package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.PemKeyType;
import com.google.crypto.tink.subtle.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.Key;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.List;

public final class SignaturePemKeysetReader implements KeysetReader {
    private List<PemKey> pemKeys;

    SignaturePemKeysetReader(List<PemKey> list) {
        this.pemKeys = list;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private List<PemKey> pemKeys = new ArrayList();

        Builder() {
        }

        public KeysetReader build() {
            return new SignaturePemKeysetReader(this.pemKeys);
        }

        public Builder addPem(String str, PemKeyType pemKeyType) {
            PemKey pemKey = new PemKey((AnonymousClass1) null);
            pemKey.reader = new BufferedReader(new StringReader(str));
            pemKey.type = pemKeyType;
            this.pemKeys.add(pemKey);
            return this;
        }
    }

    private static final class PemKey {
        BufferedReader reader;
        PemKeyType type;

        private PemKey() {
        }

        /* synthetic */ PemKey(AnonymousClass1 r1) {
            this();
        }
    }

    public Keyset read() throws IOException {
        Keyset.Builder newBuilder = Keyset.newBuilder();
        for (PemKey next : this.pemKeys) {
            for (Keyset.Key readKey = readKey(next.reader, next.type); readKey != null; readKey = readKey(next.reader, next.type)) {
                newBuilder.addKey(readKey);
            }
        }
        if (newBuilder.getKeyCount() != 0) {
            newBuilder.setPrimaryKeyId(newBuilder.getKey(0).getKeyId());
            return (Keyset) newBuilder.build();
        }
        throw new IOException("cannot find any key");
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        throw new UnsupportedOperationException();
    }

    private static Keyset.Key readKey(BufferedReader bufferedReader, PemKeyType pemKeyType) throws IOException {
        KeyData keyData;
        Key readKey = pemKeyType.readKey(bufferedReader);
        if (readKey == null) {
            return null;
        }
        if (readKey instanceof RSAPublicKey) {
            keyData = convertRsaPublicKey(pemKeyType, (RSAPublicKey) readKey);
        } else if (!(readKey instanceof ECPublicKey)) {
            return null;
        } else {
            keyData = convertEcPublicKey(pemKeyType, (ECPublicKey) readKey);
        }
        return (Keyset.Key) Keyset.Key.newBuilder().setKeyData(keyData).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(OutputPrefixType.RAW).setKeyId(Random.randInt()).build();
    }

    private static KeyData convertRsaPublicKey(PemKeyType pemKeyType, RSAPublicKey rSAPublicKey) throws IOException {
        if (pemKeyType.algorithm.equals("RSASSA-PKCS1-v1_5")) {
            return (KeyData) KeyData.newBuilder().setTypeUrl(new RsaSsaPkcs1VerifyKeyManager().getKeyType()).setValue(((RsaSsaPkcs1PublicKey) RsaSsaPkcs1PublicKey.newBuilder().setVersion(new RsaSsaPkcs1VerifyKeyManager().getVersion()).setParams((RsaSsaPkcs1Params) RsaSsaPkcs1Params.newBuilder().setHashType(getHashType(pemKeyType)).build()).setE(ByteString.copyFrom(rSAPublicKey.getPublicExponent().toByteArray())).setN(ByteString.copyFrom(rSAPublicKey.getModulus().toByteArray())).build()).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        } else if (pemKeyType.algorithm.equals("RSASSA-PSS")) {
            return (KeyData) KeyData.newBuilder().setTypeUrl(new RsaSsaPssVerifyKeyManager().getKeyType()).setValue(((RsaSsaPssPublicKey) RsaSsaPssPublicKey.newBuilder().setVersion(new RsaSsaPssVerifyKeyManager().getVersion()).setParams((RsaSsaPssParams) RsaSsaPssParams.newBuilder().setSigHash(getHashType(pemKeyType)).setMgf1Hash(getHashType(pemKeyType)).setSaltLength(getDigestSizeInBytes(pemKeyType)).build()).setE(ByteString.copyFrom(rSAPublicKey.getPublicExponent().toByteArray())).setN(ByteString.copyFrom(rSAPublicKey.getModulus().toByteArray())).build()).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        } else {
            throw new IOException("unsupported RSA signature algorithm: " + pemKeyType.algorithm);
        }
    }

    private static KeyData convertEcPublicKey(PemKeyType pemKeyType, ECPublicKey eCPublicKey) throws IOException {
        if (pemKeyType.algorithm.equals("ECDSA")) {
            return (KeyData) KeyData.newBuilder().setTypeUrl(new EcdsaVerifyKeyManager().getKeyType()).setValue(((EcdsaPublicKey) EcdsaPublicKey.newBuilder().setVersion(new EcdsaVerifyKeyManager().getVersion()).setParams((EcdsaParams) EcdsaParams.newBuilder().setHashType(getHashType(pemKeyType)).setCurve(getCurveType(pemKeyType)).setEncoding(EcdsaSignatureEncoding.DER).build()).setX(ByteString.copyFrom(eCPublicKey.getW().getAffineX().toByteArray())).setY(ByteString.copyFrom(eCPublicKey.getW().getAffineY().toByteArray())).build()).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        }
        throw new IOException("unsupported EC signature algorithm: " + pemKeyType.algorithm);
    }

    /* renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
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
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.signature.SignaturePemKeysetReader.AnonymousClass1.<clinit>():void");
        }
    }

    private static HashType getHashType(PemKeyType pemKeyType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.hash.ordinal()];
        if (i == 1) {
            return HashType.SHA256;
        }
        if (i == 2) {
            return HashType.SHA384;
        }
        if (i == 3) {
            return HashType.SHA512;
        }
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.hash.name());
    }

    private static int getDigestSizeInBytes(PemKeyType pemKeyType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.hash.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 48;
        }
        if (i == 3) {
            return 64;
        }
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.hash.name());
    }

    private static EllipticCurveType getCurveType(PemKeyType pemKeyType) {
        int i = pemKeyType.keySizeInBits;
        if (i == 256) {
            return EllipticCurveType.NIST_P256;
        }
        if (i == 384) {
            return EllipticCurveType.NIST_P384;
        }
        if (i == 521) {
            return EllipticCurveType.NIST_P521;
        }
        throw new IllegalArgumentException("unsupported curve for key size: " + pemKeyType.keySizeInBits);
    }
}
