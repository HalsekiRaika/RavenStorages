package raven.ravenstorages.common.registries.impl.wrapper;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Function;
import java.util.function.Supplier;

public class RegistryLazyWrapper <T extends IForgeRegistryEntry<T>> {
    protected final DeferredRegister<T> internalRegister;

    protected RegistryLazyWrapper(String modId, IForgeRegistry<T> registry) {
        this.internalRegister = DeferredRegister.create(registry, modId);
    }

    protected RegistryLazyWrapper(String modId, Class<T> registry) {
        this.internalRegister = DeferredRegister.create(registry, modId);
    }

    protected <I extends T, W extends RegistryWrapper<I>> W register(
            String name, Supplier<? extends I> sup, Function<RegistryObject<I>, W> objectWrapper) {
        return objectWrapper.apply(internalRegister.register(name, sup));
    }

    public void Register(IEventBus eventBus) {
        internalRegister.register(eventBus);
    }
}