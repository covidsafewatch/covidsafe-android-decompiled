package com.google.crypto.tink.aead;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesCtrJceCipher;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class AesCtrKeyManager extends KeyTypeManager<AesCtrKey> {
    private static final int MIN_IV_SIZE_IN_BYTES = 12;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public int getVersion() {
        return 0;
    }

    AesCtrKeyManager() {
        super(AesCtrKey.class, new KeyTypeManager.PrimitiveFactory<IndCpaCipher, AesCtrKey>(IndCpaCipher.class) {
            public IndCpaCipher getPrimitive(AesCtrKey aesCtrKey) throws GeneralSecurityException {
                return new AesCtrJceCipher(aesCtrKey.getKeyValue().toByteArray(), aesCtrKey.getParams().getIvSize());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(AesCtrKey aesCtrKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrKey.getVersion(), getVersion());
        Validators.validateAesKeySize(aesCtrKey.getKeyValue().size());
        validateParams(aesCtrKey.getParams());
    }

    public AesCtrKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<AesCtrKeyFormat, AesCtrKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrKeyFormat, AesCtrKey>(AesCtrKeyFormat.class) {
            public void validateKeyFormat(AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
                Validators.validateAesKeySize(aesCtrKeyFormat.getKeySize());
                AesCtrKeyManager.this.validateParams(aesCtrKeyFormat.getParams());
            }

            public AesCtrKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public AesCtrKey createKey(AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
                return (AesCtrKey) AesCtrKey.newBuilder().setParams(aesCtrKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(aesCtrKeyFormat.getKeySize()))).setVersion(AesCtrKeyManager.this.getVersion()).build();
            }
        };
    }

    /* access modifiers changed from: private */
    public void validateParams(AesCtrParams aesCtrParams) throws GeneralSecurityException {
        if (aesCtrParams.getIvSize() < 12 || aesCtrParams.getIvSize() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCtrKeyManager(), z);
    }
}
