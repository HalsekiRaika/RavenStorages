package raven.ravenstorages.containers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.items.SlotItemHandler;
import raven.ravenstorages.util.container.SlotPositionHoldingContainerScreen;
import raven.ravenstorages.util.geometry.IntPoint2d;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static raven.ravenstorages.RavenStorages.MOD_ID;

final class DebugAnchorScreen extends SlotPositionHoldingContainerScreen<DebugAnchorContainer> {
    DebugAnchorScreen(DebugAnchorContainer container, PlayerInventory pInv, ITextComponent textComponent) {
        super(container, pInv, textComponent);
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(@Nonnull MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.blendColor(1.0f, 1.0f,  1.0f, 1.0f);
        this.getMinecraft().getTextureManager().bindTexture(rLocation);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize);
    }

    private static final ResourceLocation rLocation = new ResourceLocation(MOD_ID, "textures/gui/simple_chest.png");


    @Nonnull
    @Override
    protected Map<Slot, IntPoint2d> calculateSlotPosition(@Nonnull DebugAnchorContainer container) {
        final int HOTBAR_START_POS_X = 8;
        final int HOTBAR_START_POS_Y = 142;
        final int PLAYER_INV_START_POS_X = 8;
        final int PLAYER_INV_START_POS_Y = 84;
        final int CONTAINER_INV_START_POS_X = 62;
        final int CONTAINER_INV_START_POS_Y = 17;

        final int PLAYER_INV_ROW_LIM = 9;
        final int PLAYER_INV_COL_LIM = 3;

        final int CONTAINER_INV_ROW_LIM = 3;
        final int CONTAINER_INV_COL_LIM = 3;

        final int SLOT_SIZE_X = 18;
        final int SLOT_SIZE_Y = 18;

        Map<Slot, IntPoint2d> mappings = new HashMap<>();

        List<SlotItemHandler> hotbarSlots = container.hotbarSlots();
        for (int i = 0; i < hotbarSlots.size(); i++) {
            SlotItemHandler slot = hotbarSlots.get(i);
            mappings.put(slot, new IntPoint2d(HOTBAR_START_POS_X + i * SLOT_SIZE_X, HOTBAR_START_POS_Y));
        }

        List<SlotItemHandler> pInvSlots = container.playerInventorySlots();
        for (int x = 0; x < PLAYER_INV_ROW_LIM; x++) {
            for (int y = 0; y < PLAYER_INV_COL_LIM; y++) {
                SlotItemHandler slot = pInvSlots.get(x + y * PLAYER_INV_ROW_LIM);
                mappings.put(slot, new IntPoint2d(
                        PLAYER_INV_START_POS_X + x * SLOT_SIZE_X,
                        PLAYER_INV_START_POS_Y + y * SLOT_SIZE_Y));
            }
        }

        List<SlotItemHandler> containerInvSlots = container.containerInventorySlots();
        for (int x = 0; x < CONTAINER_INV_ROW_LIM; x++) {
            for (int y = 0; y < CONTAINER_INV_COL_LIM; y++) {
                SlotItemHandler slot = containerInvSlots.get(x + y * CONTAINER_INV_ROW_LIM);
                mappings.put(slot, new IntPoint2d(
                        CONTAINER_INV_START_POS_X + x * SLOT_SIZE_X,
                        CONTAINER_INV_START_POS_Y + y * SLOT_SIZE_Y));
            }
        }

        return mappings;
    }
}
