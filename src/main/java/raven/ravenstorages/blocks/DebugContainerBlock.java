package raven.ravenstorages.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import raven.ravenstorages.containers.DebugContainer;

import javax.annotation.Nonnull;

final class DebugContainerBlock extends Block implements INamedContainerProvider {
    DebugContainerBlock() {
        super(Properties.create(Material.IRON));
    }

    @SuppressWarnings("deprecation")
    @Override
    @Nonnull
    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        if(worldIn.isRemote()) return ActionResultType.PASS;
        if(!(player instanceof ServerPlayerEntity)) return ActionResultType.FAIL;

        ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
        NetworkHooks.openGui(serverPlayer, this);

        return ActionResultType.SUCCESS;
    }

    @Nonnull
    @Override
    public Container createMenu(int windowID, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return DebugContainer.createServerSide(windowID, playerInventory);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("DebugContainer");
    }
}