package com.fox.ancientchina.core.client.gui;

import com.fox.ancientchina.core.capabilities.qi.CapabilityQiAndHealth;
import com.fox.ancientchina.core.capabilities.qi.CapabilityQiAndStrength;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * @author yaesey
 */
public class RenderHudEvent {
    public RenderHudEvent(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    public Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onHudRender(RenderGameOverlayEvent event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH){
            drawData(10);
            mc.renderEngine.bindTexture(Gui.ICONS);
        }
    }

    /**
     * 这个方法负责绘制数据值
     * @param downSet 向下偏移数值
     */
    public void drawData(int downSet){
        int y = 0;
        mc.fontRenderer.drawString(I18n.format("ac.gui.hud.health") + CapabilityQiAndHealth.INSTANCE.getQiAndHealth(),0,y,0xFFFFFFFF);
        mc.fontRenderer.drawString(I18n.format("ac.gui.hud.strength") + CapabilityQiAndStrength.INSTANCE.getQiAndStrength(),0,y + downSet,0xFFFFFFFF);
    }
}
