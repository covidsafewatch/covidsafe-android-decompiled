package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface DeterministicAead {
    byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;

    byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
