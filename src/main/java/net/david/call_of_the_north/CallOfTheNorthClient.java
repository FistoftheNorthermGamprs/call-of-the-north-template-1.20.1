package net.david.call_of_the_north;

import net.david.call_of_the_north.block.ModBlocks;
import net.david.call_of_the_north.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CallOfTheNorthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOBACCO_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.TranquilizingFluteProjectile, FlyingItemEntityRenderer::new);
    }
}
