package com.fox.ancientchina.core.client;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;
import com.fox.ancientchina.core.capabilities.CapabilityQiAndHealth;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * @author yaesey
 */
public class RenderHudEvent {
    public Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onHudRender(RenderGameOverlayEvent event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL){
            mc.fontRenderer.drawString("henjgfuehfjhu",0,0,0xffffffff);
            return;
        }
        drawMessage(20);
        mc.renderEngine.bindTexture(Gui.ICONS);
    }

    /**
     * 绘制信息在屏幕左上角
     * @param offset 向下偏移多少
     */
    private void drawMessage(int offset){
        FontRenderer renderer = mc.fontRenderer;

        renderer.drawString(
                "气血值" + CapabilityQiAndHealth.INSTANCE.getQiAndHealth(),
                0,
                0,
                0xFFFFFFFF
        );
    }
}
