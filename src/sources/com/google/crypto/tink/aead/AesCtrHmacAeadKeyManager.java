package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

class AesCtrHmacAeadKeyManager implements KeyManager<Aead> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    private static final int VERSION = 0;
    private static final Logger logger = Logger.getLogger(AesCtrHmacAeadKeyManager.class.getName());

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public int getVersion() {
        return 0;
    }

    AesCtrHmacAeadKeyManager() throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCtrKeyManager());
    }

    public Aead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) AesCtrHmacAeadKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    public Aead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesCtrHmacAeadKey) {
            AesCtrHmacAeadKey aesCtrHmacAeadKey = (AesCtrHmacAeadKey) messageLite;
            validate(aesCtrHmacAeadKey);
            return new EncryptThenAuthenticate((IndCpaCipher) Registry.getPrimitive("type.googleapis.com/google.crypto.tink.AesCtrKey", (MessageLite) aesCtrHmacAeadKey.getAesCtrKey()), (Mac) Registry.getPrimitive("type.googleapis.com/google.crypto.tink.HmacKey", (MessageLite) aesCtrHmacAeadKey.getHmacKey()), aesCtrHmacAeadKey.getHmacKey().getParams().getTagSize());
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) AesCtrHmacAeadKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesCtrHmacAeadKeyFormat) {
            AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = (AesCtrHmacAeadKeyFormat) messageLite;
            return AesCtrHmacAeadKey.newBuilder().setAesCtrKey((AesCtrKey) Registry.newKey("type.googleapis.com/google.crypto.tink.AesCtrKey", aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat())).setHmacKey((HmacKey) Registry.newKey("type.googleapis.com/google.crypto.tink.HmacKey", aesCtrHmacAeadKeyFormat.getHmacKeyFormat())).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").setValue(((AesCtrHmacAeadKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
    }

    private void validate(AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
        Validators.validateAesKeySize(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat().getKeySize());
    }

    private void validate(AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrHmacAeadKey.getVersion(), 0);
    }
}
