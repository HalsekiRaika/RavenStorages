package raven.ravenstorages.common.registries.impl.wrapper;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class RegistryComplexLazyWrapper<T extends IForgeRegistryEntry<T>, R extends IForgeRegistryEntry<R>> {
    private final DeferredRegister<T> _internalRegistry;
    private final DeferredRegister<R> __internalRegistry;

    public RegistryComplexLazyWrapper(String modId, IForgeRegistry<T> registryA, IForgeRegistry<R> registryB) {
        this._internalRegistry  = DeferredRegister.create(registryA, modId);
        this.__internalRegistry = DeferredRegister.create(registryB, modId);
    }

    public <E extends T, V extends R, W extends RegistryComplexWrapper<E, V>> W register(
            String name, Supplier<? extends E> supplierA, Supplier<? extends V> supplierB, BiFunction<RegistryObject<E>, RegistryObject<V>, W> objectWrapper) {

        return objectWrapper.apply(_internalRegistry.register(name, supplierA), __internalRegistry.register(name, supplierB));
    }

    public <E extends T, V extends R, W extends RegistryComplexWrapper<E, V>> W register(
            String name, Supplier<? extends E> supplier, Function<E, V> function, BiFunction<RegistryObject<E>, RegistryObject<V>, W> objectWrapper) {

        RegistryObject<E> internal = _internalRegistry.register(name, supplier);
        return objectWrapper.apply(internal , __internalRegistry.register(name, () -> function.apply(internal.get())));
    }

    public void register(IEventBus eventBus) {
        _internalRegistry.register(eventBus);
        __internalRegistry.register(eventBus);
    }

}