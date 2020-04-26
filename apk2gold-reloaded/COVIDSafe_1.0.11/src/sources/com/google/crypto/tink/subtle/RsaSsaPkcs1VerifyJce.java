package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums.HashType;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;

public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;

    public RsaSsaPkcs1VerifyJce(RSAPublicKey rSAPublicKey, HashType hashType) throws GeneralSecurityException {
        this.publicKey = rSAPublicKey;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hashType);
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        boolean z;
        Signature signature = (Signature) EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        signature.initVerify(this.publicKey);
        signature.update(bArr2);
        try {
            z = signature.verify(bArr);
        } catch (RuntimeException unused) {
            z = false;
        }
        if (!z) {
            throw new GeneralSecurityException("Invalid signature");
        }
    }
}
