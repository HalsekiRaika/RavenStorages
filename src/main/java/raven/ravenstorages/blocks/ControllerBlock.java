package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import raven.ravenstorages.tiles.RavenTiles;
import raven.ravenstorages.library.base.impl.IHasBlockItem;
import raven.ravenstorages.library.functional.block.IWrenchRetrievable;

import javax.annotation.Nullable;

//TODO ブロックの正式名称の決定
final class ControllerBlock extends Block implements IWrenchRetrievable, IHasBlockItem {
    ControllerBlock() {
        super(Properties.create(Material.IRON)
                .doesNotBlockMovement()
                .hardnessAndResistance(4.0f)
                .harvestLevel(0));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RavenTiles.CONTROLLER.get().create();
    }
}
