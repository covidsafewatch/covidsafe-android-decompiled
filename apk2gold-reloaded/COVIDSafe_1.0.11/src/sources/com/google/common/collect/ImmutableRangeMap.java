package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    @DoNotMock
    public static final class Builder<K extends Comparable<?>, V> {
        private final List<Entry<Range<K>, V>> entries = Lists.newArrayList();

        public Builder<K, V> put(Range<K> range, V v) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", (Object) range);
            this.entries.add(Maps.immutableEntry(range, v));
            return this;
        }

        public Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap) {
            for (Entry entry : rangeMap.asMapOfRanges().entrySet()) {
                put((Range) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableRangeMap<K, V> build() {
            Collections.sort(this.entries, Range.rangeLexOrdering().onKeys());
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(this.entries.size());
            com.google.common.collect.ImmutableList.Builder builder2 = new com.google.common.collect.ImmutableList.Builder(this.entries.size());
            for (int i = 0; i < this.entries.size(); i++) {
                Range range = (Range) ((Entry) this.entries.get(i)).getKey();
                if (i > 0) {
                    Range range2 = (Range) ((Entry) this.entries.get(i - 1)).getKey();
                    if (range.isConnected(range2) && !range.intersection(range2).isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Overlapping ranges: range ");
                        sb.append(range2);
                        sb.append(" overlaps with entry ");
                        sb.append(range);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                builder.add((Object) range);
                builder2.add(((Entry) this.entries.get(i)).getValue());
            }
            return new ImmutableRangeMap<>(builder.build(), builder2.build());
        }
    }

    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            return createRangeMap();
        }

        /* access modifiers changed from: 0000 */
        public Object createRangeMap() {
            Builder builder = new Builder();
            UnmodifiableIterator it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                builder.put((Range) entry.getKey(), entry.getValue());
            }
            return builder.build();
        }
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map asMapOfRanges = rangeMap.asMapOfRanges();
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(asMapOfRanges.size());
        com.google.common.collect.ImmutableList.Builder builder2 = new com.google.common.collect.ImmutableList.Builder(asMapOfRanges.size());
        for (Entry entry : asMapOfRanges.entrySet()) {
            builder.add(entry.getKey());
            builder2.add(entry.getValue());
        }
        return new ImmutableRangeMap<>(builder.build(), builder2.build());
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    @NullableDecl
    public V get(K k) {
        int binarySearch = SortedLists.binarySearch((List<E>) this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER);
        V v = null;
        if (binarySearch == -1) {
            return null;
        }
        if (((Range) this.ranges.get(binarySearch)).contains(k)) {
            v = this.values.get(binarySearch);
        }
        return v;
    }

    @NullableDecl
    public Entry<Range<K>, V> getEntry(K k) {
        int binarySearch = SortedLists.binarySearch((List<E>) this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER);
        Entry<Range<K>, V> entry = null;
        if (binarySearch == -1) {
            return null;
        }
        Range range = (Range) this.ranges.get(binarySearch);
        if (range.contains(k)) {
            entry = Maps.immutableEntry(range, this.values.get(binarySearch));
        }
        return entry;
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            Range range = (Range) this.ranges.get(0);
            ImmutableList<Range<K>> immutableList = this.ranges;
            return Range.create(range.lowerBound, ((Range) immutableList.get(immutableList.size() - 1)).upperBound);
        }
        throw new NoSuchElementException();
    }

    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
        if (((Range) Preconditions.checkNotNull(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        final int binarySearch = SortedLists.binarySearch((List<E>) this.ranges, Range.upperBoundFn(), range.lowerBound, KeyPresentBehavior.FIRST_AFTER, KeyAbsentBehavior.NEXT_HIGHER);
        int binarySearch2 = SortedLists.binarySearch((List<E>) this.ranges, Range.lowerBoundFn(), range.upperBound, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
        if (binarySearch >= binarySearch2) {
            return of();
        }
        final int i = binarySearch2 - binarySearch;
        final Range<K> range2 = range;
        AnonymousClass2 r3 = new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() {
            /* access modifiers changed from: 0000 */
            public boolean isPartialView() {
                return true;
            }

            public int size() {
                return i;
            }

            public Range<K> get(int i) {
                Preconditions.checkElementIndex(i, i);
                if (i == 0 || i == i - 1) {
                    return ((Range) ImmutableRangeMap.this.ranges.get(i + binarySearch)).intersection(range);
                }
                return (Range) ImmutableRangeMap.this.ranges.get(i + binarySearch);
            }
        }, this.values.subList(binarySearch, binarySearch2)) {
            public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                return ImmutableRangeMap.super.asDescendingMapOfRanges();
            }

            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return ImmutableRangeMap.super.asMapOfRanges();
            }

            public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
                if (range2.isConnected(range)) {
                    return this.subRangeMap(range.intersection(range2));
                }
                return ImmutableRangeMap.of();
            }
        };
        return r3;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof RangeMap)) {
            return false;
        }
        return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
