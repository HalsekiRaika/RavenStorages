package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 倉庫に対するクエリ1件の内容を表すインターフェース。
 */
public interface Request {
    enum InsertionPurpose {
        MANUAL,
        AUTOMATION,
        VOIDING;
    }

    enum ExtractionPurpose {
        MANUAL,
        AUTOMATION;
    }

    @Nonnull
    <T> List<Requirement<T>> retrievalTargets(@Nonnull ResourceIdentifier<T> identifier, @Nonnull ExtractionPurpose purpose);

    @Nonnull
    List<Transaction> insertions(@Nonnull InsertionPurpose purpose);

    @Nonnull
    List<Transaction> extractions(@Nonnull ExtractionPurpose purpose);
}
