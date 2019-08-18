package com.fox.ancientchina.core.wolrd;

import com.fox.ancientchina.core.loader.BlockLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * 在默认的generate方法中，用Ancient China Core自定义的genOreHelper方法注册你想要的方块
 *
 * @author yaesey
 */
public class OreGen implements IWorldGenerator {
    public OreGen(){
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    /**
     * @param random         随机值
     * @param chunkX         矿物生成区块X坐标
     * @param chunkZ         矿物生成区块Z坐标
     * @param world          矿物生成世界
     * @param chunkGenerator 这两个我目前还不知道。。。
     * @param chunkProvider
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        //主世界生成的矿物
        if (world.provider.getDimensionType() == DimensionType.OVERWORLD){
            //注意，在参数oreCount的设置上，我使用random来设定随机生成数量
            //现在矿物数量为9-13个
            //(或许是对非洲人的挑战？)
            genOreHelper(BlockLoader.COPPER_ORE.getDefaultState(),world,random,chunkX,chunkZ,0,128,9 + random.nextInt(4),4);
        }
    }

    /**
     * 这个方法是为特殊的生成需求而设定的，
     * 在分支mod中，要求自己实现这个方法
     */
    @SubscribeEvent
    public void onOreGen(OreGenEvent.GenerateMinable event){
        //fixme:It is a test,We should delete these codes when we build and release the mod
        //fixme:这是一个测试，当我们构建并发布mod时，我们应该删除这些代码
        genOreHelper(BlockLoader.NYA_ORE.getDefaultState(),event.getWorld(),event.getRand(),
                event.getPos().getX(),event.getPos().getZ(),0,256,23,4);
    }

    /**
     * @param ore      你要生成的方块种类
     * @param world    世界
     * @param random   随机值
     * @param x        矿物生成X坐标
     * @param z        矿物生成Z坐标
     * @param minY     矿物生成高度下限
     * @param maxY     矿物生成高度上限
     * @param oreCount 矿物生成数量
     * @param chances  矿物生成次数
     */
    public void genOreHelper(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int oreCount, int chances){
        if (maxY > 256){
            maxY = 256;
        }else if (minY < 0){
            minY = 0;
        }

        int domain = maxY - minY;

        for (int i = 0;i < chances;i++){
            //注意，这里的16是防止重复加载区块而设定的值
            //
            //fixme:2019.8.15：我们在测试的时候，仍然发现 Forge 的“世界生成延迟”这一警告，虽然可以取消这个警告
            // 我认为这是一个值得注意的事情，但我对优化代码很不在行，所以请诸位帮我优化这个代码
            // 另：当解决这个问题时，请删除这一注释 by yaesey
            int posX = x + random.nextInt(16);
            int posY = minY + random.nextInt(domain);
            int posZ = z + random.nextInt(16);
            BlockPos orePos = new BlockPos(posX,posY,posZ);

            WorldGenerator worldGenerator = new WorldGenMinable(ore,oreCount);
            worldGenerator.generate(world,random,orePos);
        }
    }
}
