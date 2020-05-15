package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;

public interface IndCpaCipher {
    byte[] decrypt(byte[] bArr) throws GeneralSecurityException;

    byte[] encrypt(byte[] bArr) throws GeneralSecurityException;
}
