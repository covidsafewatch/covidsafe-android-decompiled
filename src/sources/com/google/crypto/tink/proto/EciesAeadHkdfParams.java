package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class EciesAeadHkdfParams extends GeneratedMessageLite<EciesAeadHkdfParams, Builder> implements EciesAeadHkdfParamsOrBuilder {
    /* access modifiers changed from: private */
    public static final EciesAeadHkdfParams DEFAULT_INSTANCE;
    public static final int DEM_PARAMS_FIELD_NUMBER = 2;
    public static final int EC_POINT_FORMAT_FIELD_NUMBER = 3;
    public static final int KEM_PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<EciesAeadHkdfParams> PARSER;
    private EciesAeadDemParams demParams_;
    private int ecPointFormat_;
    private EciesHkdfKemParams kemParams_;

    private EciesAeadHkdfParams() {
    }

    public boolean hasKemParams() {
        return this.kemParams_ != null;
    }

    public EciesHkdfKemParams getKemParams() {
        EciesHkdfKemParams eciesHkdfKemParams = this.kemParams_;
        return eciesHkdfKemParams == null ? EciesHkdfKemParams.getDefaultInstance() : eciesHkdfKemParams;
    }

    /* access modifiers changed from: private */
    public void setKemParams(EciesHkdfKemParams eciesHkdfKemParams) {
        eciesHkdfKemParams.getClass();
        this.kemParams_ = eciesHkdfKemParams;
    }

    /* access modifiers changed from: private */
    public void mergeKemParams(EciesHkdfKemParams eciesHkdfKemParams) {
        eciesHkdfKemParams.getClass();
        EciesHkdfKemParams eciesHkdfKemParams2 = this.kemParams_;
        if (eciesHkdfKemParams2 == null || eciesHkdfKemParams2 == EciesHkdfKemParams.getDefaultInstance()) {
            this.kemParams_ = eciesHkdfKemParams;
        } else {
            this.kemParams_ = (EciesHkdfKemParams) ((EciesHkdfKemParams.Builder) EciesHkdfKemParams.newBuilder(this.kemParams_).mergeFrom(eciesHkdfKemParams)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearKemParams() {
        this.kemParams_ = null;
    }

    public boolean hasDemParams() {
        return this.demParams_ != null;
    }

    public EciesAeadDemParams getDemParams() {
        EciesAeadDemParams eciesAeadDemParams = this.demParams_;
        return eciesAeadDemParams == null ? EciesAeadDemParams.getDefaultInstance() : eciesAeadDemParams;
    }

    /* access modifiers changed from: private */
    public void setDemParams(EciesAeadDemParams eciesAeadDemParams) {
        eciesAeadDemParams.getClass();
        this.demParams_ = eciesAeadDemParams;
    }

    /* access modifiers changed from: private */
    public void mergeDemParams(EciesAeadDemParams eciesAeadDemParams) {
        eciesAeadDemParams.getClass();
        EciesAeadDemParams eciesAeadDemParams2 = this.demParams_;
        if (eciesAeadDemParams2 == null || eciesAeadDemParams2 == EciesAeadDemParams.getDefaultInstance()) {
            this.demParams_ = eciesAeadDemParams;
        } else {
            this.demParams_ = (EciesAeadDemParams) ((EciesAeadDemParams.Builder) EciesAeadDemParams.newBuilder(this.demParams_).mergeFrom(eciesAeadDemParams)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDemParams() {
        this.demParams_ = null;
    }

    public int getEcPointFormatValue() {
        return this.ecPointFormat_;
    }

    public EcPointFormat getEcPointFormat() {
        EcPointFormat forNumber = EcPointFormat.forNumber(this.ecPointFormat_);
        return forNumber == null ? EcPointFormat.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setEcPointFormatValue(int i) {
        this.ecPointFormat_ = i;
    }

    /* access modifiers changed from: private */
    public void setEcPointFormat(EcPointFormat ecPointFormat) {
        this.ecPointFormat_ = ecPointFormat.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearEcPointFormat() {
        this.ecPointFormat_ = 0;
    }

    public static EciesAeadHkdfParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static EciesAeadHkdfParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EciesAeadHkdfParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EciesAeadHkdfParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EciesAeadHkdfParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EciesAeadHkdfParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EciesAeadHkdfParams parseFrom(InputStream inputStream) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EciesAeadHkdfParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EciesAeadHkdfParams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EciesAeadHkdfParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EciesAeadHkdfParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EciesAeadHkdfParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EciesAeadHkdfParams parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EciesAeadHkdfParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesAeadHkdfParams eciesAeadHkdfParams) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(eciesAeadHkdfParams);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfParams, Builder> implements EciesAeadHkdfParamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(EciesAeadHkdfParams.DEFAULT_INSTANCE);
        }

        public boolean hasKemParams() {
            return ((EciesAeadHkdfParams) this.instance).hasKemParams();
        }

        public EciesHkdfKemParams getKemParams() {
            return ((EciesAeadHkdfParams) this.instance).getKemParams();
        }

        public Builder setKemParams(EciesHkdfKemParams eciesHkdfKemParams) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setKemParams(eciesHkdfKemParams);
            return this;
        }

        public Builder setKemParams(EciesHkdfKemParams.Builder builder) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setKemParams((EciesHkdfKemParams) builder.build());
            return this;
        }

        public Builder mergeKemParams(EciesHkdfKemParams eciesHkdfKemParams) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).mergeKemParams(eciesHkdfKemParams);
            return this;
        }

        public Builder clearKemParams() {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).clearKemParams();
            return this;
        }

        public boolean hasDemParams() {
            return ((EciesAeadHkdfParams) this.instance).hasDemParams();
        }

        public EciesAeadDemParams getDemParams() {
            return ((EciesAeadHkdfParams) this.instance).getDemParams();
        }

        public Builder setDemParams(EciesAeadDemParams eciesAeadDemParams) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setDemParams(eciesAeadDemParams);
            return this;
        }

        public Builder setDemParams(EciesAeadDemParams.Builder builder) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setDemParams((EciesAeadDemParams) builder.build());
            return this;
        }

        public Builder mergeDemParams(EciesAeadDemParams eciesAeadDemParams) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).mergeDemParams(eciesAeadDemParams);
            return this;
        }

        public Builder clearDemParams() {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).clearDemParams();
            return this;
        }

        public int getEcPointFormatValue() {
            return ((EciesAeadHkdfParams) this.instance).getEcPointFormatValue();
        }

        public Builder setEcPointFormatValue(int i) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setEcPointFormatValue(i);
            return this;
        }

        public EcPointFormat getEcPointFormat() {
            return ((EciesAeadHkdfParams) this.instance).getEcPointFormat();
        }

        public Builder setEcPointFormat(EcPointFormat ecPointFormat) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setEcPointFormat(ecPointFormat);
            return this;
        }

        public Builder clearEcPointFormat() {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).clearEcPointFormat();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfParams$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.EciesAeadHkdfParams.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new EciesAeadHkdfParams();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"kemParams_", "demParams_", "ecPointFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesAeadHkdfParams> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesAeadHkdfParams.class) {
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
        EciesAeadHkdfParams eciesAeadHkdfParams = new EciesAeadHkdfParams();
        DEFAULT_INSTANCE = eciesAeadHkdfParams;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadHkdfParams.class, eciesAeadHkdfParams);
    }

    public static EciesAeadHkdfParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesAeadHkdfParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
