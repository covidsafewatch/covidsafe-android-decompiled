package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.proto.Ed25519PrivateKey;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.subtle.Ed25519Sign;
import com.google.crypto.tink.subtle.Ed25519Sign.KeyPair;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class Ed25519PrivateKeyManager implements PrivateKeyManager<PublicKeySign> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    public int getVersion() {
        return 0;
    }

    Ed25519PrivateKeyManager() {
    }

    public PublicKeySign getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) Ed25519PrivateKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("invalid Ed25519 private key", e);
        }
    }

    public PublicKeySign getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof Ed25519PrivateKey) {
            Ed25519PrivateKey ed25519PrivateKey = (Ed25519PrivateKey) messageLite;
            validate(ed25519PrivateKey);
            return new Ed25519Sign(ed25519PrivateKey.getKeyValue().toByteArray());
        }
        throw new GeneralSecurityException("expected Ed25519PrivateKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        return newKey();
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        return newKey();
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey").setValue(newKey().toByteString()).setKeyMaterialType(KeyMaterialType.ASYMMETRIC_PRIVATE).build();
    }

    public KeyData getPublicKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.Ed25519PublicKey").setValue(Ed25519PrivateKey.parseFrom(byteString).getPublicKey().toByteString()).setKeyMaterialType(KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized Ed25519PrivateKey proto", e);
        }
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey".equals(str);
    }

    private Ed25519PrivateKey newKey() throws GeneralSecurityException {
        KeyPair newKeyPair = KeyPair.newKeyPair();
        return (Ed25519PrivateKey) Ed25519PrivateKey.newBuilder().setVersion(0).setKeyValue(ByteString.copyFrom(newKeyPair.getPrivateKey())).setPublicKey((Ed25519PublicKey) Ed25519PublicKey.newBuilder().setVersion(0).setKeyValue(ByteString.copyFrom(newKeyPair.getPublicKey())).build()).build();
    }

    private void validate(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(ed25519PrivateKey.getVersion(), 0);
        if (ed25519PrivateKey.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 private key: incorrect key length");
        }
    }
}
