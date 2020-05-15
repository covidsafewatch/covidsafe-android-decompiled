package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    protected int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    public enum MethodToInvoke {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected interface Visitor {
        boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4);

        Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2);

        ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2);

        double visitDouble(boolean z, double d, boolean z2, double d2);

        Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2);

        FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> fieldSet, FieldSet<ExtensionDescriptor> fieldSet2);

        float visitFloat(boolean z, float f, boolean z2, float f2);

        Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2);

        int visitInt(boolean z, int i, boolean z2, int i2);

        Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2);

        LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2);

        <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2);

        long visitLong(boolean z, long j, boolean z2, long j2);

        Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2);

        <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2);

        <T extends MessageLite> T visitMessage(T t, T t2);

        Object visitOneofBoolean(boolean z, Object obj, Object obj2);

        Object visitOneofByteString(boolean z, Object obj, Object obj2);

        Object visitOneofDouble(boolean z, Object obj, Object obj2);

        Object visitOneofFloat(boolean z, Object obj, Object obj2);

        Object visitOneofInt(boolean z, Object obj, Object obj2);

        Object visitOneofLazyMessage(boolean z, Object obj, Object obj2);

        Object visitOneofLong(boolean z, Object obj, Object obj2);

        Object visitOneofMessage(boolean z, Object obj, Object obj2);

        void visitOneofNotSet(boolean z);

        Object visitOneofString(boolean z, Object obj, Object obj2);

        String visitString(boolean z, String str, boolean z2, String str2);

        UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2);
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public int hashCode() {
        if (this.memoizedHashCode == 0) {
            HashCodeVisitor hashCodeVisitor = new HashCodeVisitor((AnonymousClass1) null);
            visit(hashCodeVisitor, this);
            this.memoizedHashCode = hashCodeVisitor.hashCode;
        }
        return this.memoizedHashCode;
    }

    /* access modifiers changed from: package-private */
    public int hashCode(HashCodeVisitor hashCodeVisitor) {
        if (this.memoizedHashCode == 0) {
            int access$100 = hashCodeVisitor.hashCode;
            int unused = hashCodeVisitor.hashCode = 0;
            visit(hashCodeVisitor, this);
            this.memoizedHashCode = hashCodeVisitor.hashCode;
            int unused2 = hashCodeVisitor.hashCode = access$100;
        }
        return this.memoizedHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        try {
            visit(EqualsVisitor.INSTANCE, (GeneratedMessageLite) obj);
            return true;
        } catch (EqualsVisitor.NotEqualsException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean equals(EqualsVisitor equalsVisitor, MessageLite messageLite) {
        if (this == messageLite) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(messageLite)) {
            return false;
        }
        visit(equalsVisitor, (GeneratedMessageLite) messageLite);
        return true;
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = UnknownFieldSetLite.newInstance();
        }
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.getTagWireType(i) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(i, codedInputStream);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(i, i2);
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(i, byteString);
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
        this.unknownFields.makeImmutable();
    }

    public final boolean isInitialized() {
        return dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    public final BuilderType toBuilder() {
        BuilderType buildertype = (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void visit(Visitor visitor, MessageType messagetype) {
        dynamicMethod(MethodToInvoke.VISIT, visitor, messagetype);
        this.unknownFields = visitor.visitUnknownFields(this.unknownFields, messagetype.unknownFields);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFieldSetLite);
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        protected Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (GeneratedMessageLite) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* access modifiers changed from: protected */
        public void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                messagetype.visit(MergeFromVisitor.INSTANCE, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public final BuilderType clear() {
            this.instance = (GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.mergeFrom(buildPartial());
            return newBuilderForType;
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException(buildPartial);
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            this.instance.visit(MergeFromVisitor.INSTANCE, messagetype);
            return this;
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            copyOnWrite();
            try {
                this.instance.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.newFieldSet();

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.mergeFrom(messagetype.extensions);
        }

        /* access modifiers changed from: package-private */
        public final void visit(Visitor visitor, MessageType messagetype) {
            GeneratedMessageLite.super.visit(visitor, messagetype);
            this.extensions = visitor.visitExtensions(this.extensions, messagetype.extensions);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <MessageType extends com.google.protobuf.MessageLite> boolean parseUnknownField(MessageType r6, com.google.protobuf.CodedInputStream r7, com.google.protobuf.ExtensionRegistryLite r8, int r9) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = com.google.protobuf.WireFormat.getTagWireType(r9)
                int r1 = com.google.protobuf.WireFormat.getTagFieldNumber(r9)
                com.google.protobuf.GeneratedMessageLite$GeneratedExtension r6 = r8.findLiteExtensionByNumber(r6, r1)
                r2 = 0
                r3 = 1
                if (r6 != 0) goto L_0x0013
            L_0x0010:
                r4 = r2
                r0 = r3
                goto L_0x0040
            L_0x0013:
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r4 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r4 = r4.getLiteType()
                int r4 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r4, r2)
                if (r0 != r4) goto L_0x0022
                r0 = r2
                r4 = r0
                goto L_0x0040
            L_0x0022:
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r4 = r6.descriptor
                boolean r4 = r4.isRepeated
                if (r4 == 0) goto L_0x0010
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r4 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r4 = r4.type
                boolean r4 = r4.isPackable()
                if (r4 == 0) goto L_0x0010
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r4 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r4 = r4.getLiteType()
                int r4 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r4, r3)
                if (r0 != r4) goto L_0x0010
                r0 = r2
                r4 = r3
            L_0x0040:
                if (r0 == 0) goto L_0x0047
                boolean r6 = r5.parseUnknownField(r9, r7)
                return r6
            L_0x0047:
                if (r4 == 0) goto L_0x009b
                int r8 = r7.readRawVarint32()
                int r8 = r7.pushLimit(r8)
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                com.google.protobuf.WireFormat$FieldType r0 = com.google.protobuf.WireFormat.FieldType.ENUM
                if (r9 != r0) goto L_0x007e
            L_0x005b:
                int r9 = r7.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x0096
                int r9 = r7.readEnum()
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r6.descriptor
                com.google.protobuf.Internal$EnumLiteMap r0 = r0.getEnumType()
                com.google.protobuf.Internal$EnumLite r9 = r0.findValueByNumber(r9)
                if (r9 != 0) goto L_0x0072
                return r3
            L_0x0072:
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r6.descriptor
                java.lang.Object r9 = r6.singularToFieldSetType(r9)
                r0.addRepeatedField(r1, r9)
                goto L_0x005b
            L_0x007e:
                int r9 = r7.getBytesUntilLimit()
                if (r9 <= 0) goto L_0x0096
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
                java.lang.Object r9 = com.google.protobuf.FieldSet.readPrimitiveField(r7, r9, r2)
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r6.descriptor
                r0.addRepeatedField(r1, r9)
                goto L_0x007e
            L_0x0096:
                r7.popLimit(r8)
                goto L_0x012a
            L_0x009b:
                int[] r9 = com.google.protobuf.GeneratedMessageLite.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r6.descriptor
                com.google.protobuf.WireFormat$JavaType r0 = r0.getLiteJavaType()
                int r0 = r0.ordinal()
                r9 = r9[r0]
                if (r9 == r3) goto L_0x00cf
                r8 = 2
                if (r9 == r8) goto L_0x00b9
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r8 = r8.getLiteType()
                java.lang.Object r7 = com.google.protobuf.FieldSet.readPrimitiveField(r7, r8, r2)
                goto L_0x010b
            L_0x00b9:
                int r7 = r7.readEnum()
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.descriptor
                com.google.protobuf.Internal$EnumLiteMap r8 = r8.getEnumType()
                com.google.protobuf.Internal$EnumLite r8 = r8.findValueByNumber(r7)
                if (r8 != 0) goto L_0x00cd
                r5.mergeVarintField(r1, r7)
                return r3
            L_0x00cd:
                r7 = r8
                goto L_0x010b
            L_0x00cf:
                r9 = 0
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r6.descriptor
                boolean r0 = r0.isRepeated()
                if (r0 != 0) goto L_0x00e8
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r6.descriptor
                java.lang.Object r0 = r0.getField(r1)
                com.google.protobuf.MessageLite r0 = (com.google.protobuf.MessageLite) r0
                if (r0 == 0) goto L_0x00e8
                com.google.protobuf.MessageLite$Builder r9 = r0.toBuilder()
            L_0x00e8:
                if (r9 != 0) goto L_0x00f2
                com.google.protobuf.MessageLite r9 = r6.getMessageDefaultInstance()
                com.google.protobuf.MessageLite$Builder r9 = r9.newBuilderForType()
            L_0x00f2:
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r6.descriptor
                com.google.protobuf.WireFormat$FieldType r0 = r0.getLiteType()
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP
                if (r0 != r1) goto L_0x0104
                int r0 = r6.getNumber()
                r7.readGroup((int) r0, (com.google.protobuf.MessageLite.Builder) r9, (com.google.protobuf.ExtensionRegistryLite) r8)
                goto L_0x0107
            L_0x0104:
                r7.readMessage((com.google.protobuf.MessageLite.Builder) r9, (com.google.protobuf.ExtensionRegistryLite) r8)
            L_0x0107:
                com.google.protobuf.MessageLite r7 = r9.build()
            L_0x010b:
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r6.descriptor
                boolean r8 = r8.isRepeated()
                if (r8 == 0) goto L_0x011f
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r8 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.descriptor
                java.lang.Object r6 = r6.singularToFieldSetType(r7)
                r8.addRepeatedField(r9, r6)
                goto L_0x012a
            L_0x011f:
                com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r8 = r5.extensions
                com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r6.descriptor
                java.lang.Object r6 = r6.singularToFieldSetType(r7)
                r8.setField(r9, r6)
            L_0x012a:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableMessage.parseUnknownField(com.google.protobuf.MessageLite, com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, int):boolean");
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            return this.extensions.hasField(access$200.descriptor);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            return this.extensions.getRepeatedFieldCount(access$200.descriptor);
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            Object field = this.extensions.getField(access$200.descriptor);
            if (field == null) {
                return access$200.defaultValue;
            }
            return access$200.fromFieldSetType(field);
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            return access$200.singularFromFieldSetType(this.extensions.getRepeatedField(access$200.descriptor, i));
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* access modifiers changed from: protected */
        public final void makeImmutable() {
            GeneratedMessageLite.super.makeImmutable();
            this.extensions.makeImmutable();
        }

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 r3) {
                this(z);
            }

            private ExtensionWriter(boolean z) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.protobuf.WireFormat$JavaType[] r0 = com.google.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$JavaType = r0
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
            ((ExtendableMessage) this.instance).extensions = ((ExtendableMessage) this.instance).extensions.clone();
        }

        /* access modifiers changed from: package-private */
        public void internalSetExtensionSet(FieldSet<ExtensionDescriptor> fieldSet) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = fieldSet;
        }

        /* access modifiers changed from: protected */
        public void copyOnWrite() {
            if (this.isBuilt) {
                super.copyOnWrite();
                ((ExtendableMessage) this.instance).extensions = ((ExtendableMessage) this.instance).extensions.clone();
            }
        }

        public final MessageType buildPartial() {
            if (this.isBuilt) {
                return (ExtendableMessage) this.instance;
            }
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (ExtendableMessage) super.buildPartial();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).hasExtension(extensionLite);
        }

        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extensionLite);
        }

        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtension(extensionLite);
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [com.google.protobuf.ExtensionLite, com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Type> Type getExtension(com.google.protobuf.ExtensionLite<MessageType, java.util.List<Type>> r2, int r3) {
            /*
                r1 = this;
                com.google.protobuf.GeneratedMessageLite r0 = r1.instance
                com.google.protobuf.GeneratedMessageLite$ExtendableMessage r0 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r0
                java.lang.Object r2 = r0.getExtension(r2, r3)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableBuilder.getExtension(com.google.protobuf.ExtensionLite, int):java.lang.Object");
        }

        public BuilderType clone() {
            return (ExtendableBuilder) super.clone();
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.setField(access$200.descriptor, access$200.toFieldSetType(type));
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i, Type type) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.setRepeatedField(access$200.descriptor, i, access$200.singularToFieldSetType(type));
            return this;
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.addRepeatedField(access$200.descriptor, access$200.singularToFieldSetType(type));
            return this;
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension access$200 = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(access$200);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.clearField(access$200.descriptor);
            return this;
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, false, false), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z), cls);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        public int getNumber() {
            return this.number;
        }

        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public boolean isRepeated() {
            return this.isRepeated;
        }

        public boolean isPacked() {
            return this.isPacked;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
            }
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        /* access modifiers changed from: package-private */
        public Object fromFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularFromFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularFromFieldSetType : (List) obj) {
                arrayList.add(singularFromFieldSetType(singularFromFieldSetType));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public Object singularFromFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.descriptor.enumTypeMap.findValueByNumber(((Integer) obj).intValue()) : obj;
        }

        /* access modifiers changed from: package-private */
        public Object toFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularToFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularToFieldSetType : (List) obj) {
                arrayList.add(singularToFieldSetType(singularToFieldSetType));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public Object singularToFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }

        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        public Type getDefaultValue() {
            return this.defaultValue;
        }
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final String messageClassName;

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e2) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (InvalidProtocolBufferException e4) {
                throw new RuntimeException("Unable to understand proto buffer", e4);
            }
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e2);
            } catch (SecurityException e3) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (InvalidProtocolBufferException e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.isLite()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        return t.dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(z)) != null;
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> void makeImmutable(T t) {
        t.dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    protected static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    protected static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private T defaultInstance;

        public DefaultInstanceBasedParser(T t) {
            this.defaultInstance = t;
        }

        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (GeneratedMessageLite) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            t2.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, extensionRegistryLite);
            t2.makeImmutable();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw e;
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t, byteString, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, byteString, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T parsePartialFrom;
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            parsePartialFrom = parsePartialFrom(t, newCodedInput, extensionRegistryLite);
            newCodedInput.checkLastTagWas(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(parsePartialFrom);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T parsePartialFrom;
        try {
            CodedInputStream newInstance = CodedInputStream.newInstance(bArr);
            parsePartialFrom = parsePartialFrom(t, newInstance, extensionRegistryLite);
            newInstance.checkLastTagWas(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(parsePartialFrom);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, bArr, extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, CodedInputStream.newInstance(inputStream), extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t, codedInputStream, extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T parsePartialFrom = parsePartialFrom(t, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return parsePartialFrom;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(parsePartialFrom);
            }
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    static class EqualsVisitor implements Visitor {
        static final EqualsVisitor INSTANCE = new EqualsVisitor();
        static final NotEqualsException NOT_EQUALS = new NotEqualsException();

        static final class NotEqualsException extends RuntimeException {
            NotEqualsException() {
            }
        }

        private EqualsVisitor() {
        }

        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw NOT_EQUALS;
        }

        public int visitInt(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw NOT_EQUALS;
        }

        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            if (z == z2 && d == d2) {
                return d;
            }
            throw NOT_EQUALS;
        }

        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            if (z == z2 && f == f2) {
                return f;
            }
            throw NOT_EQUALS;
        }

        public long visitLong(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw NOT_EQUALS;
        }

        public String visitString(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw NOT_EQUALS;
        }

        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            if (z == z2 && byteString.equals(byteString2)) {
                return byteString;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            if (z && ((GeneratedMessageLite) obj).equals(this, (MessageLite) obj2)) {
                return obj;
            }
            throw NOT_EQUALS;
        }

        public void visitOneofNotSet(boolean z) {
            if (z) {
                throw NOT_EQUALS;
            }
        }

        public <T extends MessageLite> T visitMessage(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t == null || t2 == null) {
                throw NOT_EQUALS;
            }
            ((GeneratedMessageLite) t).equals(this, t2);
            return t;
        }

        public LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2) {
            if (lazyFieldLite == null && lazyFieldLite2 == null) {
                return null;
            }
            if (lazyFieldLite == null || lazyFieldLite2 == null) {
                throw NOT_EQUALS;
            } else if (lazyFieldLite.equals(lazyFieldLite2)) {
                return lazyFieldLite;
            } else {
                throw NOT_EQUALS;
            }
        }

        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            if (protobufList.equals(protobufList2)) {
                return protobufList;
            }
            throw NOT_EQUALS;
        }

        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            if (booleanList.equals(booleanList2)) {
                return booleanList;
            }
            throw NOT_EQUALS;
        }

        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            if (intList.equals(intList2)) {
                return intList;
            }
            throw NOT_EQUALS;
        }

        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            if (doubleList.equals(doubleList2)) {
                return doubleList;
            }
            throw NOT_EQUALS;
        }

        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            if (floatList.equals(floatList2)) {
                return floatList;
            }
            throw NOT_EQUALS;
        }

        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            if (longList.equals(longList2)) {
                return longList;
            }
            throw NOT_EQUALS;
        }

        public FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> fieldSet, FieldSet<ExtensionDescriptor> fieldSet2) {
            if (fieldSet.equals(fieldSet2)) {
                return fieldSet;
            }
            throw NOT_EQUALS;
        }

        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            if (unknownFieldSetLite.equals(unknownFieldSetLite2)) {
                return unknownFieldSetLite;
            }
            throw NOT_EQUALS;
        }

        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (mapFieldLite.equals(mapFieldLite2)) {
                return mapFieldLite;
            }
            throw NOT_EQUALS;
        }
    }

    private static class HashCodeVisitor implements Visitor {
        /* access modifiers changed from: private */
        public int hashCode;

        private HashCodeVisitor() {
            this.hashCode = 0;
        }

        /* synthetic */ HashCodeVisitor(AnonymousClass1 r1) {
            this();
        }

        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            this.hashCode = (this.hashCode * 53) + Internal.hashBoolean(z2);
            return z2;
        }

        public int visitInt(boolean z, int i, boolean z2, int i2) {
            this.hashCode = (this.hashCode * 53) + i;
            return i;
        }

        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(d));
            return d;
        }

        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            this.hashCode = (this.hashCode * 53) + Float.floatToIntBits(f);
            return f;
        }

        public long visitLong(boolean z, long j, boolean z2, long j2) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(j);
            return j;
        }

        public String visitString(boolean z, String str, boolean z2, String str2) {
            this.hashCode = (this.hashCode * 53) + str.hashCode();
            return str;
        }

        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            this.hashCode = (this.hashCode * 53) + byteString.hashCode();
            return byteString;
        }

        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + Internal.hashBoolean(((Boolean) obj).booleanValue());
            return obj;
        }

        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + ((Integer) obj).intValue();
            return obj;
        }

        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(((Double) obj).doubleValue()));
            return obj;
        }

        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + Float.floatToIntBits(((Float) obj).floatValue());
            return obj;
        }

        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + Internal.hashLong(((Long) obj).longValue());
            return obj;
        }

        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + obj.hashCode();
            return obj;
        }

        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + obj.hashCode();
            return obj;
        }

        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            this.hashCode = (this.hashCode * 53) + obj.hashCode();
            return obj;
        }

        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            return visitMessage((MessageLite) obj, (MessageLite) obj2);
        }

        public void visitOneofNotSet(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        public <T extends MessageLite> T visitMessage(T t, T t2) {
            int i;
            if (t != null) {
                i = t instanceof GeneratedMessageLite ? ((GeneratedMessageLite) t).hashCode(this) : t.hashCode();
            } else {
                i = 37;
            }
            this.hashCode = (this.hashCode * 53) + i;
            return t;
        }

        public LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2) {
            this.hashCode = (this.hashCode * 53) + (lazyFieldLite != null ? lazyFieldLite.hashCode() : 37);
            return lazyFieldLite;
        }

        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            this.hashCode = (this.hashCode * 53) + protobufList.hashCode();
            return protobufList;
        }

        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            this.hashCode = (this.hashCode * 53) + booleanList.hashCode();
            return booleanList;
        }

        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            this.hashCode = (this.hashCode * 53) + intList.hashCode();
            return intList;
        }

        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            this.hashCode = (this.hashCode * 53) + doubleList.hashCode();
            return doubleList;
        }

        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            this.hashCode = (this.hashCode * 53) + floatList.hashCode();
            return floatList;
        }

        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            this.hashCode = (this.hashCode * 53) + longList.hashCode();
            return longList;
        }

        public FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> fieldSet, FieldSet<ExtensionDescriptor> fieldSet2) {
            this.hashCode = (this.hashCode * 53) + fieldSet.hashCode();
            return fieldSet;
        }

        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            this.hashCode = (this.hashCode * 53) + unknownFieldSetLite.hashCode();
            return unknownFieldSetLite;
        }

        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            this.hashCode = (this.hashCode * 53) + mapFieldLite.hashCode();
            return mapFieldLite;
        }
    }

    protected static class MergeFromVisitor implements Visitor {
        public static final MergeFromVisitor INSTANCE = new MergeFromVisitor();

        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            return z2 ? byteString2 : byteString;
        }

        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            return z2 ? d2 : d;
        }

        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            return z2 ? f2 : f;
        }

        public int visitInt(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        public long visitLong(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public void visitOneofNotSet(boolean z) {
        }

        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public String visitString(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        private MergeFromVisitor() {
        }

        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            LazyFieldLite lazyFieldLite = z ? (LazyFieldLite) obj : new LazyFieldLite();
            lazyFieldLite.merge((LazyFieldLite) obj2);
            return lazyFieldLite;
        }

        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            return z ? visitMessage((MessageLite) obj, (MessageLite) obj2) : obj2;
        }

        public <T extends MessageLite> T visitMessage(T t, T t2) {
            if (t == null || t2 == null) {
                return t != null ? t : t2;
            }
            return t.toBuilder().mergeFrom((MessageLite) t2).build();
        }

        public LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2) {
            if (lazyFieldLite2 != null) {
                if (lazyFieldLite == null) {
                    lazyFieldLite = new LazyFieldLite();
                }
                lazyFieldLite.merge(lazyFieldLite2);
            }
            return lazyFieldLite;
        }

        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            return size > 0 ? protobufList : protobufList2;
        }

        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            int size = booleanList.size();
            int size2 = booleanList2.size();
            if (size > 0 && size2 > 0) {
                if (!booleanList.isModifiable()) {
                    booleanList = booleanList.mutableCopyWithCapacity(size2 + size);
                }
                booleanList.addAll(booleanList2);
            }
            return size > 0 ? booleanList : booleanList2;
        }

        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            int size = intList.size();
            int size2 = intList2.size();
            if (size > 0 && size2 > 0) {
                if (!intList.isModifiable()) {
                    intList = intList.mutableCopyWithCapacity(size2 + size);
                }
                intList.addAll(intList2);
            }
            return size > 0 ? intList : intList2;
        }

        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            int size = doubleList.size();
            int size2 = doubleList2.size();
            if (size > 0 && size2 > 0) {
                if (!doubleList.isModifiable()) {
                    doubleList = doubleList.mutableCopyWithCapacity(size2 + size);
                }
                doubleList.addAll(doubleList2);
            }
            return size > 0 ? doubleList : doubleList2;
        }

        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            int size = floatList.size();
            int size2 = floatList2.size();
            if (size > 0 && size2 > 0) {
                if (!floatList.isModifiable()) {
                    floatList = floatList.mutableCopyWithCapacity(size2 + size);
                }
                floatList.addAll(floatList2);
            }
            return size > 0 ? floatList : floatList2;
        }

        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            int size = longList.size();
            int size2 = longList2.size();
            if (size > 0 && size2 > 0) {
                if (!longList.isModifiable()) {
                    longList = longList.mutableCopyWithCapacity(size2 + size);
                }
                longList.addAll(longList2);
            }
            return size > 0 ? longList : longList2;
        }

        public FieldSet<ExtensionDescriptor> visitExtensions(FieldSet<ExtensionDescriptor> fieldSet, FieldSet<ExtensionDescriptor> fieldSet2) {
            if (fieldSet.isImmutable()) {
                fieldSet = fieldSet.clone();
            }
            fieldSet.mergeFrom(fieldSet2);
            return fieldSet;
        }

        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            return unknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance() ? unknownFieldSetLite : UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2);
        }

        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (!mapFieldLite2.isEmpty()) {
                if (!mapFieldLite.isMutable()) {
                    mapFieldLite = mapFieldLite.mutableCopy();
                }
                mapFieldLite.mergeFrom(mapFieldLite2);
            }
            return mapFieldLite;
        }
    }
}
