package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class HybridConfig {
    public static final String ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    public static final String ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final String HYBRID_DECRYPT_CATALOGUE_NAME = "TinkHybridDecrypt";
    private static final String HYBRID_ENCRYPT_CATALOGUE_NAME = "TinkHybridEncrypt";
    public static final RegistryConfig LATEST = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(AeadConfig.LATEST)).addEntry(Config.getTinkKeyTypeEntry(HYBRID_DECRYPT_CATALOGUE_NAME, "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(HYBRID_ENCRYPT_CATALOGUE_NAME, "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).setConfigName("TINK_HYBRID").build());
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(AeadConfig.TINK_1_0_0)).addEntry(Config.getTinkKeyTypeEntry(HYBRID_DECRYPT_CATALOGUE_NAME, "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(HYBRID_ENCRYPT_CATALOGUE_NAME, "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).setConfigName("TINK_HYBRID_1_0_0").build());
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_HYBRID_1_1_0").build());

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
        Registry.addCatalogue(HYBRID_ENCRYPT_CATALOGUE_NAME, new HybridEncryptCatalogue());
        Registry.addCatalogue(HYBRID_DECRYPT_CATALOGUE_NAME, new HybridDecryptCatalogue());
        Config.register(LATEST);
    }
}
