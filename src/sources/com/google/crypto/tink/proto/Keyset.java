package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyData;
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

public final class Keyset extends GeneratedMessageLite<Keyset, Builder> implements KeysetOrBuilder {
    /* access modifiers changed from: private */
    public static final Keyset DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<Keyset> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Key> key_ = emptyProtobufList();
    private int primaryKeyId_;

    public interface KeyOrBuilder extends MessageLiteOrBuilder {
        KeyData getKeyData();

        int getKeyId();

        OutputPrefixType getOutputPrefixType();

        int getOutputPrefixTypeValue();

        KeyStatusType getStatus();

        int getStatusValue();

        boolean hasKeyData();
    }

    private Keyset() {
    }

    public static final class Key extends GeneratedMessageLite<Key, Builder> implements KeyOrBuilder {
        /* access modifiers changed from: private */
        public static final Key DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<Key> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private KeyData keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        private Key() {
        }

        public boolean hasKeyData() {
            return this.keyData_ != null;
        }

        public KeyData getKeyData() {
            KeyData keyData = this.keyData_;
            return keyData == null ? KeyData.getDefaultInstance() : keyData;
        }

        /* access modifiers changed from: private */
        public void setKeyData(KeyData keyData) {
            keyData.getClass();
            this.keyData_ = keyData;
        }

        /* access modifiers changed from: private */
        public void mergeKeyData(KeyData keyData) {
            keyData.getClass();
            KeyData keyData2 = this.keyData_;
            if (keyData2 == null || keyData2 == KeyData.getDefaultInstance()) {
                this.keyData_ = keyData;
            } else {
                this.keyData_ = (KeyData) ((KeyData.Builder) KeyData.newBuilder(this.keyData_).mergeFrom(keyData)).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearKeyData() {
            this.keyData_ = null;
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

        public static Key parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Key parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Key parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Key parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Key parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Key parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Key parseFrom(InputStream inputStream) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Key parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Key parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Key) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Key parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Key) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Key parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Key parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Key key) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(key);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Key, Builder> implements KeyOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(Key.DEFAULT_INSTANCE);
            }

            public boolean hasKeyData() {
                return ((Key) this.instance).hasKeyData();
            }

            public KeyData getKeyData() {
                return ((Key) this.instance).getKeyData();
            }

            public Builder setKeyData(KeyData keyData) {
                copyOnWrite();
                ((Key) this.instance).setKeyData(keyData);
                return this;
            }

            public Builder setKeyData(KeyData.Builder builder) {
                copyOnWrite();
                ((Key) this.instance).setKeyData((KeyData) builder.build());
                return this;
            }

            public Builder mergeKeyData(KeyData keyData) {
                copyOnWrite();
                ((Key) this.instance).mergeKeyData(keyData);
                return this;
            }

            public Builder clearKeyData() {
                copyOnWrite();
                ((Key) this.instance).clearKeyData();
                return this;
            }

