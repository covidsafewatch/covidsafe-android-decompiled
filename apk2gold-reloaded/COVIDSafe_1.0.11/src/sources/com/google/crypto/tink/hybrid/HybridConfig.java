package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import com.google.crypto.tink.proto.RegistryConfig.Builder;
import java.security.GeneralSecurityException;

public final class HybridConfig {
    public static final String ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    public static final String ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final String HYBRID_DECRYPT_CATALOGUE_NAME = "TinkHybridDecrypt";
    private static final String HYBRID_ENCRYPT_CATALOGUE_NAME = "TinkHybridEncrypt";
    public static final RegistryConfig LATEST;
    @Deprecated
    public static final RegistryConfig TINK_1_0_0;
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_HYBRID_1_1_0").build());

    static {
        Builder builder = (Builder) RegistryConfig.newBuilder().mergeFrom(AeadConfig.TINK_1_0_0);
        String str = "EciesAeadHkdfPrivateKey";
        String str2 = "HybridDecrypt";
        String str3 = HYBRID_DECRYPT_CATALOGUE_NAME;
        Builder addEntry = builder.addEntry(Config.getTinkKeyTypeEntry(str3, str2, str, 0, true));
        String str4 = "EciesAeadHkdfPublicKey";
        String str5 = "HybridEncrypt";
        String str6 = HYBRID_ENCRYPT_CATALOGUE_NAME;
        TINK_1_0_0 = (RegistryConfig) addEntry.addEntry(Config.getTinkKeyTypeEntry(str6, str5, str4, 0, true)).setConfigName("TINK_HYBRID_1_0_0").build();
        LATEST = (RegistryConfig) ((Builder) RegistryConfig.newBuilder().mergeFrom(AeadConfig.LATEST)).addEntry(Config.getTinkKeyTypeEntry(str3, str2, str, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str6, str5, str4, 0, true)).setConfigName("TINK_HYBRID").build();
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
