package net.david.call_of_the_north.entity;

import net.david.call_of_the_north.entity.custom.TranquilizingFluteProjectileEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities implements ModInitializer {
    public static final String ModID = "call_of_the_north"; // This is just so we can refer to our ModID easier.

    public static final EntityType<TranquilizingFluteProjectileEntity> TranquilizingFluteProjectile = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ModID, "note"),
            FabricEntityTypeBuilder.<TranquilizingFluteProjectileEntity>create(SpawnGroup.MISC, TranquilizingFluteProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.50F, 0.50F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD
            // PSLSSSSSS
    );


    @Override
    public void onInitialize() {

    }
}
