package com.fox.ancientchina.core.loader;

import com.fox.ancientchina.core.item.ItemIngot;
import com.fox.ancientchina.core.item.NyaApple;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class ItemLoader {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item NYA_APPLE = new NyaApple("nya_apple");

    public static final Item COPPER_INGOT = new ItemIngot("copper_ingot");
    public static final Item LEAD_INGOT = new ItemIngot("lead_ingot");
    public static final Item ZINC_INGOT = new ItemIngot("zinc_ingot");
    public static final Item TIN_INGOT = new ItemIngot("tin_ingot");

    public void dictionaryRegister(){
        OreDictionary.registerOre("ingotCopper",COPPER_INGOT);
        OreDictionary.registerOre("ingotLead",LEAD_INGOT);
        OreDictionary.registerOre("ingotZinc",ZINC_INGOT);
        OreDictionary.registerOre("ingotTin",TIN_INGOT);

        OreDictionary.registerOre("oreCopper",BlockLoader.COPPER_ORE);
        OreDictionary.registerOre("oreLead",BlockLoader.LEAD_ORE);
        OreDictionary.registerOre("oreZinc",BlockLoader.ZINC_ORE);
        OreDictionary.registerOre("oreTin",BlockLoader.TIN_ORE);
    }
}
