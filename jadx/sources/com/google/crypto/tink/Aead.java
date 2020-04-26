package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface Aead {
    byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;

    byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
