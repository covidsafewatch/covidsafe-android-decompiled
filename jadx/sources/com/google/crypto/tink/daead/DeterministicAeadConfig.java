package com.google.crypto.tink.daead;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class DeterministicAeadConfig {
    public static final String AES_SIV_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesSivKey";
    private static final String CATALOGUE_NAME = "TinkDeterministicAead";
    public static final RegistryConfig LATEST = ((RegistryConfig) RegistryConfig.newBuilder().addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesSivKey", 0, true)).setConfigName("TINK_DETERMINISTIC_AEAD").build());
    private static final String PRIMITIVE_NAME = "DeterministicAead";
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) RegistryConfig.newBuilder().addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesSivKey", 0, true)).setConfigName("TINK_DETERMINISTIC_AEAD_1_1_0").build());

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
        Registry.addCatalogue(CATALOGUE_NAME, new DeterministicAeadCatalogue());
        Config.register(LATEST);
    }
}
