package com.foxstudio.orientmyth.api.state.enums.item;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

/**
 * @author cyciling
 */

public enum ItemMaterialCore implements IStringSerializable {
    INGOT_COPPER,
    INGOT_LEAD,
    INGOT_ZINC,
    INGOT_TIN,
    NUGGET_COPPER,
    NUGGET_LEAD,
    NUGGET_ZINC,
    NUGGET_TIN,
    INGOT_SILVER,
    RAW_CINNABAR,
    RAW_SULPHUR,
    RAW_JADE,
    RAW_SALTPETER,
    DUST_CINNABAR,
    DUST_SULPHUR,
    DUST_JADE,
    DUST_SALTPETER;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}