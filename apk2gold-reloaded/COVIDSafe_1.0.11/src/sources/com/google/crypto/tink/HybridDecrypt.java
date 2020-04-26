package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface HybridDecrypt {
    byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
