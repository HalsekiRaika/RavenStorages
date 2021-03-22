package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;
import raven.ravenstorages.common.library.functional.block.IWrenchRetrievable;

public class BlockDebugAnchor extends Block implements IWrenchRetrievable, IHasBlockItem {
    public BlockDebugAnchor() {
        super(Properties.create(Material.IRON));
    }

    public static BlockDebugAnchor getInstance() {
        return new BlockDebugAnchor();
    }
}
