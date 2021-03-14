package raven.ravenstorages.common.library.base;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BaseBlockItem<T extends Block> extends BlockItem {
    private final T Block;

    public BaseBlockItem(T blockIn, Item.Properties builder) {
        super(blockIn, builder);
        this.Block = blockIn;
    }

    public T getInstance() {
        return Block;
    }
}
