package raven.ravenstorages.client.effects.base;

import raven.ravenstorages.common.library.vector.VectorProperty;

public abstract class BaseVisualFXEntity extends BaseFXEntity {
    private VectorProperty beforeMoving;

    public BaseVisualFXEntity(VectorProperty property) {
        super(property);
        this.beforeMoving = property.copy();
    }


}
