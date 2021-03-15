package raven.ravenstorages.common.registries;

import net.minecraft.tileentity.TileEntity;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.registries.registerer.TileEntityRegisterer;

public class RavenTileEntity {
    private static final TileEntityRegisterer<TileEntity> TILE_REGISTERER = new TileEntityRegisterer<>(Settings.MOD_ID);
}
