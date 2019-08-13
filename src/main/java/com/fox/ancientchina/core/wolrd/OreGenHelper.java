package com.fox.ancientchina.core.wolrd;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class OreGenHelper {
    /**
     * Ancient China Core自带的自定义生成，这个可以避免多次重写 generate 方法和众多的类似于 OreGen 的类
     * @param startGenYaw 矿物生成的高度，
     * @param domain 矿物生成的区域，为 [startGenYaw,domain + startGenYaw)
     * @param genTimes 生成的次数
     */
    public void generateBySelf(WorldGenerator generator, World worldIn, Random rand, BlockPos position, int startGenYaw, int domain, int genTimes){
        if (!TerrainGen.generateOre(worldIn,rand,generator,position, OreGenEvent.GenerateMinable.EventType.CUSTOM)){
            return;
        }
        for (int i = 0;i < genTimes;++i){
            int posX = position.getX() + rand.nextInt(16);
            int posY = startGenYaw + rand.nextInt(domain);
            int posZ = position.getZ() + rand.nextInt(16);
            BlockPos orePos = new BlockPos(posX,posY,posZ);
            generator.generate(worldIn, rand, orePos);
            return;
        }
    }
}
