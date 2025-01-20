package net.david.call_of_the_north.block;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.block.custom.TobaccoCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {


    public static final Block ANCIENT_CRYSTAL_ORE = registerBlock("ancient_crystal_ore",
            new  ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,5)));
    public static final Block DEEPSLATE_ANCIENT_CRYSTAL_ORE = registerBlock("deepslate_ancient_crystal_ore",
            new  ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2,5)));
    public static final Block END_STONE_ANCIENT_CRYSTAL_ORE = registerBlock("end_stone_ancient_crystal_ore",
            new  ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f), UniformIntProvider.create(4, 7)));
    public static final Block TOBACCO_CROP = Registry.register(Registries.BLOCK, new Identifier(CallOfTheNorth.MOD_ID, "tobacco_crop"),
            new TobaccoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CallOfTheNorth.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CallOfTheNorth.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        CallOfTheNorth.LOGGER.info("Registering ModBlocks for " + CallOfTheNorth.MOD_ID);
    }
}
