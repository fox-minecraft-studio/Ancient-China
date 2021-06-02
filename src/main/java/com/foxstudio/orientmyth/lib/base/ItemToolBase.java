package com.foxstudio.orientmyth.lib.base;

/**
 * @author cyciling
 */
public class ItemToolBase extends ItemBase {
    public ItemToolBase(String type, int damage, int level) {
        super(damage, 1);
        this.setHarvestLevel(type, level);
    }
    /*
        Sets or removes the harvest level for the specified tool class.
        参数:
        toolClass – Class
        level – Harvest level: Wood: 0 Stone: 1 Iron: 2 Diamond: 3 Gold: 0
        */
}
