package raven.ravenstorages.api.network;

import raven.ravenstorages.api.resource.ResourceIdentifier;
import raven.ravenstorages.api.resource.ResourceStack;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * 資源の搬出要件1件を表すインターフェースです。
 *
 * <p>搬出要件は倉庫に対する一件の搬出命令と搬出結果に対する処理からなります。
 * 倉庫は各メソッドにより搬出する資源を決定し、倉庫の資源を減少させます。
 * また実際に搬出された資源を引数としてhandleResultを呼び出します。
 *
 * @param <T> 資源の型
 * @see ResourceIdentifier
 */
public interface ExtractionRequirement<T> {

    /**
     * 搬出可能な資源の条件を定義します。
     *
     * @param storedResource 資源
     * @return 資源が搬出条件に合致するならばtrue
     */
    boolean canAccept(@Nonnull ResourceStack<T> storedResource);

    /**
     * 必要な資源の数を返します。
     *
     * <p>サイズが存在しない場合全数指定です。
     *
     * @return 必要な資源の数、存在しない場合は全数指定
     */
    @Nonnull
    OptionalLong size();

    /**
     * 搬出可能な量が指定個数未満の場合の搬出を許可するかを定義します。
     *
     * @return 指定個数未満の搬出を許可する場合true
     */
    boolean allowsPartialExtraction();

    /**
     * 一度の搬出での複数種類の資源の搬出を許可するかを定義します。
     *
     * <p>このメソッドがtrueを返す場合、倉庫内の資源一種類で指定個数に満たない場合に2種類以上の資源の搬出を行う可能性があります。
     * @return 複数種類の資源の搬出を許可する場合true
     */
    boolean allowsMultiExtraction();

    /**
     * 存在する場合、搬出条件を満たす資源が複数種類存在する場合に優先して搬出される資源を決定するコンパレータを返します。
     *
     * <p>返されるコンパレータのcompareメソッドははResourceStack r1, r2に対して、
     * r1の優先度が高い場合正の整数、等しい場合0、低い場合負の整数を返します。
     * <p>コンパレータが存在する場合、倉庫は優先度が高い資源から搬出を行います。存在しない場合、搬出される資源は非決定的です。
     *
     * @return 資源の搬出優先度を比較するコンパレータ、又は空のOptional
     */
    @Nonnull
    Optional<Comparator<? super ResourceStack<T>>> priorityComparator();

    /**
     * 搬出された資源に応じた処理を行います。
     *
     * <p>このメソッドは搬出された資源に応じて輸送元の資源を増やす必要があります。
     *
     * @param extractedResources 搬出された資源のリスト
     */
    void handleResult(@Nonnull List<ResourceStack<T>> extractedResources);
}
