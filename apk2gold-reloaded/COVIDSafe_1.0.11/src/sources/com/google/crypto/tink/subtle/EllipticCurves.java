package com.google.crypto.tink.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

public final class EllipticCurves {

    /* renamed from: com.google.crypto.tink.subtle.EllipticCurves$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.google.crypto.tink.subtle.EllipticCurves$CurveType[] r0 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = r0
                r1 = 1
                com.google.crypto.tink.subtle.EllipticCurves$CurveType r2 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.NIST_P256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.subtle.EllipticCurves$CurveType r3 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.NIST_P384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.subtle.EllipticCurves$CurveType r4 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.NIST_P521     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType[] r3 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType = r3
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType r4 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.UNCOMPRESSED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType r3 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType r1 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.COMPRESSED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.EllipticCurves.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CurveType {
        NIST_P256,
        NIST_P384,
        NIST_P521
    }

    public enum EcdsaEncoding {
        IEEE_P1363,
        DER
    }

    public enum PointFormatType {
        UNCOMPRESSED,
        COMPRESSED,
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED
    }

    public static ECParameterSpec getNistP256Params() {
        return getNistCurveSpec("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    public static ECParameterSpec getNistP384Params() {
        return getNistCurveSpec("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    public static ECParameterSpec getNistP521Params() {
        return getNistCurveSpec("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }

    static void checkPointOnCurve(ECPoint eCPoint, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ellipticCurve);
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        } else if (affineX.signum() == -1 || affineX.compareTo(modulus) != -1) {
            throw new GeneralSecurityException("x is out of range");
        } else if (affineY.signum() == -1 || affineY.compareTo(modulus) != -1) {
            throw new GeneralSecurityException("y is out of range");
        } else if (!affineY.multiply(affineY).mod(modulus).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(modulus))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    static void checkPublicKey(ECPublicKey eCPublicKey) throws GeneralSecurityException {
        checkPointOnCurve(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }

    public static void validatePublicKey(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        checkPointOnCurve(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    static void validatePublicKeySpec(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            ECParameterSpec params = eCPublicKey.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }

    public static BigInteger getModulus(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        ECField field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp) field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    private static int fieldSizeInBits(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return getModulus(ellipticCurve).subtract(BigInteger.ONE).bitLength();
    }

    public static int fieldSizeInBytes(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (fieldSizeInBits(ellipticCurve) + 7) / 8;
    }

    private static ECParameterSpec getNistCurveSpec(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    protected static BigInteger modSqrt(BigInteger bigInteger, BigInteger bigInteger2) throws GeneralSecurityException {
        if (bigInteger2.signum() == 1) {
            BigInteger mod = bigInteger.mod(bigInteger2);
            BigInteger bigInteger3 = null;
            if (mod.equals(BigInteger.ZERO)) {
                return BigInteger.ZERO;
            }
            int i = 0;
            if (bigInteger2.testBit(0) && bigInteger2.testBit(1)) {
                bigInteger3 = mod.modPow(bigInteger2.add(BigInteger.ONE).shiftRight(2), bigInteger2);
            } else if (bigInteger2.testBit(0) && !bigInteger2.testBit(1)) {
                BigInteger bigInteger4 = BigInteger.ONE;
                BigInteger shiftRight = bigInteger2.subtract(BigInteger.ONE).shiftRight(1);
                while (true) {
                    BigInteger mod2 = bigInteger4.multiply(bigInteger4).subtract(mod).mod(bigInteger2);
                    if (mod2.equals(BigInteger.ZERO)) {
                        return bigInteger4;
                    }
                    BigInteger modPow = mod2.modPow(shiftRight, bigInteger2);
                    if (modPow.add(BigInteger.ONE).equals(bigInteger2)) {
                        BigInteger shiftRight2 = bigInteger2.add(BigInteger.ONE).shiftRight(1);
                        BigInteger bigInteger5 = BigInteger.ONE;
                        BigInteger bigInteger6 = bigInteger4;
                        for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                            BigInteger multiply = bigInteger6.multiply(bigInteger5);
                            bigInteger6 = bigInteger6.multiply(bigInteger6).add(bigInteger5.multiply(bigInteger5).mod(bigInteger2).multiply(mod2)).mod(bigInteger2);
                            bigInteger5 = multiply.add(multiply).mod(bigInteger2);
                            if (shiftRight2.testBit(bitLength)) {
                                BigInteger mod3 = bigInteger6.multiply(bigInteger4).add(bigInteger5.multiply(mod2)).mod(bigInteger2);
                                bigInteger5 = bigInteger4.multiply(bigInteger5).add(bigInteger6).mod(bigInteger2);
                                bigInteger6 = mod3;
                            }
                        }
                        bigInteger3 = bigInteger6;
                    } else {
                        boolean equals = modPow.equals(BigInteger.ONE);
                        String str = "p is not prime";
                        if (equals) {
                            bigInteger4 = bigInteger4.add(BigInteger.ONE);
                            i++;
                            if (i == 128 && !bigInteger2.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException(str);
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException(str);
                        }
                    }
                }
            }
            if (bigInteger3 == null || bigInteger3.multiply(bigInteger3).mod(bigInteger2).compareTo(mod) == 0) {
                return bigInteger3;
            }
            throw new GeneralSecurityException("Could not find a modular square root");
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static BigInteger getY(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ellipticCurve);
        BigInteger modSqrt = modSqrt(bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(modulus), modulus);
        return z != modSqrt.testBit(0) ? modulus.subtract(modSqrt).mod(modulus) : modSqrt;
    }

    private static byte[] toMinimalSignedNumber(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length && bArr[i2] == 0) {
            i2++;
        }
        if (i2 == bArr.length) {
            i2 = bArr.length - 1;
        }
        if ((bArr[i2] & 128) == 128) {
            i = 1;
        }
        byte[] bArr2 = new byte[((bArr.length - i2) + i)];
        System.arraycopy(bArr, i2, bArr2, i, bArr.length - i2);
        return bArr2;
    }

    public static byte[] ecdsaIeee2Der(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        int i;
        if (bArr.length % 2 != 0 || bArr.length == 0 || bArr.length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        byte[] minimalSignedNumber = toMinimalSignedNumber(Arrays.copyOf(bArr, bArr.length / 2));
        byte[] minimalSignedNumber2 = toMinimalSignedNumber(Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length));
        int length = minimalSignedNumber.length + 2 + 1 + 1 + minimalSignedNumber2.length;
        if (length >= 128) {
            bArr2 = new byte[(length + 3)];
            bArr2[0] = 48;
            bArr2[1] = -127;
            bArr2[2] = (byte) length;
            i = 3;
        } else {
            bArr2 = new byte[(length + 2)];
            bArr2[0] = 48;
            bArr2[1] = (byte) length;
            i = 2;
        }
        int i2 = i + 1;
        bArr2[i] = 2;
        int i3 = i2 + 1;
        bArr2[i2] = (byte) minimalSignedNumber.length;
        System.arraycopy(minimalSignedNumber, 0, bArr2, i3, minimalSignedNumber.length);
        int length2 = i3 + minimalSignedNumber.length;
        int i4 = length2 + 1;
        bArr2[length2] = 2;
        int i5 = i4 + 1;
        bArr2[i4] = (byte) minimalSignedNumber2.length;
        System.arraycopy(minimalSignedNumber2, 0, bArr2, i5, minimalSignedNumber2.length);
        return bArr2;
    }

    public static byte[] ecdsaDer2Ieee(byte[] bArr, int i) throws GeneralSecurityException {
        if (isValidDerEncoding(bArr)) {
            byte[] bArr2 = new byte[i];
            byte b = 1;
            int i2 = ((bArr[1] & 255) >= 128 ? 3 : 2) + 1;
            int i3 = i2 + 1;
            byte b2 = bArr[i2];
            byte b3 = bArr[i3] == 0 ? (byte) 1 : 0;
            System.arraycopy(bArr, i3 + b3, bArr2, ((i / 2) - b2) + b3, b2 - b3);
            int i4 = i3 + b2 + 1;
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            if (bArr[i5] != 0) {
                b = 0;
            }
            System.arraycopy(bArr, i5 + b, bArr2, (i - b4) + b, b4 - b);
            return bArr2;
        }
        throw new GeneralSecurityException("Invalid DER encoding");
    }

    public static boolean isValidDerEncoding(byte[] bArr) {
        int i;
        if (bArr.length < 8 || bArr[0] != 48) {
            return false;
        }
        byte b = bArr[1] & 255;
        if (b == 129) {
            b = bArr[2] & 255;
            if (b < 128) {
                return false;
            }
            i = 2;
        } else if (b == 128 || b > 129) {
            return false;
        } else {
            i = 1;
        }
        if (b != (bArr.length - 1) - i) {
            return false;
        }
        int i2 = i + 1;
        if (bArr[i2] != 2) {
            return false;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i3] & 255;
        int i4 = i3 + 1 + b2 + 1;
        if (i4 >= bArr.length || b2 == 0) {
            return false;
        }
        int i5 = i + 3;
        if ((bArr[i5] & 255) >= 128) {
            return false;
        }
        if ((b2 > 1 && bArr[i5] == 0 && (bArr[i + 4] & 255) < 128) || bArr[i5 + b2] != 2) {
            return false;
        }
        byte b3 = bArr[i4] & 255;
        if (i4 + 1 + b3 != bArr.length || b3 == 0) {
            return false;
        }
        int i6 = i + 5 + b2;
        if ((bArr[i6] & 255) >= 128) {
            return false;
        }
        return b3 <= 1 || bArr[i6] != 0 || (bArr[(i + 6) + b2] & 255) >= 128;
    }

    public static int encodingSizeInBytes(EllipticCurve ellipticCurve, PointFormatType pointFormatType) throws GeneralSecurityException {
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        if (i == 1) {
            return (fieldSizeInBytes * 2) + 1;
        }
        if (i == 2) {
            return fieldSizeInBytes * 2;
        }
        if (i == 3) {
            return fieldSizeInBytes + 1;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    @Deprecated
    public static ECPoint ecPointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return pointDecode(ellipticCurve, pointFormatType, bArr);
    }

    public static ECPoint pointDecode(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return pointDecode(getCurveSpec(curveType).getCurve(), pointFormatType, bArr);
    }

    public static ECPoint pointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        String str = "invalid point size";
        boolean z = false;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    BigInteger modulus = getModulus(ellipticCurve);
                    if (bArr.length == fieldSizeInBytes + 1) {
                        if (bArr[0] != 2) {
                            if (bArr[0] == 3) {
                                z = true;
                            } else {
                                throw new GeneralSecurityException("invalid format");
                            }
                        }
                        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
                        if (bigInteger.signum() != -1 && bigInteger.compareTo(modulus) == -1) {
                            return new ECPoint(bigInteger, getY(bigInteger, z, ellipticCurve));
                        }
                        throw new GeneralSecurityException("x is out of range");
                    }
                    throw new GeneralSecurityException("compressed point has wrong length");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("invalid format:");
                sb.append(pointFormatType);
                throw new GeneralSecurityException(sb.toString());
            } else if (bArr.length == fieldSizeInBytes * 2) {
                ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, fieldSizeInBytes)), new BigInteger(1, Arrays.copyOfRange(bArr, fieldSizeInBytes, bArr.length)));
                checkPointOnCurve(eCPoint, ellipticCurve);
                return eCPoint;
            } else {
                throw new GeneralSecurityException(str);
            }
        } else if (bArr.length != (fieldSizeInBytes * 2) + 1) {
            throw new GeneralSecurityException(str);
        } else if (bArr[0] == 4) {
            int i2 = fieldSizeInBytes + 1;
            ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i2)), new BigInteger(1, Arrays.copyOfRange(bArr, i2, bArr.length)));
            checkPointOnCurve(eCPoint2, ellipticCurve);
            return eCPoint2;
        } else {
            throw new GeneralSecurityException("invalid point format");
        }
    }

    public static byte[] pointEncode(CurveType curveType, PointFormatType pointFormatType, ECPoint eCPoint) throws GeneralSecurityException {
        return pointEncode(getCurveSpec(curveType).getCurve(), pointFormatType, eCPoint);
    }

    public static byte[] pointEncode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, ECPoint eCPoint) throws GeneralSecurityException {
        checkPointOnCurve(eCPoint, ellipticCurve);
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        if (i != 1) {
            int i2 = 2;
            if (i == 2) {
                int i3 = fieldSizeInBytes * 2;
                byte[] bArr = new byte[i3];
                byte[] byteArray = eCPoint.getAffineX().toByteArray();
                if (byteArray.length > fieldSizeInBytes) {
                    byteArray = Arrays.copyOfRange(byteArray, byteArray.length - fieldSizeInBytes, byteArray.length);
                }
                byte[] byteArray2 = eCPoint.getAffineY().toByteArray();
                if (byteArray2.length > fieldSizeInBytes) {
                    byteArray2 = Arrays.copyOfRange(byteArray2, byteArray2.length - fieldSizeInBytes, byteArray2.length);
                }
                System.arraycopy(byteArray2, 0, bArr, i3 - byteArray2.length, byteArray2.length);
                System.arraycopy(byteArray, 0, bArr, fieldSizeInBytes - byteArray.length, byteArray.length);
                return bArr;
            } else if (i == 3) {
                int i4 = fieldSizeInBytes + 1;
                byte[] bArr2 = new byte[i4];
                byte[] byteArray3 = eCPoint.getAffineX().toByteArray();
                System.arraycopy(byteArray3, 0, bArr2, i4 - byteArray3.length, byteArray3.length);
                if (eCPoint.getAffineY().testBit(0)) {
                    i2 = 3;
                }
                bArr2[0] = (byte) i2;
                return bArr2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid format:");
                sb.append(pointFormatType);
                throw new GeneralSecurityException(sb.toString());
            }
        } else {
            int i5 = (fieldSizeInBytes * 2) + 1;
            byte[] bArr3 = new byte[i5];
            byte[] byteArray4 = eCPoint.getAffineX().toByteArray();
            byte[] byteArray5 = eCPoint.getAffineY().toByteArray();
            System.arraycopy(byteArray5, 0, bArr3, i5 - byteArray5.length, byteArray5.length);
            System.arraycopy(byteArray4, 0, bArr3, (fieldSizeInBytes + 1) - byteArray4.length, byteArray4.length);
            bArr3[0] = 4;
            return bArr3;
        }
    }

    public static ECParameterSpec getCurveSpec(CurveType curveType) throws NoSuchAlgorithmException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[curveType.ordinal()];
        if (i == 1) {
            return getNistP256Params();
        }
        if (i == 2) {
            return getNistP384Params();
        }
        if (i == 3) {
            return getNistP521Params();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("curve not implemented:");
        sb.append(curveType);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static ECPublicKey getEcPublicKey(byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("EC")).generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return getEcPublicKey(getCurveSpec(curveType), pointFormatType, bArr);
    }

    public static ECPublicKey getEcPublicKey(ECParameterSpec eCParameterSpec, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("EC")).generatePublic(new ECPublicKeySpec(pointDecode(eCParameterSpec.getCurve(), pointFormatType, bArr), eCParameterSpec));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec curveSpec = getCurveSpec(curveType);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        checkPointOnCurve(eCPoint, curveSpec.getCurve());
        return (ECPublicKey) ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("EC")).generatePublic(new ECPublicKeySpec(eCPoint, curveSpec));
    }

    public static ECPrivateKey getEcPrivateKey(byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("EC")).generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static ECPrivateKey getEcPrivateKey(CurveType curveType, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), getCurveSpec(curveType)));
    }

    public static KeyPair generateKeyPair(CurveType curveType) throws GeneralSecurityException {
        return generateKeyPair(getCurveSpec(curveType));
    }

    public static KeyPair generateKeyPair(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) EngineFactory.KEY_PAIR_GENERATOR.getInstance("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    private static void validateSharedSecret(byte[] bArr, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.signum() == -1 || bigInteger.compareTo(getModulus(curve)) != -1) {
            throw new GeneralSecurityException("shared secret is out of range");
        }
        getY(bigInteger, true, curve);
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        return computeSharedSecret(eCPrivateKey, eCPublicKey.getW());
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws GeneralSecurityException {
        checkPointOnCurve(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) EngineFactory.KEY_AGREEMENT.getInstance("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(generatePublic, true);
            byte[] generateSecret = keyAgreement.generateSecret();
            validateSharedSecret(generateSecret, eCPrivateKey);
            return generateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}
