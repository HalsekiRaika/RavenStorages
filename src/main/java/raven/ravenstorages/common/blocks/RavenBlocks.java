package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nonnull;

import static raven.ravenstorages.Settings.MOD_ID;

/**
 * RavenStoragesで実装されるBlockの参照を保持するユーティリティクラス。
 */
public final class RavenBlocks {
    private RavenBlocks() {
        throw new AssertionError();
    }

    public static final Block INTERFACE_CRYSTAL = new InterfaceCrystalBlock().setRegistryName(MOD_ID, "interface_crystal");

    /**
     * 全てのブロックをeventの返すRegisterに登録します
     *
     * @param event Registerイベント
     */
    public static void register(@Nonnull RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
            INTERFACE_CRYSTAL
        );
    }
}
