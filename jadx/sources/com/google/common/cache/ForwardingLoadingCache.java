package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    /* access modifiers changed from: protected */
    public abstract LoadingCache<K, V> delegate();

    protected ForwardingLoadingCache() {
    }

    public V get(K k) throws ExecutionException {
        return delegate().get(k);
    }

    public V getUnchecked(K k) {
        return delegate().getUnchecked(k);
    }

    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return delegate().getAll(iterable);
    }

    public V apply(K k) {
        return delegate().apply(k);
    }

    public void refresh(K k) {
        delegate().refresh(k);
    }

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> delegate;

        protected SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        /* access modifiers changed from: protected */
        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
