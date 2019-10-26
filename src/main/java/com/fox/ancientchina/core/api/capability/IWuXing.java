package com.fox.ancientchina.core.api.capability;


import com.fox.ancientchina.core.capabilities.EnumWuXing;

/**
 * 五行值
 * @author yaesey
 */
public interface IWuXing {

    default void setWuXingValue(EnumWuXing wuXing,int value){
        wuXing.setValue(value);
    }

    default int getWuXingValue(EnumWuXing wuXing){
        return wuXing.getValue();
    }
}
