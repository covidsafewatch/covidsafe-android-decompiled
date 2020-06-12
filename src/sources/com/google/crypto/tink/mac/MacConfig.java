package com.google.crypto.tink.mac;

import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class MacConfig {
    public static final String HMAC_TYPE_URL = new HmacKeyManager().getKeyType();
    @Deprecated
    public static final RegistryConfig LATEST;
    @Deprecated
    public static final RegistryConfig TINK_1_0_0;
    @Deprecated
    public static final RegistryConfig TINK_1_1_0;

    static {
        RegistryConfig defaultInstance = RegistryConfig.getDefaultInstance();
        TINK_1_0_0 = defaultInstance;
        TINK_1_1_0 = defaultInstance;
        LATEST = defaultInstance;
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
        HmacKeyManager.register(true);
        AesCmacKeyManager.register(true);
        MacWrapper.register();
    }

    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        register();
    }
}
