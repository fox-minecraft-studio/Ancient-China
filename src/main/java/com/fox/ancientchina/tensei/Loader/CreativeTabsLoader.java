package com.fox.ancientchina.tensei.Loader;

import com.fox.ancientchina.tensei.tab.CreativeTabsTensei;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.fox.ancientchina.tensei.AncientChinaTensei.MODID;

public class CreativeTabsLoader
{
    public static final CreativeTabs TAB_AC_TENSEI_BLOCK = (new CreativeTabsTensei(MODID + "tab_item")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return null;
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }

    });

    public static final CreativeTabs TAB_AC_TENSEI_ITEM = (new CreativeTabsTensei(MODID + "tab_block")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return null;
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }

    });

}
