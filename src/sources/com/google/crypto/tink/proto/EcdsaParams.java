package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class EcdsaParams extends GeneratedMessageLite<EcdsaParams, Builder> implements EcdsaParamsOrBuilder {
    public static final int CURVE_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final EcdsaParams DEFAULT_INSTANCE;
    public static final int ENCODING_FIELD_NUMBER = 3;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<EcdsaParams> PARSER;
    private int curve_;
    private int encoding_;
    private int hashType_;

    private EcdsaParams() {
    }

    public int getHashTypeValue() {
        return this.hashType_;
    }

    public HashType getHashType() {
        HashType forNumber = HashType.forNumber(this.hashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setHashTypeValue(int i) {
        this.hashType_ = i;
    }

    /* access modifiers changed from: private */
    public void setHashType(HashType hashType) {
        this.hashType_ = hashType.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearHashType() {
        this.hashType_ = 0;
    }

    public int getCurveValue() {
        return this.curve_;
    }

    public EllipticCurveType getCurve() {
        EllipticCurveType forNumber = EllipticCurveType.forNumber(this.curve_);
        return forNumber == null ? EllipticCurveType.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setCurveValue(int i) {
        this.curve_ = i;
    }

    /* access modifiers changed from: private */
    public void setCurve(EllipticCurveType ellipticCurveType) {
        this.curve_ = ellipticCurveType.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearCurve() {
        this.curve_ = 0;
    }

    public int getEncodingValue() {
        return this.encoding_;
    }

    public EcdsaSignatureEncoding getEncoding() {
        EcdsaSignatureEncoding forNumber = EcdsaSignatureEncoding.forNumber(this.encoding_);
        return forNumber == null ? EcdsaSignatureEncoding.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setEncodingValue(int i) {
        this.encoding_ = i;
    }

    /* access modifiers changed from: private */
    public void setEncoding(EcdsaSignatureEncoding ecdsaSignatureEncoding) {
        this.encoding_ = ecdsaSignatureEncoding.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearEncoding() {
        this.encoding_ = 0;
    }

    public static EcdsaParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static EcdsaParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EcdsaParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EcdsaParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EcdsaParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EcdsaParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EcdsaParams parseFrom(InputStream inputStream) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EcdsaParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EcdsaParams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EcdsaParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EcdsaParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EcdsaParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EcdsaParams parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EcdsaParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EcdsaParams ecdsaParams) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(ecdsaParams);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaParams, Builder> implements EcdsaParamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(EcdsaParams.DEFAULT_INSTANCE);
        }

        public int getHashTypeValue() {
            return ((EcdsaParams) this.instance).getHashTypeValue();
        }

        public Builder setHashTypeValue(int i) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setHashTypeValue(i);
            return this;
        }

        public HashType getHashType() {
            return ((EcdsaParams) this.instance).getHashType();
        }

        public Builder setHashType(HashType hashType) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setHashType(hashType);
            return this;
        }

        public Builder clearHashType() {
            copyOnWrite();
            ((EcdsaParams) this.instance).clearHashType();
            return this;
        }

        public int getCurveValue() {
            return ((EcdsaParams) this.instance).getCurveValue();
        }

        public Builder setCurveValue(int i) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setCurveValue(i);
            return this;
        }

        public EllipticCurveType getCurve() {
            return ((EcdsaParams) this.instance).getCurve();
        }

        public Builder setCurve(EllipticCurveType ellipticCurveType) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setCurve(ellipticCurveType);
            return this;
        }

        public Builder clearCurve() {
            copyOnWrite();
            ((EcdsaParams) this.instance).clearCurve();
            return this;
        }

        public int getEncodingValue() {
            return ((EcdsaParams) this.instance).getEncodingValue();
        }

        public Builder setEncodingValue(int i) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setEncodingValue(i);
            return this;
        }

        public EcdsaSignatureEncoding getEncoding() {
            return ((EcdsaParams) this.instance).getEncoding();
        }

        public Builder setEncoding(EcdsaSignatureEncoding ecdsaSignatureEncoding) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setEncoding(ecdsaSignatureEncoding);
            return this;
        }

        public Builder clearEncoding() {
            copyOnWrite();
            ((EcdsaParams) this.instance).clearEncoding();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EcdsaParams$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.EcdsaParams.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new EcdsaParams();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"hashType_", "curve_", "encoding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EcdsaParams> parser = PARSER;
                if (parser == null) {
                    synchronized (EcdsaParams.class) {
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
        EcdsaParams ecdsaParams = new EcdsaParams();
        DEFAULT_INSTANCE = ecdsaParams;
        GeneratedMessageLite.registerDefaultInstance(EcdsaParams.class, ecdsaParams);
    }

    public static EcdsaParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EcdsaParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
