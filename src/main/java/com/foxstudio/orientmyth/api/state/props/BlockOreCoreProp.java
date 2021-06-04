package com.foxstudio.orientmyth.api.state.props;

import com.foxstudio.orientmyth.api.block.BlockMod;
import net.minecraft.block.state.IBlockState;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyciling
 */
public class BlockOreCoreProp {
    public static Map<IBlockState, Integer> ORE_CORE_PROP;
    static {
        ORE_CORE_PROP = new HashMap<>();
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(0), 1);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(1), 2);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(2), 1);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(3), 1);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(4), 2);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(5), 2);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(6), 1);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(7), 2);
        ORE_CORE_PROP.put(BlockMod.ORE_CORE.getStateFromMeta(8), 1);
    }
}
