package com.fox.ancientchina.core.event;

import com.fox.ancientchina.core.loader.BlockLoader;
import com.fox.ancientchina.core.loader.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltHander {
    public static void init(){
        GameRegistry.addSmelting(BlockLoader.COPPER_ORE,new ItemStack(ItemLoader.COPPER_INGOT),1.0F);
        GameRegistry.addSmelting(BlockLoader.LEAD_ORE,new ItemStack(ItemLoader.LEAD_INGOT),1.0F);
        GameRegistry.addSmelting(BlockLoader.ZINC_ORE,new ItemStack(ItemLoader.ZINC_INGOT),1.0F);
        GameRegistry.addSmelting(BlockLoader.TIN_ORE,new ItemStack(ItemLoader.TIN_INGOT),1.0F);
    }
}
