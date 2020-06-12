package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.mac.HmacKeyManager;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesCtrHmacAeadKeyManager extends KeyTypeManager<AesCtrHmacAeadKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public int getVersion() {
        return 0;
    }

    AesCtrHmacAeadKeyManager() {
        super(AesCtrHmacAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesCtrHmacAeadKey>(Aead.class) {
            public Aead getPrimitive(AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
                return new EncryptThenAuthenticate((IndCpaCipher) new AesCtrKeyManager().getPrimitive(aesCtrHmacAeadKey.getAesCtrKey(), IndCpaCipher.class), (Mac) new HmacKeyManager().getPrimitive(aesCtrHmacAeadKey.getHmacKey(), Mac.class), aesCtrHmacAeadKey.getHmacKey().getParams().getTagSize());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrHmacAeadKey.getVersion(), getVersion());
    }

    public AesCtrHmacAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey>(AesCtrHmacAeadKeyFormat.class) {
            public void validateKeyFormat(AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
                new AesCtrKeyManager().keyFactory().validateKeyFormat(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat());
                new HmacKeyManager().keyFactory().validateKeyFormat(aesCtrHmacAeadKeyFormat.getHmacKeyFormat());
                Validators.validateAesKeySize(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat().getKeySize());
            }

            public AesCtrHmacAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public AesCtrHmacAeadKey createKey(AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
                return (AesCtrHmacAeadKey) AesCtrHmacAeadKey.newBuilder().setAesCtrKey(new AesCtrKeyManager().keyFactory().createKey(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat())).setHmacKey(new HmacKeyManager().keyFactory().createKey(aesCtrHmacAeadKeyFormat.getHmacKeyFormat())).setVersion(AesCtrHmacAeadKeyManager.this.getVersion()).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCtrHmacAeadKeyManager(), z);
    }

    public static final KeyTemplate aes128CtrHmacSha256Template() {
        return createKeyTemplate(16, 16, 32, 16, HashType.SHA256);
    }

    public static final KeyTemplate aes256CtrHmacSha256Template() {
        return createKeyTemplate(32, 16, 32, 32, HashType.SHA256);
    }

    private static KeyTemplate createKeyTemplate(int i, int i2, int i3, int i4, HashType hashType) {
        return KeyTemplate.create(new AesCtrHmacAeadKeyManager().getKeyType(), ((AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat((AesCtrKeyFormat) AesCtrKeyFormat.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(i2).build()).setKeySize(i).build()).setHmacKeyFormat((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(i4).build()).setKeySize(i3).build()).build()).toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }
}
