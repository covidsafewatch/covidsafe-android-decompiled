package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;

public final class PrfConfig {
    public static final String PRF_TYPE_URL = new HkdfPrfKeyManager().getKeyType();

    public static void register() throws GeneralSecurityException {
        HkdfPrfKeyManager.register(true);
        PrfSetWrapper.register();
    }

    private PrfConfig() {
    }
}
