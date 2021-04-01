package raven.ravenstorages.api.network.query.request;

/**
 * 倉庫からの資源の搬出時に指定される方式の列挙です。
 *
 * <p>搬出方式によってアクセス可能なストレージが異なります。方式とストレージの対応は以下の通りです。
 * <ul>
 *     <li>MANUAL</li>
 *     全てのストレージにアクセス可能です。
 *     <li>AUTOMATION</li>
 *     制限ストレージ、VOIDストレージ、デフォルトストレージにアクセス可能です。
 * </ul>
 */
public enum ExtractionMethod {

    /**
     * 手動加工のための搬出方式を表すシングルトンインスタンス。
     */
    MANUAL,

    /**
     * 自動加工のための搬出方式を表すシングルトンインスタンス。
     */
    AUTOMATION;
}
