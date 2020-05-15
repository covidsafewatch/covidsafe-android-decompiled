package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\f*\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\u0006*\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0007\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0010\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0011\u001a%\u0010\u000e\u001a\u00020\u0006*\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\t\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0018\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0011\u001a%\u0010\u0017\u001a\u00020\r*\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0019\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u001a"}, d2 = {"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "blackholeSink", "Lokio/Sink;", "blackhole", "appendingSink", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: Okio.kt */
public final class Okio {
    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, (Object) null);
    }

    public static final BufferedSource buffer(Source source) {
        Intrinsics.checkParameterIsNotNull(source, "$this$buffer");
        return new RealBufferedSource(source);
    }

    public static final BufferedSink buffer(Sink sink) {
        Intrinsics.checkParameterIsNotNull(sink, "$this$buffer");
        return new RealBufferedSink(sink);
    }

    public static final Sink sink(OutputStream outputStream) {
        Intrinsics.checkParameterIsNotNull(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Source source(InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final Sink sink(Socket socket) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkExpressionValueIsNotNull(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Source source(Socket socket) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkExpressionValueIsNotNull(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink sink(File file, boolean z) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "$this$sink");
        return sink((OutputStream) new FileOutputStream(file, z));
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return sink(file, z);
    }

    public static final Sink appendingSink(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "$this$appendingSink");
        return sink((OutputStream) new FileOutputStream(file, true));
    }

    public static final Source source(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "$this$source");
        return source((InputStream) new FileInputStream(file));
    }

    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkParameterIsNotNull(path, "$this$sink");
        Intrinsics.checkParameterIsNotNull(openOptionArr, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkExpressionValueIsNotNull(newOutputStream, "Files.newOutputStream(this, *options)");
        return sink(newOutputStream);
    }

    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkParameterIsNotNull(path, "$this$source");
        Intrinsics.checkParameterIsNotNull(openOptionArr, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkExpressionValueIsNotNull(newInputStream, "Files.newInputStream(this, *options)");
        return source(newInputStream);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        Intrinsics.checkParameterIsNotNull(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }
}
