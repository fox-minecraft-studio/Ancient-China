package com.fox.ancientchina.core.proxy;

import com.fox.ancientchina.core.wolrd.OreGen;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author ajacker
 */
public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent event)
    {

    }

    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new OreGen(),3);
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public void registerModel(Item item,int meta,String variantln)
    {

    }
}
