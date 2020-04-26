package com.google.crypto.tink.mac;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import com.google.crypto.tink.proto.RegistryConfig.Builder;
import java.security.GeneralSecurityException;

public final class MacConfig {
    private static final String CATALOGUE_NAME = "TinkMac";
    public static final String HMAC_TYPE_URL = "type.googleapis.com/google.crypto.tink.HmacKey";
    public static final RegistryConfig LATEST = ((RegistryConfig) ((Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_MAC").build());
    private static final String PRIMITIVE_NAME = "Mac";
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = ((RegistryConfig) RegistryConfig.newBuilder().setConfigName("TINK_MAC_1_0_0").addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "HmacKey", 0, true)).build());
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_MAC_1_1_0").build());

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
        Registry.addCatalogue(CATALOGUE_NAME, new MacCatalogue());
        Config.register(LATEST);
    }

    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        register();
    }
}
