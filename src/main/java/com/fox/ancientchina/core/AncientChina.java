package com.fox.ancientchina.core;

import com.fox.ancientchina.core.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ajacker
 */
@Mod(modid = AncientChina.MODID, name = AncientChina.NAME, version = AncientChina.VERSION)
public class AncientChina {
    public static final String MODID = "ancientchina";
    public static final String NAME = "Ancient China(Core)";
    public static final String VERSION = "0.0.1";
    @SidedProxy(clientSide = "com.fox.ancientchina.core.client.ClientProxy",
            serverSide = "com.fox.ancientchina.core.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
