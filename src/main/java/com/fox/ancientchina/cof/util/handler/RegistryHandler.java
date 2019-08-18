package com.fox.ancientchina.cof.util.handler;

import com.fox.ancientchina.cof.loader.BlockLoader;
import com.fox.ancientchina.cof.loader.EntityLoader;
import com.fox.ancientchina.cof.loader.ItemLoader;
import com.fox.ancientchina.core.util.IModelRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

import static com.fox.ancientchina.cof.AncientChinaCOF.MODID;


/**
 * @author ajacker
 */
@Mod.EventBusSubscriber(modid = MODID)
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemLoader.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockLoader.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onEntityRegister(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(EntityLoader.DEADLY_COIN);
    }
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemLoader.ITEMS) {
            if (item instanceof IModelRegister) {
                ((IModelRegister) item).registerModels();
            }
        }

        for (Block block : BlockLoader.BLOCKS) {
            if (block instanceof IModelRegister) {
                ((IModelRegister) block).registerModels();
            }
        }

    }
}
