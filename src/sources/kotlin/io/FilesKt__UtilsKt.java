package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a(\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a(\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/io/FilesKt")
/* compiled from: Utils.kt */
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempDir(str, str2, file);
    }

    public static final File createTempDir(String str, String str2, File file) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            Intrinsics.checkExpressionValueIsNotNull(createTempFile, "dir");
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempFile(str, str2, file);
    }

    public static final File createTempFile(String str, String str2, File file) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static final String getExtension(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$extension");
        String name = file.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        return StringsKt.substringAfterLast(name, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$invariantSeparatorsPath");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            Intrinsics.checkExpressionValueIsNotNull(path, "path");
            return StringsKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path2, "path");
        return path2;
    }

    public static final String getNameWithoutExtension(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$nameWithoutExtension");
        String name = file.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        return StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    public static final String toRelativeString(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$toRelativeString");
        Intrinsics.checkParameterIsNotNull(file2, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    public static final File relativeTo(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$relativeTo");
        Intrinsics.checkParameterIsNotNull(file2, "base");
        return new File(FilesKt.toRelativeString(file, file2));
    }

    public static final File relativeToOrSelf(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$relativeToOrSelf");
        Intrinsics.checkParameterIsNotNull(file2, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }

    public static final File relativeToOrNull(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$relativeToOrNull");
        Intrinsics.checkParameterIsNotNull(file2, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt.toComponents(file));
        FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(file2));
        if (!Intrinsics.areEqual((Object) normalize$FilesKt__UtilsKt.getRoot(), (Object) normalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = normalize$FilesKt__UtilsKt2.getSize();
        int size2 = normalize$FilesKt__UtilsKt.getSize();
        int i = 0;
        int min = Math.min(size2, size);
        while (i < min && Intrinsics.areEqual((Object) normalize$FilesKt__UtilsKt.getSegments().get(i), (Object) normalize$FilesKt__UtilsKt2.getSegments().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = size - 1;
        if (i2 >= i) {
            while (!Intrinsics.areEqual((Object) normalize$FilesKt__UtilsKt2.getSegments().get(i2).getName(), (Object) "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < size2) {
            if (i < size) {
                sb.append(File.separatorChar);
            }
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            CollectionsKt.joinTo$default(CollectionsKt.drop(normalize$FilesKt__UtilsKt.getSegments(), i), sb, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null);
        }
        return sb.toString();
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return FilesKt.copyTo(file, file2, z, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0088, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File copyTo(java.io.File r6, java.io.File r7, boolean r8, int r9) {
        /*
            java.lang.String r0 = "$this$copyTo"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0089
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x0033
            if (r8 == 0) goto L_0x0029
            boolean r8 = r7.delete()
            if (r8 == 0) goto L_0x001f
            goto L_0x0033
        L_0x001f:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "Tried to overwrite the destination, but failed to delete it."
            r8.<init>(r6, r7, r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x0029:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "The destination file already exists."
            r8.<init>(r6, r7, r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x0033:
            boolean r8 = r6.isDirectory()
            if (r8 == 0) goto L_0x004a
            boolean r8 = r7.mkdirs()
            if (r8 == 0) goto L_0x0040
            goto L_0x007a
        L_0x0040:
            kotlin.io.FileSystemException r8 = new kotlin.io.FileSystemException
            java.lang.String r9 = "Failed to create target directory."
            r8.<init>(r6, r7, r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x004a:
            java.io.File r8 = r7.getParentFile()
            if (r8 == 0) goto L_0x0053
            r8.mkdirs()
        L_0x0053:
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r6)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r6 = 0
            r0 = r6
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r8
            java.io.FileInputStream r1 = (java.io.FileInputStream) r1     // Catch:{ all -> 0x0082 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0082 }
            r2.<init>(r7)     // Catch:{ all -> 0x0082 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0082 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0082 }
            r3 = r2
            java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x007b }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x007b }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x007b }
            kotlin.io.ByteStreamsKt.copyTo(r1, r3, r9)     // Catch:{ all -> 0x007b }
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x0082 }
            kotlin.io.CloseableKt.closeFinally(r8, r0)
        L_0x007a:
            return r7
        L_0x007b:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x007d }
        L_0x007d:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x0082 }
            throw r7     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r6)
            throw r7
        L_0x0089:
            kotlin.io.NoSuchFileException r7 = new kotlin.io.NoSuchFileException
            r2 = 0
            r4 = 2
            r5 = 0
            java.lang.String r3 = "The source file doesn't exist."
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.copyTo(java.io.File, java.io.File, boolean, int):java.io.File");
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = FilesKt__UtilsKt$copyRecursively$1.INSTANCE;
        }
        return FilesKt.copyRecursively(file, file2, z, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a2 A[Catch:{ TerminateException -> 0x00e6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean copyRecursively(java.io.File r11, java.io.File r12, boolean r13, kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            java.lang.String r0 = "$this$copyRecursively"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            java.lang.String r0 = "onError"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0030
            kotlin.io.NoSuchFileException r12 = new kotlin.io.NoSuchFileException
            r5 = 0
            r7 = 2
            r8 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.invoke(r11, r12)
            kotlin.io.OnErrorAction r11 = (kotlin.io.OnErrorAction) r11
            kotlin.io.OnErrorAction r12 = kotlin.io.OnErrorAction.TERMINATE
            if (r11 == r12) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            return r1
        L_0x0030:
            kotlin.io.FileTreeWalk r0 = kotlin.io.FilesKt.walkTopDown(r11)     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.FilesKt__UtilsKt$copyRecursively$2 r3 = new kotlin.io.FilesKt__UtilsKt$copyRecursively$2     // Catch:{ TerminateException -> 0x00e6 }
            r3.<init>(r14)     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.FileTreeWalk r0 = r0.onFail(r3)     // Catch:{ TerminateException -> 0x00e6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ TerminateException -> 0x00e6 }
        L_0x0043:
            boolean r3 = r0.hasNext()     // Catch:{ TerminateException -> 0x00e6 }
            if (r3 == 0) goto L_0x00e5
            java.lang.Object r3 = r0.next()     // Catch:{ TerminateException -> 0x00e6 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ TerminateException -> 0x00e6 }
            boolean r4 = r3.exists()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 != 0) goto L_0x006c
            kotlin.io.NoSuchFileException r10 = new kotlin.io.NoSuchFileException     // Catch:{ TerminateException -> 0x00e6 }
            r6 = 0
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ TerminateException -> 0x00e6 }
            java.lang.Object r3 = r14.invoke(r3, r10)     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.OnErrorAction r3 = (kotlin.io.OnErrorAction) r3     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00e6 }
            if (r3 != r4) goto L_0x0043
            return r2
        L_0x006c:
            java.lang.String r4 = kotlin.io.FilesKt.toRelativeString(r3, r11)     // Catch:{ TerminateException -> 0x00e6 }
            java.io.File r5 = new java.io.File     // Catch:{ TerminateException -> 0x00e6 }
            r5.<init>(r12, r4)     // Catch:{ TerminateException -> 0x00e6 }
            boolean r4 = r5.exists()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 == 0) goto L_0x00b4
            boolean r4 = r3.isDirectory()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 == 0) goto L_0x0087
            boolean r4 = r5.isDirectory()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 != 0) goto L_0x00b4
        L_0x0087:
            if (r13 != 0) goto L_0x008b
        L_0x0089:
            r4 = 1
            goto L_0x00a0
        L_0x008b:
            boolean r4 = r5.isDirectory()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 == 0) goto L_0x0098
            boolean r4 = kotlin.io.FilesKt.deleteRecursively(r5)     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 != 0) goto L_0x009f
            goto L_0x0089
        L_0x0098:
            boolean r4 = r5.delete()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 != 0) goto L_0x009f
            goto L_0x0089
        L_0x009f:
            r4 = 0
        L_0x00a0:
            if (r4 == 0) goto L_0x00b4
            kotlin.io.FileAlreadyExistsException r4 = new kotlin.io.FileAlreadyExistsException     // Catch:{ TerminateException -> 0x00e6 }
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch:{ TerminateException -> 0x00e6 }
            java.lang.Object r3 = r14.invoke(r5, r4)     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.OnErrorAction r3 = (kotlin.io.OnErrorAction) r3     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00e6 }
            if (r3 != r4) goto L_0x0043
            return r2
        L_0x00b4:
            boolean r4 = r3.isDirectory()     // Catch:{ TerminateException -> 0x00e6 }
            if (r4 == 0) goto L_0x00be
            r5.mkdirs()     // Catch:{ TerminateException -> 0x00e6 }
            goto L_0x0043
        L_0x00be:
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = kotlin.io.FilesKt.copyTo$default(r4, r5, r6, r7, r8, r9)     // Catch:{ TerminateException -> 0x00e6 }
            long r4 = r4.length()     // Catch:{ TerminateException -> 0x00e6 }
            long r6 = r3.length()     // Catch:{ TerminateException -> 0x00e6 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0043
            java.io.IOException r4 = new java.io.IOException     // Catch:{ TerminateException -> 0x00e6 }
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch:{ TerminateException -> 0x00e6 }
            java.lang.Object r3 = r14.invoke(r3, r4)     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.OnErrorAction r3 = (kotlin.io.OnErrorAction) r3     // Catch:{ TerminateException -> 0x00e6 }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00e6 }
            if (r3 != r4) goto L_0x0043
            return r2
        L_0x00e5:
            return r1
        L_0x00e6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.copyRecursively(java.io.File, java.io.File, boolean, kotlin.jvm.functions.Function2):boolean");
    }

    public static final boolean deleteRecursively(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$deleteRecursively");
        Iterator it = FilesKt.walkBottomUp(file).iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                File file2 = (File) it.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
        }
    }

    public static final boolean startsWith(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(file2, "other");
        FilePathComponents components = FilesKt.toComponents(file);
        FilePathComponents components2 = FilesKt.toComponents(file2);
        if (!(!Intrinsics.areEqual((Object) components.getRoot(), (Object) components2.getRoot())) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    public static final boolean startsWith(File file, String str) {
        Intrinsics.checkParameterIsNotNull(file, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(str, "other");
        return FilesKt.startsWith(file, new File(str));
    }

    public static final boolean endsWith(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(file2, "other");
        FilePathComponents components = FilesKt.toComponents(file);
        FilePathComponents components2 = FilesKt.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual((Object) file, (Object) file2);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    public static final boolean endsWith(File file, String str) {
        Intrinsics.checkParameterIsNotNull(file, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(str, "other");
        return FilesKt.endsWith(file, new File(str));
    }

    public static final File normalize(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$normalize");
        FilePathComponents components = FilesKt.toComponents(file);
        File root = components.getRoot();
        String str = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
        return FilesKt.resolve(root, CollectionsKt.joinToString$default(normalize$FilesKt__UtilsKt((List<? extends File>) components.getSegments()), str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt((List<? extends File>) filePathComponents.getSegments()));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        List<File> arrayList = new ArrayList<>(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!Intrinsics.areEqual((Object) ((File) CollectionsKt.last(arrayList)).getName(), (Object) ".."))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    public static final File resolve(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$resolve");
        Intrinsics.checkParameterIsNotNull(file2, "relative");
        if (FilesKt.isRooted(file2)) {
            return file2;
        }
        String file3 = file.toString();
        Intrinsics.checkExpressionValueIsNotNull(file3, "this.toString()");
        CharSequence charSequence = file3;
        if ((charSequence.length() == 0) || StringsKt.endsWith$default(charSequence, File.separatorChar, false, 2, (Object) null)) {
            return new File(file3 + file2);
        }
        return new File(file3 + File.separatorChar + file2);
    }

    public static final File resolve(File file, String str) {
        Intrinsics.checkParameterIsNotNull(file, "$this$resolve");
        Intrinsics.checkParameterIsNotNull(str, "relative");
        return FilesKt.resolve(file, new File(str));
    }

    public static final File resolveSibling(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$resolveSibling");
        Intrinsics.checkParameterIsNotNull(file2, "relative");
        FilePathComponents components = FilesKt.toComponents(file);
        return FilesKt.resolve(FilesKt.resolve(components.getRoot(), components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1)), file2);
    }

    public static final File resolveSibling(File file, String str) {
        Intrinsics.checkParameterIsNotNull(file, "$this$resolveSibling");
        Intrinsics.checkParameterIsNotNull(str, "relative");
        return FilesKt.resolveSibling(file, new File(str));
    }
}
