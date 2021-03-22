package raven.ravenstorages.api.storage;

import net.minecraft.fluid.Fluid;

import javax.annotation.Nonnull;

/**
 * 液体を表すResourceIdentifier。
 */
public enum FluidIdentifier implements ResourceIdentifier<Fluid> {
    /**
     * シングルトンインスタンス。
     */
    SINGLETON;

    /**
     * オブジェクトの文字列表現を返します。
     *
     * @return このオブジェクトの文字列表現。
     */
    @Override
    @Nonnull
    public String toString() {
        return "Fluid";
    }
}
