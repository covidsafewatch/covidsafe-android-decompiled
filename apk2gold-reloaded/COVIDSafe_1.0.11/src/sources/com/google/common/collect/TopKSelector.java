package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;
    private final int k;
    @NullableDecl
    private T threshold;

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i) {
        return least(i, Ordering.natural());
    }

    public static <T> TopKSelector<T> least(int i, Comparator<? super T> comparator2) {
        return new TopKSelector<>(comparator2, i);
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i) {
        return greatest(i, Ordering.natural());
    }

    public static <T> TopKSelector<T> greatest(int i, Comparator<? super T> comparator2) {
        return new TopKSelector<>(Ordering.from(comparator2).reverse(), i);
    }

    private TopKSelector(Comparator<? super T> comparator2, int i) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2, "comparator");
        this.k = i;
        Preconditions.checkArgument(i >= 0, "k must be nonnegative, was %s", i);
        this.buffer = (Object[]) new Object[(i * 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public void offer(@NullableDecl T t) {
        int i = this.k;
        if (i != 0) {
            int i2 = this.bufferSize;
            if (i2 == 0) {
                this.buffer[0] = t;
                this.threshold = t;
                this.bufferSize = 1;
            } else if (i2 < i) {
                T[] tArr = this.buffer;
                this.bufferSize = i2 + 1;
                tArr[i2] = t;
                if (this.comparator.compare(t, this.threshold) > 0) {
                    this.threshold = t;
                }
            } else if (this.comparator.compare(t, this.threshold) < 0) {
                T[] tArr2 = this.buffer;
                int i3 = this.bufferSize;
                int i4 = i3 + 1;
                this.bufferSize = i4;
                tArr2[i3] = t;
                if (i4 == this.k * 2) {
                    trim();
                }
            }
        }
    }

    private void trim() {
        int i = (this.k * 2) - 1;
        int log2 = IntMath.log2(i + 0, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            int partition = partition(i2, i, ((i2 + i) + 1) >>> 1);
            int i5 = this.k;
            if (partition <= i5) {
                if (partition >= i5) {
                    break;
                }
                i2 = Math.max(partition, i2 + 1);
                i4 = partition;
            } else {
                i = partition - 1;
            }
            i3++;
            if (i3 >= log2) {
                Arrays.sort(this.buffer, i2, i, this.comparator);
                break;
            }
        }
        this.bufferSize = this.k;
        this.threshold = this.buffer[i4];
        while (true) {
            i4++;
            if (i4 >= this.k) {
                return;
            }
            if (this.comparator.compare(this.buffer[i4], this.threshold) > 0) {
                this.threshold = this.buffer[i4];
            }
        }
    }

    private int partition(int i, int i2, int i3) {
        T[] tArr = this.buffer;
        T t = tArr[i3];
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.comparator.compare(this.buffer[i], t) < 0) {
                swap(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = t;
        return i4;
    }

    private void swap(int i, int i2) {
        T[] tArr = this.buffer;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int i = this.bufferSize;
        int i2 = this.k;
        if (i > i2) {
            T[] tArr = this.buffer;
            Arrays.fill(tArr, i2, tArr.length, null);
            int i3 = this.k;
            this.bufferSize = i3;
            this.threshold = this.buffer[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }
}
