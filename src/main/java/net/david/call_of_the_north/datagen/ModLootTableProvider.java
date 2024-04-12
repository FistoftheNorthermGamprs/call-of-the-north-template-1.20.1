package net.david.call_of_the_north.datagen;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ANCIENT_CRYSTAL_ORE,oreDrops(ModBlocks.ANCIENT_CRYSTAL_ORE, ModItems.ANCIENT_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE,oreDrops(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE, ModItems.ANCIENT_CRYSTAL));
        addDrop(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE,oreDrops(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE, ModItems.ENERGIZED_ANCIENT_CRYSTAL));


    }
}
