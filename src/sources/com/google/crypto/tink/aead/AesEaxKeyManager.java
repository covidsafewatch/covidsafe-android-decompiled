package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class AesEaxKeyManager implements KeyManager<Aead> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesEaxKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public int getVersion() {
        return 0;
    }

    AesEaxKeyManager() {
    }

    public Aead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) AesEaxKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e);
        }
    }

    public Aead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesEaxKey) {
            AesEaxKey aesEaxKey = (AesEaxKey) messageLite;
            validate(aesEaxKey);
            return new AesEaxJce(aesEaxKey.getKeyValue().toByteArray(), aesEaxKey.getParams().getIvSize());
        }
        throw new GeneralSecurityException("expected AesEaxKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) AesEaxKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesEaxKeyFormat) {
            AesEaxKeyFormat aesEaxKeyFormat = (AesEaxKeyFormat) messageLite;
            validate(aesEaxKeyFormat);
            return AesEaxKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesEaxKeyFormat.getKeySize()))).setParams(aesEaxKeyFormat.getParams()).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.AesEaxKey").setValue(((AesEaxKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey");
    }

    private void validate(AesEaxKey aesEaxKey) throws GeneralSecurityException {
        Validators.validateVersion(aesEaxKey.getVersion(), 0);
        Validators.validateAesKeySize(aesEaxKey.getKeyValue().size());
        if (aesEaxKey.getParams().getIvSize() != 12 && aesEaxKey.getParams().getIvSize() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    private void validate(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
        Validators.validateAesKeySize(aesEaxKeyFormat.getKeySize());
        if (aesEaxKeyFormat.getParams().getIvSize() != 12 && aesEaxKeyFormat.getParams().getIvSize() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
