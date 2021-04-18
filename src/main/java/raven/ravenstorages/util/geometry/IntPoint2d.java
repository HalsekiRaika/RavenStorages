package raven.ravenstorages.util.geometry;

/**
 * 二次元座標の不変実装です。
 *
 * <p>座標情報はint型で保持されます。
 */
public final class IntPoint2d {
    private final int x;
    private final int y;

    /**
     * 指定した座標を持つ二次元座標を生成します。
     *
     * @param x x座標
     * @param y y座標
     */
    public IntPoint2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * x座標を取得します。
     *
     * @return x座標
     */
    public int x() {
        return x;
    }

    /**
     * y座標を取得します。
     *
     * @return y座標
     */
    public int y() {
        return y;
    }

    /**
     * この座標と他のオブジェクトが等しいか検証します。
     *
     * @param o 比較対象のオブジェクト
     * @return oがIntPoint2dで、かつこの座標がoの表す座標と一致する場合true
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntPoint2d that = (IntPoint2d) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    /**
     * この座標のハッシュコード値を計算します。
     *
     * @return ハッシュコード値
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    /**
     * この座標の文字列表現を返します。
     *
     * <p>文字列表現の形式は定義されていません。
     *
     * @return 文字列表現
     */
    @Override
    public String toString() {
        return "IntPoint2d{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
