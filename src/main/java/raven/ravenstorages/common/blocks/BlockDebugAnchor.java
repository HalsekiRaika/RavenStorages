package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;

public class BlockDebugAnchor extends Block implements IHasBlockItem {
    public BlockDebugAnchor() {
        super(Properties.create(Material.IRON));
    }

    public static BlockDebugAnchor getInstance() {
        return new BlockDebugAnchor();
    }
}
