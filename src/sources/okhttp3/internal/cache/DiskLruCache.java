package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010)\n\u0002\b\u0007*\u0001\u0012\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0004YZ[\\B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0016J!\u0010:\u001a\u0002082\n\u0010;\u001a\u00060<R\u00020\u00002\u0006\u0010=\u001a\u00020\u0015H\u0000¢\u0006\u0002\b>J\u0006\u0010?\u001a\u000208J \u0010@\u001a\b\u0018\u00010<R\u00020\u00002\u0006\u0010A\u001a\u00020'2\b\b\u0002\u0010B\u001a\u00020\u000bH\u0007J\u0006\u0010C\u001a\u000208J\b\u0010D\u001a\u000208H\u0016J\u0017\u0010E\u001a\b\u0018\u00010FR\u00020\u00002\u0006\u0010A\u001a\u00020'H\u0002J\u0006\u0010G\u001a\u000208J\u0006\u0010H\u001a\u00020\u0015J\b\u0010I\u001a\u00020\u0015H\u0002J\b\u0010J\u001a\u00020$H\u0002J\b\u0010K\u001a\u000208H\u0002J\b\u0010L\u001a\u000208H\u0002J\u0010\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020'H\u0002J\r\u0010O\u001a\u000208H\u0000¢\u0006\u0002\bPJ\u000e\u0010Q\u001a\u00020\u00152\u0006\u0010A\u001a\u00020'J\u0019\u0010R\u001a\u00020\u00152\n\u0010S\u001a\u00060(R\u00020\u0000H\u0000¢\u0006\u0002\bTJ\u0006\u00104\u001a\u00020\u000bJ\u0010\u0010U\u001a\f\u0012\b\u0012\u00060FR\u00020\u00000VJ\u0006\u0010W\u001a\u000208J\u0010\u0010X\u001a\u0002082\u0006\u0010A\u001a\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\b\u0012\u00060(R\u00020\u00000&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R&\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006]"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "closed", "", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "getValueCount$okhttp", "()I", "checkNotClosed", "", "close", "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", "flush", "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = CLEAN;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIRTY = DIRTY;
    public static final String JOURNAL_FILE = JOURNAL_FILE;
    public static final String JOURNAL_FILE_BACKUP = JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_TEMP = JOURNAL_FILE_TEMP;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String MAGIC = MAGIC;
    public static final String READ = READ;
    public static final String REMOVE = REMOVE;
    public static final String VERSION_1 = VERSION_1;
    private final int appVersion;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    /* access modifiers changed from: private */
    public boolean hasJournalErrors;
    /* access modifiers changed from: private */
    public boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    /* access modifiers changed from: private */
    public BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    /* access modifiers changed from: private */
    public boolean mostRecentRebuildFailed;
    /* access modifiers changed from: private */
    public boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size;
    private final int valueCount;

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0, 2, (Object) null);
    }

    public DiskLruCache(FileSystem fileSystem2, File file, int i, int i2, long j, TaskRunner taskRunner) {
        Intrinsics.checkParameterIsNotNull(fileSystem2, "fileSystem");
        Intrinsics.checkParameterIsNotNull(file, "directory");
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i;
        this.valueCount = i2;
        this.maxSize = j;
        boolean z = true;
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, Util.okHttpName + " Cache");
        if (j > 0) {
            if (this.valueCount <= 0 ? false : z) {
                this.journalFile = new File(this.directory, JOURNAL_FILE);
                this.journalFileTmp = new File(this.directory, JOURNAL_FILE_TEMP);
                this.journalFileBackup = new File(this.directory, JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
        }
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|(1:21)(1:22)|23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r11.redundantOpCount = r9 - r11.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        if (r3.exhausted() == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        rebuildJournal$okhttp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
        r11.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c4, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x006f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x008e=Splitter:B:26:0x008e, B:18:0x006f=Splitter:B:18:0x006f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r11.fileSystem
            java.io.File r2 = r11.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r3 = r1
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00be }
            java.lang.String r5 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00be }
            java.lang.String r6 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00be }
            java.lang.String r7 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00be }
            java.lang.String r8 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00be }
            java.lang.String r9 = MAGIC     // Catch:{ all -> 0x00be }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ all -> 0x00be }
            r10 = 1
            r9 = r9 ^ r10
            if (r9 != 0) goto L_0x008e
            java.lang.String r9 = VERSION_1     // Catch:{ all -> 0x00be }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)     // Catch:{ all -> 0x00be }
            r9 = r9 ^ r10
            if (r9 != 0) goto L_0x008e
            int r9 = r11.appVersion     // Catch:{ all -> 0x00be }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00be }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)     // Catch:{ all -> 0x00be }
            r6 = r6 ^ r10
            if (r6 != 0) goto L_0x008e
            int r6 = r11.valueCount     // Catch:{ all -> 0x00be }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00be }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x00be }
            r6 = r6 ^ r10
            if (r6 != 0) goto L_0x008e
            r6 = r8
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00be }
            int r6 = r6.length()     // Catch:{ all -> 0x00be }
            r9 = 0
            if (r6 <= 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r10 = 0
        L_0x0063:
            if (r10 != 0) goto L_0x008e
        L_0x0065:
            java.lang.String r0 = r3.readUtf8LineStrict()     // Catch:{ EOFException -> 0x006f }
            r11.readJournalLine(r0)     // Catch:{ EOFException -> 0x006f }
            int r9 = r9 + 1
            goto L_0x0065
        L_0x006f:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r11.lruEntries     // Catch:{ all -> 0x00be }
            int r0 = r0.size()     // Catch:{ all -> 0x00be }
            int r9 = r9 - r0
            r11.redundantOpCount = r9     // Catch:{ all -> 0x00be }
            boolean r0 = r3.exhausted()     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x0082
            r11.rebuildJournal$okhttp()     // Catch:{ all -> 0x00be }
            goto L_0x0088
        L_0x0082:
            okio.BufferedSink r0 = r11.newJournalWriter()     // Catch:{ all -> 0x00be }
            r11.journalWriter = r0     // Catch:{ all -> 0x00be }
        L_0x0088:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00be }
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            return
        L_0x008e:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r3.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r6 = "unexpected journal header: ["
            r3.append(r6)     // Catch:{ all -> 0x00be }
            r3.append(r4)     // Catch:{ all -> 0x00be }
            r3.append(r0)     // Catch:{ all -> 0x00be }
            r3.append(r5)     // Catch:{ all -> 0x00be }
            r3.append(r0)     // Catch:{ all -> 0x00be }
            r3.append(r7)     // Catch:{ all -> 0x00be }
            r3.append(r0)     // Catch:{ all -> 0x00be }
            r3.append(r8)     // Catch:{ all -> 0x00be }
            r0 = 93
            r3.append(r0)     // Catch:{ all -> 0x00be }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00be }
            r2.<init>(r0)     // Catch:{ all -> 0x00be }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x00be }
            throw r2     // Catch:{ all -> 0x00be }
        L_0x00be:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void readJournalLine(String str) throws IOException {
        String str2;
        String str3 = str;
        CharSequence charSequence = str3;
        int indexOf$default = StringsKt.indexOf$default(charSequence, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                if (str3 != null) {
                    str2 = str3.substring(i);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
                    if (indexOf$default == REMOVE.length() && StringsKt.startsWith$default(str3, REMOVE, false, 2, (Object) null)) {
                        this.lruEntries.remove(str2);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (str3 != null) {
                str2 = str3.substring(i, indexOf$default2);
                Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(this, str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf$default2 != -1 && indexOf$default == CLEAN.length() && StringsKt.startsWith$default(str3, CLEAN, false, 2, (Object) null)) {
                int i2 = indexOf$default2 + 1;
                if (str3 != null) {
                    String substring = str3.substring(i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    List split$default = StringsKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6, (Object) null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp((Editor) null);
                    entry.setLengths$okhttp(split$default);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else if (indexOf$default2 == -1 && indexOf$default == DIRTY.length() && StringsKt.startsWith$default(str3, DIRTY, false, 2, (Object) null)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
            } else if (indexOf$default2 != -1 || indexOf$default != READ.length() || !StringsKt.startsWith$default(str3, READ, false, 2, (Object) null)) {
                throw new IOException("unexpected journal line: " + str3);
            }
        } else {
            throw new IOException("unexpected journal line: " + str3);
        }
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "i.next()");
            Entry entry = next;
            int i = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    this.size += entry.getLengths$okhttp()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor$okhttp((Editor) null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cb, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void rebuildJournal$okhttp() throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            okio.BufferedSink r0 = r8.journalWriter     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00cc }
        L_0x0008:
            okhttp3.internal.io.FileSystem r0 = r8.fileSystem     // Catch:{ all -> 0x00cc }
            java.io.File r1 = r8.journalFileTmp     // Catch:{ all -> 0x00cc }
            okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x00cc }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00cc }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ all -> 0x00cc }
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00cc }
            r2 = r0
            okio.BufferedSink r2 = (okio.BufferedSink) r2     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = MAGIC     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r3 = r2.writeUtf8(r3)     // Catch:{ all -> 0x00c5 }
            r4 = 10
            r3.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = VERSION_1     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r3 = r2.writeUtf8(r3)     // Catch:{ all -> 0x00c5 }
            r3.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            int r3 = r8.appVersion     // Catch:{ all -> 0x00c5 }
            long r5 = (long) r3     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r3 = r2.writeDecimalLong(r5)     // Catch:{ all -> 0x00c5 }
            r3.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            int r3 = r8.valueCount     // Catch:{ all -> 0x00c5 }
            long r5 = (long) r3     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r3 = r2.writeDecimalLong(r5)     // Catch:{ all -> 0x00c5 }
            r3.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            r2.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r3 = r8.lruEntries     // Catch:{ all -> 0x00c5 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x00c5 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c5 }
        L_0x0051:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x0090
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x00c5 }
            okhttp3.internal.cache.DiskLruCache$Entry r5 = (okhttp3.internal.cache.DiskLruCache.Entry) r5     // Catch:{ all -> 0x00c5 }
            okhttp3.internal.cache.DiskLruCache$Editor r6 = r5.getCurrentEditor$okhttp()     // Catch:{ all -> 0x00c5 }
            r7 = 32
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = DIRTY     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r6 = r2.writeUtf8(r6)     // Catch:{ all -> 0x00c5 }
            r6.writeByte(r7)     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r5.getKey$okhttp()     // Catch:{ all -> 0x00c5 }
            r2.writeUtf8(r5)     // Catch:{ all -> 0x00c5 }
            r2.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            goto L_0x0051
        L_0x0079:
            java.lang.String r6 = CLEAN     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r6 = r2.writeUtf8(r6)     // Catch:{ all -> 0x00c5 }
            r6.writeByte(r7)     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = r5.getKey$okhttp()     // Catch:{ all -> 0x00c5 }
            r2.writeUtf8(r6)     // Catch:{ all -> 0x00c5 }
            r5.writeLengths$okhttp(r2)     // Catch:{ all -> 0x00c5 }
            r2.writeByte(r4)     // Catch:{ all -> 0x00c5 }
            goto L_0x0051
        L_0x0090:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c5 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x00cc }
            okhttp3.internal.io.FileSystem r0 = r8.fileSystem     // Catch:{ all -> 0x00cc }
            java.io.File r1 = r8.journalFile     // Catch:{ all -> 0x00cc }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x00a8
            okhttp3.internal.io.FileSystem r0 = r8.fileSystem     // Catch:{ all -> 0x00cc }
            java.io.File r1 = r8.journalFile     // Catch:{ all -> 0x00cc }
            java.io.File r2 = r8.journalFileBackup     // Catch:{ all -> 0x00cc }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00cc }
        L_0x00a8:
            okhttp3.internal.io.FileSystem r0 = r8.fileSystem     // Catch:{ all -> 0x00cc }
            java.io.File r1 = r8.journalFileTmp     // Catch:{ all -> 0x00cc }
            java.io.File r2 = r8.journalFile     // Catch:{ all -> 0x00cc }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00cc }
            okhttp3.internal.io.FileSystem r0 = r8.fileSystem     // Catch:{ all -> 0x00cc }
            java.io.File r1 = r8.journalFileBackup     // Catch:{ all -> 0x00cc }
            r0.delete(r1)     // Catch:{ all -> 0x00cc }
            okio.BufferedSink r0 = r8.newJournalWriter()     // Catch:{ all -> 0x00cc }
            r8.journalWriter = r0     // Catch:{ all -> 0x00cc }
            r0 = 0
            r8.hasJournalErrors = r0     // Catch:{ all -> 0x00cc }
            r8.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x00cc }
            monitor-exit(r8)
            return
        L_0x00c5:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x00cc }
            throw r2     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.rebuildJournal$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)     // Catch:{ all -> 0x0069 }
            r7.initialize()     // Catch:{ all -> 0x0069 }
            r7.checkNotClosed()     // Catch:{ all -> 0x0069 }
            r7.validateKey(r8)     // Catch:{ all -> 0x0069 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r7.lruEntries     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0069 }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0069 }
            r1 = 0
            if (r0 == 0) goto L_0x0067
            java.lang.String r2 = "lruEntries[key] ?: return null"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)     // Catch:{ all -> 0x0069 }
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x0027
            monitor-exit(r7)
            return r1
        L_0x0027:
            okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.snapshot$okhttp()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0065
            int r1 = r7.redundantOpCount     // Catch:{ all -> 0x0069 }
            int r1 = r1 + 1
            r7.redundantOpCount = r1     // Catch:{ all -> 0x0069 }
            okio.BufferedSink r1 = r7.journalWriter     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x003a
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0069 }
        L_0x003a:
            java.lang.String r2 = READ     // Catch:{ all -> 0x0069 }
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x0069 }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0069 }
            okio.BufferedSink r8 = r1.writeUtf8(r8)     // Catch:{ all -> 0x0069 }
            r1 = 10
            r8.writeByte(r1)     // Catch:{ all -> 0x0069 }
            boolean r8 = r7.journalRebuildRequired()     // Catch:{ all -> 0x0069 }
            if (r8 == 0) goto L_0x0063
            okhttp3.internal.concurrent.TaskQueue r1 = r7.cleanupQueue     // Catch:{ all -> 0x0069 }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r8 = r7.cleanupTask     // Catch:{ all -> 0x0069 }
            r2 = r8
            okhttp3.internal.concurrent.Task r2 = (okhttp3.internal.concurrent.Task) r2     // Catch:{ all -> 0x0069 }
            r3 = 0
            r5 = 2
            r6 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x0069 }
        L_0x0063:
            monitor-exit(r7)
            return r0
        L_0x0065:
            monitor-exit(r7)
            return r1
        L_0x0067:
            monitor-exit(r7)
            return r1
        L_0x0069:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r11, long r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)     // Catch:{ all -> 0x008c }
            r10.initialize()     // Catch:{ all -> 0x008c }
            r10.checkNotClosed()     // Catch:{ all -> 0x008c }
            r10.validateKey(r11)     // Catch:{ all -> 0x008c }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r10.lruEntries     // Catch:{ all -> 0x008c }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x008c }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x008c }
            long r1 = ANY_SEQUENCE_NUMBER     // Catch:{ all -> 0x008c }
            r3 = 0
            int r4 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0028
            long r1 = r0.getSequenceNumber$okhttp()     // Catch:{ all -> 0x008c }
            int r4 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            monitor-exit(r10)
            return r3
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            okhttp3.internal.cache.DiskLruCache$Editor r12 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x008c }
            goto L_0x0032
        L_0x0031:
            r12 = r3
        L_0x0032:
            if (r12 == 0) goto L_0x0036
            monitor-exit(r10)
            return r3
        L_0x0036:
            boolean r12 = r10.mostRecentTrimFailed     // Catch:{ all -> 0x008c }
            if (r12 != 0) goto L_0x007c
            boolean r12 = r10.mostRecentRebuildFailed     // Catch:{ all -> 0x008c }
            if (r12 == 0) goto L_0x003f
            goto L_0x007c
        L_0x003f:
            okio.BufferedSink r12 = r10.journalWriter     // Catch:{ all -> 0x008c }
            if (r12 != 0) goto L_0x0046
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x008c }
        L_0x0046:
            java.lang.String r13 = DIRTY     // Catch:{ all -> 0x008c }
            okio.BufferedSink r13 = r12.writeUtf8(r13)     // Catch:{ all -> 0x008c }
            r1 = 32
            okio.BufferedSink r13 = r13.writeByte(r1)     // Catch:{ all -> 0x008c }
            okio.BufferedSink r13 = r13.writeUtf8(r11)     // Catch:{ all -> 0x008c }
            r1 = 10
            r13.writeByte(r1)     // Catch:{ all -> 0x008c }
            r12.flush()     // Catch:{ all -> 0x008c }
            boolean r12 = r10.hasJournalErrors     // Catch:{ all -> 0x008c }
            if (r12 == 0) goto L_0x0064
            monitor-exit(r10)
            return r3
        L_0x0064:
            if (r0 != 0) goto L_0x0072
            okhttp3.internal.cache.DiskLruCache$Entry r0 = new okhttp3.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x008c }
            r0.<init>(r10, r11)     // Catch:{ all -> 0x008c }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r12 = r10.lruEntries     // Catch:{ all -> 0x008c }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ all -> 0x008c }
            r12.put(r11, r0)     // Catch:{ all -> 0x008c }
        L_0x0072:
            okhttp3.internal.cache.DiskLruCache$Editor r11 = new okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x008c }
            r11.<init>(r10, r0)     // Catch:{ all -> 0x008c }
            r0.setCurrentEditor$okhttp(r11)     // Catch:{ all -> 0x008c }
            monitor-exit(r10)
            return r11
        L_0x007c:
            okhttp3.internal.concurrent.TaskQueue r4 = r10.cleanupQueue     // Catch:{ all -> 0x008c }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r11 = r10.cleanupTask     // Catch:{ all -> 0x008c }
            r5 = r11
            okhttp3.internal.concurrent.Task r5 = (okhttp3.internal.concurrent.Task) r5     // Catch:{ all -> 0x008c }
            r6 = 0
            r8 = 2
            r9 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r4, r5, r6, r8, r9)     // Catch:{ all -> 0x008c }
            monitor-exit(r10)
            return r3
        L_0x008c:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache.Editor r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "editor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)     // Catch:{ all -> 0x013e }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = r9.getEntry$okhttp()     // Catch:{ all -> 0x013e }
            okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x013e }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x013e }
            if (r1 == 0) goto L_0x0130
            r1 = 0
            if (r10 == 0) goto L_0x0065
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x013e }
            if (r2 != 0) goto L_0x0065
            int r2 = r8.valueCount     // Catch:{ all -> 0x013e }
            r3 = 0
        L_0x0020:
            if (r3 >= r2) goto L_0x0065
            boolean[] r4 = r9.getWritten$okhttp()     // Catch:{ all -> 0x013e }
            if (r4 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x013e }
        L_0x002b:
            boolean r4 = r4[r3]     // Catch:{ all -> 0x013e }
            if (r4 == 0) goto L_0x0049
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x013e }
            java.util.List r5 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x013e }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x013e }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x013e }
            boolean r4 = r4.exists(r5)     // Catch:{ all -> 0x013e }
            if (r4 != 0) goto L_0x0046
            r9.abort()     // Catch:{ all -> 0x013e }
            monitor-exit(r8)
            return
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0049:
            r9.abort()     // Catch:{ all -> 0x013e }
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            r10.<init>()     // Catch:{ all -> 0x013e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r10.append(r0)     // Catch:{ all -> 0x013e }
            r10.append(r3)     // Catch:{ all -> 0x013e }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x013e }
            r9.<init>(r10)     // Catch:{ all -> 0x013e }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x013e }
            throw r9     // Catch:{ all -> 0x013e }
        L_0x0065:
            int r9 = r8.valueCount     // Catch:{ all -> 0x013e }
        L_0x0067:
            if (r1 >= r9) goto L_0x00ad
            java.util.List r2 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x013e }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x013e }
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x013e }
            if (r10 == 0) goto L_0x00a5
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x013e }
            boolean r3 = r3.exists(r2)     // Catch:{ all -> 0x013e }
            if (r3 == 0) goto L_0x00aa
            java.util.List r3 = r0.getCleanFiles$okhttp()     // Catch:{ all -> 0x013e }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x013e }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x013e }
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x013e }
            r4.rename(r2, r3)     // Catch:{ all -> 0x013e }
            long[] r2 = r0.getLengths$okhttp()     // Catch:{ all -> 0x013e }
            r4 = r2[r1]     // Catch:{ all -> 0x013e }
            okhttp3.internal.io.FileSystem r2 = r8.fileSystem     // Catch:{ all -> 0x013e }
            long r2 = r2.size(r3)     // Catch:{ all -> 0x013e }
            long[] r6 = r0.getLengths$okhttp()     // Catch:{ all -> 0x013e }
            r6[r1] = r2     // Catch:{ all -> 0x013e }
            long r6 = r8.size     // Catch:{ all -> 0x013e }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.size = r6     // Catch:{ all -> 0x013e }
            goto L_0x00aa
        L_0x00a5:
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x013e }
            r3.delete(r2)     // Catch:{ all -> 0x013e }
        L_0x00aa:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x00ad:
            int r9 = r8.redundantOpCount     // Catch:{ all -> 0x013e }
            r1 = 1
            int r9 = r9 + r1
            r8.redundantOpCount = r9     // Catch:{ all -> 0x013e }
            r9 = 0
            okhttp3.internal.cache.DiskLruCache$Editor r9 = (okhttp3.internal.cache.DiskLruCache.Editor) r9     // Catch:{ all -> 0x013e }
            r0.setCurrentEditor$okhttp(r9)     // Catch:{ all -> 0x013e }
            okio.BufferedSink r9 = r8.journalWriter     // Catch:{ all -> 0x013e }
            if (r9 != 0) goto L_0x00c0
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x013e }
        L_0x00c0:
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x013e }
            r3 = 10
            r4 = 32
            if (r2 != 0) goto L_0x00ea
            if (r10 == 0) goto L_0x00cd
            goto L_0x00ea
        L_0x00cd:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r10 = r8.lruEntries     // Catch:{ all -> 0x013e }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x013e }
            r10.remove(r1)     // Catch:{ all -> 0x013e }
            java.lang.String r10 = REMOVE     // Catch:{ all -> 0x013e }
            okio.BufferedSink r10 = r9.writeUtf8(r10)     // Catch:{ all -> 0x013e }
            r10.writeByte(r4)     // Catch:{ all -> 0x013e }
            java.lang.String r10 = r0.getKey$okhttp()     // Catch:{ all -> 0x013e }
            r9.writeUtf8(r10)     // Catch:{ all -> 0x013e }
            r9.writeByte(r3)     // Catch:{ all -> 0x013e }
            goto L_0x010f
        L_0x00ea:
            r0.setReadable$okhttp(r1)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = CLEAN     // Catch:{ all -> 0x013e }
            okio.BufferedSink r1 = r9.writeUtf8(r1)     // Catch:{ all -> 0x013e }
            r1.writeByte(r4)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x013e }
            r9.writeUtf8(r1)     // Catch:{ all -> 0x013e }
            r0.writeLengths$okhttp(r9)     // Catch:{ all -> 0x013e }
            r9.writeByte(r3)     // Catch:{ all -> 0x013e }
            if (r10 == 0) goto L_0x010f
            long r1 = r8.nextSequenceNumber     // Catch:{ all -> 0x013e }
            r3 = 1
            long r3 = r3 + r1
            r8.nextSequenceNumber = r3     // Catch:{ all -> 0x013e }
            r0.setSequenceNumber$okhttp(r1)     // Catch:{ all -> 0x013e }
        L_0x010f:
            r9.flush()     // Catch:{ all -> 0x013e }
            long r9 = r8.size     // Catch:{ all -> 0x013e }
            long r0 = r8.maxSize     // Catch:{ all -> 0x013e }
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0120
            boolean r9 = r8.journalRebuildRequired()     // Catch:{ all -> 0x013e }
            if (r9 == 0) goto L_0x012e
        L_0x0120:
            okhttp3.internal.concurrent.TaskQueue r0 = r8.cleanupQueue     // Catch:{ all -> 0x013e }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r9 = r8.cleanupTask     // Catch:{ all -> 0x013e }
            r1 = r9
            okhttp3.internal.concurrent.Task r1 = (okhttp3.internal.concurrent.Task) r1     // Catch:{ all -> 0x013e }
            r2 = 0
            r4 = 2
            r5 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r0, r1, r2, r4, r5)     // Catch:{ all -> 0x013e }
        L_0x012e:
            monitor-exit(r8)
            return
        L_0x0130:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x013e }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x013e }
            r10.<init>(r9)     // Catch:{ all -> 0x013e }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ all -> 0x013e }
            throw r10     // Catch:{ all -> 0x013e }
        L_0x013e:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)     // Catch:{ all -> 0x0033 }
            r6.initialize()     // Catch:{ all -> 0x0033 }
            r6.checkNotClosed()     // Catch:{ all -> 0x0033 }
            r6.validateKey(r7)     // Catch:{ all -> 0x0033 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r6.lruEntries     // Catch:{ all -> 0x0033 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0033 }
            okhttp3.internal.cache.DiskLruCache$Entry r7 = (okhttp3.internal.cache.DiskLruCache.Entry) r7     // Catch:{ all -> 0x0033 }
            r0 = 0
            if (r7 == 0) goto L_0x0031
            java.lang.String r1 = "lruEntries[key] ?: return false"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)     // Catch:{ all -> 0x0033 }
            boolean r7 = r6.removeEntry$okhttp(r7)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x002f
            long r1 = r6.size     // Catch:{ all -> 0x0033 }
            long r3 = r6.maxSize     // Catch:{ all -> 0x0033 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002f
            r6.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0033 }
        L_0x002f:
            monitor-exit(r6)
            return r7
        L_0x0031:
            monitor-exit(r6)
            return r0
        L_0x0033:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink == null) {
            Intrinsics.throwNpe();
        }
        bufferedSink.writeUtf8(REMOVE).writeByte(32).writeUtf8(entry.getKey$okhttp()).writeByte(10);
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
        }
        return true;
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink == null) {
                Intrinsics.throwNpe();
            }
            bufferedSink.flush();
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public synchronized void close() throws IOException {
        if (this.initialized) {
            if (!this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                Intrinsics.checkExpressionValueIsNotNull(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array != null) {
                    for (Entry entry : (Entry[]) array) {
                        if (entry.getCurrentEditor$okhttp() != null) {
                            Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
                            if (currentEditor$okhttp == null) {
                                Intrinsics.throwNpe();
                            }
                            currentEditor$okhttp.abort();
                        }
                    }
                    trimToSize();
                    BufferedSink bufferedSink = this.journalWriter;
                    if (bufferedSink == null) {
                        Intrinsics.throwNpe();
                    }
                    bufferedSink.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.closed = true;
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            Entry next = this.lruEntries.values().iterator().next();
            Intrinsics.checkExpressionValueIsNotNull(next, "lruEntries.values.iterator().next()");
            removeEntry$okhttp(next);
        }
        this.mostRecentTrimFailed = false;
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array != null) {
            for (Entry entry : (Entry[]) array) {
                Intrinsics.checkExpressionValueIsNotNull(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Typography.quote).toString());
        }
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "close", "", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getLength", "index", "", "getSource", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DiskLruCache.kt */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j, List<? extends Source> list, long[] jArr) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            Intrinsics.checkParameterIsNotNull(list, "sources");
            Intrinsics.checkParameterIsNotNull(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.sources = list;
            this.lengths = jArr;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource(int i) {
            return this.sources.get(i);
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "abort", "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DiskLruCache.kt */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry2) {
            Intrinsics.checkParameterIsNotNull(entry2, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry2;
            this.written = entry2.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final void detach$okhttp() {
            if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor$okhttp(), (Object) this)) {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i = 0; i < valueCount$okhttp; i++) {
                    try {
                        this.this$0.getFileSystem$okhttp().delete(this.entry.getDirtyFiles$okhttp().get(i));
                    } catch (IOException unused) {
                    }
                }
                this.entry.setCurrentEditor$okhttp((Editor) null);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Source newSource(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x004c }
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x003e
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004c }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x004c }
                r2 = 0
                if (r1 == 0) goto L_0x003c
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004c }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x004c }
                r3 = r4
                okhttp3.internal.cache.DiskLruCache$Editor r3 = (okhttp3.internal.cache.DiskLruCache.Editor) r3     // Catch:{ all -> 0x004c }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ all -> 0x004c }
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x0024
                goto L_0x003c
            L_0x0024:
                okhttp3.internal.cache.DiskLruCache r1 = r4.this$0     // Catch:{ FileNotFoundException -> 0x003a }
                okhttp3.internal.io.FileSystem r1 = r1.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x003a }
                okhttp3.internal.cache.DiskLruCache$Entry r3 = r4.entry     // Catch:{ FileNotFoundException -> 0x003a }
                java.util.List r3 = r3.getCleanFiles$okhttp()     // Catch:{ FileNotFoundException -> 0x003a }
                java.lang.Object r5 = r3.get(r5)     // Catch:{ FileNotFoundException -> 0x003a }
                java.io.File r5 = (java.io.File) r5     // Catch:{ FileNotFoundException -> 0x003a }
                okio.Source r2 = r1.source(r5)     // Catch:{ FileNotFoundException -> 0x003a }
            L_0x003a:
                monitor-exit(r0)
                return r2
            L_0x003c:
                monitor-exit(r0)
                return r2
            L_0x003e:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004c }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004c }
                r1.<init>(r5)     // Catch:{ all -> 0x004c }
                java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x004c }
                throw r1     // Catch:{ all -> 0x004c }
            L_0x004c:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:24|25|26|27) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r5 = okio.Okio.blackhole();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
            return r5;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0056 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Sink newSink(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x006a }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x005c
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x006a }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x006a }
                r3 = r4
                okhttp3.internal.cache.DiskLruCache$Editor r3 = (okhttp3.internal.cache.DiskLruCache.Editor) r3     // Catch:{ all -> 0x006a }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ all -> 0x006a }
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x001f
                okio.Sink r5 = okio.Okio.blackhole()     // Catch:{ all -> 0x006a }
                monitor-exit(r0)
                return r5
            L_0x001f:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x006a }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x006a }
                if (r1 != 0) goto L_0x0030
                boolean[] r1 = r4.written     // Catch:{ all -> 0x006a }
                if (r1 != 0) goto L_0x002e
                kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x006a }
            L_0x002e:
                r1[r5] = r2     // Catch:{ all -> 0x006a }
            L_0x0030:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x006a }
                java.util.List r1 = r1.getDirtyFiles$okhttp()     // Catch:{ all -> 0x006a }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x006a }
                java.io.File r1 = (java.io.File) r1     // Catch:{ all -> 0x006a }
                okhttp3.internal.cache.DiskLruCache r2 = r4.this$0     // Catch:{ FileNotFoundException -> 0x0056 }
                okhttp3.internal.io.FileSystem r2 = r2.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x0056 }
                okio.Sink r1 = r2.sink(r1)     // Catch:{ FileNotFoundException -> 0x0056 }
                okhttp3.internal.cache.FaultHidingSink r2 = new okhttp3.internal.cache.FaultHidingSink     // Catch:{ all -> 0x006a }
                okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 r3 = new okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x006a }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x006a }
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x006a }
                r2.<init>(r1, r3)     // Catch:{ all -> 0x006a }
                okio.Sink r2 = (okio.Sink) r2     // Catch:{ all -> 0x006a }
                monitor-exit(r0)
                return r2
            L_0x0056:
                okio.Sink r5 = okio.Okio.blackhole()     // Catch:{ all -> 0x006a }
                monitor-exit(r0)
                return r5
            L_0x005c:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006a }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006a }
                r1.<init>(r5)     // Catch:{ all -> 0x006a }
                java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x006a }
                throw r1     // Catch:{ all -> 0x006a }
            L_0x006a:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):okio.Sink");
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor$okhttp(), (Object) this)) {
                        this.this$0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor$okhttp(), (Object) this)) {
                        this.this$0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0002J\u001b\u0010)\u001a\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0000¢\u0006\u0002\b+J\u0013\u0010,\u001a\b\u0018\u00010-R\u00020\fH\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00063"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "key", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "", "Ljava/io/File;", "getCleanFiles$okhttp", "()Ljava/util/List;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles$okhttp", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "invalidLengths", "Ljava/io/IOException;", "strings", "", "setLengths", "", "setLengths$okhttp", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DiskLruCache.kt */
    public final class Entry {
        private final List<File> cleanFiles = new ArrayList();
        private Editor currentEditor;
        private final List<File> dirtyFiles = new ArrayList();
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public Entry(DiskLruCache diskLruCache, String str) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            StringBuilder sb = new StringBuilder(this.key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                sb.append(i);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            Intrinsics.checkParameterIsNotNull(list, "strings");
            if (list.size() == this.this$0.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(list.get(i));
                    }
                } catch (NumberFormatException unused) {
                    throw invalidLengths(list);
                }
            } else {
                throw invalidLengths(list);
            }
        }

        public final void writeLengths$okhttp(BufferedSink bufferedSink) throws IOException {
            Intrinsics.checkParameterIsNotNull(bufferedSink, "writer");
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }

        private final IOException invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
                List<Source> arrayList = new ArrayList<>();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i = 0; i < valueCount$okhttp; i++) {
                        arrayList.add(this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i)));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (Source closeQuietly : arrayList) {
                        Util.closeQuietly((Closeable) closeQuietly);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(diskLruCache);
                throw new AssertionError(sb.toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DiskLruCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(this);
                throw new AssertionError(sb.toString());
            }
        }
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.Companion.get();
                    platform.log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        }
    }
}
