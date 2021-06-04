package com.foxstudio.orientmyth.lib.base;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.util.StringUntil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author cyciling
 */
public class BlockBase extends Block  {
    public BlockBase(Material materialIn, String name, CreativeTabs tab) {
        super(materialIn);
        this.setTranslationKey(StringUntil.toLowerCamelCase(name));
        this.setRegistryName(new ResourceLocation(Orientmyth.MOD_ID, name));
        if (tab != null){
            this.setCreativeTab(this.registerInCreative(tab));
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
