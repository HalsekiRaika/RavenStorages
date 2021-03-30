package raven.ravenstorages.api.network.query.request;

import raven.ravenstorages.api.storage.ResourceIdentifier;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * 倉庫へのクエリにおいて、資源要件一種類を表すインターフェース。
 *
 * <P>要件を満たすことが出来る資源を定義します。
 *
 * @param <T> 資源の型
 * @see ResourceIdentifier
 */
@FunctionalInterface
public interface Requirement<T> {

    /**
     *
     *
     * @param resource
     * @return
     */
    boolean isAcceptable(@Nonnull T resource);

    @Nonnull
    static <T> Requirement<T> any() {
        return RequirementSupport.any();
    }

    @Nonnull
    static <T> Requirement<T> of(@Nonnull ResourceIdentifier<T> identifier, @Nonnull Requirement<T> requirement) {
        return requirement;
    }

    @Nonnull
    static <T> Requirement<T> exact(@Nonnull ResourceIdentifier<T> identifier, @Nonnull T resource) {
        return of(identifier, target -> target.equals(resource));
    }

    @Nonnull
    static <T> Requirement<T> anyOf(@Nonnull ResourceIdentifier<T> identifier, @Nonnull Set<Requirement<T>> requirements) {
        return of(identifier, target -> requirements.stream().anyMatch(requirement -> requirement.isAcceptable(target)));
    }
}
