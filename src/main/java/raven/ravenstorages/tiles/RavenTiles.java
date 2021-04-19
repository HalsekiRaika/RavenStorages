package raven.ravenstorages.tiles;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import raven.ravenstorages.blocks.RavenBlocks;

import javax.annotation.Nonnull;
import java.io.Reader;
import java.util.function.Supplier;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class RavenTiles {
    private RavenTiles() {
        throw new AssertionError();
    }

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    public static final RegistryObject<TileEntityType<InterfaceTile>> INTERFACE = TILES.register("interface", tileEntityTypeSupplier(InterfaceTile::new, RavenBlocks.INTERFACE));
    public static final RegistryObject<TileEntityType<ControllerTile>> CONTROLLER = TILES.register("controller", tileEntityTypeSupplier(ControllerTile::new, RavenBlocks.CONTROLLER));
    public static final RegistryObject<TileEntityType<ReaderTile>> READER = TILES.register("reader", tileEntityTypeSupplier(ReaderTile::new, RavenBlocks.READER));
    public static final RegistryObject<TileEntityType<AccessPointTile>> ACCESS_POINT = TILES.register("access_point", tileEntityTypeSupplier(AccessPointTile::new, RavenBlocks.ACCESS_POINT));
    public static final RegistryObject<TileEntityType<DebugAnchorTile>> DEBUG_ANCHOR = TILES.register("debug_anchor", tileEntityTypeSupplier(DebugAnchorTile::new, RavenBlocks.DEBUG_ANCHOR));

    public static void register(@Nonnull IEventBus bus) {
        TILES.register(bus);
    }

    private static <T extends TileEntity> Supplier<TileEntityType<T>> tileEntityTypeSupplier(@Nonnull Supplier<? extends T> factory, @Nonnull Supplier<Block> validBlock) {
        //noinspection ConstantConditions
        return () -> TileEntityType.Builder.<T>create(factory, validBlock.get()).build(null);
    }
}
