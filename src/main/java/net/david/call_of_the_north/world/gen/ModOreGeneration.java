package net.david.call_of_the_north.world.gen;

import net.david.call_of_the_north.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_CRYSTAL_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.END_STONE_ANCIENT_CRYSTAL_ORE_PLACED_KEY);
    }
}
