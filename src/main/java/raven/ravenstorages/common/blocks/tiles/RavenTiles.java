package raven.ravenstorages.common.blocks.tiles;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import raven.ravenstorages.common.blocks.RavenBlocks;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class RavenTiles {
    private RavenTiles() {
        throw new AssertionError();
    }

    @SuppressWarnings("ConstantConditions")
    public static final TileEntityType<?> DEBUG_ANCHOR = TileEntityType.Builder.create(TileDebugAnchor::new, RavenBlocks.DEBUG_ANCHOR).build(null).setRegistryName(MOD_ID, "debug_anchor");
    @SuppressWarnings("ConstantConditions")
    public static final TileEntityType<?> INTERFACE = TileEntityType.Builder.create(InterfaceTile::new, RavenBlocks.INTERFACE).build(null).setRegistryName(MOD_ID, "interface");
    @SuppressWarnings("ConstantConditions")
    public static final TileEntityType<?> CONTROLLER = TileEntityType.Builder.create(ControllerTile::new, RavenBlocks.CONTROLLER).build(null).setRegistryName(MOD_ID, "controller");
    @SuppressWarnings("ConstantConditions")
    public static final TileEntityType<?> READER = TileEntityType.Builder.create(ReaderTile::new, RavenBlocks.READER).build(null).setRegistryName(MOD_ID, "reader");

    public static void register(@Nonnull RegistryEvent.Register<TileEntityType<?>> register) {
        register.getRegistry().registerAll(
            DEBUG_ANCHOR,
            INTERFACE,
            CONTROLLER,
            READER
        );
    }
}
