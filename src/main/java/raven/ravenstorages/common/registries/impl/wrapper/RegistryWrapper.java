package raven.ravenstorages.common.registries.impl.wrapper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;
import raven.ravenstorages.common.registries.impl.wrapper.interfaces.IHasNamedEntry;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class RegistryWrapper<T extends IForgeRegistryEntry<? super T>> implements Supplier<T>, IHasNamedEntry {
    @Nonnull
    protected RegistryObject<T> registryObject;

    protected RegistryWrapper(@Nonnull RegistryObject<T> registryObject) {
        this.registryObject = registryObject;
    }

    @Nonnull
    @Override
    public T get() {
        return registryObject.get();
    }

    @Override
    public String getLocalizeName() {
        return registryObject.getId().getPath();
    }
}