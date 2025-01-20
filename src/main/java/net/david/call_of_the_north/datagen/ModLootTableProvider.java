package net.david.call_of_the_north.datagen;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.block.custom.TobaccoCropBlock;
import net.david.call_of_the_north.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ANCIENT_CRYSTAL_ORE,oreDrops(ModBlocks.ANCIENT_CRYSTAL_ORE, ModItems.ANCIENT_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE,oreDrops(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE, ModItems.ANCIENT_CRYSTAL));
        addDrop(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE,oreDrops(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE, ModItems.ENERGIZED_ANCIENT_CRYSTAL));


        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOBACCO_CROP).properties(StatePredicate.Builder.create()
                 .exactMatch(TobaccoCropBlock.AGE, 8));
        addDrop(ModBlocks.TOBACCO_CROP, cropDrops(ModBlocks.TOBACCO_CROP, ModItems.TOBACCO_LEAF, ModItems.TOBACCO_SEEDS, builder));
    }
}
