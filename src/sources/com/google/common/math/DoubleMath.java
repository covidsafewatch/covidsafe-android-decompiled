package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

public final class DoubleMath {
    private static final double LN_2 = Math.log(2.0d);
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    static double roundIntermediate(double d, RoundingMode roundingMode) {
        if (DoubleUtils.isFinite(d)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d));
                    return d;
                case 2:
                    return (d >= LN_2 || isMathematicalInteger(d)) ? d : (double) (((long) d) - 1);
                case 3:
                    return (d <= LN_2 || isMathematicalInteger(d)) ? d : (double) (((long) d) + 1);
                case 4:
                    return d;
                case 5:
                    if (isMathematicalInteger(d)) {
                        return d;
                    }
                    return (double) (((long) d) + ((long) (d > LN_2 ? 1 : -1)));
                case 6:
                    return Math.rint(d);
                case 7:
                    double rint = Math.rint(d);
                    return Math.abs(d - rint) == 0.5d ? d + Math.copySign(0.5d, d) : rint;
                case 8:
                    double rint2 = Math.rint(d);
                    return Math.abs(d - rint2) == 0.5d ? d : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    /* renamed from: com.google.common.math.DoubleMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.AnonymousClass1.<clinit>():void");
        }
    }

    public static int roundToInt(double d, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d, roundingMode);
        boolean z = true;
        boolean z2 = roundIntermediate > -2.147483649E9d;
        if (roundIntermediate >= 2.147483648E9d) {
            z = false;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z2 & z, d, roundingMode);
        return (int) roundIntermediate;
    }

    public static long roundToLong(double d, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d, roundingMode);
        boolean z = true;
        boolean z2 = MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d;
        if (roundIntermediate >= MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            z = false;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z2 & z, d, roundingMode);
        return (long) roundIntermediate;
    }

    public static BigInteger roundToBigInteger(double d, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d, roundingMode);
        boolean z = true;
        boolean z2 = MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d;
        if (roundIntermediate >= MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            z = false;
        }
        if (z2 && z) {
            return BigInteger.valueOf((long) roundIntermediate);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        return roundIntermediate < LN_2 ? shiftLeft.negate() : shiftLeft;
    }

    public static boolean isPowerOfTwo(double d) {
        if (d <= LN_2 || !DoubleUtils.isFinite(d)) {
            return false;
        }
        long significand = DoubleUtils.getSignificand(d);
        if ((significand & (significand - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static double log2(double d) {
        return Math.log(d) / LN_2;
    }

    public static int log2(double d, RoundingMode roundingMode) {
        boolean z;
        boolean z2 = false;
        Preconditions.checkArgument(d > LN_2 && DoubleUtils.isFinite(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (!DoubleUtils.isNormal(d)) {
            return log2(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(d));
                break;
            case 2:
                break;
            case 3:
                z2 = !isPowerOfTwo(d);
                break;
            case 4:
                if (exponent < 0) {
                    z2 = true;
                }
                z = isPowerOfTwo(d);
                break;
            case 5:
                if (exponent >= 0) {
                    z2 = true;
                }
                z = isPowerOfTwo(d);
                break;
            case 6:
            case 7:
            case 8:
                double scaleNormalize = DoubleUtils.scaleNormalize(d);
                if (scaleNormalize * scaleNormalize > 2.0d) {
                    z2 = true;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        z2 &= !z;
        return z2 ? exponent + 1 : exponent;
    }

    public static boolean isMathematicalInteger(double d) {
        return DoubleUtils.isFinite(d) && (d == LN_2 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d)) <= Math.getExponent(d));
    }

    public static double factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        if (i > MAX_FACTORIAL) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        int i2 = i & -16;
        while (true) {
            i2++;
            if (i2 > i) {
                return d * everySixteenthFactorial[i >> 4];
            }
            d *= (double) i2;
        }
    }

    public static boolean fuzzyEquals(double d, double d2, double d3) {
        MathPreconditions.checkNonNegative("tolerance", d3);
        return Math.copySign(d - d2, 1.0d) <= d3 || d == d2 || (Double.isNaN(d) && Double.isNaN(d2));
    }

    public static int fuzzyCompare(double d, double d2, double d3) {
        if (fuzzyEquals(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d), Double.isNaN(d2));
    }

    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double checkFinite = checkFinite(dArr[0]);
        long j = 1;
        for (int i = 1; i < dArr.length; i++) {
            checkFinite(dArr[i]);
            j++;
            checkFinite += (dArr[i] - checkFinite) / ((double) j);
        }
        return checkFinite;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j = 0;
        for (int i : iArr) {
            j += (long) i;
        }
        return ((double) j) / ((double) iArr.length);
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d = (double) jArr[0];
        long j = 1;
        for (int i = 1; i < jArr.length; i++) {
            j++;
            d += (((double) jArr[i]) - d) / ((double) j);
        }
        return d;
    }

    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double checkFinite = checkFinite(((Number) it.next()).doubleValue());
        long j = 1;
        while (it.hasNext()) {
            j++;
            checkFinite += (checkFinite(((Number) it.next()).doubleValue()) - checkFinite) / ((double) j);
        }
        return checkFinite;
    }

    private static double checkFinite(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return d;
    }

    private DoubleMath() {
    }
}
