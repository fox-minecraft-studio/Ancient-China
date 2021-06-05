package com.foxstudio.orientmyth.util.register;

import com.foxstudio.orientmyth.api.block.BlockMod;
import com.foxstudio.orientmyth.block.BlockCoreOre;
import com.foxstudio.orientmyth.block.BlockPlantSoulOre;
import com.foxstudio.orientmyth.util.config.ConfigMod;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;


/**
 * @author cyciling
 */
public class BlockRegister {
    // TODO: 2021/6/4 BlockRegister

    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(BlockMod.ORE_CORE = new BlockCoreOre());
    }

    static {
        if (ConfigMod.plantSoulEnable) {
            BLOCKS.add(BlockMod.ORE_PS = new BlockPlantSoulOre());
        }
    }
}
