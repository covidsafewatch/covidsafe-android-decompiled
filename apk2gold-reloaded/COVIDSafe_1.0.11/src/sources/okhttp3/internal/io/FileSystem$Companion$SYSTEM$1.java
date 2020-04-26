package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"okhttp3/internal/io/FileSystem$Companion$SYSTEM$1", "Lokhttp3/internal/io/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", "from", "to", "sink", "size", "", "source", "Lokio/Source;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileSystem.kt */
public final class FileSystem$Companion$SYSTEM$1 implements FileSystem {
    FileSystem$Companion$SYSTEM$1() {
    }

    public Source source(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return Okio.source(file);
    }

    public Sink sink(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            return Okio.sink$default(file, false, 1, null);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return Okio.sink$default(file, false, 1, null);
        }
    }

    public Sink appendingSink(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            return Okio.appendingSink(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return Okio.appendingSink(file);
        }
    }

    public void delete(File file) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!file.delete() && file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed to delete ");
            sb.append(file);
            throw new IOException(sb.toString());
        }
    }

    public boolean exists(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.exists();
    }

    public long size(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.length();
    }

    public void rename(File file, File file2) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "from");
        Intrinsics.checkParameterIsNotNull(file2, "to");
        delete(file2);
        if (!file.renameTo(file2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed to rename ");
            sb.append(file);
            sb.append(" to ");
            sb.append(file2);
            throw new IOException(sb.toString());
        }
    }

    public void deleteContents(File file) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "directory");
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                Intrinsics.checkExpressionValueIsNotNull(file2, "file");
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("failed to delete ");
                    sb.append(file2);
                    throw new IOException(sb.toString());
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("not a readable directory: ");
        sb2.append(file);
        throw new IOException(sb2.toString());
    }
}
