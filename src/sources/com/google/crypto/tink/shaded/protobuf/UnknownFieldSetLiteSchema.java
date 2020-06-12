package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    /* access modifiers changed from: package-private */
    public boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }

    UnknownFieldSetLiteSchema() {
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    /* access modifiers changed from: package-private */
    public void addVarint(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i, 0), Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void addFixed32(UnknownFieldSetLite unknownFieldSetLite, int i, int i2) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i, 5), Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public void addFixed64(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i, 1), Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void addLengthDelimited(UnknownFieldSetLite unknownFieldSetLite, int i, ByteString byteString) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i, 2), byteString);
    }

    /* access modifiers changed from: package-private */
    public void addGroup(UnknownFieldSetLite unknownFieldSetLite, int i, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i, 3), unknownFieldSetLite2);
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite toImmutable(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    public void setToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite getFromMessage(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite getBuilderFromMessage(Object obj) {
        UnknownFieldSetLite fromMessage = getFromMessage(obj);
        if (fromMessage != UnknownFieldSetLite.getDefaultInstance()) {
            return fromMessage;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        setToMessage(obj, newInstance);
        return newInstance;
    }

    /* access modifiers changed from: package-private */
    public void setBuilderToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        setToMessage(obj, unknownFieldSetLite);
    }

    /* access modifiers changed from: package-private */
    public void makeImmutable(Object obj) {
        getFromMessage(obj).makeImmutable();
    }

    /* access modifiers changed from: package-private */
    public void writeTo(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.writeTo(writer);
    }

    /* access modifiers changed from: package-private */
    public void writeAsMessageSetTo(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.writeAsMessageSetTo(writer);
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite merge(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return unknownFieldSetLite2.equals(UnknownFieldSetLite.getDefaultInstance()) ? unknownFieldSetLite : UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2);
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }
}
