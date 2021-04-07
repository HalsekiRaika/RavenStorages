package raven.ravenstorages.api.storage;

/**
 * 資源の種類の識別子を表すインターフェースです。
 *
 * <p>資源とは倉庫が取り扱うことが出来る物です。アイテムや液体等倉庫で管理される対象を表します。
 * 型Tが同じである資源は同種の資源と判断されます。
 * ただしここで同種であるとはスタック可能であるアイテムのようにゲーム内の同じ資源であると言う事を意味しているわけではありません。
 * 同種であるとは同じ種類の資源同士でスタック可能か否かを調べたり型Tの実装によっては比較を行うことが出来るという事を意味します。
 * <p>型Tは{@link ResourceStack}や各種Requirement等資源を扱う型で利用され、倉庫の検索や輸送に利用されます。
 *
 * @param <T> 資源の型
 * @see ResourceStack
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
