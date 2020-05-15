package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
    Map<K, Collection<V>> asMap();

    SortedSet<V> get(@NullableDecl K k);

    SortedSet<V> removeAll(@NullableDecl Object obj);

    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
