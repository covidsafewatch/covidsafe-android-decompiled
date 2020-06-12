package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class StructuralMessageInfo implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;
    private final FieldInfo[] fields;
    private final boolean messageSetWireFormat;
    private final ProtoSyntax syntax;

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.syntax = protoSyntax;
        this.messageSetWireFormat = z;
        this.checkInitialized = iArr;
        this.fields = fieldInfoArr;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(obj, "defaultInstance");
    }

    public ProtoSyntax getSyntax() {
        return this.syntax;
    }

    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }

    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    public FieldInfo[] getFields() {
        return this.fields;
    }

    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(int i) {
        return new Builder(i);
    }

    public static final class Builder {
        private int[] checkInitialized;
        private Object defaultInstance;
        private final List<FieldInfo> fields;
        private boolean messageSetWireFormat;
        private ProtoSyntax syntax;
        private boolean wasBuilt;

        public Builder() {
            this.checkInitialized = null;
            this.fields = new ArrayList();
        }

        public Builder(int i) {
            this.checkInitialized = null;
            this.fields = new ArrayList(i);
        }

        public void withDefaultInstance(Object obj) {
            this.defaultInstance = obj;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            this.syntax = (ProtoSyntax) Internal.checkNotNull(protoSyntax, "syntax");
        }

        public void withMessageSetWireFormat(boolean z) {
            this.messageSetWireFormat = z;
        }

        public void withCheckInitialized(int[] iArr) {
            this.checkInitialized = iArr;
        }

        public void withField(FieldInfo fieldInfo) {
            if (!this.wasBuilt) {
                this.fields.add(fieldInfo);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public StructuralMessageInfo build() {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            } else if (this.syntax != null) {
                this.wasBuilt = true;
                Collections.sort(this.fields);
                return new StructuralMessageInfo(this.syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) this.fields.toArray(new FieldInfo[0]), this.defaultInstance);
            } else {
                throw new IllegalStateException("Must specify a proto syntax");
            }
        }
    }
}
