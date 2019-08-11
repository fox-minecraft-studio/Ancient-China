package com.fox.ancientchina.core.util.lib;

import com.fox.ancientchina.core.AncientChina;
import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.core.util.loader.CreativeTabsLoader;
import com.fox.ancientchina.core.util.loader.ItemLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

import static com.fox.ancientchina.core.AncientChina.MODID;

/**
 * @author ajacker
 */
public class ItemBase extends Item implements IModelRegister {

    public ItemBase(String name) {
        setUnlocalizedName(MODID + "." + name);
        setRegistryName(name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabsLoader.TAB_AC_CORE_ITEM);
        ItemLoader.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        AncientChina.proxy.registerModel(this,0,"inventory");
    }
}
