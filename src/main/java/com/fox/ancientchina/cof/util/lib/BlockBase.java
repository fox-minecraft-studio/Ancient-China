package com.fox.ancientchina.cof.util.lib;

import com.fox.ancientchina.cof.AncientChinaCOF;
import com.fox.ancientchina.cof.loader.BlockLoader;
import com.fox.ancientchina.cof.loader.CreativeTabsLoader;
import com.fox.ancientchina.cof.loader.ItemLoader;
import com.fox.ancientchina.core.util.IModelRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import static com.fox.ancientchina.cof.AncientChinaCOF.MODID;

/**
 * @author ajacker
 */
public class BlockBase extends Block implements IModelRegister {
    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsLoader.TAB_AC_COF_BLOCK);

        BlockLoader.BLOCKS.add(this);
        ItemLoader.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels() {
        AncientChinaCOF.proxy.registerModel(Item.getItemFromBlock(this), 0, "inventory");
    }
}
