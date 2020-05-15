package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;
import java.security.GeneralSecurityException;
import java.util.Arrays;

class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    private static long load32(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE))) & 4294967295L;
    }

    private static long load26(byte[] bArr, int i, int i2) {
        return (load32(bArr, i) >> i2) & 67108863;
    }

    private static void toByteArray(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    private static void copyBlockSize(byte[] bArr, byte[] bArr2, int i) {
        int min = Math.min(16, bArr2.length - i);
        System.arraycopy(bArr2, i, bArr, 0, min);
        bArr[min] = 1;
        if (min != 16) {
            Arrays.fill(bArr, min + 1, bArr.length, (byte) 0);
        }
    }

    static byte[] computeMac(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            int i = 0;
            long load26 = load26(bArr3, 0, 0) & 67108863;
            int i2 = 2;
            long load262 = load26(bArr3, 3, 2) & 67108611;
            long load263 = load26(bArr3, 6, 4) & 67092735;
            long load264 = load26(bArr3, 9, 6) & 66076671;
            long load265 = load26(bArr3, 12, 8) & 1048575;
            long j = load262 * 5;
            long j2 = load263 * 5;
            long j3 = load264 * 5;
            long j4 = load265 * 5;
            byte[] bArr5 = new byte[17];
            long j5 = 0;
            int i3 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            while (i3 < bArr4.length) {
                copyBlockSize(bArr5, bArr4, i3);
                long load266 = j9 + load26(bArr5, i, i);
                long load267 = j5 + load26(bArr5, 3, i2);
                long load268 = j6 + load26(bArr5, 6, 4);
                long load269 = j7 + load26(bArr5, 9, 6);
                long load2610 = j8 + (load26(bArr5, 12, 8) | ((long) (bArr5[16] << Ascii.CAN)));
                long j10 = (load266 * load26) + (load267 * j4) + (load268 * j3) + (load269 * j2) + (load2610 * j);
                long j11 = (load266 * load262) + (load267 * load26) + (load268 * j4) + (load269 * j3) + (load2610 * j2) + (j10 >> 26);
                long j12 = (load266 * load263) + (load267 * load262) + (load268 * load26) + (load269 * j4) + (load2610 * j3) + (j11 >> 26);
                long j13 = (load266 * load264) + (load267 * load263) + (load268 * load262) + (load269 * load26) + (load2610 * j4) + (j12 >> 26);
                long j14 = (load266 * load265) + (load267 * load264) + (load268 * load263) + (load269 * load262) + (load2610 * load26) + (j13 >> 26);
                long j15 = (j10 & 67108863) + ((j14 >> 26) * 5);
                j5 = (j11 & 67108863) + (j15 >> 26);
                i3 += 16;
                j6 = j12 & 67108863;
                j7 = j13 & 67108863;
                j8 = j14 & 67108863;
                i2 = 2;
                j9 = j15 & 67108863;
                i = 0;
            }
            long j16 = j6 + (j5 >> 26);
            long j17 = j16 & 67108863;
            long j18 = j7 + (j16 >> 26);
            long j19 = j18 & 67108863;
            long j20 = j8 + (j18 >> 26);
            long j21 = j20 & 67108863;
            long j22 = j9 + ((j20 >> 26) * 5);
            long j23 = j22 & 67108863;
            long j24 = (j5 & 67108863) + (j22 >> 26);
            long j25 = j23 + 5;
            long j26 = j25 & 67108863;
            long j27 = (j25 >> 26) + j24;
            long j28 = j17 + (j27 >> 26);
            long j29 = j19 + (j28 >> 26);
            long j30 = (j21 + (j29 >> 26)) - 67108864;
            long j31 = j30 >> 63;
            long j32 = j23 & j31;
            long j33 = j24 & j31;
            long j34 = j17 & j31;
            long j35 = j19 & j31;
            long j36 = j21 & j31;
            long j37 = ~j31;
            long j38 = (j27 & 67108863 & j37) | j33;
            long j39 = (j28 & 67108863 & j37) | j34;
            long j40 = (j29 & 67108863 & j37) | j35;
            long load32 = ((j32 | (j26 & j37) | (j38 << 26)) & 4294967295L) + load32(bArr3, 16);
            long load322 = (((j38 >> 6) | (j39 << 20)) & 4294967295L) + load32(bArr3, 20) + (load32 >> 32);
            long load323 = (((j39 >> 12) | (j40 << 14)) & 4294967295L) + load32(bArr3, 24) + (load322 >> 32);
            byte[] bArr6 = new byte[16];
            toByteArray(bArr6, load32 & 4294967295L, 0);
            toByteArray(bArr6, load322 & 4294967295L, 4);
            toByteArray(bArr6, load323 & 4294967295L, 8);
            toByteArray(bArr6, ((((j40 >> 18) | (((j30 & j37) | j36) << 8)) & 4294967295L) + load32(bArr3, 28) + (load323 >> 32)) & 4294967295L, 12);
            return bArr6;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    static void verifyMac(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
