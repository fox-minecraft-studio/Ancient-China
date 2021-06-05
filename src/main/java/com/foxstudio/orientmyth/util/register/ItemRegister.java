package com.foxstudio.orientmyth.util.register;

import com.foxstudio.orientmyth.api.item.ItemMod;
import com.foxstudio.orientmyth.item.ItemMaterialCore;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyciling
 */
public class ItemRegister {
    // TODO: 2021/6/4 ItemRegister

    public static final List<Item> ITEMS = new ArrayList<>();
    static {
        ITEMS.add(ItemMod.MATERIAL_CORE = new ItemMaterialCore());
    }
}
