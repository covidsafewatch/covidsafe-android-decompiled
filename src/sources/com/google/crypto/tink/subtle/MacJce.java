package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Immutable
public final class MacJce implements Mac {
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private final String algorithm;
    private final int digestSize;
    private final Key key;
    private final javax.crypto.Mac mac;

    public MacJce(String str, Key key2, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        } else if (key2.getEncoded().length >= 16) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
                    } else if (i > 64) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                } else if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
            } else if (i > 20) {
                throw new InvalidAlgorithmParameterException("tag size too big");
            }
            this.algorithm = str;
            this.digestSize = i;
            this.key = key2;
            javax.crypto.Mac instance = EngineFactory.MAC.getInstance(str);
            this.mac = instance;
            instance.init(key2);
        } else {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
    }

    public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
        javax.crypto.Mac mac2;
        try {
            mac2 = (javax.crypto.Mac) this.mac.clone();
        } catch (CloneNotSupportedException unused) {
            mac2 = EngineFactory.MAC.getInstance(this.algorithm);
            mac2.init(this.key);
        }
        mac2.update(bArr);
        byte[] bArr2 = new byte[this.digestSize];
        System.arraycopy(mac2.doFinal(), 0, bArr2, 0, this.digestSize);
        return bArr2;
    }

    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
