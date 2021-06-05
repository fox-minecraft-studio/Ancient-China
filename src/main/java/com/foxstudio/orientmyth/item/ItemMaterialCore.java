package com.foxstudio.orientmyth.item;

import com.foxstudio.orientmyth.api.item.ItemModName;
import com.foxstudio.orientmyth.api.state.enums.item.ItemMaterialCoreEnum;
import com.foxstudio.orientmyth.lib.BaseOrientmythTab;
import com.foxstudio.orientmyth.lib.base.ItemMetaBase;

/**
 * @author cyciling
 */
public class ItemMaterialCore extends ItemMetaBase {
    public ItemMaterialCore() {
        super(0, 64, ItemMaterialCoreEnum.values().length, true, BaseOrientmythTab.CORE, ItemModName.MATERIAL_CORE);
    }
}
