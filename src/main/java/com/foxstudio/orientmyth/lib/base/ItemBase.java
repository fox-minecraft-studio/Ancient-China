package com.foxstudio.orientmyth.lib.base;

import com.foxstudio.orientmyth.Orientmyth;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
    public ItemBase(int damage, int size) {
        this.setMaxDamage(damage);
        this.setHasSubtypes(false);
        this.setMaxStackSize(size);
        if (damage == 0){
            this.setNoRepair();
        }
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
