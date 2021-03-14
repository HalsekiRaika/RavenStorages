package raven.ravenstorages.common.registries.registerer;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.registries.ForgeRegistries;
import raven.ravenstorages.common.registries.impl.objects.RegisteredItem;
import raven.ravenstorages.common.registries.impl.provider.IRavenItemProvider;
import raven.ravenstorages.common.registries.impl.wrapper.RegistryLazyWrapper;
import raven.ravenstorages.common.tabs.TabMain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Deprecated
public class ItemRegisterer extends RegistryLazyWrapper<Item> {
    private static final List<IRavenItemProvider> items = new ArrayList<>();

    public ItemRegisterer(String modId) {
        super(modId, ForgeRegistries.ITEMS);
    }

    public RegisteredItem<Item> registry(String name) {
        return registry(name, Item::new);
    }

    public RegisteredItem<Item> registry(String name, Rarity rarity) {
        return registry(name, properties -> new Item(properties.rarity(rarity)));
    }

    public <T extends Item> RegisteredItem<T> registry(String name, Function<Item.Properties, T> sup) {
        return registry(name, () -> sup.apply(getBaseProperties()));
    }

    public <T extends Item> RegisteredItem<T> registry(String name, Supplier<? extends T> sup) {
        RegisteredItem<T> registeredItem = register(name, sup, RegisteredItem::new);
        items.add(registeredItem);
        return registeredItem;
    }

    public static Item.Properties getBaseProperties() {
        return new Item.Properties().group(TabMain.INSTANCE);
    }

    public static List<IRavenItemProvider> getItems() {
        return items;
    }
}