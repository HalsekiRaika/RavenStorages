package raven.ravenstorages.common.registries;

import net.minecraftforge.eventbus.api.IEventBus;
import raven.ravenstorages.RavenStorages;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.registries.registerer.BlockRegisterer;

public class RavenBlock {
    public static final BlockRegisterer BLOCK_REGISTERER = new BlockRegisterer(Settings.MOD_ID);

    public static void onRegistration(IEventBus eventBus) {
        RavenStorages.LOGGER.info("Start Block Registration");
        BLOCK_REGISTERER.register(eventBus);
    }
}
