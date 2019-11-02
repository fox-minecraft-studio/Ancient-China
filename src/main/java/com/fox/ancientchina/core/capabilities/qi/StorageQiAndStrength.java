package com.fox.ancientchina.core.capabilities.qi;

import com.fox.ancientchina.core.api.capability.IQiAndStrength;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
@Deprecated
public class StorageQiAndStrength implements Capability.IStorage<IQiAndStrength>{
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IQiAndStrength> capability, IQiAndStrength instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("qi_strength",instance.getQiAndStrength());
        return tag;
    }

    @Override
    public void readNBT(Capability<IQiAndStrength> capability, IQiAndStrength instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagCompound){
            instance.setQiAndStrength(((NBTTagCompound)nbt).getInteger("qi_strength"));
        }
    }
}
