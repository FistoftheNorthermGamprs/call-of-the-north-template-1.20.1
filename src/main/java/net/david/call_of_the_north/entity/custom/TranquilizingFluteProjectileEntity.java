package net.david.call_of_the_north.entity.custom;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.CallOfTheNorthClient;
import net.david.call_of_the_north.effect.ModEffects;
import net.david.call_of_the_north.entity.ModEntities;
import net.david.call_of_the_north.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class TranquilizingFluteProjectileEntity extends ThrownItemEntity {
    public TranquilizingFluteProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public TranquilizingFluteProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.TranquilizingFluteProjectile, livingEntity, world); // null will be changed later
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.TRANQUILIZING_FLUTE;
    }
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    private static final Identifier TEXTURE = new Identifier("call_of_the_north", "textures/entity/note.png");


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        System.out.println("Entity hit results: " + entity.getEntityName());
        int i = entity instanceof BlazeEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity
        Entity entity2 = this.getOwner();
        entity.damage(this.getDamageSources().explosion(this, entity2), 6.0F);
        if (entity2 instanceof LivingEntity) {
            this.applyDamageEffects((LivingEntity)entity2, entity);
        }


        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            livingEntity.addStatusEffect((new StatusEffectInstance(ModEffects.FROSTBITE, 20 * 9, 1))); // applies a status effect
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WITHER, 20 * 9, 3))); // applies a status effect
        }
    }


}

