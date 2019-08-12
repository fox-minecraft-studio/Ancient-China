package com.fox.ancientchina.cof.entity.render;

import com.fox.ancientchina.cof.entity.EntityDeadlyCoin;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ajacker
 */
public class RenderLoader {
    public RenderLoader() {
        registerEntityRender(EntityDeadlyCoin.class, RenderDeadlyCoin.class);

    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, manager -> {
            try {
                return render.getConstructor(RenderManager.class).newInstance(manager);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
