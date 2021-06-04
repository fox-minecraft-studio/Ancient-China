package com.foxstudio.orientmyth.block;

import com.foxstudio.orientmyth.api.block.BlockModName;
import com.foxstudio.orientmyth.api.state.OrientmythStateProps;
import com.foxstudio.orientmyth.api.state.enums.block.BlockOrePlantSoulVariant;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.lib.base.BlockMetaBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

import javax.annotation.Nonnull;

/**
 * @author cyciling
 */
public class BlockPlantSoulOre extends BlockMetaBase {

    public BlockPlantSoulOre() {
        this(BlockModName.ORE_PS);
    }

    public BlockPlantSoulOre(String name) {
        super(Material.ROCK, name, BaseOrientmythTab.PLANT_SOUL, OrientmythStateProps.ORE_PS_META);
        this.setDefaultState(blockState.getBaseState()
                .withProperty(OrientmythStateProps.ORE_PS_VARIANT, BlockOrePlantSoulVariant.AMBER));
    }

    @Nonnull
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, OrientmythStateProps.ORE_PS_VARIANT);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(OrientmythStateProps.ORE_PS_VARIANT).ordinal();
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta >= OrientmythStateProps.ORE_PS_META) {
            meta = 0;
        }
        return getDefaultState().withProperty(OrientmythStateProps.ORE_PS_VARIANT, BlockOrePlantSoulVariant.values()[meta]);
    }
}
