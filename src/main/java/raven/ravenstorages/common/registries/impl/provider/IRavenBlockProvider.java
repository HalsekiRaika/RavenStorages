package raven.ravenstorages.common.registries.impl.provider;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
@Deprecated
public interface IRavenBlockProvider extends IRavenItemProvider {
    @Nonnull
    Block getBlock();

    default boolean blockMatches(ItemStack otherStack) {
        Item item = otherStack.getItem();
        return item instanceof BlockItem && blockMatches(((BlockItem) item).getBlock());
    }

    default boolean blockMatches(Block other) {
        return getBlock().equals(other);
    }

    default ResourceLocation getRegistryName() {
        return getBlock().getRegistryName();
    }
}