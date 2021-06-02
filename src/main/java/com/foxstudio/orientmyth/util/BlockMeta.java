package com.foxstudio.orientmyth.util;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * @author cyciling
 */
public interface BlockMeta {
    /**
     *  To prevent forgetting to override methods when using block meta, extract the methods to the interface
     */
    BlockStateContainer createBlockState();

    int getMetaFromState(IBlockState state);

    IBlockState getStateFromMeta(int meta);

    void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> stacks);

}
