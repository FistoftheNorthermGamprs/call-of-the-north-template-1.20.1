package net.david.call_of_the_north.item;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.item.custom.OreCompassItem;
import net.david.call_of_the_north.item.custom.TranquilizingFluteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FUR = registerItem("fur", new Item(new FabricItemSettings()));
    public static final Item EYE_OF_ILLUSION = registerItem("eye_of_illusion", new Item(new FabricItemSettings()));
    public static final Item FREEZE_BERRIES = registerItem("freeze_berries", new Item(new FabricItemSettings().food(ModFoodComponents.FREEZE_BERRIES)));

    public static final Item ORE_COMPASS = registerItem("ore_compass", new OreCompassItem(new FabricItemSettings().maxDamage(20)));

    public static final Item ANCIENT_CRYSTAL = registerItem("ancient_crystal", new Item(new FabricItemSettings()));
    public static final Item ENERGIZED_ANCIENT_CRYSTAL = registerItem("energized_ancient_crystal", new Item(new FabricItemSettings()));

    public static final Item TRANQUILIZING_FLUTE = registerItem("tranquilizing_flute", new TranquilizingFluteItem(new FabricItemSettings()));


    public static final Item TOBACCO_SEEDS = registerItem("tobacco_seeds",
            new AliasedBlockItem(ModBlocks.TOBACCO_CROP, new FabricItemSettings()));
    public static final Item TOBACCO_LEAF = registerItem("tobacco_leaf",
            new Item(new FabricItemSettings()));

    public static final Item CIGAR = registerItem("cigar", new Item(new FabricItemSettings().food(ModFoodComponents.CIGAR)));



    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FUR);
        entries.add(ANCIENT_CRYSTAL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CallOfTheNorth.MOD_ID, name), item);
    }


    public static void registerModItems() {
        CallOfTheNorth.LOGGER.info("Registering Mod Items for " + CallOfTheNorth.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
