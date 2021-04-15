package raven.ravenstorages.library.base;

import net.minecraft.item.Item;

public class BaseItem<T extends Item> extends Item {
    private final T item;

    public BaseItem(T item, Properties properties) {
        super(properties);
        this.item = item;
    }

    public T getInstance() {
        return item;
    }
}
