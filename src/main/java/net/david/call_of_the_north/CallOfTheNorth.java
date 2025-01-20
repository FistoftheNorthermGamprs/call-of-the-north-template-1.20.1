package net.david.call_of_the_north;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.effect.ModEffects;
import net.david.call_of_the_north.entity.custom.TranquilizingFluteProjectileEntity;
import net.david.call_of_the_north.item.ModItemGroups;
import net.david.call_of_the_north.item.ModItems;
import net.david.call_of_the_north.potion.ModPotions;
import net.david.call_of_the_north.sound.ModSounds;
import net.david.call_of_the_north.util.ModLootTableModifiers;
import net.david.call_of_the_north.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CallOfTheNorth implements ModInitializer {
	public static final String MOD_ID = "call_of_the_north";
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		ModLootTableModifiers.modifyLootTables();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModSounds.registerSounds();

		LOGGER.info("Hello Fabric world!");

		ModWorldGeneration.generateModWorldGen();
	}
}