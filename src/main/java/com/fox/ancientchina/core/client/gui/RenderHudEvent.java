package com.fox.ancientchina.core.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
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
            mc.renderEngine.bindTexture(Gui.ICONS);
    }
    }


}
