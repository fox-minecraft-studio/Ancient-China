package com.foxstudio.orientmyth.lib.base;

import com.foxstudio.orientmyth.api.state.OrientmythStateProps;
import net.minecraft.block.material.Material;
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
public class BlockMetaBase extends BlockBase {

    private final int meta;

    public BlockMetaBase(Material materialIn, String name, CreativeTabs tab, int meta) {
        super(materialIn, name, tab);
        this.meta = meta;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Nonnull
    @Override
    public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult target, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        for(int i = 0; i < meta; i++) {
            stacks.add(new ItemStack(this, 1, i));
        }
    }
}
