package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class RsaSsaPkcs1PrivateKey extends GeneratedMessageLite<RsaSsaPkcs1PrivateKey, Builder> implements RsaSsaPkcs1PrivateKeyOrBuilder {
    public static final int CRT_FIELD_NUMBER = 8;
    /* access modifiers changed from: private */
    public static final RsaSsaPkcs1PrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    private static volatile Parser<RsaSsaPkcs1PrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString crt_ = ByteString.EMPTY;
    private ByteString d_ = ByteString.EMPTY;
    private ByteString dp_ = ByteString.EMPTY;
    private ByteString dq_ = ByteString.EMPTY;
    private ByteString p_ = ByteString.EMPTY;
    private RsaSsaPkcs1PublicKey publicKey_;
    private ByteString q_ = ByteString.EMPTY;
    private int version_;

    private RsaSsaPkcs1PrivateKey() {
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

    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    public RsaSsaPkcs1PublicKey getPublicKey() {
        RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey = this.publicKey_;
        return rsaSsaPkcs1PublicKey == null ? RsaSsaPkcs1PublicKey.getDefaultInstance() : rsaSsaPkcs1PublicKey;
    }

    /* access modifiers changed from: private */
    public void setPublicKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) {
        rsaSsaPkcs1PublicKey.getClass();
        this.publicKey_ = rsaSsaPkcs1PublicKey;
    }

    /* access modifiers changed from: private */
    public void mergePublicKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) {
        rsaSsaPkcs1PublicKey.getClass();
        RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey2 = this.publicKey_;
        if (rsaSsaPkcs1PublicKey2 == null || rsaSsaPkcs1PublicKey2 == RsaSsaPkcs1PublicKey.getDefaultInstance()) {
            this.publicKey_ = rsaSsaPkcs1PublicKey;
        } else {
            this.publicKey_ = (RsaSsaPkcs1PublicKey) ((RsaSsaPkcs1PublicKey.Builder) RsaSsaPkcs1PublicKey.newBuilder(this.publicKey_).mergeFrom(rsaSsaPkcs1PublicKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    public ByteString getD() {
        return this.d_;
    }

    /* access modifiers changed from: private */
    public void setD(ByteString byteString) {
        byteString.getClass();
        this.d_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearD() {
        this.d_ = getDefaultInstance().getD();
    }

    public ByteString getP() {
        return this.p_;
    }

    /* access modifiers changed from: private */
    public void setP(ByteString byteString) {
        byteString.getClass();
        this.p_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearP() {
        this.p_ = getDefaultInstance().getP();
    }

    public ByteString getQ() {
        return this.q_;
    }

    /* access modifiers changed from: private */
    public void setQ(ByteString byteString) {
        byteString.getClass();
        this.q_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearQ() {
        this.q_ = getDefaultInstance().getQ();
    }

    public ByteString getDp() {
        return this.dp_;
    }

    /* access modifiers changed from: private */
    public void setDp(ByteString byteString) {
        byteString.getClass();
        this.dp_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearDp() {
        this.dp_ = getDefaultInstance().getDp();
    }

    public ByteString getDq() {
        return this.dq_;
    }

    /* access modifiers changed from: private */
    public void setDq(ByteString byteString) {
        byteString.getClass();
        this.dq_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearDq() {
        this.dq_ = getDefaultInstance().getDq();
    }

    public ByteString getCrt() {
        return this.crt_;
    }

    /* access modifiers changed from: private */
    public void setCrt(ByteString byteString) {
        byteString.getClass();
        this.crt_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearCrt() {
        this.crt_ = getDefaultInstance().getCrt();
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(InputStream inputStream) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPkcs1PrivateKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RsaSsaPkcs1PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPkcs1PrivateKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPkcs1PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(rsaSsaPkcs1PrivateKey);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1PrivateKey, Builder> implements RsaSsaPkcs1PrivateKeyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearVersion();
            return this;
        }

        public boolean hasPublicKey() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).hasPublicKey();
        }

        public RsaSsaPkcs1PublicKey getPublicKey() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setPublicKey(rsaSsaPkcs1PublicKey);
            return this;
        }

        public Builder setPublicKey(RsaSsaPkcs1PublicKey.Builder builder) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setPublicKey((RsaSsaPkcs1PublicKey) builder.build());
            return this;
        }

        public Builder mergePublicKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).mergePublicKey(rsaSsaPkcs1PublicKey);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearPublicKey();
            return this;
        }

        public ByteString getD() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getD();
        }

        public Builder setD(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setD(byteString);
            return this;
        }

        public Builder clearD() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearD();
            return this;
        }

        public ByteString getP() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getP();
        }

        public Builder setP(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setP(byteString);
            return this;
        }

        public Builder clearP() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearP();
            return this;
        }

        public ByteString getQ() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getQ();
        }

        public Builder setQ(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setQ(byteString);
            return this;
        }

        public Builder clearQ() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearQ();
            return this;
        }

        public ByteString getDp() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getDp();
        }

        public Builder setDp(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setDp(byteString);
            return this;
        }

        public Builder clearDp() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearDp();
            return this;
        }

        public ByteString getDq() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getDq();
        }

        public Builder setDq(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setDq(byteString);
            return this;
        }

        public Builder clearDq() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearDq();
            return this;
        }

        public ByteString getCrt() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getCrt();
        }

        public Builder setCrt(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setCrt(byteString);
            return this;
        }

        public Builder clearCrt() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearCrt();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RsaSsaPkcs1PrivateKey();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPkcs1PrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPkcs1PrivateKey.class) {
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
        RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey = new RsaSsaPkcs1PrivateKey();
        DEFAULT_INSTANCE = rsaSsaPkcs1PrivateKey;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPkcs1PrivateKey.class, rsaSsaPkcs1PrivateKey);
    }

    public static RsaSsaPkcs1PrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPkcs1PrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
