package com.fox.ancientchina.core.capabilities.base;

import com.fox.ancientchina.core.api.capability.ISerializableData;
import com.google.common.base.Preconditions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * 这个负责帮助注册有关实体能力的过程
 */
public class EntityCapabilitiesHelper {
    /** 这个存放在{@link com.fox.ancientchina.core.loader.CapabilitiesLoader}注册过的实体能力*/
    private static final List<EntityCapability<?, ?, ? extends Entity>> LOADER_CAPABILITIES = new ArrayList<EntityCapability<?, ?, ? extends Entity>>();
    private static final Map<ResourceLocation,EntityCapability<?, ?, ? extends Entity>> ID_MAP = new HashMap<ResourceLocation, EntityCapability<?, ?, ? extends Entity>>();
    private static final Map<EntityPlayerMP, List<EntityCapabilityTracker>> TRACKER_MAP = new HashMap<EntityPlayerMP, List<EntityCapabilityTracker>>();

    private static int updateTimer = 0;

    /**
     * <b>注意：请使用这个来注册能力！！！</b>
     */
    public static <F extends EntityCapability<F, C, E>,C ,E extends Entity> void registerEntityCapability(EntityCapability<F,C,E> capability){
        //确保这个鬼东西真的是实体能力，而不是更可怕的东西
        Preconditions.checkState(capability.getCapabilityClass().isAssignableFrom(capability.getClass()),
                "Entity capability %s must implement %s", capability.getClass().getName(), capability.getCapabilityClass().getName());
        LOADER_CAPABILITIES.add(capability);
    }

    /**
     * <b>注意：除非有特殊需求，这个方法不能被调用在其他类之中</b>
     *
     * Forge的能力注册流程：以下是AncientChina早期使用的注册：
     * CapabilityManager.INSTANCE.register(IQiAndStrength.class,new StorageQiAndStrength(), CapabilityQiAndStrength::new);
     * 分别为能力的定义接口，存储和默认实现,
     * 这个缺点是需要针对每一个能力设计一个{@link Capability.IStorage}的实例，非常低效
     *
     * 因此本方法打算一次性解决这个问题
     * @param capability 默认实现
     * @param <C> 定义接口
     * @param <E> 实体
     */
    public static <C,E extends Entity> void registerCapability(EntityCapability<?,C,E> capability){
        //register方法需要定义接口（由getCapabilityClass()给出），存储和默认实现
        CapabilityManager.INSTANCE.register(capability.getCapabilityClass(), new Capability.IStorage<C>() {
            @Override
            public NBTBase writeNBT(Capability<C> capability, C instance, EnumFacing side) {
                if (instance instanceof ISerializableData) {
                    NBTTagCompound nbt = new NBTTagCompound();
                    ((ISerializableData) instance).writeToNBT(nbt);
                    return nbt;
                }
                return new NBTTagCompound();
            }

            @Override
            public void readNBT(Capability<C> capability, C instance, EnumFacing side, NBTBase nbt) {
                if (instance instanceof ISerializableData && nbt instanceof NBTTagCompound) {
                    ((ISerializableData) instance).readFromNBT((NBTTagCompound) nbt);
                }
            }
        }, new Callable<C>() {
            @SuppressWarnings("unchecked")
            @Override
            public C call() throws Exception {
                //尝试获取默认实现
                return (C) capability.getDefaultCapability();
            }
        });
        ID_MAP.put(capability.getID(),capability);
    }

    /**
     * 在注册时调用这个，确保所有东西一次性加载
     */
    public static void registerAllCapabilities(){
        Preconditions.checkState(Loader.instance().isInState(LoaderState.PREINITIALIZATION));
        for (EntityCapability<?,?,?> capability : LOADER_CAPABILITIES){
            registerCapability(capability);
        }
    }

    /**
     * @param id 还记得我们用{@link ResourceLocation}来管理capabilities吗
     */
    public static <E extends Entity> EntityCapability<?,?,E> getCapability(ResourceLocation id, E entity){
        EntityCapability<?,?,?> capability = ID_MAP.get(id);
        if (capability != null && entity.hasCapability(capability.getCapability(),null)){
            return (EntityCapability<?,?,E>) entity.getCapability(capability.getCapability(),null);
        }
        return null;
    }

