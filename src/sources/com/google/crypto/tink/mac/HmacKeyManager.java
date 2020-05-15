package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.MacJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

class HmacKeyManager implements KeyManager<Mac> {
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.HmacKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public int getVersion() {
        return 0;
    }

    HmacKeyManager() {
    }

    public Mac getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) HmacKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    public Mac getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof HmacKey) {
            HmacKey hmacKey = (HmacKey) messageLite;
            validate(hmacKey);
            HashType hash = hmacKey.getParams().getHash();
            SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.getKeyValue().toByteArray(), "HMAC");
            int tagSize = hmacKey.getParams().getTagSize();
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
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
        throw new GeneralSecurityException("expected HmacKey proto");
    }

    /* renamed from: com.google.crypto.tink.mac.HmacKeyManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.mac.HmacKeyManager.AnonymousClass1.<clinit>():void");
        }
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) HmacKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof HmacKeyFormat) {
            HmacKeyFormat hmacKeyFormat = (HmacKeyFormat) messageLite;
            validate(hmacKeyFormat);
            return HmacKey.newBuilder().setVersion(0).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(hmacKeyFormat.getKeySize()))).build();
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.HmacKey").setValue(((HmacKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.HmacKey");
    }

    private void validate(HmacKey hmacKey) throws GeneralSecurityException {
        Validators.validateVersion(hmacKey.getVersion(), 0);
        if (hmacKey.getKeyValue().size() >= 16) {
            validate(hmacKey.getParams());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    private void validate(HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
        if (hmacKeyFormat.getKeySize() >= 16) {
            validate(hmacKeyFormat.getParams());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    private void validate(HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.getTagSize() >= 10) {
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hmacParams.getHash().ordinal()];
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
}
