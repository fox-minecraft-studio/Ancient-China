package com.foxstudio.orientmyth;

import com.foxstudio.orientmyth.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@Mod(modid = Orientmyth.MOD_ID, name = Orientmyth.NAME, version = Orientmyth.VERSION, dependencies = Orientmyth.DEPENDENCIES)
public class Orientmyth {
    public static final String MOD_ID = "orientmyth";
    public static final String NAME = "Orientmyth";
    public static final String VERSION = "1.0.0";
    public static final String DEPENDENCIES = "required-after:bookshelf";

    public static Logger logger;
    public static SimpleNetworkWrapper networkWrapper;

    @Mod.Instance(MOD_ID)
    public static Orientmyth INSTANCE;

    @SidedProxy(clientSide = "com.foxstudio.orientmyth.proxy",
            serverSide = "com.foxstudio.orientmyth.proxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        logger = event.getModLog();
        /*注册一个属于Mod的网络通信频道，日后所有通信全在这个之下*/
        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public Logger getLogger(){
        return logger;
    }
}