    //================以下为超级长的玩家事件，放心直到末尾都是==================
    /**
     * 给玩家绑定能力的事件
     */
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event){
        Entity entity = event.getObject();
        for (EntityCapability<?,?,?> entityCapability : LOADER_CAPABILITIES){
            if (entityCapability.isApplicable(entity)){
                final Capability<?> instance = entityCapability.getCapability();
                event.addCapability(entityCapability.getID(), new ICapabilitySerializable<NBTTagCompound>() {
                    private Object entityCapability = this.getNewInstance();

                    private EntityCapability<?,?,?> getNewInstance(){
                        EntityCapability<?,?,?> entityCapability = (EntityCapability<?,?,?>)instance.getDefaultInstance();
                        entityCapability.setEntity(entity);
                        entityCapability.init();
                        return entityCapability;
                    }

                    @Override
                    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
                        return capability == instance;
                    }

                    @SuppressWarnings("unchecked")
                    @Override
                    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
                        return capability == instance ? (T) this.entityCapability : null;
                    }

                    @Override
                    public NBTTagCompound serializeNBT() {
                        return serialize(instance,this.entityCapability);
                    }

                    @SuppressWarnings("unchecked")
                    private <T> NBTTagCompound serialize(Capability<T> capability, Object instance) {
                        return (NBTTagCompound) capability.getStorage().writeNBT(capability, (T)instance, null);
                    }

                    @Override
                    public void deserializeNBT(NBTTagCompound nbt) {
                        this.deserialize(instance,this.entityCapability,null);
                    }

                    @SuppressWarnings("unchecked")
                    private <T> void deserialize(Capability<T> capability, Object instance, NBTTagCompound nbt) {
                        capability.getStorage().readNBT(capability, (T)instance, null, nbt);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event){
        EntityPlayer oldPlayer = event.getOriginal();
        EntityPlayer newPlayer = event.getEntityPlayer();
        List<EntityCapability<?, ?, EntityPlayer>> capabilities = getEntityCapabilities(oldPlayer);

        for (EntityCapability<?, ?, EntityPlayer> capability : capabilities){
            if (capability.isPersistent(oldPlayer,newPlayer,event.isWasDeath()) && capability instanceof ISerializableData){
                EntityCapability<?, ?, EntityPlayer> newCapability = capability.getEntityCapability(newPlayer);

                if (newCapability instanceof ISerializableData){
                    capability.cloneDataToPlayer(oldPlayer,newPlayer,event.isWasDeath(),(ISerializableData)newCapability);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event){
        if (!event.getWorld().isRemote && event.getEntity() instanceof EntityPlayerMP){
            EntityPlayerMP player = (EntityPlayerMP) event.getEntity();
            addTrackers(player,player);
        }
    }

    @SubscribeEvent
    public static void onPlayerChangeDimension(PlayerChangedDimensionEvent event){
        if (!event.player.getEntityWorld().isRemote && event.player instanceof EntityPlayerMP){
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            List<EntityCapabilityTracker> trackers = TRACKER_MAP.get(player);
            if (trackers != null){
                for (EntityCapabilityTracker tracker : trackers){
                    tracker.getCapability().sendPacket(tracker.getWatcher());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityStartTracking(PlayerEvent.StartTracking event) {
        if(event.getEntityPlayer() instanceof EntityPlayerMP) {
            addTrackers((EntityPlayerMP)event.getEntityPlayer(), event.getTarget());
        }
    }

    @SubscribeEvent
    public static void onEntityStopTracking(PlayerEvent.StopTracking event) {
        if(event.getEntityPlayer() instanceof EntityPlayerMP) {
            removeTrackers((EntityPlayerMP)event.getEntityPlayer(), event.getTarget());
        }
    }

    @SubscribeEvent
    public static void onPlayerUpdate(TickEvent.PlayerTickEvent event){
        if (!event.player.getEntityWorld().isRemote && event.side == Side.CLIENT){
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            List<EntityCapabilityTracker> trackers = TRACKER_MAP.get(player);
            if(trackers != null) {
                Iterator<EntityCapabilityTracker> trackerIT = trackers.iterator();
                while(trackerIT.hasNext()) {
                    EntityCapabilityTracker tracker = trackerIT.next();
                    //删除原版追踪器
                    if(tracker.getCapability().getEntity() != player) {
                        Set<? extends EntityPlayer> vanillaTrackingPlayers = player.getServerWorld().getEntityTracker().getTrackingPlayers(tracker.getCapability().getEntity());

                        if(vanillaTrackingPlayers == null || vanillaTrackingPlayers.isEmpty() || !vanillaTrackingPlayers.contains(player)) {
                            trackerIT.remove();
                            tracker.remove();
                        }
                    }
                    tracker.update();
                }
            }
        }
    }

    @SubscribeEvent
    public static void onServerTickEvent(TickEvent.ServerTickEvent event){
        //什么，服务器结束了吗
        if (event.phase == TickEvent.Phase.END){
            updateTimer++;
            if (updateTimer > 20){
                updateTimer = 0;
                Iterator<Map.Entry<EntityPlayerMP, List<EntityCapabilityTracker>>> it = TRACKER_MAP.entrySet().iterator();
                while(it.hasNext()) {
                    Map.Entry<EntityPlayerMP, List<EntityCapabilityTracker>> entry = it.next();
                    EntityPlayerMP player = entry.getKey();

                    System.out.println("请看" + entry.getValue().size() + " " + player.getServerWorld().loadedEntityList.size());

                    if(player.getServerWorld().getMinecraftServer() != null && !player.getServerWorld().getMinecraftServer().getPlayerList().getPlayers().contains(player)) {
                        it.remove();
                        for(EntityCapabilityTracker tracker : entry.getValue()) {
                            tracker.remove();
                        }
                    }
                }
            }
        }
    }

    //下面是一些工具方法

    @SuppressWarnings("unchecked")
    private static <E extends Entity> List<EntityCapability<?, ?, E>> getEntityCapabilities(E entity){
        List<EntityCapability<?, ?, E>> capabilities = new ArrayList<EntityCapability<?, ?, E>>();

        for (EntityCapability<?, ?, ?> capability : LOADER_CAPABILITIES){
            if (entity.hasCapability(capability.getCapability(),null)){
                capabilities.add((EntityCapability<?, ?, E>)entity.getCapability(capability.getCapability(),null));
            }
        }
        return capabilities;
    }

    private static void addTrackers(EntityPlayerMP watcher, Entity target){
        List<EntityCapability<?,?,Entity>> entityCapabilities = getEntityCapabilities(target);
        for (EntityCapability<?,?,Entity> capability : entityCapabilities){
            if (capability.getTrackingTime() >= 0){
                List<EntityCapabilityTracker> trackers = TRACKER_MAP.get(watcher);
                if (trackers == null){
                    TRACKER_MAP.put(watcher,trackers = new ArrayList<EntityCapabilityTracker>());
                }
                EntityCapabilityTracker tracker = new EntityCapabilityTracker(capability,watcher);
                trackers.add(tracker);
                tracker.add();

                capability.sendPacket(watcher);
            }
        }
    }

    private static void removeTrackers(EntityPlayerMP watcher, Entity target){
        List<EntityCapabilityTracker> trackers = TRACKER_MAP.get(watcher);
        if (trackers != null){
            List<EntityCapability<?,?,Entity>> entityCapabilities = getEntityCapabilities(target);
            for (EntityCapability<?,?,Entity> capability : entityCapabilities){
                if (capability.getTrackingTime() >= 0){
                    Iterator<EntityCapabilityTracker> iterable = trackers.iterator();
                    while (iterable.hasNext()){
                        EntityCapabilityTracker tracker = iterable.next();
                        if (tracker.getCapability() == capability){
                            iterable.remove();
                            tracker.remove();
                        }
                    }
                }
            }

            if (trackers.isEmpty()){
                TRACKER_MAP.remove(watcher);
            }
        }
    }
}
