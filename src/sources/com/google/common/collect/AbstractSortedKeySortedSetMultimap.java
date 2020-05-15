package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    /* access modifiers changed from: package-private */
    public SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap) super.backingMap();
    }

    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }
}
