package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema2;
        this.hasExtensions = extensionSchema2.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema2, extensionSchema2, messageLite);
    }

    public T newInstance() {
        return this.defaultInstance.newBuilderForType().buildPartial();
    }

    public boolean equals(T t, T t2) {
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public int hashCode(T t) {
        int hashCode = this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : hashCode;
    }

    public void mergeFrom(T t, T t2) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    public void writeTo(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.getExtensions(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), next.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeAsMessageSetTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite r0 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite) r0
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r2 = com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L_0x0011
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r1 = com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite.newInstance()
            r0.unknownFields = r1
        L_0x0011:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.crypto.tink.shaded.protobuf.FieldSet r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r13, r15)
            int r13 = r15.int1
            int r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L_0x0066
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r2 = r10.extensionSchema
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r3 = r15.extensionRegistry
            com.google.crypto.tink.shaded.protobuf.MessageLite r5 = r10.defaultInstance
            int r6 = com.google.crypto.tink.shaded.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.findExtensionByNumber(r3, r5, r6)
            r8 = r2
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L_0x005b
            com.google.crypto.tink.shaded.protobuf.Protobuf r13 = com.google.crypto.tink.shaded.protobuf.Protobuf.getInstance()
            com.google.crypto.tink.shaded.protobuf.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            com.google.crypto.tink.shaded.protobuf.Schema r13 = r13.schemaFor(r2)
            int r13 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageField(r13, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.descriptor
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeUnknownField(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.skipField(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r15)
            int r6 = r15.int1
            int r7 = com.google.crypto.tink.shaded.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = com.google.crypto.tink.shaded.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            com.google.crypto.tink.shaded.protobuf.Protobuf r6 = com.google.crypto.tink.shaded.protobuf.Protobuf.getInstance()
            com.google.crypto.tink.shaded.protobuf.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r6.schemaFor(r7)
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageField(r6, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.descriptor
            java.lang.Object r7 = r15.object1
            r11.setField(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeBytes(r12, r4, r15)
            java.lang.Object r3 = r15.object1
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r15)
            int r13 = r15.int1
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r2 = r10.extensionSchema
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r6 = r15.extensionRegistry
            com.google.crypto.tink.shaded.protobuf.MessageLite r7 = r10.defaultInstance
            java.lang.Object r2 = r2.findExtensionByNumber(r6, r7, r13)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = com.google.crypto.tink.shaded.protobuf.WireFormat.MESSAGE_SET_ITEM_END_TAG
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.skipField(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = com.google.crypto.tink.shaded.protobuf.WireFormat.makeTag(r13, r5)
            r1.storeField(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r11 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):void");
    }

    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, ExtensionSchema<ET> extensionSchema2, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t);
        FieldSet<ET> mutableExtensions = extensionSchema2.getMutableExtensions(t);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    unknownFieldSchema2.setBuilderToMessage(t, builderFromMessage);
                    return;
                }
            } finally {
                unknownFieldSchema2.setBuilderToMessage(t, builderFromMessage);
            }
        } while (parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema2, mutableExtensions, unknownFieldSchema2, builderFromMessage));
    }

    public void makeImmutable(T t) {
        this.unknownFieldSchema.makeImmutable(t);
        this.extensionSchema.makeImmutable(t);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema2, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema2, UB ub) throws IOException {
        int tag = reader.getTag();
        if (tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
            int i = 0;
            Object obj = null;
            ByteString byteString = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = reader.getTag();
                if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i = reader.readUInt32();
                    obj = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, i);
                } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (obj != null) {
                        extensionSchema2.parseLengthPrefixedMessageSetItem(reader, obj, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = reader.readBytes();
                    }
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                if (byteString != null) {
                    if (obj != null) {
                        extensionSchema2.parseMessageSetItem(byteString, obj, extensionRegistryLite, fieldSet);
                    } else {
                        unknownFieldSchema2.addLengthDelimited(ub, i, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (WireFormat.getTagWireType(tag) != 2) {
            return reader.skipField();
        } else {
            Object findExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (findExtensionByNumber == null) {
                return unknownFieldSchema2.mergeOneFieldFrom(ub, reader);
            }
            extensionSchema2.parseLengthPrefixedMessageSetItem(reader, findExtensionByNumber, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    public final boolean isInitialized(T t) {
        return this.extensionSchema.getExtensions(t).isInitialized();
    }

    public int getSerializedSize(T t) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t) + 0;
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSizeAsMessageSet(unknownFieldSchema2.getFromMessage(t));
    }
}
