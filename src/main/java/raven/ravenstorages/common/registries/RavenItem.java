package raven.ravenstorages.common.registries;

import net.minecraft.item.Item;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.items.ItemManipulator;
import raven.ravenstorages.common.registries.registerer.BlockRegisterer;
import raven.ravenstorages.common.registries.registerer.ItemRegisterer;

public class RavenItem {
    private static final ItemRegisterer<Item> ITEM_REGISTERER = new ItemRegisterer<>(Settings.MOD_ID);

    public static Item Manipulator;

    public static void regItem() {
        Manipulator = ITEM_REGISTERER.registry(ItemManipulator.getInstance());
    }

    public static void regBlockItem() {
        BlockRegisterer.getBlockItems().forEach(ITEM_REGISTERER::registry);
    }
}
