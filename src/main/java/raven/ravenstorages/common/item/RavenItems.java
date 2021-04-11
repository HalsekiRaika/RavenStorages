package raven.ravenstorages.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nonnull;

/**
 * RavenStoragesで実装されるItemの参照を保持するユーティリティクラスです。
 */
public final class RavenItems {
    private RavenItems() {
        throw new AssertionError();
    }

    public static final Item MANIPULATOR = new ManipulatorItem();

    /**
     * 全てのItemをeventの返すRegistryに登録します。
     *
     * @param event Registerイベント
     */
    public static void register(@Nonnull RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            MANIPULATOR
        );
    }
}
