package com.fox.ancientchina.core.network.clientmessage;

import com.fox.ancientchina.core.capabilities.base.EntityCapabilitiesHelper;
import com.fox.ancientchina.core.capabilities.base.EntityCapability;
import com.fox.ancientchina.core.network.ACMessageEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

/**
 * 本类负责同步玩家等实体的技能
 */
public class MessageEntityCapability extends ACMessageEntity {
    private NBTTagCompound nbtTagCompound;
    /**我们采用ResourceLocation保存了每一个能力的id*/
    private ResourceLocation capability;

    public MessageEntityCapability(){}

    public MessageEntityCapability(EntityCapability<?,?,?> capability){
        this.capability = capability.getID();
        this.addEntity(capability.getEntity());
        this.nbtTagCompound = new NBTTagCompound();
        capability.writeTrackingDataToNBT(this.nbtTagCompound);
    }

    @Override
    public void serialize(PacketBuffer buffer) {
        super.serialize(buffer);
        buffer.writeString(this.capability.toString());
        buffer.writeCompoundTag(this.nbtTagCompound);
    }

    @Override
    public void deserialize(PacketBuffer buffer) {
        super.deserialize(buffer);
        this.capability = new ResourceLocation(buffer.readString(128));
        try {
            this.nbtTagCompound = buffer.readCompoundTag();
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public IMessage process(MessageContext context) {
        super.process(context);
        if (context.side == Side.CLIENT){
            this.processClient();
        }

        return null;
    }

    @SideOnly(Side.CLIENT)
    public void processClient(){
        Entity entity = this.getEntity(0);
        if (entity != null){
            EntityCapability<?,?,Entity> capability = EntityCapabilitiesHelper.getCapability(this.capability,entity);
            if (capability != null){
                capability.readTrackingDataFromNBT(this.nbtTagCompound);
            }
        }
    }
}
