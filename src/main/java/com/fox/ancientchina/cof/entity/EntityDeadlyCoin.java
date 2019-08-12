package com.fox.ancientchina.cof.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * @author ajacker
 */
public class EntityDeadlyCoin extends EntityThrowable {
    public EntityDeadlyCoin(World worldIn) {
        super(worldIn);
    }

    public EntityDeadlyCoin(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityDeadlyCoin(World worldIn, EntityLivingBase throwerIn) {

        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit instanceof EntityLiving) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5.0f);
                this.setDead();
            }
        }
    }
}
