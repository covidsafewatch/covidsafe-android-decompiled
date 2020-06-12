package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() {
        /* access modifiers changed from: protected */
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance(AesCtrJceCipher.CIPHER_ALGORITHM);
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private final int blockSize;
    private final int ivSize;
    private final SecretKeySpec keySpec;

    public AesCtrJceCipher(byte[] bArr, int i) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
        int blockSize2 = localCipher.get().getBlockSize();
        this.blockSize = blockSize2;
        if (i < 12 || i > blockSize2) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.ivSize = i;
    }

    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.ivSize;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] randBytes = Random.randBytes(i);
            System.arraycopy(randBytes, 0, bArr2, 0, this.ivSize);
            doCtr(bArr, 0, bArr.length, bArr2, this.ivSize, randBytes, true);
            return bArr2;
        }
        throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.ivSize));
    }

    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.ivSize;
        if (length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int length2 = bArr.length;
            int i2 = this.ivSize;
            byte[] bArr3 = new byte[(length2 - i2)];
            doCtr(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private void doCtr(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = localCipher.get();
        byte[] bArr4 = new byte[this.blockSize];
        System.arraycopy(bArr3, 0, bArr4, 0, this.ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z) {
            cipher.init(1, this.keySpec, ivParameterSpec);
        } else {
            cipher.init(2, this.keySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) != i2) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
