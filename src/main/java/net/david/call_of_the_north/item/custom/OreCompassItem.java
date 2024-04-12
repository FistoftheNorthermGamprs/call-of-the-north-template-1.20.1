package net.david.call_of_the_north.item.custom;

import net.david.call_of_the_north.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreCompassItem extends Item { public OreCompassItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        boolean foundBlock = false;
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if (isValueableBlock(state)) {
                    outputValueableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    //break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(Text.literal("No Valuables Found!"));
            }
        }
        if (foundBlock) {
            context.getStack().damage(1, context.getPlayer(),
                    playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        }


        return ActionResult.SUCCESS;
    }

    private void outputValueableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + ")"), false);
    }

    private boolean isValueableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.ORE_COMPASS_FINDABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.call_of_the_north.ore_compass.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
