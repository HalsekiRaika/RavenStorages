package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import raven.ravenstorages.tiles.RavenTiles;

import javax.annotation.Nullable;

final class AccessPointBlock extends Block {
    AccessPointBlock() {
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
        return RavenTiles.ACCESS_POINT.create();
    }
}
