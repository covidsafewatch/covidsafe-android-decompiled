package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.Utf8;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import okhttp3.internal.http2.Http2Stream;

abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j) {
        byte b;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            b = (byte) 6;
            j >>>= 28;
        } else {
            b = 2;
        }
        if ((-2097152 & j) != 0) {
            b = (byte) (b + 2);
            j >>>= 14;
        }
        return (j & -16384) != 0 ? (byte) (b + 1) : b;
    }

    /* access modifiers changed from: package-private */
    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    /* access modifiers changed from: package-private */
    public abstract void requireSpace(int i);

    /* access modifiers changed from: package-private */
    public abstract void writeBool(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void writeFixed32(int i);

    /* access modifiers changed from: package-private */
    public abstract void writeFixed64(long j);

    /* access modifiers changed from: package-private */
    public abstract void writeInt32(int i);

    /* access modifiers changed from: package-private */
    public abstract void writeSInt32(int i);

    /* access modifiers changed from: package-private */
    public abstract void writeSInt64(long j);

    /* access modifiers changed from: package-private */
    public abstract void writeString(String str);

    /* access modifiers changed from: package-private */
    public abstract void writeTag(int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void writeVarint32(int i);

    /* access modifiers changed from: package-private */
    public abstract void writeVarint64(long j);

    /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i, AnonymousClass1 r3) {
        this(bufferAllocator, i);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i) {
        if (isUnsafeHeapSupported()) {
            return newUnsafeHeapInstance(bufferAllocator, i);
        }
        return newSafeHeapInstance(bufferAllocator, i);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i) {
        if (isUnsafeDirectSupported()) {
            return newUnsafeDirectInstance(bufferAllocator, i);
        }
        return newSafeDirectInstance(bufferAllocator, i);
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i) {
        return new SafeHeapWriter(bufferAllocator, i);
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i) {
        return new SafeDirectWriter(bufferAllocator, i);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private BinaryWriter(BufferAllocator bufferAllocator, int i) {
        this.buffers = new ArrayDeque<>(4);
        if (i > 0) {
            this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
            this.chunkSize = i;
            return;
        }
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    public final void writeSFixed32(int i, int i2) throws IOException {
        writeFixed32(i, i2);
    }

    public final void writeInt64(int i, long j) throws IOException {
        writeUInt64(i, j);
    }

    public final void writeSFixed64(int i, long j) throws IOException {
        writeFixed64(i, j);
    }

    public final void writeFloat(int i, float f) throws IOException {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    public final void writeDouble(int i, double d) throws IOException {
        writeFixed64(i, Double.doubleToRawLongBits(d));
    }

    public final void writeEnum(int i, int i2) throws IOException {
        writeInt32(i, i2);
    }

    public final void writeInt32List(int i, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeInt32List_Internal(i, list, z);
        }
    }

    private final void writeInt32List_Internal(int i, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i, list.get(size2).intValue());
        }
    }

    private final void writeInt32List_Internal(int i, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i, intArrayList.getInt(size2));
        }
    }

    public final void writeFixed32List(int i, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeFixed32List_Internal(i, list, z);
        }
    }

    private final void writeFixed32List_Internal(int i, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i, list.get(size2).intValue());
        }
    }

    private final void writeFixed32List_Internal(int i, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i, intArrayList.getInt(size2));
        }
    }

    public final void writeInt64List(int i, List<Long> list, boolean z) throws IOException {
        writeUInt64List(i, list, z);
    }

    public final void writeUInt64List(int i, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i, (LongArrayList) list, z);
        } else {
            writeUInt64List_Internal(i, list, z);
        }
    }

    private final void writeUInt64List_Internal(int i, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i, list.get(size2).longValue());
        }
    }

    private final void writeUInt64List_Internal(int i, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i, longArrayList.getLong(size2));
        }
    }

    public final void writeFixed64List(int i, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i, (LongArrayList) list, z);
        } else {
            writeFixed64List_Internal(i, list, z);
        }
    }

    private final void writeFixed64List_Internal(int i, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i, list.get(size2).longValue());
        }
    }

    private final void writeFixed64List_Internal(int i, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i, longArrayList.getLong(size2));
        }
    }

    public final void writeFloatList(int i, List<Float> list, boolean z) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i, (FloatArrayList) list, z);
        } else {
            writeFloatList_Internal(i, list, z);
        }
    }

    private final void writeFloatList_Internal(int i, List<Float> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i, list.get(size2).floatValue());
        }
    }

    private final void writeFloatList_Internal(int i, FloatArrayList floatArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i, floatArrayList.getFloat(size2));
        }
    }

    public final void writeDoubleList(int i, List<Double> list, boolean z) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i, (DoubleArrayList) list, z);
        } else {
            writeDoubleList_Internal(i, list, z);
        }
    }

    private final void writeDoubleList_Internal(int i, List<Double> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i, list.get(size2).doubleValue());
        }
    }

    private final void writeDoubleList_Internal(int i, DoubleArrayList doubleArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i, doubleArrayList.getDouble(size2));
        }
    }

    public final void writeEnumList(int i, List<Integer> list, boolean z) throws IOException {
        writeInt32List(i, list, z);
    }

    public final void writeBoolList(int i, List<Boolean> list, boolean z) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i, (BooleanArrayList) list, z);
        } else {
            writeBoolList_Internal(i, list, z);
        }
    }

    private final void writeBoolList_Internal(int i, List<Boolean> list, boolean z) throws IOException {
        if (z) {
            requireSpace(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(list.get(size).booleanValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i, list.get(size2).booleanValue());
        }
    }

    private final void writeBoolList_Internal(int i, BooleanArrayList booleanArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i, booleanArrayList.getBoolean(size2));
        }
    }

    public final void writeStringList(int i, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                writeLazyString(i, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i, list.get(size2));
        }
    }

    private void writeLazyString(int i, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i, (String) obj);
        } else {
            writeBytes(i, (ByteString) obj);
        }
    }

    public final void writeBytesList(int i, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i, list.get(size));
        }
    }

    public final void writeUInt32List(int i, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeUInt32List_Internal(i, list, z);
        }
    }

    private final void writeUInt32List_Internal(int i, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i, list.get(size2).intValue());
        }
    }

    private final void writeUInt32List_Internal(int i, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i, intArrayList.getInt(size2));
        }
    }

    public final void writeSFixed32List(int i, List<Integer> list, boolean z) throws IOException {
        writeFixed32List(i, list, z);
    }

    public final void writeSFixed64List(int i, List<Long> list, boolean z) throws IOException {
        writeFixed64List(i, list, z);
    }

    public final void writeSInt32List(int i, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeSInt32List_Internal(i, list, z);
        }
    }

    private final void writeSInt32List_Internal(int i, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i, list.get(size2).intValue());
        }
    }

    private final void writeSInt32List_Internal(int i, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i, intArrayList.getInt(size2));
        }
    }

    public final void writeSInt64List(int i, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i, (LongArrayList) list, z);
        } else {
            writeSInt64List_Internal(i, list, z);
        }
    }

    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, next.getValue());
            writeMapEntryField(this, 1, metadata.keyType, next.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.BinaryWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
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
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.BinaryWriter.AnonymousClass1.<clinit>():void");
        }
    }

    static final void writeMapEntryField(Writer writer, int i, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i, obj);
                return;
            case 16:
                writer.writeBytes(i, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else if (obj instanceof Integer) {
                    writer.writeEnum(i, ((Integer) obj).intValue());
                    return;
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void writeSInt64List_Internal(int i, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i, list.get(size2).longValue());
        }
    }

    private final void writeSInt64List_Internal(int i, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i, longArrayList.getLong(size2));
        }
    }

    public final void writeMessageList(int i, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i, list.get(size));
        }
    }

    public final void writeMessageList(int i, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i, list.get(size), schema);
        }
    }

    public final void writeGroupList(int i, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i, list.get(size));
        }
    }

    public final void writeGroupList(int i, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i, list.get(size), schema);
        }
    }

    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i);
        writeTag(1, 3);
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newHeapBuffer(int i) {
        return this.alloc.allocateHeapBuffer(Math.max(i, this.chunkSize));
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer newDirectBuffer(int i) {
        return this.alloc.allocateDirectBuffer(Math.max(i, this.chunkSize));
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, (AnonymousClass1) null);
            nextBuffer();
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer2 = this.allocatedBuffer;
                allocatedBuffer2.position((this.pos - allocatedBuffer2.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int i) {
            nextBuffer(newHeapBuffer(i));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                int arrayOffset = allocatedBuffer2.arrayOffset();
                this.limit = allocatedBuffer2.limit() + arrayOffset;
                int position = arrayOffset + allocatedBuffer2.position();
                this.offset = position;
                this.offsetMinusOne = position - 1;
                int i = this.limit - 1;
                this.limitMinusOne = i;
                this.pos = i;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        /* access modifiers changed from: package-private */
        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        /* access modifiers changed from: package-private */
        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        public void writeUInt32(int i, int i2) throws IOException {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        public void writeInt32(int i, int i2) throws IOException {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        public void writeSInt32(int i, int i2) throws IOException {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        public void writeFixed32(int i, int i2) throws IOException {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        public void writeUInt64(int i, long j) throws IOException {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        public void writeSInt64(int i, long j) throws IOException {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        public void writeFixed64(int i, long j) throws IOException {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        public void writeBool(int i, boolean z) throws IOException {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i, 0);
        }

        public void writeString(int i, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeBytes(int i, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeMessage(int i, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeMessage(int i, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeGroup(int i, Object obj) throws IOException {
            writeTag(i, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeGroup(int i, Object obj, Schema schema) throws IOException {
            writeTag(i, 4);
            schema.writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64((long) i);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.makeTag(i, i2));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i) {
            if ((i & -128) == 0) {
                writeVarint32OneByte(i);
            } else if ((i & -16384) == 0) {
                writeVarint32TwoBytes(i);
            } else if ((-2097152 & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if ((-268435456 & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        private void writeVarint32OneByte(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) i;
        }

        private void writeVarint32TwoBytes(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (i >>> 7);
            this.pos = i3 - 1;
            bArr[i3] = (byte) ((i & 127) | 128);
        }

        private void writeVarint32ThreeBytes(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (i >>> 14);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (((i >>> 7) & 127) | 128);
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((i & 127) | 128);
        }

        private void writeVarint32FourBytes(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (i >>> 21);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (((i >>> 14) & 127) | 128);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((i >>> 7) & 127) | 128);
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((i & 127) | 128);
        }

        private void writeVarint32FiveBytes(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (i >>> 28);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (((i >>> 21) & 127) | 128);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((i >>> 14) & 127) | 128);
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((i >>> 7) & 127) | 128);
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((i & 127) | 128);
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i - 1;
            bArr[i] = (byte) ((int) j);
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 7));
            this.pos = i2 - 1;
            bArr[i2] = (byte) ((((int) j) & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) (((int) j) >>> 14);
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i3 - 1;
            bArr[i3] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 21));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 28));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 35));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 42));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i7 - 1;
            bArr[i7] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 49));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 42) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i8 - 1;
            bArr[i8] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 56));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 49) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 42) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i9 - 1;
            bArr[i9] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) ((int) (j >>> 63));
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (((j >>> 56) & 127) | 128));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 49) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 42) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i10 = i9 - 1;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i10 - 1;
            bArr[i10] = (byte) ((int) ((j & 127) | 128));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((i >> 24) & 255);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((i >> 16) & 255);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((i >> 8) & 255);
            this.pos = i5 - 1;
            bArr[i5] = (byte) (i & 255);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            int i2 = i - 1;
            this.pos = i2;
            bArr[i] = (byte) (((int) (j >> 56)) & 255);
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (((int) (j >> 48)) & 255);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (((int) (j >> 40)) & 255);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((int) (j >> 32)) & 255);
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((int) (j >> 24)) & 255);
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (((int) (j >> 16)) & 255);
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) (((int) (j >> 8)) & 255);
            this.pos = i8 - 1;
            bArr[i8] = (byte) (((int) j) & 255);
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            int i;
            int i2;
            int i3;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i3 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i3 - 1;
                    bArr[i3] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i2 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i4 = i2 - 1;
                    this.pos = i4;
                    bArr2[i2] = (byte) ((charAt2 & '?') | 128);
                    this.pos = i4 - 1;
                    bArr2[i4] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i5 = i - 1;
                    this.pos = i5;
                    bArr3[i] = (byte) ((charAt2 & '?') | 128);
                    int i6 = i5 - 1;
                    this.pos = i6;
                    bArr3[i5] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.pos = i6 - 1;
                    bArr3[i6] = (byte) ((charAt2 >>> 12) | 480);
                } else if (this.pos > this.offset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.buffer;
                            int i7 = this.pos;
                            int i8 = i7 - 1;
                            this.pos = i8;
                            bArr4[i7] = (byte) ((codePoint & 63) | 128);
                            int i9 = i8 - 1;
                            this.pos = i9;
                            bArr4[i8] = (byte) (((codePoint >>> 6) & 63) | 128);
                            int i10 = i9 - 1;
                            this.pos = i10;
                            bArr4[i9] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.pos = i10 - 1;
                            bArr4[i10] = (byte) ((codePoint >>> 18) | 240);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        public void write(byte b) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i - 1;
            bArr[i] = b;
        }

        public void write(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            int i3 = this.pos - i2;
            this.pos = i3;
            System.arraycopy(bArr, i, this.buffer, i3 + 1, i2);
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i, i2));
                nextBuffer();
                return;
            }
            int i3 = this.pos - i2;
            this.pos = i3;
            System.arraycopy(bArr, i, this.buffer, i3 + 1, i2);
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i = this.pos - remaining;
            this.pos = i;
            byteBuffer.get(this.buffer, i + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i = this.pos - remaining;
            this.pos = i;
            byteBuffer.get(this.buffer, i + 1, remaining);
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, (AnonymousClass1) null);
            nextBuffer();
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int i) {
            nextBuffer(newHeapBuffer(i));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                int arrayOffset = allocatedBuffer2.arrayOffset();
                this.limit = (long) (allocatedBuffer2.limit() + arrayOffset);
                long position = (long) (arrayOffset + allocatedBuffer2.position());
                this.offset = position;
                this.offsetMinusOne = position - 1;
                long j = this.limit - 1;
                this.limitMinusOne = j;
                this.pos = j;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        /* access modifiers changed from: package-private */
        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        /* access modifiers changed from: package-private */
        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        public void writeBool(int i, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i, 0);
        }

        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeMessage(int i, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeMessage(int i, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeGroup(int i, Object obj) throws IOException {
            writeTag(i, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeGroup(int i, Object obj, Schema schema) throws IOException {
            writeTag(i, 4);
            schema.writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64((long) i);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.makeTag(i, i2));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i) {
            if ((i & -128) == 0) {
                writeVarint32OneByte(i);
            } else if ((i & -16384) == 0) {
                writeVarint32TwoBytes(i);
            } else if ((-2097152 & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if ((-268435456 & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        private void writeVarint32OneByte(int i) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) i);
        }

        private void writeVarint32TwoBytes(int i) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i >>> 7));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) ((i & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int i) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i >>> 14));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((i >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) ((i & 127) | 128));
        }

        private void writeVarint32FourBytes(int i) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i >>> 21));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((i >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) (((i >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) ((i & 127) | 128));
        }

        private void writeVarint32FiveBytes(int i) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i >>> 28));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((i >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) (((i >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) (((i >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr5, j5, (byte) ((i & 127) | 128));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) j));
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 7)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((((int) j) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (((int) j) >>> 14));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 21)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 28)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 35)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 42)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 49)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 42) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 56)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 49) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 42) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr9, j10, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 63)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 56) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 49) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 42) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr9, j10, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr10 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr10, j11, (byte) ((int) ((j & 127) | 128)));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) ((i >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) ((i >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) ((i >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) (i & 255));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (((int) (j >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((int) (j >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((int) (j >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((int) (j >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((int) (j >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((int) (j >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) (((int) (j >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) (((int) j) & 255));
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    byte[] bArr = this.buffer;
                    long j = this.pos;
                    this.pos = j - 1;
                    UnsafeUtil.putByte(bArr, j, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j2 = this.pos;
                        if (j2 > this.offsetMinusOne) {
                            byte[] bArr2 = this.buffer;
                            this.pos = j2 - 1;
                            UnsafeUtil.putByte(bArr2, j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j3 = this.pos;
                        if (j3 > this.offset) {
                            byte[] bArr3 = this.buffer;
                            this.pos = j3 - 1;
                            UnsafeUtil.putByte(bArr3, j3, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr4 = this.buffer;
                            long j4 = this.pos;
                            this.pos = j4 - 1;
                            UnsafeUtil.putByte(bArr4, j4, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j5 = this.pos;
                        if (j5 > this.offset + 1) {
                            byte[] bArr5 = this.buffer;
                            this.pos = j5 - 1;
                            UnsafeUtil.putByte(bArr5, j5, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr6 = this.buffer;
                            long j6 = this.pos;
                            this.pos = j6 - 1;
                            UnsafeUtil.putByte(bArr6, j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            byte[] bArr7 = this.buffer;
                            long j7 = this.pos;
                            this.pos = j7 - 1;
                            UnsafeUtil.putByte(bArr7, j7, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr8 = this.buffer;
                                long j8 = this.pos;
                                this.pos = j8 - 1;
                                UnsafeUtil.putByte(bArr8, j8, (byte) ((codePoint & 63) | 128));
                                byte[] bArr9 = this.buffer;
                                long j9 = this.pos;
                                this.pos = j9 - 1;
                                UnsafeUtil.putByte(bArr9, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                byte[] bArr10 = this.buffer;
                                long j10 = this.pos;
                                this.pos = j10 - 1;
                                UnsafeUtil.putByte(bArr10, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                byte[] bArr11 = this.buffer;
                                long j11 = this.pos;
                                this.pos = j11 - 1;
                                UnsafeUtil.putByte(bArr11, j11, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void write(byte b) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, b);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            requireSpace(i2);
            this.pos -= (long) i2;
            System.arraycopy(bArr, i, this.buffer, arrayPos() + 1, i2);
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            } else if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i, i2));
                nextBuffer();
            } else {
                this.pos -= (long) i2;
                System.arraycopy(bArr, i, this.buffer, arrayPos() + 1, i2);
            }
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            requireSpace(remaining);
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, (AnonymousClass1) null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int i) {
            nextBuffer(newDirectBuffer(i));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    nioBuffer.limit(nioBuffer.capacity());
                    this.buffer.position(0);
                    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.buffer.limit() - 1;
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        public void writeBool(int i, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i, 0);
        }

        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeMessage(int i, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeMessage(int i, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeGroup(int i, Object obj) throws IOException {
            writeTag(i, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeGroup(int i, Object obj, Schema schema) throws IOException {
            writeTag(i, 4);
            schema.writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64((long) i);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.makeTag(i, i2));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i) {
            if ((i & -128) == 0) {
                writeVarint32OneByte(i);
            } else if ((i & -16384) == 0) {
                writeVarint32TwoBytes(i);
            } else if ((-2097152 & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if ((-268435456 & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        private void writeVarint32OneByte(int i) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) i);
        }

        private void writeVarint32TwoBytes(int i) {
            int i2 = this.pos - 2;
            this.pos = i2;
            this.buffer.putShort(i2 + 1, (short) ((i & 127) | 128 | ((i & 16256) << 1)));
        }

        private void writeVarint32ThreeBytes(int i) {
            int i2 = this.pos - 3;
            this.pos = i2;
            this.buffer.putInt(i2, (((i & 127) | 128) << 8) | ((2080768 & i) << 10) | (((i & 16256) | 16384) << 9));
        }

        private void writeVarint32FourBytes(int i) {
            int i2 = this.pos - 4;
            this.pos = i2;
            this.buffer.putInt(i2 + 1, (i & 127) | 128 | ((266338304 & i) << 3) | (((2080768 & i) | 2097152) << 2) | (((i & 16256) | 16384) << 1));
        }

        private void writeVarint32FiveBytes(int i) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) (i >>> 28));
            int i3 = this.pos - 4;
            this.pos = i3;
            this.buffer.putInt(i3 + 1, (i & 127) | 128 | ((((i >>> 21) & 127) | 128) << 24) | ((((i >>> 14) & 127) | 128) << 16) | ((((i >>> 7) & 127) | 128) << 8));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void writeVarint64OneByte(long j) {
            writeVarint32OneByte((int) j);
        }

        private void writeVarint64TwoBytes(long j) {
            writeVarint32TwoBytes((int) j);
        }

        private void writeVarint64ThreeBytes(long j) {
            writeVarint32ThreeBytes((int) j);
        }

        private void writeVarint64FourBytes(long j) {
            writeVarint32FourBytes((int) j);
        }

        private void writeVarint64FiveBytes(long j) {
            int i = this.pos - 5;
            this.pos = i;
            this.buffer.putLong(i - 2, (((j & 127) | 128) << 24) | ((34091302912L & j) << 28) | (((266338304 & j) | 268435456) << 27) | (((2080768 & j) | 2097152) << 26) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 25));
        }

        private void writeVarint64SixBytes(long j) {
            int i = this.pos - 6;
            this.pos = i;
            this.buffer.putLong(i - 1, (((j & 127) | 128) << 16) | ((4363686772736L & j) << 21) | (((34091302912L & j) | 34359738368L) << 20) | (((266338304 & j) | 268435456) << 19) | (((2080768 & j) | 2097152) << 18) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 17));
        }

        private void writeVarint64SevenBytes(long j) {
            int i = this.pos - 7;
            this.pos = i;
            this.buffer.putLong(i, (((j & 127) | 128) << 8) | ((558551906910208L & j) << 14) | (((4363686772736L & j) | 4398046511104L) << 13) | (((34091302912L & j) | 34359738368L) << 12) | (((266338304 & j) | 268435456) << 11) | (((2080768 & j) | 2097152) << 10) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 9));
        }

        private void writeVarint64EightBytes(long j) {
            int i = this.pos - 8;
            this.pos = i;
            this.buffer.putLong(i + 1, (j & 127) | 128 | ((71494644084506624L & j) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | 2097152) << 2) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j) {
            int i = this.pos - 8;
            this.pos = i;
            this.buffer.putLong(i + 1, (j & 127) | 128 | (((71494644084506624L & j) | 72057594037927936L) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | 2097152) << 2) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 1));
        }

        private void writeVarint64NineBytes(long j) {
            ByteBuffer byteBuffer = this.buffer;
            int i = this.pos;
            this.pos = i - 1;
            byteBuffer.put(i, (byte) ((int) (j >>> 56)));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64TenBytes(long j) {
            ByteBuffer byteBuffer = this.buffer;
            int i = this.pos;
            this.pos = i - 1;
            byteBuffer.put(i, (byte) ((int) (j >>> 63)));
            ByteBuffer byteBuffer2 = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer2.put(i2, (byte) ((int) (((j >>> 56) & 127) | 128)));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i) {
            int i2 = this.pos - 4;
            this.pos = i2;
            this.buffer.putInt(i2 + 1, i);
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j) {
            int i = this.pos - 8;
            this.pos = i;
            this.buffer.putLong(i + 1, j);
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            int i;
            int i2;
            int i3;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i3 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i3 - 1;
                    byteBuffer.put(i3, (byte) charAt2);
                } else if (charAt2 < 2048 && (i2 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i2 - 1;
                    byteBuffer2.put(i2, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 - 1;
                    byteBuffer3.put(i4, (byte) ((charAt2 >>> 6) | 960));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = i - 1;
                    byteBuffer4.put(i, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i5 = this.pos;
                    this.pos = i5 - 1;
                    byteBuffer5.put(i5, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i6 = this.pos;
                    this.pos = i6 - 1;
                    byteBuffer6.put(i6, (byte) ((charAt2 >>> 12) | 480));
                } else if (this.pos > 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            ByteBuffer byteBuffer7 = this.buffer;
                            int i7 = this.pos;
                            this.pos = i7 - 1;
                            byteBuffer7.put(i7, (byte) ((codePoint & 63) | 128));
                            ByteBuffer byteBuffer8 = this.buffer;
                            int i8 = this.pos;
                            this.pos = i8 - 1;
                            byteBuffer8.put(i8, (byte) (((codePoint >>> 6) & 63) | 128));
                            ByteBuffer byteBuffer9 = this.buffer;
                            int i9 = this.pos;
                            this.pos = i9 - 1;
                            byteBuffer9.put(i9, (byte) (((codePoint >>> 12) & 63) | 128));
                            ByteBuffer byteBuffer10 = this.buffer;
                            int i10 = this.pos;
                            this.pos = i10 - 1;
                            byteBuffer10.put(i10, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        public void write(byte b) {
            ByteBuffer byteBuffer = this.buffer;
            int i = this.pos;
            this.pos = i - 1;
            byteBuffer.put(i, b);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            int i3 = this.pos - i2;
            this.pos = i3;
            this.buffer.position(i3 + 1);
            this.buffer.put(bArr, i, i2);
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i, i2));
                nextBuffer();
                return;
            }
            int i3 = this.pos - i2;
            this.pos = i3;
            this.buffer.position(i3 + 1);
            this.buffer.put(bArr, i, i2);
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i = this.pos - remaining;
            this.pos = i;
            this.buffer.position(i + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            int i = this.pos - remaining;
            this.pos = i;
            this.buffer.position(i + 1);
            this.buffer.put(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        UnsafeDirectWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, (AnonymousClass1) null);
            nextBuffer();
        }

        /* access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int i) {
            nextBuffer(newDirectBuffer(i));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    nioBuffer.limit(nioBuffer.capacity());
                    this.buffer.position(0);
                    long addressOffset = UnsafeUtil.addressOffset(this.buffer);
                    this.bufferOffset = addressOffset;
                    long limit = addressOffset + ((long) (this.buffer.limit() - 1));
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        /* access modifiers changed from: package-private */
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(bufferPos() + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        public void writeBool(int i, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i, 0);
        }

        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeMessage(int i, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeMessage(int i, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }

        public void writeGroup(int i, Object obj) throws IOException {
            writeTag(i, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeGroup(int i, Object obj, Schema schema) throws IOException {
            writeTag(i, 4);
            schema.writeTo(obj, this);
            writeTag(i, 3);
        }

        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        /* access modifiers changed from: package-private */
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64((long) i);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        /* access modifiers changed from: package-private */
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        /* access modifiers changed from: package-private */
        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        /* access modifiers changed from: package-private */
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.makeTag(i, i2));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint32(int i) {
            if ((i & -128) == 0) {
                writeVarint32OneByte(i);
            } else if ((i & -16384) == 0) {
                writeVarint32TwoBytes(i);
            } else if ((-2097152 & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if ((-268435456 & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        private void writeVarint32OneByte(int i) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) i);
        }

        private void writeVarint32TwoBytes(int i) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i >>> 7));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((i & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int i) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i >>> 14));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((i >>> 7) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i & 127) | 128));
        }

        private void writeVarint32FourBytes(int i) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i >>> 21));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((i >>> 14) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i >>> 7) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((i & 127) | 128));
        }

        private void writeVarint32FiveBytes(int i) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i >>> 28));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((i >>> 21) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i >>> 14) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((i >>> 7) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((i & 127) | 128));
        }

        /* access modifiers changed from: package-private */
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void writeVarint64OneByte(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) j));
        }

        private void writeVarint64TwoBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 7)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((((int) j) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((int) j) >>> 14));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 21)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 28)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 35)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64SevenBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 42)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64EightBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 49)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 56)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 49) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 63)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 56) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 49) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) ((j & 127) | 128)));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed32(int i) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) ((i >> 24) & 255));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((i >> 16) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i >> 8) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (i & 255));
        }

        /* access modifiers changed from: package-private */
        public void writeFixed64(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((int) (j >> 56)) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((int) (j >> 48)) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((int) (j >> 40)) & 255));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((int) (j >> 32)) & 255));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((int) (j >> 24)) & 255));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((int) (j >> 16)) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((int) (j >> 8)) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((int) j) & 255));
        }

        /* access modifiers changed from: package-private */
        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    long j = this.pos;
                    this.pos = j - 1;
                    UnsafeUtil.putByte(j, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j2 = this.pos;
                        if (j2 >= this.bufferOffset) {
                            this.pos = j2 - 1;
                            UnsafeUtil.putByte(j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j3 = this.pos;
                        if (j3 > this.bufferOffset) {
                            this.pos = j3 - 1;
                            UnsafeUtil.putByte(j3, (byte) ((charAt2 & '?') | 128));
                            long j4 = this.pos;
                            this.pos = j4 - 1;
                            UnsafeUtil.putByte(j4, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j5 = this.pos;
                        if (j5 > this.bufferOffset + 1) {
                            this.pos = j5 - 1;
                            UnsafeUtil.putByte(j5, (byte) ((charAt2 & '?') | 128));
                            long j6 = this.pos;
                            this.pos = j6 - 1;
                            UnsafeUtil.putByte(j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            long j7 = this.pos;
                            this.pos = j7 - 1;
                            UnsafeUtil.putByte(j7, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.pos > this.bufferOffset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                long j8 = this.pos;
                                this.pos = j8 - 1;
                                UnsafeUtil.putByte(j8, (byte) ((codePoint & 63) | 128));
                                long j9 = this.pos;
                                this.pos = j9 - 1;
                                UnsafeUtil.putByte(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j10 = this.pos;
                                this.pos = j10 - 1;
                                UnsafeUtil.putByte(j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = this.pos;
                                this.pos = j11 - 1;
                                UnsafeUtil.putByte(j11, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void write(byte b) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, b);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            this.pos -= (long) i2;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i, i2);
        }

        public void writeLazy(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i, i2));
                nextBuffer();
                return;
            }
            this.pos -= (long) i2;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i, i2);
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            this.pos -= (long) remaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            this.pos -= (long) remaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }
    }
}
