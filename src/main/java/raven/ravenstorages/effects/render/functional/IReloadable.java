package raven.ravenstorages.effects.render.functional;

import raven.ravenstorages.effects.entities.base.BaseFXEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface IReloadable<T extends BaseFXEntity> {
    IReloadable<?> NO_DRAWING = FX -> false;

    boolean doReload(T effects);
}
