package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import raven.ravenstorages.containers.DebugContainer;
import raven.ravenstorages.tiles.RavenTiles;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class DebugContainerBlock extends Block {
    DebugContainerBlock() {
        super(Properties.create(Material.IRON)
            .doesNotBlockMovement()
            .hardnessAndResistance(4.0f)
            .harvestLevel(0));
    }

    @Override
    @Nonnull
    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        if(worldIn.isRemote()) return ActionResultType.PASS;
        if(!(player instanceof ServerPlayerEntity)) return ActionResultType.FAIL;

        ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
        INamedContainerProvider namedContainerProvider = this.getContainer(state, worldIn, pos);

        if (namedContainerProvider != null) {
            NetworkHooks.openGui(serverPlayer, namedContainerProvider);
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RavenTiles.DEBUG_CONTAINER.create();
    }

    @Nullable
    @Override
    public INamedContainerProvider getContainer(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity instanceof INamedContainerProvider ? (INamedContainerProvider) tileentity : null;
    }

    /*
    @Nonnull
    @Override
    public Container createMenu(int windowID, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return DebugContainer.create(windowID, playerInventory);
    }
    */

}