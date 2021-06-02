package com.foxstudio.orientmyth.util.handler;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.api.block.BlockMod;
import com.foxstudio.orientmyth.api.state.OrientmythStateProps;
import com.foxstudio.orientmyth.util.register.BlockRegister;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IRegistryDelegate;

import java.util.Map;

/**
 * @author cyciling
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Orientmyth.MOD_ID)
public class IModelRegister {

    private static final Map<IRegistryDelegate<Block>, IStateMapper> STATE_MAPPER =
            ReflectionHelper.getPrivateValue(ModelLoader.class, null, "customStateMappers");
    private static final DefaultStateMapper F_B_MAPPER = new DefaultStateMapper();

    private static ModelResourceLocation getMrlForState(IBlockState state) {
        return STATE_MAPPER
                .getOrDefault(state.getBlock().delegate, F_B_MAPPER)
                .putStateModelLocations(state.getBlock())
                .get(state);
    }

    @SubscribeEvent
    public static void onBlockItemModelRegister(ModelRegistryEvent event) {
        for (Block block: BlockRegister.BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block),
                    0,
                    getMrlForState(block.getStateFromMeta(0)));
        }

    }

    @SubscribeEvent
    public static void onMetaBlockItemModelRegister(ModelRegistryEvent event) {
        for (int meta = 0; meta < OrientmythStateProps.ORE_META; meta++) { ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockMod.ORE), meta, getMrlForState(BlockMod.ORE.getStateFromMeta(meta))); }
    }
}
