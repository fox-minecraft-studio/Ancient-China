package com.fox.ancientchina.core.capabilities;

import com.fox.ancientchina.core.api.capability.IWuXing;

/**
 * 五行值，使用{@link EnumWuXing}作为枚举值
 * @author yaesey
 */
public class CapabilityWuXing implements IWuXing {
    public static final CapabilityWuXing INSTANCE = new CapabilityWuXing();

    public void update() {
        //todo:添加五行值的增减机制
    }
}
