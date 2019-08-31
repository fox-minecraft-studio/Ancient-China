package com.fox.ancientchina.core.world.gen;

import com.fox.ancientchina.core.loader.BlockLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * 在默认的generate方法中，用Ancient China Core自定义的genOreHelper方法注册你想要的方块
 * 注：必须通过世界生成事件来生成矿物，不允许使用GameRegistry的注册
 * @author yaesey
 */
public class OreGen {
    public OreGen(){
        MinecraftForge.ORE_GEN_BUS.register(this);
    }
    /**
     * 所有的矿物生成必须放在这里
     * 在分支mod中，要求自己实现这个方法
     */
    @SubscribeEvent
    public void onOreGen(OreGenEvent.GenerateMinable event){
        //fixme:It is a test,We should delete these codes when we build and release the mod
        //fixme:这是一个测试，当我们构建并发布mod时，我们应该删除这些代码
        if (event.getType() == OreGenEvent.GenerateMinable.EventType.ANDESITE) {
            genOreHelper(BlockLoader.NYA_ORE.getDefaultState(),event.getWorld(),event.getRand(),event.getPos(),0,128,16,4);
        }
        if (event.getType() == OreGenEvent.GenerateMinable.EventType.GRANITE){
            genOreHelper(BlockLoader.COPPER_ORE.getDefaultState(),event.getWorld(),event.getRand(),event.getPos(),0,128,16,4);
        }
    }

    /**
     * @param state     你要生成的方块种类
     * @param world     世界
     * @param random    随机值
     * @param pos       当前矿物生成的区块坐标
     * @param minY      矿物生成高度下限
     * @param maxY      矿物生成高度上限
     * @param chances   矿物生成次数
     */
    public void genOreHelper(IBlockState state, World world, Random random, BlockPos pos, int minY, int maxY, int oreCount,int chances){
        if (maxY > 256) {
            maxY = 256;
        } else if (minY < 0) {
            minY = 0;
        }
        int domain = maxY - minY;
        for (int i = 0; i < chances; i++) {
            //注意，这里的16是防止重复加载区块而设定的值
            //
            //fixme:2019.8.15：我们在测试的时候，仍然发现 Forge 的“世界生成延迟”这一警告，虽然可以取消这个警告
            // 我认为这是一个值得注意的事情，但我对优化代码很不在行，所以请诸位帮我优化这个代码
            // 另：当解决这个问题时，请删除这一注释 by yaesey
            int posX = pos.getX() + random.nextInt(16);
            int posY = minY + random.nextInt(domain);
            int posZ = pos.getZ() + random.nextInt(16);
            BlockPos orePos = new BlockPos(posX, posY, posZ);
            WorldGenerator generator = new WorldGenMinable(state,oreCount);
            generator.generate(world, random, orePos);
            //普通玩家看不见这个
            System.out.println("矿物坐标x:"+posX+"\ty:"+posY+"\tz:"+posZ);
        }
    }
}
