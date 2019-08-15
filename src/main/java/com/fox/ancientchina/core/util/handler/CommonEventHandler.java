package com.fox.ancientchina.core.util.handler;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.fox.ancientchina.core.AncientChina_Core.MODID;

/**
 * @author ajacker
 */
@Mod.EventBusSubscriber(modid = MODID)
public class CommonEventHandler {
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getWorld().isRemote) {
            //something
        }
    }
}
