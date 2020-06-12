package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class RsaSsaPssKeyFormat extends GeneratedMessageLite<RsaSsaPssKeyFormat, Builder> implements RsaSsaPssKeyFormatOrBuilder {
    /* access modifiers changed from: private */
    public static final RsaSsaPssKeyFormat DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPssKeyFormat> PARSER = null;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    private int modulusSizeInBits_;
    private RsaSsaPssParams params_;
    private ByteString publicExponent_ = ByteString.EMPTY;

    private RsaSsaPssKeyFormat() {
    }

    public boolean hasParams() {
        return this.params_ != null;
    }

    public RsaSsaPssParams getParams() {
        RsaSsaPssParams rsaSsaPssParams = this.params_;
        return rsaSsaPssParams == null ? RsaSsaPssParams.getDefaultInstance() : rsaSsaPssParams;
    }

    /* access modifiers changed from: private */
    public void setParams(RsaSsaPssParams rsaSsaPssParams) {
        rsaSsaPssParams.getClass();
        this.params_ = rsaSsaPssParams;
    }

    /* access modifiers changed from: private */
    public void mergeParams(RsaSsaPssParams rsaSsaPssParams) {
        rsaSsaPssParams.getClass();
        RsaSsaPssParams rsaSsaPssParams2 = this.params_;
        if (rsaSsaPssParams2 == null || rsaSsaPssParams2 == RsaSsaPssParams.getDefaultInstance()) {
            this.params_ = rsaSsaPssParams;
        } else {
            this.params_ = (RsaSsaPssParams) ((RsaSsaPssParams.Builder) RsaSsaPssParams.newBuilder(this.params_).mergeFrom(rsaSsaPssParams)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public int getModulusSizeInBits() {
        return this.modulusSizeInBits_;
    }

    /* access modifiers changed from: private */
    public void setModulusSizeInBits(int i) {
        this.modulusSizeInBits_ = i;
    }

    /* access modifiers changed from: private */
    public void clearModulusSizeInBits() {
        this.modulusSizeInBits_ = 0;
    }

    public ByteString getPublicExponent() {
        return this.publicExponent_;
    }

    /* access modifiers changed from: private */
    public void setPublicExponent(ByteString byteString) {
        byteString.getClass();
        this.publicExponent_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearPublicExponent() {
        this.publicExponent_ = getDefaultInstance().getPublicExponent();
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RsaSsaPssKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RsaSsaPssKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPssKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RsaSsaPssKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPssKeyFormat rsaSsaPssKeyFormat) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(rsaSsaPssKeyFormat);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssKeyFormat, Builder> implements RsaSsaPssKeyFormatOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(RsaSsaPssKeyFormat.DEFAULT_INSTANCE);
        }

        public boolean hasParams() {
            return ((RsaSsaPssKeyFormat) this.instance).hasParams();
        }

        public RsaSsaPssParams getParams() {
            return ((RsaSsaPssKeyFormat) this.instance).getParams();
        }

        public Builder setParams(RsaSsaPssParams rsaSsaPssParams) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setParams(rsaSsaPssParams);
            return this;
        }

        public Builder setParams(RsaSsaPssParams.Builder builder) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setParams((RsaSsaPssParams) builder.build());
            return this;
        }

        public Builder mergeParams(RsaSsaPssParams rsaSsaPssParams) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).mergeParams(rsaSsaPssParams);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearParams();
            return this;
        }

        public int getModulusSizeInBits() {
            return ((RsaSsaPssKeyFormat) this.instance).getModulusSizeInBits();
        }

        public Builder setModulusSizeInBits(int i) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setModulusSizeInBits(i);
            return this;
        }

        public Builder clearModulusSizeInBits() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearModulusSizeInBits();
            return this;
        }

        public ByteString getPublicExponent() {
            return ((RsaSsaPssKeyFormat) this.instance).getPublicExponent();
        }

        public Builder setPublicExponent(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setPublicExponent(byteString);
            return this;
        }

        public Builder clearPublicExponent() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearPublicExponent();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssKeyFormat$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.RsaSsaPssKeyFormat.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RsaSsaPssKeyFormat();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[]{"params_", "modulusSizeInBits_", "publicExponent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPssKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPssKeyFormat.class) {
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
        RsaSsaPssKeyFormat rsaSsaPssKeyFormat = new RsaSsaPssKeyFormat();
        DEFAULT_INSTANCE = rsaSsaPssKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssKeyFormat.class, rsaSsaPssKeyFormat);
    }

    public static RsaSsaPssKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPssKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
