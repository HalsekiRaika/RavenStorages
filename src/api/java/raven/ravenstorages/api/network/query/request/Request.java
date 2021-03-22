package raven.ravenstorages.api.network.query.request;

import java.util.List;

/**
 * 倉庫に対して要求する操作を表すインターフェース。
 */
public interface Request {
    List<Transaction> insertions();

    List<Transaction> extractions();
}
