package raven.ravenstorages.common.library.functional.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface IWrenchRetrievable {
    default ActionResultType onRetrieve(World worldIn, BlockState block, BlockPos blockPos, PlayerEntity playerIn) {
        PlayerInventory playerInv = playerIn.inventory;
        ItemStack blockItem = block.getBlock().asItem().getDefaultInstance();
        boolean result = playerInv.addItemStackToInventory(blockItem);
        if (result) {
            worldIn.removeBlock(blockPos, false);
            // TODO : Add an effect for removal.
            return ActionResultType.SUCCESS;
        } else {
            ItemEntity itemEntity = playerIn.dropItem(blockItem, false);
            worldIn.removeBlock(blockPos, false);
            if (itemEntity != null) {
                itemEntity.setNoPickupDelay();
                itemEntity.setOwnerId(playerIn.getUniqueID());
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}
