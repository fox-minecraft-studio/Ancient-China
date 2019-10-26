package com.fox.ancientchina.core.capabilities;

import net.minecraft.nbt.NBTTagCompound;

/**
 * 这个枚举定义了金木水火土五种五行值(暂时使用拼音)
 * @author yaesey
 */
public enum EnumWuXing {
    /** 金，生水克木*/
    JIN(0),
    /** 木，生火克土*/
    MU(0),
    /** 水，生木克火*/
    SHUI(0),
    /** 火，生土克金*/
    HUO(0),
    /** 土，生金克水*/
    TU(0);

    private int value;
    private EnumWuXing(int value){
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void writeNBT(NBTTagCompound nbt){
        nbt.setInteger("jin",JIN.getValue());
        nbt.setInteger("mu",MU.getValue());
        nbt.setInteger("shui",SHUI.getValue());
        nbt.setInteger("huo",HUO.getValue());
        nbt.setInteger("tu",TU.getValue());
    }

    public void readNBT(NBTTagCompound nbt){
        JIN.setValue(nbt.getInteger("jin"));
        MU.setValue(nbt.getInteger("mu"));
        SHUI.setValue(nbt.getInteger("shui"));
        HUO.setValue(nbt.getInteger("huo"));
        TU.setValue(nbt.getInteger("tu"));
    }
}
