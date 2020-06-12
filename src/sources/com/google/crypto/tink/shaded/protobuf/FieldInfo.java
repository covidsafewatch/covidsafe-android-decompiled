package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {
    private final Field cachedSizeField;
    private final boolean enforceUtf8;
    private final Internal.EnumVerifier enumVerifier;
    private final Field field;
    private final int fieldNumber;
    private final Object mapDefaultEntry;
    private final Class<?> messageClass;
    private final OneofInfo oneof;
    private final Class<?> oneofStoredType;
    private final Field presenceField;
    private final int presenceMask;
    private final boolean required;
    private final FieldType type;

    private static boolean isExactlyOneBitSet(int i) {
        return i != 0 && (i & (i + -1)) == 0;
    }

    public static FieldInfo forField(Field field2, int i, FieldType fieldType, boolean z) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i);
        Field field3 = field2;
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field2, i, fieldType, (Class<?>) null, (Field) null, 0, false, z, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forPackedField(Field field2, int i, FieldType fieldType, Field field3) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i);
        Field field4 = field2;
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field2, i, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, field3);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forRepeatedMessageField(Field field2, int i, FieldType fieldType, Class<?> cls) {
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        FieldType fieldType2 = fieldType;
        Internal.checkNotNull(fieldType2, "fieldType");
        Class<?> cls2 = cls;
        Internal.checkNotNull(cls2, "messageClass");
        return new FieldInfo(field2, i, fieldType2, cls2, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
    }

    public static FieldInfo forFieldWithEnumVerifier(Field field2, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier2) {
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        return new FieldInfo(field2, i, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, (Field) null);
    }

    public static FieldInfo forPackedFieldWithEnumVerifier(Field field2, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier2, Field field3) {
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        return new FieldInfo(field2, i, fieldType, (Class<?>) null, (Field) null, 0, false, false, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, field3);
    }

    public static FieldInfo forProto2OptionalField(Field field2, int i, FieldType fieldType, Field field3, int i2, boolean z, Internal.EnumVerifier enumVerifier2) {
        Field field4 = field3;
        checkFieldNumber(i);
        Field field5 = field2;
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(field4, "presenceField");
        if (field4 == null || isExactlyOneBitSet(i2)) {
            int i3 = i2;
            return new FieldInfo(field2, i, fieldType, (Class<?>) null, field3, i2, false, z, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
    }

    public static FieldInfo forOneofMemberField(int i, FieldType fieldType, OneofInfo oneofInfo, Class<?> cls, boolean z, Internal.EnumVerifier enumVerifier2) {
        FieldType fieldType2 = fieldType;
        checkFieldNumber(i);
        Internal.checkNotNull(fieldType2, "fieldType");
        Internal.checkNotNull(oneofInfo, "oneof");
        Internal.checkNotNull(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo((Field) null, i, fieldType, (Class<?>) null, (Field) null, 0, false, z, oneofInfo, cls, (Object) null, enumVerifier2, (Field) null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Oneof is only supported for scalar fields. Field ");
        int i2 = i;
        sb.append(i);
        sb.append(" is of type ");
        sb.append(fieldType2);
        throw new IllegalArgumentException(sb.toString());
    }

    private static void checkFieldNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
    }

    public static FieldInfo forProto2RequiredField(Field field2, int i, FieldType fieldType, Field field3, int i2, boolean z, Internal.EnumVerifier enumVerifier2) {
        Field field4 = field3;
        checkFieldNumber(i);
        Field field5 = field2;
        Internal.checkNotNull(field2, "field");
        Internal.checkNotNull(fieldType, "fieldType");
        Internal.checkNotNull(field4, "presenceField");
        if (field4 == null || isExactlyOneBitSet(i2)) {
            int i3 = i2;
            return new FieldInfo(field2, i, fieldType, (Class<?>) null, field3, i2, true, z, (OneofInfo) null, (Class<?>) null, (Object) null, enumVerifier2, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
    }

    public static FieldInfo forMapField(Field field2, int i, Object obj, Internal.EnumVerifier enumVerifier2) {
        Object obj2 = obj;
        Internal.checkNotNull(obj2, "mapDefaultEntry");
        checkFieldNumber(i);
        Internal.checkNotNull(field2, "field");
        return new FieldInfo(field2, i, FieldType.MAP, (Class<?>) null, (Field) null, 0, false, true, (OneofInfo) null, (Class<?>) null, obj2, enumVerifier2, (Field) null);
    }

    private FieldInfo(Field field2, int i, FieldType fieldType, Class<?> cls, Field field3, int i2, boolean z, boolean z2, OneofInfo oneofInfo, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier2, Field field4) {
        this.field = field2;
        this.type = fieldType;
        this.messageClass = cls;
        this.fieldNumber = i;
        this.presenceField = field3;
        this.presenceMask = i2;
        this.required = z;
        this.enforceUtf8 = z2;
        this.oneof = oneofInfo;
        this.oneofStoredType = cls2;
        this.mapDefaultEntry = obj;
        this.enumVerifier = enumVerifier2;
        this.cachedSizeField = field4;
    }

    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public Field getField() {
        return this.field;
    }

    public FieldType getType() {
        return this.type;
    }

    public OneofInfo getOneof() {
        return this.oneof;
    }

    public Class<?> getOneofStoredType() {
        return this.oneofStoredType;
    }

    public Internal.EnumVerifier getEnumVerifier() {
        return this.enumVerifier;
    }

    public int compareTo(FieldInfo fieldInfo) {
        return this.fieldNumber - fieldInfo.fieldNumber;
    }

    public Class<?> getListElementType() {
        return this.messageClass;
    }

    public Field getPresenceField() {
        return this.presenceField;
    }

    public Object getMapDefaultEntry() {
        return this.mapDefaultEntry;
    }

    public int getPresenceMask() {
        return this.presenceMask;
    }

    public boolean isRequired() {
        return this.required;
    }

    public boolean isEnforceUtf8() {
        return this.enforceUtf8;
    }

    public Field getCachedSizeField() {
        return this.cachedSizeField;
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.FieldInfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.FieldType[] r0 = com.google.crypto.tink.shaded.protobuf.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$FieldType = r0
                com.google.crypto.tink.shaded.protobuf.FieldType r1 = com.google.crypto.tink.shaded.protobuf.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.FieldType r1 = com.google.crypto.tink.shaded.protobuf.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.FieldType r1 = com.google.crypto.tink.shaded.protobuf.FieldType.MESSAGE_LIST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.FieldType r1 = com.google.crypto.tink.shaded.protobuf.FieldType.GROUP_LIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.FieldInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public Class<?> getMessageFieldClass() {
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (i == 1 || i == 2) {
            Field field2 = this.field;
            return field2 != null ? field2.getType() : this.oneofStoredType;
        } else if (i == 3 || i == 4) {
            return this.messageClass;
        } else {
            return null;
        }
    }

    public static Builder newBuilder() {
        return new Builder((AnonymousClass1) null);
    }

    public static final class Builder {
        private Field cachedSizeField;
        private boolean enforceUtf8;
        private Internal.EnumVerifier enumVerifier;
        private Field field;
        private int fieldNumber;
        private Object mapDefaultEntry;
        private OneofInfo oneof;
        private Class<?> oneofStoredType;
        private Field presenceField;
        private int presenceMask;
        private boolean required;
        private FieldType type;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
        }

        public Builder withField(Field field2) {
            if (this.oneof == null) {
                this.field = field2;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withType(FieldType fieldType) {
            this.type = fieldType;
            return this;
        }

        public Builder withFieldNumber(int i) {
            this.fieldNumber = i;
            return this;
        }

        public Builder withPresence(Field field2, int i) {
            this.presenceField = (Field) Internal.checkNotNull(field2, "presenceField");
            this.presenceMask = i;
            return this;
        }

        public Builder withOneof(OneofInfo oneofInfo, Class<?> cls) {
            if (this.field == null && this.presenceField == null) {
                this.oneof = oneofInfo;
                this.oneofStoredType = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withRequired(boolean z) {
            this.required = z;
            return this;
        }

        public Builder withMapDefaultEntry(Object obj) {
            this.mapDefaultEntry = obj;
            return this;
        }

        public Builder withEnforceUtf8(boolean z) {
            this.enforceUtf8 = z;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier enumVerifier2) {
            this.enumVerifier = enumVerifier2;
            return this;
        }

        public Builder withCachedSizeField(Field field2) {
            this.cachedSizeField = field2;
            return this;
        }

        public FieldInfo build() {
            OneofInfo oneofInfo = this.oneof;
            if (oneofInfo != null) {
                return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, oneofInfo, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
            }
            Object obj = this.mapDefaultEntry;
            if (obj != null) {
                return FieldInfo.forMapField(this.field, this.fieldNumber, obj, this.enumVerifier);
            }
            Field field2 = this.presenceField;
            if (field2 == null) {
                Internal.EnumVerifier enumVerifier2 = this.enumVerifier;
                if (enumVerifier2 != null) {
                    Field field3 = this.cachedSizeField;
                    if (field3 == null) {
                        return FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier2);
                    }
                    return FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, enumVerifier2, field3);
                }
                Field field4 = this.cachedSizeField;
                if (field4 == null) {
                    return FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8);
                }
                return FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, field4);
            } else if (this.required) {
                return FieldInfo.forProto2RequiredField(this.field, this.fieldNumber, this.type, field2, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            } else {
                return FieldInfo.forProto2OptionalField(this.field, this.fieldNumber, this.type, field2, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            }
        }
    }
}
