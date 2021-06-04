package com.foxstudio.orientmyth.item;

import com.foxstudio.orientmyth.api.item.ItemModName;
import com.foxstudio.orientmyth.api.state.enums.item.ItemMaterialCore;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.lib.base.ItemMetaBase;

/**
 * @author cyciling
 */
public class ItemMaterial extends ItemMetaBase {
    public ItemMaterial() {
        super(0, 64, ItemMaterialCore.values().length, true, BaseOrientmythTab.CORE, ItemModName.MATERIAL_CORE);
    }
}
