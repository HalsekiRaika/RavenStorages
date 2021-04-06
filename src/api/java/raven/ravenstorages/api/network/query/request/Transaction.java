package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 同時に処理される輸送要件を表すインターフェースです。
 *
 * <p>Transactionは資源識別子及び搬入出方式別に分けられた搬入要件及び搬出要件のリストからなります。
 * Transaction内の各要件の処理はアトミックに行われます。つまり、全ての輸送が成功するか、又は1つでも失敗する場合は全ての輸送が失敗します。
 * <p>搬入から処理されるか、搬出から処理されるかは実装に依存します。
 *
 * @see ResourceIdentifier
 * @see InsertionMethod
 * @see ExtractionMethod
 */
public interface Transaction {

    /**
     * 倉庫への搬入要件のリストを取得します。
     *
     * <p>指定された資源識別子及び搬入方式に対応する搬入要件のリストを返します。資源識別子と搬入方式に対応する搬入要件が存在しない場合空のリストを返します。
     * <p>指定された搬入方式によってアクセスできるストレージが異なります。InsertionMethodとアクセス可能なストレージの対応は以下の通りです。
     * <ul>
     *     <li>MANUAL</li>
     *     全てのストレージにアクセス可能です。
     *     <li>HALTING</li>
     *     取り置きストレージと制限ストレージにアクセス可能です。
     *     <li>VOIDING</li>
     *     取り置きストレージと制限ストレージとVOIDストレージにアクセス可能です。
     * </ul>
     *
     * @param identifier 資源識別子
     * @param method 倉庫への搬入方式
     * @param <T> 資源の型
     * @return 資源識別子と搬入方式に対応する搬入要件のリスト
     * @see ResourceIdentifier
     * @see InsertionMethod
     */
    @Nonnull
    <T> List<InsertionRequirement<T>> insertions(@Nonnull ResourceIdentifier<T> identifier, @Nonnull InsertionMethod method);

    /**
     * 倉庫への搬出要件のリストを取得します。
     *
     * <p>指定された資源識別子及び搬出方式に対応する搬出対象を返します。資源識別子と搬入方式に対応する搬出要件が存在しない場合空のリストを返します。
     * <p>指定された搬出方式によってアクセスできるストレージが異なります。ExtractionMethodとアクセス可能なストレージの対応は以下の通りです。
     * <ul>
     *     <li>MANUAL</li>
     *     全てのストレージにアクセス可能です。
     *     <li>AUTOMATION</li>
     *     取り置きストレージ以外にアクセス可能です。
     * </ul>
     *
     * @param identifier 資源識別子
     * @param method 搬出方式
     * @param <T> 資源の型
     * @return 資源識別子と搬出方式に対応する搬出要件のリスト
     * @see ResourceIdentifier
     * @see ExtractionMethod
     */
    @Nonnull
    <T> List<ExtractionRequirement<T>> extractions(@Nonnull ResourceIdentifier<T> identifier, @Nonnull ExtractionMethod method);
}
