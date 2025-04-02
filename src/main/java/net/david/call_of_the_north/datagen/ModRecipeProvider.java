package net.david.call_of_the_north.datagen;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ANCIENT_CRYSTAL_SMELTABLES = List.of(ModBlocks.ANCIENT_CRYSTAL_ORE,
            ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE, ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, ANCIENT_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.ANCIENT_CRYSTAL,
                1.9f, 200, "ancient_crystal");
        offerBlasting(exporter, ANCIENT_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.ANCIENT_CRYSTAL,
                1.9f, 100, "ancient_crystal");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ORE_COMPASS, 1)
                .pattern(" G ")
                .pattern("IED")
                .pattern(" R ")
                .input('G', Items.GOLD_INGOT)
                .input('I', Items.IRON_INGOT)
                .input('E', ModItems.EYE_OF_ILLUSION)
                .input('R', Items.REDSTONE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.EYE_OF_ILLUSION), conditionsFromItem(ModItems.EYE_OF_ILLUSION))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.ORE_COMPASS)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CIGAR, 2)
                .pattern("PPP")
                .pattern("TTT")
                .pattern("PPP")
                .input('T', ModItems.TOBACCO_LEAF)
                .input('P', Items.PAPER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(ModItems.TOBACCO_LEAF), conditionsFromItem(ModItems.TOBACCO_LEAF))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.CIGAR)));










    }
}
