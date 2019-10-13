package com.fox.ancientchina.core.capabilities;

import com.fox.ancientchina.core.api.capability.IWuXing;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * @author yaesey
 */
public class StorageWuXing implements Capability.IStorage<IWuXing> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IWuXing> capability, IWuXing instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("jin",instance.getWuXingValue(EnumWuXing.JIN));
        tag.setInteger("mu",instance.getWuXingValue(EnumWuXing.MU));
        tag.setInteger("shui",instance.getWuXingValue(EnumWuXing.SHUI));
        tag.setInteger("huo",instance.getWuXingValue(EnumWuXing.HUO));
        tag.setInteger("tu",instance.getWuXingValue(EnumWuXing.TU));
        return tag;
    }

    @Override
    public void readNBT(Capability<IWuXing> capability, IWuXing instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagCompound){
            NBTTagCompound tag = (NBTTagCompound)nbt;
            instance.setWuXingValue(EnumWuXing.JIN,tag.getInteger("jin"));
            instance.setWuXingValue(EnumWuXing.MU,tag.getInteger("mu"));
            instance.setWuXingValue(EnumWuXing.SHUI,tag.getInteger("shui"));
            instance.setWuXingValue(EnumWuXing.HUO,tag.getInteger("huo"));
            instance.setWuXingValue(EnumWuXing.TU,tag.getInteger("tu"));
        }
    }
}
