package com.fox.ancientchina.plantssoul;

import com.fox.ancientchina.plantssoul.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * @author Gu_ZT
 */


@Mod(modid = AncientChinaPlantsSoul.MODID, name = AncientChinaPlantsSoul.NAME, version = AncientChinaPlantsSoul.VERSION,
        dependencies = "required-after:ancientchinacore@[0.0.1,);")
public class AncientChinaPlantsSoul
{
    public static final String MODID = "ancientchinaplantssoul";
    public static final String NAME = "Ancient China(PlantsSoul)";
    public static final String VERSION = "0.0.1";
    public static final String CLIENT_SIDE = "com.fox.ancientchina.plantssoul.proxy.ClientProxy";
    public static final String SERVER_SIDE = "com.fox.ancientchina.plantssoul.proxy.CommonProxy";

    @Mod.Instance(AncientChinaPlantsSoul.MODID)
    public static AncientChinaPlantsSoul instance;

    @SidedProxy(clientSide = "com.fox.ancientchina.plantssoul.proxy.ClientProxy",
            serverSide = "com.fox.ancientchina.plantssoul.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
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
