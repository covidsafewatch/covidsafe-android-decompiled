package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

public final class IntMath {
    static final int FLOOR_SQRT_MAX_INT = 46340;
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static final int[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    static final int[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static boolean isPowerOfTwo(int i) {
        boolean z = false;
        boolean z2 = i > 0;
        if ((i & (i - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    static int lessThanBranchFree(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    public static int mean(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    public static int ceilingPowerOfTwo(int i) {
        MathPreconditions.checkPositive("x", i);
        if (i <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i + ") not representable as an int");
    }

    public static int floorPowerOfTwo(int i) {
        MathPreconditions.checkPositive("x", i);
        return Integer.highestOneBit(i);
    }

    /* renamed from: com.google.common.math.IntMath$1  reason: invalid class name */
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
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
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
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.AnonymousClass1.<clinit>():void");
        }
    }

    public static int log2(int i, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log10(int r3, java.math.RoundingMode r4) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkPositive((java.lang.String) r0, (int) r3)
            int r0 = log10Floor(r3)
            int[] r1 = powersOf10
            r1 = r1[r0]
            int[] r2 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r4.ordinal()
            r4 = r2[r4]
            switch(r4) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0035;
                case 3: goto L_0x0035;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x001e:
            int[] r4 = halfPowersOf10
            r4 = r4[r0]
            int r3 = lessThanBranchFree(r4, r3)
        L_0x0026:
            int r0 = r0 + r3
            return r0
        L_0x0028:
            int r3 = lessThanBranchFree(r1, r3)
            goto L_0x0026
        L_0x002d:
            if (r3 != r1) goto L_0x0031
            r3 = 1
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r3)
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.log10(int, java.math.RoundingMode):int");
    }

    private static int log10Floor(int i) {
        byte b = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i)];
        return b - lessThanBranchFree(i, powersOf10[b]);
    }

    public static int pow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i != -2) {
            if (i == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            }
            if (i == 0) {
                return i2 == 0 ? 1 : 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i != 2) {
                int i3 = 1;
                while (i2 != 0) {
                    if (i2 == 1) {
                        return i * i3;
                    }
                    i3 *= (i2 & 1) == 0 ? 1 : i;
                    i *= i;
                    i2 >>= 1;
                }
                return i3;
            } else if (i2 < 32) {
                return 1 << i2;
            } else {
                return 0;
            }
        } else if (i2 < 32) {
            return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
        } else {
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        return r0 + r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int sqrt(int r2, java.math.RoundingMode r3) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkNonNegative((java.lang.String) r0, (int) r2)
            int r0 = sqrtFloor(r2)
            int[] r1 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r3 = r3.ordinal()
            r3 = r1[r3]
            switch(r3) {
                case 1: goto L_0x002a;
                case 2: goto L_0x0034;
                case 3: goto L_0x0034;
                case 4: goto L_0x0023;
                case 5: goto L_0x0023;
                case 6: goto L_0x001a;
                case 7: goto L_0x001a;
                case 8: goto L_0x001a;
                default: goto L_0x0014;
            }
        L_0x0014:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x001a:
            int r3 = r0 * r0
            int r3 = r3 + r0
            int r2 = lessThanBranchFree(r3, r2)
        L_0x0021:
            int r0 = r0 + r2
            return r0
        L_0x0023:
            int r3 = r0 * r0
            int r2 = lessThanBranchFree(r3, r2)
            goto L_0x0021
        L_0x002a:
            int r3 = r0 * r0
            if (r3 != r2) goto L_0x0030
            r2 = 1
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.sqrt(int, java.math.RoundingMode):int");
    }

    private static int sqrtFloor(int i) {
        return (int) Math.sqrt((double) i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r5 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r5 < 0) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L_0x005c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0057;
                case 3: goto L_0x004d;
                case 4: goto L_0x0058;
                case 5: goto L_0x004a;
                case 6: goto L_0x0025;
                case 7: goto L_0x0025;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L_0x0025:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L_0x0047
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L_0x0058
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r7 = r0 & 1
            if (r7 == 0) goto L_0x0042
            r7 = 1
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            r6 = r6 & r7
            if (r6 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0047:
            if (r1 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004a:
            if (r5 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004d:
            if (r5 >= 0) goto L_0x0057
            goto L_0x0058
        L_0x0050:
            if (r1 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L_0x0057:
            r2 = 0
        L_0x0058:
            if (r2 == 0) goto L_0x005b
            int r0 = r0 + r5
        L_0x005b:
            return r0
        L_0x005c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int mod(int i, int i2) {
        if (i2 > 0) {
            int i3 = i % i2;
            return i3 >= 0 ? i3 : i3 + i2;
        }
        throw new ArithmeticException("Modulus " + i2 + " must be > 0");
    }

    public static int gcd(int i, int i2) {
        MathPreconditions.checkNonNegative("a", i);
        MathPreconditions.checkNonNegative("b", i2);
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        int i3 = i >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros2;
        while (i3 != i4) {
            int i5 = i3 - i4;
            int i6 = (i5 >> 31) & i5;
            int i7 = (i5 - i6) - i6;
            i4 += i6;
            i3 = i7 >> Integer.numberOfTrailingZeros(i7);
        }
        return i3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static int checkedAdd(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int checkedSubtract(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    public static int checkedMultiply(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedMultiply", i, i2);
        return i3;
    }

    public static int checkedPow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        boolean z = false;
        if (i == -2) {
            if (i2 < 32) {
                z = true;
            }
            MathPreconditions.checkNoOverflow(z, "checkedPow", i, i2);
            return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
        } else if (i != -1) {
            if (i != 0) {
                if (i == 1) {
                    return 1;
                }
                if (i != 2) {
                    int i3 = 1;
                    while (i2 != 0) {
                        if (i2 == 1) {
                            return checkedMultiply(i3, i);
                        }
                        if ((i2 & 1) != 0) {
                            i3 = checkedMultiply(i3, i);
                        }
                        i2 >>= 1;
                        if (i2 > 0) {
                            MathPreconditions.checkNoOverflow((-46340 <= i) & (i <= FLOOR_SQRT_MAX_INT), "checkedPow", i, i2);
                            i *= i;
                        }
                    }
                    return i3;
                }
                if (i2 < 31) {
                    z = true;
                }
                MathPreconditions.checkNoOverflow(z, "checkedPow", i, i2);
                return 1 << i2;
            } else if (i2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if ((i2 & 1) == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int saturatedAdd(int i, int i2) {
        return Ints.saturatedCast(((long) i) + ((long) i2));
    }

    public static int saturatedSubtract(int i, int i2) {
        return Ints.saturatedCast(((long) i) - ((long) i2));
    }

    public static int saturatedMultiply(int i, int i2) {
        return Ints.saturatedCast(((long) i) * ((long) i2));
    }

    public static int saturatedPow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return 1;
                    }
                    if (i != 2) {
                        int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
                        int i4 = 1;
                        while (i2 != 0) {
                            if (i2 == 1) {
                                return saturatedMultiply(i4, i);
                            }
                            if ((i2 & 1) != 0) {
                                i4 = saturatedMultiply(i4, i);
                            }
                            i2 >>= 1;
                            if (i2 > 0) {
                                if ((-46340 > i) || (i > FLOOR_SQRT_MAX_INT)) {
                                    return i3;
                                }
                                i *= i;
                            }
                        }
                        return i4;
                    } else if (i2 >= 31) {
                        return Integer.MAX_VALUE;
                    } else {
                        return 1 << i2;
                    }
                } else if (i2 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i2 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i2 >= 32) {
            return (i2 & 1) + Integer.MAX_VALUE;
        } else {
            return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
        }
    }

    public static int factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        int[] iArr = factorials;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Integer.MAX_VALUE;
    }

    public static int binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        int i3 = 0;
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Integer.MAX_VALUE;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return i;
        }
        long j = 1;
        while (i3 < i2) {
            i3++;
            j = (j * ((long) (i - i3))) / ((long) i3);
        }
        return (int) j;
    }

    public static boolean isPrime(int i) {
        return LongMath.isPrime((long) i);
    }

    private IntMath() {
    }
}
