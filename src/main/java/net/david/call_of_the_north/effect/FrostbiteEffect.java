package net.david.call_of_the_north.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.DamageModifierStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class FrostbiteEffect extends StatusEffect {
    protected FrostbiteEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.45f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "22653B89-116E-49DC-9B6B-9971489B5BE5", -1.0, EntityAttributeModifier.Operation.ADDITION);
        if (this == ModEffects.FROSTBITE) {
            if (entity.getHealth() > 1.0f) {
                entity.damage(entity.getDamageSources().freeze(), 0.5f);
            }
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == ModEffects.FROSTBITE) {
            int i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return true;
        }
        return false;
    }
}