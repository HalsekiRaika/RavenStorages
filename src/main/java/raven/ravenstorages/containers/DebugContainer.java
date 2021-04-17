package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.PlayerInvWrapper;

import javax.annotation.Nonnull;

public final class DebugContainer extends Container {
    public static DebugContainer createServerSide(int windowId, PlayerInventory playerInventory) {
        return new DebugContainer(windowId, playerInventory);
    }

    public static DebugContainer createClientSide(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
        return new DebugContainer(windowId, playerInventory);
    }

    private static final int HOTBAR_SLOT_SIZE = 9;
    private static final int PLAYER_INVENTORY_SLOT_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_SLOT_COLUMN_COUNT = 9;
    private static final int INPUT_SLOT_SIZE = 1;
    private static final int OUTPUT_SLOT_SIZE = 1;


    private DebugContainer(int windowId, PlayerInventory playerInventory) {
        super(RavenContainers.DEBUG_CONTAINER, windowId);

        PlayerInvWrapper playerInventoryItemHandler = new PlayerInvWrapper(playerInventory);

        final int SLOT_X_SPACING = 18;
        final int SLOT_Y_SPACING = 18;
        final int HOTBAR_XPOS = 8;
        final int HOTBAR_YPOS = 142;
        final int PLAYER_INVENTORY_XPOS = 8;
        final int PLAYER_INVENTORY_YPOS = 84;

        int slotNumber = 0;

        for (int i=0; i<HOTBAR_SLOT_SIZE; i++)
            this.addSlot(new SlotItemHandler(playerInventoryItemHandler, slotNumber++, HOTBAR_XPOS + SLOT_X_SPACING * i, HOTBAR_YPOS));

        for (int y=0; y<PLAYER_INVENTORY_SLOT_ROW_COUNT; y++) {
            for (int x = 0; x < PLAYER_INVENTORY_SLOT_COLUMN_COUNT; x++) {
                this.addSlot(new SlotItemHandler(
                    playerInventoryItemHandler,
                    slotNumber++,
                    PLAYER_INVENTORY_XPOS + SLOT_X_SPACING*x,
                    PLAYER_INVENTORY_YPOS + SLOT_Y_SPACING*y
                ));
            }
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
    }
}
