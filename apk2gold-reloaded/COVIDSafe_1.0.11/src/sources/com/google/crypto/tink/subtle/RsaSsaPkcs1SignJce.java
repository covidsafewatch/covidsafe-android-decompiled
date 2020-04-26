package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.subtle.Enums.HashType;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public final class RsaSsaPkcs1SignJce implements PublicKeySign {
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;

    public RsaSsaPkcs1SignJce(RSAPrivateCrtKey rSAPrivateCrtKey, HashType hashType) throws GeneralSecurityException {
        this.privateKey = rSAPrivateCrtKey;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hashType);
        this.publicKey = (RSAPublicKey) ((KeyFactory) EngineFactory.KEY_FACTORY.getInstance("RSA")).generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
    }

    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        Signature signature = (Signature) EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        signature.initSign(this.privateKey);
        signature.update(bArr);
        byte[] sign = signature.sign();
        Signature signature2 = (Signature) EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        signature2.initVerify(this.publicKey);
        signature2.update(bArr);
        if (signature2.verify(sign)) {
            return sign;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
}
