package com.fox.ancientchina.cof.loader;

import com.fox.ancientchina.core.util.lib.TabCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.fox.ancientchina.cof.AncientChinaCOF.MODID;

/**
 * @author ajacker
 */
public class CreativeTabsLoader {

    public static final CreativeTabs TAB_AC_COF_ITEM = (new TabCore(MODID + "." + "tab_item") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemLoader.NYA_APPLE);
        }
    });
    public static final CreativeTabs TAB_AC_COF_BLOCK = (new TabCore(MODID + "." + "tab_block") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(BlockLoader.NYA_ORE);
        }
    });
}
