package io.reactivex.internal.fuseable;

import io.reactivex.Maybe;

public interface FuseToMaybe<T> {
    Maybe<T> fuseToMaybe();
}
