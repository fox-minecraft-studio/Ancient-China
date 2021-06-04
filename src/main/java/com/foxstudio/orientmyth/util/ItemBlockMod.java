package com.foxstudio.orientmyth.util;

import com.foxstudio.orientmyth.Orientmyth;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * @author cyciling
 */
public class ItemBlockMod extends ItemBlock {

    public ItemBlockMod(Block block) {
        super(block);
    }

    @Nonnull
    @Override
    public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
        return getUnlocalizedNameInefficiently_(par1ItemStack).replaceAll("tile.", "tile." + Orientmyth.MOD_ID + ".");
    }

    public String getUnlocalizedNameInefficiently_(ItemStack stack) {
        return super.getUnlocalizedNameInefficiently(stack);
    }
}
