package com.google.crypto.tink.prf;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
public interface Prf {
    byte[] compute(byte[] bArr, int i) throws GeneralSecurityException;
}
