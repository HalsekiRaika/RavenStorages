package raven.ravenstorages.tiles;

import mcp.MethodsReturnNonnullByDefault;
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
import raven.ravenstorages.containers.DebugAnchorContainer;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static raven.ravenstorages.RavenStorages.MOD_ID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
final class DebugAnchorTile extends LockableLootTileEntity {
    private NonNullList<ItemStack> contents;

    DebugAnchorTile() {
        super(RavenTiles.DEBUG_ANCHOR.get());
        this.contents = NonNullList.withSize(9, ItemStack.EMPTY);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(MOD_ID + ".container.debug_anchor");
    }

    @Override
    protected Container createMenu(int id, @Nonnull PlayerInventory player) {
        return DebugAnchorContainer.create(id, player, this);
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);

        this.contents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.contents);
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.contents);
        }

        return compound;
    }

    @Override
    public int getSizeInventory() {
        return this.getItems().size();
    }

    @Override
    public boolean isEmpty() {
        return contents.isEmpty();
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.contents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.contents = NonNullList.withSize(9, ItemStack.EMPTY);

        for (int i = 0; i < itemsIn.size(); i++) {
            if (i < this.contents.size()) {
                this.getItems().set(i, itemsIn.get(i));
            }
        }
    }

}
