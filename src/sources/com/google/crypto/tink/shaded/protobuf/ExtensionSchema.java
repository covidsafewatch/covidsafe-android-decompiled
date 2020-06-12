package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;

abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    /* access modifiers changed from: package-private */
    public abstract int extensionNumber(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i);

    /* access modifiers changed from: package-private */
    public abstract FieldSet<T> getExtensions(Object obj);

    /* access modifiers changed from: package-private */
    public abstract FieldSet<T> getMutableExtensions(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean hasExtensions(MessageLite messageLite);

    /* access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB parseExtension(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void serializeExtension(Writer writer, Map.Entry<?, ?> entry) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void setExtensions(Object obj, FieldSet<T> fieldSet);

    ExtensionSchema() {
    }
}
