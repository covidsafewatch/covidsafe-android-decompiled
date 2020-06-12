package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AesCtrHmacStreamingParams extends GeneratedMessageLite<AesCtrHmacStreamingParams, Builder> implements AesCtrHmacStreamingParamsOrBuilder {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final AesCtrHmacStreamingParams DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    public static final int HMAC_PARAMS_FIELD_NUMBER = 4;
    private static volatile Parser<AesCtrHmacStreamingParams> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;
    private HmacParams hmacParams_;

    private AesCtrHmacStreamingParams() {
    }

    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize_;
    }

    /* access modifiers changed from: private */
    public void setCiphertextSegmentSize(int i) {
        this.ciphertextSegmentSize_ = i;
    }

    /* access modifiers changed from: private */
    public void clearCiphertextSegmentSize() {
        this.ciphertextSegmentSize_ = 0;
    }

    public int getDerivedKeySize() {
        return this.derivedKeySize_;
    }

    /* access modifiers changed from: private */
    public void setDerivedKeySize(int i) {
        this.derivedKeySize_ = i;
    }

    /* access modifiers changed from: private */
    public void clearDerivedKeySize() {
        this.derivedKeySize_ = 0;
    }

    public int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
    }

    public HashType getHkdfHashType() {
        HashType forNumber = HashType.forNumber(this.hkdfHashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setHkdfHashTypeValue(int i) {
        this.hkdfHashType_ = i;
    }

    /* access modifiers changed from: private */
    public void setHkdfHashType(HashType hashType) {
        this.hkdfHashType_ = hashType.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearHkdfHashType() {
        this.hkdfHashType_ = 0;
    }

    public boolean hasHmacParams() {
        return this.hmacParams_ != null;
    }

    public HmacParams getHmacParams() {
        HmacParams hmacParams = this.hmacParams_;
        return hmacParams == null ? HmacParams.getDefaultInstance() : hmacParams;
    }

    /* access modifiers changed from: private */
    public void setHmacParams(HmacParams hmacParams) {
        hmacParams.getClass();
        this.hmacParams_ = hmacParams;
    }

    /* access modifiers changed from: private */
    public void mergeHmacParams(HmacParams hmacParams) {
        hmacParams.getClass();
        HmacParams hmacParams2 = this.hmacParams_;
        if (hmacParams2 == null || hmacParams2 == HmacParams.getDefaultInstance()) {
            this.hmacParams_ = hmacParams;
        } else {
            this.hmacParams_ = (HmacParams) ((HmacParams.Builder) HmacParams.newBuilder(this.hmacParams_).mergeFrom(hmacParams)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearHmacParams() {
        this.hmacParams_ = null;
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AesCtrHmacStreamingParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingParams parseFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacStreamingParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingParams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacStreamingParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacStreamingParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacStreamingParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingParams parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AesCtrHmacStreamingParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(aesCtrHmacStreamingParams);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingParams, Builder> implements AesCtrHmacStreamingParamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AesCtrHmacStreamingParams.DEFAULT_INSTANCE);
        }

        public int getCiphertextSegmentSize() {
            return ((AesCtrHmacStreamingParams) this.instance).getCiphertextSegmentSize();
        }

        public Builder setCiphertextSegmentSize(int i) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setCiphertextSegmentSize(i);
            return this;
        }

        public Builder clearCiphertextSegmentSize() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearCiphertextSegmentSize();
            return this;
        }

        public int getDerivedKeySize() {
            return ((AesCtrHmacStreamingParams) this.instance).getDerivedKeySize();
        }

        public Builder setDerivedKeySize(int i) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setDerivedKeySize(i);
            return this;
        }

        public Builder clearDerivedKeySize() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearDerivedKeySize();
            return this;
        }

        public int getHkdfHashTypeValue() {
            return ((AesCtrHmacStreamingParams) this.instance).getHkdfHashTypeValue();
        }

        public Builder setHkdfHashTypeValue(int i) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHkdfHashTypeValue(i);
            return this;
        }

        public HashType getHkdfHashType() {
            return ((AesCtrHmacStreamingParams) this.instance).getHkdfHashType();
        }

        public Builder setHkdfHashType(HashType hashType) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHkdfHashType(hashType);
            return this;
        }

        public Builder clearHkdfHashType() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearHkdfHashType();
            return this;
        }

        public boolean hasHmacParams() {
            return ((AesCtrHmacStreamingParams) this.instance).hasHmacParams();
        }

        public HmacParams getHmacParams() {
            return ((AesCtrHmacStreamingParams) this.instance).getHmacParams();
        }

        public Builder setHmacParams(HmacParams hmacParams) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHmacParams(hmacParams);
            return this;
        }

        public Builder setHmacParams(HmacParams.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHmacParams((HmacParams) builder.build());
            return this;
        }

        public Builder mergeHmacParams(HmacParams hmacParams) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).mergeHmacParams(hmacParams);
            return this;
        }

        public Builder clearHmacParams() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearHmacParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacStreamingParams$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.AesCtrHmacStreamingParams.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AesCtrHmacStreamingParams();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f\u0004\t", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_", "hmacParams_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacStreamingParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacStreamingParams.class) {
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
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = new AesCtrHmacStreamingParams();
        DEFAULT_INSTANCE = aesCtrHmacStreamingParams;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacStreamingParams.class, aesCtrHmacStreamingParams);
    }

    public static AesCtrHmacStreamingParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacStreamingParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
