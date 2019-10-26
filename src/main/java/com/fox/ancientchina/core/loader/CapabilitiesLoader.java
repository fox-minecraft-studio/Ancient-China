package com.fox.ancientchina.core.loader;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;
import com.fox.ancientchina.core.api.capability.IQiAndStrength;
import com.fox.ancientchina.core.api.capability.IWuXing;
import com.fox.ancientchina.core.capabilities.*;
import com.fox.ancientchina.core.capabilities.base.EntityCapabilitiesHelper;
import com.fox.ancientchina.core.capabilities.qi.CapabilityQiAndHealth;
import com.fox.ancientchina.core.capabilities.qi.CapabilityQiAndStrength;
import com.fox.ancientchina.core.capabilities.qi.StorageQiAndHealth;
import com.fox.ancientchina.core.capabilities.qi.StorageQiAndStrength;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 * 这个负责加载玩家能力
 * @author yaesey
 */
public class CapabilitiesLoader {
    @CapabilityInject(IQiAndStrength.class)
    public static final Capability<IQiAndStrength> CAPABILITY_QI_AND_STRENGTH = null;

    @CapabilityInject(IQiAndHealth.class)
    public static final Capability<IQiAndHealth> CAPABILITY_QI_AND_HEALTH = null;

    @CapabilityInject(IWuXing.class)
    public static final Capability<IWuXing> CAPABILITY_WUXING = null;

    public static void preInit(){

        CapabilityManager.INSTANCE.register(IQiAndHealth.class,new StorageQiAndHealth(), CapabilityQiAndHealth::new);
        CapabilityManager.INSTANCE.register(IWuXing.class,new StorageWuXing(),CapabilityWuXing::new);
    }
}
