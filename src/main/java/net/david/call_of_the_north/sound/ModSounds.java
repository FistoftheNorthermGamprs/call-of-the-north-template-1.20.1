package net.david.call_of_the_north.sound;

import net.david.call_of_the_north.CallOfTheNorth;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent TRANQUILIZING_FLUTE_SHOT = registerSoundEvent("tranquilizing_flute_shot");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(CallOfTheNorth.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CallOfTheNorth.LOGGER.info("Registering Sounds for " + CallOfTheNorth.MOD_ID);
    }
}
