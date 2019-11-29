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

    public static class EntityCheckerID {
        private int entityID,dimensionID;
        private Entity entity;

        public EntityCheckerID(int entityID, int dimensionID, Entity entity){
            this.entityID = entityID;
            this.dimensionID = dimensionID;
            this.entity = entity;
        }
    }

    private List<EntityCheckerID> entityCheckerIDs = new ArrayList<>();

    public void addEntity(Entity entity){
        this.entityCheckerIDs.add(new EntityCheckerID(entity.getEntityId(),entity.dimension,entity));
    }
    @Nullable
    public Entity getEntity(int index){
        //是否越界
        if (index < this.entityCheckerIDs.size()){
            EntityCheckerID id = this.entityCheckerIDs.get(index);
            if (id != null){
                return id.entity;
            }
        }
        return null;
    }

    public List getAllEntities(){
        List<Entity> entities = new ArrayList<>();
        for (EntityCheckerID id : this.entityCheckerIDs){
            if (id.entity != null){
                entities.add(id.entity);
            }
        }
        return entities;
    }
    @Override
    public void serialize(PacketBuffer buffer){
        buffer.writeByte(this.entityCheckerIDs.size());
        for (EntityCheckerID id : this.entityCheckerIDs){
            buffer.writeInt(id.entityID);
            buffer.writeInt(id.dimensionID);
        }
    }
    @Override
    public void deserialize(PacketBuffer buffer){
        this.entityCheckerIDs.clear();
        int entities = buffer.readByte();
        for (int i = 0;i < entities;i++){
            this.entityCheckerIDs.add(new EntityCheckerID(buffer.readInt(),buffer.readInt(),null));
        }
    }
    @Override
    public IMessage process(MessageContext context){
        if (context.side == Side.CLIENT){
            processClient();
        }else {
            for (EntityCheckerID id : this.entityCheckerIDs){
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
            for (EntityCheckerID id : this.entityCheckerIDs){
                if (id.dimensionID == world.provider.getDimension()){
                    id.entity = world.getEntityByID(id.entityID);
                }
            }
        }
    }
}
