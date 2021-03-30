package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 倉庫からの搬入出時に同時に取り扱われるべき資源を表すインターフェース。
 */
public interface Transaction {
    @Nonnull
    <T> List<SizedRequirement<T>> requirements(@Nonnull ResourceIdentifier<T> identifier);
}
