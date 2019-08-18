package com.fox.ancientchina.cof.proxy;

import com.fox.ancientchina.core.AncientChinaCore;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ajacker
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Loader.isModLoaded(AncientChinaCore.MODID);
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerModel(Item item, int meta, String variantln) {

    }
}
