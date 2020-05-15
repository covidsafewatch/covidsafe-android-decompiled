package com.google.common.collect;

import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    public abstract boolean encloses(Range<C> range);

    public abstract Range<C> rangeContaining(C c);

    AbstractRangeSet() {
    }

    public boolean contains(C c) {
        return rangeContaining(c) != null;
    }

    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean enclosesAll(RangeSet<C> rangeSet) {
        return enclosesAll(rangeSet.asRanges());
    }

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        for (Range<C> encloses : iterable) {
            if (!encloses(encloses)) {
                return false;
            }
        }
        return true;
    }

    public void addAll(RangeSet<C> rangeSet) {
        addAll(rangeSet.asRanges());
    }

    public void addAll(Iterable<Range<C>> iterable) {
        for (Range<C> add : iterable) {
            add(add);
        }
    }

    public void removeAll(RangeSet<C> rangeSet) {
        removeAll(rangeSet.asRanges());
    }

    public void removeAll(Iterable<Range<C>> iterable) {
        for (Range<C> remove : iterable) {
            remove(remove);
        }
    }

    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return asRanges().equals(((RangeSet) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public final String toString() {
        return asRanges().toString();
    }
}
