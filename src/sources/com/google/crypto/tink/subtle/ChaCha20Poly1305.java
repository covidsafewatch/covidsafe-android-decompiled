package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public final class ChaCha20Poly1305 extends SnufflePoly1305 {
    public /* bridge */ /* synthetic */ byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.decrypt(bArr, bArr2);
    }

    public /* bridge */ /* synthetic */ byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.encrypt(bArr, bArr2);
    }

    public ChaCha20Poly1305(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public Snuffle createSnuffleInstance(byte[] bArr, int i) throws InvalidKeyException {
        return new ChaCha20(bArr, i);
    }
}
