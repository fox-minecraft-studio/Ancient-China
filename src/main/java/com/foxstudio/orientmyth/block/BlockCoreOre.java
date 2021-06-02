package com.foxstudio.orientmyth.block;

import com.foxstudio.orientmyth.api.state.OrientmythStateProps;
import com.foxstudio.orientmyth.api.state.enums.BlockOreCoreVariant;
import com.foxstudio.orientmyth.api.block.BlockModName;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.lib.base.BlockMetaBase;
import com.foxstudio.orientmyth.util.BlockMeta;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

/**
 * @author cyciling
 */
public class BlockCoreOre extends BlockMetaBase implements BlockMeta {

    public BlockCoreOre() {
        this(BlockModName.ORE_CORE);
    }

    public BlockCoreOre(String name) {
        super(Material.ROCK, name, BaseOrientmythTab.CORE);
        this.setDefaultState(blockState.getBaseState()
                .withProperty(OrientmythStateProps.ORE_CORE_VARIANT, BlockOreCoreVariant.COPPER));
    }
    @Nonnull
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, OrientmythStateProps.ORE_CORE_VARIANT);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(OrientmythStateProps.ORE_CORE_VARIANT).ordinal();
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta >= OrientmythStateProps.ORE_CORE_META) {
            meta = 0;
        }
        return getDefaultState().withProperty(OrientmythStateProps.ORE_CORE_VARIANT, BlockOreCoreVariant.values()[meta]);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        for(int i = 0; i < OrientmythStateProps.ORE_CORE_META; i++) {
            stacks.add(new ItemStack(this, 1, i));
        }
    }
}
