package com.fox.ancientchina.tensei.Loader;

import com.fox.ancientchina.tensei.icon.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockLoader
{
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block ICON_BLOCK = new IconBlock("icon_block", Material.AIR);
}
