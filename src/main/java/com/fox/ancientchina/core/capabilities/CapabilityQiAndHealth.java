package com.fox.ancientchina.core.capabilities;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;

public class CapabilityQiAndHealth implements IQiAndHealth {
    public static final CapabilityQiAndHealth INSTANCE = new CapabilityQiAndHealth();

    public int healthValue = 0;

    @Override
    public void update() {
        //todo:添加气血值的增减机制
    }

    @Override
    public void setQiAndHealth(int healthValue) {
        this.healthValue = healthValue;
    }

    @Override
    public int getQiAndHealth() {
        return this.healthValue;
    }
}
