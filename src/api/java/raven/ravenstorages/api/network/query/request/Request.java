package raven.ravenstorages.api.network.query.request;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 倉庫に対して要求する操作を表すインターフェース。
 */
public interface Request {
    @Nonnull
    List<Transaction> insertions();

    @Nonnull
    List<Transaction> extractions();
}
