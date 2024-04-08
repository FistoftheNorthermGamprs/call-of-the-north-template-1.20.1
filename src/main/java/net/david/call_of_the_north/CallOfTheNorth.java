package net.david.call_of_the_north;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.item.ModItemGroups;
import net.david.call_of_the_north.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallOfTheNorth implements ModInitializer {
	public static final String MOD_ID = "call_of_the_north";
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		LOGGER.info("Hello Fabric world!");
	}
}