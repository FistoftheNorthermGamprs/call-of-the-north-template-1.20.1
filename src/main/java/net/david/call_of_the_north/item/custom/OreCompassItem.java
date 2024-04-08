package net.david.call_of_the_north.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

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
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.REDSTONE_ORE) || state.isOf(Blocks.GOLD_ORE);
    }
}