package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    @LazyInit
    private transient ImmutableRangeSet<C> complement;
    /* access modifiers changed from: private */
    public final transient ImmutableList<Range<C>> ranges;

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(Range.all())) {
            return all();
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf(rangeSet.asRanges()));
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new Builder().addAll(iterable).build();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public boolean intersects(Range<C> range) {
        int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (binarySearch < this.ranges.size() && ((Range) this.ranges.get(binarySearch)).isConnected(range) && !((Range) this.ranges.get(binarySearch)).intersection(range).isEmpty()) {
            return true;
        }
        if (binarySearch > 0) {
            int i = binarySearch - 1;
            if (!((Range) this.ranges.get(i)).isConnected(range) || ((Range) this.ranges.get(i)).intersection(range).isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean encloses(Range<C> range) {
        int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return binarySearch != -1 && ((Range) this.ranges.get(binarySearch)).encloses(range);
    }

    public Range<C> rangeContaining(C c) {
        int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch == -1) {
            return null;
        }
        Range<C> range = (Range) this.ranges.get(binarySearch);
        if (range.contains(c)) {
            return range;
        }
        return null;
    }

    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            Cut<C> cut = ((Range) this.ranges.get(0)).lowerBound;
            ImmutableList<Range<C>> immutableList = this.ranges;
            return Range.create(cut, ((Range) immutableList.get(immutableList.size() - 1)).upperBound);
        }
        throw new NoSuchElementException();
    }

    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    private final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        ComplementRanges() {
            this.positiveBoundedBelow = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range) Iterables.getLast(ImmutableRangeSet.this.ranges)).hasUpperBound();
            int size2 = ImmutableRangeSet.this.ranges.size() - 1;
            size2 = this.positiveBoundedBelow ? size2 + 1 : size2;
            this.size = this.positiveBoundedAbove ? size2 + 1 : size2;
        }

        public int size() {
            return this.size;
        }

        public Range<C> get(int i) {
            Cut<C> cut;
            Cut<C> cut2;
            Preconditions.checkElementIndex(i, this.size);
            if (this.positiveBoundedBelow) {
                cut = i == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(i - 1)).upperBound;
            } else {
                cut = ((Range) ImmutableRangeSet.this.ranges.get(i)).upperBound;
            }
            if (!this.positiveBoundedAbove || i != this.size - 1) {
                cut2 = ((Range) ImmutableRangeSet.this.ranges.get(i + (this.positiveBoundedBelow ^ true ? 1 : 0))).lowerBound;
            } else {
                cut2 = Cut.aboveAll();
            }
            return Range.create(cut, cut2);
        }
    }

    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        } else if (this.ranges.size() != 1 || !((Range) this.ranges.get(0)).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.complement = immutableRangeSet2;
            return immutableRangeSet2;
        } else {
            ImmutableRangeSet<C> of = of();
            this.complement = of;
            return of;
        }
    }

    public ImmutableRangeSet<C> union(RangeSet<C> rangeSet) {
        return unionOf(Iterables.concat(asRanges(), rangeSet.asRanges()));
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet.complement());
        return copyOf(create);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet);
        return copyOf(create);
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        final int i;
        int i2;
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        if (range.hasLowerBound()) {
            i = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        } else {
            i = 0;
        }
        if (range.hasUpperBound()) {
            i2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        } else {
            i2 = this.ranges.size();
        }
        final int i3 = i2 - i;
        if (i3 == 0) {
            return ImmutableList.of();
        }
        return new ImmutableList<Range<C>>() {
            /* access modifiers changed from: package-private */
            public boolean isPartialView() {
                return true;
            }

            public int size() {
                return i3;
            }

            public Range<C> get(int i) {
                Preconditions.checkElementIndex(i, i3);
                if (i == 0 || i == i3 - 1) {
                    return ((Range) ImmutableRangeSet.this.ranges.get(i + i)).intersection(range);
                }
                return (Range) ImmutableRangeSet.this.ranges.get(i + i);
            }
        };
    }

    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    private final class AsSet extends ImmutableSortedSet<C> {
        /* access modifiers changed from: private */
        public final DiscreteDomain<C> domain;
        @MonotonicNonNullDecl
        private transient Integer size;

        AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        public int size() {
            Integer num = this.size;
            if (num == null) {
                long j = 0;
                UnmodifiableIterator it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    j += (long) ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.saturatedCast(j));
                this.size = num;
            }
            return num.intValue();
        }

        public UnmodifiableIterator<C> iterator() {
            return new AbstractIterator<C>() {
                Iterator<C> elemItr = Iterators.emptyIterator();
                final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.iterator();

                /* access modifiers changed from: protected */
                public C computeNext() {
                    while (!this.elemItr.hasNext()) {
                        if (!this.rangeItr.hasNext()) {
                            return (Comparable) endOfData();
                        }
                        this.elemItr = ContiguousSet.create(this.rangeItr.next(), AsSet.this.domain).iterator();
                    }
                    return (Comparable) this.elemItr.next();
                }
            };
        }

        public UnmodifiableIterator<C> descendingIterator() {
            return new AbstractIterator<C>() {
                Iterator<C> elemItr = Iterators.emptyIterator();
                final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.reverse().iterator();

                /* access modifiers changed from: protected */
                public C computeNext() {
                    while (!this.elemItr.hasNext()) {
                        if (!this.rangeItr.hasNext()) {
                            return (Comparable) endOfData();
                        }
                        this.elemItr = ContiguousSet.create(this.rangeItr.next(), AsSet.this.domain).descendingIterator();
                    }
                    return (Comparable) this.elemItr.next();
                }
            };
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet(range).asSet(this.domain);
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> headSetImpl(C c, boolean z) {
            return subSet(Range.upTo(c, BoundType.forBoolean(z)));
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
            if (z || z2 || Range.compareOrThrow(c, c2) != 0) {
                return subSet(Range.range(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2)));
            }
            return ImmutableSortedSet.of();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> tailSetImpl(C c, boolean z) {
            return subSet(Range.downTo(c, BoundType.forBoolean(z)));
        }

        public boolean contains(@NullableDecl Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            long j = 0;
            UnmodifiableIterator it = ImmutableRangeSet.this.ranges.iterator();
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return Ints.saturatedCast(j + ((long) ContiguousSet.create(range, this.domain).indexOf(comparable)));
                }
                j += (long) ContiguousSet.create(range, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }
    }

    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder<>();
    }

    public static class Builder<C extends Comparable<?>> {
        private final List<Range<C>> ranges = Lists.newArrayList();

        public Builder<C> add(Range<C> range) {
            Preconditions.checkArgument(!range.isEmpty(), "range must not be empty, but was %s", (Object) range);
            this.ranges.add(range);
            return this;
        }

        public Builder<C> addAll(RangeSet<C> rangeSet) {
            return addAll(rangeSet.asRanges());
        }

        public Builder<C> addAll(Iterable<Range<C>> iterable) {
            for (Range<C> add : iterable) {
                add(add);
            }
            return this;
        }

        public ImmutableRangeSet<C> build() {
            ImmutableList.Builder builder = new ImmutableList.Builder(this.ranges.size());
            Collections.sort(this.ranges, Range.rangeLexOrdering());
            PeekingIterator<T> peekingIterator = Iterators.peekingIterator(this.ranges.iterator());
            while (peekingIterator.hasNext()) {
                Range range = (Range) peekingIterator.next();
                while (peekingIterator.hasNext()) {
                    Range range2 = (Range) peekingIterator.peek();
                    if (!range.isConnected(range2)) {
                        break;
                    }
                    Preconditions.checkArgument(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", (Object) range, (Object) range2);
                    range = range.span((Range) peekingIterator.next());
                }
                builder.add((Object) range);
            }
            ImmutableList build = builder.build();
            if (build.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (build.size() != 1 || !((Range) Iterables.getOnlyElement(build)).equals(Range.all())) {
                return new ImmutableRangeSet<>(build);
            }
            return ImmutableRangeSet.all();
        }
    }

    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }
}
