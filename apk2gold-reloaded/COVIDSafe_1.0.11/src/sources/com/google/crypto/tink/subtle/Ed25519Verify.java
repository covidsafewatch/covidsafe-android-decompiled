package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import java.security.GeneralSecurityException;

public final class Ed25519Verify implements PublicKeyVerify {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final ImmutableByteArray publicKey;

    public Ed25519Verify(byte[] bArr) {
        if (bArr.length == 32) {
            this.publicKey = ImmutableByteArray.of(bArr);
        } else {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", new Object[]{Integer.valueOf(32)}));
        }
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            throw new GeneralSecurityException(String.format("The length of the signature is not %s.", new Object[]{Integer.valueOf(64)}));
        } else if (!Ed25519.verify(bArr2, bArr, this.publicKey.getBytes())) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}
