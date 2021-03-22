package raven.ravenstorages.common.registries.impl.wrapper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;
import raven.ravenstorages.common.registries.impl.wrapper.interfaces.IHasNamedEntry;

import javax.annotation.Nonnull;

public class RegistryComplexWrapper<T extends IForgeRegistryEntry<? super T>,
        R extends IForgeRegistryEntry<? super R>> implements IHasNamedEntry {

    private final RegistryObject<T> registryObjectA;
    private final RegistryObject<R> registryObjectB;

    public RegistryComplexWrapper(RegistryObject<T> registryObjectA, RegistryObject<R> registryObjectB) {
        this.registryObjectA = registryObjectA;
        this.registryObjectB = registryObjectB;
    }

    @Nonnull
    public T getRegistryA() {
        return registryObjectA.get();
    }

    @Nonnull
    public R getRegistryB() {
        return registryObjectB.get();
    }

    @Override
    public String getLocalizeName() {
        return registryObjectA.getId().getPath();
    }
}
