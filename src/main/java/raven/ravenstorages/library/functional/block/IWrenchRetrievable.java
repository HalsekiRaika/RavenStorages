package raven.ravenstorages.library.functional.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * By implementing this in a class that inherits from Block,
 * it is possible to determine if the Manipulator is capable of immediate collection.
 */
@ParametersAreNonnullByDefault
public interface IWrenchRetrievable {
    /**
     * Collect the Block in which this Interface is implemented.
     * @param worldIn  World where the block and Player exist.
     * @param block    Target block
     * @param blockPos Coordinates of the block to be recovered.
     * @param playerIn The target player to be retrieved and stored in the inventory.
     * @return Returns the ActionResultType, Returns SUCCESS if the collection was successful, or PASS if not.
     */
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
