package com.fox.ancientchina.cof;

import com.fox.ancientchina.cof.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ajacker
 */
@Mod(modid = AncientChina_COF.MODID, name = AncientChina_COF.NAME, version = AncientChina_COF.VERSION,
        dependencies = "required-after:ancientchina-core@[0.0.1,);")

public class AncientChina_COF {
    public static final String MODID = "ancientchina-cof";
    public static final String NAME = "Ancient China(Change Of Fire)";
    public static final String VERSION = "0.0.1";
    @SidedProxy(clientSide = "com.fox.ancientchina.cof.proxy.ClientProxy",
            serverSide = "com.fox.ancientchina.cof.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
