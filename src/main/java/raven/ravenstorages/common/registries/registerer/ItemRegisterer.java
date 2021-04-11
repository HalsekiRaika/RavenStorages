package raven.ravenstorages.common.registries.registerer;

import com.google.common.base.CaseFormat;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import raven.ravenstorages.common.handler.RegistrationEventHandler;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;
import raven.ravenstorages.common.itemgroup.RavenItemGroups;

import java.util.Objects;

public class ItemRegisterer<T extends Item> {
    private final String modId;

    public ItemRegisterer(String modId) {
        this.modId = modId;
    }

    public T registry(T item) {
        Class<?> blockClass = item.getClass();
        // Cut class name prefix (e.g. ItemOperator -> Operator)
        String resourceName = blockClass.getSimpleName().substring(4);
               resourceName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, resourceName);
        return registry(item, new ResourceLocation(modId, resourceName));
    }

    public T registry(T item, ResourceLocation rLocation) {
        item.setRegistryName(rLocation);
        RegistrationEventHandler.registration(item);
        return item;
    }

    public void registry(IHasBlockItem block) {
        BlockItem blockItem = block.genBlockItem(getDefaultBlockItemProperties());
        blockItem.setRegistryName(Objects.requireNonNull(blockItem.getBlock().getRegistryName()));
        RegistrationEventHandler.registration(blockItem);
    }

    private static Item.Properties getDefaultBlockItemProperties() {
        Item.Properties properties = new Item.Properties();
        properties.group(RavenItemGroups.RAVEN_MAIN);
        return properties;
    }
}
