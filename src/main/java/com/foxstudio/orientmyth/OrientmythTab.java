package com.foxstudio.orientmyth;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * @author cyciling
 */
public abstract class OrientmythTab extends CreativeTabs {
    public static CreativeTabs INSTANT;

    public static void preInit(FMLPreInitializationEvent event){
        INSTANT = (new OrientmythTab(Orientmyth.MOD_ID) {
            @Override
            @Nonnull
            @SideOnly(Side.CLIENT)
            public ItemStack createIcon() {
                return new ItemStack(Items.AIR);
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        }).setBackgroundImageName("item_search.png");
    }

    public OrientmythTab(String label) {
        super(label);
    }
}
