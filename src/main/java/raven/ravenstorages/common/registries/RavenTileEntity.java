package raven.ravenstorages.common.registries;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.blocks.tiles.TileDebugAnchor;
import raven.ravenstorages.common.registries.registerer.TileEntityRegisterer;

public class RavenTileEntity {
    private static final TileEntityRegisterer TILE_REGISTERER = new TileEntityRegisterer(Settings.MOD_ID);

    public static TileEntityType<TileDebugAnchor> DEBUG_ANCHOR;

    public static void regTile() {
        DEBUG_ANCHOR = TILE_REGISTERER.registry(TileDebugAnchor.class, RavenBlock.BLOCK_DEBUG);
    }
}
