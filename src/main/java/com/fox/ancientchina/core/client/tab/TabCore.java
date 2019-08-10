package com.fox.ancientchina.core.client.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabCore extends CreativeTabs {

    private ItemStack iconItemStack;

    public TabCore(String name) {
        super(name);
        this.iconItemStack = ItemStack.EMPTY;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
        if (this.iconItemStack.isEmpty()) {
            this.iconItemStack = this.getTabIconItem();
        }

        return this.iconItemStack;
    }
}
