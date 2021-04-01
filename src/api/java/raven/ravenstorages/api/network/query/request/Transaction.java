package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 倉庫に対する輸送時に同時に取り扱われるべき資源を表すインターフェース。
 *
 * <p>Transaction1件は各資源の種類及び目的毎に分けられたSizedRequirementのリストからなります。
 * Transaction内のSizedRequirementの処理はアトミックに行われます。つまり、全ての輸送が成功するか、又は1つでも失敗する場合は全ての輸送が失敗します。
 * 倉庫に対する輸送命令はTransactionのリストとして表現され、倉庫は各Transactionを一件ずつ処理してその結果を元にレスポンスを生成します。
 */
public interface Transaction {

    /**
     * 倉庫への搬入対象を取得します。
     *
     * <p>指定されたidentifier及びpurposeに対応する搬入対象を返します。対応する搬入対象が存在しない場合空のリストを返します。
     * <p>purposeによってアクセスできるストレージが異なります。InsertionPurposeとアクセス可能なストレージの対応は以下の通りです。
     * <ul>
     *     <li>MANUAL</li>
     *     全てのストレージにアクセス可能です。
     *     <li>AUTOMATION</li>
     *     取り置きストレージと制限ストレージにアクセス可能です。
     *     <li>VOIDING</li>
     *     取り置きストレージと制限ストレージとVOIDストレージにアクセス可能です。
     * </ul>
     *
     * @param identifier 資源の種類を表す識別子
     * @param purpose 倉庫への搬入目的
     * @param <T> 資源の型
     * @return 搬入命令のリスト
     * @see InsertionMethod
     */
    @Nonnull
    <T> List<SizedRequirement<T>> insertions(@Nonnull ResourceIdentifier<T> identifier, @Nonnull InsertionMethod purpose);

    /**
     * 倉庫への搬出命令を取得します。
     *
     * <p>指定されたidentifier及びpurposeに対応する搬出対象を返します。対応する搬出対象が存在しない場合空のリストを返します。
     * <p>purposeによってアクセスできるストレージが異なります。ExtractionPurposeとアクセス可能なストレージの対応は以下の通りです。
     * <ul>
     *     <li>MANUAL</li>
     *     全てのストレージにアクセス可能です。
     *     <li>AUTOMATION</li>
     *     取り置きストレージ以外にアクセス可能です。
     * </ul>
     *
     * @param identifier 倉庫への搬出目的
     * @param purpose 倉庫からの搬出目的
     * @param <T> 資源の型
     * @return 搬出命令のリスト
     */
    @Nonnull
    <T> List<SizedRequirement<T>> extractions(@Nonnull ResourceIdentifier<T> identifier, @Nonnull ExtractionMethod purpose);
}
