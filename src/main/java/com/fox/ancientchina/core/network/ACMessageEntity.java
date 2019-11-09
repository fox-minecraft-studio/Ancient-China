package com.fox.ancientchina.core.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class ACMessageEntity extends ACMessageBase{
    public ACMessageEntity(){}

    public static class EntityCheck{
        private int entityID,dimensionID;
        private Entity entity;

        public EntityCheck(int entityID,int dimensionID,Entity entity){
            this.entityID = entityID;
            this.dimensionID = dimensionID;
            this.entity = entity;
        }
    }

    private List<EntityCheck> entityCheck = new ArrayList<>();

    public void addEntity(Entity entity){
        this.entityCheck.add(new EntityCheck(entity.getEntityId(),entity.dimension,entity));
    }
    @Nullable
    public Entity getEntity(int index){
        //是否越界
        if (index < this.entityCheck.size()){
            EntityCheck id = this.entityCheck.get(index);
            if (id != null){
                return id.entity;
            }
        }
        return null;
    }

    public List getAllEntities(){
        List<Entity> entities = new ArrayList<>();
        for (EntityCheck id : this.entityCheck){
            if (id.entity != null){
                entities.add(id.entity);
            }
        }
        return entities;
    }
    @Override
    public void serialize(PacketBuffer buffer){
        buffer.writeByte(this.entityCheck.size());
        for (EntityCheck id : this.entityCheck){
            buffer.writeInt(id.entityID);
            buffer.writeInt(id.dimensionID);
        }
    }
    @Override
    public void deserialize(PacketBuffer buffer){
        this.entityCheck.clear();
        int entities = buffer.readByte();
        for (int i = 0;i < entities;i++){
            this.entityCheck.add(new EntityCheck(buffer.readInt(),buffer.readInt(),null));
        }
    }
    @Override
    public IMessage process(MessageContext context){
        if (context.side == Side.CLIENT){
            processClient();
        }else {
            for (EntityCheck id : this.entityCheck){
                World world = DimensionManager.getWorld(id.dimensionID);
                if (world != null){
                    id.entity = world.getEntityByID(id.entityID);
                }
            }
        }

        return null;
    }

    @SideOnly(Side.CLIENT)
    private void processClient(){
        World world = Minecraft.getMinecraft().world;
        if (world != null){
            for (EntityCheck id : this.entityCheck){
                if (id.dimensionID == world.provider.getDimension()){
                    id.entity = world.getEntityByID(id.entityID);
                }
            }
        }
    }
}
