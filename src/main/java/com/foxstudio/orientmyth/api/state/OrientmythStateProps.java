package com.foxstudio.orientmyth.api.state;

import com.foxstudio.orientmyth.api.state.enums.block.BlockOreCoreVariant;
import com.foxstudio.orientmyth.api.state.enums.block.BlockOrePlantSoulVariant;
import net.minecraft.block.properties.PropertyEnum;

/**
 * @author cyciling
 */
public class OrientmythStateProps {
    //TODO

    public static final int
            ORE_CORE_META = BlockOreCoreVariant.values().length,
            ORE_PS_META = BlockOrePlantSoulVariant.values().length;
    public static final PropertyEnum<BlockOreCoreVariant>
            ORE_CORE_VARIANT = PropertyEnum.create("variant", BlockOreCoreVariant.class);
    public static final PropertyEnum<BlockOrePlantSoulVariant>
            ORE_PS_VARIANT = PropertyEnum.create("variant", BlockOrePlantSoulVariant.class);
}
