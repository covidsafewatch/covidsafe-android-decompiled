package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class HybridConfig {
    public static final String ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = new EciesAeadHkdfPrivateKeyManager().getKeyType();
    public static final String ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = new EciesAeadHkdfPublicKeyManager().getKeyType();
    @Deprecated
    public static final RegistryConfig LATEST = RegistryConfig.getDefaultInstance();
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.getDefaultInstance();
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    static {
        try {
            init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Deprecated
    public static void init() throws GeneralSecurityException {
        register();
    }

    public static void register() throws GeneralSecurityException {
        AeadConfig.register();
        EciesAeadHkdfPrivateKeyManager.registerPair(true);
        HybridDecryptWrapper.register();
        HybridEncryptWrapper.register();
    }
}
