package com.fox.ancientchina.core.util.lib;

import com.fox.ancientchina.core.AncientChina_Core;
import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.core.loader.CreativeTabsLoader;
import com.fox.ancientchina.core.loader.ItemLoader;
import net.minecraft.item.Item;

import static com.fox.ancientchina.core.AncientChina_Core.MODID;

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
        AncientChina_Core.proxy.registerModel(this, 0, "inventory");
    }
}
