package com.fox.ancientchina.cof.loader;

import com.fox.ancientchina.cof.entity.EntityDeadlyCoin;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;


import static com.fox.ancientchina.cof.AncientChinaCOF.MODID;

/**
 * @author ajacker
 */
public class EntityLoader {
    public static final EntityEntry DEADLY_COIN = EntityEntryBuilder.create().
            entity(EntityDeadlyCoin.class).
            name("DeadlyCoin")
            .id(new ResourceLocation(MODID, "deadly_coin"), 0)
            .tracker(80, 1, false)
            .build();

}
