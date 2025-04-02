package net.david.call_of_the_north.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent FREEZE_BERRIES = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600), 0.40f).build();

    public static final FoodComponent CIGAR = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300), 0.90f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100), 0.50f).build();
}
