package com.fox.ancientchina.core.util.handler;

import com.fox.ancientchina.core.loader.BlockLoader;
import com.fox.ancientchina.core.wolrd.OreGenHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * @author yaesey
 */
public class WorldGenOreHandler {
    /**
     * 注册生成矿物
     */
    private static final WorldGenerator copperGen = new WorldGenMinable(BlockLoader.COPPER_ORE.getDefaultState(),30);

    /**
     * 在这里注册
     */
    @SubscribeEvent
    public static void onGenOre(OreGenEvent.GenerateMinable event){


        if (event.getType() == OreGenEvent.GenerateMinable.EventType.COAL){
            if (!TerrainGen.generateOre(event.getWorld(),event.getRand(),event.getGenerator(),event.getPos(),OreGenEvent.GenerateMinable.EventType.CUSTOM)){
                return;
            }
            for (int i = 0;i < 4;++i){
                int posX = event.getPos().getX() + event.getRand().nextInt(16);
                int posY = event.getRand().nextInt(128);
                int posZ = event.getPos().getZ() + event.getRand().nextInt(16);
                BlockPos orePos = new BlockPos(posX,posY,posZ);
                copperGen.generate(event.getWorld(), event.getRand(), orePos);
            }
        }


    }


}
