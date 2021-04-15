package raven.ravenstorages.effects.entities.base;

import raven.ravenstorages.library.vector.VectorProperty;

public abstract class BaseVisualFXEntity extends BaseFXEntity {
    private VectorProperty beforeMoving;
    private VectorProperty motionProp = VectorProperty.NEUTRAL;
    private float gravity     = 0f;
    private float effectAlpha = 0f;

    public BaseVisualFXEntity(VectorProperty property) {
        super(property);
        this.beforeMoving = property.copy();
    }

    public abstract void onRendering();

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseVisualFXEntity> T setOriginPoint(VectorProperty origin) {
        this.beforeMoving = origin.copy();
        return (T) this;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseVisualFXEntity> T setMotionProp(VectorProperty motionProp) {
        this.motionProp = motionProp.copy();
        return (T) this;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseVisualFXEntity> T setGravity(float gravValue) {
        this.gravity = gravValue;
        return (T) this;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseVisualFXEntity> T setEffectAlpha(float alphaValue) {
        this.effectAlpha = alphaValue;
        return (T) this;
    }

    public float getGravity() { return gravity; }

    public float getEffectAlpha() { return effectAlpha; }

}
