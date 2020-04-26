package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i) throws GeneralSecurityException;
}
