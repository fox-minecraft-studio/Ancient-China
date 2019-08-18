package com.fox.ancientchina.core.util.lib;

import com.fox.ancientchina.core.AncientChinaCore;
import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.core.loader.CreativeTabsLoader;
import com.fox.ancientchina.core.loader.ItemLoader;
import net.minecraft.item.Item;

/**
 * @author ajacker
 */
public class ItemBase extends Item implements IModelRegister {

    public ItemBase(String modid,String name) {
        setUnlocalizedName(modid + "." + name);
        setRegistryName(name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabsLoader.TAB_AC_CORE_ITEM);
        ItemLoader.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        AncientChinaCore.proxy.registerModel(this, 0, "inventory");
    }
}
