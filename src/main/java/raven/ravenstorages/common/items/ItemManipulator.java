package raven.ravenstorages.common.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import raven.ravenstorages.RavenStorages;
import raven.ravenstorages.common.library.functional.tile.IWrenchRetrievable;
import raven.ravenstorages.common.tab.RavenItemGroups;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemManipulator extends Item {
    public ItemManipulator() {
        super(new Properties().group(RavenItemGroups.RAVEN_MAIN));
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
        Block tileBlock = context.getWorld().getBlockState(context.getPos()).getBlock();
        PlayerEntity player = Objects.requireNonNull(context.getPlayer(), "player data is null");
        PlayerInventory playerInv = player.inventory;

        if (tileBlock instanceof IWrenchRetrievable) {
            return ((IWrenchRetrievable) tileBlock).onRetrieve(tileBlock, playerInv);
        }

        return ActionResultType.PASS;
    }

    public static ItemManipulator getInstance() {
        return new ItemManipulator();
    }
}
