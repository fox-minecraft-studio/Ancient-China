package com.foxstudio.orientmyth.lib.base;

import com.foxstudio.orientmyth.util.StringUntil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

/**
 * @author cyciling
 */
public class ItemMetaBase extends ItemBase {

    private int meta;

    public ItemMetaBase(int damage, int size, int meta, boolean subtype, CreativeTabs tab, String name) {
        super(damage, size, subtype, tab, name);
        this.setTranslationKey(StringUntil.toLowerCamelCase(name));
        this.meta = meta;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> stacks)
    {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < meta; i++) {
                stacks.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        return super.getTranslationKey(stack) + stack.getItemDamage();
    }
}
