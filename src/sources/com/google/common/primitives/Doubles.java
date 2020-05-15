package com.google.common.primitives;

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
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Doubles {
    public static final int BYTES = 8;
    static final Pattern FLOATING_POINT_PATTERN = fpPattern();

    public static boolean isFinite(double d) {
        return Double.NEGATIVE_INFINITY < d && d < Double.POSITIVE_INFINITY;
    }

    private Doubles() {
    }

    public static int hashCode(double d) {
        return Double.valueOf(d).hashCode();
    }

    public static int compare(double d, double d2) {
        return Double.compare(d, d2);
    }

    public static boolean contains(double[] dArr, double d) {
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(double[] dArr, double d) {
        return indexOf(dArr, d, 0, dArr.length);
    }

    /* access modifiers changed from: private */
    public static int indexOf(double[] dArr, double d, int i, int i2) {
        while (i < i2) {
            if (dArr[i] == d) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double[] dArr2) {
        Preconditions.checkNotNull(dArr, "array");
        Preconditions.checkNotNull(dArr2, "target");
        if (dArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (dArr.length - dArr2.length) + 1) {
            int i2 = 0;
            while (i2 < dArr2.length) {
                if (dArr[i + i2] != dArr2[i2]) {
                    i++;
                } else {
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d) {
        return lastIndexOf(dArr, d, 0, dArr.length);
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(double[] dArr, double d, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (dArr[i3] == d) {
                return i3;
            }
        }
        return -1;
    }

    public static double min(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Math.min(d, dArr[i]);
        }
        return d;
    }

    public static double max(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Math.max(d, dArr[i]);
        }
        return d;
    }

    public static double constrainToRange(double d, double d2, double d3) {
        Preconditions.checkArgument(d2 <= d3, "min (%s) must be less than or equal to max (%s)", (Object) Double.valueOf(d2), (Object) Double.valueOf(d3));
        return Math.min(Math.max(d, d2), d3);
    }

    public static double[] concat(double[]... dArr) {
        int i = 0;
        for (double[] length : dArr) {
            i += length.length;
        }
        double[] dArr2 = new double[i];
        int i2 = 0;
        for (double[] dArr3 : dArr) {
            System.arraycopy(dArr3, 0, dArr2, i2, dArr3.length);
            i2 += dArr3.length;
        }
        return dArr2;
    }

    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = new DoubleConverter();
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Doubles.stringConverter()";
        }

        private DoubleConverter() {
        }

        /* access modifiers changed from: protected */
        public Double doForward(String str) {
            return Double.valueOf(str);
        }

        /* access modifiers changed from: protected */
        public String doBackward(Double d) {
            return d.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.INSTANCE;
    }

    public static double[] ensureCapacity(double[] dArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return dArr.length < i ? Arrays.copyOf(dArr, i + i2) : dArr;
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            sb.append(str);
            sb.append(dArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }

        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Double.compare(dArr[i], dArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr, int i, int i2) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i, i2, dArr.length);
        Arrays.sort(dArr, i, i2);
        reverse(dArr, i, i2);
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void reverse(double[] dArr, int i, int i2) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i, i2, dArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            double d = dArr[i];
            dArr[i] = dArr[i3];
            dArr[i3] = d;
            i++;
        }
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = ((Number) Preconditions.checkNotNull(array[i])).doubleValue();
        }
        return dArr;
    }

    public static List<Double> asList(double... dArr) {
        if (dArr.length == 0) {
            return Collections.emptyList();
        }
        return new DoubleArrayAsList(dArr);
    }

    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        public boolean isEmpty() {
            return false;
        }

        DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        DoubleArrayAsList(double[] dArr, int i, int i2) {
            this.array = dArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public Double get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Double.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Double) || (access$000 = Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Double) || (access$100 = Doubles.lastIndexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public Double set(int i, Double d) {
            Preconditions.checkElementIndex(i, size());
            double[] dArr = this.array;
            int i2 = this.start;
            double d2 = dArr[i2 + i];
            dArr[i2 + i] = ((Double) Preconditions.checkNotNull(d)).doubleValue();
            return Double.valueOf(d2);
        }

        public List<Double> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i3 = this.start;
            return new DoubleArrayAsList(dArr, i + i3, i3 + i2);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != doubleArrayAsList.array[doubleArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Doubles.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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
        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    private static Pattern fpPattern() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)" + "(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX]" + "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)" + "[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    @NullableDecl
    public static Double tryParse(String str) {
        if (!FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
