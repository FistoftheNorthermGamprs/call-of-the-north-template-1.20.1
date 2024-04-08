package net.david.call_of_the_north.world;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_CRYSTAL_ORE_KEY = registerKey("ancient_crystal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_STONE_ANCIENT_CRYSTAL_ORE_KEY = registerKey("end_stone_ancient_crystal_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldAncientCrystalOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ANCIENT_CRYSTAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ANCIENT_CRYSTAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endAncientCrystalOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_STONE_ANCIENT_CRYSTAL_ORE.getDefaultState()));

    register(context, ANCIENT_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAncientCrystalOres, 13));
        register(context, END_STONE_ANCIENT_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(endAncientCrystalOres, 10));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CallOfTheNorth.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
