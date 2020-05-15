package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Mac;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

public final class EncryptThenAuthenticate implements Aead {
    private final IndCpaCipher cipher;
    private final Mac mac;
    private final int macLength;

    public EncryptThenAuthenticate(IndCpaCipher indCpaCipher, Mac mac2, int i) {
        this.cipher = indCpaCipher;
        this.mac = mac2;
        this.macLength = i;
    }

    public static Aead newAesCtrHmac(byte[] bArr, int i, String str, byte[] bArr2, int i2) throws GeneralSecurityException {
        return new EncryptThenAuthenticate(new AesCtrJceCipher(bArr, i), new MacJce(str, new SecretKeySpec(bArr2, "HMAC"), i2), i2);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] encrypt = this.cipher.encrypt(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return Bytes.concat(encrypt, this.mac.computeMac(Bytes.concat(bArr2, encrypt, copyOf)));
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.macLength;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.macLength, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.mac.verifyMac(copyOfRange2, Bytes.concat(bArr2, copyOfRange, copyOf));
            return this.cipher.decrypt(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
