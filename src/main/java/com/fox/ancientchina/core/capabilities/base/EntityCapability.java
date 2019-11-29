package com.fox.ancientchina.core.capabilities.base;

import com.fox.ancientchina.core.AncientChinaCore;
import com.fox.ancientchina.core.api.capability.ISerializableData;

import java.util.ArrayList;
import java.util.List;

import com.fox.ancientchina.core.network.clientmessage.MessageEntityCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 这个参考了BL的代码
 * 这个类负责将Entity的capabilities内部实现和包装，
 * TileEntity都有自己的实现了，为什么Entity不能有（滑稽）？
 * @param <F> 默认实现
 * @param <C> capability接口
 * @param <E> 绑定实体
 */
public abstract class EntityCapability<F extends EntityCapability<F,C,E>,C,E extends Entity> extends AbstractCapability<F,C,E> {
    private E entity;
    private List<EntityCapabilityTracker> trackers = new ArrayList<>();

    void setEntity(Entity entity){
        this.entity = (E) entity;
    }

    public final E getEntity() {
        return this.entity;
    }

    protected void init(){

    }

    /**
     * 设置使用的实体范围
     * 比如可以判定entity是否属于玩家等等。
     */
    public boolean isApplicable(Entity entity) {
        return false;
    }

    @SuppressWarnings("unchecked")
    public EntityCapability<?,?,E> getEntityCapability(E entity) {
        if (entity.hasCapability(this.getCapability(),null)){
            return (EntityCapability<?,?,E>)entity.getCapability(this.getCapability(),null);
        }
        return null;
    }

    /**
     * 判断这个能力是否对玩家永久绑定，即是否有必要实现接口{@link com.fox.ancientchina.core.api.capability.ISerializableData}
     */
    public boolean isPersistent(EntityPlayer oldPlayer,EntityPlayer newPlayer,boolean wasDead){
        return !wasDead;
    }

    /**
     * 玩家在死亡重生或者从一个维度来到另一个维度时，
     * 在原版中是先复制一个玩家，再把玩家数据转移到这个复制品上面,
     * 所以需要这个方法将数据转移至玩家上面
     */
    public void cloneDataToPlayer(EntityPlayer oldPlayer, EntityPlayer newPlayer, boolean wasDead, ISerializableData capability){
        if (this instanceof ISerializableData){
            NBTTagCompound nbt = new NBTTagCompound();
            ((ISerializableData)this).writeToNBT(nbt);
            capability.readFromNBT(nbt);
        }
    }

    /**
     * 添加跟踪者，即添加对新玩家的绑定
     * @param tracker
     */
    public final void addTracker(EntityCapabilityTracker tracker){
        this.trackers.add(tracker);
    }

    /**
     * 移除对玩家的绑定
     * @param tracker
     */
    public final void removeTracker(EntityCapabilityTracker tracker){
        this.trackers.remove(tracker);
    }

    public void markDirty(){
        for (EntityCapabilityTracker tracker : this.trackers){
            tracker.makeDirty();
        }
    }

    /**
     * @return 返回跟踪间隔时长，如果返回-1，表示不跟踪
     */
    public int getTrackingTime(){
        return -1;
    }

    /**
     * 将跟踪的玩家数据写入nbt
     * @param nbt
     */
    public void writeTrackingDataToNBT(NBTTagCompound nbt) {

    }

    /**
     * 读取跟踪的数据
     * @param nbt
     */
    public void readTrackingDataFromNBT(NBTTagCompound nbt) {

    }

    /**
     * 发送所有跟踪的数据
     */
    public void sendPacket(EntityPlayerMP player){
        MessageEntityCapability message = new MessageEntityCapability(this);
        AncientChinaCore.networkWrapper.sendTo(message,player);
    }
}