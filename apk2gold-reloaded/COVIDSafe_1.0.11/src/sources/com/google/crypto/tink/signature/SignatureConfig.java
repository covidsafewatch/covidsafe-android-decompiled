package com.google.crypto.tink.signature;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import com.google.crypto.tink.proto.RegistryConfig.Builder;
import java.security.GeneralSecurityException;

public final class SignatureConfig {
    public static final String ECDSA_PRIVATE_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    public static final String ECDSA_PUBLIC_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    public static final String ED25519_PRIVATE_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    public static final String ED25519_PUBLIC_KEY_TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    public static final RegistryConfig LATEST;
    private static final String PUBLIC_KEY_SIGN_CATALOGUE_NAME = "TinkPublicKeySign";
    private static final String PUBLIC_KEY_VERIFY_CATALOGUE_NAME = "TinkPublicKeyVerify";
    @Deprecated
    public static final RegistryConfig TINK_1_0_0;
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_SIGNATURE_1_1_0").build());

    static {
        Builder configName = RegistryConfig.newBuilder().setConfigName("TINK_SIGNATURE_1_0_0");
        String str = "EcdsaPrivateKey";
        String str2 = "PublicKeySign";
        String str3 = PUBLIC_KEY_SIGN_CATALOGUE_NAME;
        String str4 = "Ed25519PrivateKey";
        Builder addEntry = configName.addEntry(Config.getTinkKeyTypeEntry(str3, str2, str, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str3, str2, str4, 0, true));
        String str5 = "EcdsaPublicKey";
        String str6 = "PublicKeyVerify";
        String str7 = PUBLIC_KEY_VERIFY_CATALOGUE_NAME;
        String str8 = "Ed25519PublicKey";
        TINK_1_0_0 = (RegistryConfig) addEntry.addEntry(Config.getTinkKeyTypeEntry(str7, str6, str5, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str7, str6, str8, 0, true)).build();
        LATEST = (RegistryConfig) RegistryConfig.newBuilder().setConfigName("TINK_SIGNATURE").addEntry(Config.getTinkKeyTypeEntry(str3, str2, str, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str3, str2, str4, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str7, str6, str5, 0, true)).addEntry(Config.getTinkKeyTypeEntry(str7, str6, str8, 0, true)).build();
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
