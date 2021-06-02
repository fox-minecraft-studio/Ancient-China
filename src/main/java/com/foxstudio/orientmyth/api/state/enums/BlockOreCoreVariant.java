package com.foxstudio.orientmyth.api.state.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

/**
 * @author cyciling
 */

public enum BlockOreCoreVariant implements IStringSerializable {
    COPPER,
    LEAD,
    ZINC,
    TIN,
    SILVER,
    CINNABAR,
    SULPHUR,
    JADE,
    SALTPETER,;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
