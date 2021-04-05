package raven.ravenstorages.api.network.query.request;

/**
 * 倉庫に対する資源の検索時に指定される方式の列挙です。
 *
 * <p>検索方式によってアクセス可能なストレージが異なります。
 * InsertionMethod及びExtractionMethodと同名の方式では同じストレージにアクセスできます。
 */
public enum StorageViewMethod {

    /**
     * デフォルトストレージの検索を表すシングルトンインスタンス。
     */
    DEFAULT,

    /**
     * VOIDストレージの検索を表すシングルトンインスタンス。
     */
    VOID,

    /**
     * 制限ストレージの検索を表すシングルトンインスタンス。
     */
    RESTRICTED,

    /**
     * 取り置きストレージの検索を表すシングルトンインスタンス。
     */
    LAYAWAY,

    /**
     * HALTING搬入方式でアクセス可能なストレージの検索を表すシングルトンインスタンス。
     */
    HALTING,

    /**
     * VOIDING搬入方式でアクセス可能なストレージの検索を表すシングルトンインスタンス。
     */
    VOIDING,

    /**
     * AUTOMATION搬出方式でアクセス可能なストレージの検索を表すシングルトンインスタンス。
     */
    AUTOMATION,

    /**
     * MANUAL搬入方式及び搬出方式でアクセス可能なストレージの検索を表すシングルトンインスタンス。
     */
    MANUAL
}
