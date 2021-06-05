package com.foxstudio.orientmyth.api.state.enums.block;

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
    SALTPETER,
    BILE_ALUM;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}