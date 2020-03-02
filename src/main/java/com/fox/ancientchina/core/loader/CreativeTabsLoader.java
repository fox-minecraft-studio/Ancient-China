package com.fox.ancientchina.core.loader;

import com.fox.ancientchina.core.util.lib.TabCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.fox.ancientchina.core.AncientChinaCore.MODID;

/**
 * @author ajacker
 */
public class CreativeTabsLoader {

    public static final CreativeTabs TAB_AC_CORE_ITEM = (new TabCore(MODID + "." + "tab_item") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemLoader.NYA_APPLE);
        }
    });
    public static final CreativeTabs TAB_AC_CORE_BLOCK = (new TabCore(MODID + "." + "tab_block") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(BlockLoader.NYA_ORE);
        }
    });
    public static CreativeTabs tabFMLTutor;
}
