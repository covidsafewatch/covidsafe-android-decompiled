package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 1, mv = {1, 1, 16})
@Deprecated(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedOkio  reason: invalid class name */
/* compiled from: -DeprecatedOkio.kt */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    public final Sink appendingSink(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return Okio.appendingSink(file);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sink.buffer()", imports = {"okio.buffer"}))
    public final BufferedSink buffer(Sink sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        return Okio.buffer(sink);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "source.buffer()", imports = {"okio.buffer"}))
    public final BufferedSource buffer(Source source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        return Okio.buffer(source);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.sink()", imports = {"okio.sink"}))
    public final Sink sink(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return Okio.sink$default(file, false, 1, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "outputStream.sink()", imports = {"okio.sink"}))
    public final Sink sink(OutputStream outputStream) {
        Intrinsics.checkParameterIsNotNull(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.sink(*options)", imports = {"okio.sink"}))
    public final Sink sink(Path path, OpenOption... openOptionArr) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.sink()", imports = {"okio.sink"}))
    public final Sink sink(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        return Okio.sink(socket);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.source()", imports = {"okio.source"}))
    public final Source source(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return Okio.source(file);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputStream.source()", imports = {"okio.source"}))
    public final Source source(InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.source(*options)", imports = {"okio.source"}))
    public final Source source(Path path, OpenOption... openOptionArr) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.source()", imports = {"okio.source"}))
    public final Source source(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        return Okio.source(socket);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    public final Sink blackhole() {
        return Okio.blackhole();
    }
}
