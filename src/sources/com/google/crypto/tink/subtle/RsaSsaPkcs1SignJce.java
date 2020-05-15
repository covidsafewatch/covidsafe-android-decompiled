package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public final class RsaSsaPkcs1SignJce implements PublicKeySign {
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;

    public RsaSsaPkcs1SignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType) throws GeneralSecurityException {
        this.privateKey = rSAPrivateCrtKey;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hashType);
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
    }

    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        Signature instance = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        instance.initSign(this.privateKey);
        instance.update(bArr);
        byte[] sign = instance.sign();
        Signature instance2 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        instance2.initVerify(this.publicKey);
        instance2.update(bArr);
        if (instance2.verify(sign)) {
            return sign;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
}
