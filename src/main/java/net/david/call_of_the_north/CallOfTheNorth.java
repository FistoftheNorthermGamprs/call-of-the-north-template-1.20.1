package net.david.call_of_the_north;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallOfTheNorth implements ModInitializer {
	public static final String MOD_ID = "call_of_the_north";
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}