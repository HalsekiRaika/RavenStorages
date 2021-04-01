package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;

/**
 * 倉庫へのクエリにおいて、資源要件一種類を表すインターフェース。
 *
 * <p>倉庫はリクエストからRequirementを取り出してストレージの資源が要件を満たすことが出来るか検証します。
 *
 * @param <T> 資源の型
 * @see ResourceIdentifier
 */
@FunctionalInterface
public interface Requirement<T> {

    /**
     * 指定された資源がこの要件を満たすことが出来るか検証します。
     *　
     * @param resource 資源
     * @return 資源が要件を満たすことが出来るならばtrue
     */
    boolean isAcceptable(@Nonnull T resource);

    /**
     * この要件とnextの論理和である要件を返します。
     *
     * @param next この要件の次に検証する要件
     * @return 合成要件
     */
    @Nonnull
    default Requirement<T> or(@Nonnull Requirement<T> next) {
        return resource -> this.isAcceptable(resource) || next.isAcceptable(resource);
    }

    /**
     * この要件とnextの論理積である要件を返します。
     *
     * @param next この要件の次に検証する要件
     * @return 合成要件
     */
    @Nonnull
    default Requirement<T> and(@Nonnull Requirement<T> next) {
        return resource -> this.isAcceptable(resource) && next.isAcceptable(resource);
    }

    /**
     * この要件の論理否定である要件を返します。
     *
     * @return 否定要件
     */
    @Nonnull
    default Requirement<T> not() {
        return resource -> !this.isAcceptable(resource);
    }

    /**
     * 型Tが一致する任意の資源により満たすことができる要件
     *
     * @param identifier 資源の種類を表す識別子
     * @param <T> 資源の型
     * @return 任意の資源で満たすことが出来る要件
     */
    @Nonnull
    static <T> Requirement<T> any(@Nonnull ResourceIdentifier<T> identifier) {
        return RequirementSupport.any();
    }

    /**
     * 満たすことが出来ない要件を返します。
     *
     * @param identifier 資源の種類を表す識別子
     * @param <T> 資源の型
     * @return 任意の
     */
    @Nonnull
    static <T> Requirement<T> none(@Nonnull ResourceIdentifier<T> identifier) {
        return RequirementSupport.none();
    }

    /**
     * 引数の要件を返します。
     *
     * <p>このメソッドは引数をそのまま返します。ラムダ式からメソッドチェインを行う場合に利用できます。
     *
     * @param requirement 要件
     * @param <T> 資源の型
     * @return 引数の要件
     */
    @Nonnull
    static <T> Requirement<T> of(@Nonnull Requirement<T> requirement) {
        return requirement;
    }

    /**
     * 指定した資源と完全一致する資源でのみ満たすことが出来る要件を返します。
     *
     * @param identifier 資源の種類を表す識別子
     * @param resource 資源
     * @param <T> 資源の型
     * @return 完全一致要件
     */
    @Nonnull
    static <T> Requirement<T> exact(@Nonnull ResourceIdentifier<T> identifier, @Nonnull T resource) {
        return of(target -> target.equals(resource));
    }
}
