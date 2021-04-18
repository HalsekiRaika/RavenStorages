package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;
import raven.ravenstorages.RavenStorages;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public final class DebugContainer extends Container {
    public static DebugContainer createServerSide(int windowId, PlayerInventory playerInventory) {
        return new DebugContainer(windowId, playerInventory);
    }

    public static DebugContainer createClientSide(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
        return new DebugContainer(windowId, playerInventory);
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = 27;
    private static final int MAIN_SLOT_COUNT = 2;
    private static final int INPUT_SLOT_NUMBER = 0;
    private static final int OUTPUT_SLOT_NUMBER = 1;

    private final IItemHandler mainItemHandler;
    private final PlayerMainInvWrapper playerInventoryItemHandler;

    private final List<SlotItemHandler> hotbarSlots;
    private final List<SlotItemHandler> playerInventorySlots;
    private final SlotItemHandler inputSlot;
    private final SlotItemHandler outputSlot;


    private DebugContainer(int windowId, PlayerInventory playerInventory) {
        super(RavenContainers.DEBUG_CONTAINER, windowId);
        mainItemHandler = new ItemStackHandler(MAIN_SLOT_COUNT);
        playerInventoryItemHandler = new PlayerMainInvWrapper(playerInventory);

        hotbarSlots = new ArrayList<>();
        playerInventorySlots = new ArrayList<>();

        for (int slotNumber = 0; slotNumber< HOTBAR_SLOT_COUNT; slotNumber++) {
            SlotItemHandler slot = newSlot(playerInventoryItemHandler, slotNumber);
            this.addSlot(slot);
            hotbarSlots.add(slot);
        }

        for (int i = 0; i<PLAYER_INVENTORY_SLOT_COUNT; i++) {
            int slotNumber = HOTBAR_SLOT_COUNT + i;
            SlotItemHandler slot = newSlot(playerInventoryItemHandler, slotNumber);
            this.addSlot(slot);
            playerInventorySlots.add(slot);
        }

        inputSlot = newSlot(mainItemHandler, INPUT_SLOT_NUMBER);
        outputSlot = newSlot(mainItemHandler, OUTPUT_SLOT_NUMBER);
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        RavenStorages.LOGGER.debug("transferStackInSlot");
        return ItemStack.EMPTY;
    }

    public List<SlotItemHandler> hotbarSlots() {
        return unmodifiableList(hotbarSlots);
    }

    public List<SlotItemHandler> playerInventorySlots() {
        return unmodifiableList(playerInventorySlots);
    }

    public SlotItemHandler inputSlot() {
        return inputSlot;
    }

    public SlotItemHandler getOutputSlot() {
        return outputSlot;
    }

    private static SlotItemHandler newSlot(IItemHandler itemHandler, int index) {
        return new SlotItemHandler(itemHandler, index, 0, 0);
    }
}
