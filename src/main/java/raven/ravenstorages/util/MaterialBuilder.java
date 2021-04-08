package raven.ravenstorages.util;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

import javax.annotation.Nonnull;

public final class MaterialBuilder {
    private MaterialColor color;
    private boolean isLiquid;
    private boolean isSolid;
    private boolean blocksMovement;
    private boolean isOpaque;
    private boolean flammable;
    private boolean replaceable;
    private PushReaction pushReaction;

    public MaterialBuilder() {
        color = MaterialColor.AIR;
        pushReaction = PushReaction.NORMAL;
    }

    public void setColor(@Nonnull MaterialColor color) {
        this.color = color;
    }

    public void setLiquid(boolean liquid) {
        isLiquid = liquid;
    }

    public void setSolid(boolean solid) {
        isSolid = solid;
    }

    public void setBlocksMovement(boolean blocksMovement) {
        this.blocksMovement = blocksMovement;
    }

    public void setOpaque(boolean opaque) {
        isOpaque = opaque;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public void setReplaceable(boolean replaceable) {
        this.replaceable = replaceable;
    }

    public void setPushReaction(@Nonnull PushReaction pushReaction) {
        this.pushReaction = pushReaction;
    }

    @Nonnull
    public Material build() {
        return new Material(color, isLiquid, isSolid, blocksMovement, isOpaque, flammable, replaceable, pushReaction);
    }
}
