package com.fox.ancientchina.cof.loader;

import com.fox.ancientchina.cof.block.NyaOre;
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
}
