package com.fox.ancientchina.core.proxy;

import com.fox.ancientchina.core.loader.CapabilitiesLoader;
import com.fox.ancientchina.core.world.gen.OreGen;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ajacker
 */
public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent event)
    {
        CapabilitiesLoader.preInit();
    }

    public void init(FMLInitializationEvent event)
    {
        new OreGen();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public void registerModel(Item item,int meta,String variantln)
    {

    }
}
