package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class StreamingAeadConfig {
    public static final String AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    public static final String AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    private static final String CATALOGUE_NAME = "TinkStreamingAead";
    public static final RegistryConfig LATEST = ((RegistryConfig) RegistryConfig.newBuilder().addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesCtrHmacStreamingKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesGcmHkdfStreamingKey", 0, true)).setConfigName("TINK_STREAMINGAEAD").build());
    private static final String PRIMITIVE_NAME = "StreamingAead";
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) RegistryConfig.newBuilder().addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesCtrHmacStreamingKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesGcmHkdfStreamingKey", 0, true)).setConfigName("TINK_STREAMINGAEAD_1_1_0").build());

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
        Registry.addCatalogue(CATALOGUE_NAME, new StreamingAeadCatalogue());
        Config.register(LATEST);
    }
}
