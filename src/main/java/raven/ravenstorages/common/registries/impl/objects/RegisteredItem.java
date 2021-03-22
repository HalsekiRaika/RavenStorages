package raven.ravenstorages.common.registries.impl.objects;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import raven.ravenstorages.common.registries.impl.provider.IRavenItemProvider;
import raven.ravenstorages.common.registries.impl.wrapper.RegistryWrapper;

import javax.annotation.Nonnull;

public class RegisteredItem<T extends Item> extends RegistryWrapper<Item> implements IRavenItemProvider {
    public RegisteredItem(@Nonnull RegistryObject<Item> registryObject) {
        super(registryObject);
    }

    @Nonnull
    @Override
    public Item getItem() {
        return get();
    }
}