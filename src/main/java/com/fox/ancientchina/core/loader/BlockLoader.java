package com.fox.ancientchina.core.loader;

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
    public static final Block COPPER_ORE = new BlockBase("copper_ore",Material.ROCK);
}
