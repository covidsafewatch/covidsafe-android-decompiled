package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @NullableDecl
    private final T lowerEndpoint;
    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @NullableDecl
    private final T upperEndpoint;

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        Comparable comparable = null;
        Object lowerEndpoint2 = range.hasLowerBound() ? range.lowerEndpoint() : null;
        BoundType lowerBoundType2 = range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN;
        if (range.hasUpperBound()) {
            comparable = range.upperEndpoint();
        }
        GeneralRange generalRange = new GeneralRange(Ordering.natural(), range.hasLowerBound(), lowerEndpoint2, lowerBoundType2, range.hasUpperBound(), comparable, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
        return generalRange;
    }

    static <T> GeneralRange<T> all(Comparator<? super T> comparator2) {
        GeneralRange generalRange = new GeneralRange(comparator2, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
        return generalRange;
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> comparator2, @NullableDecl T t, BoundType boundType) {
        GeneralRange generalRange = new GeneralRange(comparator2, true, t, boundType, false, null, BoundType.OPEN);
        return generalRange;
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> comparator2, @NullableDecl T t, BoundType boundType) {
        GeneralRange generalRange = new GeneralRange(comparator2, false, null, BoundType.OPEN, true, t, boundType);
        return generalRange;
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator2, @NullableDecl T t, BoundType boundType, @NullableDecl T t2, BoundType boundType2) {
        GeneralRange generalRange = new GeneralRange(comparator2, true, t, boundType, true, t2, boundType2);
        return generalRange;
    }

    private GeneralRange(Comparator<? super T> comparator2, boolean z, @NullableDecl T t, BoundType boundType, boolean z2, @NullableDecl T t2, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator2.compare(t, t);
        }
        if (z2) {
            comparator2.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator2.compare(t, t2);
            boolean z3 = true;
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", (Object) t, (Object) t2);
            if (compare == 0) {
                boolean z4 = boundType != BoundType.OPEN;
                if (boundType2 == BoundType.OPEN) {
                    z3 = false;
                }
                Preconditions.checkArgument(z4 | z3);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    /* access modifiers changed from: 0000 */
    public boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    /* access modifiers changed from: 0000 */
    public boolean tooLow(@NullableDecl T t) {
        boolean z = false;
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (getLowerBoundType() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    /* access modifiers changed from: 0000 */
    public boolean tooHigh(@NullableDecl T t) {
        boolean z = false;
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (getUpperBoundType() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    /* access modifiers changed from: 0000 */
    public boolean contains(@NullableDecl T t) {
        return !tooLow(t) && !tooHigh(t);
    }

    /* access modifiers changed from: 0000 */
    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        BoundType boundType;
        BoundType boundType2;
        Object obj;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z = this.hasLowerBound;
        Object lowerEndpoint2 = getLowerEndpoint();
        BoundType lowerBoundType2 = getLowerBoundType();
        if (!hasLowerBound()) {
            z = generalRange.hasLowerBound;
            lowerEndpoint2 = generalRange.getLowerEndpoint();
            lowerBoundType2 = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound()) {
            int compare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint());
            if (compare < 0 || (compare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN)) {
                lowerEndpoint2 = generalRange.getLowerEndpoint();
                lowerBoundType2 = generalRange.getLowerBoundType();
            }
        }
        boolean z2 = z;
        boolean z3 = this.hasUpperBound;
        Object upperEndpoint2 = getUpperEndpoint();
        BoundType upperBoundType2 = getUpperBoundType();
        if (!hasUpperBound()) {
            z3 = generalRange.hasUpperBound;
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound()) {
            int compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint());
            if (compare2 > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN)) {
                upperEndpoint2 = generalRange.getUpperEndpoint();
                upperBoundType2 = generalRange.getUpperBoundType();
            }
        }
        boolean z4 = z3;
        Object obj2 = upperEndpoint2;
        if (z2 && z4) {
            int compare3 = this.comparator.compare(lowerEndpoint2, obj2);
            if (compare3 > 0 || (compare3 == 0 && lowerBoundType2 == BoundType.OPEN && upperBoundType2 == BoundType.OPEN)) {
                boundType2 = BoundType.OPEN;
                boundType = BoundType.CLOSED;
                obj = obj2;
                GeneralRange generalRange2 = new GeneralRange(this.comparator, z2, obj, boundType2, z4, obj2, boundType);
                return generalRange2;
            }
        }
        obj = lowerEndpoint2;
        boundType2 = lowerBoundType2;
        boundType = upperBoundType2;
        GeneralRange generalRange22 = new GeneralRange(this.comparator, z2, obj, boundType2, z4, obj2, boundType);
        return generalRange22;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        if (!this.comparator.equals(generalRange.comparator) || this.hasLowerBound != generalRange.hasLowerBound || this.hasUpperBound != generalRange.hasUpperBound || !getLowerBoundType().equals(generalRange.getLowerBoundType()) || !getUpperBoundType().equals(generalRange.getUpperBoundType()) || !Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) || !Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    /* access modifiers changed from: 0000 */
    public GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange generalRange2 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        sb.append(this.lowerBoundType == BoundType.CLOSED ? '[' : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(',');
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == BoundType.CLOSED ? ']' : ')');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    /* access modifiers changed from: 0000 */
    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    /* access modifiers changed from: 0000 */
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    /* access modifiers changed from: 0000 */
    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
