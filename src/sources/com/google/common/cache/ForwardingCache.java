package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
    /* access modifiers changed from: protected */
    public abstract Cache<K, V> delegate();

    protected ForwardingCache() {
    }

    @NullableDecl
    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        return delegate().get(k, callable);
    }

    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        return delegate().getAllPresent(iterable);
    }

    public void put(K k, V v) {
        delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public void invalidate(Object obj) {
        delegate().invalidate(obj);
    }

    public void invalidateAll(Iterable<?> iterable) {
        delegate().invalidateAll(iterable);
    }

    public void invalidateAll() {
        delegate().invalidateAll();
    }

    public long size() {
        return delegate().size();
    }

    public CacheStats stats() {
        return delegate().stats();
    }

    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    public void cleanUp() {
        delegate().cleanUp();
    }

    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {
        private final Cache<K, V> delegate;

        protected SimpleForwardingCache(Cache<K, V> cache) {
            this.delegate = (Cache) Preconditions.checkNotNull(cache);
        }

        /* access modifiers changed from: protected */
        public final Cache<K, V> delegate() {
            return this.delegate;
        }
    }
}
