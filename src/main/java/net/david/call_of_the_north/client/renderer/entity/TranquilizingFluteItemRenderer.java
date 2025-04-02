package net.david.call_of_the_north.client.renderer.entity;

import net.david.call_of_the_north.CallOfTheNorth;
import net.david.call_of_the_north.entity.custom.TranquilizingFluteProjectileEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TranquilizingFluteItemRenderer extends EntityRenderer<TranquilizingFluteProjectileEntity> {

    private static final Identifier TEXTURE = new Identifier(CallOfTheNorth.MOD_ID, "textures/entity/note.png");
    public TranquilizingFluteItemRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(TranquilizingFluteProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        // Get the item stack of the thrown entity
        ItemStack stack = entity.getStack();

        if (!stack.isEmpty()) {
            // Define the custom texture you want to apply to the thrown item
            Identifier customTexture = new Identifier(CallOfTheNorth.MOD_ID, "textures/entity/note.png");

            // Bind the custom texture
            MinecraftClient.getInstance().getTextureManager().bindTexture(customTexture);

            // Get the BakedModel for the item
            BakedModel model = MinecraftClient.getInstance().getItemRenderer().getModel(stack, entity.getWorld(), null, 0);

            // Call renderItem with all the necesfsary parameters
            MinecraftClient.getInstance().getItemRenderer().renderItem(
                    stack,                                    // The item stack
                    ModelTransformationMode.NONE,             // No specific transformation (it's not in the hand)
                    false,                                    // Not left-handed
                    matrices,                                 // Matrix stack (used for transformations)
                    vertexConsumers,                          // Vertex consumers (used for rendering)
                    light,                                    // Light level
                    OverlayTexture.DEFAULT_UV,                // Default overlay (you can customize this if you have effects like glint)
                    model                                     // The model of the item
            );
        }
    }

    @Override
    public Identifier getTexture(TranquilizingFluteProjectileEntity entity) {
        return TEXTURE;
    }
}
