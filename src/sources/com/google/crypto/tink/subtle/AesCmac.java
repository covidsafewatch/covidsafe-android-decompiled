package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class AesCmac implements Mac {
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private final SecretKey keySpec;
    private byte[] subKey1;
    private byte[] subKey2;
    private final int tagSizeInBytes;

    private static Cipher instance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
    }

    public AesCmac(byte[] bArr, int i) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, min is 10 bytes");
        } else if (i <= 16) {
            this.keySpec = new SecretKeySpec(bArr, "AES");
            this.tagSizeInBytes = i;
            generateSubKeys();
        } else {
            throw new InvalidAlgorithmParameterException("tag size too large, max is 16 bytes");
        }
    }

    public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        Cipher instance = instance();
        instance.init(1, this.keySpec);
        int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        if (max * 16 == bArr.length) {
            bArr2 = Bytes.xor(bArr, (max - 1) * 16, this.subKey1, 0, 16);
        } else {
            bArr2 = Bytes.xor(AesUtil.cmacPad(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.subKey2);
        }
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr3 = instance.doFinal(Bytes.xor(bArr3, 0, bArr, i * 16, 16));
        }
        byte[] xor = Bytes.xor(bArr2, bArr3);
        byte[] bArr4 = new byte[this.tagSizeInBytes];
        System.arraycopy(instance.doFinal(xor), 0, bArr4, 0, this.tagSizeInBytes);
        return bArr4;
    }

    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Bytes.equal(bArr, computeMac(bArr2))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    private void generateSubKeys() throws GeneralSecurityException {
        Cipher instance = instance();
        instance.init(1, this.keySpec);
        byte[] dbl = AesUtil.dbl(instance.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = AesUtil.dbl(dbl);
    }
}
