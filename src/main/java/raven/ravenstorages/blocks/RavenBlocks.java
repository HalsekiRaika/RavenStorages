package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

/**
 * RavenStoragesで実装されるBlockの参照を保持するユーティリティクラス。
 */
public final class RavenBlocks {
    private RavenBlocks() {
        throw new AssertionError();
    }

    public static final Block DEBUG_ANCHOR = new DebugAnchorBlock().setRegistryName(MOD_ID, "debug_anchor");
    public static final Block DEBUG_CONTAINER = new DebugContainerBlock().setRegistryName(MOD_ID, "debug_container");
    public static final Block INTERFACE = new InterfaceBlock().setRegistryName(MOD_ID, "interface");
    public static final Block CONTROLLER = new ControllerBlock().setRegistryName(MOD_ID, "controller");
    public static final Block READER = new ReaderBlock().setRegistryName(MOD_ID, "reader");
    public static final Block ACCESS_POINT = new AccessPointBlock().setRegistryName(MOD_ID, "access_point");

    /**
     * 全てのブロックをeventの返すRegistryに登録します
     *
     * @param event Registerイベント
     */
    public static void register(@Nonnull RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
            DEBUG_ANCHOR,
            DEBUG_CONTAINER,
            INTERFACE,
            CONTROLLER,
            READER,
            ACCESS_POINT
        );
    }
}
