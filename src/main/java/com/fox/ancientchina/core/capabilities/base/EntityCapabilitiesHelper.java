package com.fox.ancientchina.core.capabilities.base;

import com.fox.ancientchina.core.api.capability.ISerializableData;
import com.google.common.base.Preconditions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 这个负责帮助注册有关实体能力的过程
 */
public class EntityCapabilitiesHelper {
    /** 这个存放在{@link com.fox.ancientchina.core.loader.CapabilitiesLoader}注册过的实体能力*/
    private static final List<EntityCapability<?, ?, ? extends Entity>> LOADER_CAPABILITIES = new ArrayList<EntityCapability<?, ?, ? extends Entity>>();
    private static final Map<ResourceLocation,EntityCapability<?, ?, ? extends Entity>> ID_MAP = new HashMap<ResourceLocation, EntityCapability<?, ?, ? extends Entity>>();

    public static <F extends EntityCapability<F, C, E>,C ,E extends Entity> void registerEntityCapability(EntityCapability<F,C,E> capability){
        //确保这个鬼东西真的是实体能力，而不是更可怕的东西
        Preconditions.checkState(capability.getCapabilityClass().isAssignableFrom(capability.getClass()),
                "Entity capability %s must implement %s", capability.getClass().getName(), capability.getCapabilityClass().getName());
        LOADER_CAPABILITIES.add(capability);
    }

    /**
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
        CapabilityManager.INSTANCE.register(capability.getCapabilityClass(), new Capability.IStorage<C>() {
            @Nullable
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
                return (C) capability.getDefaultCapability();
            }
        });
        ID_MAP.put(capability.getID(),capability);
    }

    public static void registerAllCapabilities(){
        Preconditions.checkState(Loader.instance().isInState(LoaderState.PREINITIALIZATION));
        for (EntityCapability<?,?,?> capability : LOADER_CAPABILITIES){
            registerCapability(capability);
        }
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

    @SuppressWarnings("unchecked")
    private static <E extends Entity> List<EntityCapability<?, ?, E>> getEntityCapabilities(E entity){
        List<EntityCapability<?, ?, E>> capabilities = new ArrayList<EntityCapability<?, ?, E>>();

        for (EntityCapability<?, ?, ?> capability : LOADER_CAPABILITIES){
            capabilities.add((EntityCapability<?, ?, E>)entity.getCapability(capability.getCapability(),null));
        }
        return capabilities;
    }
}
