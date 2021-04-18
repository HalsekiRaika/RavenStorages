package raven.ravenstorages.tiles;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import raven.ravenstorages.blocks.RavenBlocks;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class RavenTiles {
    private RavenTiles() {
        throw new AssertionError();
    }

    public static final TileEntityType<InterfaceTile> INTERFACE = create(InterfaceTile::new, "interface", RavenBlocks.INTERFACE);
    public static final TileEntityType<ControllerTile> CONTROLLER = create(ControllerTile::new, "controller", RavenBlocks.CONTROLLER);
    public static final TileEntityType<ReaderTile> READER = create(ReaderTile::new, "reader", RavenBlocks.READER);
    public static final TileEntityType<AccessPointTile> ACCESS_POINT = create(AccessPointTile::new, "access_point", RavenBlocks.ACCESS_POINT);

    // Use for Debug
    public static final TileEntityType<DebugAnchorTile> DEBUG_ANCHOR = create(DebugAnchorTile::new, "debug_anchor", RavenBlocks.DEBUG_ANCHOR);

    public static void register(@Nonnull RegistryEvent.Register<TileEntityType<?>> register) {
        register.getRegistry().registerAll(
            DEBUG_ANCHOR,
            INTERFACE,
            CONTROLLER,
            READER,
            ACCESS_POINT
        );
    }

    private static <T extends TileEntity> TileEntityType<T> create(@Nonnull Supplier<? extends T> factory, @Nonnull String name, @Nonnull Block... validBlocks) {
        //noinspection ConstantConditions
        TileEntityType<T> type = TileEntityType.Builder.<T>create(factory, validBlocks).build(null);
        type.setRegistryName(MOD_ID, name);
        return type;
    }
}
