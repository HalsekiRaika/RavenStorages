package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 倉庫に対するクエリ1件の内容を表すインターフェースです。
 *
 * <p>クエリ1件は検索対象及び搬入、搬出それぞれの対象のリストからなります。
 * 倉庫にアクセスするシステムはあるtickにおいて必要な検索、輸送の情報を1つのRequestにまとめる事が出来ます。
 * <p>倉庫へのアクセスを行う場合は必ずその目的を指定する必要があります。倉庫はアクセスの目的を解釈して実際に在庫検索を行うストレージを制限します。
 * 倉庫に対して正しく目的を示す事で自動加工システムによる資材の使い潰しを防いだり、無駄な加工による資源の消費を防ぐことが出来ます。
 *
 * @see ExtractionPurpose
 * @see InsertionPurpose
 */
public interface Request {

    /**
     * 倉庫への検索対象のリストを返します。
     *
     * <p>指定されたidentifier及びpurposeに対応する検索対象を返します。対応する検索対象が存在しない場合、空のリストを返します。
     * <p>purposeによってアクセスできるストレージの制限が異なります。ExtractionPurposeとアクセス可能なストレージの対応は以下の通りです。
     * <ul>
     *     <li>MANUAL</li>
     *     全てのストレージにアクセス可能です。
     *     <li>AUTOMATION</li>
     *     取り置き倉庫以外にアクセス可能です。
     * </ul>
     * <p>倉庫はこのメソッドにより返されるRequirementを満たす資源の量を調べてレスポンスを返します。
     *
     * @param identifier 資源の種類を表す識別子
     * @param purpose 倉庫へのアクセスの目的
     * @param <T> 資源の型
     * @return 検索対象のリスト
     */
    @Nonnull
    <T> List<Requirement<T>> retrievalTargets(@Nonnull ResourceIdentifier<T> identifier, @Nonnull ExtractionPurpose purpose);

    /**
     * 倉庫への輸送対象のリストを返します。
     *
     * <p>倉庫はこのメソッドにより返されるTransactionを順に処理し、実際に輸送が行われた資源の量を求めてレスポンスを返します。
     * Transaction1件はアトミックな輸送1件を示し、その中の輸送が全て行われるか、又は全て失敗することが保証されています。
     *
     * @return アトミックに行われる輸送のリスト
     */
    @Nonnull
    List<Transaction> transportTargets();
}
