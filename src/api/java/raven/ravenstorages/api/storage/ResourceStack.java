package raven.ravenstorages.api.storage;

import javax.annotation.Nonnull;

public interface ResourceStack<T> {

    /**
     * この資源の識別子を返します。
     *
     * @return 資源の識別子
     */
    @Nonnull
    ResourceIdentifier<T> identifier();

    /**
     * この資源の種類を返します。
     *
     * @return 資源の種類
     */
    @Nonnull
    T resourceType();

    /**
     * スタックサイズを返します。
     *
     * <p>スタックサイズの範囲[0, Long.MAX_VALUE]です。
     *
     * @return スタックサイズ
     */
    long size();
}
