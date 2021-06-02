package com.foxstudio.orientmyth.proxy;

import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author cyciling
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BaseOrientmythTab.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
