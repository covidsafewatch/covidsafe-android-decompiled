package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AesCtrHmacAeadKey extends GeneratedMessageLite<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final AesCtrHmacAeadKey DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile Parser<AesCtrHmacAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AesCtrKey aesCtrKey_;
    private HmacKey hmacKey_;
    private int version_;

    private AesCtrHmacAeadKey() {
    }

    public int getVersion() {
        return this.version_;
    }

    /* access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public boolean hasAesCtrKey() {
        return this.aesCtrKey_ != null;
    }

    public AesCtrKey getAesCtrKey() {
        AesCtrKey aesCtrKey = this.aesCtrKey_;
        return aesCtrKey == null ? AesCtrKey.getDefaultInstance() : aesCtrKey;
    }

    /* access modifiers changed from: private */
    public void setAesCtrKey(AesCtrKey aesCtrKey) {
        aesCtrKey.getClass();
        this.aesCtrKey_ = aesCtrKey;
    }

    /* access modifiers changed from: private */
    public void mergeAesCtrKey(AesCtrKey aesCtrKey) {
        aesCtrKey.getClass();
        AesCtrKey aesCtrKey2 = this.aesCtrKey_;
        if (aesCtrKey2 == null || aesCtrKey2 == AesCtrKey.getDefaultInstance()) {
            this.aesCtrKey_ = aesCtrKey;
        } else {
            this.aesCtrKey_ = (AesCtrKey) ((AesCtrKey.Builder) AesCtrKey.newBuilder(this.aesCtrKey_).mergeFrom(aesCtrKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAesCtrKey() {
        this.aesCtrKey_ = null;
    }

    public boolean hasHmacKey() {
        return this.hmacKey_ != null;
    }

    public HmacKey getHmacKey() {
        HmacKey hmacKey = this.hmacKey_;
        return hmacKey == null ? HmacKey.getDefaultInstance() : hmacKey;
    }

    /* access modifiers changed from: private */
    public void setHmacKey(HmacKey hmacKey) {
        hmacKey.getClass();
        this.hmacKey_ = hmacKey;
    }

    /* access modifiers changed from: private */
    public void mergeHmacKey(HmacKey hmacKey) {
        hmacKey.getClass();
        HmacKey hmacKey2 = this.hmacKey_;
        if (hmacKey2 == null || hmacKey2 == HmacKey.getDefaultInstance()) {
            this.hmacKey_ = hmacKey;
        } else {
            this.hmacKey_ = (HmacKey) ((HmacKey.Builder) HmacKey.newBuilder(this.hmacKey_).mergeFrom(hmacKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearHmacKey() {
        this.hmacKey_ = null;
    }

    public static AesCtrHmacAeadKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AesCtrHmacAeadKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacAeadKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacAeadKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AesCtrHmacAeadKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacAeadKey aesCtrHmacAeadKey) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(aesCtrHmacAeadKey);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AesCtrHmacAeadKey.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((AesCtrHmacAeadKey) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearVersion();
            return this;
        }

        public boolean hasAesCtrKey() {
            return ((AesCtrHmacAeadKey) this.instance).hasAesCtrKey();
        }

        public AesCtrKey getAesCtrKey() {
            return ((AesCtrHmacAeadKey) this.instance).getAesCtrKey();
        }

        public Builder setAesCtrKey(AesCtrKey aesCtrKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setAesCtrKey(aesCtrKey);
            return this;
        }

        public Builder setAesCtrKey(AesCtrKey.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setAesCtrKey((AesCtrKey) builder.build());
            return this;
        }

        public Builder mergeAesCtrKey(AesCtrKey aesCtrKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).mergeAesCtrKey(aesCtrKey);
            return this;
        }

        public Builder clearAesCtrKey() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearAesCtrKey();
            return this;
        }

        public boolean hasHmacKey() {
            return ((AesCtrHmacAeadKey) this.instance).hasHmacKey();
        }

        public HmacKey getHmacKey() {
            return ((AesCtrHmacAeadKey) this.instance).getHmacKey();
        }

        public Builder setHmacKey(HmacKey hmacKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setHmacKey(hmacKey);
            return this;
        }

        public Builder setHmacKey(HmacKey.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setHmacKey((HmacKey) builder.build());
            return this;
        }

        public Builder mergeHmacKey(HmacKey hmacKey) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).mergeHmacKey(hmacKey);
            return this;
        }

        public Builder clearHmacKey() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearHmacKey();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacAeadKey$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.AesCtrHmacAeadKey.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AesCtrHmacAeadKey();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacAeadKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacAeadKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrHmacAeadKey aesCtrHmacAeadKey = new AesCtrHmacAeadKey();
        DEFAULT_INSTANCE = aesCtrHmacAeadKey;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacAeadKey.class, aesCtrHmacAeadKey);
    }

    public static AesCtrHmacAeadKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacAeadKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
