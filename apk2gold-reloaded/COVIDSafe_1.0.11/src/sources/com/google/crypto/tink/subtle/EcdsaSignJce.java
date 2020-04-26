package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.subtle.EllipticCurves.EcdsaEncoding;
import com.google.crypto.tink.subtle.Enums.HashType;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;

public final class EcdsaSignJce implements PublicKeySign {
    private final EcdsaEncoding encoding;
    private final ECPrivateKey privateKey;
    private final String signatureAlgorithm;

    public EcdsaSignJce(ECPrivateKey eCPrivateKey, HashType hashType, EcdsaEncoding ecdsaEncoding) throws GeneralSecurityException {
        this.privateKey = eCPrivateKey;
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hashType);
        this.encoding = ecdsaEncoding;
    }

    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        Signature signature = (Signature) EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        signature.initSign(this.privateKey);
        signature.update(bArr);
        byte[] sign = signature.sign();
        return this.encoding == EcdsaEncoding.IEEE_P1363 ? EllipticCurves.ecdsaDer2Ieee(sign, EllipticCurves.fieldSizeInBytes(this.privateKey.getParams().getCurve()) * 2) : sign;
    }
}
