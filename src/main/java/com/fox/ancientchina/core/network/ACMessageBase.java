package com.fox.ancientchina.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.io.IOException;

public abstract class ACMessageBase implements IMessage {
    /**必须含有一个无参构造函数*/
    public ACMessageBase(){ }

    /**
     * 将字节流转换为信息
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        try {
            deserialize(new PacketBuffer(buf));
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * 将信息翻译成字节流
     */
    @Override
    public void toBytes(ByteBuf buf) {
        try {
            serialize(new PacketBuffer(buf));
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    public abstract void serialize(PacketBuffer buffer) throws IOException;
    public abstract void deserialize(PacketBuffer buffer) throws IOException;
    public abstract IMessage process(MessageContext context);
}
