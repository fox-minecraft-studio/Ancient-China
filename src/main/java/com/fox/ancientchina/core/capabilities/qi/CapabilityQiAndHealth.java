package com.fox.ancientchina.core.capabilities.qi;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
@Deprecated
public class CapabilityQiAndHealth implements IQiAndHealth {
    public static final CapabilityQiAndHealth INSTANCE = new CapabilityQiAndHealth();

    private int healthValue = 0;

    public void update(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) event.getObject();
            this.healthValue = (int) player.getHealth();
        }
    }

    @Override
    public void setQiAndHealth(int healthValue) {
        this.healthValue = healthValue;
    }

    @Override
    public int getQiAndHealth() {
        return this.healthValue;
    }
}
