package com.fox.ancientchina.core.util.lib;

import com.fox.ancientchina.core.AncientChinaCore;
import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.core.loader.BlockLoader;
import com.fox.ancientchina.core.loader.CreativeTabsLoader;
import com.fox.ancientchina.core.loader.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

import static com.fox.ancientchina.core.AncientChinaCore.MODID;

/**
 * @author ajacker
 */
public class BlockBase extends Block implements IModelRegister {
    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsLoader.TAB_AC_CORE_BLOCK);

        BlockLoader.BLOCKS.add(this);
        ItemLoader.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels() {
        AncientChinaCore.proxy.registerModel(Item.getItemFromBlock(this), 0, "inventory");
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
