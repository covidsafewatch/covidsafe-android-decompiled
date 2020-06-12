package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

public final class AesSivKeyManager extends KeyTypeManager<AesSivKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public int getVersion() {
        return 0;
    }

    AesSivKeyManager() {
        super(AesSivKey.class, new KeyTypeManager.PrimitiveFactory<DeterministicAead, AesSivKey>(DeterministicAead.class) {
            public DeterministicAead getPrimitive(AesSivKey aesSivKey) throws GeneralSecurityException {
                return new AesSiv(aesSivKey.getKeyValue().toByteArray());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(AesSivKey aesSivKey) throws GeneralSecurityException {
        Validators.validateVersion(aesSivKey.getVersion(), getVersion());
        if (aesSivKey.getKeyValue().size() != 64) {
            throw new InvalidKeyException("invalid key size: " + aesSivKey.getKeyValue().size() + ". Valid keys must have 64 bytes.");
        }
    }

    public AesSivKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesSivKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey>(AesSivKeyFormat.class) {
            public void validateKeyFormat(AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
                if (aesSivKeyFormat.getKeySize() != 64) {
                    throw new InvalidAlgorithmParameterException("invalid key size: " + aesSivKeyFormat.getKeySize() + ". Valid keys must have 64 bytes.");
                }
            }

            public AesSivKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesSivKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public AesSivKey createKey(AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
                return (AesSivKey) AesSivKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesSivKeyFormat.getKeySize()))).setVersion(AesSivKeyManager.this.getVersion()).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesSivKeyManager(), z);
    }

    public static final KeyTemplate aes256SivTemplate() {
        return createKeyTemplate(64, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawAes256SivTemplate() {
        return createKeyTemplate(64, KeyTemplate.OutputPrefixType.RAW);
    }

    private static KeyTemplate createKeyTemplate(int i, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new AesSivKeyManager().getKeyType(), ((AesSivKeyFormat) AesSivKeyFormat.newBuilder().setKeySize(i).build()).toByteArray(), outputPrefixType);
    }
}
