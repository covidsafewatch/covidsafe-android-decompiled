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

@Deprecated
public final class AeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(16, 16, 32, 16, HashType.SHA256);
    public static final KeyTemplate AES128_EAX = createAesEaxKeyTemplate(16, 16);
    public static final KeyTemplate AES128_GCM = createAesGcmKeyTemplate(16);
    public static final KeyTemplate AES256_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(32, 16, 32, 32, HashType.SHA256);
    public static final KeyTemplate AES256_EAX = createAesEaxKeyTemplate(32, 16);
    public static final KeyTemplate AES256_GCM = createAesGcmKeyTemplate(32);
    public static final KeyTemplate CHACHA20_POLY1305 = ((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(new ChaCha20Poly1305KeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build());
    public static final KeyTemplate XCHACHA20_POLY1305 = ((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(new XChaCha20Poly1305KeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build());

    public static KeyTemplate createAesGcmKeyTemplate(int i) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesGcmKeyFormat) AesGcmKeyFormat.newBuilder().setKeySize(i).build()).toByteString()).setTypeUrl(new AesGcmKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesEaxKeyTemplate(int i, int i2) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesEaxKeyFormat) AesEaxKeyFormat.newBuilder().setKeySize(i).setParams((AesEaxParams) AesEaxParams.newBuilder().setIvSize(i2).build()).build()).toByteString()).setTypeUrl(new AesEaxKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesCtrHmacAeadKeyTemplate(int i, int i2, int i3, int i4, HashType hashType) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat((AesCtrKeyFormat) AesCtrKeyFormat.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(i2).build()).setKeySize(i).build()).setHmacKeyFormat((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(i4).build()).setKeySize(i3).build()).build()).toByteString()).setTypeUrl(new AesCtrHmacAeadKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createKmsAeadKeyTemplate(String str) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((KmsAeadKeyFormat) KmsAeadKeyFormat.newBuilder().setKeyUri(str).build()).toByteString()).setTypeUrl(new KmsAeadKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createKmsEnvelopeAeadKeyTemplate(String str, KeyTemplate keyTemplate) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((KmsEnvelopeAeadKeyFormat) KmsEnvelopeAeadKeyFormat.newBuilder().setDekTemplate(keyTemplate).setKekUri(str).build()).toByteString()).setTypeUrl(new KmsEnvelopeAeadKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }
}
