package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceStack;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 資源の検索要件1件を表すインターフェース。
 *
 * <p>検索要件は資源の検索条件と検索条件に合致した資源を用いる手続きからなります。
 * 倉庫はcanAcceptにより管理下の資源が検索対象であるのか検証します。
 * 資源を用いる処理はhandleResultにより定義されます。倉庫は検索条件に合致する資源のリストによりhandleResultを呼び出します。
 *
 * @param <T> 資源の型
 */
public interface RetrievalRequirement<T> {

    /**
     * 検索条件を定義します。
     *
     * @param storedResource 倉庫内の資源
     * @return 引数が検索条件に合致する場合true
     */
    boolean canAccept(@Nonnull T storedResource);

    /**
     * 検索条件に合致した資源を用いた処理を行います。
     *
     * @param foundResources 検索条件に合致した資源のリスト
     */
    void handleResult(@Nonnull List<ResourceStack<T>> foundResources);
}
