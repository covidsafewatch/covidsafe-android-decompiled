package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Booleans {
    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static int hashCode(boolean z) {
        return z ? 1231 : 1237;
    }

    private Booleans() {
    }

    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        private final String toString;
        private final int trueValue;

        private BooleanComparator(int i, String str) {
            this.trueValue = i;
            this.toString = str;
        }

        public int compare(Boolean bool, Boolean bool2) {
            int i = 0;
            int i2 = bool.booleanValue() ? this.trueValue : 0;
            if (bool2.booleanValue()) {
                i = this.trueValue;
            }
            return i - i2;
        }

        public String toString() {
            return this.toString;
        }
    }

    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0, zArr.length);
    }

    /* access modifiers changed from: private */
    public static int indexOf(boolean[] zArr, boolean z, int i, int i2) {
        while (i < i2) {
            if (zArr[i] == z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, "target");
        if (zArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (zArr.length - zArr2.length) + 1) {
            int i2 = 0;
            while (i2 < zArr2.length) {
                if (zArr[i + i2] != zArr2[i2]) {
                    i++;
                } else {
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, 0, zArr.length);
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(boolean[] zArr, boolean z, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (zArr[i3] == z) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i = 0;
        for (boolean[] length : zArr) {
            i += length.length;
        }
        boolean[] zArr2 = new boolean[i];
        int i2 = 0;
        for (boolean[] zArr3 : zArr) {
            System.arraycopy(zArr3, 0, zArr2, i2, zArr3.length);
            i2 += zArr3.length;
        }
        return zArr2;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return zArr.length < i ? Arrays.copyOf(zArr, i + i2) : zArr;
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i = 1; i < zArr.length; i++) {
            sb.append(str);
            sb.append(zArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    private enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Booleans.compare(zArr[i], zArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = ((Boolean) Preconditions.checkNotNull(array[i])).booleanValue();
        }
        return zArr;
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(zArr);
    }

    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        public boolean isEmpty() {
            return false;
        }

        BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        BooleanArrayAsList(boolean[] zArr, int i, int i2) {
            this.array = zArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public Boolean get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Boolean.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Boolean) || (access$000 = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Boolean) || (access$100 = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public Boolean set(int i, Boolean bool) {
            Preconditions.checkElementIndex(i, size());
            boolean[] zArr = this.array;
            int i2 = this.start;
            boolean z = zArr[i2 + i];
            zArr[i2 + i] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z);
        }

        public List<Boolean> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i3 = this.start;
            return new BooleanArrayAsList(zArr, i + i3, i3 + i2);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != booleanArrayAsList.array[booleanArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Booleans.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.array[this.start] ? "[true" : "[false");
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(this.array[i] ? ", true" : ", false");
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    public static int countTrue(boolean... zArr) {
        int i = 0;
        for (boolean z : zArr) {
            if (z) {
                i++;
            }
        }
        return i;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static void reverse(boolean[] zArr, int i, int i2) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i, i2, zArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            boolean z = zArr[i];
            zArr[i] = zArr[i3];
            zArr[i3] = z;
            i++;
        }
    }
}
