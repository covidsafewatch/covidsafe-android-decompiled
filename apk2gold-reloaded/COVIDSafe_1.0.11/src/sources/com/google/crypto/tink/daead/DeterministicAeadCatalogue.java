package com.google.crypto.tink.daead;

import com.google.crypto.tink.Catalogue;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyManager;
import java.security.GeneralSecurityException;

class DeterministicAeadCatalogue implements Catalogue<DeterministicAead> {
    public KeyManager<DeterministicAead> getKeyManager(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == 109397593 && lowerCase.equals("deterministicaead")) ? (char) 0 : 65535) == 0) {
            KeyManager<DeterministicAead> daeadKeyManager = daeadKeyManager(str);
            if (daeadKeyManager.getVersion() >= i) {
                return daeadKeyManager;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    private KeyManager<DeterministicAead> daeadKeyManager(String str) throws GeneralSecurityException {
        if (((str.hashCode() == -2089717248 && str.equals("type.googleapis.com/google.crypto.tink.AesSivKey")) ? (char) 0 : 65535) == 0) {
            return new AesSivKeyManager();
        }
        throw new GeneralSecurityException(String.format("No support for primitive 'DeterministicAead' with key type '%s'.", new Object[]{str}));
    }
}
