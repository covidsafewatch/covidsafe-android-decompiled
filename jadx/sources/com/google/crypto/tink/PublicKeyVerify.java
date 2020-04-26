package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface PublicKeyVerify {
    void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
