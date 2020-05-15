package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class KmsAeadKeyManager implements KeyManager<Aead> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public int getVersion() {
        return 0;
    }

    KmsAeadKeyManager() {
    }

    public Aead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) KmsAeadKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    public Aead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof KmsAeadKey) {
            KmsAeadKey kmsAeadKey = (KmsAeadKey) messageLite;
            validate(kmsAeadKey);
            String keyUri = kmsAeadKey.getParams().getKeyUri();
            return KmsClients.get(keyUri).getAead(keyUri);
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) KmsAeadKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof KmsAeadKeyFormat) {
            return KmsAeadKey.newBuilder().setParams((KmsAeadKeyFormat) messageLite).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.KmsAeadKey").setValue(((KmsAeadKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.REMOTE).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey");
    }

    private static void validate(KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(kmsAeadKey.getVersion(), 0);
    }
}
