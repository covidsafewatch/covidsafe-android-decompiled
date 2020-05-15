package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface SetMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    Set<Map.Entry<K, V>> entries();

    boolean equals(@NullableDecl Object obj);

    Set<V> get(@NullableDecl K k);

    Set<V> removeAll(@NullableDecl Object obj);

    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
