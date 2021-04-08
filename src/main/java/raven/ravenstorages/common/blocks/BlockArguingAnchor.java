package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;
import raven.ravenstorages.common.library.functional.block.IWrenchRetrievable;

// TODO: Make Storage Interface
public class BlockArguingAnchor extends Block implements IWrenchRetrievable, IHasBlockItem {
    public BlockArguingAnchor() {
        super(Properties.create(Material.IRON)
                .doesNotBlockMovement()
                .hardnessAndResistance(4.0f)
                .harvestLevel(0));
    }

    public static BlockArguingAnchor getInstance() {
        return new BlockArguingAnchor();
    }
}
