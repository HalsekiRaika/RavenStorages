package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import raven.ravenstorages.containers.RavenContainers;
import raven.ravenstorages.library.base.impl.IHasBlockItem;
import raven.ravenstorages.library.functional.block.IWrenchRetrievable;
import raven.ravenstorages.tiles.RavenTiles;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
final class DebugAnchorBlock extends Block implements IWrenchRetrievable, IHasBlockItem {
    DebugAnchorBlock() {
        super(Properties.create(Material.IRON));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RavenTiles.DEBUG_ANCHOR.get().create();
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(worldIn.isRemote()) return ActionResultType.SUCCESS;
        if(!(player instanceof ServerPlayerEntity)) return ActionResultType.FAIL;

        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        NetworkHooks.openGui(serverPlayer, RavenContainers.DEBUG_ANCHOR_PROVIDER);

        return ActionResultType.SUCCESS;
    }
}
