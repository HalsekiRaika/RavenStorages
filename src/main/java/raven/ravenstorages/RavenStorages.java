package raven.ravenstorages;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raven.ravenstorages.client.ClientProxy;
import raven.ravenstorages.common.proxy.CommonProxy;

@Mod(Settings.MOD_ID)
public class RavenStorages {
    public static final Logger LOGGER = LogManager.getLogger();

    private final CommonProxy proxy;

    public RavenStorages() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        this.proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        this.proxy.initialization();
        this.proxy.attachLifeCycle(eventBus);
    }
}
