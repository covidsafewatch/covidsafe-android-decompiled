package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        if (codedOutputStream.wrapper != null) {
            return codedOutputStream.wrapper;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    public void writeSFixed32(int i, int i2) throws IOException {
        this.output.writeSFixed32(i, i2);
    }

    public void writeInt64(int i, long j) throws IOException {
        this.output.writeInt64(i, j);
    }

    public void writeSFixed64(int i, long j) throws IOException {
        this.output.writeSFixed64(i, j);
    }

    public void writeFloat(int i, float f) throws IOException {
        this.output.writeFloat(i, f);
    }

    public void writeDouble(int i, double d) throws IOException {
        this.output.writeDouble(i, d);
    }

    public void writeEnum(int i, int i2) throws IOException {
        this.output.writeEnum(i, i2);
    }

    public void writeUInt64(int i, long j) throws IOException {
        this.output.writeUInt64(i, j);
    }

    public void writeInt32(int i, int i2) throws IOException {
        this.output.writeInt32(i, i2);
    }

    public void writeFixed64(int i, long j) throws IOException {
        this.output.writeFixed64(i, j);
    }

    public void writeFixed32(int i, int i2) throws IOException {
        this.output.writeFixed32(i, i2);
    }

    public void writeBool(int i, boolean z) throws IOException {
        this.output.writeBool(i, z);
    }

    public void writeString(int i, String str) throws IOException {
        this.output.writeString(i, str);
    }

    public void writeBytes(int i, ByteString byteString) throws IOException {
        this.output.writeBytes(i, byteString);
    }

    public void writeUInt32(int i, int i2) throws IOException {
        this.output.writeUInt32(i, i2);
    }

    public void writeSInt32(int i, int i2) throws IOException {
        this.output.writeSInt32(i, i2);
    }

    public void writeSInt64(int i, long j) throws IOException {
        this.output.writeSInt64(i, j);
    }

    public void writeMessage(int i, Object obj) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj);
    }

    public void writeMessage(int i, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj, schema);
    }

    public void writeGroup(int i, Object obj) throws IOException {
        this.output.writeGroup(i, (MessageLite) obj);
    }

    public void writeGroup(int i, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i, (MessageLite) obj, schema);
    }

    public void writeStartGroup(int i) throws IOException {
        this.output.writeTag(i, 3);
    }

    public void writeEndGroup(int i) throws IOException {
        this.output.writeTag(i, 4);
    }

    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    public void writeInt32List(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeInt32(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void writeFixed32List(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i4).intValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeFixed32(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void writeInt64List(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeInt64SizeNoTag(list.get(i4).longValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeInt64(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void writeUInt64List(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeUInt64(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void writeFixed64List(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i4).longValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeFixed64(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void writeFloatList(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeFloatSizeNoTag(list.get(i4).floatValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeFloatNoTag(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeFloat(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public void writeDoubleList(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i4).doubleValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeDouble(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public void writeEnumList(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeEnumSizeNoTag(list.get(i4).intValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeEnumNoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeEnum(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void writeBoolList(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeBoolSizeNoTag(list.get(i4).booleanValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeBoolNoTag(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeBool(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public void writeStringList(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < list.size()) {
                writeLazyString(i, lazyStringList.getRaw(i2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeString(i, list.get(i2));
            i2++;
        }
    }

    private void writeLazyString(int i, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i, (String) obj);
        } else {
            this.output.writeBytes(i, (ByteString) obj);
        }
    }

    public void writeBytesList(int i, List<ByteString> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.output.writeBytes(i, list.get(i2));
        }
    }

    public void writeUInt32List(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i4).intValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeUInt32(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void writeSFixed32List(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i4).intValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSFixed32(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void writeSFixed64List(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i4).longValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSFixed64(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void writeSInt32List(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i4).intValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSInt32(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void writeSInt64List(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i4).longValue());
            }
            this.output.writeUInt32NoTag(i3);
            while (i2 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSInt64(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void writeMessageList(int i, List<?> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeMessage(i, list.get(i2));
        }
    }

    public void writeMessageList(int i, List<?> list, Schema schema) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeMessage(i, list.get(i2), schema);
        }
    }

    public void writeGroupList(int i, List<?> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeGroup(i, list.get(i2));
        }
    }

    public void writeGroupList(int i, List<?> list, Schema schema) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeGroup(i, list.get(i2), schema);
        }
    }

    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i, metadata, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, next.getKey(), next.getValue()));
            MapEntryLite.writeTo(this.output, metadata, next.getKey(), next.getValue());
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType[] r0 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private <K, V> void writeDeterministicMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    writeDeterministicBooleanMapEntry(i, false, v, metadata);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(i, true, v2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicBooleanMapEntry(int i, boolean z, V v, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z), v));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z), v);
    }

    private <V> void writeDeterministicIntegerMap(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (Integer intValue : map.keySet()) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            V v = map.get(Integer.valueOf(i4));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i4), v));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i4), v);
        }
    }

    private <V> void writeDeterministicLongMap(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i2 = 0;
        for (Long longValue : map.keySet()) {
            jArr[i2] = longValue.longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            V v = map.get(Long.valueOf(j));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j), v));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j), v);
        }
    }

    private <V> void writeDeterministicStringMap(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i2 = 0;
        for (String str : map.keySet()) {
            strArr[i2] = str;
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = strArr[i3];
            V v = map.get(str2);
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str2, v));
            MapEntryLite.writeTo(this.output, metadata, str2, v);
        }
    }
}
