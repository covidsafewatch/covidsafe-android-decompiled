package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PrivateKeyTypeManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.Ed25519KeyFormat;
import com.google.crypto.tink.proto.Ed25519PrivateKey;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Ed25519Sign;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class Ed25519PrivateKeyManager extends PrivateKeyTypeManager<Ed25519PrivateKey, Ed25519PublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    public int getVersion() {
        return 0;
    }

    Ed25519PrivateKeyManager() {
        super(Ed25519PrivateKey.class, Ed25519PublicKey.class, new KeyTypeManager.PrimitiveFactory<PublicKeySign, Ed25519PrivateKey>(PublicKeySign.class) {
            public PublicKeySign getPrimitive(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
                return new Ed25519Sign(ed25519PrivateKey.getKeyValue().toByteArray());
            }
        });
    }

    public Ed25519PublicKey getPublicKey(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        return ed25519PrivateKey.getPublicKey();
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    public Ed25519PrivateKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return Ed25519PrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(ed25519PrivateKey.getVersion(), getVersion());
        new Ed25519PublicKeyManager().validateKey(ed25519PrivateKey.getPublicKey());
        if (ed25519PrivateKey.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 private key: incorrect key length");
        }
    }

    public KeyTypeManager.KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey>(Ed25519KeyFormat.class) {
            public void validateKeyFormat(Ed25519KeyFormat ed25519KeyFormat) throws GeneralSecurityException {
            }

            public Ed25519KeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return Ed25519KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public Ed25519PrivateKey createKey(Ed25519KeyFormat ed25519KeyFormat) throws GeneralSecurityException {
                Ed25519Sign.KeyPair newKeyPair = Ed25519Sign.KeyPair.newKeyPair();
                return (Ed25519PrivateKey) Ed25519PrivateKey.newBuilder().setVersion(Ed25519PrivateKeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(newKeyPair.getPrivateKey())).setPublicKey((Ed25519PublicKey) Ed25519PublicKey.newBuilder().setVersion(Ed25519PrivateKeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(newKeyPair.getPublicKey())).build()).build();
            }
        };
    }

    public static void registerPair(boolean z) throws GeneralSecurityException {
        Registry.registerAsymmetricKeyManagers(new Ed25519PrivateKeyManager(), new Ed25519PublicKeyManager(), z);
    }

    public static final KeyTemplate ed25519Template() {
        return KeyTemplate.create(new Ed25519PrivateKeyManager().getKeyType(), new byte[0], KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawEd25519Template() {
        return KeyTemplate.create(new Ed25519PrivateKeyManager().getKeyType(), new byte[0], KeyTemplate.OutputPrefixType.RAW);
    }
}
