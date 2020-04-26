package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@NullableDecl Object obj);

    List<V> get(@NullableDecl K k);

    List<V> removeAll(@NullableDecl Object obj);

    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
