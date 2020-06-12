package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class KmsEnvelopeAeadKeyFormat extends GeneratedMessageLite<KmsEnvelopeAeadKeyFormat, Builder> implements KmsEnvelopeAeadKeyFormatOrBuilder {
    /* access modifiers changed from: private */
    public static final KmsEnvelopeAeadKeyFormat DEFAULT_INSTANCE;
    public static final int DEK_TEMPLATE_FIELD_NUMBER = 2;
    public static final int KEK_URI_FIELD_NUMBER = 1;
    private static volatile Parser<KmsEnvelopeAeadKeyFormat> PARSER;
    private KeyTemplate dekTemplate_;
    private String kekUri_ = "";

    private KmsEnvelopeAeadKeyFormat() {
    }

    public String getKekUri() {
        return this.kekUri_;
    }

    public ByteString getKekUriBytes() {
        return ByteString.copyFromUtf8(this.kekUri_);
    }

    /* access modifiers changed from: private */
    public void setKekUri(String str) {
        str.getClass();
        this.kekUri_ = str;
    }

    /* access modifiers changed from: private */
    public void clearKekUri() {
        this.kekUri_ = getDefaultInstance().getKekUri();
    }

    /* access modifiers changed from: private */
    public void setKekUriBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.kekUri_ = byteString.toStringUtf8();
    }

    public boolean hasDekTemplate() {
        return this.dekTemplate_ != null;
    }

    public KeyTemplate getDekTemplate() {
        KeyTemplate keyTemplate = this.dekTemplate_;
        return keyTemplate == null ? KeyTemplate.getDefaultInstance() : keyTemplate;
    }

    /* access modifiers changed from: private */
    public void setDekTemplate(KeyTemplate keyTemplate) {
        keyTemplate.getClass();
        this.dekTemplate_ = keyTemplate;
    }

    /* access modifiers changed from: private */
    public void mergeDekTemplate(KeyTemplate keyTemplate) {
        keyTemplate.getClass();
        KeyTemplate keyTemplate2 = this.dekTemplate_;
        if (keyTemplate2 == null || keyTemplate2 == KeyTemplate.getDefaultInstance()) {
            this.dekTemplate_ = keyTemplate;
        } else {
            this.dekTemplate_ = (KeyTemplate) ((KeyTemplate.Builder) KeyTemplate.newBuilder(this.dekTemplate_).mergeFrom(keyTemplate)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDekTemplate() {
        this.dekTemplate_ = null;
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KmsEnvelopeAeadKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(kmsEnvelopeAeadKeyFormat);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KmsEnvelopeAeadKeyFormat, Builder> implements KmsEnvelopeAeadKeyFormatOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE);
        }

        public String getKekUri() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).getKekUri();
        }

        public ByteString getKekUriBytes() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).getKekUriBytes();
        }

        public Builder setKekUri(String str) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setKekUri(str);
            return this;
        }

        public Builder clearKekUri() {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).clearKekUri();
            return this;
        }

        public Builder setKekUriBytes(ByteString byteString) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setKekUriBytes(byteString);
            return this;
        }

        public boolean hasDekTemplate() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).hasDekTemplate();
        }

        public KeyTemplate getDekTemplate() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).getDekTemplate();
        }

        public Builder setDekTemplate(KeyTemplate keyTemplate) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setDekTemplate(keyTemplate);
            return this;
        }

        public Builder setDekTemplate(KeyTemplate.Builder builder) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setDekTemplate((KeyTemplate) builder.build());
            return this;
        }

        public Builder mergeDekTemplate(KeyTemplate keyTemplate) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).mergeDekTemplate(keyTemplate);
            return this;
        }

        public Builder clearDekTemplate() {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).clearDekTemplate();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new KmsEnvelopeAeadKeyFormat();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"kekUri_", "dekTemplate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KmsEnvelopeAeadKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (KmsEnvelopeAeadKeyFormat.class) {
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
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = new KmsEnvelopeAeadKeyFormat();
        DEFAULT_INSTANCE = kmsEnvelopeAeadKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(KmsEnvelopeAeadKeyFormat.class, kmsEnvelopeAeadKeyFormat);
    }

    public static KmsEnvelopeAeadKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KmsEnvelopeAeadKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
