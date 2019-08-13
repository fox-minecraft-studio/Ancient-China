package com.fox.ancientchina.cof.item;

import com.fox.ancientchina.cof.entity.EntityDeadlyCoin;
import com.fox.ancientchina.cof.util.lib.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 * @author ajacker
 */
public class ItemDeadlyCoin extends ItemBase {

    public ItemDeadlyCoin(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode) {
            itemStack.shrink(1);
        }
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            EntityDeadlyCoin coin = new EntityDeadlyCoin(worldIn, playerIn);
            coin.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3F, 1.0F);
            worldIn.spawnEntity(coin);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
    }
}
