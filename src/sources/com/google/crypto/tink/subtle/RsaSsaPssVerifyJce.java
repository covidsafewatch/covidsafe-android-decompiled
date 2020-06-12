package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        this.publicKey = rSAPublicKey;
        this.sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i;
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        int bitLength2 = ((modulus.bitLength() - 1) + 7) / 8;
        if (bitLength == bArr.length) {
            BigInteger bytes2Integer = SubtleUtil.bytes2Integer(bArr);
            if (bytes2Integer.compareTo(modulus) < 0) {
                emsaPssVerify(bArr2, SubtleUtil.integer2Bytes(bytes2Integer.modPow(publicExponent, modulus), bitLength2), modulus.bitLength() - 1);
                return;
            }
            throw new GeneralSecurityException("signature out of range");
        }
        throw new GeneralSecurityException("invalid signature's length");
    }

    private void emsaPssVerify(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        byte[] bArr3 = bArr2;
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = instance.digest(bArr);
        int digestLength = instance.getDigestLength();
        int length = bArr3.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        } else if (bArr3[bArr3.length - 1] == -68) {
            int i2 = length - digestLength;
            int i3 = i2 - 1;
            byte[] copyOf = Arrays.copyOf(bArr3, i3);
            byte[] copyOfRange = Arrays.copyOfRange(bArr3, copyOf.length, copyOf.length + digestLength);
            int i4 = 0;
            while (true) {
                int i5 = i3;
                MessageDigest messageDigest = instance;
                byte[] bArr4 = digest;
                long j = (((long) length) * 8) - ((long) i);
                if (((long) i4) < j) {
                    if (((copyOf[i4 / 8] >> (7 - (i4 % 8))) & 1) == 0) {
                        i4++;
                        i3 = i5;
                        instance = messageDigest;
                        digest = bArr4;
                    } else {
                        throw new GeneralSecurityException("inconsistent");
                    }
                } else {
                    byte[] mgf1 = SubtleUtil.mgf1(copyOfRange, i5, this.mgf1Hash);
                    int length2 = mgf1.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i6 = 0; i6 < length2; i6++) {
                        bArr5[i6] = (byte) (mgf1[i6] ^ copyOf[i6]);
                    }
                    for (int i7 = 0; ((long) i7) <= j; i7++) {
                        int i8 = i7 / 8;
                        bArr5[i8] = (byte) ((~(1 << (7 - (i7 % 8)))) & bArr5[i8]);
                    }
                    int i9 = 0;
                    while (true) {
                        int i10 = this.saltLength;
                        if (i9 < (i2 - i10) - 2) {
                            if (bArr5[i9] == 0) {
                                i9++;
                            } else {
                                throw new GeneralSecurityException("inconsistent");
                            }
                        } else if (bArr5[(i2 - i10) - 2] == 1) {
                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr5, length2 - i10, length2);
                            int i11 = digestLength + 8;
                            byte[] bArr6 = new byte[(this.saltLength + i11)];
                            byte[] bArr7 = bArr4;
                            System.arraycopy(bArr7, 0, bArr6, 8, bArr7.length);
                            System.arraycopy(copyOfRange2, 0, bArr6, i11, copyOfRange2.length);
                            if (!Bytes.equal(messageDigest.digest(bArr6), copyOfRange)) {
                                throw new GeneralSecurityException("inconsistent");
                            }
                            return;
                        } else {
                            throw new GeneralSecurityException("inconsistent");
                        }
                    }
                }
            }
        } else {
            throw new GeneralSecurityException("inconsistent");
        }
    }
}
