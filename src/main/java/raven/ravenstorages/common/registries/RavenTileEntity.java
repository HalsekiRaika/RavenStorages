package raven.ravenstorages.common.registries;

import net.minecraft.tileentity.TileEntity;
import raven.ravenstorages.common.registries.registerer.TileEntityRegisterer;

public class RavenTileEntity {
    private static final TileEntityRegisterer<TileEntity> REGISTERER = new TileEntityRegisterer<>();

    public static void onRegistration() {
        //TODO: Handle events.
    }
}
