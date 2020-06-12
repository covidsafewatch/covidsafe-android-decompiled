package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesEaxKeyManager extends KeyTypeManager<AesEaxKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public int getVersion() {
        return 0;
    }

    AesEaxKeyManager() {
        super(AesEaxKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesEaxKey>(Aead.class) {
            public Aead getPrimitive(AesEaxKey aesEaxKey) throws GeneralSecurityException {
                return new AesEaxJce(aesEaxKey.getKeyValue().toByteArray(), aesEaxKey.getParams().getIvSize());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(AesEaxKey aesEaxKey) throws GeneralSecurityException {
        Validators.validateVersion(aesEaxKey.getVersion(), getVersion());
        Validators.validateAesKeySize(aesEaxKey.getKeyValue().size());
        if (aesEaxKey.getParams().getIvSize() != 12 && aesEaxKey.getParams().getIvSize() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public AesEaxKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesEaxKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<AesEaxKeyFormat, AesEaxKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesEaxKeyFormat, AesEaxKey>(AesEaxKeyFormat.class) {
            public void validateKeyFormat(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                Validators.validateAesKeySize(aesEaxKeyFormat.getKeySize());
                if (aesEaxKeyFormat.getParams().getIvSize() != 12 && aesEaxKeyFormat.getParams().getIvSize() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }

            public AesEaxKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesEaxKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public AesEaxKey createKey(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                return (AesEaxKey) AesEaxKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesEaxKeyFormat.getKeySize()))).setParams(aesEaxKeyFormat.getParams()).setVersion(AesEaxKeyManager.this.getVersion()).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesEaxKeyManager(), z);
    }

    public static final KeyTemplate aes128EaxTemplate() {
        return createKeyTemplate(16, 16, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawAes128EaxTemplate() {
        return createKeyTemplate(16, 16, KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate aes256EaxTemplate() {
        return createKeyTemplate(32, 16, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawAes256EaxTemplate() {
        return createKeyTemplate(32, 16, KeyTemplate.OutputPrefixType.RAW);
    }

    private static KeyTemplate createKeyTemplate(int i, int i2, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new AesEaxKeyManager().getKeyType(), ((AesEaxKeyFormat) AesEaxKeyFormat.newBuilder().setKeySize(i).setParams((AesEaxParams) AesEaxParams.newBuilder().setIvSize(i2).build()).build()).toByteArray(), outputPrefixType);
    }
}
