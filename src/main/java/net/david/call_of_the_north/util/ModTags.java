package net.david.call_of_the_north.util;

import net.david.call_of_the_north.CallOfTheNorth;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORE_COMPASS_FINDABLE_BLOCKS =
                createTag("ore_compass_findable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CallOfTheNorth.MOD_ID, name));
        }
    }
    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CallOfTheNorth.MOD_ID, name));
        }
    }
}
