package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Hkdf {
    public static byte[] computeHkdf(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws GeneralSecurityException {
        Mac instance = EngineFactory.MAC.getInstance(str);
        if (i <= instance.getMacLength() * 255) {
            if (bArr2 == null || bArr2.length == 0) {
                instance.init(new SecretKeySpec(new byte[instance.getMacLength()], str));
            } else {
                instance.init(new SecretKeySpec(bArr2, str));
            }
            byte[] bArr4 = new byte[i];
            instance.init(new SecretKeySpec(instance.doFinal(bArr), str));
            byte[] bArr5 = new byte[0];
            int i2 = 1;
            int i3 = 0;
            while (true) {
                instance.update(bArr5);
                instance.update(bArr3);
                instance.update((byte) i2);
                bArr5 = instance.doFinal();
                if (bArr5.length + i3 < i) {
                    System.arraycopy(bArr5, 0, bArr4, i3, bArr5.length);
                    i3 += bArr5.length;
                    i2++;
                } else {
                    System.arraycopy(bArr5, 0, bArr4, i3, i - i3);
                    return bArr4;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }

    public static byte[] computeEciesHkdfSymmetricKey(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, byte[] bArr4, int i) throws GeneralSecurityException {
        return computeHkdf(str, Bytes.concat(bArr, bArr2), bArr3, bArr4, i);
    }
}
