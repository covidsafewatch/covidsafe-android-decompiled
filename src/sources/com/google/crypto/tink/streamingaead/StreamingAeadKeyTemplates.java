package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

@Deprecated
public final class StreamingAeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 4096);
    public static final KeyTemplate AES128_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(16, HashType.SHA256, 16, 4096);
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 4096);
    public static final KeyTemplate AES256_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(32, HashType.SHA256, 32, 1048576);
    public static final KeyTemplate AES256_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(32, HashType.SHA256, 32, 4096);

    public static KeyTemplate createAesCtrHmacStreamingKeyTemplate(int i, HashType hashType, int i2, HashType hashType2, int i3, int i4) {
        AesCtrHmacStreamingParams.Builder hkdfHashType = AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(i4).setDerivedKeySize(i2).setHkdfHashType(hashType);
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesCtrHmacStreamingKeyFormat) AesCtrHmacStreamingKeyFormat.newBuilder().setParams((AesCtrHmacStreamingParams) hkdfHashType.setHmacParams((HmacParams) HmacParams.newBuilder().setHash(hashType2).setTagSize(i3).build()).build()).setKeySize(i).build()).toByteString()).setTypeUrl(new AesCtrHmacStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    public static KeyTemplate createAesGcmHkdfStreamingKeyTemplate(int i, HashType hashType, int i2, int i3) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesGcmHkdfStreamingKeyFormat) AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(i).setParams((AesGcmHkdfStreamingParams) AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(i3).setDerivedKeySize(i2).setHkdfHashType(hashType).build()).build()).toByteString()).setTypeUrl(new AesGcmHkdfStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }
}
