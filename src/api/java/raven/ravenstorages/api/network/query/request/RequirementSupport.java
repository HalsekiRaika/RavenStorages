package raven.ravenstorages.api.network.query.request;

/**
 * Requirementのユーティリティクラス。
 */
class RequirementSupport {
    static final Requirement<?> ANY = t -> true;
    static final Requirement<?> NONE = t -> false;

    @SuppressWarnings("unchecked")
    static <T> Requirement<T> any() {
        return (Requirement<T>) ANY;
    }

    @SuppressWarnings("unchecked")
    static <T> Requirement<T> none() {
        return (Requirement<T>) NONE;
    }
}
