package com.fox.ancientchina.cia;

import com.fox.ancientchina.cia.lib.ModInfo;
import com.fox.ancientchina.cia.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * @author yaesey
 */
@Mod(modid = ModInfo.MODID,name = ModInfo.NAME,version = ModInfo.VENSION)
public class AncientchinaCIA {
    @Instance(ModInfo.MODID)
    public static AncientchinaCIA INSTANCE;

    @SidedProxy(clientSide = ModInfo.CLIENT_SIDE,serverSide = ModInfo.SERVER_SIDE)
    public static CommonProxy proxy;

    private Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        logger = event.getModLog();
    }

    @EventHandler
    public void Init(FMLInitializationEvent event){
        proxy.Init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }

    public Logger getLogger() {
        return logger;
    }
}
