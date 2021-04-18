package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.PlayerInvWrapper;
import raven.ravenstorages.client.screen.reference.SimpleHopperRef;

import javax.annotation.Nonnull;

public final class DebugContainer extends Container {
    public static DebugContainer createServerSide(int windowId, PlayerInventory playerInventory) {
        return create(windowId, playerInventory);
    }

    public static DebugContainer createClientSide(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
        return create(windowId, playerInventory);
    }

    public static DebugContainer create(int windowId, PlayerInventory pInv) {
        return new DebugContainer(windowId, new Inventory(2), pInv);
    }

    public static DebugContainer create(int windowId, IInventory inv, PlayerInventory pInv) {
        return new DebugContainer(windowId, inv, pInv);
    }

    private static final int HOTBAR_SLOT_SIZE = 9;
    private static final int PLAYER_INVENTORY_SLOT_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_SLOT_COLUMN_COUNT = 9;
    private static final int INPUT_SLOT_SIZE = 1;
    private static final int OUTPUT_SLOT_SIZE = 1;
    private static final int INPUT_SLOT_INDEX = 0;
    private static final int OUTPUT_SLOT_INDEX = 1;


    private DebugContainer(int windowId, IInventory inv, PlayerInventory playerInventory) {
        super(RavenDefContainers.DEBUG_CONTAINER.get(), windowId);

        assertInventorySize(inv, 2);

        /*
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
        */

        this.addSlot(new Slot(inv, INPUT_SLOT_INDEX,  SimpleHopperRef.LeftSlotPosX,  SimpleHopperRef.LeftSlotPosY));
        this.addSlot(new Slot(inv, OUTPUT_SLOT_INDEX, SimpleHopperRef.RightSlotPosX, SimpleHopperRef.RightSlotPosY));

        int leftCol = (SimpleHopperRef.TextureUISizeX - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
                this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, SimpleHopperRef.TextureUISizeY - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
            this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, SimpleHopperRef.TextureUISizeY - 24));
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
    }
}
