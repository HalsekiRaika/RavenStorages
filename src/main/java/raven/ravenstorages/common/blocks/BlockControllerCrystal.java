package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raven.ravenstorages.common.library.base.impl.IHasBlockItem;
import raven.ravenstorages.common.library.functional.block.IWrenchRetrievable;

// TODO: Make Controller
public class BlockControllerCrystal extends Block implements IWrenchRetrievable, IHasBlockItem {
    public BlockControllerCrystal() {
        super(Properties.create(Material.IRON)
                .doesNotBlockMovement()
                .hardnessAndResistance(4.0f)
                .harvestLevel(0));
    }

    public static BlockControllerCrystal getInstance() {
        return new BlockControllerCrystal();
    }
}
