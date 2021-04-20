package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import raven.ravenstorages.containers.RavenContainers;

import javax.annotation.Nonnull;

final class DebugContainerBlock extends Block {
    DebugContainerBlock() {
        super(Properties.create(Material.IRON));
    }

    @SuppressWarnings("deprecation")
    @Override
    @Nonnull
    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        if(worldIn.isRemote()) return ActionResultType.SUCCESS;
        if(!(player instanceof ServerPlayerEntity)) return ActionResultType.FAIL;

        ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
        NetworkHooks.openGui(serverPlayer, RavenContainers.DEBUG_CONTAINER_PROVIDER);

        return ActionResultType.SUCCESS;
    }
}