package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;

public final class EcdsaVerifyJce implements PublicKeyVerify {
    private final EllipticCurves.EcdsaEncoding encoding;
    private final ECPublicKey publicKey;
    private final String signatureAlgorithm;

    public EcdsaVerifyJce(ECPublicKey eCPublicKey, Enums.HashType hashType, EllipticCurves.EcdsaEncoding ecdsaEncoding) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(eCPublicKey);
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hashType);
        this.publicKey = eCPublicKey;
        this.encoding = ecdsaEncoding;
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        boolean z;
        if (this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363) {
            if (bArr.length == EllipticCurves.fieldSizeInBytes(this.publicKey.getParams().getCurve()) * 2) {
                bArr = EllipticCurves.ecdsaIeee2Der(bArr);
            } else {
                throw new GeneralSecurityException("Invalid signature");
            }
        }
        if (EllipticCurves.isValidDerEncoding(bArr)) {
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
            return;
        }
        throw new GeneralSecurityException("Invalid signature");
    }
}
