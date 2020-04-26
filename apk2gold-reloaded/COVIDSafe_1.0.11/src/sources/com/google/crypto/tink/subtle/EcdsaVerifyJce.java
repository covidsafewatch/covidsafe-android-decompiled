package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.EllipticCurves.EcdsaEncoding;
import com.google.crypto.tink.subtle.Enums.HashType;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;

public final class EcdsaVerifyJce implements PublicKeyVerify {
    private final EcdsaEncoding encoding;
    private final ECPublicKey publicKey;
    private final String signatureAlgorithm;

    public EcdsaVerifyJce(ECPublicKey eCPublicKey, HashType hashType, EcdsaEncoding ecdsaEncoding) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(eCPublicKey);
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hashType);
        this.publicKey = eCPublicKey;
        this.encoding = ecdsaEncoding;
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        boolean z;
        String str = "Invalid signature";
        if (this.encoding == EcdsaEncoding.IEEE_P1363) {
            if (bArr.length == EllipticCurves.fieldSizeInBytes(this.publicKey.getParams().getCurve()) * 2) {
                bArr = EllipticCurves.ecdsaIeee2Der(bArr);
            } else {
                throw new GeneralSecurityException(str);
            }
        }
        if (EllipticCurves.isValidDerEncoding(bArr)) {
            Signature signature = (Signature) EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
            signature.initVerify(this.publicKey);
            signature.update(bArr2);
            try {
                z = signature.verify(bArr);
            } catch (RuntimeException unused) {
                z = false;
            }
            if (!z) {
                throw new GeneralSecurityException(str);
            }
            return;
        }
        throw new GeneralSecurityException(str);
    }
}
