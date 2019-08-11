package com.fox.ancientchina.core.util.loader;

import com.fox.ancientchina.core.client.tab.TabCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ajacker
 */
public class CreativeTabsLoader {

    public static final CreativeTabs TAB_AC_CORE_ITEM = (new TabCore("tab_item") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemLoader.NYA_APPLE);
        }
    });
    public static final CreativeTabs TAB_AC_CORE_BLOCK = (new TabCore("tab_block") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(BlockLoader.NYA_ORE);
        }
    });
}
