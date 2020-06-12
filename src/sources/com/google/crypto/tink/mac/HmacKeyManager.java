package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.MacJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

public final class HmacKeyManager extends KeyTypeManager<HmacKey> {
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public int getVersion() {
        return 0;
    }

    public HmacKeyManager() {
        super(HmacKey.class, new KeyTypeManager.PrimitiveFactory<Mac, HmacKey>(Mac.class) {
            public Mac getPrimitive(HmacKey hmacKey) throws GeneralSecurityException {
                HashType hash = hmacKey.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.getKeyValue().toByteArray(), "HMAC");
                int tagSize = hmacKey.getParams().getTagSize();
                int i = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
                if (i == 1) {
                    return new MacJce("HMACSHA1", secretKeySpec, tagSize);
                }
                if (i == 2) {
                    return new MacJce("HMACSHA256", secretKeySpec, tagSize);
                }
                if (i == 3) {
                    return new MacJce("HMACSHA512", secretKeySpec, tagSize);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    /* renamed from: com.google.crypto.tink.mac.HmacKeyManager$3  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.mac.HmacKeyManager.AnonymousClass3.<clinit>():void");
        }
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(HmacKey hmacKey) throws GeneralSecurityException {
        Validators.validateVersion(hmacKey.getVersion(), getVersion());
        if (hmacKey.getKeyValue().size() >= 16) {
            validateParams(hmacKey.getParams());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public HmacKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return HmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* access modifiers changed from: private */
    public static void validateParams(HmacParams hmacParams) throws GeneralSecurityException {
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

    public KeyTypeManager.KeyFactory<HmacKeyFormat, HmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacKeyFormat, HmacKey>(HmacKeyFormat.class) {
            public void validateKeyFormat(HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                if (hmacKeyFormat.getKeySize() >= 16) {
                    HmacKeyManager.validateParams(hmacKeyFormat.getParams());
                    return;
                }
                throw new GeneralSecurityException("key too short");
            }

            public HmacKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return HmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public HmacKey createKey(HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                return (HmacKey) HmacKey.newBuilder().setVersion(HmacKeyManager.this.getVersion()).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(hmacKeyFormat.getKeySize()))).build();
            }

            public HmacKey deriveKey(HmacKeyFormat hmacKeyFormat, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(hmacKeyFormat.getVersion(), HmacKeyManager.this.getVersion());
                byte[] bArr = new byte[hmacKeyFormat.getKeySize()];
                try {
                    if (inputStream.read(bArr) == hmacKeyFormat.getKeySize()) {
                        return (HmacKey) HmacKey.newBuilder().setVersion(HmacKeyManager.this.getVersion()).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(bArr)).build();
                    }
                    throw new GeneralSecurityException("Not enough pseudorandomness given");
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new HmacKeyManager(), z);
    }

    public static final KeyTemplate hmacSha256HalfDigestTemplate() {
        return createTemplate(32, 16, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha256Template() {
        return createTemplate(32, 32, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha512HalfDigestTemplate() {
        return createTemplate(64, 32, HashType.SHA512);
    }

    public static final KeyTemplate hmacSha512Template() {
        return createTemplate(64, 64, HashType.SHA512);
    }

    private static KeyTemplate createTemplate(int i, int i2, HashType hashType) {
        return KeyTemplate.create(new HmacKeyManager().getKeyType(), ((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(i2).build()).setKeySize(i).build()).toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }
}
