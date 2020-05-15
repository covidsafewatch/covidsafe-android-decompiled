package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.subtle.EciesHkdfSenderKem;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

public final class EciesAeadHkdfHybridEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_AAD = new byte[0];
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final EciesHkdfSenderKem senderKem;

    public EciesAeadHkdfHybridEncrypt(ECPublicKey eCPublicKey, byte[] bArr, String str, EllipticCurves.PointFormatType pointFormatType, EciesAeadHkdfDemHelper eciesAeadHkdfDemHelper) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(eCPublicKey);
        this.senderKem = new EciesHkdfSenderKem(eCPublicKey);
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.ecPointFormat = pointFormatType;
        this.demHelper = eciesAeadHkdfDemHelper;
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        EciesHkdfSenderKem.KemKey generateKey = this.senderKem.generateKey(this.hkdfHmacAlgo, this.hkdfSalt, bArr2, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat);
        byte[] encrypt = this.demHelper.getAead(generateKey.getSymmetricKey()).encrypt(bArr, EMPTY_AAD);
        byte[] kemBytes = generateKey.getKemBytes();
        return ByteBuffer.allocate(kemBytes.length + encrypt.length).put(kemBytes).put(encrypt).array();
    }
}
