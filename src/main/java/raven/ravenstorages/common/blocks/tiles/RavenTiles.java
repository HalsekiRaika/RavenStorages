package raven.ravenstorages.common.blocks.tiles;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import raven.ravenstorages.common.blocks.RavenBlocks;

import static raven.ravenstorages.Settings.MOD_ID;

public final class RavenTiles {
    private RavenTiles() {
        throw new AssertionError();
    }

    public static final TileEntityType<?> INTERFACE_CRYSTAL = TileEntityType.Builder.create(InterfaceCrystalTile::new, RavenBlocks.INTERFACE_CRYSTAL).build(null).setRegistryName(MOD_ID, "interface_crystal");

    public static void register(RegistryEvent.Register<TileEntityType<?>> register) {
        register.getRegistry().registerAll(
            INTERFACE_CRYSTAL
        );
    }
}
