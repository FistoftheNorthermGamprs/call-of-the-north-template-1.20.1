package net.david.call_of_the_north.datagen;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.block.custom.TobaccoCropBlock;
import net.david.call_of_the_north.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_CRYSTAL_ORE);
        blockStateModelGenerator.registerCrop(ModBlocks.TOBACCO_CROP, TobaccoCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FREEZE_BERRIES, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANCIENT_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_ANCIENT_CRYSTAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.EYE_OF_ILLUSION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORE_COMPASS, Models.GENERATED);

        itemModelGenerator.register(ModItems.TRANQUILIZING_FLUTE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOBACCO_LEAF, Models.GENERATED);




    }
}
