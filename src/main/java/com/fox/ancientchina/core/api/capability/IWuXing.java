package com.fox.ancientchina.core.api.capability;


/**
 * 五行值
 * @author yaesey
 */
public interface IWuXing {
    /**
     * @return 如果五行之间发生冲突，返回true，否则返回false
     */
    boolean isConflict();
}
