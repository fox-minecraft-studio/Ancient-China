package com.fox.ancientchina.core.util.handler;

import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.core.loader.BlockLoader;
import com.fox.ancientchina.core.loader.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.fox.ancientchina.core.AncientChinaCore.MODID;

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
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemLoader.ITEMS) {
            if (item instanceof IModelRegister) {
                System.out.println(item.getUnlocalizedName());
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
