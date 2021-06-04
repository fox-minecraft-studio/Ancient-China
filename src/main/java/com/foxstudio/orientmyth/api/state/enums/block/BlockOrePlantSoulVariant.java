package com.foxstudio.orientmyth.api.state.enums.block;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

/**
 * @author cyciling
 */
public enum BlockOrePlantSoulVariant implements IStringSerializable {
    AMBER,
    TALC,
    ALUM,
    CALCITE,
    REALGAR;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
