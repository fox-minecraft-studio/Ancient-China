package com.fox.ancientchina.plantssoul.register;

import com.fox.ancientchina.plantssoul.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
/**
  *注册菖蒲根
  */
public class ItemsRegister {
    public static final Item acorus_tatarinowii_root = new AcorusTatarinowiiRoot("Acorus Tatarinowii Root");
    public ItemsRegister(){
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                acorus_tatarinowii_root
        );
    }
}
