package com.google.common.collect;

import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract ListMultimap<K, V> delegate();

    protected ForwardingListMultimap() {
    }

    public List<V> get(@NullableDecl K k) {
        return delegate().get(k);
    }

    public List<V> removeAll(@NullableDecl Object obj) {
        return delegate().removeAll(obj);
    }

    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k, iterable);
    }
}
