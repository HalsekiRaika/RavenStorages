package raven.ravenstorages.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import raven.ravenstorages.blocks.RavenBlocks;
import raven.ravenstorages.itemgroup.RavenItemGroups;

import javax.annotation.Nonnull;

import java.util.function.Supplier;

import static raven.ravenstorages.RavenStorages.MOD_ID;

/**
 * RavenStoragesで実装されるItemの参照を保持するユーティリティクラスです。
 */
public final class RavenItems {
    private RavenItems() {
        throw new AssertionError();
    }

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static RegistryObject<Item> DEBUGGER = ITEMS.register("debugger", DebuggerItem::new);
    public static RegistryObject<Item> MANIPULATOR = ITEMS.register("manipulator", ManipulatorItem::new);
    public static RegistryObject<Item> DEBUG_CONTAINER = ITEMS.register("debug_container",blockItemSupplier(RavenBlocks.DEBUG_CONTAINER));
    public static RegistryObject<Item> DEBUG_ANCHOR = ITEMS.register("debug_anchor", blockItemSupplier(RavenBlocks.DEBUG_ANCHOR));


    /**
     * 全てのItemをeventの返すRegistryに登録します。
     *
     * @param bus Forgeイベントバス
     */
    public static void register(@Nonnull IEventBus bus) {
        ITEMS.register(bus);
    }

    private static Supplier<BlockItem> blockItemSupplier(Supplier<Block> blockSupplier) {
        return () -> new BlockItem(blockSupplier.get(), new Item.Properties().group(RavenItemGroups.RAVEN_MAIN));
    }
}
