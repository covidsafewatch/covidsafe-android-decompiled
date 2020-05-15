package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {
    FilteredKeySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    public SetMultimap<K, V> unfiltered() {
        return (SetMultimap) this.unfiltered;
    }

    public Set<V> get(K k) {
        return (Set) super.get(k);
    }

    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k, iterable);
    }

    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> createEntries() {
        return new EntrySet();
    }

    class EntrySet extends FilteredKeyMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        public boolean equals(@NullableDecl Object obj) {
            return Sets.equalsImpl(this, obj);
        }
    }
}
