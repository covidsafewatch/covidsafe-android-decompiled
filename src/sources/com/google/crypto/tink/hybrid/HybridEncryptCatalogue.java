package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Catalogue;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeyManager;
import java.security.GeneralSecurityException;

class HybridEncryptCatalogue implements Catalogue<HybridEncrypt> {
    public KeyManager<HybridEncrypt> getKeyManager(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == 1420614889 && lowerCase.equals("hybridencrypt")) ? (char) 0 : 65535) == 0) {
            KeyManager<HybridEncrypt> hybridEncryptKeyManager = hybridEncryptKeyManager(str);
            if (hybridEncryptKeyManager.getVersion() >= i) {
                return hybridEncryptKeyManager;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    private KeyManager<HybridEncrypt> hybridEncryptKeyManager(String str) throws GeneralSecurityException {
        if (((str.hashCode() == 396454335 && str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) ? (char) 0 : 65535) == 0) {
            return new EciesAeadHkdfPublicKeyManager();
        }
        throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
    }
}
