package raven.ravenstorages.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import raven.ravenstorages.blocks.RavenBlocks;
import raven.ravenstorages.itemgroup.RavenItemGroups;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

/**
 * RavenStoragesで実装されるItemの参照を保持するユーティリティクラスです。
 */
public final class RavenItems {
    private RavenItems() {
        throw new AssertionError();
    }

    public static final Item DEBUGGER = new DebuggerItem().setRegistryName(MOD_ID, "debugger");
    public static final Item MANIPULATOR = new ManipulatorItem().setRegistryName(MOD_ID, "manipulator");
    public static final Item DEBUG_CONTAINER = new BlockItem(RavenBlocks.DEBUG_CONTAINER, new Item.Properties().group(RavenItemGroups.RAVEN_MAIN))
        .setRegistryName(MOD_ID, "debug_container");

    public static final Item DEBUG_ANCHOR_ITEM = new BlockItem(RavenBlocks.DEBUG_ANCHOR, new Item.Properties().group(RavenItemGroups.RAVEN_MAIN))
            .setRegistryName(MOD_ID, "debug_anchor");

    /**
     * 全てのItemをeventの返すRegistryに登録します。
     *
     * @param event Registerイベント
     */
    public static void register(@Nonnull RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            DEBUGGER,
            MANIPULATOR,
            DEBUG_CONTAINER,
            DEBUG_ANCHOR_ITEM
        );
    }
}
