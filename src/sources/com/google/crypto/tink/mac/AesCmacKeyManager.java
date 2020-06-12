package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCmacKey;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesCmac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesCmacKeyManager extends KeyTypeManager<AesCmacKey> {
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int MAX_TAG_SIZE_IN_BYTES = 16;
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public int getVersion() {
        return 0;
    }

    AesCmacKeyManager() {
        super(AesCmacKey.class, new KeyTypeManager.PrimitiveFactory<Mac, AesCmacKey>(Mac.class) {
            public Mac getPrimitive(AesCmacKey aesCmacKey) throws GeneralSecurityException {
                return new AesCmac(aesCmacKey.getKeyValue().toByteArray(), aesCmacKey.getParams().getTagSize());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCmacKey.getVersion(), getVersion());
        validateSize(aesCmacKey.getKeyValue().size());
        validateParams(aesCmacKey.getParams());
    }

    public AesCmacKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* access modifiers changed from: private */
    public static void validateParams(AesCmacParams aesCmacParams) throws GeneralSecurityException {
        if (aesCmacParams.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (aesCmacParams.getTagSize() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void validateSize(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
        }
    }

    public KeyTypeManager.KeyFactory<AesCmacKeyFormat, AesCmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCmacKeyFormat, AesCmacKey>(AesCmacKeyFormat.class) {
            public void validateKeyFormat(AesCmacKeyFormat aesCmacKeyFormat) throws GeneralSecurityException {
                AesCmacKeyManager.validateParams(aesCmacKeyFormat.getParams());
                AesCmacKeyManager.validateSize(aesCmacKeyFormat.getKeySize());
            }

            public AesCmacKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public AesCmacKey createKey(AesCmacKeyFormat aesCmacKeyFormat) throws GeneralSecurityException {
                return (AesCmacKey) AesCmacKey.newBuilder().setVersion(0).setKeyValue(ByteString.copyFrom(Random.randBytes(aesCmacKeyFormat.getKeySize()))).setParams(aesCmacKeyFormat.getParams()).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCmacKeyManager(), z);
    }

    public static final KeyTemplate aes256CmacTemplate() {
        return KeyTemplate.create(new AesCmacKeyManager().getKeyType(), ((AesCmacKeyFormat) AesCmacKeyFormat.newBuilder().setKeySize(32).setParams((AesCmacParams) AesCmacParams.newBuilder().setTagSize(16).build()).build()).toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawAes256CmacTemplate() {
        return KeyTemplate.create(new AesCmacKeyManager().getKeyType(), ((AesCmacKeyFormat) AesCmacKeyFormat.newBuilder().setKeySize(32).setParams((AesCmacParams) AesCmacParams.newBuilder().setTagSize(16).build()).build()).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}
