package raven.ravenstorages.capability;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 方向に依存しないCapability実装1つを保持するCapabilityProviderの実装です。
 *
 * {@link this#getCapability(Capability, Direction)}メソッドはdirectionを無視します。
 * この実装のインスタンスが保持しているCapabilityやそのホルダーオブジェクトへの参照は変化しません。
 *
 * @param <T> Capabilityの実装型
 * @see Capability
 */
public final class SingleCapabilityProvider<T> implements ICapabilityProvider {
    private final Capability<T> holder;
    private final T capability;

    /**
     * 指定したCapabilityを保持するCapabilityProviderを構築します。
     *
     * @param holder Capabilityのホルダーオブジェクト
     * @param capability Capability実装
     */
    public SingleCapabilityProvider(@Nonnull Capability<T> holder, @Nonnull T capability) {
        this.holder = holder;
        this.capability = capability;
    }

    /**
     * 指定したホルダーオブジェクトに対応するCapabilityProviderが保持するCapability実装のLazyOptionalを返します。
     *
     * <p>指定したdirectionは無視されます。
     * つまり、このメソッドの如何なるdirectionによる呼び出しも{@link this#getCapability(Capability)}と一致します。
     *
     * @param holder Capabilityのホルダーオブジェクト
     * @param direction Capabilityを取得する方向
     * @param <R> holderに対応するCapabilityの実装型
     * @return CapabilityのLazyOptional
     */
    @Nonnull
    @Override
    public <R> LazyOptional<R> getCapability(@Nonnull Capability<R> holder, @Nullable Direction direction) {
        return this.holder.orEmpty(holder, LazyOptional.of(() -> capability));
    }
}