            public int getStatusValue() {
                return ((Key) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int i) {
                copyOnWrite();
                ((Key) this.instance).setStatusValue(i);
                return this;
            }

            public KeyStatusType getStatus() {
                return ((Key) this.instance).getStatus();
            }

            public Builder setStatus(KeyStatusType keyStatusType) {
                copyOnWrite();
                ((Key) this.instance).setStatus(keyStatusType);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((Key) this.instance).clearStatus();
                return this;
            }

            public int getKeyId() {
                return ((Key) this.instance).getKeyId();
            }

            public Builder setKeyId(int i) {
                copyOnWrite();
                ((Key) this.instance).setKeyId(i);
                return this;
            }

            public Builder clearKeyId() {
                copyOnWrite();
                ((Key) this.instance).clearKeyId();
                return this;
            }

            public int getOutputPrefixTypeValue() {
                return ((Key) this.instance).getOutputPrefixTypeValue();
            }

            public Builder setOutputPrefixTypeValue(int i) {
                copyOnWrite();
                ((Key) this.instance).setOutputPrefixTypeValue(i);
                return this;
            }

            public OutputPrefixType getOutputPrefixType() {
                return ((Key) this.instance).getOutputPrefixType();
            }

            public Builder setOutputPrefixType(OutputPrefixType outputPrefixType) {
                copyOnWrite();
                ((Key) this.instance).setOutputPrefixType(outputPrefixType);
                return this;
            }

            public Builder clearOutputPrefixType() {
                copyOnWrite();
                ((Key) this.instance).clearOutputPrefixType();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Key();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Key> parser = PARSER;
                    if (parser == null) {
                        synchronized (Key.class) {
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
            Key key = new Key();
            DEFAULT_INSTANCE = key;
            GeneratedMessageLite.registerDefaultInstance(Key.class, key);
        }

        public static Key getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Key> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.crypto.tink.proto.Keyset$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.Keyset.AnonymousClass1.<clinit>():void");
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

    public List<Key> getKeyList() {
        return this.key_;
    }

    public List<? extends KeyOrBuilder> getKeyOrBuilderList() {
        return this.key_;
    }

    public int getKeyCount() {
        return this.key_.size();
    }

    public Key getKey(int i) {
        return (Key) this.key_.get(i);
    }

    public KeyOrBuilder getKeyOrBuilder(int i) {
        return (KeyOrBuilder) this.key_.get(i);
    }

    private void ensureKeyIsMutable() {
        if (!this.key_.isModifiable()) {
            this.key_ = GeneratedMessageLite.mutableCopy(this.key_);
        }
    }

    /* access modifiers changed from: private */
    public void setKey(int i, Key key) {
        key.getClass();
        ensureKeyIsMutable();
        this.key_.set(i, key);
    }

    /* access modifiers changed from: private */
    public void addKey(Key key) {
        key.getClass();
        ensureKeyIsMutable();
        this.key_.add(key);
    }

    /* access modifiers changed from: private */
    public void addKey(int i, Key key) {
        key.getClass();
        ensureKeyIsMutable();
        this.key_.add(i, key);
    }

    /* access modifiers changed from: private */
    public void addAllKey(Iterable<? extends Key> iterable) {
        ensureKeyIsMutable();
        AbstractMessageLite.addAll(iterable, this.key_);
    }

    /* access modifiers changed from: private */
    public void clearKey() {
        this.key_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeKey(int i) {
        ensureKeyIsMutable();
        this.key_.remove(i);
    }

    public static Keyset parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Keyset parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Keyset parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Keyset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Keyset parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Keyset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Keyset parseFrom(InputStream inputStream) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Keyset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Keyset parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Keyset) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Keyset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Keyset) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Keyset parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Keyset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Keyset keyset) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(keyset);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Keyset, Builder> implements KeysetOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Keyset.DEFAULT_INSTANCE);
        }

        public int getPrimaryKeyId() {
            return ((Keyset) this.instance).getPrimaryKeyId();
        }

        public Builder setPrimaryKeyId(int i) {
            copyOnWrite();
            ((Keyset) this.instance).setPrimaryKeyId(i);
            return this;
        }

        public Builder clearPrimaryKeyId() {
            copyOnWrite();
            ((Keyset) this.instance).clearPrimaryKeyId();
            return this;
        }

        public List<Key> getKeyList() {
            return Collections.unmodifiableList(((Keyset) this.instance).getKeyList());
        }

        public int getKeyCount() {
            return ((Keyset) this.instance).getKeyCount();
        }

        public Key getKey(int i) {
            return ((Keyset) this.instance).getKey(i);
        }

        public Builder setKey(int i, Key key) {
            copyOnWrite();
            ((Keyset) this.instance).setKey(i, key);
            return this;
        }

        public Builder setKey(int i, Key.Builder builder) {
            copyOnWrite();
            ((Keyset) this.instance).setKey(i, (Key) builder.build());
            return this;
        }

        public Builder addKey(Key key) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(key);
            return this;
        }

        public Builder addKey(int i, Key key) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(i, key);
            return this;
        }

        public Builder addKey(Key.Builder builder) {
            copyOnWrite();
            ((Keyset) this.instance).addKey((Key) builder.build());
            return this;
        }

        public Builder addKey(int i, Key.Builder builder) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(i, (Key) builder.build());
            return this;
        }

        public Builder addAllKey(Iterable<? extends Key> iterable) {
            copyOnWrite();
            ((Keyset) this.instance).addAllKey(iterable);
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((Keyset) this.instance).clearKey();
            return this;
        }

        public Builder removeKey(int i) {
            copyOnWrite();
            ((Keyset) this.instance).removeKey(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Keyset();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", Key.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Keyset> parser = PARSER;
                if (parser == null) {
                    synchronized (Keyset.class) {
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
        Keyset keyset = new Keyset();
        DEFAULT_INSTANCE = keyset;
        GeneratedMessageLite.registerDefaultInstance(Keyset.class, keyset);
    }

    public static Keyset getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Keyset> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
