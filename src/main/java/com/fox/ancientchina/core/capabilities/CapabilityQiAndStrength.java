package com.fox.ancientchina.core.capabilities;

import com.fox.ancientchina.core.api.capability.IQiAndStrength;

/**
 * 气力值
 * 这个值负责玩家的武技等提供基础
 * @author yaesey
 */
public class CapabilityQiAndStrength implements IQiAndStrength{
    public static final CapabilityQiAndStrength INSTANCE = new CapabilityQiAndStrength();

    public int strengthValue;

    @Override
    public void update() {
        //todo:添加有关气力值增减机制
    }
    @Override
    public void setQiAndStrength(int strengthValue) {
        this.strengthValue = strengthValue;
    }

    @Override
    public int getQiAndStrength() {
        return this.strengthValue;
    }
}
