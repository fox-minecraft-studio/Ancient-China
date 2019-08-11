package com.fox.ancientchina.core.util.lib;

import com.fox.ancientchina.core.AncientChina;
import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.core.util.loader.BlockLoader;
import com.fox.ancientchina.core.util.loader.CreativeTabsLoader;
import com.fox.ancientchina.core.util.loader.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

import static com.fox.ancientchina.core.AncientChina.MODID;

/**
 * @author ajacker
 */
public class BlockBase extends Block implements IModelRegister {
    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsLoader.TAB_AC_CORE_BLOCK);

        BlockLoader.BLOCKS.add(this);
        ItemLoader.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels() {
        AncientChina.proxy.registerModel(Item.getItemFromBlock(this),0,"inventory");
    }
}
