package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.AesGcmHkdfStreaming;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class AesGcmHkdfStreamingKeyManager implements KeyManager<StreamingAead> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }

    public int getVersion() {
        return 0;
    }

    AesGcmHkdfStreamingKeyManager() {
    }

    public StreamingAead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) AesGcmHkdfStreamingKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("expected AesGcmHkdfStreamingKey proto");
        }
    }

    public StreamingAead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesGcmHkdfStreamingKey) {
            AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey = (AesGcmHkdfStreamingKey) messageLite;
            validate(aesGcmHkdfStreamingKey);
            return new AesGcmHkdfStreaming(aesGcmHkdfStreamingKey.getKeyValue().toByteArray(), StreamingAeadUtil.toHmacAlgo(aesGcmHkdfStreamingKey.getParams().getHkdfHashType()), aesGcmHkdfStreamingKey.getParams().getDerivedKeySize(), aesGcmHkdfStreamingKey.getParams().getCiphertextSegmentSize(), 0);
        }
        throw new GeneralSecurityException("expected AesGcmHkdfStreamingKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) AesGcmHkdfStreamingKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesGcmHkdfStreamingKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesGcmHkdfStreamingKeyFormat) {
            AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat = (AesGcmHkdfStreamingKeyFormat) messageLite;
            validate(aesGcmHkdfStreamingKeyFormat);
            return AesGcmHkdfStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesGcmHkdfStreamingKeyFormat.getKeySize()))).setParams(aesGcmHkdfStreamingKeyFormat.getParams()).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected AesGcmHkdfStreamingKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey").setValue(((AesGcmHkdfStreamingKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey");
    }

    private void validate(AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey) throws GeneralSecurityException {
        Validators.validateVersion(aesGcmHkdfStreamingKey.getVersion(), 0);
        validate(aesGcmHkdfStreamingKey.getParams());
    }

    private void validate(AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat) throws GeneralSecurityException {
        if (aesGcmHkdfStreamingKeyFormat.getKeySize() >= 16) {
            validate(aesGcmHkdfStreamingKeyFormat.getParams());
            return;
        }
        throw new GeneralSecurityException("key_size must be at least 16 bytes");
    }

    private void validate(AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) throws GeneralSecurityException {
        Validators.validateAesKeySize(aesGcmHkdfStreamingParams.getDerivedKeySize());
        if (aesGcmHkdfStreamingParams.getHkdfHashType() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        } else if (aesGcmHkdfStreamingParams.getCiphertextSegmentSize() < aesGcmHkdfStreamingParams.getDerivedKeySize() + 8) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + 8)");
        }
    }
}
