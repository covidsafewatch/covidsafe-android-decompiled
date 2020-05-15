package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

final class Ed25519Constants {
    static final Ed25519.CachedXYT[] B2 = new Ed25519.CachedXYT[8];
    static final Ed25519.CachedXYT[][] B_TABLE = ((Ed25519.CachedXYT[][]) Array.newInstance(Ed25519.CachedXYT.class, new int[]{32, 8}));
    static final long[] D = Field25519.expand(toLittleEndian(D_BI));
    static final long[] D2 = Field25519.expand(toLittleEndian(D2_BI));
    private static final BigInteger D2_BI = BigInteger.valueOf(2).multiply(D_BI).mod(P_BI);
    private static final BigInteger D_BI = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(P_BI)).mod(P_BI);
    private static final BigInteger P_BI = BigInteger.valueOf(2).pow(255).subtract(BigInteger.valueOf(19));
    static final long[] SQRTM1 = Field25519.expand(toLittleEndian(SQRTM1_BI));
    private static final BigInteger SQRTM1_BI = BigInteger.valueOf(2).modPow(P_BI.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), P_BI);

    Ed25519Constants() {
    }

    static {
        Point point = new Point();
        BigInteger unused = point.y = BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(P_BI)).mod(P_BI);
        BigInteger unused2 = point.x = recoverX(point.y);
        Point point2 = point;
        for (int i = 0; i < 32; i++) {
            Point point3 = point2;
            for (int i2 = 0; i2 < 8; i2++) {
                B_TABLE[i][i2] = getCachedXYT(point3);
                point3 = edwards(point3, point2);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                point2 = edwards(point2, point2);
            }
        }
        Point edwards = edwards(point, point);
        for (int i4 = 0; i4 < 8; i4++) {
            B2[i4] = getCachedXYT(point);
            point = edwards(point, edwards);
        }
    }

    private static class Point {
        /* access modifiers changed from: private */
        public BigInteger x;
        /* access modifiers changed from: private */
        public BigInteger y;

        private Point() {
        }
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger multiply = bigInteger.pow(2).subtract(BigInteger.ONE).multiply(D_BI.multiply(bigInteger.pow(2)).add(BigInteger.ONE).modInverse(P_BI));
        BigInteger modPow = multiply.modPow(P_BI.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), P_BI);
        if (!modPow.pow(2).subtract(multiply).mod(P_BI).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(SQRTM1_BI).mod(P_BI);
        }
        return modPow.testBit(0) ? P_BI.subtract(modPow) : modPow;
    }

    private static Point edwards(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger mod = D_BI.multiply(point.x.multiply(point2.x).multiply(point.y).multiply(point2.y)).mod(P_BI);
        BigInteger unused = point3.x = point.x.multiply(point2.y).add(point2.x.multiply(point.y)).multiply(BigInteger.ONE.add(mod).modInverse(P_BI)).mod(P_BI);
        BigInteger unused2 = point3.y = point.y.multiply(point2.y).add(point.x.multiply(point2.x)).multiply(BigInteger.ONE.subtract(mod).modInverse(P_BI)).mod(P_BI);
        return point3;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = (32 - i) - 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point point) {
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(point.y.add(point.x).mod(P_BI))), Field25519.expand(toLittleEndian(point.y.subtract(point.x).mod(P_BI))), Field25519.expand(toLittleEndian(D2_BI.multiply(point.x).multiply(point.y).mod(P_BI))));
    }
}
