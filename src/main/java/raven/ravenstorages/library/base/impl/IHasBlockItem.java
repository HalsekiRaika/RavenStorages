package raven.ravenstorages.library.base.impl;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import raven.ravenstorages.RavenStorages;
import raven.ravenstorages.library.base.BaseBlockItem;
import raven.ravenstorages.library.exceptions.RavenRegisterException;

public interface IHasBlockItem {
    default Class<? extends BlockItem> getBlockItem() {
        return BaseBlockItem.class;
    }

    default BlockItem genBlockItem(Item.Properties properties) {
        Class<?> base = getBlockItem();
        try {
            RavenStorages.LOGGER.debug("Auto generate BlockItem instance :: Class / " + base.getSimpleName());
            return (BlockItem) base.getConstructor(Block.class, Item.Properties.class)
                    .newInstance(this, properties);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RavenRegisterException("Cannot generate BlockItem instance... " +
                    "Cause Class:: " + base.getSimpleName());
        }
    }
}
