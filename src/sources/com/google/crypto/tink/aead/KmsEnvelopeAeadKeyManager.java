package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class KmsEnvelopeAeadKeyManager extends KeyTypeManager<KmsEnvelopeAeadKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public int getVersion() {
        return 0;
    }

    KmsEnvelopeAeadKeyManager() {
        super(KmsEnvelopeAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, KmsEnvelopeAeadKey>(Aead.class) {
            public Aead getPrimitive(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) throws GeneralSecurityException {
                String kekUri = kmsEnvelopeAeadKey.getParams().getKekUri();
                return new KmsEnvelopeAead(kmsEnvelopeAeadKey.getParams().getDekTemplate(), KmsClients.get(kekUri).getAead(kekUri));
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    public void validateKey(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(kmsEnvelopeAeadKey.getVersion(), getVersion());
    }

    public KmsEnvelopeAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return KmsEnvelopeAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey>(KmsEnvelopeAeadKeyFormat.class) {
            public void validateKeyFormat(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) throws GeneralSecurityException {
            }

            public KmsEnvelopeAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return KmsEnvelopeAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public KmsEnvelopeAeadKey createKey(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) throws GeneralSecurityException {
                return (KmsEnvelopeAeadKey) KmsEnvelopeAeadKey.newBuilder().setParams(kmsEnvelopeAeadKeyFormat).setVersion(KmsEnvelopeAeadKeyManager.this.getVersion()).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new KmsEnvelopeAeadKeyManager(), z);
    }
}
