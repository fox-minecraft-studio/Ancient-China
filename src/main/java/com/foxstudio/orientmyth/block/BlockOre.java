package com.foxstudio.orientmyth.block;

import com.foxstudio.orientmyth.api.state.OrientmythStateProps;
import com.foxstudio.orientmyth.api.state.enums.BlockOreVariant;
import com.foxstudio.orientmyth.api.block.BlockModName;
import com.foxstudio.orientmyth.lib.base.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * @author cyciling
 */
public class BlockOre extends BlockBase {

    public BlockOre() {
        this(BlockModName.ORE);
    }

    public BlockOre(String name) {
        super(Material.ROCK, name);
        this.setDefaultState(blockState.getBaseState()
                .withProperty(OrientmythStateProps.ORE_VARIANT, BlockOreVariant.COPPER));
    }
    @Nonnull
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, OrientmythStateProps.ORE_VARIANT);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(OrientmythStateProps.ORE_VARIANT).ordinal();
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta >= BlockOreVariant.values().length) {
            meta = 0;
        }
        return getDefaultState().withProperty(OrientmythStateProps.ORE_VARIANT, BlockOreVariant.values()[meta]);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        for(int i = 0; i < BlockOreVariant.values().length; i++)
            stacks.add(new ItemStack(this, 1, i));
    }

    @Nonnull
    @Override
    public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult target, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }

}
