package com.foxstudio.orientmyth.block;

import com.foxstudio.orientmyth.api.state.OrientmythStateProps;
import com.foxstudio.orientmyth.api.state.enums.block.BlockOreCoreVariant;
import com.foxstudio.orientmyth.api.block.BlockModName;
import com.foxstudio.orientmyth.api.state.props.BlockOreCoreProp;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.lib.base.BlockMetaBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @author cyciling
 */
public class BlockCoreOre extends BlockMetaBase {

    public BlockCoreOre() {
        this(BlockModName.ORE_CORE);
    }

    public BlockCoreOre(String name) {
        super(Material.ROCK, name, BaseOrientmythTab.CORE, OrientmythStateProps.ORE_CORE_META);
        this.setDefaultState(blockState.getBaseState()
                .withProperty(OrientmythStateProps.ORE_CORE_VARIANT, BlockOreCoreVariant.COPPER));
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        for (Map.Entry<IBlockState, Integer> prop : BlockOreCoreProp.ORE_CORE_PROP.entrySet()){
            this.setHarvestLevel("pickaxe", prop.getValue(), prop.getKey());
        }
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
}
