package raven.ravenstorages.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
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
        TileEntity tile = context.getWorld().getTileEntity(context.getPos());
        PlayerEntity player = Objects.requireNonNull(context.getPlayer());
        PlayerInventory playerInv = player.inventory;
        if (tile instanceof IWrenchRetrievable && player.isSneaking()) {
            return ((IWrenchRetrievable) tile).onRetrieve(tile, playerInv);
        }

        return super.onItemUse(context);
    }

    public static ItemManipulator getInstance() {
        return new ItemManipulator();
    }
}
