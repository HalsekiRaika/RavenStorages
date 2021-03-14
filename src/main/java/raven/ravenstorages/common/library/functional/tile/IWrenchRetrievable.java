package raven.ravenstorages.common.library.functional.tile;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface IWrenchRetrievable {
    default ActionResultType onRetrieve(TileEntity tile, PlayerInventory storeTarget) {
        return ActionResultType.SUCCESS;
    }
}
