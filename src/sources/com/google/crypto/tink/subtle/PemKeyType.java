package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public enum PemKeyType {
    RSA_PSS_2048_SHA256("RSA", "RSASSA-PSS", 2048, Enums.HashType.SHA256),
    RSA_PSS_3072_SHA256("RSA", "RSASSA-PSS", 3072, Enums.HashType.SHA256),
    RSA_PSS_4096_SHA256("RSA", "RSASSA-PSS", 4096, Enums.HashType.SHA256),
    RSA_PSS_4096_SHA512("RSA", "RSASSA-PSS", 4096, Enums.HashType.SHA512),
    RSA_SIGN_PKCS1_2048_SHA256("RSA", "RSASSA-PKCS1-v1_5", 2048, Enums.HashType.SHA256),
    RSA_SIGN_PKCS1_3072_SHA256("RSA", "RSASSA-PKCS1-v1_5", 3072, Enums.HashType.SHA256),
    RSA_SIGN_PKCS1_4096_SHA256("RSA", "RSASSA-PKCS1-v1_5", 4096, Enums.HashType.SHA256),
    RSA_SIGN_PKCS1_4096_SHA512("RSA", "RSASSA-PKCS1-v1_5", 4096, Enums.HashType.SHA512),
    ECDSA_P256_SHA256("EC", "ECDSA", 256, Enums.HashType.SHA256),
    ECDSA_P384_SHA384("EC", "ECDSA", 384, Enums.HashType.SHA384),
    ECDSA_P521_SHA512("EC", "ECDSA", 521, Enums.HashType.SHA512);
    
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";
    private static final String MARKER = "-----";
    private static final String PRIVATE_KEY = "PRIVATE KEY";
    private static final String PUBLIC_KEY = "PUBLIC KEY";
    public final String algorithm;
    public final Enums.HashType hash;
    public final int keySizeInBits;
    public final String keyType;

    private PemKeyType(String str, String str2, int i, Enums.HashType hashType) {
        this.keyType = str;
        this.algorithm = str2;
        this.keySizeInBits = i;
        this.hash = hashType;
    }

    public Key readKey(BufferedReader bufferedReader) throws IOException {
        String substring;
        int indexOf;
        String readLine = bufferedReader.readLine();
        while (readLine != null && !readLine.startsWith(BEGIN)) {
            readLine = bufferedReader.readLine();
        }
        if (readLine == null || (indexOf = substring.indexOf(MARKER)) < 0) {
            return null;
        }
        String substring2 = (substring = readLine.trim().substring(11)).substring(0, indexOf);
        String str = END + substring2 + MARKER;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                if (readLine2.indexOf(":") <= 0) {
                    if (!readLine2.contains(str)) {
                        sb.append(readLine2);
                    }
                }
            }
            try {
                byte[] decode = Base64.decode(sb.toString(), 0);
                if (substring2.contains(PUBLIC_KEY)) {
                    return getPublicKey(decode);
                }
                if (substring2.contains(PRIVATE_KEY)) {
                    return getPrivateKey(decode);
                }
                return null;
            } catch (IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
    }

    private Key getPublicKey(byte[] bArr) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePublic(new X509EncodedKeySpec(bArr)));
    }

    private Key getPrivateKey(byte[] bArr) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePrivate(new PKCS8EncodedKeySpec(bArr)));
    }

    private Key validate(Key key) throws GeneralSecurityException {
        if (this.keyType.equals("RSA")) {
            int bitLength = ((RSAKey) key).getModulus().bitLength();
            if (bitLength != this.keySizeInBits) {
                throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(bitLength)}));
            }
        } else {
            ECParameterSpec params = ((ECKey) key).getParams();
            if (EllipticCurves.isNistEcParameterSpec(params)) {
                int fieldSizeInBits = EllipticCurves.fieldSizeInBits(params.getCurve());
                if (fieldSizeInBits != this.keySizeInBits) {
                    throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(fieldSizeInBits)}));
                }
            } else {
                throw new GeneralSecurityException("unsupport EC spec: " + params.toString());
            }
        }
        return key;
    }
}
