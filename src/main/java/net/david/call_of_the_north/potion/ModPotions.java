package net.david.call_of_the_north.potion;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion FROSTBITE_POTION;
    public static Potion LONG_FROSTBITE_POTION;

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(CallOfTheNorth.MOD_ID, name), potion);
    }


    public static void registerPotions() {
        FROSTBITE_POTION = registerPotion("frostbite_potion", new Potion(new StatusEffectInstance(ModEffects.FROSTBITE, 200)));
    }
}
