package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKey;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesCtrHmacStreaming;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesCtrHmacStreamingKeyManager extends KeyTypeManager<AesCtrHmacStreamingKey> {
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private static final int NONCE_PREFIX_IN_BYTES = 7;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }

    public int getVersion() {
        return 0;
    }

    AesCtrHmacStreamingKeyManager() {
        super(AesCtrHmacStreamingKey.class, new KeyTypeManager.PrimitiveFactory<StreamingAead, AesCtrHmacStreamingKey>(StreamingAead.class) {
            public StreamingAead getPrimitive(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) throws GeneralSecurityException {
                return new AesCtrHmacStreaming(aesCtrHmacStreamingKey.getKeyValue().toByteArray(), StreamingAeadUtil.toHmacAlgo(aesCtrHmacStreamingKey.getParams().getHkdfHashType()), aesCtrHmacStreamingKey.getParams().getDerivedKeySize(), StreamingAeadUtil.toHmacAlgo(aesCtrHmacStreamingKey.getParams().getHmacParams().getHash()), aesCtrHmacStreamingKey.getParams().getHmacParams().getTagSize(), aesCtrHmacStreamingKey.getParams().getCiphertextSegmentSize(), 0);
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrHmacStreamingKey.getVersion(), getVersion());
        if (aesCtrHmacStreamingKey.getKeyValue().size() < 16) {
            throw new GeneralSecurityException("key_value must have at least 16 bytes");
        } else if (aesCtrHmacStreamingKey.getKeyValue().size() >= aesCtrHmacStreamingKey.getParams().getDerivedKeySize()) {
            validateParams(aesCtrHmacStreamingKey.getParams());
        } else {
            throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
        }
    }

    public AesCtrHmacStreamingKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacStreamingKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey>(AesCtrHmacStreamingKeyFormat.class) {
            public void validateKeyFormat(AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat) throws GeneralSecurityException {
                if (aesCtrHmacStreamingKeyFormat.getKeySize() >= 16) {
                    AesCtrHmacStreamingKeyManager.validateParams(aesCtrHmacStreamingKeyFormat.getParams());
                    return;
                }
                throw new GeneralSecurityException("key_size must be at least 16 bytes");
            }

            public AesCtrHmacStreamingKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacStreamingKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public AesCtrHmacStreamingKey createKey(AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat) throws GeneralSecurityException {
                return (AesCtrHmacStreamingKey) AesCtrHmacStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesCtrHmacStreamingKeyFormat.getKeySize()))).setParams(aesCtrHmacStreamingKeyFormat.getParams()).setVersion(AesCtrHmacStreamingKeyManager.this.getVersion()).build();
            }
        };
    }

    /* access modifiers changed from: private */
    public static void validateParams(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) throws GeneralSecurityException {
        Validators.validateAesKeySize(aesCtrHmacStreamingParams.getDerivedKeySize());
        if (aesCtrHmacStreamingParams.getHkdfHashType() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        } else if (aesCtrHmacStreamingParams.getHmacParams().getHash() != HashType.UNKNOWN_HASH) {
            validateHmacParams(aesCtrHmacStreamingParams.getHmacParams());
            if (aesCtrHmacStreamingParams.getCiphertextSegmentSize() < aesCtrHmacStreamingParams.getDerivedKeySize() + aesCtrHmacStreamingParams.getHmacParams().getTagSize() + 2 + 7) {
                throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
            }
        } else {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
    }

    private static void validateHmacParams(HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.getTagSize() >= 10) {
            int i = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hmacParams.getHash().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (hmacParams.getTagSize() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (hmacParams.getTagSize() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (hmacParams.getTagSize() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    /* renamed from: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.crypto.tink.proto.HashType[] r0 = com.google.crypto.tink.proto.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$HashType = r0
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$HashType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$HashType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.AnonymousClass3.<clinit>():void");
        }
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCtrHmacStreamingKeyManager(), z);
    }

    public static final KeyTemplate aes128CtrHmacSha2564KBTemplate() {
        return createKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 4096);
    }

    public static final KeyTemplate aes128CtrHmacSha2561MBTemplate() {
        return createKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 1048576);
    }

    public static final KeyTemplate aes256CtrHmacSha2564KBTemplate() {
        return createKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 4096);
    }

    public static final KeyTemplate aes256CtrHmacSha2561MBTemplate() {
        return createKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 1048576);
    }

    private static KeyTemplate createKeyTemplate(int i, HashType hashType, int i2, HashType hashType2, int i3, int i4) {
        AesCtrHmacStreamingParams.Builder hkdfHashType = AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(i4).setDerivedKeySize(i2).setHkdfHashType(hashType);
        return KeyTemplate.create(new AesCtrHmacStreamingKeyManager().getKeyType(), ((AesCtrHmacStreamingKeyFormat) AesCtrHmacStreamingKeyFormat.newBuilder().setParams((AesCtrHmacStreamingParams) hkdfHashType.setHmacParams((HmacParams) HmacParams.newBuilder().setHash(hashType2).setTagSize(i3).build()).build()).setKeySize(i).build()).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}
