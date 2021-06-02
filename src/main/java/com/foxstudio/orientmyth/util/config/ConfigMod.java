package com.foxstudio.orientmyth.util.config;

import com.foxstudio.orientmyth.Orientmyth;
import net.minecraftforge.common.config.Config;

/**
 * @author cyciling
 */
@Config(modid = Orientmyth.MOD_ID)
public class ConfigMod {
    @Config.Comment("If true, the part of mod: plant,Herbal Medicine will add into game. [default: true]")
    public static boolean plantSoulEnable = true;

}
