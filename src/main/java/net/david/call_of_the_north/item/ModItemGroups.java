package net.david.call_of_the_north.item;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup NORTHERN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CallOfTheNorth.MOD_ID, "northern"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.northern"))
                    .icon(() -> new ItemStack(ModItems.FUR)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FUR);
                        entries.add(ModItems.FREEZE_BERRIES);
                        entries.add(ModItems.CIGAR);
                        entries.add(ModItems.ORE_COMPASS);
                        entries.add(ModItems.EYE_OF_ILLUSION);
                        entries.add(ModItems.ANCIENT_CRYSTAL);
                        entries.add(ModItems.TOBACCO_LEAF);
                        entries.add(ModItems.TOBACCO_SEEDS);
                        entries.add(ModItems.ENERGIZED_ANCIENT_CRYSTAL);
                        entries.add(ModItems.TRANQUILIZING_FLUTE);
                        entries.add(ModBlocks.ANCIENT_CRYSTAL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE);
                        entries.add(ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE);


                    }).build());

    public static void registerItemGroups() {
        CallOfTheNorth.LOGGER.info("Registering Item Groups for " + CallOfTheNorth.MOD_ID);
    }
}
