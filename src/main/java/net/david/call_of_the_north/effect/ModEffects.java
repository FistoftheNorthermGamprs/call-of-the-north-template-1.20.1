package net.david.call_of_the_north.effect;

import net.david.call_of_the_north.CallOfTheNorth;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect FROSTBITE;

    public static StatusEffect registerFrostbite(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(CallOfTheNorth.MOD_ID, name),
                new FrostbiteEffect(StatusEffectCategory.HARMFUL, 14270531)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                "22653B89-116E-49DC-9B6B-9971489B5BE5",
                                -0.5, EntityAttributeModifier.Operation.ADDITION));
    }

    public static void registerEffects() {
        FROSTBITE = registerFrostbite("frostbite");
    }
}
