package raven.ravenstorages.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import raven.ravenstorages.common.blocks.tiles.RavenTiles;

import javax.annotation.Nullable;

//TODO ブロックの正式名称の決定
public final class InterfaceCrystalBlock extends Block {
    InterfaceCrystalBlock() {
        super(Properties.create(Material.IRON));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RavenTiles.INTERFACE_CRYSTAL.create();
    }
}
