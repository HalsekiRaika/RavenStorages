package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

/**
 * RavenStoragesで実装されるBlockの参照を保持するユーティリティクラス。
 */
public final class RavenBlocks {
    private RavenBlocks() {
        throw new AssertionError();
    }

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> DEBUG_CONTAINER = BLOCKS.register("debug_container", DebugContainerBlock::new);
    public static final RegistryObject<Block> DEBUG_ANCHOR = BLOCKS.register("debug_anchor", DebugAnchorBlock::new);
    public static final RegistryObject<Block> INTERFACE = BLOCKS.register("interface", InterfaceBlock::new);
    public static final RegistryObject<Block> CONTROLLER = BLOCKS.register("controller", ControllerBlock::new);
    public static final RegistryObject<Block> READER = BLOCKS.register("reader", ReaderBlock::new);
    public static final RegistryObject<Block> ACCESS_POINT = BLOCKS.register("access_point", AccessPointBlock::new);

    /**
     * 全てのブロックをeventの返すRegistryに登録します
     *
     * @param bus Forgeイベントバス
     */
    public static void register(@Nonnull IEventBus bus) {
        BLOCKS.register(bus);
    }
}
