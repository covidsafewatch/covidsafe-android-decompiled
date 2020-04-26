package com.google.crypto.tink.aead;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.subtle.AesCtrJceCipher;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class AesCtrKeyManager implements KeyManager<IndCpaCipher> {
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return TYPE_URL;
    }

    public int getVersion() {
        return 0;
    }

    AesCtrKeyManager() {
    }

    public AesCtrJceCipher getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) AesCtrKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e);
        }
    }

    public AesCtrJceCipher getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesCtrKey) {
            AesCtrKey aesCtrKey = (AesCtrKey) messageLite;
            validate(aesCtrKey);
            return new AesCtrJceCipher(aesCtrKey.getKeyValue().toByteArray(), aesCtrKey.getParams().getIvSize());
        }
        throw new GeneralSecurityException("expected AesCtrKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) AesCtrKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesCtrKeyFormat) {
            AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) messageLite;
            validate(aesCtrKeyFormat);
            return AesCtrKey.newBuilder().setParams(aesCtrKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(aesCtrKeyFormat.getKeySize()))).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl(TYPE_URL).setValue(((AesCtrKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals(TYPE_URL);
    }

    private void validate(AesCtrKey aesCtrKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrKey.getVersion(), 0);
        Validators.validateAesKeySize(aesCtrKey.getKeyValue().size());
        validate(aesCtrKey.getParams());
    }

    private void validate(AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
        Validators.validateAesKeySize(aesCtrKeyFormat.getKeySize());
        validate(aesCtrKeyFormat.getParams());
    }

    private void validate(AesCtrParams aesCtrParams) throws GeneralSecurityException {
        if (aesCtrParams.getIvSize() < 12 || aesCtrParams.getIvSize() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
