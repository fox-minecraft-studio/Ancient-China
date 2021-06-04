package com.foxstudio.orientmyth.api.state.enums.item;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

/**
 * @author cyciling
 */

public enum ItemMaterialCore implements IStringSerializable {
    INGOT_COPPER,
    INGOT_TIN,
    ORE_COPPER,
    ;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
