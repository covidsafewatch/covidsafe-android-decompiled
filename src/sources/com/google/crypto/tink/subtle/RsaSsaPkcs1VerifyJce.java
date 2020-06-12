package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;

public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private static final String ASN_PREFIX_SHA256 = "3031300d060960864801650304020105000420";
    private static final String ASN_PREFIX_SHA512 = "3051300d060960864801650304020305000440";
    private final Enums.HashType hash;
    private final RSAPublicKey publicKey;

    public RsaSsaPkcs1VerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        this.publicKey = rSAPublicKey;
        this.hash = hashType;
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        if (bitLength == bArr.length) {
            BigInteger bytes2Integer = SubtleUtil.bytes2Integer(bArr);
            if (bytes2Integer.compareTo(modulus) >= 0) {
                throw new GeneralSecurityException("signature out of range");
            } else if (!Bytes.equal(SubtleUtil.integer2Bytes(bytes2Integer.modPow(publicExponent, modulus), bitLength), emsaPkcs1(bArr2, bitLength, this.hash))) {
                throw new GeneralSecurityException("invalid signature");
            }
        } else {
            throw new GeneralSecurityException("invalid signature's length");
        }
    }

    private byte[] emsaPkcs1(byte[] bArr, int i, Enums.HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.hash));
        instance.update(bArr);
        byte[] digest = instance.digest();
        byte[] asnPrefix = toAsnPrefix(hashType);
        int length = asnPrefix.length + digest.length;
        if (i >= length + 11) {
            byte[] bArr2 = new byte[i];
            bArr2[0] = 0;
            int i2 = 2;
            bArr2[1] = 1;
            int i3 = 0;
            while (i3 < (i - length) - 3) {
                bArr2[i2] = -1;
                i3++;
                i2++;
            }
            int i4 = i2 + 1;
            bArr2[i2] = 0;
            System.arraycopy(asnPrefix, 0, bArr2, i4, asnPrefix.length);
            System.arraycopy(digest, 0, bArr2, i4 + asnPrefix.length, digest.length);
            return bArr2;
        }
        throw new GeneralSecurityException("intended encoded message length too short");
    }

    /* renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.crypto.tink.subtle.Enums$HashType[] r0 = com.google.crypto.tink.subtle.Enums.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce.AnonymousClass1.<clinit>():void");
        }
    }

    private byte[] toAsnPrefix(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return Hex.decode(ASN_PREFIX_SHA256);
        }
        if (i == 2) {
            return Hex.decode(ASN_PREFIX_SHA512);
        }
        throw new GeneralSecurityException("Unsupported hash " + hashType);
    }
}
