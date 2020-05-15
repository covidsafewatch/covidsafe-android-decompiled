package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2);

    boolean containsKey(@NullableDecl Object obj);

    boolean containsValue(@NullableDecl Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@NullableDecl Object obj);

    Collection<V> get(@NullableDecl K k);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    boolean put(@NullableDecl K k, @NullableDecl V v);

    boolean putAll(Multimap<? extends K, ? extends V> multimap);

    boolean putAll(@NullableDecl K k, Iterable<? extends V> iterable);

    boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2);

    Collection<V> removeAll(@NullableDecl Object obj);

    Collection<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable);

    int size();

    Collection<V> values();
}
