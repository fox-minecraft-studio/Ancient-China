package com.fox.ancientchina.core.client.gui;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;
import com.fox.ancientchina.core.capabilities.CapabilityQiAndHealth;
import com.fox.ancientchina.core.capabilities.CapabilityQiAndStrength;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
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
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL){
            return;
        }
        drawData(20);
        mc.renderEngine.bindTexture(Gui.ICONS);
    }

    /**
     * 这个方法负责绘制数据值
     * @param downset 向下偏移数值
     */
    public void drawData(int downset){
        int y = 0;
        mc.fontRenderer.drawString("气血值：" + CapabilityQiAndHealth.INSTANCE.getQiAndHealth(),0,y,0xFFFFFFFF);
        mc.fontRenderer.drawString("气力值：" + CapabilityQiAndStrength.INSTANCE.getQiAndStrength(),0,y + downset,0xFFFFFFFF);
    }
}
