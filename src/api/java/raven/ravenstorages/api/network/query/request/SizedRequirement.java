package raven.ravenstorages.api.network.query.request;

import javax.annotation.Nonnull;

public interface SizedRequirement<T> {
    @Nonnull
    Requirement<T> requirement();

    long size();
}
