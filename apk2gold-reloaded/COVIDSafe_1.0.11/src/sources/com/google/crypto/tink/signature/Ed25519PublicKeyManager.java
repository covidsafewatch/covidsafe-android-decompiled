package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class Ed25519PublicKeyManager implements KeyManager<PublicKeyVerify> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    }

    public int getVersion() {
        return 0;
    }

    Ed25519PublicKeyManager() {
    }

    public PublicKeyVerify getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) Ed25519PublicKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("invalid Ed25519 public key", e);
        }
    }

    public PublicKeyVerify getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof Ed25519PublicKey) {
            Ed25519PublicKey ed25519PublicKey = (Ed25519PublicKey) messageLite;
            validate(ed25519PublicKey);
            return new Ed25519Verify(ed25519PublicKey.getKeyValue().toByteArray());
        }
        throw new GeneralSecurityException("expected Ed25519PublicKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented");
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented");
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey".equals(str);
    }

    private void validate(Ed25519PublicKey ed25519PublicKey) throws GeneralSecurityException {
        Validators.validateVersion(ed25519PublicKey.getVersion(), 0);
        if (ed25519PublicKey.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 public key: incorrect key length");
        }
    }
}
