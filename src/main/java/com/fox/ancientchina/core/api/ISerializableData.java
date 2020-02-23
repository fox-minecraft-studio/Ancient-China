package com.fox.ancientchina.core.api;

import net.minecraft.nbt.NBTTagCompound;

public interface ISerializableData {
    void writeToNBT(NBTTagCompound nbt);
    void readFromNBT(NBTTagCompound nbt);
}
