package com.foxstudio.orientmyth.util;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * @author cyciling
 */
public class ItemBlockWithMeta extends ItemBlockMod {

    public ItemBlockWithMeta(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        return super.getTranslationKey(stack) + stack.getItemDamage();
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

}