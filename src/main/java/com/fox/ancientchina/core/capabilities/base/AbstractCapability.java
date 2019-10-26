package com.fox.ancientchina.core.capabilities.base;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

/**
 * 这个参考了BL的代码
 * @param <F> capability 的默认功能实现
 * @param <C> capability 本身接口
 * @param <T> capability 的绑定对象
 */
public abstract class AbstractCapability <F extends AbstractCapability<F,C,T>,C,T>{
    public abstract ResourceLocation getID();

    /**
     * 返回capability默认实现
     */
    public abstract F getDefaultCapability();

    public abstract Capability<C> getCapability();

    /**
     * 返回capability的接口
     * @return
     */
    public abstract Class<C> getCapabilityClass();

}
