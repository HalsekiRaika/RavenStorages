package raven.ravenstorages.api.network;

import raven.ravenstorages.api.network.query.request.Request;
import raven.ravenstorages.api.network.query.response.Response;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * 倉庫管理ネットワークのAPIを表すインターフェース。
 *
 * <p>このインターフェースを通じてネットワークに対してクエリを発行する事が出来る。
 */
@ParametersAreNonnullByDefault
public interface StorageNetworkAPI {

    /**
     * このネットワークに対してリクエストを送信して結果を取得します。
     *
     * <p>倉庫に対する操作は1つのリクエストによって表現可能です。
     * 複数の操作を複数のqueryに分けて行うより、1つのResponseで全ての操作を表現することが推奨されます。
     *
     * @param request このネットワークに対する操作要求
     * @return 操作の結果
     */
    Response query(Request request);
}
