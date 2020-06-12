package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    public static boolean shouldUseTableSwitch(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = (long) i3;
        return ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * j) + 3) + ((j + 3) * 3);
    }

    private SchemaUtil() {
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void writeDouble(int i, double d, Writer writer) throws IOException {
        if (Double.compare(d, 0.0d) != 0) {
            writer.writeDouble(i, d);
        }
    }

    public static void writeFloat(int i, float f, Writer writer) throws IOException {
        if (Float.compare(f, 0.0f) != 0) {
            writer.writeFloat(i, f);
        }
    }

    public static void writeInt64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeInt64(i, j);
        }
    }

    public static void writeUInt64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeUInt64(i, j);
        }
    }

    public static void writeSInt64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeSInt64(i, j);
        }
    }

    public static void writeFixed64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeFixed64(i, j);
        }
    }

    public static void writeSFixed64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeSFixed64(i, j);
        }
    }

    public static void writeInt32(int i, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeInt32(i, i2);
        }
    }

    public static void writeUInt32(int i, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeUInt32(i, i2);
        }
    }

    public static void writeSInt32(int i, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeSInt32(i, i2);
        }
    }

    public static void writeFixed32(int i, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeFixed32(i, i2);
        }
    }

    public static void writeSFixed32(int i, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeSFixed32(i, i2);
        }
    }

    public static void writeEnum(int i, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeEnum(i, i2);
        }
    }

    public static void writeBool(int i, boolean z, Writer writer) throws IOException {
        if (z) {
            writer.writeBool(i, true);
        }
    }

    public static void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i, (String) obj, writer);
        } else {
            writeBytes(i, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i, str);
        }
    }

    public static void writeBytes(int i, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i, byteString);
        }
    }

    public static void writeMessage(int i, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i, obj);
        }
    }

    public static void writeDoubleList(int i, List<Double> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i, list, z);
        }
    }

    public static void writeFloatList(int i, List<Float> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i, list, z);
        }
    }

    public static void writeInt64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i, list, z);
        }
    }

    public static void writeUInt64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i, list, z);
        }
    }

    public static void writeSInt64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i, list, z);
        }
    }

    public static void writeFixed64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i, list, z);
        }
    }

    public static void writeSFixed64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i, list, z);
        }
    }

    public static void writeInt32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i, list, z);
        }
    }

    public static void writeUInt32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i, list, z);
        }
    }

    public static void writeSInt32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i, list, z);
        }
    }

    public static void writeFixed32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i, list, z);
        }
    }

    public static void writeSFixed32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i, list, z);
        }
    }

    public static void writeEnumList(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i, list, z);
        }
    }

    public static void writeBoolList(int i, List<Boolean> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i, list, z);
        }
    }

    public static void writeStringList(int i, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i, list);
        }
    }

    public static void writeBytesList(int i, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i, list);
        }
    }

    public static void writeMessageList(int i, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i, list);
        }
    }

    public static void writeMessageList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i, list, schema);
        }
    }

    public static void writeLazyFieldList(int i, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                ((LazyFieldLite) it.next()).writeTo(writer, i);
            }
        }
    }

    public static void writeGroupList(int i, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i, list);
        }
    }

    public static void writeGroupList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i, list, schema);
        }
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeInt64List(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag);
        }
        return computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeUInt64List(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag);
        }
        return computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeSInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeSInt64List(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag);
        }
        return computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeEnumSizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeEnumList(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag);
        }
        return computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag);
        }
        return computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeUInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag);
        }
        return computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeSInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int computeSizeSInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag);
        }
        return computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed32List(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeFixed64List(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i, 0);
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeBoolList(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(i, true);
    }

    static int computeSizeStringList(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i4 < size) {
                Object raw = lazyStringList.getRaw(i4);
                if (raw instanceof ByteString) {
                    i3 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    i3 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof ByteString) {
                    i2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    i2 = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += i2;
                i4++;
            }
        }
        return computeTagSize;
    }

    static int computeSizeMessage(int i, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(i, (MessageLite) obj, schema);
    }

    static int computeSizeMessageList(int i, List<?> list) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof LazyFieldLite) {
                i2 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i2 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            computeTagSize += i2;
        }
        return computeTagSize;
    }

    static int computeSizeMessageList(int i, List<?> list, Schema schema) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof LazyFieldLite) {
                i2 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                i2 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize += i2;
        }
        return computeTagSize;
    }

    static int computeSizeByteStringList(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i2));
        }
        return computeTagSize;
    }

    static int computeSizeGroupList(int i, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += CodedOutputStream.computeGroupSize(i, list.get(i3));
        }
        return i2;
    }

    static int computeSizeGroupList(int i, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += CodedOutputStream.computeGroupSize(i, list.get(i3), schema);
        }
        return i2;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    static String toCamelCase(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb.append(charAt);
                    }
                    z = true;
                } else if (i != 0 || z) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + ' '));
                }
            } else if (z) {
                sb.append((char) (charAt - ' '));
            } else {
                sb.append(charAt);
            }
            z = false;
        }
        return sb.toString();
    }

    static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t, T t2, long j) {
        UnsafeUtil.putObject((Object) t, j, mapFieldSchema.mergeFrom(UnsafeUtil.getObject((Object) t, j), UnsafeUtil.getObject((Object) t2, j)));
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t2);
        if (!extensions.isEmpty()) {
            extensionSchema.getMutableExtensions(t).mergeFrom(extensions);
        }
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, T t2) {
        unknownFieldSchema.setToMessage(t, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t), unknownFieldSchema.getFromMessage(t2)));
    }

    static <UT, UB> UB filterUnknownEnumList(int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = storeUnknownEnum(i, intValue, ub, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = storeUnknownEnum(i, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB filterUnknownEnumList(int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = storeUnknownEnum(i, intValue, ub, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = storeUnknownEnum(i, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB storeUnknownEnum(int i, int i2, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.newBuilder();
        }
        unknownFieldSchema.addVarint(ub, i, (long) i2);
        return ub;
    }
}
