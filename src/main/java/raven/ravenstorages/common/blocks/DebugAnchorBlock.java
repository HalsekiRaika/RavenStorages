package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;
import raven.ravenstorages.common.library.functional.block.IWrenchRetrievable;

public final class DebugAnchorBlock extends Block implements IWrenchRetrievable, IHasBlockItem {
    DebugAnchorBlock() {
        super(Properties.create(Material.IRON));
    }
}
