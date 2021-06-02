package com.foxstudio.orientmyth.api.state;

import com.foxstudio.orientmyth.api.state.enums.BlockOreVariant;
import net.minecraft.block.properties.PropertyEnum;

/**
 * @author cyciling
 */
public class OrientmythStateProps {
    public static final PropertyEnum<BlockOreVariant>
            ORE_VARIANT = PropertyEnum.create("variant", BlockOreVariant.class);
    public static final int
            ORE_META = BlockOreVariant.values().length;
}
