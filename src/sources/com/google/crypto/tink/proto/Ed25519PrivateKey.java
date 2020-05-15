package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class Ed25519PrivateKey extends GeneratedMessageLite<Ed25519PrivateKey, Builder> implements Ed25519PrivateKeyOrBuilder {
    /* access modifiers changed from: private */
    public static final Ed25519PrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Ed25519PrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 3;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private Ed25519PublicKey publicKey_;
    private int version_;

    private Ed25519PrivateKey() {
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

    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* access modifiers changed from: private */
    public void setKeyValue(ByteString byteString) {
        if (byteString != null) {
            this.keyValue_ = byteString;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    public Ed25519PublicKey getPublicKey() {
        Ed25519PublicKey ed25519PublicKey = this.publicKey_;
        return ed25519PublicKey == null ? Ed25519PublicKey.getDefaultInstance() : ed25519PublicKey;
    }

    /* access modifiers changed from: private */
    public void setPublicKey(Ed25519PublicKey ed25519PublicKey) {
        if (ed25519PublicKey != null) {
            this.publicKey_ = ed25519PublicKey;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setPublicKey(Ed25519PublicKey.Builder builder) {
        this.publicKey_ = (Ed25519PublicKey) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergePublicKey(Ed25519PublicKey ed25519PublicKey) {
        Ed25519PublicKey ed25519PublicKey2 = this.publicKey_;
        if (ed25519PublicKey2 == null || ed25519PublicKey2 == Ed25519PublicKey.getDefaultInstance()) {
            this.publicKey_ = ed25519PublicKey;
        } else {
            this.publicKey_ = (Ed25519PublicKey) ((Ed25519PublicKey.Builder) Ed25519PublicKey.newBuilder(this.publicKey_).mergeFrom(ed25519PublicKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.version_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!this.keyValue_.isEmpty()) {
            codedOutputStream.writeBytes(2, this.keyValue_);
        }
        if (this.publicKey_ != null) {
            codedOutputStream.writeMessage(3, getPublicKey());
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
        if (!this.keyValue_.isEmpty()) {
            i2 += CodedOutputStream.computeBytesSize(2, this.keyValue_);
        }
        if (this.publicKey_ != null) {
            i2 += CodedOutputStream.computeMessageSize(3, getPublicKey());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Ed25519PrivateKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Ed25519PrivateKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Ed25519PrivateKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ed25519PrivateKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Ed25519PrivateKey parseFrom(InputStream inputStream) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ed25519PrivateKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Ed25519PrivateKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Ed25519PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ed25519PrivateKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Ed25519PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Ed25519PrivateKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Ed25519PrivateKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Ed25519PrivateKey ed25519PrivateKey) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(ed25519PrivateKey);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519PrivateKey, Builder> implements Ed25519PrivateKeyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Ed25519PrivateKey.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((Ed25519PrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).clearVersion();
            return this;
        }

        public ByteString getKeyValue() {
            return ((Ed25519PrivateKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString byteString) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setKeyValue(byteString);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).clearKeyValue();
            return this;
        }

        public boolean hasPublicKey() {
            return ((Ed25519PrivateKey) this.instance).hasPublicKey();
        }

        public Ed25519PublicKey getPublicKey() {
            return ((Ed25519PrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(Ed25519PublicKey ed25519PublicKey) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setPublicKey(ed25519PublicKey);
            return this;
        }

        public Builder setPublicKey(Ed25519PublicKey.Builder builder) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setPublicKey(builder);
            return this;
        }

        public Builder mergePublicKey(Ed25519PublicKey ed25519PublicKey) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).mergePublicKey(ed25519PublicKey);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).clearPublicKey();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.Ed25519PrivateKey$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.Ed25519PrivateKey.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Ed25519PrivateKey();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder((AnonymousClass1) null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Ed25519PrivateKey ed25519PrivateKey = (Ed25519PrivateKey) obj2;
                this.version_ = visitor.visitInt(this.version_ != 0, this.version_, ed25519PrivateKey.version_ != 0, ed25519PrivateKey.version_);
                boolean z2 = this.keyValue_ != ByteString.EMPTY;
                ByteString byteString = this.keyValue_;
                if (ed25519PrivateKey.keyValue_ != ByteString.EMPTY) {
                    z = true;
                }
                this.keyValue_ = visitor.visitByteString(z2, byteString, z, ed25519PrivateKey.keyValue_);
                this.publicKey_ = (Ed25519PublicKey) visitor.visitMessage(this.publicKey_, ed25519PrivateKey.publicKey_);
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
                                this.keyValue_ = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                Ed25519PublicKey.Builder builder = this.publicKey_ != null ? (Ed25519PublicKey.Builder) this.publicKey_.toBuilder() : null;
                                Ed25519PublicKey ed25519PublicKey = (Ed25519PublicKey) codedInputStream.readMessage(Ed25519PublicKey.parser(), extensionRegistryLite);
                                this.publicKey_ = ed25519PublicKey;
                                if (builder != null) {
                                    builder.mergeFrom(ed25519PublicKey);
                                    this.publicKey_ = (Ed25519PublicKey) builder.buildPartial();
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
                    synchronized (Ed25519PrivateKey.class) {
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
        Ed25519PrivateKey ed25519PrivateKey = new Ed25519PrivateKey();
        DEFAULT_INSTANCE = ed25519PrivateKey;
        ed25519PrivateKey.makeImmutable();
    }

    public static Ed25519PrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Ed25519PrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
