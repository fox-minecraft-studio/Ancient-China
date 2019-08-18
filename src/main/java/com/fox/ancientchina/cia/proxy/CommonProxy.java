package com.fox.ancientchina.cia.proxy;

import com.fox.ancientchina.core.AncientChinaCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author yaesey
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event){
        Loader.isModLoaded(AncientChinaCore.MODID);
    }

    public void Init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
