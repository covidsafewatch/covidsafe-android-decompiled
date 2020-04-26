package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;

public interface EciesAeadHkdfDemHelper {
    Aead getAead(byte[] bArr) throws GeneralSecurityException;

    int getSymmetricKeySizeInBytes();
}
