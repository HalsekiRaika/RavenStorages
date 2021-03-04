package raven.ravenstorages;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raven.ravenstorages.common.registries.handler.RegistrationHandler;

@Mod(Settings.MOD_ID)
public class RavenStorages {
    public static final Logger LOGGER = LogManager.getLogger();

    public RavenStorages() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegistrationHandler.onRegistration(eventBus);
    }
}
