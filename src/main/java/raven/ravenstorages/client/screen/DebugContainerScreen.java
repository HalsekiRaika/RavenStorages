package raven.ravenstorages.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import raven.ravenstorages.client.screen.reference.SimpleHopperRef;
import raven.ravenstorages.containers.DebugContainer;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public class DebugContainerScreen extends ContainerScreen<DebugContainer> {
    private final int texX;
    private final int texY;

    public DebugContainerScreen(DebugContainer screenContainer, PlayerInventory playerInventory, ITextComponent title) {
        super(screenContainer, playerInventory, title);
        this.xSize = SimpleHopperRef.TextureUISizeX;
        this.ySize = SimpleHopperRef.TextureUISizeY;
        this.texX  = SimpleHopperRef.TextureFullSizeX;
        this.texY  = SimpleHopperRef.TextureFullSizeY;

        this.passEvents = false;
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(@Nonnull MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.blendColor(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize, this.texX, this.texY);
    }

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/simple_hopper.png");
}
