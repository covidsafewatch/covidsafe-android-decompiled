package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class KmsEnvelopeAeadKey extends GeneratedMessageLite<KmsEnvelopeAeadKey, Builder> implements KmsEnvelopeAeadKeyOrBuilder {
    /* access modifiers changed from: private */
    public static final KmsEnvelopeAeadKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<KmsEnvelopeAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private KmsEnvelopeAeadKeyFormat params_;
    private int version_;

    private KmsEnvelopeAeadKey() {
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

    public boolean hasParams() {
        return this.params_ != null;
    }

    public KmsEnvelopeAeadKeyFormat getParams() {
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = this.params_;
        return kmsEnvelopeAeadKeyFormat == null ? KmsEnvelopeAeadKeyFormat.getDefaultInstance() : kmsEnvelopeAeadKeyFormat;
    }

    /* access modifiers changed from: private */
    public void setParams(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
        if (kmsEnvelopeAeadKeyFormat != null) {
            this.params_ = kmsEnvelopeAeadKeyFormat;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setParams(KmsEnvelopeAeadKeyFormat.Builder builder) {
        this.params_ = (KmsEnvelopeAeadKeyFormat) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeParams(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat2 = this.params_;
        if (kmsEnvelopeAeadKeyFormat2 == null || kmsEnvelopeAeadKeyFormat2 == KmsEnvelopeAeadKeyFormat.getDefaultInstance()) {
            this.params_ = kmsEnvelopeAeadKeyFormat;
        } else {
            this.params_ = (KmsEnvelopeAeadKeyFormat) ((KmsEnvelopeAeadKeyFormat.Builder) KmsEnvelopeAeadKeyFormat.newBuilder(this.params_).mergeFrom(kmsEnvelopeAeadKeyFormat)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.version_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (this.params_ != null) {
            codedOutputStream.writeMessage(2, getParams());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.version_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        if (this.params_ != null) {
            i2 += CodedOutputStream.computeMessageSize(2, getParams());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static KmsEnvelopeAeadKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static KmsEnvelopeAeadKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KmsEnvelopeAeadKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKey parseFrom(InputStream inputStream) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KmsEnvelopeAeadKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (KmsEnvelopeAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KmsEnvelopeAeadKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KmsEnvelopeAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static KmsEnvelopeAeadKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(kmsEnvelopeAeadKey);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KmsEnvelopeAeadKey, Builder> implements KmsEnvelopeAeadKeyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(KmsEnvelopeAeadKey.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((KmsEnvelopeAeadKey) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).clearVersion();
            return this;
        }

        public boolean hasParams() {
            return ((KmsEnvelopeAeadKey) this.instance).hasParams();
        }

        public KmsEnvelopeAeadKeyFormat getParams() {
            return ((KmsEnvelopeAeadKey) this.instance).getParams();
        }

        public Builder setParams(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).setParams(kmsEnvelopeAeadKeyFormat);
            return this;
        }

        public Builder setParams(KmsEnvelopeAeadKeyFormat.Builder builder) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).setParams(builder);
            return this;
        }

        public Builder mergeParams(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).mergeParams(kmsEnvelopeAeadKeyFormat);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KmsEnvelopeAeadKey$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.KmsEnvelopeAeadKey.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new KmsEnvelopeAeadKey();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                KmsEnvelopeAeadKey kmsEnvelopeAeadKey = (KmsEnvelopeAeadKey) obj2;
                boolean z2 = this.version_ != 0;
                int i = this.version_;
                if (kmsEnvelopeAeadKey.version_ != 0) {
                    z = true;
                }
                this.version_ = visitor.visitInt(z2, i, z, kmsEnvelopeAeadKey.version_);
                this.params_ = (KmsEnvelopeAeadKeyFormat) visitor.visitMessage(this.params_, kmsEnvelopeAeadKey.params_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.version_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                KmsEnvelopeAeadKeyFormat.Builder builder = this.params_ != null ? (KmsEnvelopeAeadKeyFormat.Builder) this.params_.toBuilder() : null;
                                KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = (KmsEnvelopeAeadKeyFormat) codedInputStream.readMessage(KmsEnvelopeAeadKeyFormat.parser(), extensionRegistryLite);
                                this.params_ = kmsEnvelopeAeadKeyFormat;
                                if (builder != null) {
                                    builder.mergeFrom(kmsEnvelopeAeadKeyFormat);
                                    this.params_ = (KmsEnvelopeAeadKeyFormat) builder.buildPartial();
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
                    synchronized (KmsEnvelopeAeadKey.class) {
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
        KmsEnvelopeAeadKey kmsEnvelopeAeadKey = new KmsEnvelopeAeadKey();
        DEFAULT_INSTANCE = kmsEnvelopeAeadKey;
        kmsEnvelopeAeadKey.makeImmutable();
    }

    public static KmsEnvelopeAeadKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KmsEnvelopeAeadKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
