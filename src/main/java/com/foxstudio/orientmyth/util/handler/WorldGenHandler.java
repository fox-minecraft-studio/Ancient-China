package com.foxstudio.orientmyth.util.handler;

import com.foxstudio.orientmyth.api.block.BlockMod;
import com.foxstudio.orientmyth.api.world.gen.WorldGenMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * @author cyciling
 */
public class WorldGenHandler implements IWorldGenerator {
    // TODO: 2021/6/4 WorldGen
    public WorldGenHandler() {
        WorldGenMod.COPPER = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(0),
                8);
        WorldGenMod.LEAD = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(1),
                6);
        WorldGenMod.ZINC = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(2),
                6);
        WorldGenMod.TIN = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(3),
                6);
        WorldGenMod.SILVER = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(4),
                4);
        WorldGenMod.CINNABAR = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(5),
                5);
        WorldGenMod.SULPHUR = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(6),
                10);
        WorldGenMod.JADE = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(7),
                4, BlockMatcher.forBlock(Blocks.GRAVEL));
        WorldGenMod.SALTPETER = new WorldGenMinable(
                BlockMod.ORE_CORE.getStateFromMeta(8),
                16);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            worldGen(WorldGenMod.COPPER, world, random, chunkX, chunkZ, 16, 0, 100);
            worldGen(WorldGenMod.LEAD, world, random, chunkX, chunkZ, 14, 0, 50);
            worldGen(WorldGenMod.ZINC, world, random, chunkX, chunkZ, 12, 0, 100);
            worldGen(WorldGenMod.TIN, world, random, chunkX, chunkZ, 14, 0, 100);
            worldGen(WorldGenMod.SILVER, world, random, chunkX, chunkZ, 12, 0, 50);
            worldGenSulphur(WorldGenMod.SULPHUR, world, random, chunkX, chunkZ, 18, 0, 100);
            worldGenJade(WorldGenMod.JADE, world, random, chunkX, chunkZ, 10, 50, 200);
            worldGen(WorldGenMod.SALTPETER, world, random, chunkX, chunkZ, 18, 0, 100);

        }
        if (world.provider.getDimension() == -1) {
            worldGen(WorldGenMod.CINNABAR, world, random, chunkX, chunkZ, 12, 100, 256);
        }
    }

    private static void worldGen(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minY, int maxY) {
        for (int i = 0; i < chance; i++) {
            int posX = chunkX * 16 + rand.nextInt(16);
            int posY = minY + rand.nextInt(worldGenRegister(minY, maxY));
            int posZ = chunkZ * 16 + rand.nextInt(16);
            BlockPos blockPos = new BlockPos(posX, posY, posZ);
            gen.generate(world, rand, blockPos);
        }
    }

    /*
    * 特殊情况，特殊处理
    * */

    private static void worldGenJade(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minY, int maxY) {
        for (int i = 0; i < chance; i++) {
            int posX = chunkX * 16 + rand.nextInt(16);
            int posY = minY + rand.nextInt(worldGenRegister(minY, maxY));
            int posZ = chunkZ * 16 + rand.nextInt(16);
            BlockPos blockPos = new BlockPos(posX, posY, posZ);
            if(world.getBiome(blockPos) == Biomes.EXTREME_HILLS || world.getBiome(blockPos) == Biomes.EXTREME_HILLS_EDGE || world.getBiome(blockPos) == Biomes.EXTREME_HILLS){
                gen.generate(world, rand, blockPos);
            }
        }
    }

    private static void worldGenSulphur(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minY, int maxY) {
        for (int i = 0; i < chance; i++) {
            int posX = chunkX * 16 + rand.nextInt(16);
            int posY = minY + rand.nextInt(worldGenRegister(minY, maxY));
            int posZ = chunkZ * 16 + rand.nextInt(16);
            BlockPos blockPos = new BlockPos(posX, posY, posZ);
            Block blockD = world.getBlockState(blockPos.down()).getBlock();
            Block blockE = world.getBlockState(blockPos.east()).getBlock();
            Block blockW = world.getBlockState(blockPos.west()).getBlock();
            Block blockS = world.getBlockState(blockPos.south()).getBlock();
            Block blockN = world.getBlockState(blockPos.north()).getBlock();
            if(blockD == Blocks.LAVA || blockE == Blocks.LAVA || blockW == Blocks.LAVA || blockS == Blocks.LAVA || blockN == Blocks.LAVA){
                gen.generate(world, rand, blockPos);
            }
        }
    }

    private static int worldGenRegister(int minY, int maxY) {
        String error = "Ore generated out of bounds";
        int genMaxY = 256;
        int genMinY = 0;
        if (minY > maxY || minY < genMinY || maxY > genMaxY) {
            throw new IllegalArgumentException(error);
        }
        return maxY - minY;
    }
}
     /*private static final int MAX_Y = 256;
    public static Map<IBlockState, Map<String, Integer>> WORLD_GEN_REGISTER = new HashMap<>();

    public WorldGenHandler() {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public static void onWorldOreGen(OreGenEvent.Pre event) {
        for (Map.Entry<IBlockState, Map<String, Integer>> registerEntry : WORLD_GEN_REGISTER.entrySet()) {
            Map<String, Integer> paraMap = registerEntry.getValue();
            for (String registerPara : registerEntry.getValue().keySet()) {
                IBlockState block = registerEntry.getKey();
                int minY = paraMap.get("minY");
                int maxY = paraMap.get("maxY");
                int count = paraMap.get("count");
                int chances = paraMap.get("chances");
                worldGenRegister(block, event.getWorld(), event.getRand(), event.getPos(), minY, maxY, count, chances);
            }
        }
        worldGenRegister(BlockMod.ORE_CORE.getStateFromMeta(0), event.getWorld(), event.getRand(), event.getPos(), 0, 256, 32, 8);
    }

    public static void worldGenRegister(
            IBlockState state,
            World world,
            Random random,
            BlockPos pos,
            int minY, int maxY, int oreCount,int chances){
        if (maxY > MAX_Y) {
            maxY = MAX_Y;
        } else if (minY < 0) {
            minY = 0;
        }
        int domain = maxY - minY;
        for (int i = 0; i < chances; i++) {
            int posX = pos.getX() + random.nextInt(16);
            int posY = minY + random.nextInt(domain);
            int posZ = pos.getZ() + random.nextInt(16);
            BlockPos orePos = new BlockPos(posX, posY, posZ);
            WorldGenerator generator = new WorldGenMinable(state,oreCount);
            generator.generate(world, random, orePos);
        }
    }*/
