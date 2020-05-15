package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @Deprecated
    V apply(K k);

    ConcurrentMap<K, V> asMap();

    V get(K k) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k);

    void refresh(K k);
}
