package raven.ravenstorages.common.library.functional.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ActionResultType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface IWrenchRetrievable {
    default ActionResultType onRetrieve(Block block, PlayerInventory storeTarget) {
        return ActionResultType.SUCCESS;
    }


}
