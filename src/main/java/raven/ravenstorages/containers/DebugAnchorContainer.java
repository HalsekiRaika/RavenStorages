package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;
import raven.ravenstorages.util.container.SlotPositionLessContainer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DebugAnchorContainer extends SlotPositionLessContainer {
    public static DebugAnchorContainer createServerSide(int windowId, PlayerInventory pInv) {
        return new DebugAnchorContainer(windowId, pInv);
    }

    public static DebugAnchorContainer createClientSide(int windowId, PlayerInventory pInv, PacketBuffer exData) {
        return new DebugAnchorContainer(windowId, pInv);
    }

    private static final int PLAYER_HOTBAR_INV_SIZE = 9;
    private static final int PLAYER_INV_SIZE = 27;
    private static final int CONTAINER_INV_SIZE = 9;

    private final IItemHandler containerItemHandler;
    private final PlayerMainInvWrapper pInvItemHandler;

    private final List<SlotItemHandler> hotBarInv;
    private final List<SlotItemHandler> playerInv;
    private final List<SlotItemHandler> containerInv;

    private DebugAnchorContainer(int windowId, PlayerInventory pInv) {
        super(RavenContainers.DEBUG_ANCHOR.get(), windowId);
        this.containerItemHandler = new ItemStackHandler(CONTAINER_INV_SIZE);
        this.pInvItemHandler      = new PlayerMainInvWrapper(pInv);
        this.hotBarInv    = new ArrayList<>();
        this.playerInv    = new ArrayList<>();
        this.containerInv = new ArrayList<>();

        for (int addSlotNum = 0; addSlotNum < PLAYER_HOTBAR_INV_SIZE; addSlotNum++) {
            SlotItemHandler handler = posLessSlot(pInvItemHandler, addSlotNum);
            this.addSlot(handler);
            hotBarInv.add(handler);
        }

        for (int addSlotNum = 0; addSlotNum < PLAYER_INV_SIZE; addSlotNum++) {
            SlotItemHandler handler = posLessSlot(pInvItemHandler, addSlotNum + PLAYER_HOTBAR_INV_SIZE);
            this.addSlot(handler);
            playerInv.add(handler);
        }

        for (int addSlotNum = 0; addSlotNum < CONTAINER_INV_SIZE; addSlotNum++) {
            SlotItemHandler handler = posLessSlot(pInvItemHandler, addSlotNum + PLAYER_INV_SIZE + PLAYER_HOTBAR_INV_SIZE);
            this.addSlot(handler);
            containerInv.add(handler);
        }
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull PlayerEntity playerIn, int index) {
        Slot sourceSlot = inventorySlots.get(index);
        if(sourceSlot == null || !sourceSlot.getHasStack()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getStack();
        ItemStack copy = sourceStack.copy();

        if(isPlayerInventory(index))
            if(!mergeItemStack(sourceStack, 36, 45, false)) return ItemStack.EMPTY;

        if(isContainerSlot(index)) if(!mergeItemStack(sourceStack, 0, 35, false))
            return ItemStack.EMPTY;

        if(sourceStack.getCount() == 0) {
            sourceSlot.putStack(ItemStack.EMPTY);
        } else {
            sourceSlot.onSlotChanged();
        }

        sourceSlot.onTake(playerIn, sourceStack);
        return copy;
    }

    private boolean isPlayerInventory(int index) {
        return 0 <= index && index <= 35;
    }

    private boolean isContainerSlot(int index) {
        return index == 36 || index == 45;
    }

    public List<SlotItemHandler> hotbarSlots() {
        return Collections.unmodifiableList(hotBarInv);
    }

    public List<SlotItemHandler> playerInventorySlots() {
        return Collections.unmodifiableList(playerInv);
    }

    public List<SlotItemHandler> containerInventorySlots() {
        return Collections.unmodifiableList(containerInv);
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
    }

    private static SlotItemHandler posLessSlot(IItemHandler itemHandler, int index) {
        return new SlotItemHandler(itemHandler, index, 0, 0);
    }
}
