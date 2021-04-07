package raven.ravenstorages.api.storage;

import javax.annotation.Nonnull;

/**
 * 型Tで表される資源とその個数を表すインターフェースです。
 *
 * @param <T> 資源の型
 */
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
     * <p>このメソッドは1以上の値を返します。
     *
     * @return スタックサイズ
     */
    long size();
}
