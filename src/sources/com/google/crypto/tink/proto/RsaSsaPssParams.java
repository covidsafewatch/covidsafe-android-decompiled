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

public final class RsaSsaPssParams extends GeneratedMessageLite<RsaSsaPssParams, Builder> implements RsaSsaPssParamsOrBuilder {
    /* access modifiers changed from: private */
    public static final RsaSsaPssParams DEFAULT_INSTANCE;
    public static final int MGF1_HASH_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPssParams> PARSER = null;
    public static final int SALT_LENGTH_FIELD_NUMBER = 3;
    public static final int SIG_HASH_FIELD_NUMBER = 1;
    private int mgf1Hash_;
    private int saltLength_;
    private int sigHash_;

    private RsaSsaPssParams() {
    }

    public int getSigHashValue() {
        return this.sigHash_;
    }

    public HashType getSigHash() {
        HashType forNumber = HashType.forNumber(this.sigHash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setSigHashValue(int i) {
        this.sigHash_ = i;
    }

    /* access modifiers changed from: private */
    public void setSigHash(HashType hashType) {
        this.sigHash_ = hashType.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearSigHash() {
        this.sigHash_ = 0;
    }

    public int getMgf1HashValue() {
        return this.mgf1Hash_;
    }

    public HashType getMgf1Hash() {
        HashType forNumber = HashType.forNumber(this.mgf1Hash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setMgf1HashValue(int i) {
        this.mgf1Hash_ = i;
    }

    /* access modifiers changed from: private */
    public void setMgf1Hash(HashType hashType) {
        this.mgf1Hash_ = hashType.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearMgf1Hash() {
        this.mgf1Hash_ = 0;
    }

    public int getSaltLength() {
        return this.saltLength_;
    }

    /* access modifiers changed from: private */
    public void setSaltLength(int i) {
        this.saltLength_ = i;
    }

    /* access modifiers changed from: private */
    public void clearSaltLength() {
        this.saltLength_ = 0;
    }

    public static RsaSsaPssParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static RsaSsaPssParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RsaSsaPssParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RsaSsaPssParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RsaSsaPssParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RsaSsaPssParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RsaSsaPssParams parseFrom(InputStream inputStream) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssParams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RsaSsaPssParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPssParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssParams parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RsaSsaPssParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPssParams rsaSsaPssParams) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(rsaSsaPssParams);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssParams, Builder> implements RsaSsaPssParamsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(RsaSsaPssParams.DEFAULT_INSTANCE);
        }

        public int getSigHashValue() {
            return ((RsaSsaPssParams) this.instance).getSigHashValue();
        }

        public Builder setSigHashValue(int i) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setSigHashValue(i);
            return this;
        }

        public HashType getSigHash() {
            return ((RsaSsaPssParams) this.instance).getSigHash();
        }

        public Builder setSigHash(HashType hashType) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setSigHash(hashType);
            return this;
        }

        public Builder clearSigHash() {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).clearSigHash();
            return this;
        }

        public int getMgf1HashValue() {
            return ((RsaSsaPssParams) this.instance).getMgf1HashValue();
        }

        public Builder setMgf1HashValue(int i) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setMgf1HashValue(i);
            return this;
        }

        public HashType getMgf1Hash() {
            return ((RsaSsaPssParams) this.instance).getMgf1Hash();
        }

        public Builder setMgf1Hash(HashType hashType) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setMgf1Hash(hashType);
            return this;
        }

        public Builder clearMgf1Hash() {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).clearMgf1Hash();
            return this;
        }

        public int getSaltLength() {
            return ((RsaSsaPssParams) this.instance).getSaltLength();
        }

        public Builder setSaltLength(int i) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setSaltLength(i);
            return this;
        }

        public Builder clearSaltLength() {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).clearSaltLength();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssParams$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.RsaSsaPssParams.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RsaSsaPssParams();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"sigHash_", "mgf1Hash_", "saltLength_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPssParams> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPssParams.class) {
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
        RsaSsaPssParams rsaSsaPssParams = new RsaSsaPssParams();
        DEFAULT_INSTANCE = rsaSsaPssParams;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssParams.class, rsaSsaPssParams);
    }

    public static RsaSsaPssParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPssParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
