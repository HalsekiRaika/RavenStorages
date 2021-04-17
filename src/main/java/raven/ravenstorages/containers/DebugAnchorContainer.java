package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class DebugAnchorContainer extends Container {
    private IInventory inventory;

    private final int SLOT_SIZE_LIMIT = 9;
    private final int SLOT_ROW_LIMIT = 3;
    private final int SLOT_COL_LIMIT = 3;
    private final int TEX_X_SIZE = 176;
    private final int TEX_Y_SIZE = 166;
    private final int TEX_X_FULL_SIZE = 256;
    private final int TEX_Y_FULL_SIZE = 256;

    public DebugAnchorContainer(ContainerType<?> containerType, int windowId, IInventory inv, PlayerInventory pInv) {
        super(containerType, windowId);
        assertInventorySize(inv, 9);
        this.inventory = inv;

        inv.openInventory(pInv.player);

        for (int containerSlotRow = 0; containerSlotRow < this.SLOT_ROW_LIMIT; containerSlotRow++) {
            for (int containerSlotCol = 0; containerSlotCol < this.SLOT_COL_LIMIT; containerSlotCol++) {
                this.addSlot(new Slot(inv, containerSlotCol + containerSlotRow * this.SLOT_ROW_LIMIT, 62 + containerSlotCol * 18, 17 + containerSlotRow * 18));
            }
        }

        int leftCol = (this.TEX_X_SIZE - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
                this.addSlot(new Slot(pInv, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, this.TEX_Y_SIZE - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
            this.addSlot(new Slot(pInv, hotbarSlot, leftCol + hotbarSlot * 18, this.TEX_Y_SIZE - 24));
        }
    }

    public static DebugAnchorContainer create(int windowId, PlayerInventory pInv) {
        return new DebugAnchorContainer(RavenDefContainers.DEBUG_ANCHOR_CONTAINER.get(), windowId, new Inventory(9), pInv);
    }

    public static DebugAnchorContainer create(int windowId, PlayerInventory pInv, IInventory inv) {
        return new DebugAnchorContainer(RavenDefContainers.DEBUG_ANCHOR_CONTAINER.get(), windowId, inv, pInv);
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return this.inventory.isUsableByPlayer(playerIn);
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.SLOT_SIZE_LIMIT) {
                if (!this.mergeItemStack(itemstack1, this.SLOT_SIZE_LIMIT, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.SLOT_SIZE_LIMIT, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(@Nonnull PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.inventory.closeInventory(playerIn);
    }

    public int getSlotSizeLimit() { return  this.SLOT_SIZE_LIMIT; }

    public int getTexXSize() {
        return this.TEX_X_SIZE;
    }

    public int getTexYSize() {
        return this.TEX_Y_SIZE;
    }

    public int getTexXFullSize() {
        return this.TEX_X_FULL_SIZE;
    }

    public int getTexYFullSize() {
        return this.TEX_Y_FULL_SIZE;
    }
}
