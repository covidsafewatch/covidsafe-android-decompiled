package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface HybridEncrypt {
    byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
