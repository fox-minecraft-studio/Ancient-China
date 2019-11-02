package com.fox.ancientchina.core.capabilities.qi;

import com.fox.ancientchina.core.api.capability.IQiAndHealth;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
@Deprecated
public class StorageQiAndHealth implements Capability.IStorage<IQiAndHealth> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IQiAndHealth> capability, IQiAndHealth instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("qi_health",instance.getQiAndHealth());
        return tag;
    }

    @Override
    public void readNBT(Capability<IQiAndHealth> capability, IQiAndHealth instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagCompound){
            instance.setQiAndHealth(((NBTTagCompound)nbt).getInteger("qi_health"));
        }
    }
}
