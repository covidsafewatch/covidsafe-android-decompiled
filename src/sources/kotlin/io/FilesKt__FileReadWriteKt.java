package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\b\u001a?\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010/\u001a\u000200*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\b\u0002\b\n\u0006\b\u0011(+0\u0001¨\u00061"}, d2 = {"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/io/FilesKt")
/* compiled from: FileReadWrite.kt */
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    static /* synthetic */ InputStreamReader reader$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    private static final InputStreamReader reader(File file, Charset charset) {
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i);
    }

    private static final BufferedReader bufferedReader(File file, Charset charset, int i) {
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    private static final OutputStreamWriter writer(File file, Charset charset) {
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i);
    }

    private static final BufferedWriter bufferedWriter(File file, Charset charset, int i) {
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i);
    }

    static /* synthetic */ PrintWriter printWriter$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    private static final PrintWriter printWriter(File file, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bb, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00be, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] readBytes(java.io.File r12) {
        /*
            java.lang.String r0 = "$this$readBytes"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r12)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r3 = r0
            java.io.FileInputStream r3 = (java.io.FileInputStream) r3     // Catch:{ all -> 0x00b8 }
            long r4 = r12.length()     // Catch:{ all -> 0x00b8 }
            r6 = 2147483647(0x7fffffff, float:NaN)
            long r6 = (long) r6
            java.lang.String r8 = "File "
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 > 0) goto L_0x0094
            int r5 = (int) r4
            byte[] r4 = new byte[r5]     // Catch:{ all -> 0x00b8 }
            r6 = 0
            r7 = r5
            r9 = 0
        L_0x0027:
            if (r7 <= 0) goto L_0x0033
            int r10 = r3.read(r4, r9, r7)     // Catch:{ all -> 0x00b8 }
            if (r10 >= 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            int r7 = r7 - r10
            int r9 = r9 + r10
            goto L_0x0027
        L_0x0033:
            java.lang.String r10 = "java.util.Arrays.copyOf(this, newSize)"
            if (r7 <= 0) goto L_0x003f
            byte[] r4 = java.util.Arrays.copyOf(r4, r9)     // Catch:{ all -> 0x00b8 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r10)     // Catch:{ all -> 0x00b8 }
            goto L_0x0074
        L_0x003f:
            int r7 = r3.read()     // Catch:{ all -> 0x00b8 }
            r9 = -1
            if (r7 != r9) goto L_0x0047
            goto L_0x0074
        L_0x0047:
            kotlin.io.ExposingBufferByteArrayOutputStream r9 = new kotlin.io.ExposingBufferByteArrayOutputStream     // Catch:{ all -> 0x00b8 }
            r11 = 8193(0x2001, float:1.1481E-41)
            r9.<init>(r11)     // Catch:{ all -> 0x00b8 }
            r9.write(r7)     // Catch:{ all -> 0x00b8 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x00b8 }
            r7 = r9
            java.io.OutputStream r7 = (java.io.OutputStream) r7     // Catch:{ all -> 0x00b8 }
            r11 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r3, r7, r6, r11, r1)     // Catch:{ all -> 0x00b8 }
            int r1 = r9.size()     // Catch:{ all -> 0x00b8 }
            int r1 = r1 + r5
            if (r1 < 0) goto L_0x0078
            byte[] r12 = r9.getBuffer()     // Catch:{ all -> 0x00b8 }
            byte[] r1 = java.util.Arrays.copyOf(r4, r1)     // Catch:{ all -> 0x00b8 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)     // Catch:{ all -> 0x00b8 }
            int r3 = r9.size()     // Catch:{ all -> 0x00b8 }
            byte[] r4 = kotlin.collections.ArraysKt.copyInto((byte[]) r12, (byte[]) r1, (int) r5, (int) r6, (int) r3)     // Catch:{ all -> 0x00b8 }
        L_0x0074:
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return r4
        L_0x0078:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r2.<init>()     // Catch:{ all -> 0x00b8 }
            r2.append(r8)     // Catch:{ all -> 0x00b8 }
            r2.append(r12)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = " is too big to fit in memory."
            r2.append(r12)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x00b8 }
            r1.<init>(r12)     // Catch:{ all -> 0x00b8 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00b8 }
            throw r1     // Catch:{ all -> 0x00b8 }
        L_0x0094:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r2.<init>()     // Catch:{ all -> 0x00b8 }
            r2.append(r8)     // Catch:{ all -> 0x00b8 }
            r2.append(r12)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = " is too big ("
            r2.append(r12)     // Catch:{ all -> 0x00b8 }
            r2.append(r4)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = " bytes) to fit in memory."
            r2.append(r12)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x00b8 }
            r1.<init>(r12)     // Catch:{ all -> 0x00b8 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00b8 }
            throw r1     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r12)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.readBytes(java.io.File):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void writeBytes(java.io.File r2, byte[] r3) {
        /*
            java.lang.String r0 = "$this$writeBytes"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r2)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0020 }
            r1.write(r3)     // Catch:{ all -> 0x0020 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0020 }
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return
        L_0x0020:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.writeBytes(java.io.File, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void appendBytes(java.io.File r2, byte[] r3) {
        /*
            java.lang.String r0 = "$this$appendBytes"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r1 = 1
            r0.<init>(r2, r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0021 }
            r1.write(r3)     // Catch:{ all -> 0x0021 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0021 }
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return
        L_0x0021:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.appendBytes(java.io.File, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readText(java.io.File r1, java.nio.charset.Charset r2) {
        /*
            java.lang.String r0 = "$this$readText"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            java.io.InputStream r0 = (java.io.InputStream) r0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r0, r2)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r0 = r1
            java.io.InputStreamReader r0 = (java.io.InputStreamReader) r0     // Catch:{ all -> 0x0028 }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0028 }
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            return r0
        L_0x0028:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002a }
        L_0x002a:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.readText(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readText(file, charset);
    }

    public static final void writeText(File file, String str, Charset charset) {
        Intrinsics.checkParameterIsNotNull(file, "$this$writeText");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        FilesKt.writeBytes(file, bytes);
    }

    public static /* synthetic */ void writeText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.writeText(file, str, charset);
    }

    public static final void appendText(File file, String str, Charset charset) {
        Intrinsics.checkParameterIsNotNull(file, "$this$appendText");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        FilesKt.appendBytes(file, bytes);
    }

    public static /* synthetic */ void appendText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.appendText(file, str, charset);
    }

    public static final void forEachBlock(File file, Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$forEachBlock");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        FilesKt.forEachBlock(file, 4096, function2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void forEachBlock(java.io.File r3, int r4, kotlin.jvm.functions.Function2<? super byte[], ? super java.lang.Integer, kotlin.Unit> r5) {
        /*
            java.lang.String r0 = "$this$forEachBlock"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            r0 = 512(0x200, float:7.175E-43)
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r0)
            byte[] r4 = new byte[r4]
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r3 = 0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r1 = r0
            java.io.FileInputStream r1 = (java.io.FileInputStream) r1     // Catch:{ all -> 0x0033 }
        L_0x001f:
            int r2 = r1.read(r4)     // Catch:{ all -> 0x0033 }
            if (r2 > 0) goto L_0x002b
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0033 }
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return
        L_0x002b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0033 }
            r5.invoke(r4, r2)     // Catch:{ all -> 0x0033 }
            goto L_0x001f
        L_0x0033:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.forEachBlock(java.io.File, int, kotlin.jvm.functions.Function2):void");
    }

    public static /* synthetic */ void forEachLine$default(File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file, charset, function1);
    }

    public static final void forEachLine(File file, Charset charset, Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(file, "$this$forEachLine");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
    }

    private static final FileInputStream inputStream(File file) {
        return new FileInputStream(file);
    }

    private static final FileOutputStream outputStream(File file) {
        return new FileOutputStream(file);
    }

    public static /* synthetic */ List readLines$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readLines(file, charset);
    }

    public static final List<String> readLines(File file, Charset charset) {
        Intrinsics.checkParameterIsNotNull(file, "$this$readLines");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        ArrayList arrayList = new ArrayList();
        FilesKt.forEachLine(file, charset, new FilesKt__FileReadWriteKt$readLines$1(arrayList));
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object useLines$default(java.io.File r1, java.nio.charset.Charset r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) {
        /*
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0006
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
        L_0x0006:
            java.lang.String r4 = "$this$useLines"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r4)
            java.lang.String r4 = "charset"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r4)
            java.lang.String r4 = "block"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r4)
            r4 = 8192(0x2000, float:1.14794E-41)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            java.io.InputStream r0 = (java.io.InputStream) r0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r0, r2)
            java.io.Reader r1 = (java.io.Reader) r1
            boolean r2 = r1 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x002c
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0032
        L_0x002c:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r2.<init>(r1, r4)
            r1 = r2
        L_0x0032:
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r4 = 0
            r0 = r1
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x0057 }
            kotlin.sequences.Sequence r0 = kotlin.io.TextStreamsKt.lineSequence(r0)     // Catch:{ all -> 0x0057 }
            java.lang.Object r3 = r3.invoke(r0)     // Catch:{ all -> 0x0057 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r4 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r5, r5, r4)
            if (r4 == 0) goto L_0x0050
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            goto L_0x0053
        L_0x0050:
            r1.close()
        L_0x0053:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            return r3
        L_0x0057:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r4 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r5, r5, r4)
            if (r4 != 0) goto L_0x0067
            r1.close()     // Catch:{ all -> 0x006a }
            goto L_0x006a
        L_0x0067:
            kotlin.io.CloseableKt.closeFinally(r1, r2)
        L_0x006a:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.useLines$default(java.io.File, java.nio.charset.Charset, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T useLines(java.io.File r3, java.nio.charset.Charset r4, kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r5) {
        /*
            java.lang.String r0 = "$this$useLines"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
            java.io.InputStream r0 = (java.io.InputStream) r0
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            r3.<init>(r0, r4)
            java.io.Reader r3 = (java.io.Reader) r3
            boolean r4 = r3 instanceof java.io.BufferedReader
            if (r4 == 0) goto L_0x0024
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            goto L_0x002c
        L_0x0024:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r0)
            r3 = r4
        L_0x002c:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = 0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r0 = 0
            r1 = 1
            r2 = r3
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x0052 }
            kotlin.sequences.Sequence r2 = kotlin.io.TextStreamsKt.lineSequence(r2)     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r5.invoke(r2)     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r1, r1, r0)
            if (r0 == 0) goto L_0x004b
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            goto L_0x004e
        L_0x004b:
            r3.close()
        L_0x004e:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r5
        L_0x0052:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r1, r1, r0)
            if (r0 != 0) goto L_0x0062
            r3.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0065
        L_0x0062:
            kotlin.io.CloseableKt.closeFinally(r3, r4)
        L_0x0065:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.useLines(java.io.File, java.nio.charset.Charset, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
