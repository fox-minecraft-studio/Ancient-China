package com.fox.ancientchina.tensei.Loader;

import com.fox.ancientchina.tensei.tab.CreativeTabsTensei;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.fox.ancientchina.tensei.AncientChinaTensei.MODID;

public class CreativeTabsLoader
{
    public static final CreativeTabs TAB_AC_TENSEI_BLOCK = (new CreativeTabsTensei(MODID + "tabItem")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(BlockLoader.ICON_BLOCK);
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }

    });

    public static final CreativeTabs TAB_AC_TENSEI_ITEM = (new CreativeTabsTensei(MODID + "tabBlock")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(BlockLoader.ICON_BLOCK);
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }

    });

}
