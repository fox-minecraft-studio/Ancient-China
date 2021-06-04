package com.foxstudio.orientmyth.util.handler;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.util.ItemBlockWithMeta;
import com.foxstudio.orientmyth.util.register.BlockRegister;
import com.foxstudio.orientmyth.util.register.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author cyciling
 */
@Mod.EventBusSubscriber(modid = Orientmyth.MOD_ID)
public class RegisterHandler {
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> registry = e.getRegistry();
        for (Block block : BlockRegister.BLOCKS) {
            registry.register(block);
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> registry = e.getRegistry();
        for (Block blockItem : BlockRegister.BLOCKS) {
            registry.register(new ItemBlockWithMeta(blockItem).setRegistryName(blockItem.getRegistryName()));
        }
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> registry = e.getRegistry();
        for (Item item : ItemRegister.ITEMS) {
            registry.register(item);
        }
    }
}
