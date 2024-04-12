package net.david.call_of_the_north.datagen;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.ORE_COMPASS_FINDABLE_BLOCKS)
                .add(ModBlocks.ANCIENT_CRYSTAL_ORE)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.IRON_ORES);


        // Blocks mineable with pickaxe
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ANCIENT_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE)
                .add(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE);

        // Blocks mineable with pickaxe tiers

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ANCIENT_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE);

    }
}