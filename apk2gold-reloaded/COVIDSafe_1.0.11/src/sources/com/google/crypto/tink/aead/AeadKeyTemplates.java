package com.google.crypto.tink.aead;

import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;

public final class AeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(16, 16, 32, 16, HashType.SHA256);
    public static final KeyTemplate AES128_EAX = createAesEaxKeyTemplate(16, 16);
    public static final KeyTemplate AES128_GCM = createAesGcmKeyTemplate(16);
    public static final KeyTemplate AES256_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(32, 16, 32, 32, HashType.SHA256);
    public static final KeyTemplate AES256_EAX = createAesEaxKeyTemplate(32, 16);
    public static final KeyTemplate AES256_GCM = createAesGcmKeyTemplate(32);
    public static final KeyTemplate CHACHA20_POLY1305 = ((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").setOutputPrefixType(OutputPrefixType.TINK).build());

    public static KeyTemplate createAesGcmKeyTemplate(int i) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesGcmKeyFormat) AesGcmKeyFormat.newBuilder().setKeySize(i).build()).toByteString()).setTypeUrl("type.googleapis.com/google.crypto.tink.AesGcmKey").setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesEaxKeyTemplate(int i, int i2) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesEaxKeyFormat) AesEaxKeyFormat.newBuilder().setKeySize(i).setParams((AesEaxParams) AesEaxParams.newBuilder().setIvSize(i2).build()).build()).toByteString()).setTypeUrl("type.googleapis.com/google.crypto.tink.AesEaxKey").setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesCtrHmacAeadKeyTemplate(int i, int i2, int i3, int i4, HashType hashType) {
        AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) AesCtrKeyFormat.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(i2).build()).setKeySize(i).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat(aesCtrKeyFormat).setHmacKeyFormat((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(i4).build()).setKeySize(i3).build()).build()).toByteString()).setTypeUrl("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createKmsAeadKeyTemplate(String str) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((KmsAeadKeyFormat) KmsAeadKeyFormat.newBuilder().setKeyUri(str).build()).toByteString()).setTypeUrl("type.googleapis.com/google.crypto.tink.KmsAeadKey").setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createKmsEnvelopeAeadKeyTemplate(String str, KeyTemplate keyTemplate) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((KmsEnvelopeAeadKeyFormat) KmsEnvelopeAeadKeyFormat.newBuilder().setDekTemplate(keyTemplate).setKekUri(str).build()).toByteString()).setTypeUrl("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").setOutputPrefixType(OutputPrefixType.TINK).build();
    }
}
