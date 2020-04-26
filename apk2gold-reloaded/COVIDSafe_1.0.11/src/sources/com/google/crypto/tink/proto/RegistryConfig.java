package com.google.crypto.tink.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class RegistryConfig extends GeneratedMessageLite<RegistryConfig, Builder> implements RegistryConfigOrBuilder {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final RegistryConfig DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    private static volatile Parser<RegistryConfig> PARSER;
    private int bitField0_;
    private String configName_ = "";
    private ProtobufList<KeyTypeEntry> entry_ = emptyProtobufList();

    /* renamed from: com.google.crypto.tink.proto.RegistryConfig$1 reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.RegistryConfig.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<RegistryConfig, Builder> implements RegistryConfigOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(RegistryConfig.DEFAULT_INSTANCE);
        }

        public String getConfigName() {
            return ((RegistryConfig) this.instance).getConfigName();
        }

        public ByteString getConfigNameBytes() {
            return ((RegistryConfig) this.instance).getConfigNameBytes();
        }

        public Builder setConfigName(String str) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setConfigName(str);
            return this;
        }

        public Builder clearConfigName() {
            copyOnWrite();
            ((RegistryConfig) this.instance).clearConfigName();
            return this;
        }

        public Builder setConfigNameBytes(ByteString byteString) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setConfigNameBytes(byteString);
            return this;
        }

        public List<KeyTypeEntry> getEntryList() {
            return Collections.unmodifiableList(((RegistryConfig) this.instance).getEntryList());
        }

        public int getEntryCount() {
            return ((RegistryConfig) this.instance).getEntryCount();
        }

        public KeyTypeEntry getEntry(int i) {
            return ((RegistryConfig) this.instance).getEntry(i);
        }

        public Builder setEntry(int i, KeyTypeEntry keyTypeEntry) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setEntry(i, keyTypeEntry);
            return this;
        }

        public Builder setEntry(int i, com.google.crypto.tink.proto.KeyTypeEntry.Builder builder) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setEntry(i, builder);
            return this;
        }

        public Builder addEntry(KeyTypeEntry keyTypeEntry) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(keyTypeEntry);
            return this;
        }

        public Builder addEntry(int i, KeyTypeEntry keyTypeEntry) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(i, keyTypeEntry);
            return this;
        }

        public Builder addEntry(com.google.crypto.tink.proto.KeyTypeEntry.Builder builder) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(builder);
            return this;
        }

        public Builder addEntry(int i, com.google.crypto.tink.proto.KeyTypeEntry.Builder builder) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(i, builder);
            return this;
        }

        public Builder addAllEntry(Iterable<? extends KeyTypeEntry> iterable) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addAllEntry(iterable);
            return this;
        }

        public Builder clearEntry() {
            copyOnWrite();
            ((RegistryConfig) this.instance).clearEntry();
            return this;
        }

        public Builder removeEntry(int i) {
            copyOnWrite();
            ((RegistryConfig) this.instance).removeEntry(i);
            return this;
        }
    }

    private RegistryConfig() {
    }

    public String getConfigName() {
        return this.configName_;
    }

    public ByteString getConfigNameBytes() {
        return ByteString.copyFromUtf8(this.configName_);
    }

    /* access modifiers changed from: private */
    public void setConfigName(String str) {
        if (str != null) {
            this.configName_ = str;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void clearConfigName() {
        this.configName_ = getDefaultInstance().getConfigName();
    }

    /* access modifiers changed from: private */
    public void setConfigNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.configName_ = byteString.toStringUtf8();
            return;
        }
        throw null;
    }

    public List<KeyTypeEntry> getEntryList() {
        return this.entry_;
    }

    public List<? extends KeyTypeEntryOrBuilder> getEntryOrBuilderList() {
        return this.entry_;
    }

    public int getEntryCount() {
        return this.entry_.size();
    }

    public KeyTypeEntry getEntry(int i) {
        return (KeyTypeEntry) this.entry_.get(i);
    }

    public KeyTypeEntryOrBuilder getEntryOrBuilder(int i) {
        return (KeyTypeEntryOrBuilder) this.entry_.get(i);
    }

    private void ensureEntryIsMutable() {
        if (!this.entry_.isModifiable()) {
            this.entry_ = GeneratedMessageLite.mutableCopy(this.entry_);
        }
    }

    /* access modifiers changed from: private */
    public void setEntry(int i, KeyTypeEntry keyTypeEntry) {
        if (keyTypeEntry != null) {
            ensureEntryIsMutable();
            this.entry_.set(i, keyTypeEntry);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void setEntry(int i, com.google.crypto.tink.proto.KeyTypeEntry.Builder builder) {
        ensureEntryIsMutable();
        this.entry_.set(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addEntry(KeyTypeEntry keyTypeEntry) {
        if (keyTypeEntry != null) {
            ensureEntryIsMutable();
            this.entry_.add(keyTypeEntry);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEntry(int i, KeyTypeEntry keyTypeEntry) {
        if (keyTypeEntry != null) {
            ensureEntryIsMutable();
            this.entry_.add(i, keyTypeEntry);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void addEntry(com.google.crypto.tink.proto.KeyTypeEntry.Builder builder) {
        ensureEntryIsMutable();
        this.entry_.add(builder.build());
    }

    /* access modifiers changed from: private */
    public void addEntry(int i, com.google.crypto.tink.proto.KeyTypeEntry.Builder builder) {
        ensureEntryIsMutable();
        this.entry_.add(i, builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllEntry(Iterable<? extends KeyTypeEntry> iterable) {
        ensureEntryIsMutable();
        AbstractMessageLite.addAll(iterable, this.entry_);
    }

    /* access modifiers changed from: private */
    public void clearEntry() {
        this.entry_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeEntry(int i) {
        ensureEntryIsMutable();
        this.entry_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.configName_.isEmpty()) {
            codedOutputStream.writeString(1, getConfigName());
        }
        for (int i = 0; i < this.entry_.size(); i++) {
            codedOutputStream.writeMessage(2, (MessageLite) this.entry_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.configName_.isEmpty() ? CodedOutputStream.computeStringSize(1, getConfigName()) + 0 : 0;
        for (int i2 = 0; i2 < this.entry_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, (MessageLite) this.entry_.get(i2));
        }
        this.memoizedSerializedSize = computeStringSize;
        return computeStringSize;
    }

    public static RegistryConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RegistryConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RegistryConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RegistryConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RegistryConfig parseFrom(InputStream inputStream) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RegistryConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RegistryConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RegistryConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RegistryConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegistryConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RegistryConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RegistryConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RegistryConfig registryConfig) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(registryConfig);
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RegistryConfig();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.entry_.makeImmutable();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                Visitor visitor = (Visitor) obj;
                RegistryConfig registryConfig = (RegistryConfig) obj2;
                this.configName_ = visitor.visitString(!this.configName_.isEmpty(), this.configName_, true ^ registryConfig.configName_.isEmpty(), registryConfig.configName_);
                this.entry_ = visitor.visitList(this.entry_, registryConfig.entry_);
                if (visitor == MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= registryConfig.bitField0_;
                }
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
                                this.configName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                if (!this.entry_.isModifiable()) {
                                    this.entry_ = GeneratedMessageLite.mutableCopy(this.entry_);
                                }
                                this.entry_.add(codedInputStream.readMessage(KeyTypeEntry.parser(), extensionRegistryLite));
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
                    synchronized (RegistryConfig.class) {
                        if (PARSER == null) {
                            PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
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
        RegistryConfig registryConfig = new RegistryConfig();
        DEFAULT_INSTANCE = registryConfig;
        registryConfig.makeImmutable();
    }

    public static RegistryConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RegistryConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
