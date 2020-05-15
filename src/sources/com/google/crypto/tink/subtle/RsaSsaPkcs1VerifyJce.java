package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;

public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;

    public RsaSsaPkcs1VerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType) throws GeneralSecurityException {
        this.publicKey = rSAPublicKey;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hashType);
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        boolean z;
        Signature instance = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        instance.initVerify(this.publicKey);
        instance.update(bArr2);
        try {
            z = instance.verify(bArr);
        } catch (RuntimeException unused) {
            z = false;
        }
        if (!z) {
            throw new GeneralSecurityException("Invalid signature");
        }
    }
}
