package com.fox.ancientchina.core.api.capability;

/**
 * 气血值
 * @author yaesey
 */
public interface IQiAndHealth {
    void update();

    void setQiAndHealth(int healthValue);

    int getQiAndHealth();
}
