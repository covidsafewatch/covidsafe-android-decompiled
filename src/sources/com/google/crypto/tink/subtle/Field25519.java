package com.google.crypto.tink.subtle;

import java.util.Arrays;

final class Field25519 {
    private static final int[] EXPAND_SHIFT = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] EXPAND_START = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    static final int FIELD_LEN = 32;
    static final int LIMB_CNT = 10;
    private static final int[] MASK = {67108863, 33554431};
    private static final int[] SHIFT = {26, 25};
    private static final long TWO_TO_25 = 33554432;
    private static final long TWO_TO_26 = 67108864;

    private static int eq(int i, int i2) {
        int i3 = ~(i ^ i2);
        int i4 = i3 & (i3 << 16);
        int i5 = i4 & (i4 << 8);
        int i6 = i5 & (i5 << 4);
        int i7 = i6 & (i6 << 2);
        return (i7 & (i7 << 1)) >> 31;
    }

    private static int gte(int i, int i2) {
        return ~((i - i2) >> 31);
    }

    Field25519() {
    }

    static void sum(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    static void sum(long[] jArr, long[] jArr2) {
        sum(jArr, jArr, jArr2);
    }

    static void sub(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    static void sub(long[] jArr, long[] jArr2) {
        sub(jArr, jArr2, jArr);
    }

    static void scalarProduct(long[] jArr, long[] jArr2, long j) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j;
        }
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void product(long[] r18, long[] r19, long[] r20) {
        /*
            r0 = 0
            r1 = r19[r0]
            r3 = r20[r0]
            long r1 = r1 * r3
            r18[r0] = r1
            r1 = r19[r0]
            r3 = 1
            r4 = r20[r3]
            long r1 = r1 * r4
            r4 = r19[r3]
            r6 = r20[r0]
            long r4 = r4 * r6
            long r1 = r1 + r4
            r18[r3] = r1
            r1 = r19[r3]
            r4 = 2
            long r1 = r1 * r4
            r6 = r20[r3]
            long r1 = r1 * r6
            r6 = r19[r0]
            r8 = 2
            r9 = r20[r8]
            long r6 = r6 * r9
            long r1 = r1 + r6
            r6 = r19[r8]
            r9 = r20[r0]
            long r6 = r6 * r9
            long r1 = r1 + r6
            r18[r8] = r1
            r1 = r19[r3]
            r6 = r20[r8]
            long r1 = r1 * r6
            r6 = r19[r8]
            r9 = r20[r3]
            long r6 = r6 * r9
            long r1 = r1 + r6
            r6 = r19[r0]
            r9 = 3
            r10 = r20[r9]
            long r6 = r6 * r10
            long r1 = r1 + r6
            r6 = r19[r9]
            r10 = r20[r0]
            long r6 = r6 * r10
            long r1 = r1 + r6
            r18[r9] = r1
            r1 = r19[r8]
            r6 = r20[r8]
            long r1 = r1 * r6
            r6 = r19[r3]
            r10 = r20[r9]
            long r6 = r6 * r10
            r10 = r19[r9]
            r12 = r20[r3]
            long r10 = r10 * r12
            long r6 = r6 + r10
            long r6 = r6 * r4
            long r1 = r1 + r6
            r6 = r19[r0]
            r10 = 4
            r11 = r20[r10]
            long r6 = r6 * r11
            long r1 = r1 + r6
            r6 = r19[r10]
            r11 = r20[r0]
            long r6 = r6 * r11
            long r1 = r1 + r6
            r18[r10] = r1
            r1 = r19[r8]
            r6 = r20[r9]
            long r1 = r1 * r6
            r6 = r19[r9]
            r11 = r20[r8]
            long r6 = r6 * r11
            long r1 = r1 + r6
            r6 = r19[r3]
            r11 = r20[r10]
            long r6 = r6 * r11
            long r1 = r1 + r6
            r6 = r19[r10]
            r11 = r20[r3]
            long r6 = r6 * r11
            long r1 = r1 + r6
            r6 = r19[r0]
            r11 = 5
            r12 = r20[r11]
            long r6 = r6 * r12
            long r1 = r1 + r6
            r6 = r19[r11]
            r12 = r20[r0]
            long r6 = r6 * r12
            long r1 = r1 + r6
            r18[r11] = r1
            r1 = r19[r9]
            r6 = r20[r9]
            long r1 = r1 * r6
            r6 = r19[r3]
            r12 = r20[r11]
            long r6 = r6 * r12
            long r1 = r1 + r6
            r6 = r19[r11]
            r12 = r20[r3]
            long r6 = r6 * r12
            long r1 = r1 + r6
            long r1 = r1 * r4
            r6 = r19[r8]
            r12 = r20[r10]
            long r6 = r6 * r12
            long r1 = r1 + r6
            r6 = r19[r10]
            r12 = r20[r8]
            long r6 = r6 * r12
            long r1 = r1 + r6
            r6 = r19[r0]
            r12 = 6
            r13 = r20[r12]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r19[r12]
            r13 = r20[r0]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r18[r12] = r1
            r1 = r19[r9]
            r6 = r20[r10]
            long r1 = r1 * r6
            r6 = r19[r10]
            r13 = r20[r9]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r19[r8]
            r13 = r20[r11]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r19[r11]
            r13 = r20[r8]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r19[r3]
            r13 = r20[r12]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r19[r12]
            r13 = r20[r3]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r19[r0]
            r13 = 7
            r14 = r20[r13]
            long r6 = r6 * r14
            long r1 = r1 + r6
            r6 = r19[r13]
            r14 = r20[r0]
            long r6 = r6 * r14
            long r1 = r1 + r6
            r18[r13] = r1
            r1 = r19[r10]
            r6 = r20[r10]
            long r1 = r1 * r6
            r6 = r19[r9]
            r14 = r20[r11]
            long r6 = r6 * r14
            r14 = r19[r11]
            r16 = r20[r9]
            long r14 = r14 * r16
            long r6 = r6 + r14
            r14 = r19[r3]
            r16 = r20[r13]
            long r14 = r14 * r16
            long r6 = r6 + r14
            r14 = r19[r13]
            r16 = r20[r3]
            long r14 = r14 * r16
            long r6 = r6 + r14
            long r6 = r6 * r4
            long r1 = r1 + r6
            r6 = r19[r8]
            r14 = r20[r12]
            long r6 = r6 * r14
            long r1 = r1 + r6
            r6 = r19[r12]
            r14 = r20[r8]
            long r6 = r6 * r14
            long r1 = r1 + r6
            r6 = r19[r0]
            r14 = 8
            r15 = r20[r14]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r14]
            r15 = r20[r0]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r18[r14] = r1
            r1 = r19[r10]
            r6 = r20[r11]
            long r1 = r1 * r6
            r6 = r19[r11]
            r15 = r20[r10]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r9]
            r15 = r20[r12]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r12]
            r15 = r20[r9]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r8]
            r15 = r20[r13]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r13]
            r15 = r20[r8]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r3]
            r15 = r20[r14]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r14]
            r15 = r20[r3]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r19[r0]
            r15 = 9
            r16 = r20[r15]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r6 = r19[r15]
            r16 = r20[r0]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r18[r15] = r1
            r0 = r19[r11]
            r6 = r20[r11]
            long r0 = r0 * r6
            r6 = r19[r9]
            r16 = r20[r13]
            long r6 = r6 * r16
            long r0 = r0 + r6
            r6 = r19[r13]
            r16 = r20[r9]
            long r6 = r6 * r16
            long r0 = r0 + r6
            r6 = r19[r3]
            r16 = r20[r15]
            long r6 = r6 * r16
            long r0 = r0 + r6
            r6 = r19[r15]
            r2 = r20[r3]
            long r6 = r6 * r2
            long r0 = r0 + r6
            long r0 = r0 * r4
            r2 = r19[r10]
            r6 = r20[r12]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r12]
            r6 = r20[r10]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r8]
            r6 = r20[r14]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r14]
            r6 = r20[r8]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 10
            r18[r2] = r0
            r0 = r19[r11]
            r2 = r20[r12]
            long r0 = r0 * r2
            r2 = r19[r12]
            r6 = r20[r11]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r10]
            r6 = r20[r13]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r13]
            r6 = r20[r10]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r9]
            r6 = r20[r14]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r14]
            r6 = r20[r9]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r8]
            r6 = r20[r15]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r15]
            r6 = r20[r8]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 11
            r18[r2] = r0
            r0 = r19[r12]
            r2 = r20[r12]
            long r0 = r0 * r2
            r2 = r19[r11]
            r6 = r20[r13]
            long r2 = r2 * r6
            r6 = r19[r13]
            r16 = r20[r11]
            long r6 = r6 * r16
            long r2 = r2 + r6
            r6 = r19[r9]
            r16 = r20[r15]
            long r6 = r6 * r16
            long r2 = r2 + r6
            r6 = r19[r15]
            r8 = r20[r9]
            long r6 = r6 * r8
            long r2 = r2 + r6
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r10]
            r6 = r20[r14]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r14]
            r6 = r20[r10]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 12
            r18[r2] = r0
            r0 = r19[r12]
            r2 = r20[r13]
            long r0 = r0 * r2
            r2 = r19[r13]
            r6 = r20[r12]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r11]
            r6 = r20[r14]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r14]
            r6 = r20[r11]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r10]
            r6 = r20[r15]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r15]
            r6 = r20[r10]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 13
            r18[r2] = r0
            r0 = r19[r13]
            r2 = r20[r13]
            long r0 = r0 * r2
            r2 = r19[r11]
            r6 = r20[r15]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r15]
            r6 = r20[r11]
            long r2 = r2 * r6
            long r0 = r0 + r2
            long r0 = r0 * r4
            r2 = r19[r12]
            r6 = r20[r14]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r14]
            r6 = r20[r12]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 14
            r18[r2] = r0
            r0 = r19[r13]
            r2 = r20[r14]
            long r0 = r0 * r2
            r2 = r19[r14]
            r6 = r20[r13]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r12]
            r6 = r20[r15]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = r19[r15]
            r6 = r20[r12]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 15
            r18[r2] = r0
            r0 = r19[r14]
            r2 = r20[r14]
            long r0 = r0 * r2
            r2 = r19[r13]
            r6 = r20[r15]
            long r2 = r2 * r6
            r6 = r19[r15]
            r8 = r20[r13]
            long r6 = r6 * r8
            long r2 = r2 + r6
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 16
            r18[r2] = r0
            r0 = r19[r14]
            r2 = r20[r15]
            long r0 = r0 * r2
            r2 = r19[r15]
            r6 = r20[r14]
            long r2 = r2 * r6
            long r0 = r0 + r2
            r2 = 17
            r18[r2] = r0
            r0 = r19[r15]
            long r0 = r0 * r4
            r2 = r20[r15]
            long r0 = r0 * r2
            r2 = 18
            r18[r2] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Field25519.product(long[], long[], long[]):void");
    }

    static void reduce(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        reduceSizeByModularReduction(jArr);
        reduceCoefficients(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void reduceSizeByModularReduction(long[] jArr) {
        jArr[8] = jArr[8] + (jArr[18] << 4);
        jArr[8] = jArr[8] + (jArr[18] << 1);
        jArr[8] = jArr[8] + jArr[18];
        jArr[7] = jArr[7] + (jArr[17] << 4);
        jArr[7] = jArr[7] + (jArr[17] << 1);
        jArr[7] = jArr[7] + jArr[17];
        jArr[6] = jArr[6] + (jArr[16] << 4);
        jArr[6] = jArr[6] + (jArr[16] << 1);
        jArr[6] = jArr[6] + jArr[16];
        jArr[5] = jArr[5] + (jArr[15] << 4);
        jArr[5] = jArr[5] + (jArr[15] << 1);
        jArr[5] = jArr[5] + jArr[15];
        jArr[4] = jArr[4] + (jArr[14] << 4);
        jArr[4] = jArr[4] + (jArr[14] << 1);
        jArr[4] = jArr[4] + jArr[14];
        jArr[3] = jArr[3] + (jArr[13] << 4);
        jArr[3] = jArr[3] + (jArr[13] << 1);
        jArr[3] = jArr[3] + jArr[13];
        jArr[2] = jArr[2] + (jArr[12] << 4);
        jArr[2] = jArr[2] + (jArr[12] << 1);
        jArr[2] = jArr[2] + jArr[12];
        jArr[1] = jArr[1] + (jArr[11] << 4);
        jArr[1] = jArr[1] + (jArr[11] << 1);
        jArr[1] = jArr[1] + jArr[11];
        jArr[0] = jArr[0] + (jArr[10] << 4);
        jArr[0] = jArr[0] + (jArr[10] << 1);
        jArr[0] = jArr[0] + jArr[10];
    }

    static void reduceCoefficients(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr[i] / TWO_TO_26;
            jArr[i] = jArr[i] - (j << 26);
            int i2 = i + 1;
            jArr[i2] = jArr[i2] + j;
            long j2 = jArr[i2] / TWO_TO_25;
            jArr[i2] = jArr[i2] - (j2 << 25);
            i += 2;
            jArr[i] = jArr[i] + j2;
        }
        jArr[0] = jArr[0] + (jArr[10] << 4);
        jArr[0] = jArr[0] + (jArr[10] << 1);
        jArr[0] = jArr[0] + jArr[10];
        jArr[10] = 0;
        long j3 = jArr[0] / TWO_TO_26;
        jArr[0] = jArr[0] - (j3 << 26);
        jArr[1] = jArr[1] + j3;
    }

    static void mult(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        product(jArr4, jArr2, jArr3);
        reduce(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r23v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void squareInner(long[] r23, long[] r24) {
        /*
            r0 = 0
            r1 = r24[r0]
            r3 = r24[r0]
            long r1 = r1 * r3
            r23[r0] = r1
            r1 = r24[r0]
            r3 = 2
            long r1 = r1 * r3
            r5 = 1
            r6 = r24[r5]
            long r1 = r1 * r6
            r23[r5] = r1
            r1 = r24[r5]
            r6 = r24[r5]
            long r1 = r1 * r6
            r6 = r24[r0]
            r8 = 2
            r9 = r24[r8]
            long r6 = r6 * r9
            long r1 = r1 + r6
            long r1 = r1 * r3
            r23[r8] = r1
            r1 = r24[r5]
            r6 = r24[r8]
            long r1 = r1 * r6
            r6 = r24[r0]
            r9 = 3
            r10 = r24[r9]
            long r6 = r6 * r10
            long r1 = r1 + r6
            long r1 = r1 * r3
            r23[r9] = r1
            r1 = r24[r8]
            r6 = r24[r8]
            long r1 = r1 * r6
            r6 = r24[r5]
            r10 = 4
            long r6 = r6 * r10
            r12 = r24[r9]
            long r6 = r6 * r12
            long r1 = r1 + r6
            r6 = r24[r0]
            long r6 = r6 * r3
            r12 = 4
            r13 = r24[r12]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r23[r12] = r1
            r1 = r24[r8]
            r6 = r24[r9]
            long r1 = r1 * r6
            r6 = r24[r5]
            r13 = r24[r12]
            long r6 = r6 * r13
            long r1 = r1 + r6
            r6 = r24[r0]
            r13 = 5
            r14 = r24[r13]
            long r6 = r6 * r14
            long r1 = r1 + r6
            long r1 = r1 * r3
            r23[r13] = r1
            r1 = r24[r9]
            r6 = r24[r9]
            long r1 = r1 * r6
            r6 = r24[r8]
            r14 = r24[r12]
            long r6 = r6 * r14
            long r1 = r1 + r6
            r6 = r24[r0]
            r14 = 6
            r15 = r24[r14]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r24[r5]
            long r6 = r6 * r3
            r15 = r24[r13]
            long r6 = r6 * r15
            long r1 = r1 + r6
            long r1 = r1 * r3
            r23[r14] = r1
            r1 = r24[r9]
            r6 = r24[r12]
            long r1 = r1 * r6
            r6 = r24[r8]
            r15 = r24[r13]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r24[r5]
            r15 = r24[r14]
            long r6 = r6 * r15
            long r1 = r1 + r6
            r6 = r24[r0]
            r15 = 7
            r16 = r24[r15]
            long r6 = r6 * r16
            long r1 = r1 + r6
            long r1 = r1 * r3
            r23[r15] = r1
            r1 = r24[r12]
            r6 = r24[r12]
            long r1 = r1 * r6
            r6 = r24[r8]
            r16 = r24[r14]
            long r6 = r6 * r16
            r16 = r24[r0]
            r18 = 8
            r19 = r24[r18]
            long r16 = r16 * r19
            long r6 = r6 + r16
            r16 = r24[r5]
            r19 = r24[r15]
            long r16 = r16 * r19
            r19 = r24[r9]
            r21 = r24[r13]
            long r19 = r19 * r21
            long r16 = r16 + r19
            long r16 = r16 * r3
            long r6 = r6 + r16
            long r6 = r6 * r3
            long r1 = r1 + r6
            r23[r18] = r1
            r1 = r24[r12]
            r6 = r24[r13]
            long r1 = r1 * r6
            r6 = r24[r9]
            r16 = r24[r14]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r6 = r24[r8]
            r16 = r24[r15]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r6 = r24[r5]
            r16 = r24[r18]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r6 = r24[r0]
            r0 = 9
            r16 = r24[r0]
            long r6 = r6 * r16
            long r1 = r1 + r6
            long r1 = r1 * r3
            r23[r0] = r1
            r1 = r24[r13]
            r6 = r24[r13]
            long r1 = r1 * r6
            r6 = r24[r12]
            r16 = r24[r14]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r6 = r24[r8]
            r16 = r24[r18]
            long r6 = r6 * r16
            long r1 = r1 + r6
            r6 = r24[r9]
            r16 = r24[r15]
            long r6 = r6 * r16
            r16 = r24[r5]
            r19 = r24[r0]
            long r16 = r16 * r19
            long r6 = r6 + r16
            long r6 = r6 * r3
            long r1 = r1 + r6
            long r1 = r1 * r3
            r5 = 10
            r23[r5] = r1
            r1 = r24[r13]
            r5 = r24[r14]
            long r1 = r1 * r5
            r5 = r24[r12]
            r16 = r24[r15]
            long r5 = r5 * r16
            long r1 = r1 + r5
            r5 = r24[r9]
            r16 = r24[r18]
            long r5 = r5 * r16
            long r1 = r1 + r5
            r5 = r24[r8]
            r7 = r24[r0]
            long r5 = r5 * r7
            long r1 = r1 + r5
            long r1 = r1 * r3
            r5 = 11
            r23[r5] = r1
            r1 = r24[r14]
            r5 = r24[r14]
            long r1 = r1 * r5
            r5 = r24[r12]
            r7 = r24[r18]
            long r5 = r5 * r7
            r7 = r24[r13]
            r16 = r24[r15]
            long r7 = r7 * r16
            r16 = r24[r9]
            r19 = r24[r0]
            long r16 = r16 * r19
            long r7 = r7 + r16
            long r7 = r7 * r3
            long r5 = r5 + r7
            long r5 = r5 * r3
            long r1 = r1 + r5
            r5 = 12
            r23[r5] = r1
            r1 = r24[r14]
            r5 = r24[r15]
            long r1 = r1 * r5
            r5 = r24[r13]
            r7 = r24[r18]
            long r5 = r5 * r7
            long r1 = r1 + r5
            r5 = r24[r12]
            r7 = r24[r0]
            long r5 = r5 * r7
            long r1 = r1 + r5
            long r1 = r1 * r3
            r5 = 13
            r23[r5] = r1
            r1 = r24[r15]
            r5 = r24[r15]
            long r1 = r1 * r5
            r5 = r24[r14]
            r7 = r24[r18]
            long r5 = r5 * r7
            long r1 = r1 + r5
            r5 = r24[r13]
            long r5 = r5 * r3
            r7 = r24[r0]
            long r5 = r5 * r7
            long r1 = r1 + r5
            long r1 = r1 * r3
            r5 = 14
            r23[r5] = r1
            r1 = r24[r15]
            r5 = r24[r18]
            long r1 = r1 * r5
            r5 = r24[r14]
            r7 = r24[r0]
            long r5 = r5 * r7
            long r1 = r1 + r5
            long r1 = r1 * r3
            r5 = 15
            r23[r5] = r1
            r1 = r24[r18]
            r5 = r24[r18]
            long r1 = r1 * r5
            r5 = r24[r15]
            long r5 = r5 * r10
            r7 = r24[r0]
            long r5 = r5 * r7
            long r1 = r1 + r5
            r5 = 16
            r23[r5] = r1
            r1 = r24[r18]
            long r1 = r1 * r3
            r5 = r24[r0]
            long r1 = r1 * r5
            r5 = 17
            r23[r5] = r1
            r1 = r24[r0]
            long r1 = r1 * r3
            r3 = r24[r0]
            long r1 = r1 * r3
            r0 = 18
            r23[r0] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Field25519.squareInner(long[], long[]):void");
    }

    static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        squareInner(jArr3, jArr2);
        reduce(jArr3, jArr);
    }

    static long[] expand(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int[] iArr = EXPAND_START;
            jArr[i] = ((((((long) (bArr[iArr[i]] & 255)) | (((long) (bArr[iArr[i] + 1] & 255)) << 8)) | (((long) (bArr[iArr[i] + 2] & 255)) << 16)) | (((long) (bArr[iArr[i] + 3] & 255)) << 24)) >> EXPAND_SHIFT[i]) & ((long) MASK[i & 1]);
        }
        return jArr;
    }

    static byte[] contract(long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, 10);
        for (int i = 0; i < 2; i++) {
            int i2 = 0;
            while (i2 < 9) {
                long j = copyOf[i2] & (copyOf[i2] >> 31);
                int[] iArr = SHIFT;
                int i3 = i2 & 1;
                int i4 = -((int) (j >> iArr[i3]));
                copyOf[i2] = copyOf[i2] + ((long) (i4 << iArr[i3]));
                i2++;
                copyOf[i2] = copyOf[i2] - ((long) i4);
            }
            int i5 = -((int) (((copyOf[9] >> 31) & copyOf[9]) >> 25));
            copyOf[9] = copyOf[9] + ((long) (i5 << 25));
            copyOf[0] = copyOf[0] - ((long) (i5 * 19));
        }
        int i6 = -((int) ((copyOf[0] & (copyOf[0] >> 31)) >> 26));
        copyOf[0] = copyOf[0] + ((long) (i6 << 26));
        copyOf[1] = copyOf[1] - ((long) i6);
        for (int i7 = 0; i7 < 2; i7++) {
            int i8 = 0;
            while (i8 < 9) {
                int i9 = i8 & 1;
                int i10 = (int) (copyOf[i8] >> SHIFT[i9]);
                copyOf[i8] = ((long) MASK[i9]) & copyOf[i8];
                i8++;
                copyOf[i8] = copyOf[i8] + ((long) i10);
            }
        }
        copyOf[9] = copyOf[9] & 33554431;
        copyOf[0] = copyOf[0] + ((long) (((int) (copyOf[9] >> 25)) * 19));
        int gte = gte((int) copyOf[0], 67108845);
        for (int i11 = 1; i11 < 10; i11++) {
            gte &= eq((int) copyOf[i11], MASK[i11 & 1]);
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & gte));
        long j2 = (long) (33554431 & gte);
        copyOf[1] = copyOf[1] - j2;
        for (int i12 = 2; i12 < 10; i12 += 2) {
            copyOf[i12] = copyOf[i12] - ((long) (67108863 & gte));
            int i13 = i12 + 1;
            copyOf[i13] = copyOf[i13] - j2;
        }
        for (int i14 = 0; i14 < 10; i14++) {
            copyOf[i14] = copyOf[i14] << EXPAND_SHIFT[i14];
        }
        byte[] bArr = new byte[32];
        for (int i15 = 0; i15 < 10; i15++) {
            int[] iArr2 = EXPAND_START;
            int i16 = iArr2[i15];
            bArr[i16] = (byte) ((int) (((long) bArr[i16]) | (copyOf[i15] & 255)));
            int i17 = iArr2[i15] + 1;
            bArr[i17] = (byte) ((int) (((long) bArr[i17]) | ((copyOf[i15] >> 8) & 255)));
            int i18 = iArr2[i15] + 2;
            bArr[i18] = (byte) ((int) (((long) bArr[i18]) | ((copyOf[i15] >> 16) & 255)));
            int i19 = iArr2[i15] + 3;
            bArr[i19] = (byte) ((int) (((long) bArr[i19]) | ((copyOf[i15] >> 24) & 255)));
        }
        return bArr;
    }

    static void inverse(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        square(jArr3, jArr2);
        square(jArr12, jArr3);
        square(jArr11, jArr12);
        mult(jArr4, jArr11, jArr2);
        mult(jArr5, jArr4, jArr3);
        square(jArr11, jArr5);
        mult(jArr6, jArr11, jArr4);
        square(jArr11, jArr6);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        mult(jArr7, jArr11, jArr6);
        square(jArr11, jArr7);
        square(jArr12, jArr11);
        for (int i = 2; i < 10; i += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr8, jArr12, jArr7);
        square(jArr11, jArr8);
        square(jArr12, jArr11);
        for (int i2 = 2; i2 < 20; i2 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr8);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr9, jArr11, jArr7);
        square(jArr11, jArr9);
        square(jArr12, jArr11);
        for (int i4 = 2; i4 < 50; i4 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr10, jArr12, jArr9);
        square(jArr12, jArr10);
        square(jArr11, jArr12);
        for (int i5 = 2; i5 < 100; i5 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr12, jArr11, jArr10);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr9);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        mult(jArr, jArr12, jArr5);
    }
}
