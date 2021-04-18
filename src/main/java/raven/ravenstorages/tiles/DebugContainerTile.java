package raven.ravenstorages.tiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import raven.ravenstorages.containers.DebugContainer;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

final class DebugContainerTile extends LockableLootTileEntity {
    private NonNullList<ItemStack> contents;

    DebugContainerTile() {
        super(RavenTiles.DEBUG_CONTAINER);
        this.contents = NonNullList.withSize(2, ItemStack.EMPTY);
    }

    @Override
    public void read(@Nonnull BlockState state, @Nonnull CompoundNBT compound) {
        super.read(state, compound);

        this.contents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.contents);
        }
    }

    @Nonnull
    @Override
    public CompoundNBT write(@Nonnull CompoundNBT compound) {
        super.write(compound);

        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.contents);
        }

        return compound;
    }

    @Nonnull
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.contents;
    }

    @Override
    protected void setItems(@Nonnull NonNullList<ItemStack> itemsIn) {
        this.contents = NonNullList.withSize(2, ItemStack.EMPTY);

        for (int i = 0; i < itemsIn.size(); i++) {
            if (i < this.contents.size()) {
                this.getItems().set(i, itemsIn.get(i));
            }
        }
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(MOD_ID + ".container.debug_container");
    }

    @Override
    protected Container createMenu(int id, @Nonnull PlayerInventory player) {
        return DebugContainer.create(id, this, player);
    }

    @Override
    public boolean isEmpty() {
        return this.contents.isEmpty();
    }

    @Override
    public int getSizeInventory() {
        return this.getItems().size();
    }
}
