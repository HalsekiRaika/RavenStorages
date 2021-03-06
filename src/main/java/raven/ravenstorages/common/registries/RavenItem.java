package raven.ravenstorages.common.registries;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import raven.ravenstorages.RavenStorages;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.items.ItemManipulator;
import raven.ravenstorages.common.registries.impl.objects.RegisteredItem;
import raven.ravenstorages.common.registries.registerer.ItemRegisterer;

public class RavenItem {
    private static final ItemRegisterer ITEM_REGISTERER = new ItemRegisterer(Settings.MOD_ID);

    public static final RegisteredItem<Item> MANIPULATOR = ITEM_REGISTERER.registry("manipulator", ItemManipulator::new);

    public static void onRegistration(IEventBus eventBus) {
        RavenStorages.LOGGER.info("Start Item Registration");
        ITEM_REGISTERER.register(eventBus);
    }
}
