package com.fox.ancientchina.core.loader;

import com.fox.ancientchina.core.block.BlockOre;
import com.fox.ancientchina.core.block.NyaOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

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
    public static final Block SILVER_ORE = new BlockOre("silver_ore",Material.ROCK);

    //朱砂，掉落朱砂粉
    public static final Block CINNBAR = new BlockOre("cinnbar",Material.ROCK){
        @Override
        public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
            ItemStack itemStack = new ItemStack(ItemLoader.CINNBAR_POWDER);
            drops.add(itemStack);
        }
    };
    //硫磺，掉落硫磺粉
    public static final Block SULPHUR = new BlockOre("sulphur",Material.ROCK){
        @Override
        public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
            ItemStack itemStack = new ItemStack(ItemLoader.SULPHUR_POWDER);
            drops.add(itemStack);
        }
    };
    //玉石，掉落圆石
    public static final Block JADE = new BlockOre("jade",Material.ROCK){
        @Override
        public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
            drops.add(new ItemStack(Blocks.COBBLESTONE));
        }
    };
}
