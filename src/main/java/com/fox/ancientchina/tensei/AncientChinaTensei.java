package com.fox.ancientchina.tensei;


import com.fox.ancientchina.tensei.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AncientChinaTensei.MODID, name = AncientChinaTensei.NAME, version =AncientChinaTensei.VERSION,
        dependencies = "required-after:ancientchinacore@[0.0.1,);")

public class AncientChinaTensei
{
    public static final String MODID = "ancientchinatensei";
    public static final String NAME = "Ancient China Tensei";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "com.fox.ancientchina.tensei.proxy.ClientProxy",
            serverSide = "com.fox.ancientchina.tensei.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

}

