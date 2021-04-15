package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.library.base.impl.IHasBlockItem;
import raven.ravenstorages.library.functional.block.IWrenchRetrievable;

//TODO ブロックの正式名称の決定
public final class ReaderBlock extends Block implements IWrenchRetrievable, IHasBlockItem {
    ReaderBlock() {
        super(Properties.create(Material.IRON)
                .doesNotBlockMovement()
                .hardnessAndResistance(4.0f)
                .harvestLevel(0));
    }
}
