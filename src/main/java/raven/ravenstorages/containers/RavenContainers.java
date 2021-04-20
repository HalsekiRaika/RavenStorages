package raven.ravenstorages.containers;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class RavenContainers {
    private RavenContainers() { throw new AssertionError(); }

    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);

    public static final RegistryObject<ContainerType<DebugContainer>> DEBUG_CONTAINER = CONTAINERS.register("debug_container", create(DebugContainer::createClientSide));

    public static final INamedContainerProvider DEBUG_CONTAINER_PROVIDER = new DebugContainerProvider();

    public static void register(@Nonnull IEventBus modEventBus) {
        CONTAINERS.register(modEventBus);
        modEventBus.addListener(RavenContainers::registerScreen);
    }

    private static void registerScreen(@Nonnull FMLClientSetupEvent event) {
        ScreenManager.registerFactory(DEBUG_CONTAINER.get(), DebugContainerScreen::new);
    }

    @Nonnull
    private static <T extends Container> Supplier<ContainerType<T>> create(@Nonnull IContainerFactory<T> clientContainerFactory) {
        return () -> IForgeContainerType.create(clientContainerFactory);
    }
}
