package com.fox.ancientchina.plantssoul.item;

import com.fox.ancientchina.plantssoul.AncientChinaPlantsSoul;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class AcorusTatarinowiiRoot extends Item {
    private static final String name = "Acorus Tatarinowii Root";
    public AcorusTatarinowiiRoot(String acorus_tatarinowii_root){
        this.setRegistryName(name);
        this.setUnlocalizedName(AncientChinaPlantsSoul.MODID+":"+name);
        this.setCreativeTab(CreativeTabs.MISC);
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            tooltip.add(I18n.format(this.getUnlocalizedName()+".shift.1."+"desc"));
        }
        if(flagIn.isAdvanced()){
         tooltip.add("this is ");
        }
        else{
         tooltip.add(I18n.format(this.getUnlocalizedName()+".1."+"desc"));
        }
    }
}
