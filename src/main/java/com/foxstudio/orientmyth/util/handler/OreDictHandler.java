package com.foxstudio.orientmyth.util.handler;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.api.block.BlockMod;
import com.foxstudio.orientmyth.api.state.enums.block.BlockOreCoreVariant;
import com.foxstudio.orientmyth.api.state.enums.block.BlockOreHerbalVariant;
import com.foxstudio.orientmyth.util.StringUntil;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author cyciling
 */
@Mod.EventBusSubscriber(modid = Orientmyth.MOD_ID)
public class OreDictHandler {
    @SubscribeEvent
    public static void blockOreDictRegister(OreDictionary.OreRegisterEvent event) {
        /*add ore to the ore dict*/
        for (BlockOreCoreVariant oreVariant : BlockOreCoreVariant.values()){
            OreDictionary.registerOre(
                    StringUntil.toLowerCamelCase("ore_" + oreVariant.toString()),
                    new ItemStack(BlockMod.ORE_CORE, 1, oreVariant.ordinal()));
        }
        for (BlockOreHerbalVariant oreVariant : BlockOreHerbalVariant.values()){
            OreDictionary.registerOre(
                    StringUntil.toLowerCamelCase("ore_" + oreVariant.toString()),
                    new ItemStack(BlockMod.ORE_HERBAL, 1, oreVariant.ordinal()));
        }
    }
}
