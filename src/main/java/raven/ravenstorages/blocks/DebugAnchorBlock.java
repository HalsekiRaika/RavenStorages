package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.library.base.impl.IHasBlockItem;
import raven.ravenstorages.library.functional.block.IWrenchRetrievable;

public final class DebugAnchorBlock extends Block implements IWrenchRetrievable, IHasBlockItem {
    DebugAnchorBlock() {
        super(Properties.create(Material.IRON));
    }
}
