package com.fox.ancientchina.tensei.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class CreativeTabsTensei extends CreativeTabs
{
    private ItemStack iconItemStack;

    public CreativeTabsTensei(String label)
    {
        super(label);
        this.iconItemStack = ItemStack.EMPTY;
    }

    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack()
    {
        if (this.iconItemStack.isEmpty())
        {
            this.iconItemStack = this.getTabIconItem();
        }

        return this.iconItemStack;
    }

}
