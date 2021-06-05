package com.foxstudio.orientmyth.api.state.enums.block;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

/**
 * @author cyciling
 */
public enum BlockOreHerbalVariant implements IStringSerializable {
    AMBER,
    TALC,
    ALUM,
    CALCITE,
    REALGAR,
    BILE_ALUM;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
