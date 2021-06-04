package com.foxstudio.orientmyth.proxy;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.util.handler.WorldGenHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author cyciling
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BaseOrientmythTab.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
        /*new WorldGenHandler();*/
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
