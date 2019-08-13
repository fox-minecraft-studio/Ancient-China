package com.fox.ancientchina.core;

import com.fox.ancientchina.core.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ajacker
 */
@Mod(modid = AncientChina_Core.MODID, name = AncientChina_Core.NAME, version = AncientChina_Core.VERSION)
public class AncientChina_Core {
    public static final String MODID = "ancientchina-core";
    public static final String NAME = "Ancient China(Core)";
    public static final String VERSION = "0.0.1";
<<<<<<< HEAD:src/main/java/com/fox/ancientchina/core/AncientChina.java

    @Instance(MODID)
    public static AncientChina INSTANCE;

    @SidedProxy(clientSide = "com.fox.ancientchina.core.client.ClientProxy",
            serverSide = "com.fox.ancientchina.core.common.CommonProxy")
=======
    @SidedProxy(clientSide = "com.fox.ancientchina.core.proxy.ClientProxy",
            serverSide = "com.fox.ancientchina.core.proxy.CommonProxy")
>>>>>>> 554ef93281d7ea0d9460025b37ec38c56cebab99:src/main/java/com/fox/ancientchina/core/AncientChina_Core.java
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
