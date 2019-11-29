package com.fox.ancientchina.core.capabilities.base;


import net.minecraft.entity.player.EntityPlayerMP;

/**
 * 这个参考了BL的代码
 * BL的能力系统采用观察者模式，用多个观察者来表示玩家，这样即可支持多人游戏
 */
public class EntityCapabilityTracker {
    private final EntityCapability<?, ?, ?> capability;
    private final EntityPlayerMP watcher;
    //部署观察者
    private boolean trackerReady = false;
    /**设置更新观察者时间，每次更新检查是否有玩家加入或退出游戏*/
    private int lastUpdate = 0;
    private boolean dirty = false;

    public EntityCapabilityTracker(EntityCapability<?, ?, ?> capability,EntityPlayerMP watcher){
        this.capability = capability;
        this.watcher = watcher;
    }

    public void add(){
        this.capability.addTracker(this);
    }

    public void remove(){
        this.capability.removeTracker(this);
    }

    /**
     * 对脏数据的处理标记
     *
     * 脏数据就是指玩家们在游戏中，
     * 因为一些高ping战士等原因数据来不及被修改，就被调用，
     * 此时数据我们称为“脏数据”
     */
    public void makeDirty(){
        this.dirty = true;
    }

    public EntityPlayerMP getWatcher() {
        return this.watcher;
    }

    public EntityCapability<?, ?, ?> getCapability() {
        return capability;
    }

    public void update(){
        if (this.lastUpdate < this.capability.getTrackingTime()){
            this.lastUpdate++;
        }else {
            this.trackerReady = true;
        }

        if (this.trackerReady && this.dirty){
            this.lastUpdate = 0;
            this.trackerReady = false;
            this.capability.sendPacket(this.watcher);
            this.dirty = false;
        }
    }
}
