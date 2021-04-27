package raven.ravenstorages.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public class DebugAnchorContainerProvider implements INamedContainerProvider {
    private final ITextComponent displayName;

    DebugAnchorContainerProvider() {
        this.displayName = new TranslationTextComponent(MOD_ID + ".container.debug_anchor");
    }

    @Override
    @Nonnull
    public ITextComponent getDisplayName() {
        return displayName;
    }

    @Override
    @Nonnull
    public Container createMenu(int windowID, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return DebugAnchorContainer.createServerSide(windowID, playerInventory);
    }
}
