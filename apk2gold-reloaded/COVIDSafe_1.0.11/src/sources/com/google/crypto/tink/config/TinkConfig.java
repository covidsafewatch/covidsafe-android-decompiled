package com.google.crypto.tink.config;

import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.hybrid.HybridConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import com.google.crypto.tink.proto.RegistryConfig.Builder;
import com.google.crypto.tink.signature.SignatureConfig;
import com.google.crypto.tink.streamingaead.StreamingAeadConfig;
import java.security.GeneralSecurityException;

public final class TinkConfig {
    public static final RegistryConfig LATEST = ((RegistryConfig) ((Builder) ((Builder) ((Builder) ((Builder) RegistryConfig.newBuilder().mergeFrom(HybridConfig.LATEST)).mergeFrom(SignatureConfig.LATEST)).mergeFrom(DeterministicAeadConfig.LATEST)).mergeFrom(StreamingAeadConfig.LATEST)).setConfigName("TINK").build());
    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = ((RegistryConfig) ((Builder) ((Builder) RegistryConfig.newBuilder().mergeFrom(HybridConfig.TINK_1_0_0)).mergeFrom(SignatureConfig.TINK_1_0_0)).setConfigName("TINK_1_0_0").build());
    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = ((RegistryConfig) ((Builder) ((Builder) ((Builder) ((Builder) RegistryConfig.newBuilder().mergeFrom(HybridConfig.TINK_1_1_0)).mergeFrom(SignatureConfig.TINK_1_1_0)).mergeFrom(DeterministicAeadConfig.TINK_1_1_0)).mergeFrom(StreamingAeadConfig.TINK_1_1_0)).setConfigName("TINK_1_1_0").build());

    @Deprecated
    public static void init() throws GeneralSecurityException {
        register();
    }

    public static void register() throws GeneralSecurityException {
        DeterministicAeadConfig.register();
        HybridConfig.register();
        SignatureConfig.register();
    }
}
