package com.fox.ancientchina.core.event;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;
import com.fox.ancientchina.core.api.capability.IQiAndStrength;
import com.fox.ancientchina.core.api.capability.IWuXing;
import com.fox.ancientchina.core.capabilities.CapabilityQiAndHealth;
import com.fox.ancientchina.core.capabilities.CapabilityQiAndStrength;
import com.fox.ancientchina.core.capabilities.CapabilityWuXing;
import com.fox.ancientchina.core.loader.CapabilitiesLoader;
import net.minecraft.nbt.NBTBase;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 这个类主要是用于注册有关玩家的事件的。
 * 目前有以下事件被注册在本类中：
 *
 * · 当玩家去末地等等情况时，更新玩家的气血值等等
 * · 气血值的增长检测
 * · 气力值的增长检测
 * · 五行值的增长检测
 *
 * @author yaesey
 */
public class AncientChinaPlayerEvent {
    /**
     * 玩家在去世或者从一个维度来到另一个维度时，
     * 在原版中是先复制一个玩家，再把玩家数据转移到这个复制品上面
     * 本方法监听Clone事件，并将本Mod的数据值复制到玩家上面
     * @param event
     */
    @SubscribeEvent
    public void onPlayClone(PlayerEvent.Clone event){
        Capability<IQiAndStrength> strength = CapabilitiesLoader.CAPABILITY_QI_AND_STRENGTH;
        Capability<IQiAndHealth> health = CapabilitiesLoader.CAPABILITY_QI_AND_HEALTH;
        Capability<IWuXing> wuXing = CapabilitiesLoader.CAPABILITY_WUXING;
        IStorage<IQiAndStrength> strengthStorage = strength.getStorage();
        IStorage<IQiAndHealth> healthStorage = health.getStorage();
        IStorage<IWuXing> wuXingStorage = wuXing.getStorage();

        cloneHelper(event,strength,strengthStorage);
        cloneHelper(event,health,healthStorage);
        cloneHelper(event,wuXing,wuXingStorage);
    }

    /**
     * todo:这个方法正在考虑是否加入API中
     */
    private void cloneHelper(PlayerEvent.Clone event, Capability capability,IStorage storage){
        if (event.getOriginal().hasCapability(capability,null) && event.getEntityPlayer().hasCapability(capability,null)){
            NBTBase nbtBase = storage.writeNBT(capability,event.getOriginal().getCapability(capability,null),null);
            storage.readNBT(capability,event.getOriginal().getCapability(capability,null),null,nbtBase);
        }
    }

    @SubscribeEvent
    public void qiAndHealthUpdate(){
        CapabilityQiAndHealth.INSTANCE.update();
    }

    @SubscribeEvent
    public void qiAndStrengthUpdate(){
        CapabilityQiAndStrength.INSTANCE.update();
    }

    @SubscribeEvent
    public void wuXingUpdate(){
        CapabilityWuXing.INSTANCE.update();
    }
}
