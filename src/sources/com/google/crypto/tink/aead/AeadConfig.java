package com.google.crypto.tink.aead;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class AeadConfig {
    public static final String AES_CTR_HMAC_AEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String AES_EAX_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesEaxKey";
    public static final String AES_GCM_TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    private static final String CATALOGUE_NAME = "TinkAead";
    public static final String CHACHA20_POLY1305_TYPE_URL = "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    public static final String KMS_AEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    public static final String KMS_ENVELOPE_AEAD_TYPE_URL = "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    public static final RegistryConfig LATEST = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(MacConfig.LATEST)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesCtrHmacAeadKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesEaxKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesGcmKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "ChaCha20Poly1305Key", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "KmsAeadKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "KmsEnvelopeAeadKey", 0, true)).setConfigName("TINK_AEAD").build());
    private static final String PRIMITIVE_NAME = "Aead";
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(MacConfig.TINK_1_0_0)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesCtrHmacAeadKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesEaxKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "AesGcmKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "ChaCha20Poly1305Key", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "KmsAeadKey", 0, true)).addEntry(Config.getTinkKeyTypeEntry(CATALOGUE_NAME, PRIMITIVE_NAME, "KmsEnvelopeAeadKey", 0, true)).setConfigName("TINK_AEAD_1_0_0").build());
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((RegistryConfig.Builder) RegistryConfig.newBuilder().mergeFrom(TINK_1_0_0)).setConfigName("TINK_AEAD_1_1_0").build());

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
        MacConfig.register();
        Registry.addCatalogue(CATALOGUE_NAME, new AeadCatalogue());
        Config.register(LATEST);
    }

    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        register();
    }
}
