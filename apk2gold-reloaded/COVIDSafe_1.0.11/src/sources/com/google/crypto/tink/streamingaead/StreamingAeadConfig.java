package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import com.google.crypto.tink.proto.RegistryConfig.Builder;
import java.security.GeneralSecurityException;

public final class StreamingAeadConfig {
    public static final String AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    public static final String AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    private static final String CATALOGUE_NAME = "TinkStreamingAead";
    public static final RegistryConfig LATEST;
    private static final String PRIMITIVE_NAME = "StreamingAead";
    @Deprecated
    public static final RegistryConfig TINK_1_1_0;

    static {
        Builder newBuilder = RegistryConfig.newBuilder();
        String str = "AesCtrHmacStreamingKey";
        String str2 = PRIMITIVE_NAME;
        String str3 = CATALOGUE_NAME;
        String str4 = "AesGcmHkdfStreamingKey";
        TINK_1_1_0 = (RegistryConfig) newBuilder.addEntry(Config.getTinkKeyTypeEntry(str3, str2, str, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str3, str2, str4, 0, true)).setConfigName("TINK_STREAMINGAEAD_1_1_0").build();
        LATEST = (RegistryConfig) RegistryConfig.newBuilder().addEntry(Config.getTinkKeyTypeEntry(str3, str2, str, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str3, str2, str4, 0, true)).setConfigName("TINK_STREAMINGAEAD").build();
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
