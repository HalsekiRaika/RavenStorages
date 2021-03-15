package raven.ravenstorages.common.handler;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import raven.ravenstorages.RavenStorages;
import raven.ravenstorages.common.registries.RavenBlock;
import raven.ravenstorages.common.registries.RavenItem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationEventHandler {
    private static final Map<Class<?>, List<IForgeRegistryEntry<?>>> entriesMap = new HashMap<>();

    public void onAttach(IEventBus eventBus) {
        eventBus.addGenericListener(Item.class, this::regItems);
        eventBus.addGenericListener(Block.class, this::regBlocks);
    }

    private void regItems(RegistryEvent.Register<Item> event) {
        RavenStorages.LOGGER.debug("Registration Item.");
        RavenItem.regItem();
        RavenItem.regBlockItem();
        checkout(event.getRegistry().getRegistrySuperType(), event.getRegistry());
    }

    private void regBlocks(RegistryEvent.Register<Block> event) {
        RavenStorages.LOGGER.debug("Registration Block.");
        RavenBlock.regBlock();
        checkout(event.getRegistry().getRegistrySuperType(), event.getRegistry());
    }

    public static <T extends IForgeRegistryEntry<T>> void registration(T entry) {
        Class<T> typeClass = entry.getRegistryType();
        List<IForgeRegistryEntry<?>> entries = entriesMap.computeIfAbsent(typeClass, e -> Lists.newArrayList());
        entries.add(entry);
    }

    public static <T extends IForgeRegistryEntry<T>> List<?> getEntries(Class<T> entryClass) {
        return entriesMap.getOrDefault(entryClass, Collections.emptyList());
    }

    @SuppressWarnings("unchecked")
    private static <T extends IForgeRegistryEntry<T>> void checkout(Class<T> regSuper, IForgeRegistry<T> forgeReg) {
        getEntries(regSuper).forEach(entry -> forgeReg.register((T) entry));
    }
}
