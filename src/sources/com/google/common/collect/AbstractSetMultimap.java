package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    /* access modifiers changed from: package-private */
    public abstract Set<V> createCollection();

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new AbstractMapBasedMultimap.WrappedSet(k, (Set) collection);
    }

    public Set<V> get(@NullableDecl K k) {
        return (Set) super.get(k);
    }

    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    public Set<V> removeAll(@NullableDecl Object obj) {
        return (Set) super.removeAll(obj);
    }

    public Set<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k, iterable);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        return super.put(k, v);
    }

    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
