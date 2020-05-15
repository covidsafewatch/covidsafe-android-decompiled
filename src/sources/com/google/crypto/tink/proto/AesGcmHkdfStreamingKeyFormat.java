package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class AesGcmHkdfStreamingKeyFormat extends GeneratedMessageLite<AesGcmHkdfStreamingKeyFormat, Builder> implements AesGcmHkdfStreamingKeyFormatOrBuilder {
    /* access modifiers changed from: private */
    public static final AesGcmHkdfStreamingKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesGcmHkdfStreamingKeyFormat> PARSER;
    private int keySize_;
    private AesGcmHkdfStreamingParams params_;

    private AesGcmHkdfStreamingKeyFormat() {
    }

    public boolean hasParams() {
        return this.params_ != null;
    }

    public AesGcmHkdfStreamingParams getParams() {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = this.params_;
        return aesGcmHkdfStreamingParams == null ? AesGcmHkdfStreamingParams.getDefaultInstance() : aesGcmHkdfStreamingParams;
    }

    /* access modifiers changed from: private */
    public void setParams(AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
        if (aesGcmHkdfStreamingParams != null) {
            this.params_ = aesGcmHkdfStreamingParams;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setParams(AesGcmHkdfStreamingParams.Builder builder) {
        this.params_ = (AesGcmHkdfStreamingParams) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeParams(AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams2 = this.params_;
        if (aesGcmHkdfStreamingParams2 == null || aesGcmHkdfStreamingParams2 == AesGcmHkdfStreamingParams.getDefaultInstance()) {
            this.params_ = aesGcmHkdfStreamingParams;
        } else {
            this.params_ = (AesGcmHkdfStreamingParams) ((AesGcmHkdfStreamingParams.Builder) AesGcmHkdfStreamingParams.newBuilder(this.params_).mergeFrom(aesGcmHkdfStreamingParams)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public int getKeySize() {
        return this.keySize_;
    }

    /* access modifiers changed from: private */
    public void setKeySize(int i) {
        this.keySize_ = i;
    }

    /* access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.params_ != null) {
            codedOutputStream.writeMessage(1, getParams());
        }
        int i = this.keySize_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.params_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getParams());
        }
        int i3 = this.keySize_;
        if (i3 != 0) {
            i2 += CodedOutputStream.computeUInt32Size(2, i3);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesGcmHkdfStreamingKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesGcmHkdfStreamingKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(aesGcmHkdfStreamingKeyFormat);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingKeyFormat, Builder> implements AesGcmHkdfStreamingKeyFormatOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE);
        }

        public boolean hasParams() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).hasParams();
        }

        public AesGcmHkdfStreamingParams getParams() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).getParams();
        }

        public Builder setParams(AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setParams(aesGcmHkdfStreamingParams);
            return this;
        }

        public Builder setParams(AesGcmHkdfStreamingParams.Builder builder) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setParams(builder);
            return this;
        }

        public Builder mergeParams(AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).mergeParams(aesGcmHkdfStreamingParams);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).clearParams();
            return this;
        }

        public int getKeySize() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int i) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setKeySize(i);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AesGcmHkdfStreamingKeyFormat();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat = (AesGcmHkdfStreamingKeyFormat) obj2;
                this.params_ = (AesGcmHkdfStreamingParams) visitor.visitMessage(this.params_, aesGcmHkdfStreamingKeyFormat.params_);
                boolean z2 = this.keySize_ != 0;
                int i = this.keySize_;
                if (aesGcmHkdfStreamingKeyFormat.keySize_ != 0) {
                    z = true;
                }
                this.keySize_ = visitor.visitInt(z2, i, z, aesGcmHkdfStreamingKeyFormat.keySize_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                AesGcmHkdfStreamingParams.Builder builder = this.params_ != null ? (AesGcmHkdfStreamingParams.Builder) this.params_.toBuilder() : null;
                                AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = (AesGcmHkdfStreamingParams) codedInputStream.readMessage(AesGcmHkdfStreamingParams.parser(), extensionRegistryLite);
                                this.params_ = aesGcmHkdfStreamingParams;
                                if (builder != null) {
                                    builder.mergeFrom(aesGcmHkdfStreamingParams);
                                    this.params_ = (AesGcmHkdfStreamingParams) builder.buildPartial();
                                }
                            } else if (readTag == 16) {
                                this.keySize_ = codedInputStream.readUInt32();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (AesGcmHkdfStreamingKeyFormat.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat = new AesGcmHkdfStreamingKeyFormat();
        DEFAULT_INSTANCE = aesGcmHkdfStreamingKeyFormat;
        aesGcmHkdfStreamingKeyFormat.makeImmutable();
    }

    public static AesGcmHkdfStreamingKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmHkdfStreamingKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
