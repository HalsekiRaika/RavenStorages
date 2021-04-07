package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;
import raven.ravenstorages.api.storage.ResourceStack;

import javax.annotation.Nonnull;

/**
 * 資源の搬入要件1件を表すインターフェースです。
 *
 * <p>搬入要件は倉庫に対する一件の搬入命令と、搬入結果に対する処理からなります。
 * 倉庫は各メソッドにより搬入する資源を決定し、倉庫の資源を増加させます。
 * また実際に搬入された資源を引数としてhandleResultを呼び出します
 *
 * @param <T> 資源の型
 * @see ResourceIdentifier
 */
public interface InsertionRequirement<T> {

    /**
     * 搬入する資源とその個数を定義します。
     *
     * @return 搬入するResourceStack
     */
    @Nonnull
    ResourceStack<T> stackToInsert();

    /**
     * 搬入可能な量が指定個数未満の場合に搬入するか定義します。
     *
     * @return 指定個数未満の搬入を許可する場合true
     */
    boolean allowsPartialInsertion();

    /**
     * 搬入された資源の量に応じる処理を行います。
     *
     * <p>このメソッドはamountOfInsertedに応じて輸送元の資源を減らす必要があります。
     *
     * @param amountOfInserted 搬入された資源の量
     */
    void handleResult(long amountOfInserted);


}
