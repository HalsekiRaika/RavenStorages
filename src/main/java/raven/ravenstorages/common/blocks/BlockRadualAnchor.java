package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;
import raven.ravenstorages.common.library.functional.block.IWrenchRetrievable;

// TODO: Make Reader.
public class BlockRadualAnchor extends Block implements IWrenchRetrievable, IHasBlockItem {
    public BlockRadualAnchor() {
        super(Properties.create(Material.IRON)
                .doesNotBlockMovement()
                .hardnessAndResistance(4.0f)
                .harvestLevel(0));
    }

    public static BlockRadualAnchor getInstance() {
        return new BlockRadualAnchor();
    }
}
