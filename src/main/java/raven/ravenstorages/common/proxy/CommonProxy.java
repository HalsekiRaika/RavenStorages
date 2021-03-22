package raven.ravenstorages.common.proxy;

import net.minecraftforge.eventbus.api.IEventBus;
import raven.ravenstorages.common.handler.RegistrationEventHandler;

// Basically, don't write any processing directly
// in RavenStorages.java, but use a proxy in between.
public class CommonProxy {
    private RegistrationEventHandler registrationEventHandler;

    public void initialization() {
        this.registrationEventHandler = new RegistrationEventHandler();
    }

    public void attachLifeCycle(IEventBus eventBus) {
        registrationEventHandler.onAttach(eventBus);
    }
}
