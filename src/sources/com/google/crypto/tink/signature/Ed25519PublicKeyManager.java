package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

class Ed25519PublicKeyManager extends KeyTypeManager<Ed25519PublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    }

    public int getVersion() {
        return 0;
    }

    public Ed25519PublicKeyManager() {
        super(Ed25519PublicKey.class, new KeyTypeManager.PrimitiveFactory<PublicKeyVerify, Ed25519PublicKey>(PublicKeyVerify.class) {
            public PublicKeyVerify getPrimitive(Ed25519PublicKey ed25519PublicKey) {
                return new Ed25519Verify(ed25519PublicKey.getKeyValue().toByteArray());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    public Ed25519PublicKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return Ed25519PublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(Ed25519PublicKey ed25519PublicKey) throws GeneralSecurityException {
        Validators.validateVersion(ed25519PublicKey.getVersion(), getVersion());
        if (ed25519PublicKey.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 public key: incorrect key length");
        }
    }
}
