package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 倉庫に対するクエリ1件の内容を表すインターフェースです。
 *
 * <p>クエリ1件は検索要件及び輸送要件のリストからなります。ある時点において必要な全ての検索、輸送命令を1つのRequestにまとめる事が出来ます。
 * <p>倉庫へのアクセスを行う場合は必ずアクセス方式を指定する必要があります。倉庫はアクセス方式を解釈して実際に取り扱うストレージを決定します。
 * 倉庫に対して正しく目的を示す事で自動加工システムによる資材の使い潰しを防いだり、無駄な加工による資源の消費を防ぐことが出来ます。
 *
 * <p>検索から処理されるか輸送から処理されるかは実装依存です。
 *
 * @see ResourceIdentifier
 */
public interface Request {

    /**
     * 倉庫への検索要件のリストを返します。
     *
     * <p>指定された資源識別子及び検索方式に対応する検索対象を返します。対応する検索対象が存在しない場合、空のリストを返します。
     * <p>指定された検索方式によってアクセスできるストレージが異なります。詳細はRetrievalMethodを参照してください。
     *
     * @param identifier 資源識別子
     * @param method 検索方式
     * @param <T> 資源の型
     * @return 検索対象のリスト
     * @see RetrievalMethod
     */
    @Nonnull
    <T> List<RetrievalRequirement<T>> retrievalTargets(@Nonnull ResourceIdentifier<T> identifier, @Nonnull RetrievalMethod method);

    /**
     * 倉庫への輸送要件のリストを返します。
     *
     * <p>倉庫はこのメソッドにより返されるTransactionを順に処理します。Transaction1件はアトミックに処理される複数の輸送要件を表しており、
     * 全ての輸送が成功するか、そうでない場合輸送が行われない事が保証されています。
     *
     * @return アトミックに行われる輸送要件のリスト
     */
    @Nonnull
    List<Transaction> transportTargets();
}
