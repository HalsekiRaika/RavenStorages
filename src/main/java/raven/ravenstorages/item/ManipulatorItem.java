package raven.ravenstorages.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import raven.ravenstorages.library.functional.block.IWrenchRetrievable;
import raven.ravenstorages.itemgroup.RavenItemGroups;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ManipulatorItem extends Item {
    ManipulatorItem() {
        super(new Properties().group(RavenItemGroups.RAVEN_MAIN));
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
        World worldIn = context.getWorld();

        if (!worldIn.isRemote) {
            PlayerEntity player = Objects.requireNonNull(context.getPlayer(), "player data is null");
            if (player.isSneaking()) { // Alternate / Retrieve
                BlockPos blockPos = context.getPos();
                BlockState tileBlock = worldIn.getBlockState(blockPos);
                Block block = tileBlock.getBlock();
                if (block instanceof IWrenchRetrievable) {
                    return ((IWrenchRetrievable) block).onRetrieve(worldIn, tileBlock, blockPos, player);
                }
            }
        }

        return ActionResultType.PASS;
    }
}
