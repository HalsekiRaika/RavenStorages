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

    public MaterialBuilder setColor(@Nonnull MaterialColor color) {
        this.color = color;
        return this;
    }

    public MaterialBuilder setLiquid(boolean liquid) {
        isLiquid = liquid;
        return this;
    }

    public MaterialBuilder setSolid(boolean solid) {
        isSolid = solid;
        return this;
    }

    public MaterialBuilder setBlocksMovement(boolean blocksMovement) {
        this.blocksMovement = blocksMovement;
        return this;
    }

    public MaterialBuilder setOpaque(boolean opaque) {
        isOpaque = opaque;
        return this;
    }

    public MaterialBuilder setFlammable(boolean flammable) {
        this.flammable = flammable;
        return this;
    }

    public MaterialBuilder setReplaceable(boolean replaceable) {
        this.replaceable = replaceable;
        return this;
    }

    public MaterialBuilder setPushReaction(@Nonnull PushReaction pushReaction) {
        this.pushReaction = pushReaction;
        return this;
    }

    @Nonnull
    public Material build() {
        return new Material(color, isLiquid, isSolid, blocksMovement, isOpaque, flammable, replaceable, pushReaction);
    }
}
