package raven.ravenstorages.containers;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.network.IContainerFactory;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class RavenContainers {
    private RavenContainers() { throw new AssertionError(); }

    //public static final ContainerType<DebugContainer> DEBUG_CONTAINER = create(DebugContainer::createClientSide, "debug_container");

    public static void register(@Nonnull RegistryEvent.Register<ContainerType<?>> event) {
        //event.getRegistry().registerAll(DEBUG_CONTAINER);
    }
    private static <T extends Container> ContainerType<T> create(@Nonnull IContainerFactory<T> factory, @Nonnull String name) {
        ContainerType<T> type = IForgeContainerType.create(factory);
        type.setRegistryName(MOD_ID, name);
        return type;
    }
}
