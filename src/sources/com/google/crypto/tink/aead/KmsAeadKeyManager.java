package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class KmsAeadKeyManager extends KeyTypeManager<KmsAeadKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public int getVersion() {
        return 0;
    }

    KmsAeadKeyManager() {
        super(KmsAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, KmsAeadKey>(Aead.class) {
            public Aead getPrimitive(KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
                String keyUri = kmsAeadKey.getParams().getKeyUri();
                return KmsClients.get(keyUri).getAead(keyUri);
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    public void validateKey(KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(kmsAeadKey.getVersion(), getVersion());
    }

    public KmsAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return KmsAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<KmsAeadKeyFormat, KmsAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsAeadKeyFormat, KmsAeadKey>(KmsAeadKeyFormat.class) {
            public void validateKeyFormat(KmsAeadKeyFormat kmsAeadKeyFormat) throws GeneralSecurityException {
            }

            public KmsAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return KmsAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public KmsAeadKey createKey(KmsAeadKeyFormat kmsAeadKeyFormat) throws GeneralSecurityException {
                return (KmsAeadKey) KmsAeadKey.newBuilder().setParams(kmsAeadKeyFormat).setVersion(KmsAeadKeyManager.this.getVersion()).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new KmsAeadKeyManager(), z);
    }
}
