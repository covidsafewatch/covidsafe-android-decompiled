package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

final class Ed25519 {
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        CachedXYT(CachedXYT cachedXYT) {
            this.yPlusX = Arrays.copyOf(cachedXYT.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(cachedXYT.yMinusX, 10);
            this.t2d = Arrays.copyOf(cachedXYT.t2d, 10);
        }

        /* access modifiers changed from: 0000 */
        public void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }

        /* access modifiers changed from: 0000 */
        public void copyConditional(CachedXYT cachedXYT, int i) {
            Curve25519.copyConditional(this.yPlusX, cachedXYT.yPlusX, i);
            Curve25519.copyConditional(this.yMinusX, cachedXYT.yMinusX, i);
            Curve25519.copyConditional(this.t2d, cachedXYT.t2d, i);
        }
    }

    private static class CachedXYZT extends CachedXYT {
        private final long[] z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            Field25519.sum(this.yPlusX, xyzt.xyz.y, xyzt.xyz.x);
            Field25519.sub(this.yMinusX, xyzt.xyz.y, xyzt.xyz.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.z = jArr3;
        }

        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.z);
        }
    }

    private static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz2, long[] jArr) {
            this.xyz = xyz2;
            this.t = jArr;
        }

        PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.t = Arrays.copyOf(partialXYZT.t, 10);
        }
    }

    private static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.x = jArr;
            this.y = jArr2;
            this.z = jArr3;
        }

        XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            Field25519.mult(xyz.y, partialXYZT.xyz.y, partialXYZT.xyz.z);
            Field25519.mult(xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            return xyz;
        }

        /* access modifiers changed from: 0000 */
        public byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.z);
            Field25519.mult(jArr2, this.x, jArr);
            Field25519.mult(jArr3, this.y, jArr);
            byte[] contract = Field25519.contract(jArr3);
            contract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ contract[31]);
            return contract;
        }

        /* access modifiers changed from: 0000 */
        public boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }
    }

    private static class XYZT {
        final long[] t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz2, long[] jArr) {
            this.xyz = xyz2;
            this.t = jArr;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        /* access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            Field25519.mult(xyzt.xyz.y, partialXYZT.xyz.y, partialXYZT.xyz.z);
            Field25519.mult(xyzt.xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            Field25519.mult(xyzt.t, partialXYZT.xyz.x, partialXYZT.xyz.y);
            return xyzt;
        }

        /* access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] expand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, expand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (!Ed25519.isNonZeroVarTime(jArr7)) {
                    Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
                } else {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((bArr[31] & 255) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((bArr[31] & 255) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, expand);
                return new XYZT(new XYZ(jArr, expand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }
    }

    private static int eq(int i, int i2) {
        int i3 = (~(i ^ i2)) & 255;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return ((i5 & (i5 << 1)) >> 7) & 1;
    }

    Ed25519() {
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.x, xyzt.xyz.y, xyzt.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, xyzt.xyz.y, xyzt.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        Field25519.sum(jArr, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.z, jArr, partialXYZT.t);
        Field25519.sub(partialXYZT.t, jArr, partialXYZT.t);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.x, xyzt.xyz.y, xyzt.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, xyzt.xyz.y, xyzt.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        Field25519.sum(jArr, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.xyz.z, jArr, partialXYZT.t);
        Field25519.sum(partialXYZT.t, jArr, partialXYZT.t);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.x, xyz.x);
        Field25519.square(partialXYZT.xyz.z, xyz.y);
        Field25519.square(partialXYZT.t, xyz.z);
        Field25519.sum(partialXYZT.t, partialXYZT.t, partialXYZT.t);
        Field25519.sum(partialXYZT.xyz.y, xyz.x, xyz.y);
        Field25519.square(jArr, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.z, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, jArr, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.t, partialXYZT.t, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static void select(CachedXYT cachedXYT, int i, byte b) {
        int i2 = (b & 255) >> 7;
        int i3 = b - (((-i2) & b) << 1);
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][0], eq(i3, 1));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][1], eq(i3, 2));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][2], eq(i3, 3));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][3], eq(i3, 4));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][4], eq(i3, 5));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][5], eq(i3, 6));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][6], eq(i3, 7));
        cachedXYT.copyConditional(Ed25519Constants.B_TABLE[i][7], eq(i3, 8));
        long[] copyOf = Arrays.copyOf(cachedXYT.yMinusX, 10);
        long[] copyOf2 = Arrays.copyOf(cachedXYT.yPlusX, 10);
        long[] copyOf3 = Arrays.copyOf(cachedXYT.t2d, 10);
        neg(copyOf3, copyOf3);
        cachedXYT.copyConditional(new CachedXYT(copyOf, copyOf2, copyOf3), i2);
    }

    private static XYZ scalarMultWithBase(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr2[i3 + 0] = (byte) (((bArr[i2] & 255) >> 0) & 15);
            bArr2[i3 + 1] = (byte) (((bArr[i2] & 255) >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 63; i5++) {
            bArr2[i5] = (byte) (bArr2[i5] + i4);
            i4 = (bArr2[i5] + 8) >> 4;
            bArr2[i5] = (byte) (bArr2[i5] - (i4 << 4));
        }
        bArr2[63] = (byte) (bArr2[63] + i4);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr2[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i6 = 0; i6 < 64; i6 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i6 / 2, bArr2[i6]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    static byte[] scalarMultWithBaseToBytes(byte[] bArr) {
        return scalarMultWithBase(bArr).toBytes();
    }

    private static byte[] slide(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) (1 & ((bArr[i >> 3] & 255) >> (i & 7)));
        }
        for (int i2 = 0; i2 < 256; i2++) {
            if (bArr2[i2] != 0) {
                for (int i3 = 1; i3 <= 6; i3++) {
                    int i4 = i2 + i3;
                    if (i4 >= 256) {
                        break;
                    }
                    if (bArr2[i4] != 0) {
                        if (bArr2[i2] + (bArr2[i4] << i3) > 15) {
                            if (bArr2[i2] - (bArr2[i4] << i3) < -15) {
                                break;
                            }
                            bArr2[i2] = (byte) (bArr2[i2] - (bArr2[i4] << i3));
                            while (true) {
                                if (i4 >= 256) {
                                    break;
                                } else if (bArr2[i4] == 0) {
                                    bArr2[i4] = 1;
                                    break;
                                } else {
                                    bArr2[i4] = 0;
                                    i4++;
                                }
                            }
                        } else {
                            bArr2[i2] = (byte) (bArr2[i2] + (bArr2[i4] << i3));
                            bArr2[i4] = 0;
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] slide = slide(bArr);
        byte[] slide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && slide[i2] == 0 && slide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            if (slide[i2] > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[slide[i2] / 2]);
            } else if (slide[i2] < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-slide[i2]) / 2]);
            }
            if (slide2[i2] > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[slide2[i2] / 2]);
            } else if (slide2[i2] < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-slide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    /* access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[(jArr.length + 1)];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b : Field25519.contract(jArr2)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    /* access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        for (int i = 1; i < 2; i++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i2 = 1; i2 < 5; i2++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i3 = 1; i3 < 10; i3++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i4 = 1; i4 < 20; i4++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i5 = 1; i5 < 10; i5++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i6 = 1; i6 < 50; i6++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i7 = 1; i7 < 100; i7++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i8 = 1; i8 < 50; i8++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        for (int i9 = 1; i9 < 2; i9++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static long load3(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (((long) bArr[i]) & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long load4(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | load3(bArr, i);
    }

    private static void reduce(byte[] bArr) {
        byte[] bArr2 = bArr;
        long load3 = (load3(bArr2, 47) >> 2) & 2097151;
        long load4 = (load4(bArr2, 49) >> 7) & 2097151;
        long load42 = (load4(bArr2, 52) >> 4) & 2097151;
        long load32 = (load3(bArr2, 55) >> 1) & 2097151;
        long load43 = (load4(bArr2, 57) >> 6) & 2097151;
        long load44 = load4(bArr2, 60) >> 3;
        long load33 = (load3(bArr2, 42) & 2097151) - (load44 * 683901);
        long load45 = ((((load4(bArr2, 36) >> 6) & 2097151) - (load44 * 997805)) + (load43 * 136657)) - (load32 * 683901);
        long load46 = ((((((load4(bArr2, 31) >> 4) & 2097151) + (load44 * 470296)) + (load43 * 654183)) - (load32 * 997805)) + (load42 * 136657)) - (load4 * 683901);
        long load47 = ((load4(bArr2, 15) >> 6) & 2097151) + (load3 * 666643);
        long load34 = ((load3(bArr2, 18) >> 3) & 2097151) + (load4 * 666643) + (load3 * 470296);
        long load35 = (load3(bArr2, 21) & 2097151) + (load42 * 666643) + (load4 * 470296) + (load3 * 654183);
        long load48 = (((((load4(bArr2, 23) >> 5) & 2097151) + (load32 * 666643)) + (load42 * 470296)) + (load4 * 654183)) - (load3 * 997805);
        long load36 = ((((((load3(bArr2, 26) >> 2) & 2097151) + (load43 * 666643)) + (load32 * 470296)) + (load42 * 654183)) - (load4 * 997805)) + (load3 * 136657);
        long load49 = (((((((load4(bArr2, 28) >> 7) & 2097151) + (load44 * 666643)) + (load43 * 470296)) + (load32 * 654183)) - (load42 * 997805)) + (load4 * 136657)) - (load3 * 683901);
        long j = (load47 + 1048576) >> 21;
        long j2 = load34 + j;
        long j3 = load47 - (j << 21);
        long j4 = (load35 + 1048576) >> 21;
        long j5 = load48 + j4;
        long j6 = load35 - (j4 << 21);
        long j7 = (load36 + 1048576) >> 21;
        long j8 = load49 + j7;
        long j9 = load36 - (j7 << 21);
        long j10 = (load46 + 1048576) >> 21;
        long load37 = ((((((load3(bArr2, 34) >> 1) & 2097151) + (load44 * 654183)) - (load43 * 997805)) + (load32 * 136657)) - (load42 * 683901)) + j10;
        long j11 = load46 - (j10 << 21);
        long j12 = (load45 + 1048576) >> 21;
        long load38 = ((((load3(bArr2, 39) >> 3) & 2097151) + (load44 * 136657)) - (load43 * 683901)) + j12;
        long j13 = load45 - (j12 << 21);
        long j14 = (load33 + 1048576) >> 21;
        long load410 = ((load4(bArr2, 44) >> 5) & 2097151) + j14;
        long j15 = load33 - (j14 << 21);
        long j16 = (j2 + 1048576) >> 21;
        long j17 = j6 + j16;
        long j18 = j2 - (j16 << 21);
        long j19 = (j5 + 1048576) >> 21;
        long j20 = j9 + j19;
        long j21 = j5 - (j19 << 21);
        long j22 = (j8 + 1048576) >> 21;
        long j23 = j11 + j22;
        long j24 = j8 - (j22 << 21);
        long j25 = (load37 + 1048576) >> 21;
        long j26 = j13 + j25;
        long j27 = load37 - (j25 << 21);
        long j28 = (load38 + 1048576) >> 21;
        long j29 = j15 + j28;
        long j30 = load38 - (j28 << 21);
        long j31 = j20 - (load410 * 683901);
        long j32 = ((j17 - (load410 * 997805)) + (j29 * 136657)) - (j30 * 683901);
        long j33 = ((((j3 + (load410 * 470296)) + (j29 * 654183)) - (j30 * 997805)) + (j26 * 136657)) - (j27 * 683901);
        long load39 = (load3(bArr2, 0) & 2097151) + (j23 * 666643);
        long load411 = ((load4(bArr2, 2) >> 5) & 2097151) + (j27 * 666643) + (j23 * 470296);
        long load310 = ((load3(bArr2, 5) >> 2) & 2097151) + (j26 * 666643) + (j27 * 470296) + (j23 * 654183);
        long load412 = (((((load4(bArr2, 7) >> 7) & 2097151) + (j30 * 666643)) + (j26 * 470296)) + (j27 * 654183)) - (j23 * 997805);
        long load413 = ((((((load4(bArr2, 10) >> 4) & 2097151) + (j29 * 666643)) + (j30 * 470296)) + (j26 * 654183)) - (j27 * 997805)) + (j23 * 136657);
        long load311 = (((((((load3(bArr2, 13) >> 1) & 2097151) + (load410 * 666643)) + (j29 * 470296)) + (j30 * 654183)) - (j26 * 997805)) + (j27 * 136657)) - (j23 * 683901);
        long j34 = (load39 + 1048576) >> 21;
        long j35 = load411 + j34;
        long j36 = load39 - (j34 << 21);
        long j37 = (load310 + 1048576) >> 21;
        long j38 = load412 + j37;
        long j39 = load310 - (j37 << 21);
        long j40 = (load413 + 1048576) >> 21;
        long j41 = load311 + j40;
        long j42 = load413 - (j40 << 21);
        long j43 = (j33 + 1048576) >> 21;
        long j44 = ((((j18 + (load410 * 654183)) - (j29 * 997805)) + (j30 * 136657)) - (j26 * 683901)) + j43;
        long j45 = j33 - (j43 << 21);
        long j46 = (j32 + 1048576) >> 21;
        long j47 = ((j21 + (load410 * 136657)) - (j29 * 683901)) + j46;
        long j48 = j32 - (j46 << 21);
        long j49 = (j31 + 1048576) >> 21;
        long j50 = j24 + j49;
        long j51 = j31 - (j49 << 21);
        long j52 = (j35 + 1048576) >> 21;
        long j53 = j39 + j52;
        long j54 = j35 - (j52 << 21);
        long j55 = (j38 + 1048576) >> 21;
        long j56 = j42 + j55;
        long j57 = j38 - (j55 << 21);
        long j58 = (j41 + 1048576) >> 21;
        long j59 = j45 + j58;
        long j60 = j41 - (j58 << 21);
        long j61 = (j44 + 1048576) >> 21;
        long j62 = j48 + j61;
        long j63 = j44 - (j61 << 21);
        long j64 = (j47 + 1048576) >> 21;
        long j65 = j51 + j64;
        long j66 = j47 - (j64 << 21);
        long j67 = (j50 + 1048576) >> 21;
        long j68 = j67 + 0;
        long j69 = j36 + (j68 * 666643);
        long j70 = j54 + (j68 * 470296);
        long j71 = j53 + (j68 * 654183);
        long j72 = j57 - (j68 * 997805);
        long j73 = j60 - (j68 * 683901);
        long j74 = j69 >> 21;
        long j75 = j70 + j74;
        long j76 = j69 - (j74 << 21);
        long j77 = j75 >> 21;
        long j78 = j71 + j77;
        long j79 = j75 - (j77 << 21);
        long j80 = j78 >> 21;
        long j81 = j72 + j80;
        long j82 = j78 - (j80 << 21);
        long j83 = j81 >> 21;
        long j84 = j56 + (j68 * 136657) + j83;
        long j85 = j81 - (j83 << 21);
        long j86 = j84 >> 21;
        long j87 = j73 + j86;
        long j88 = j84 - (j86 << 21);
        long j89 = j87 >> 21;
        long j90 = j59 + j89;
        long j91 = j87 - (j89 << 21);
        long j92 = j90 >> 21;
        long j93 = j63 + j92;
        long j94 = j90 - (j92 << 21);
        long j95 = j93 >> 21;
        long j96 = j62 + j95;
        long j97 = j93 - (j95 << 21);
        long j98 = j96 >> 21;
        long j99 = j66 + j98;
        long j100 = j96 - (j98 << 21);
        long j101 = j99 >> 21;
        long j102 = j65 + j101;
        long j103 = j99 - (j101 << 21);
        long j104 = j102 >> 21;
        long j105 = (j50 - (j67 << 21)) + j104;
        long j106 = j102 - (j104 << 21);
        long j107 = j105 >> 21;
        long j108 = j107 + 0;
        long j109 = j105 - (j107 << 21);
        long j110 = j76 + (666643 * j108);
        long j111 = j110 >> 21;
        long j112 = j79 + (470296 * j108) + j111;
        long j113 = j110 - (j111 << 21);
        long j114 = j112 >> 21;
        long j115 = j82 + (654183 * j108) + j114;
        long j116 = j112 - (j114 << 21);
        long j117 = j115 >> 21;
        long j118 = (j85 - (997805 * j108)) + j117;
        long j119 = j115 - (j117 << 21);
        long j120 = j118 >> 21;
        long j121 = j88 + (136657 * j108) + j120;
        long j122 = j118 - (j120 << 21);
        long j123 = j121 >> 21;
        long j124 = (j91 - (j108 * 683901)) + j123;
        long j125 = j121 - (j123 << 21);
        long j126 = j124 >> 21;
        long j127 = j94 + j126;
        long j128 = j124 - (j126 << 21);
        long j129 = j127 >> 21;
        long j130 = j97 + j129;
        long j131 = j127 - (j129 << 21);
        long j132 = j130 >> 21;
        long j133 = j100 + j132;
        long j134 = j130 - (j132 << 21);
        long j135 = j133 >> 21;
        long j136 = j103 + j135;
        long j137 = j122;
        long j138 = j133 - (j135 << 21);
        long j139 = j136 >> 21;
        long j140 = j106 + j139;
        long j141 = j136 - (j139 << 21);
        long j142 = j140 >> 21;
        long j143 = j109 + j142;
        long j144 = j140 - (j142 << 21);
        bArr2[0] = (byte) ((int) j113);
        bArr2[1] = (byte) ((int) (j113 >> 8));
        bArr2[2] = (byte) ((int) ((j113 >> 16) | (j116 << 5)));
        bArr2[3] = (byte) ((int) (j116 >> 3));
        bArr2[4] = (byte) ((int) (j116 >> 11));
        bArr2[5] = (byte) ((int) ((j116 >> 19) | (j119 << 2)));
        bArr2[6] = (byte) ((int) (j119 >> 6));
        bArr2[7] = (byte) ((int) ((j119 >> 14) | (j137 << 7)));
        bArr2[8] = (byte) ((int) (j137 >> 1));
        bArr2[9] = (byte) ((int) (j137 >> 9));
        bArr2[10] = (byte) ((int) ((j137 >> 17) | (j125 << 4)));
        bArr2[11] = (byte) ((int) (j125 >> 4));
        bArr2[12] = (byte) ((int) (j125 >> 12));
        bArr2[13] = (byte) ((int) ((j125 >> 20) | (j128 << 1)));
        bArr2[14] = (byte) ((int) (j128 >> 7));
        bArr2[15] = (byte) ((int) ((j128 >> 15) | (j131 << 6)));
        bArr2[16] = (byte) ((int) (j131 >> 2));
        bArr2[17] = (byte) ((int) (j131 >> 10));
        bArr2[18] = (byte) ((int) ((j131 >> 18) | (j134 << 3)));
        bArr2[19] = (byte) ((int) (j134 >> 5));
        bArr2[20] = (byte) ((int) (j134 >> 13));
        bArr2[21] = (byte) ((int) j138);
        bArr2[22] = (byte) ((int) (j138 >> 8));
        bArr2[23] = (byte) ((int) ((j138 >> 16) | (j141 << 5)));
        bArr2[24] = (byte) ((int) (j141 >> 3));
        bArr2[25] = (byte) ((int) (j141 >> 11));
        bArr2[26] = (byte) ((int) ((j141 >> 19) | (j144 << 2)));
        bArr2[27] = (byte) ((int) (j144 >> 6));
        bArr2[28] = (byte) ((int) ((j144 >> 14) | (j143 << 7)));
        bArr2[29] = (byte) ((int) (j143 >> 1));
        bArr2[30] = (byte) ((int) (j143 >> 9));
        bArr2[31] = (byte) ((int) (j143 >> 17));
    }

    private static void mulAdd(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        byte[] bArr7 = bArr4;
        long load3 = load3(bArr5, 0) & 2097151;
        long load4 = (load4(bArr5, 2) >> 5) & 2097151;
        long load32 = (load3(bArr5, 5) >> 2) & 2097151;
        long load42 = (load4(bArr5, 7) >> 7) & 2097151;
        long load43 = (load4(bArr5, 10) >> 4) & 2097151;
        long load33 = (load3(bArr5, 13) >> 1) & 2097151;
        long load44 = (load4(bArr5, 15) >> 6) & 2097151;
        long load34 = (load3(bArr5, 18) >> 3) & 2097151;
        long load35 = load3(bArr5, 21) & 2097151;
        long load45 = (load4(bArr5, 23) >> 5) & 2097151;
        long load36 = (load3(bArr5, 26) >> 2) & 2097151;
        long load46 = load4(bArr5, 28) >> 7;
        long load37 = load3(bArr6, 0) & 2097151;
        long load47 = (load4(bArr6, 2) >> 5) & 2097151;
        long load38 = (load3(bArr6, 5) >> 2) & 2097151;
        long load48 = (load4(bArr6, 7) >> 7) & 2097151;
        long load49 = (load4(bArr6, 10) >> 4) & 2097151;
        long load39 = (load3(bArr6, 13) >> 1) & 2097151;
        long load410 = (load4(bArr6, 15) >> 6) & 2097151;
        long load310 = (load3(bArr6, 18) >> 3) & 2097151;
        long load311 = load3(bArr6, 21) & 2097151;
        long load411 = (load4(bArr6, 23) >> 5) & 2097151;
        long load312 = (load3(bArr6, 26) >> 2) & 2097151;
        long load412 = load4(bArr6, 28) >> 7;
        long load313 = (load3(bArr7, 0) & 2097151) + (load3 * load37);
        long load413 = ((load4(bArr7, 2) >> 5) & 2097151) + (load3 * load47) + (load4 * load37);
        long load314 = ((load3(bArr7, 5) >> 2) & 2097151) + (load3 * load38) + (load4 * load47) + (load32 * load37);
        long load414 = ((load4(bArr7, 7) >> 7) & 2097151) + (load3 * load48) + (load4 * load38) + (load32 * load47) + (load42 * load37);
        long load415 = ((load4(bArr7, 10) >> 4) & 2097151) + (load3 * load49) + (load4 * load48) + (load32 * load38) + (load42 * load47) + (load43 * load37);
        long load315 = ((load3(bArr7, 13) >> 1) & 2097151) + (load3 * load39) + (load4 * load49) + (load32 * load48) + (load42 * load38) + (load43 * load47) + (load33 * load37);
        long load416 = ((load4(bArr7, 15) >> 6) & 2097151) + (load3 * load410) + (load4 * load39) + (load32 * load49) + (load42 * load48) + (load43 * load38) + (load33 * load47) + (load44 * load37);
        long load316 = ((load3(bArr7, 18) >> 3) & 2097151) + (load3 * load310) + (load4 * load410) + (load32 * load39) + (load42 * load49) + (load43 * load48) + (load33 * load38) + (load44 * load47) + (load34 * load37);
        long load317 = (load3(bArr7, 21) & 2097151) + (load3 * load311) + (load4 * load310) + (load32 * load410) + (load42 * load39) + (load43 * load49) + (load33 * load48) + (load44 * load38) + (load34 * load47) + (load35 * load37);
        long load417 = ((load4(bArr7, 23) >> 5) & 2097151) + (load3 * load411) + (load4 * load311) + (load32 * load310) + (load42 * load410) + (load43 * load39) + (load33 * load49) + (load44 * load48) + (load34 * load38) + (load35 * load47) + (load45 * load37);
        long load318 = ((load3(bArr7, 26) >> 2) & 2097151) + (load3 * load312) + (load4 * load411) + (load32 * load311) + (load42 * load310) + (load43 * load410) + (load33 * load39) + (load44 * load49) + (load34 * load48) + (load35 * load38) + (load45 * load47) + (load36 * load37);
        long j = (load4 * load412) + (load32 * load312) + (load42 * load411) + (load43 * load311) + (load33 * load310) + (load44 * load410) + (load34 * load39) + (load35 * load49) + (load45 * load48) + (load36 * load38) + (load47 * load46);
        long j2 = (load42 * load412) + (load43 * load312) + (load33 * load411) + (load44 * load311) + (load34 * load310) + (load35 * load410) + (load45 * load39) + (load36 * load49) + (load48 * load46);
        long j3 = (load33 * load412) + (load44 * load312) + (load34 * load411) + (load35 * load311) + (load45 * load310) + (load36 * load410) + (load39 * load46);
        long j4 = (load34 * load412) + (load35 * load312) + (load45 * load411) + (load36 * load311) + (load310 * load46);
        long j5 = (load45 * load412) + (load36 * load312) + (load411 * load46);
        long j6 = load46 * load412;
        long j7 = (load313 + 1048576) >> 21;
        long j8 = load413 + j7;
        long j9 = load313 - (j7 << 21);
        long j10 = (load314 + 1048576) >> 21;
        long j11 = load414 + j10;
        long j12 = load314 - (j10 << 21);
        long j13 = (load415 + 1048576) >> 21;
        long j14 = load315 + j13;
        long j15 = load415 - (j13 << 21);
        long j16 = (load416 + 1048576) >> 21;
        long j17 = load316 + j16;
        long j18 = load416 - (j16 << 21);
        long j19 = (load317 + 1048576) >> 21;
        long j20 = load417 + j19;
        long j21 = load317 - (j19 << 21);
        long j22 = (load318 + 1048576) >> 21;
        long load418 = (load4(bArr7, 28) >> 7) + (load3 * load412) + (load4 * load312) + (load32 * load411) + (load42 * load311) + (load43 * load310) + (load33 * load410) + (load44 * load39) + (load34 * load49) + (load35 * load48) + (load45 * load38) + (load36 * load47) + (load37 * load46) + j22;
        long j23 = load318 - (j22 << 21);
        long j24 = (j + 1048576) >> 21;
        long j25 = (load32 * load412) + (load42 * load312) + (load43 * load411) + (load33 * load311) + (load44 * load310) + (load34 * load410) + (load35 * load39) + (load45 * load49) + (load36 * load48) + (load38 * load46) + j24;
        long j26 = j - (j24 << 21);
        long j27 = (j2 + 1048576) >> 21;
        long j28 = (load43 * load412) + (load33 * load312) + (load44 * load411) + (load34 * load311) + (load35 * load310) + (load45 * load410) + (load36 * load39) + (load49 * load46) + j27;
        long j29 = j2 - (j27 << 21);
        long j30 = (j3 + 1048576) >> 21;
        long j31 = (load44 * load412) + (load34 * load312) + (load35 * load411) + (load45 * load311) + (load36 * load310) + (load410 * load46) + j30;
        long j32 = j3 - (j30 << 21);
        long j33 = (j4 + 1048576) >> 21;
        long j34 = (load35 * load412) + (load45 * load312) + (load36 * load411) + (load311 * load46) + j33;
        long j35 = j4 - (j33 << 21);
        long j36 = (j5 + 1048576) >> 21;
        long j37 = (load36 * load412) + (load312 * load46) + j36;
        long j38 = j5 - (j36 << 21);
        long j39 = (j6 + 1048576) >> 21;
        long j40 = j39 + 0;
        long j41 = j6 - (j39 << 21);
        long j42 = (j8 + 1048576) >> 21;
        long j43 = j12 + j42;
        long j44 = j8 - (j42 << 21);
        long j45 = (j11 + 1048576) >> 21;
        long j46 = j15 + j45;
        long j47 = j11 - (j45 << 21);
        long j48 = (j14 + 1048576) >> 21;
        long j49 = j18 + j48;
        long j50 = j14 - (j48 << 21);
        long j51 = (j17 + 1048576) >> 21;
        long j52 = j21 + j51;
        long j53 = j17 - (j51 << 21);
        long j54 = (j20 + 1048576) >> 21;
        long j55 = j23 + j54;
        long j56 = j20 - (j54 << 21);
        long j57 = (load418 + 1048576) >> 21;
        long j58 = j26 + j57;
        long j59 = load418 - (j57 << 21);
        long j60 = (j25 + 1048576) >> 21;
        long j61 = j29 + j60;
        long j62 = j25 - (j60 << 21);
        long j63 = (j28 + 1048576) >> 21;
        long j64 = j32 + j63;
        long j65 = j28 - (j63 << 21);
        long j66 = (j31 + 1048576) >> 21;
        long j67 = j35 + j66;
        long j68 = j31 - (j66 << 21);
        long j69 = (j34 + 1048576) >> 21;
        long j70 = j38 + j69;
        long j71 = j34 - (j69 << 21);
        long j72 = (j37 + 1048576) >> 21;
        long j73 = j41 + j72;
        long j74 = j37 - (j72 << 21);
        long j75 = j64 - (j40 * 683901);
        long j76 = ((j61 - (j40 * 997805)) + (j73 * 136657)) - (j74 * 683901);
        long j77 = ((((j58 + (j40 * 470296)) + (j73 * 654183)) - (j74 * 997805)) + (j70 * 136657)) - (j71 * 683901);
        long j78 = j49 + (j67 * 666643);
        long j79 = j53 + (j71 * 666643) + (j67 * 470296);
        long j80 = j52 + (j70 * 666643) + (j71 * 470296) + (j67 * 654183);
        long j81 = (((j56 + (j74 * 666643)) + (j70 * 470296)) + (j71 * 654183)) - (j67 * 997805);
        long j82 = ((((j55 + (j73 * 666643)) + (j74 * 470296)) + (j70 * 654183)) - (j71 * 997805)) + (j67 * 136657);
        long j83 = (((((j59 + (j40 * 666643)) + (j73 * 470296)) + (j74 * 654183)) - (j70 * 997805)) + (j71 * 136657)) - (j67 * 683901);
        long j84 = (j78 + 1048576) >> 21;
        long j85 = j79 + j84;
        long j86 = j78 - (j84 << 21);
        long j87 = (j80 + 1048576) >> 21;
        long j88 = j81 + j87;
        long j89 = j80 - (j87 << 21);
        long j90 = (j82 + 1048576) >> 21;
        long j91 = j83 + j90;
        long j92 = j82 - (j90 << 21);
        long j93 = (j77 + 1048576) >> 21;
        long j94 = ((((j62 + (j40 * 654183)) - (j73 * 997805)) + (j74 * 136657)) - (j70 * 683901)) + j93;
        long j95 = j77 - (j93 << 21);
        long j96 = (j76 + 1048576) >> 21;
        long j97 = ((j65 + (j40 * 136657)) - (j73 * 683901)) + j96;
        long j98 = j76 - (j96 << 21);
        long j99 = (j75 + 1048576) >> 21;
        long j100 = j68 + j99;
        long j101 = j75 - (j99 << 21);
        long j102 = (j85 + 1048576) >> 21;
        long j103 = j89 + j102;
        long j104 = j85 - (j102 << 21);
        long j105 = (j88 + 1048576) >> 21;
        long j106 = j92 + j105;
        long j107 = j88 - (j105 << 21);
        long j108 = (j91 + 1048576) >> 21;
        long j109 = j95 + j108;
        long j110 = j91 - (j108 << 21);
        long j111 = (j94 + 1048576) >> 21;
        long j112 = j98 + j111;
        long j113 = j94 - (j111 << 21);
        long j114 = (j97 + 1048576) >> 21;
        long j115 = j101 + j114;
        long j116 = j97 - (j114 << 21);
        long j117 = j106 - (j100 * 683901);
        long j118 = ((j103 - (j100 * 997805)) + (j115 * 136657)) - (j116 * 683901);
        long j119 = ((((j86 + (j100 * 470296)) + (j115 * 654183)) - (j116 * 997805)) + (j112 * 136657)) - (j113 * 683901);
        long j120 = j9 + (j109 * 666643);
        long j121 = j44 + (j113 * 666643) + (j109 * 470296);
        long j122 = j43 + (j112 * 666643) + (j113 * 470296) + (j109 * 654183);
        long j123 = (((j47 + (j116 * 666643)) + (j112 * 470296)) + (j113 * 654183)) - (j109 * 997805);
        long j124 = ((((j46 + (j115 * 666643)) + (j116 * 470296)) + (j112 * 654183)) - (j113 * 997805)) + (j109 * 136657);
        long j125 = (((((j50 + (j100 * 666643)) + (j115 * 470296)) + (j116 * 654183)) - (j112 * 997805)) + (j113 * 136657)) - (j109 * 683901);
        long j126 = (j120 + 1048576) >> 21;
        long j127 = j121 + j126;
        long j128 = j120 - (j126 << 21);
        long j129 = (j122 + 1048576) >> 21;
        long j130 = j123 + j129;
        long j131 = j122 - (j129 << 21);
        long j132 = (j124 + 1048576) >> 21;
        long j133 = j125 + j132;
        long j134 = j124 - (j132 << 21);
        long j135 = (j119 + 1048576) >> 21;
        long j136 = ((((j104 + (j100 * 654183)) - (j115 * 997805)) + (j116 * 136657)) - (j112 * 683901)) + j135;
        long j137 = j119 - (j135 << 21);
        long j138 = (j118 + 1048576) >> 21;
        long j139 = ((j107 + (j100 * 136657)) - (j115 * 683901)) + j138;
        long j140 = j118 - (j138 << 21);
        long j141 = (j117 + 1048576) >> 21;
        long j142 = j110 + j141;
        long j143 = j117 - (j141 << 21);
        long j144 = (j127 + 1048576) >> 21;
        long j145 = j131 + j144;
        long j146 = j127 - (j144 << 21);
        long j147 = (j130 + 1048576) >> 21;
        long j148 = j134 + j147;
        long j149 = j130 - (j147 << 21);
        long j150 = (j133 + 1048576) >> 21;
        long j151 = j137 + j150;
        long j152 = j133 - (j150 << 21);
        long j153 = (j136 + 1048576) >> 21;
        long j154 = j140 + j153;
        long j155 = j136 - (j153 << 21);
        long j156 = (j139 + 1048576) >> 21;
        long j157 = j143 + j156;
        long j158 = j139 - (j156 << 21);
        long j159 = (1048576 + j142) >> 21;
        long j160 = 0 + j159;
        long j161 = j128 + (j160 * 666643);
        long j162 = j146 + (j160 * 470296);
        long j163 = j145 + (j160 * 654183);
        long j164 = j149 - (j160 * 997805);
        long j165 = j152 - (j160 * 683901);
        long j166 = j161 >> 21;
        long j167 = j162 + j166;
        long j168 = j161 - (j166 << 21);
        long j169 = j167 >> 21;
        long j170 = j163 + j169;
        long j171 = j167 - (j169 << 21);
        long j172 = j170 >> 21;
        long j173 = j164 + j172;
        long j174 = j170 - (j172 << 21);
        long j175 = j173 >> 21;
        long j176 = j148 + (j160 * 136657) + j175;
        long j177 = j173 - (j175 << 21);
        long j178 = j176 >> 21;
        long j179 = j165 + j178;
        long j180 = j176 - (j178 << 21);
        long j181 = j179 >> 21;
        long j182 = j151 + j181;
        long j183 = j179 - (j181 << 21);
        long j184 = j182 >> 21;
        long j185 = j155 + j184;
        long j186 = j182 - (j184 << 21);
        long j187 = j185 >> 21;
        long j188 = j154 + j187;
        long j189 = j185 - (j187 << 21);
        long j190 = j188 >> 21;
        long j191 = j158 + j190;
        long j192 = j188 - (j190 << 21);
        long j193 = j191 >> 21;
        long j194 = j157 + j193;
        long j195 = j191 - (j193 << 21);
        long j196 = j194 >> 21;
        long j197 = (j142 - (j159 << 21)) + j196;
        long j198 = j194 - (j196 << 21);
        long j199 = j197 >> 21;
        long j200 = 0 + j199;
        long j201 = j197 - (j199 << 21);
        long j202 = j168 + (666643 * j200);
        long j203 = j202 >> 21;
        long j204 = j171 + (470296 * j200) + j203;
        long j205 = j202 - (j203 << 21);
        long j206 = j204 >> 21;
        long j207 = j174 + (654183 * j200) + j206;
        long j208 = j204 - (j206 << 21);
        long j209 = j207 >> 21;
        long j210 = (j177 - (997805 * j200)) + j209;
        long j211 = j207 - (j209 << 21);
        long j212 = j210 >> 21;
        long j213 = j180 + (136657 * j200) + j212;
        long j214 = j210 - (j212 << 21);
        long j215 = j213 >> 21;
        long j216 = (j183 - (j200 * 683901)) + j215;
        long j217 = j213 - (j215 << 21);
        long j218 = j216 >> 21;
        long j219 = j186 + j218;
        long j220 = j216 - (j218 << 21);
        long j221 = j219 >> 21;
        long j222 = j189 + j221;
        long j223 = j219 - (j221 << 21);
        long j224 = j222 >> 21;
        long j225 = j192 + j224;
        long j226 = j222 - (j224 << 21);
        long j227 = j225 >> 21;
        long j228 = j195 + j227;
        long j229 = j225 - (j227 << 21);
        long j230 = j228 >> 21;
        long j231 = j198 + j230;
        long j232 = j228 - (j230 << 21);
        long j233 = j231 >> 21;
        long j234 = j201 + j233;
        long j235 = j231 - (j233 << 21);
        bArr[0] = (byte) ((int) j205);
        bArr[1] = (byte) ((int) (j205 >> 8));
        bArr[2] = (byte) ((int) ((j205 >> 16) | (j208 << 5)));
        bArr[3] = (byte) ((int) (j208 >> 3));
        bArr[4] = (byte) ((int) (j208 >> 11));
        bArr[5] = (byte) ((int) ((j208 >> 19) | (j211 << 2)));
        bArr[6] = (byte) ((int) (j211 >> 6));
        bArr[7] = (byte) ((int) ((j211 >> 14) | (j214 << 7)));
        bArr[8] = (byte) ((int) (j214 >> 1));
        bArr[9] = (byte) ((int) (j214 >> 9));
        bArr[10] = (byte) ((int) ((j214 >> 17) | (j217 << 4)));
        bArr[11] = (byte) ((int) (j217 >> 4));
        bArr[12] = (byte) ((int) (j217 >> 12));
        bArr[13] = (byte) ((int) ((j217 >> 20) | (j220 << 1)));
        bArr[14] = (byte) ((int) (j220 >> 7));
        bArr[15] = (byte) ((int) ((j220 >> 15) | (j223 << 6)));
        bArr[16] = (byte) ((int) (j223 >> 2));
        bArr[17] = (byte) ((int) (j223 >> 10));
        bArr[18] = (byte) ((int) ((j223 >> 18) | (j226 << 3)));
        bArr[19] = (byte) ((int) (j226 >> 5));
        bArr[20] = (byte) ((int) (j226 >> 13));
        bArr[21] = (byte) ((int) j229);
        bArr[22] = (byte) ((int) (j229 >> 8));
        bArr[23] = (byte) ((int) ((j229 >> 16) | (j232 << 5)));
        bArr[24] = (byte) ((int) (j232 >> 3));
        bArr[25] = (byte) ((int) (j232 >> 11));
        bArr[26] = (byte) ((int) ((j232 >> 19) | (j235 << 2)));
        bArr[27] = (byte) ((int) (j235 >> 6));
        bArr[28] = (byte) ((int) ((j235 >> 14) | (j234 << 7)));
        bArr[29] = (byte) ((int) (j234 >> 1));
        bArr[30] = (byte) ((int) (j234 >> 9));
        bArr[31] = (byte) ((int) (j234 >> 17));
    }

    static byte[] getHashedScalar(byte[] bArr) throws GeneralSecurityException {
        MessageDigest messageDigest = (MessageDigest) EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] digest = messageDigest.digest();
        digest[0] = (byte) (digest[0] & 248);
        digest[31] = (byte) (digest[31] & Byte.MAX_VALUE);
        digest[31] = (byte) (digest[31] | SignedBytes.MAX_POWER_OF_TWO);
        return digest;
    }

    static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length);
        MessageDigest messageDigest = (MessageDigest) EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        messageDigest.update(bArr3, 32, 32);
        messageDigest.update(copyOfRange);
        byte[] digest = messageDigest.digest();
        reduce(digest);
        byte[] copyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(digest).toBytes(), 0, 32);
        messageDigest.reset();
        messageDigest.update(copyOfRange2);
        messageDigest.update(bArr2);
        messageDigest.update(copyOfRange);
        byte[] digest2 = messageDigest.digest();
        reduce(digest2);
        byte[] bArr4 = new byte[32];
        mulAdd(bArr4, digest2, bArr3, digest);
        return Bytes.concat(copyOfRange2, bArr4);
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        int i = 31;
        while (true) {
            boolean z = false;
            if (i < 0) {
                return false;
            }
            byte b = bArr[i] & 255;
            byte b2 = GROUP_ORDER[i] & 255;
            if (b != b2) {
                if (b < b2) {
                    z = true;
                }
                return z;
            }
            i--;
        }
    }

    static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(copyOfRange)) {
            return false;
        }
        MessageDigest messageDigest = (MessageDigest) EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        reduce(digest);
        byte[] bytes = doubleScalarMultVarTime(digest, XYZT.fromBytesNegateVarTime(bArr3), copyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
