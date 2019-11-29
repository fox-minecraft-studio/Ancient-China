package com.fox.ancientchina.core;

import com.fox.ancientchina.core.capabilities.base.EntityCapabilitiesHelper;
import com.fox.ancientchina.core.event.SmeltHander;
import com.fox.ancientchina.core.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

/**
 * @author ajacker
 */
@Mod(modid = AncientChinaCore.MODID, name = AncientChinaCore.NAME, version = AncientChinaCore.VERSION)
public class AncientChinaCore
{
    public static final String MODID = "ancientchinacore";
    public static final String NAME = "Ancient China(Core)";
    public static final String VERSION = "0.0.1";

    public static SimpleNetworkWrapper networkWrapper;

    @Instance(MODID)
    public static AncientChinaCore INSTANCE;

    @SidedProxy(clientSide = "com.fox.ancientchina.core.proxy.ClientProxy",
            serverSide = "com.fox.ancientchina.core.proxy.CommonProxy")
    public static CommonProxy proxy;

    private Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        logger = event.getModLog();
        //注册一个属于Mod的网络通信频道，日后所有通信全在这个之下
        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

        MinecraftForge.EVENT_BUS.register(EntityCapabilitiesHelper.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        SmeltHander.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public Logger getLogger(){
        return logger;
    }
}
