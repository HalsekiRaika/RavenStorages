package raven.ravenstorages.common.registries.handler;

import net.minecraftforge.eventbus.api.IEventBus;
import raven.ravenstorages.common.registries.RavenItem;

public class RegistrationHandler {
    public static void onRegistration(IEventBus eventBus) {
        RavenItem.onRegistration(eventBus);
    }
}
