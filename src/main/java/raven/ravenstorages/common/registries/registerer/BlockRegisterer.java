package raven.ravenstorages.common.registries.registerer;

import com.google.common.base.CaseFormat;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import raven.ravenstorages.common.handler.RegistrationEventHandler;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;

import java.util.ArrayList;
import java.util.List;

public class BlockRegisterer<T extends Block> {
    private static final List<IHasBlockItem> blockItems = new ArrayList<>();
    private final String modId;

    public BlockRegisterer(String modId) {
        this.modId = modId;
    }

    public T registry(T block) {
        Class<?> blockClass = block.getClass();
        // Cut class name prefix (e.g. BlockOperator -> Operator)
        String resourceName = blockClass.getSimpleName().substring(5);
               resourceName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, resourceName);
        return registry(block, new ResourceLocation(modId, resourceName));
    }

    public T registry(T block, ResourceLocation rLocation) {
        block.setRegistryName(rLocation);
        RegistrationEventHandler.registration(block);
        if (block instanceof IHasBlockItem){
            blockItems.add((IHasBlockItem) block);
        }
        return block;
    }

    public static List<IHasBlockItem> getBlockItems() {
        return blockItems;
    }
}
