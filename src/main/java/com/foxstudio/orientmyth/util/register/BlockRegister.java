package com.foxstudio.orientmyth.util.register;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.api.block.BlockMod;
import com.foxstudio.orientmyth.block.BlockCoreOre;
import com.foxstudio.orientmyth.block.BlockPlantSoulOre;
import com.foxstudio.orientmyth.util.ItemBlockWithMeta;
import com.foxstudio.orientmyth.util.config.ConfigMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;


/**
 * @author cyciling
 */
@Mod.EventBusSubscriber(modid = Orientmyth.MOD_ID)
public class BlockRegister {
    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(BlockMod.ORE_CORE = new BlockCoreOre());
    }

    static {
        if (ConfigMod.plantSoulEnable) {
            BLOCKS.add(BlockMod.ORE_PS = new BlockPlantSoulOre());
        }
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> registry = e.getRegistry();
        for (Block block : BLOCKS) {
            registry.register(block);
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> registry = e.getRegistry();
        for (Block blockItem : BLOCKS) {
            registry.register(new ItemBlockWithMeta(blockItem).setRegistryName(blockItem.getRegistryName()));
        }
    }
}
