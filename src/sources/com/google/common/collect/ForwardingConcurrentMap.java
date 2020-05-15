package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    /* access modifiers changed from: protected */
    public abstract ConcurrentMap<K, V> delegate();

    protected ForwardingConcurrentMap() {
    }

    public V putIfAbsent(K k, V v) {
        return delegate().putIfAbsent(k, v);
    }

    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public V replace(K k, V v) {
        return delegate().replace(k, v);
    }

    public boolean replace(K k, V v, V v2) {
        return delegate().replace(k, v, v2);
    }
}
