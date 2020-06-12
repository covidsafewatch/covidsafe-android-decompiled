package com.google.crypto.tink;

import java.security.GeneralSecurityException;

@Deprecated
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i) throws GeneralSecurityException;

    PrimitiveWrapper<P> getPrimitiveWrapper() throws GeneralSecurityException;
}
