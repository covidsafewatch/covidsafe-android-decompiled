package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractNavigableMap<K, V> extends IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    private final class DescendingMap extends DescendingMap<K, V> {
        private DescendingMap() {
        }

        /* access modifiers changed from: 0000 */
        public NavigableMap<K, V> forward() {
            return AbstractNavigableMap.this;
        }

        /* access modifiers changed from: 0000 */
        public Iterator<Entry<K, V>> entryIterator() {
            return AbstractNavigableMap.this.descendingEntryIterator();
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract Iterator<Entry<K, V>> descendingEntryIterator();

    @NullableDecl
    public abstract V get(@NullableDecl Object obj);

    AbstractNavigableMap() {
    }

    @NullableDecl
    public Entry<K, V> firstEntry() {
        return (Entry) Iterators.getNext(entryIterator(), null);
    }

    @NullableDecl
    public Entry<K, V> lastEntry() {
        return (Entry) Iterators.getNext(descendingEntryIterator(), null);
    }

    @NullableDecl
    public Entry<K, V> pollFirstEntry() {
        return (Entry) Iterators.pollNext(entryIterator());
    }

    @NullableDecl
    public Entry<K, V> pollLastEntry() {
        return (Entry) Iterators.pollNext(descendingEntryIterator());
    }

    public K firstKey() {
        Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public K lastKey() {
        Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @NullableDecl
    public Entry<K, V> lowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    @NullableDecl
    public Entry<K, V> floorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    @NullableDecl
    public Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    @NullableDecl
    public Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K lowerKey(K k) {
        return Maps.keyOrNull(lowerEntry(k));
    }

    public K floorKey(K k) {
        return Maps.keyOrNull(floorEntry(k));
    }

    public K ceilingKey(K k) {
        return Maps.keyOrNull(ceilingEntry(k));
    }

    public K higherKey(K k) {
        return Maps.keyOrNull(higherEntry(k));
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }

    public NavigableSet<K> navigableKeySet() {
        return new NavigableKeySet(this);
    }

    public Set<K> keySet() {
        return navigableKeySet();
    }

    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap();
    }
}
