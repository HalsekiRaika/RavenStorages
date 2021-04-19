package raven.ravenstorages.containers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.items.SlotItemHandler;
import raven.ravenstorages.util.container.screen.SlotPositionHoldingContainerScreen;
import raven.ravenstorages.util.geometry.IntPoint2d;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public class DebugContainerScreen extends SlotPositionHoldingContainerScreen<DebugContainer> {
    public DebugContainerScreen(DebugContainer screenContainer, PlayerInventory playerInventory, ITextComponent title) {
        super(screenContainer, playerInventory, title);
    }

    @Override
    protected Map<Slot, IntPoint2d> calculateSlotPosition() {
        final int SLOT_X_SPACING = 18;
        final int SLOT_Y_SPACING = 18;
        final int HOTBAR_XPOS = 8;
        final int HOTBAR_YPOS = 142;
        final int PLAYER_INVENTORY_XPOS = 8;
        final int PLAYER_INVENTORY_YPOS = 84;

        Map<Slot, IntPoint2d> mapping = new HashMap<>();

        List<SlotItemHandler> hotbarSlots = container.hotbarSlots();
        for(int i=0; i<hotbarSlots.size(); i++) {
            SlotItemHandler slot = hotbarSlots.get(i);
            mapping.put(slot, new IntPoint2d(HOTBAR_XPOS + i*SLOT_X_SPACING, HOTBAR_YPOS));
        }

        List<SlotItemHandler> playerInventorySlots = container.playerInventorySlots();
        for (int y=0; y<3; y++) {
            for(int x=0; x<9; x++) {
                SlotItemHandler slot = playerInventorySlots.get(x+y*9);
                mapping.put(slot, new IntPoint2d(PLAYER_INVENTORY_XPOS + x*SLOT_X_SPACING, PLAYER_INVENTORY_YPOS + y*SLOT_Y_SPACING));
            }
        }

        SlotItemHandler inputSlot = container.inputSlot();
        mapping.put(inputSlot, new IntPoint2d(62, 34));

        SlotItemHandler outputSlot = container.getOutputSlot();
        mapping.put(outputSlot, new IntPoint2d(98, 34));

        return mapping;
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(@Nonnull MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.getMinecraft().getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int edgeSpacingX = (this.width - this.xSize) / 2;
        int edgeSpacingY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, edgeSpacingX, edgeSpacingY, 0, 0, this.xSize, this.ySize);
    }

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/simple_hopper.png");
}
