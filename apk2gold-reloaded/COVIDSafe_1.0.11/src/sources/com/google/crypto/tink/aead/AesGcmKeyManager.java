package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class AesGcmKeyManager implements KeyManager<Aead> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public int getVersion() {
        return 0;
    }

    AesGcmKeyManager() {
    }

    public Aead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) AesGcmKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
    }

    public Aead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesGcmKey) {
            AesGcmKey aesGcmKey = (AesGcmKey) messageLite;
            validate(aesGcmKey);
            return new AesGcmJce(aesGcmKey.getKeyValue().toByteArray());
        }
        throw new GeneralSecurityException("expected AesGcmKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) AesGcmKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesGcmKeyFormat) {
            AesGcmKeyFormat aesGcmKeyFormat = (AesGcmKeyFormat) messageLite;
            validate(aesGcmKeyFormat);
            return AesGcmKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesGcmKeyFormat.getKeySize()))).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.AesGcmKey").setValue(((AesGcmKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey");
    }

    private void validate(AesGcmKey aesGcmKey) throws GeneralSecurityException {
        Validators.validateVersion(aesGcmKey.getVersion(), 0);
        Validators.validateAesKeySize(aesGcmKey.getKeyValue().size());
    }

    private void validate(AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
        Validators.validateAesKeySize(aesGcmKeyFormat.getKeySize());
    }
}
