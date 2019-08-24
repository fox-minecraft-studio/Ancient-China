package com.fox.ancientchina.tensei.util.lib;

import com.fox.ancientchina.core.util.IModelRegister;
import com.fox.ancientchina.tensei.AncientChinaTensei;
import com.fox.ancientchina.tensei.Loader.BlockLoader;
import com.fox.ancientchina.tensei.Loader.CreativeTabsLoader;
import com.fox.ancientchina.tensei.Loader.ItemLoader;
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

import static com.fox.ancientchina.tensei.AncientChinaTensei.MODID;

public class BlockTensei extends Block implements IModelRegister
{
    public BlockTensei(String name, Material material)
    {
        super(material);
        this.setUnlocalizedName(MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabsLoader.TAB_AC_TENSEI_BLOCK);

        BlockLoader.BLOCKS.add(this);
        ItemLoader.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        AncientChinaTensei.proxy.registerItemRender(Item.getItemFromBlock(this), 0, "inventory");
    }

    /**
     * 继承该类的方块都会被强制添加注释
     */
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
