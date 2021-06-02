package com.foxstudio.orientmyth.api.state.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

/**
 * @author cyciling
 */

public enum BlockOreVariant implements IStringSerializable {
    COPPER,
    LEAD,
    ZINC,
    TIN,
    SILVER,
    CINNABAR,
    SULPHUR,
    JADE;

    @Override
    public java.lang.String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
