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

@Deprecated
public final class KeyTypeEntry extends GeneratedMessageLite<KeyTypeEntry, Builder> implements KeyTypeEntryOrBuilder {
    public static final int CATALOGUE_NAME_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */
    public static final KeyTypeEntry DEFAULT_INSTANCE;
    public static final int KEY_MANAGER_VERSION_FIELD_NUMBER = 3;
    public static final int NEW_KEY_ALLOWED_FIELD_NUMBER = 4;
    private static volatile Parser<KeyTypeEntry> PARSER = null;
    public static final int PRIMITIVE_NAME_FIELD_NUMBER = 1;
    public static final int TYPE_URL_FIELD_NUMBER = 2;
    private String catalogueName_ = "";
    private int keyManagerVersion_;
    private boolean newKeyAllowed_;
    private String primitiveName_ = "";
    private String typeUrl_ = "";

    private KeyTypeEntry() {
    }

    public String getPrimitiveName() {
        return this.primitiveName_;
    }

    public ByteString getPrimitiveNameBytes() {
        return ByteString.copyFromUtf8(this.primitiveName_);
    }

    /* access modifiers changed from: private */
    public void setPrimitiveName(String str) {
        str.getClass();
        this.primitiveName_ = str;
    }

    /* access modifiers changed from: private */
    public void clearPrimitiveName() {
        this.primitiveName_ = getDefaultInstance().getPrimitiveName();
    }

    /* access modifiers changed from: private */
    public void setPrimitiveNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.primitiveName_ = byteString.toStringUtf8();
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

    public int getKeyManagerVersion() {
        return this.keyManagerVersion_;
    }

    /* access modifiers changed from: private */
    public void setKeyManagerVersion(int i) {
        this.keyManagerVersion_ = i;
    }

    /* access modifiers changed from: private */
    public void clearKeyManagerVersion() {
        this.keyManagerVersion_ = 0;
    }

    public boolean getNewKeyAllowed() {
        return this.newKeyAllowed_;
    }

    /* access modifiers changed from: private */
    public void setNewKeyAllowed(boolean z) {
        this.newKeyAllowed_ = z;
    }

    /* access modifiers changed from: private */
    public void clearNewKeyAllowed() {
        this.newKeyAllowed_ = false;
    }

    public String getCatalogueName() {
        return this.catalogueName_;
    }

    public ByteString getCatalogueNameBytes() {
        return ByteString.copyFromUtf8(this.catalogueName_);
    }

    /* access modifiers changed from: private */
    public void setCatalogueName(String str) {
        str.getClass();
        this.catalogueName_ = str;
    }

    /* access modifiers changed from: private */
    public void clearCatalogueName() {
        this.catalogueName_ = getDefaultInstance().getCatalogueName();
    }

    /* access modifiers changed from: private */
    public void setCatalogueNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.catalogueName_ = byteString.toStringUtf8();
    }

    public static KeyTypeEntry parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KeyTypeEntry parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static KeyTypeEntry parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static KeyTypeEntry parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static KeyTypeEntry parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KeyTypeEntry parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static KeyTypeEntry parseFrom(InputStream inputStream) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeyTypeEntry parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeyTypeEntry parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (KeyTypeEntry) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeyTypeEntry parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeyTypeEntry) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeyTypeEntry parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static KeyTypeEntry parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KeyTypeEntry keyTypeEntry) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(keyTypeEntry);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KeyTypeEntry, Builder> implements KeyTypeEntryOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(KeyTypeEntry.DEFAULT_INSTANCE);
        }

        public String getPrimitiveName() {
            return ((KeyTypeEntry) this.instance).getPrimitiveName();
        }

        public ByteString getPrimitiveNameBytes() {
            return ((KeyTypeEntry) this.instance).getPrimitiveNameBytes();
        }

        public Builder setPrimitiveName(String str) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setPrimitiveName(str);
            return this;
        }

        public Builder clearPrimitiveName() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearPrimitiveName();
            return this;
        }

        public Builder setPrimitiveNameBytes(ByteString byteString) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setPrimitiveNameBytes(byteString);
            return this;
        }

        public String getTypeUrl() {
            return ((KeyTypeEntry) this.instance).getTypeUrl();
        }

        public ByteString getTypeUrlBytes() {
            return ((KeyTypeEntry) this.instance).getTypeUrlBytes();
        }

        public Builder setTypeUrl(String str) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setTypeUrl(str);
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearTypeUrl();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setTypeUrlBytes(byteString);
            return this;
        }

        public int getKeyManagerVersion() {
            return ((KeyTypeEntry) this.instance).getKeyManagerVersion();
        }

        public Builder setKeyManagerVersion(int i) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setKeyManagerVersion(i);
            return this;
        }

        public Builder clearKeyManagerVersion() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearKeyManagerVersion();
            return this;
        }

        public boolean getNewKeyAllowed() {
            return ((KeyTypeEntry) this.instance).getNewKeyAllowed();
        }

        public Builder setNewKeyAllowed(boolean z) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setNewKeyAllowed(z);
            return this;
        }

        public Builder clearNewKeyAllowed() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearNewKeyAllowed();
            return this;
        }

        public String getCatalogueName() {
            return ((KeyTypeEntry) this.instance).getCatalogueName();
        }

        public ByteString getCatalogueNameBytes() {
            return ((KeyTypeEntry) this.instance).getCatalogueNameBytes();
        }

        public Builder setCatalogueName(String str) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setCatalogueName(str);
            return this;
        }

        public Builder clearCatalogueName() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearCatalogueName();
            return this;
        }

        public Builder setCatalogueNameBytes(ByteString byteString) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setCatalogueNameBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KeyTypeEntry$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.KeyTypeEntry.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new KeyTypeEntry();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"primitiveName_", "typeUrl_", "keyManagerVersion_", "newKeyAllowed_", "catalogueName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeyTypeEntry> parser = PARSER;
                if (parser == null) {
                    synchronized (KeyTypeEntry.class) {
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
        KeyTypeEntry keyTypeEntry = new KeyTypeEntry();
        DEFAULT_INSTANCE = keyTypeEntry;
        GeneratedMessageLite.registerDefaultInstance(KeyTypeEntry.class, keyTypeEntry);
    }

    public static KeyTypeEntry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KeyTypeEntry> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
