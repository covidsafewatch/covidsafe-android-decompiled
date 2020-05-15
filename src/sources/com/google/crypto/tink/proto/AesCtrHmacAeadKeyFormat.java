package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class AesCtrHmacAeadKeyFormat extends GeneratedMessageLite<AesCtrHmacAeadKeyFormat, Builder> implements AesCtrHmacAeadKeyFormatOrBuilder {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final AesCtrHmacAeadKeyFormat DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrHmacAeadKeyFormat> PARSER;
    private AesCtrKeyFormat aesCtrKeyFormat_;
    private HmacKeyFormat hmacKeyFormat_;

    private AesCtrHmacAeadKeyFormat() {
    }

    public boolean hasAesCtrKeyFormat() {
        return this.aesCtrKeyFormat_ != null;
    }

    public AesCtrKeyFormat getAesCtrKeyFormat() {
        AesCtrKeyFormat aesCtrKeyFormat = this.aesCtrKeyFormat_;
        return aesCtrKeyFormat == null ? AesCtrKeyFormat.getDefaultInstance() : aesCtrKeyFormat;
    }

    /* access modifiers changed from: private */
    public void setAesCtrKeyFormat(AesCtrKeyFormat aesCtrKeyFormat) {
        if (aesCtrKeyFormat != null) {
            this.aesCtrKeyFormat_ = aesCtrKeyFormat;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setAesCtrKeyFormat(AesCtrKeyFormat.Builder builder) {
        this.aesCtrKeyFormat_ = (AesCtrKeyFormat) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeAesCtrKeyFormat(AesCtrKeyFormat aesCtrKeyFormat) {
        AesCtrKeyFormat aesCtrKeyFormat2 = this.aesCtrKeyFormat_;
        if (aesCtrKeyFormat2 == null || aesCtrKeyFormat2 == AesCtrKeyFormat.getDefaultInstance()) {
            this.aesCtrKeyFormat_ = aesCtrKeyFormat;
        } else {
            this.aesCtrKeyFormat_ = (AesCtrKeyFormat) ((AesCtrKeyFormat.Builder) AesCtrKeyFormat.newBuilder(this.aesCtrKeyFormat_).mergeFrom(aesCtrKeyFormat)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAesCtrKeyFormat() {
        this.aesCtrKeyFormat_ = null;
    }

    public boolean hasHmacKeyFormat() {
        return this.hmacKeyFormat_ != null;
    }

    public HmacKeyFormat getHmacKeyFormat() {
        HmacKeyFormat hmacKeyFormat = this.hmacKeyFormat_;
        return hmacKeyFormat == null ? HmacKeyFormat.getDefaultInstance() : hmacKeyFormat;
    }

    /* access modifiers changed from: private */
    public void setHmacKeyFormat(HmacKeyFormat hmacKeyFormat) {
        if (hmacKeyFormat != null) {
            this.hmacKeyFormat_ = hmacKeyFormat;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setHmacKeyFormat(HmacKeyFormat.Builder builder) {
        this.hmacKeyFormat_ = (HmacKeyFormat) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeHmacKeyFormat(HmacKeyFormat hmacKeyFormat) {
        HmacKeyFormat hmacKeyFormat2 = this.hmacKeyFormat_;
        if (hmacKeyFormat2 == null || hmacKeyFormat2 == HmacKeyFormat.getDefaultInstance()) {
            this.hmacKeyFormat_ = hmacKeyFormat;
        } else {
            this.hmacKeyFormat_ = (HmacKeyFormat) ((HmacKeyFormat.Builder) HmacKeyFormat.newBuilder(this.hmacKeyFormat_).mergeFrom(hmacKeyFormat)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearHmacKeyFormat() {
        this.hmacKeyFormat_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.aesCtrKeyFormat_ != null) {
            codedOutputStream.writeMessage(1, getAesCtrKeyFormat());
        }
        if (this.hmacKeyFormat_ != null) {
            codedOutputStream.writeMessage(2, getHmacKeyFormat());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.aesCtrKeyFormat_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getAesCtrKeyFormat());
        }
        if (this.hmacKeyFormat_ != null) {
            i2 += CodedOutputStream.computeMessageSize(2, getHmacKeyFormat());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AesCtrHmacAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacAeadKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(aesCtrHmacAeadKeyFormat);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKeyFormat, Builder> implements AesCtrHmacAeadKeyFormatOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE);
        }

        public boolean hasAesCtrKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).hasAesCtrKeyFormat();
        }

        public AesCtrKeyFormat getAesCtrKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).getAesCtrKeyFormat();
        }

        public Builder setAesCtrKeyFormat(AesCtrKeyFormat aesCtrKeyFormat) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setAesCtrKeyFormat(aesCtrKeyFormat);
            return this;
        }

        public Builder setAesCtrKeyFormat(AesCtrKeyFormat.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setAesCtrKeyFormat(builder);
            return this;
        }

        public Builder mergeAesCtrKeyFormat(AesCtrKeyFormat aesCtrKeyFormat) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).mergeAesCtrKeyFormat(aesCtrKeyFormat);
            return this;
        }

        public Builder clearAesCtrKeyFormat() {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).clearAesCtrKeyFormat();
            return this;
        }

        public boolean hasHmacKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).hasHmacKeyFormat();
        }

        public HmacKeyFormat getHmacKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).getHmacKeyFormat();
        }

        public Builder setHmacKeyFormat(HmacKeyFormat hmacKeyFormat) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setHmacKeyFormat(hmacKeyFormat);
            return this;
        }

        public Builder setHmacKeyFormat(HmacKeyFormat.Builder builder) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setHmacKeyFormat(builder);
            return this;
        }

        public Builder mergeHmacKeyFormat(HmacKeyFormat hmacKeyFormat) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).mergeHmacKeyFormat(hmacKeyFormat);
            return this;
        }

        public Builder clearHmacKeyFormat() {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).clearHmacKeyFormat();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AesCtrHmacAeadKeyFormat();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = (AesCtrHmacAeadKeyFormat) obj2;
                this.aesCtrKeyFormat_ = (AesCtrKeyFormat) visitor.visitMessage(this.aesCtrKeyFormat_, aesCtrHmacAeadKeyFormat.aesCtrKeyFormat_);
                this.hmacKeyFormat_ = (HmacKeyFormat) visitor.visitMessage(this.hmacKeyFormat_, aesCtrHmacAeadKeyFormat.hmacKeyFormat_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                AesCtrKeyFormat.Builder builder = this.aesCtrKeyFormat_ != null ? (AesCtrKeyFormat.Builder) this.aesCtrKeyFormat_.toBuilder() : null;
                                AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) codedInputStream.readMessage(AesCtrKeyFormat.parser(), extensionRegistryLite);
                                this.aesCtrKeyFormat_ = aesCtrKeyFormat;
                                if (builder != null) {
                                    builder.mergeFrom(aesCtrKeyFormat);
                                    this.aesCtrKeyFormat_ = (AesCtrKeyFormat) builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                HmacKeyFormat.Builder builder2 = this.hmacKeyFormat_ != null ? (HmacKeyFormat.Builder) this.hmacKeyFormat_.toBuilder() : null;
                                HmacKeyFormat hmacKeyFormat = (HmacKeyFormat) codedInputStream.readMessage(HmacKeyFormat.parser(), extensionRegistryLite);
                                this.hmacKeyFormat_ = hmacKeyFormat;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hmacKeyFormat);
                                    this.hmacKeyFormat_ = (HmacKeyFormat) builder2.buildPartial();
                                }
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
                    synchronized (AesCtrHmacAeadKeyFormat.class) {
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
        AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = new AesCtrHmacAeadKeyFormat();
        DEFAULT_INSTANCE = aesCtrHmacAeadKeyFormat;
        aesCtrHmacAeadKeyFormat.makeImmutable();
    }

    public static AesCtrHmacAeadKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacAeadKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
