package com.fox.ancientchina.core.util.lib;

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
public class ItemMod extends Item {

    public ItemMod(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabsLoader.TAB_AC_CORE_ITEM);
        ItemLoader.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this,
                0, new ModelResourceLocation(Objects.requireNonNull(this.getRegistryName()), "inventory"));
    }
}
