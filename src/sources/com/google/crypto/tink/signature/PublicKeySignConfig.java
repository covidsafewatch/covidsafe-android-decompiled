package com.google.crypto.tink.signature;

import com.google.crypto.tink.Config;
import java.security.GeneralSecurityException;

@Deprecated
public final class PublicKeySignConfig {
    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        Config.register(SignatureConfig.TINK_1_0_0);
    }
}
