package com.fox.ancientchina.core.capabilities;

import com.fox.ancientchina.core.AncientChinaCore;
import com.fox.ancientchina.core.api.capability.ISerializableData;
import com.fox.ancientchina.core.api.capability.IWuXing;
import com.fox.ancientchina.core.capabilities.base.EntityCapability;
import com.fox.ancientchina.core.loader.CapabilitiesLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

/**
 * 五行值，使用{@link EnumWuXing}作为枚举值
 * @author yaesey
 */
public class CapabilityWuXing extends EntityCapability<CapabilityWuXing,IWuXing, EntityPlayer> implements IWuXing, ISerializableData {
    private EnumWuXing wuXing;

    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(AncientChinaCore.MODID,"wuXing");
    }

    @Override
    public CapabilityWuXing getDefaultCapability() {
        return new CapabilityWuXing();
    }

    @Override
    public Capability<IWuXing> getCapability() {
        return CapabilitiesLoader.CAPABILITY_WUXING;
    }

    @Override
    public Class<IWuXing> getCapabilityClass() {
        return IWuXing.class;
    }

    @Override
    public boolean isApplicable(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger("jin",wuXing.JIN.getValue());
        nbt.setInteger("mu",wuXing.MU.getValue());
        nbt.setInteger("shui",wuXing.SHUI.getValue());
        nbt.setInteger("huo",wuXing.HUO.getValue());
        nbt.setInteger("tu",wuXing.TU.getValue());
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        wuXing.JIN.setValue(nbt.getInteger("jin"));
        wuXing.MU.setValue(nbt.getInteger("mu"));
        wuXing.SHUI.setValue(nbt.getInteger("shui"));
        wuXing.HUO.setValue(nbt.getInteger("huo"));
        wuXing.TU.setValue(nbt.getInteger("tu"));
    }

    @Override
    public void writeTrackingDataToNBT(NBTTagCompound nbt) {
        this.writeToNBT(nbt);
    }

    @Override
    public void readTrackingDataFromNBT(NBTTagCompound nbt) {
        this.readFromNBT(nbt);
    }

    @Override
    public boolean isConflict() {
        return false;
    }
}
