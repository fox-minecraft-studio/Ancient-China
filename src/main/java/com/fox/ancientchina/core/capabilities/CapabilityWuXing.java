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
        wuXing.writeNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        wuXing.readNBT(nbt);
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
