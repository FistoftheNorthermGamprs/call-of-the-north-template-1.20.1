package net.david.call_of_the_north.item.custom;

import net.david.call_of_the_north.entity.custom.TranquilizingFluteProjectileEntity;
import net.david.call_of_the_north.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TranquilizingFluteItem extends Item {
    public TranquilizingFluteItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), ModSounds.TRANQUILIZING_FLUTE_SHOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            TranquilizingFluteProjectileEntity tranquilizingFluteProjectileEntity = new TranquilizingFluteProjectileEntity(user, world);
            tranquilizingFluteProjectileEntity.setItem(itemStack);
            tranquilizingFluteProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.0F, 0.0F);
            world.spawnEntity(tranquilizingFluteProjectileEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(0);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

}