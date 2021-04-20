package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nonnull;

final class DebugContainerProvider implements INamedContainerProvider {
    private final ITextComponent displayName;

    DebugContainerProvider() {
        this.displayName = new StringTextComponent("Debug Container");
    }

    @Override
    @Nonnull
    public ITextComponent getDisplayName() {
        return displayName;
    }

    @Override
    @Nonnull
    public Container createMenu(int windowID, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return DebugContainer.createServerSide(windowID, playerInventory);
    }
}
