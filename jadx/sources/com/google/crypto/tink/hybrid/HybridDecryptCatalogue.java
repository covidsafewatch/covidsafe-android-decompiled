package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Catalogue;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyManager;
import java.security.GeneralSecurityException;

class HybridDecryptCatalogue implements Catalogue<HybridDecrypt> {
    public KeyManager<HybridDecrypt> getKeyManager(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == 275448849 && lowerCase.equals("hybriddecrypt")) ? (char) 0 : 65535) == 0) {
            KeyManager<HybridDecrypt> hybridDecryptKeyManager = hybridDecryptKeyManager(str);
            if (hybridDecryptKeyManager.getVersion() >= i) {
                return hybridDecryptKeyManager;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    private KeyManager<HybridDecrypt> hybridDecryptKeyManager(String str) throws GeneralSecurityException {
        if (((str.hashCode() == -80133005 && str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) ? (char) 0 : 65535) == 0) {
            return new EciesAeadHkdfPrivateKeyManager();
        }
        throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
    }
}
