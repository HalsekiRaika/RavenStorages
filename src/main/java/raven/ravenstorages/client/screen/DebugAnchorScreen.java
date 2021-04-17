package raven.ravenstorages.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import raven.ravenstorages.containers.DebugAnchorContainer;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public class DebugAnchorScreen extends ContainerScreen<DebugAnchorContainer> implements IHasContainer<DebugAnchorContainer> {
    private final int texX;
    private final int texY;
    private final ResourceLocation rLocation = new ResourceLocation(MOD_ID, "textures/gui/simple_chest.png");

    public DebugAnchorScreen(DebugAnchorContainer container, PlayerInventory pInv, ITextComponent textComponent) {
        super(container, pInv, textComponent);
        this.xSize = container.getTexXSize();
        this.ySize = container.getTexYSize();
        this.texX  = container.getTexXFullSize();
        this.texY  = container.getTexYFullSize();

        this.passEvents = false;
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(@Nonnull MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.blendColor(1.0f, 1.0f,  1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(rLocation);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize, this.texX, this.texY);
    }

}
