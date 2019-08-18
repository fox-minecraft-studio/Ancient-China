package com.fox.ancientchina.core.block;

import com.fox.ancientchina.core.AncientChinaCore;
import com.fox.ancientchina.core.util.lib.BlockBase;
import net.minecraft.block.material.Material;

/**
 * 我们日后还需进行子方块注册。。。
 * @author yaesey
 */
public class BlockOre extends BlockBase {
    public BlockOre(float hardNess,int level,String name,Material material){
        super(AncientChinaCore.MODID,name,material);
        this.setHardness(hardNess);
        this.setHarvestLevel("pickaxe",1);
    }
    public BlockOre(String name, Material material){
        this(3.0F,1,name,material);
    }
}
