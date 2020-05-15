package com.google.crypto.tink.signature;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class SignatureConfig {
    public static final String ECDSA_PRIVATE_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    public static final String ECDSA_PUBLIC_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    public static final String ED25519_PRIVATE_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    public static final String ED25519_PUBLIC_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    public static final RegistryConfig LATEST = ((RegistryConfig) RegistryConfig.newBuilder().setConfigName("TINK_SIGNATURE").addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_SIGN_CATALOGUE_NAME, "PublicKeySign", "EcdsaPrivateKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_SIGN_CATALOGUE_NAME, "PublicKeySign", "Ed25519PrivateKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_VERIFY_CATALOGUE_NAME, "PublicKeyVerify", "EcdsaPublicKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_VERIFY_CATALOGUE_NAME, "PublicKeyVerify", "Ed25519PublicKey", 0, true)).build());
    private static final String PUBLIC_KEY_SIGN_CATALOGUE_NAME = "TinkPublicKeySign";
    private static final String PUBLIC_KEY_VERIFY_CATALOGUE_NAME = "TinkPublicKeyVerify";
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = ((RegistryConfig) RegistryConfig.newBuilder().setConfigName("TINK_SIGNATURE_1_0_0").addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_SIGN_CATALOGUE_NAME, "PublicKeySign", "EcdsaPrivateKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_SIGN_CATALOGUE_NAME, "PublicKeySign", "Ed25519PrivateKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_VERIFY_CATALOGUE_NAME, "PublicKeyVerify", "EcdsaPublicKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(PUBLIC_KEY_VERIFY_CATALOGUE_NAME, "PublicKeyVerify", "Ed25519PublicKey", 0, true)).build());
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_SIGNATURE_1_1_0").build());

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
        Registry.addCatalogue(PUBLIC_KEY_SIGN_CATALOGUE_NAME, new PublicKeySignCatalogue());
        Registry.addCatalogue(PUBLIC_KEY_VERIFY_CATALOGUE_NAME, new PublicKeyVerifyCatalogue());
        Config.register(LATEST);
    }
}
