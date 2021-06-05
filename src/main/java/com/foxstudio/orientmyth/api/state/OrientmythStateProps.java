package com.foxstudio.orientmyth.api.state;

import com.foxstudio.orientmyth.api.state.enums.block.BlockOreCoreVariant;
import com.foxstudio.orientmyth.api.state.enums.block.BlockOreHerbalVariant;
import net.minecraft.block.properties.PropertyEnum;

/**
 * @author cyciling
 */
public class OrientmythStateProps {
    //TODO: BlockStateSet

    public static final int
            ORE_CORE_META = BlockOreCoreVariant.values().length,
            ORE_HERBAL_META = BlockOreHerbalVariant.values().length;
    public static final PropertyEnum<BlockOreCoreVariant>
            ORE_CORE_VARIANT = PropertyEnum.create("variant", BlockOreCoreVariant.class);
    public static final PropertyEnum<BlockOreHerbalVariant>
            ORE_HERBAL_VARIANT = PropertyEnum.create("variant", BlockOreHerbalVariant.class);
}
