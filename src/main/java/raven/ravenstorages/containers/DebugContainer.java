package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;

import javax.annotation.Nonnull;

public final class DebugContainer extends Container {
    public static DebugContainer createServerSide(int windowId) {
        return new DebugContainer(windowId);
    }

    public static DebugContainer createClientSide(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
        return new DebugContainer(windowId);
    }

    private static final int HOTBAR_SLOT_SIZE = 9;
    private static final int PLAYER_INVENTORY_SLOT_SIZE = 27;
    private static final int INPUT_SLOT_SIZE = 1;
    private static final int OUTPUT_SLOT_SIZE = 1;


    private DebugContainer(int windowId) {
        super(RavenContainers.DEBUG_CONTAINER, windowId);
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
    }
}
