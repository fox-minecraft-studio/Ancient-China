package com.fox.ancientchina.cof.util.lib;

import com.fox.ancientchina.cof.AncientChinaCOF;
import com.fox.ancientchina.cof.loader.CreativeTabsLoader;
import com.fox.ancientchina.cof.loader.ItemLoader;
import com.fox.ancientchina.core.util.IModelRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

import static com.fox.ancientchina.cof.AncientChinaCOF.MODID;

/**
 * @author ajacker
 */
public class ItemBase extends Item implements IModelRegister {

    public ItemBase(String name) {
        setUnlocalizedName(MODID + "." + name);
        setRegistryName(name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabsLoader.TAB_AC_COF_ITEM);
        ItemLoader.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        AncientChinaCOF.proxy.registerModel(this, 0, "inventory");
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && Keyboard.isKeyDown(Keyboard.KEY_M))
        {
            list.add(TextFormatting.AQUA + I18n.format("gui.inventory.itemtips"+ "." + getUnlocalizedName()));
        }

        else
        {
            list.add(TextFormatting.GRAY + I18n.format("gui.inventory.shiftfordetail"));
        }

    }

}
