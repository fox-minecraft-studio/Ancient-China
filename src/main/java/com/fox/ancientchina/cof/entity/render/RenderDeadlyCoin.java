package com.fox.ancientchina.cof.entity.render;

import com.fox.ancientchina.cof.entity.EntityDeadlyCoin;
import com.fox.ancientchina.cof.loader.ItemLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

/**
 * @author ajacker
 */
public class RenderDeadlyCoin extends RenderSnowball<EntityDeadlyCoin> {

    public RenderDeadlyCoin(RenderManager renderManagerIn) {
        super(renderManagerIn, ItemLoader.DEADLY_COIN, Minecraft.getMinecraft().getRenderItem());
    }
}
