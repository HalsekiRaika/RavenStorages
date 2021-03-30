package raven.ravenstorages.api.network.query.request;

/**
 * Requirementのユーティリティクラス。
 */
class RequirementSupport {
    static final Requirement<?> ANY = t -> true;

    @SuppressWarnings("unchecked")
    static <T> Requirement<T> any() {
        return (Requirement<T>) ANY;
    }
}
