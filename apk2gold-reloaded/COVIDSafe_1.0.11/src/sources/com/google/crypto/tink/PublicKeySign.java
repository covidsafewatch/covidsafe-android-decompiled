package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface PublicKeySign {
    byte[] sign(byte[] bArr) throws GeneralSecurityException;
}
