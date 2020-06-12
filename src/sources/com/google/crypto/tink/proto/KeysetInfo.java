package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class KeysetInfo extends GeneratedMessageLite<KeysetInfo, Builder> implements KeysetInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final KeysetInfo DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile Parser<KeysetInfo> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<KeyInfo> keyInfo_ = emptyProtobufList();
    private int primaryKeyId_;

    public interface KeyInfoOrBuilder extends MessageLiteOrBuilder {
        int getKeyId();

        OutputPrefixType getOutputPrefixType();

        int getOutputPrefixTypeValue();

        KeyStatusType getStatus();

        int getStatusValue();

        String getTypeUrl();

        ByteString getTypeUrlBytes();
    }

    private KeysetInfo() {
    }

    public static final class KeyInfo extends GeneratedMessageLite<KeyInfo, Builder> implements KeyInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final KeyInfo DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<KeyInfo> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;
        private String typeUrl_ = "";

        private KeyInfo() {
        }

        public String getTypeUrl() {
            return this.typeUrl_;
        }

        public ByteString getTypeUrlBytes() {
            return ByteString.copyFromUtf8(this.typeUrl_);
        }

        /* access modifiers changed from: private */
        public void setTypeUrl(String str) {
            str.getClass();
            this.typeUrl_ = str;
        }

        /* access modifiers changed from: private */
        public void clearTypeUrl() {
            this.typeUrl_ = getDefaultInstance().getTypeUrl();
        }

        /* access modifiers changed from: private */
        public void setTypeUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.typeUrl_ = byteString.toStringUtf8();
        }

        public int getStatusValue() {
            return this.status_;
        }

        public KeyStatusType getStatus() {
            KeyStatusType forNumber = KeyStatusType.forNumber(this.status_);
            return forNumber == null ? KeyStatusType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setStatusValue(int i) {
            this.status_ = i;
        }

        /* access modifiers changed from: private */
        public void setStatus(KeyStatusType keyStatusType) {
            this.status_ = keyStatusType.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        public int getKeyId() {
            return this.keyId_;
        }

        /* access modifiers changed from: private */
        public void setKeyId(int i) {
            this.keyId_ = i;
        }

        /* access modifiers changed from: private */
        public void clearKeyId() {
            this.keyId_ = 0;
        }

        public int getOutputPrefixTypeValue() {
            return this.outputPrefixType_;
        }

        public OutputPrefixType getOutputPrefixType() {
            OutputPrefixType forNumber = OutputPrefixType.forNumber(this.outputPrefixType_);
            return forNumber == null ? OutputPrefixType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setOutputPrefixTypeValue(int i) {
            this.outputPrefixType_ = i;
        }

        /* access modifiers changed from: private */
        public void setOutputPrefixType(OutputPrefixType outputPrefixType) {
            this.outputPrefixType_ = outputPrefixType.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearOutputPrefixType() {
            this.outputPrefixType_ = 0;
        }

        public static KeyInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KeyInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static KeyInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KeyInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static KeyInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static KeyInfo parseFrom(InputStream inputStream) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (KeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static KeyInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(KeyInfo keyInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(keyInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<KeyInfo, Builder> implements KeyInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(KeyInfo.DEFAULT_INSTANCE);
            }

            public String getTypeUrl() {
                return ((KeyInfo) this.instance).getTypeUrl();
            }

            public ByteString getTypeUrlBytes() {
                return ((KeyInfo) this.instance).getTypeUrlBytes();
            }

            public Builder setTypeUrl(String str) {
                copyOnWrite();
                ((KeyInfo) this.instance).setTypeUrl(str);
                return this;
            }

            public Builder clearTypeUrl() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearTypeUrl();
                return this;
            }

            public Builder setTypeUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyInfo) this.instance).setTypeUrlBytes(byteString);
                return this;
            }

            public int getStatusValue() {
                return ((KeyInfo) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((KeyInfo) this.instance).setStatusValue(i);
                return this;
            }

            public KeyStatusType getStatus() {
                return ((KeyInfo) this.instance).getStatus();
            }

            public Builder setStatus(KeyStatusType keyStatusType) {
                copyOnWrite();
                ((KeyInfo) this.instance).setStatus(keyStatusType);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearStatus();
                return this;
            }

            public int getKeyId() {
                return ((KeyInfo) this.instance).getKeyId();
            }

            public Builder setKeyId(int i) {
                copyOnWrite();
                ((KeyInfo) this.instance).setKeyId(i);
                return this;
            }

            public Builder clearKeyId() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearKeyId();
                return this;
            }

            public int getOutputPrefixTypeValue() {
                return ((KeyInfo) this.instance).getOutputPrefixTypeValue();
            }

            public Builder setOutputPrefixTypeValue(int i) {
                copyOnWrite();
                ((KeyInfo) this.instance).setOutputPrefixTypeValue(i);
                return this;
            }

            public OutputPrefixType getOutputPrefixType() {
                return ((KeyInfo) this.instance).getOutputPrefixType();
            }

            public Builder setOutputPrefixType(OutputPrefixType outputPrefixType) {
                copyOnWrite();
                ((KeyInfo) this.instance).setOutputPrefixType(outputPrefixType);
                return this;
            }

            public Builder clearOutputPrefixType() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearOutputPrefixType();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new KeyInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<KeyInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (KeyInfo.class) {
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
            KeyInfo keyInfo = new KeyInfo();
            DEFAULT_INSTANCE = keyInfo;
            GeneratedMessageLite.registerDefaultInstance(KeyInfo.class, keyInfo);
        }

        public static KeyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<KeyInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KeysetInfo$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.KeysetInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public int getPrimaryKeyId() {
        return this.primaryKeyId_;
    }

    /* access modifiers changed from: private */
    public void setPrimaryKeyId(int i) {
        this.primaryKeyId_ = i;
    }

    /* access modifiers changed from: private */
    public void clearPrimaryKeyId() {
        this.primaryKeyId_ = 0;
    }

    public List<KeyInfo> getKeyInfoList() {
        return this.keyInfo_;
    }

    public List<? extends KeyInfoOrBuilder> getKeyInfoOrBuilderList() {
        return this.keyInfo_;
    }

    public int getKeyInfoCount() {
        return this.keyInfo_.size();
    }

    public KeyInfo getKeyInfo(int i) {
        return (KeyInfo) this.keyInfo_.get(i);
    }

    public KeyInfoOrBuilder getKeyInfoOrBuilder(int i) {
        return (KeyInfoOrBuilder) this.keyInfo_.get(i);
    }

    private void ensureKeyInfoIsMutable() {
        if (!this.keyInfo_.isModifiable()) {
            this.keyInfo_ = GeneratedMessageLite.mutableCopy(this.keyInfo_);
        }
    }

    /* access modifiers changed from: private */
    public void setKeyInfo(int i, KeyInfo keyInfo) {
        keyInfo.getClass();
        ensureKeyInfoIsMutable();
        this.keyInfo_.set(i, keyInfo);
    }

    /* access modifiers changed from: private */
    public void addKeyInfo(KeyInfo keyInfo) {
        keyInfo.getClass();
        ensureKeyInfoIsMutable();
        this.keyInfo_.add(keyInfo);
    }

    /* access modifiers changed from: private */
    public void addKeyInfo(int i, KeyInfo keyInfo) {
        keyInfo.getClass();
        ensureKeyInfoIsMutable();
        this.keyInfo_.add(i, keyInfo);
    }

    /* access modifiers changed from: private */
    public void addAllKeyInfo(Iterable<? extends KeyInfo> iterable) {
        ensureKeyInfoIsMutable();
        AbstractMessageLite.addAll(iterable, this.keyInfo_);
    }

    /* access modifiers changed from: private */
    public void clearKeyInfo() {
        this.keyInfo_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeKeyInfo(int i) {
        ensureKeyInfoIsMutable();
        this.keyInfo_.remove(i);
    }

    public static KeysetInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KeysetInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static KeysetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static KeysetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static KeysetInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KeysetInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static KeysetInfo parseFrom(InputStream inputStream) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeysetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeysetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (KeysetInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeysetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeysetInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeysetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static KeysetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KeysetInfo keysetInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(keysetInfo);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KeysetInfo, Builder> implements KeysetInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(KeysetInfo.DEFAULT_INSTANCE);
        }

        public int getPrimaryKeyId() {
            return ((KeysetInfo) this.instance).getPrimaryKeyId();
        }

        public Builder setPrimaryKeyId(int i) {
            copyOnWrite();
            ((KeysetInfo) this.instance).setPrimaryKeyId(i);
            return this;
        }

        public Builder clearPrimaryKeyId() {
            copyOnWrite();
            ((KeysetInfo) this.instance).clearPrimaryKeyId();
            return this;
        }

        public List<KeyInfo> getKeyInfoList() {
            return Collections.unmodifiableList(((KeysetInfo) this.instance).getKeyInfoList());
        }

        public int getKeyInfoCount() {
            return ((KeysetInfo) this.instance).getKeyInfoCount();
        }

        public KeyInfo getKeyInfo(int i) {
            return ((KeysetInfo) this.instance).getKeyInfo(i);
        }

        public Builder setKeyInfo(int i, KeyInfo keyInfo) {
            copyOnWrite();
            ((KeysetInfo) this.instance).setKeyInfo(i, keyInfo);
            return this;
        }

        public Builder setKeyInfo(int i, KeyInfo.Builder builder) {
            copyOnWrite();
            ((KeysetInfo) this.instance).setKeyInfo(i, (KeyInfo) builder.build());
            return this;
        }

        public Builder addKeyInfo(KeyInfo keyInfo) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(keyInfo);
            return this;
        }

        public Builder addKeyInfo(int i, KeyInfo keyInfo) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(i, keyInfo);
            return this;
        }

        public Builder addKeyInfo(KeyInfo.Builder builder) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo((KeyInfo) builder.build());
            return this;
        }

        public Builder addKeyInfo(int i, KeyInfo.Builder builder) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(i, (KeyInfo) builder.build());
            return this;
        }

        public Builder addAllKeyInfo(Iterable<? extends KeyInfo> iterable) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addAllKeyInfo(iterable);
            return this;
        }

        public Builder clearKeyInfo() {
            copyOnWrite();
            ((KeysetInfo) this.instance).clearKeyInfo();
            return this;
        }

        public Builder removeKeyInfo(int i) {
            copyOnWrite();
            ((KeysetInfo) this.instance).removeKeyInfo(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new KeysetInfo();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", KeyInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeysetInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (KeysetInfo.class) {
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
        KeysetInfo keysetInfo = new KeysetInfo();
        DEFAULT_INSTANCE = keysetInfo;
        GeneratedMessageLite.registerDefaultInstance(KeysetInfo.class, keysetInfo);
    }

    public static KeysetInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KeysetInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
