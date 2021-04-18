package raven.ravenstorages.containers;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public class RavenDefContainers {
    private static final DeferredRegister<ContainerType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);

    public static final RegistryObject<ContainerType<DebugAnchorContainer>> DEBUG_ANCHOR_CONTAINER
            = CONTAINER.register("debug_anchor", () -> new ContainerType<>(DebugAnchorContainer::create));

    public static void onRegistration(IEventBus eventBus) {
        CONTAINER.register(eventBus);
    }
}
