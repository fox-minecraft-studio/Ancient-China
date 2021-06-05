package com.foxstudio.orientmyth.lib.base;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.util.StringUntil;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author cyciling
 */
public class ItemBase extends Item {
    public ItemBase(int damage, int size, boolean subtype, CreativeTabs tab, String name) {
        this.setMaxDamage(damage);
        this.setHasSubtypes(subtype);
        this.setMaxStackSize(size);
        this.setRegistryName(Orientmyth.MOD_ID, name);
        if (!subtype) {
            this.setTranslationKey(Orientmyth.MOD_ID + "." + StringUntil.toLowerCamelCase(name));
        }
        if (tab != null) {
            this.setCreativeTab(registerInCreative(tab));
        }
        if (damage == 0){
            this.setNoRepair();
        }
    }

    public CreativeTabs registerInCreative(CreativeTabs tab) {
        return tab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(I18n.format(Orientmyth.MOD_ID + stack.getTranslationKey() + ".info"));
        } else {
            tooltip.add(I18n.format(Orientmyth.MOD_ID + ".inventory.info"));
        }
    }
}
