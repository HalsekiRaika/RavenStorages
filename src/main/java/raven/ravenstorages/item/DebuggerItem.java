package raven.ravenstorages.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import raven.ravenstorages.capability.CapabilityDebugHandler;
import raven.ravenstorages.itemgroup.RavenItemGroups;

import javax.annotation.Nonnull;

final class DebuggerItem extends Item {
    DebuggerItem() {
        super(new Properties().group(RavenItemGroups.RAVEN_MAIN));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        if(!worldIn.isRemote) {
            playerIn.getHeldItem(handIn).getCapability(CapabilityDebugHandler.debugHandler())
                .orElseThrow(() -> new IllegalStateException("Capability Debug Handler is not present."))
                .hello();
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
