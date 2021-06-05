package com.foxstudio.orientmyth.lib;

import com.foxstudio.orientmyth.Orientmyth;
import com.foxstudio.orientmyth.api.block.BlockMod;
import com.foxstudio.orientmyth.util.config.ConfigMod;
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
public abstract class BaseOrientmythTab extends CreativeTabs {
    public static CreativeTabs CORE;
    public static CreativeTabs PLANT_SOUL;

    public static void preInit(FMLPreInitializationEvent event){
        CORE = (new BaseOrientmythTab(Orientmyth.MOD_ID + ".core") {
            @Override
            @Nonnull
            @SideOnly(Side.CLIENT)
            public ItemStack createIcon() {
                return new ItemStack(BlockMod.ORE_CORE, 1, 0);
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }
        }).setBackgroundImageName("item_search.png");
        if(ConfigMod.herbalEnable){
            PLANT_SOUL = (new BaseOrientmythTab(Orientmyth.MOD_ID + ".herbal") {
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
    }

    public BaseOrientmythTab(String label) {
        super(label);
    }
}
