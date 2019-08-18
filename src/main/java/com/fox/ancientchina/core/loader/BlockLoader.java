package com.fox.ancientchina.core.loader;

import com.fox.ancientchina.core.block.BlockOre;
import com.fox.ancientchina.core.block.NyaOre;
import com.fox.ancientchina.core.util.lib.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajacker
 */
public class BlockLoader {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block NYA_ORE = new NyaOre("nya_ore", Material.GOURD);

    public static final Block COPPER_ORE = new BlockOre("copper_ore",Material.ROCK);
    public static final Block LEAD_ORE = new BlockOre("lead_ore",Material.ROCK);
    public static final Block ZINC_ORE = new BlockOre("zinc_ore",Material.ROCK);
    public static final Block TIN_ORE = new BlockOre("tin_ore",Material.ROCK);
}
