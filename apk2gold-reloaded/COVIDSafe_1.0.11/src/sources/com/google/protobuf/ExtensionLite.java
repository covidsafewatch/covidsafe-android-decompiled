package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat.FieldType;

public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract Type getDefaultValue();

    public abstract FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    /* access modifiers changed from: 0000 */
    public boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
