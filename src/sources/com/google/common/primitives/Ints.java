package com.google.common.primitives;

import com.google.common.base.Ascii;
import com.google.common.base.Converter;
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

public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int fromBytes(byte b, byte b2, byte b3, byte b4) {
        return (b << Ascii.CAN) | ((b2 & 255) << Ascii.DLE) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static int hashCode(int i) {
        return i;
    }

    public static int saturatedCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static byte[] toByteArray(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    private Ints() {
    }

    public static int checkedCast(long j) {
        int i = (int) j;
        Preconditions.checkArgument(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static boolean contains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] iArr, int i) {
        return indexOf(iArr, i, 0, iArr.length);
    }

    /* access modifiers changed from: private */
    public static int indexOf(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(int[] iArr, int[] iArr2) {
        Preconditions.checkNotNull(iArr, "array");
        Preconditions.checkNotNull(iArr2, "target");
        if (iArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (iArr.length - iArr2.length) + 1) {
            int i2 = 0;
            while (i2 < iArr2.length) {
                if (iArr[i + i2] != iArr2[i2]) {
                    i++;
                } else {
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i) {
        return lastIndexOf(iArr, i, 0, iArr.length);
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int constrainToRange(int i, int i2, int i3) {
        Preconditions.checkArgument(i2 <= i3, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static int[] concat(int[]... iArr) {
        int i = 0;
        for (int[] length : iArr) {
            i += length.length;
        }
        int[] iArr2 = new int[i];
        int i2 = 0;
        for (int[] iArr3 : iArr) {
            System.arraycopy(iArr3, 0, iArr2, i2, iArr3.length);
            i2 += iArr3.length;
        }
        return iArr2;
    }

    public static int fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    private static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Ints.stringConverter()";
        }

        private IntConverter() {
        }

        /* access modifiers changed from: protected */
        public Integer doForward(String str) {
            return Integer.decode(str);
        }

        /* access modifiers changed from: protected */
        public String doBackward(Integer num) {
            return num.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] ensureCapacity(int[] iArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return iArr.length < i ? Arrays.copyOf(iArr, i + i2) : iArr;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            sb.append(str);
            sb.append(iArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Ints.compare(iArr[i], iArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr, int i, int i2) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i, i2, iArr.length);
        Arrays.sort(iArr, i, i2);
        reverse(iArr, i, i2);
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static void reverse(int[] iArr, int i, int i2) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i, i2, iArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            int i4 = iArr[i];
            iArr[i] = iArr[i3];
            iArr[i3] = i4;
            i++;
        }
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) Preconditions.checkNotNull(array[i])).intValue();
        }
        return iArr;
    }

    public static List<Integer> asList(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new IntArrayAsList(iArr);
    }

    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public boolean isEmpty() {
            return false;
        }

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        IntArrayAsList(int[] iArr, int i, int i2) {
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public Integer get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Integer) || (access$000 = Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Integer) || (access$100 = Ints.lastIndexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public Integer set(int i, Integer num) {
            Preconditions.checkElementIndex(i, size());
            int[] iArr = this.array;
            int i2 = this.start;
            int i3 = iArr[i2 + i];
            iArr[i2 + i] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i3);
        }

        public List<Integer> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i3 = this.start;
            return new IntArrayAsList(iArr, i + i3, i3 + i2);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != intArrayAsList.array[intArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Ints.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(", ");
                    sb.append(this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    @NullableDecl
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    @NullableDecl
    public static Integer tryParse(String str, int i) {
        Long tryParse = Longs.tryParse(str, i);
        if (tryParse == null || tryParse.longValue() != ((long) tryParse.intValue())) {
            return null;
        }
        return Integer.valueOf(tryParse.intValue());
    }
}
