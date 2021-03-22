package raven.ravenstorages.api.storage;

/**
 * 資源の識別子を表すインターフェースです。
 *
 * <p>資源とは倉庫が取り扱うことが出来る物です。アイテムや液体等倉庫で管理される対象を表します。
 *
 * @param <T> 資源の型
 */
public interface ResourceIdentifier<T> {

    /**
     * このオブジェクトが他のオブジェクトと等しいかどうかを示します。
     *
     * <p>ResourceIdentifierの実装クラスではこのメソッドをOverrideすることが禁止されています。
     * つまり、x.equals(y) == (x == y)が成り立つべきです。
     *
     * @param obj 比較対象の参照オブジェクト
     * @return このオブジェクトがobj引数と同じである場合はtrue、それ以外の場合はfalse
     */
    @Override
    boolean equals(Object obj);

    /**
     * オブジェクトのハッシュ・コード値を返します。
     *
     * <p>equalsメソッドと同様、実装クラスではこのメソッドをOverrideすることが禁止されています。
     *
     * @return このオブジェクトのハッシュ・コード値
     */
    @Override
    int hashCode();
}
