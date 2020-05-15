package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface Mac {
    byte[] computeMac(byte[] bArr) throws GeneralSecurityException;

    void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
