package com.google.crypto.tink.signature;

import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class SignatureConfig {
    public static final String ECDSA_PRIVATE_KEY_TYPE_URL = new EcdsaSignKeyManager().getKeyType();
    public static final String ECDSA_PUBLIC_KEY_TYPE_URL = new EcdsaVerifyKeyManager().getKeyType();
    public static final String ED25519_PRIVATE_KEY_TYPE_URL = new Ed25519PrivateKeyManager().getKeyType();
    public static final String ED25519_PUBLIC_KEY_TYPE_URL = new Ed25519PublicKeyManager().getKeyType();
    public static final RegistryConfig LATEST = RegistryConfig.getDefaultInstance();
    public static final String RSA_PKCS1_PRIVATE_KEY_TYPE_URL = new RsaSsaPkcs1SignKeyManager().getKeyType();
    public static final String RSA_PKCS1_PUBLIC_KEY_TYPE_URL = new RsaSsaPkcs1VerifyKeyManager().getKeyType();
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
        EcdsaSignKeyManager.registerPair(true);
        Ed25519PrivateKeyManager.registerPair(true);
        RsaSsaPkcs1SignKeyManager.registerPair(true);
        RsaSsaPssSignKeyManager.registerPair(true);
        PublicKeySignWrapper.register();
        PublicKeyVerifyWrapper.register();
    }
}
