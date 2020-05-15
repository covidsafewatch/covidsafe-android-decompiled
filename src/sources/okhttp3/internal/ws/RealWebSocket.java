package okhttp3.internal.ws;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0005[\\]^_B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203J\b\u00104\u001a\u000200H\u0016J\u001f\u00105\u001a\u0002002\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0000¢\u0006\u0002\b:J\u001a\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\fJ\u000e\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020AJ\u001c\u0010B\u001a\u0002002\n\u0010C\u001a\u00060Dj\u0002`E2\b\u00106\u001a\u0004\u0018\u000107J\u0016\u0010F\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u0006\u0010G\u001a\u000200J\u0018\u0010H\u001a\u0002002\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0015H\u0016J\u0010\u0010I\u001a\u0002002\u0006\u0010J\u001a\u00020\u0015H\u0016J\u0010\u0010I\u001a\u0002002\u0006\u0010K\u001a\u00020\u001dH\u0016J\u0010\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\u001dH\u0016J\u0010\u0010N\u001a\u0002002\u0006\u0010M\u001a\u00020\u001dH\u0016J\u000e\u0010O\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u001dJ\u0006\u0010P\u001a\u00020\u000fJ\b\u0010\u001e\u001a\u00020\fH\u0016J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\b\u0010Q\u001a\u00020\u0006H\u0016J\b\u0010R\u001a\u000200H\u0002J\u0010\u0010S\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0015H\u0016J\u0010\u0010S\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u001dH\u0016J\u0018\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020\"J\u0006\u0010V\u001a\u000200J\r\u0010W\u001a\u00020\u000fH\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u000200H\u0000¢\u0006\u0002\bZR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealWebSocket.kt */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    /* access modifiers changed from: private */
    public String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random2, long j) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(request, "originalRequest");
        Intrinsics.checkParameterIsNotNull(webSocketListener, "listener");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random2;
        this.pingIntervalMillis = j;
        this.taskQueue = taskRunner.newQueue();
        if (Intrinsics.areEqual((Object) "GET", (Object) this.originalRequest.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] bArr = new byte[16];
            this.random.nextBytes(bArr);
            this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, (Object) null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + this.originalRequest.method()).toString());
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public Request request() {
        return this.originalRequest;
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public void cancel() {
        Call call2 = this.call;
        if (call2 == null) {
            Intrinsics.throwNpe();
        }
        call2.cancel();
    }

    public final void connect(OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request build2 = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").build();
        Call realCall = new RealCall(build, build2, true);
        this.call = realCall;
        if (realCall == null) {
            Intrinsics.throwNpe();
        }
        realCall.enqueue(new RealWebSocket$connect$1(this, build2));
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, HttpHeaders.CONNECTION, (String) null, 2, (Object) null);
            if (StringsKt.equals(HttpHeaders.UPGRADE, header$default, true)) {
                String header$default2 = Response.header$default(response, HttpHeaders.UPGRADE, (String) null, 2, (Object) null);
                if (StringsKt.equals("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, (String) null, 2, (Object) null);
                    ByteString.Companion companion = ByteString.Companion;
                    String base64 = companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (!Intrinsics.areEqual((Object) base64, (Object) header$default3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(streams2, "streams");
        synchronized (this) {
            this.name = str;
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random);
            this.writerTask = new WriterTask();
            if (this.pingIntervalMillis != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                String str2 = str + " ping";
                this.taskQueue.schedule(new RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(str2, str2, nanos, this, str, streams2), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this);
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                Intrinsics.throwNpe();
            }
            webSocketReader.processNextFrame();
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                Intrinsics.throwNpe();
            }
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, (Response) null);
            return false;
        }
    }

    public final void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j, timeUnit);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public void onReadMessage(String str) throws IOException {
        Intrinsics.checkParameterIsNotNull(str, "text");
        this.listener.onMessage((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        this.listener.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)     // Catch:{ all -> 0x0029 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0027
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0029 }
            r0.add(r2)     // Catch:{ all -> 0x0029 }
            r1.runWriter()     // Catch:{ all -> 0x0029 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0029 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)
            return
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public void onReadClose(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "reason");
        boolean z = true;
        if (i != -1) {
            Streams streams2 = null;
            synchronized (this) {
                if (this.receivedCloseCode != -1) {
                    z = false;
                }
                if (z) {
                    this.receivedCloseCode = i;
                    this.receivedCloseReason = str;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        streams2 = this.streams;
                        this.streams = null;
                        this.taskQueue.shutdown();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("already closed".toString());
                }
            }
            try {
                this.listener.onClosing(this, i, str);
                if (streams2 != null) {
                    this.listener.onClosed(this, i, str);
                }
            } finally {
                if (streams2 != null) {
                    Util.closeQuietly((Closeable) streams2);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public boolean send(String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        return send(ByteString.Companion.encodeUtf8(str), 1);
    }

    public boolean send(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        return send(byteString, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean send(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }

    public final synchronized boolean pong(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "payload");
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return false;
    }

    public boolean close(int i, String str) {
        return close(i, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean close(int r8, java.lang.String r9, long r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            okhttp3.internal.ws.WebSocketProtocol r0 = okhttp3.internal.ws.WebSocketProtocol.INSTANCE     // Catch:{ all -> 0x005d }
            r0.validateCloseCode(r8)     // Catch:{ all -> 0x005d }
            r0 = 0
            okio.ByteString r0 = (okio.ByteString) r0     // Catch:{ all -> 0x005d }
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0041
            okio.ByteString$Companion r0 = okio.ByteString.Companion     // Catch:{ all -> 0x005d }
            okio.ByteString r0 = r0.encodeUtf8(r9)     // Catch:{ all -> 0x005d }
            int r3 = r0.size()     // Catch:{ all -> 0x005d }
            long r3 = (long) r3     // Catch:{ all -> 0x005d }
            r5 = 123(0x7b, double:6.1E-322)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0020
            r3 = r2
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            if (r3 == 0) goto L_0x0024
            goto L_0x0041
        L_0x0024:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r8.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r10 = "reason.size() > 123: "
            r8.append(r10)     // Catch:{ all -> 0x005d }
            r8.append(r9)     // Catch:{ all -> 0x005d }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x005d }
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005d }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x005d }
            r9.<init>(r8)     // Catch:{ all -> 0x005d }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x005d }
            throw r9     // Catch:{ all -> 0x005d }
        L_0x0041:
            boolean r9 = r7.failed     // Catch:{ all -> 0x005d }
            if (r9 != 0) goto L_0x005b
            boolean r9 = r7.enqueuedClose     // Catch:{ all -> 0x005d }
            if (r9 == 0) goto L_0x004a
            goto L_0x005b
        L_0x004a:
            r7.enqueuedClose = r2     // Catch:{ all -> 0x005d }
            java.util.ArrayDeque<java.lang.Object> r9 = r7.messageAndCloseQueue     // Catch:{ all -> 0x005d }
            okhttp3.internal.ws.RealWebSocket$Close r1 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x005d }
            r1.<init>(r8, r0, r10)     // Catch:{ all -> 0x005d }
            r9.add(r1)     // Catch:{ all -> 0x005d }
            r7.runWriter()     // Catch:{ all -> 0x005d }
            monitor-exit(r7)
            return r2
        L_0x005b:
            monitor-exit(r7)
            return r1
        L_0x005d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cd, code lost:
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cf, code lost:
        if (r3 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d1, code lost:
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d3, code lost:
        if (r1 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d8, code lost:
        r1.writePong(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00db, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00df, code lost:
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e5, code lost:
        if ((r0.element instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e7, code lost:
        r2 = r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e9, code lost:
        if (r2 == null) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00eb, code lost:
        r2 = ((okhttp3.internal.ws.RealWebSocket.Message) r2).getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f1, code lost:
        if (r1 != null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f3, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f6, code lost:
        r0 = r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (r0 == null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fa, code lost:
        r0 = okio.Okio.buffer(r1.newMessageSink(((okhttp3.internal.ws.RealWebSocket.Message) r0).getFormatOpcode(), (long) r2.size()));
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0113, code lost:
        monitor-enter(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r13.queueSize -= (long) r2.size();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        monitor-exit(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012c, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0134, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        if ((r0.element instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013b, code lost:
        r0 = r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013d, code lost:
        if (r0 == null) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        r0 = (okhttp3.internal.ws.RealWebSocket.Close) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0141, code lost:
        if (r1 != null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0143, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0146, code lost:
        r1.writeClose(r0.getCode(), r0.getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0151, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0157, code lost:
        if (((okhttp3.internal.ws.RealWebSocket.Streams) r1.element) == null) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0159, code lost:
        r0 = r13.listener;
        r2 = r13;
        r3 = r14.element;
        r4 = (java.lang.String) r15.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0164, code lost:
        if (r4 != null) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0166, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0169, code lost:
        r0.onClosed(r2, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x016c, code lost:
        r1 = (okhttp3.internal.ws.RealWebSocket.Streams) r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0171, code lost:
        if (r1 == null) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0173, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0178, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0179, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0182, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0183, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x018c, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x018d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x018f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0190, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0192, code lost:
        r1 = (okhttp3.internal.ws.RealWebSocket.Streams) r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0196, code lost:
        if (r1 != null) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0198, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x019d, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            r23 = this;
            r13 = r23
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r1 = 0
            r0.element = r1
            kotlin.jvm.internal.Ref$IntRef r14 = new kotlin.jvm.internal.Ref$IntRef
            r14.<init>()
            r2 = -1
            r14.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            r15.element = r3
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r3 = r1
            okhttp3.internal.ws.RealWebSocket$Streams r3 = (okhttp3.internal.ws.RealWebSocket.Streams) r3
            r12.element = r3
            monitor-enter(r23)
            boolean r3 = r13.failed     // Catch:{ all -> 0x019e }
            r4 = 0
            if (r3 == 0) goto L_0x002e
            monitor-exit(r23)
            return r4
        L_0x002e:
            okhttp3.internal.ws.WebSocketWriter r11 = r13.writer     // Catch:{ all -> 0x019e }
            java.util.ArrayDeque<okio.ByteString> r3 = r13.pongQueue     // Catch:{ all -> 0x019e }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x019e }
            r10 = r3
            okio.ByteString r10 = (okio.ByteString) r10     // Catch:{ all -> 0x019e }
            if (r10 != 0) goto L_0x00c4
            java.util.ArrayDeque<java.lang.Object> r3 = r13.messageAndCloseQueue     // Catch:{ all -> 0x019e }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x019e }
            r0.element = r3     // Catch:{ all -> 0x019e }
            T r3 = r0.element     // Catch:{ all -> 0x019e }
            boolean r3 = r3 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x019e }
            if (r3 == 0) goto L_0x00b8
            int r3 = r13.receivedCloseCode     // Catch:{ all -> 0x019e }
            r14.element = r3     // Catch:{ all -> 0x019e }
            java.lang.String r3 = r13.receivedCloseReason     // Catch:{ all -> 0x019e }
            r15.element = r3     // Catch:{ all -> 0x019e }
            int r3 = r14.element     // Catch:{ all -> 0x019e }
            if (r3 == r2) goto L_0x0064
            okhttp3.internal.ws.RealWebSocket$Streams r2 = r13.streams     // Catch:{ all -> 0x019e }
            r12.element = r2     // Catch:{ all -> 0x019e }
            okhttp3.internal.ws.RealWebSocket$Streams r1 = (okhttp3.internal.ws.RealWebSocket.Streams) r1     // Catch:{ all -> 0x019e }
            r13.streams = r1     // Catch:{ all -> 0x019e }
            okhttp3.internal.concurrent.TaskQueue r1 = r13.taskQueue     // Catch:{ all -> 0x019e }
            r1.shutdown()     // Catch:{ all -> 0x019e }
            goto L_0x00c4
        L_0x0064:
            T r1 = r0.element     // Catch:{ all -> 0x019e }
            if (r1 == 0) goto L_0x00b0
            okhttp3.internal.ws.RealWebSocket$Close r1 = (okhttp3.internal.ws.RealWebSocket.Close) r1     // Catch:{ all -> 0x019e }
            long r1 = r1.getCancelAfterCloseMillis()     // Catch:{ all -> 0x019e }
            okhttp3.internal.concurrent.TaskQueue r9 = r13.taskQueue     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019e }
            r3.<init>()     // Catch:{ all -> 0x019e }
            java.lang.String r4 = r13.name     // Catch:{ all -> 0x019e }
            r3.append(r4)     // Catch:{ all -> 0x019e }
            java.lang.String r4 = " cancel"
            r3.append(r4)     // Catch:{ all -> 0x019e }
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x019e }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x019e }
            long r7 = r3.toNanos(r1)     // Catch:{ all -> 0x019e }
            r5 = 1
            okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1 r16 = new okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x019e }
            r1 = r16
            r2 = r4
            r3 = r5
            r6 = r23
            r17 = r7
            r7 = r11
            r8 = r10
            r19 = r9
            r9 = r0
            r20 = r10
            r10 = r14
            r21 = r11
            r11 = r15
            r22 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x019e }
            r1 = r16
            okhttp3.internal.concurrent.Task r1 = (okhttp3.internal.concurrent.Task) r1     // Catch:{ all -> 0x019e }
            r3 = r17
            r2 = r19
            r2.schedule(r1, r3)     // Catch:{ all -> 0x019e }
            goto L_0x00ca
        L_0x00b0:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x019e }
            java.lang.String r1 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close"
            r0.<init>(r1)     // Catch:{ all -> 0x019e }
            throw r0     // Catch:{ all -> 0x019e }
        L_0x00b8:
            r20 = r10
            r21 = r11
            r22 = r12
            T r1 = r0.element     // Catch:{ all -> 0x019e }
            if (r1 != 0) goto L_0x00ca
            monitor-exit(r23)
            return r4
        L_0x00c4:
            r20 = r10
            r21 = r11
            r22 = r12
        L_0x00ca:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x019e }
            monitor-exit(r23)
            r3 = r20
            if (r3 == 0) goto L_0x00df
            r1 = r21
            if (r1 != 0) goto L_0x00d8
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x018f }
        L_0x00d8:
            r1.writePong(r3)     // Catch:{ all -> 0x018f }
        L_0x00db:
            r1 = r22
            goto L_0x016c
        L_0x00df:
            r1 = r21
            T r2 = r0.element     // Catch:{ all -> 0x018f }
            boolean r2 = r2 instanceof okhttp3.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x018f }
            if (r2 == 0) goto L_0x0135
            T r2 = r0.element     // Catch:{ all -> 0x018f }
            if (r2 == 0) goto L_0x012d
            okhttp3.internal.ws.RealWebSocket$Message r2 = (okhttp3.internal.ws.RealWebSocket.Message) r2     // Catch:{ all -> 0x018f }
            okio.ByteString r2 = r2.getData()     // Catch:{ all -> 0x018f }
            if (r1 != 0) goto L_0x00f6
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x018f }
        L_0x00f6:
            T r0 = r0.element     // Catch:{ all -> 0x018f }
            if (r0 == 0) goto L_0x0125
            okhttp3.internal.ws.RealWebSocket$Message r0 = (okhttp3.internal.ws.RealWebSocket.Message) r0     // Catch:{ all -> 0x018f }
            int r0 = r0.getFormatOpcode()     // Catch:{ all -> 0x018f }
            int r3 = r2.size()     // Catch:{ all -> 0x018f }
            long r3 = (long) r3     // Catch:{ all -> 0x018f }
            okio.Sink r0 = r1.newMessageSink(r0, r3)     // Catch:{ all -> 0x018f }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x018f }
            r0.write((okio.ByteString) r2)     // Catch:{ all -> 0x018f }
            r0.close()     // Catch:{ all -> 0x018f }
            monitor-enter(r23)     // Catch:{ all -> 0x018f }
            long r0 = r13.queueSize     // Catch:{ all -> 0x0122 }
            int r2 = r2.size()     // Catch:{ all -> 0x0122 }
            long r2 = (long) r2     // Catch:{ all -> 0x0122 }
            long r0 = r0 - r2
            r13.queueSize = r0     // Catch:{ all -> 0x0122 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0122 }
            monitor-exit(r23)     // Catch:{ all -> 0x018f }
            goto L_0x00db
        L_0x0122:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x018f }
            throw r0     // Catch:{ all -> 0x018f }
        L_0x0125:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x018f }
            java.lang.String r1 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message"
            r0.<init>(r1)     // Catch:{ all -> 0x018f }
            throw r0     // Catch:{ all -> 0x018f }
        L_0x012d:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x018f }
            java.lang.String r1 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message"
            r0.<init>(r1)     // Catch:{ all -> 0x018f }
            throw r0     // Catch:{ all -> 0x018f }
        L_0x0135:
            T r2 = r0.element     // Catch:{ all -> 0x018f }
            boolean r2 = r2 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x018f }
            if (r2 == 0) goto L_0x0183
            T r0 = r0.element     // Catch:{ all -> 0x018f }
            if (r0 == 0) goto L_0x0179
            okhttp3.internal.ws.RealWebSocket$Close r0 = (okhttp3.internal.ws.RealWebSocket.Close) r0     // Catch:{ all -> 0x018f }
            if (r1 != 0) goto L_0x0146
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x018f }
        L_0x0146:
            int r2 = r0.getCode()     // Catch:{ all -> 0x018f }
            okio.ByteString r0 = r0.getReason()     // Catch:{ all -> 0x018f }
            r1.writeClose(r2, r0)     // Catch:{ all -> 0x018f }
            r1 = r22
            T r0 = r1.element     // Catch:{ all -> 0x018d }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = (okhttp3.internal.ws.RealWebSocket.Streams) r0     // Catch:{ all -> 0x018d }
            if (r0 == 0) goto L_0x016c
            okhttp3.WebSocketListener r0 = r13.listener     // Catch:{ all -> 0x018d }
            r2 = r13
            okhttp3.WebSocket r2 = (okhttp3.WebSocket) r2     // Catch:{ all -> 0x018d }
            int r3 = r14.element     // Catch:{ all -> 0x018d }
            T r4 = r15.element     // Catch:{ all -> 0x018d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x018d }
            if (r4 != 0) goto L_0x0169
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x018d }
        L_0x0169:
            r0.onClosed(r2, r3, r4)     // Catch:{ all -> 0x018d }
        L_0x016c:
            r0 = 1
            T r1 = r1.element
            okhttp3.internal.ws.RealWebSocket$Streams r1 = (okhttp3.internal.ws.RealWebSocket.Streams) r1
            if (r1 == 0) goto L_0x0178
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0178:
            return r0
        L_0x0179:
            r1 = r22
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x018d }
            java.lang.String r2 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close"
            r0.<init>(r2)     // Catch:{ all -> 0x018d }
            throw r0     // Catch:{ all -> 0x018d }
        L_0x0183:
            r1 = r22
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x018d }
            r0.<init>()     // Catch:{ all -> 0x018d }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x018d }
            throw r0     // Catch:{ all -> 0x018d }
        L_0x018d:
            r0 = move-exception
            goto L_0x0192
        L_0x018f:
            r0 = move-exception
            r1 = r22
        L_0x0192:
            T r1 = r1.element
            okhttp3.internal.ws.RealWebSocket$Streams r1 = (okhttp3.internal.ws.RealWebSocket.Streams) r1
            if (r1 == 0) goto L_0x019d
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x019d:
            throw r0
        L_0x019e:
            r0 = move-exception
            monitor-exit(r23)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r1 == -1) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r0 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r0.writePing(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame$okhttp() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.writer     // Catch:{ all -> 0x005e }
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x005e }
            r2 = -1
            if (r1 == 0) goto L_0x0011
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x005e }
            goto L_0x0012
        L_0x0011:
            r1 = r2
        L_0x0012:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x005e }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x005e }
            r7.awaitingPong = r4     // Catch:{ all -> 0x005e }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005e }
            monitor-exit(r7)
            r3 = 0
            if (r1 == r2) goto L_0x004c
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.pingIntervalMillis
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            java.lang.Exception r0 = (java.lang.Exception) r0
            r7.failWebSocket(r0, r3)
            return
        L_0x004c:
            if (r0 != 0) goto L_0x0051
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ IOException -> 0x0057 }
        L_0x0051:
            okio.ByteString r1 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x0057 }
            r0.writePing(r1)     // Catch:{ IOException -> 0x0057 }
            goto L_0x005d
        L_0x0057:
            r0 = move-exception
            java.lang.Exception r0 = (java.lang.Exception) r0
            r7.failWebSocket(r0, r3)
        L_0x005d:
            return
        L_0x005e:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writePingFrame$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.listener.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(java.lang.Exception r4, okhttp3.Response r5) {
        /*
            r3 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            monitor-enter(r3)
            boolean r0 = r3.failed     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)
            return
        L_0x000c:
            r0 = 1
            r3.failed = r0     // Catch:{ all -> 0x0039 }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r3.streams     // Catch:{ all -> 0x0039 }
            r1 = 0
            okhttp3.internal.ws.RealWebSocket$Streams r1 = (okhttp3.internal.ws.RealWebSocket.Streams) r1     // Catch:{ all -> 0x0039 }
            r3.streams = r1     // Catch:{ all -> 0x0039 }
            okhttp3.internal.concurrent.TaskQueue r1 = r3.taskQueue     // Catch:{ all -> 0x0039 }
            r1.shutdown()     // Catch:{ all -> 0x0039 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            monitor-exit(r3)
            okhttp3.WebSocketListener r1 = r3.listener     // Catch:{ all -> 0x0030 }
            r2 = r3
            okhttp3.WebSocket r2 = (okhttp3.WebSocket) r2     // Catch:{ all -> 0x0030 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0030 }
            r1.onFailure(r2, r4, r5)     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            java.io.Closeable r0 = (java.io.Closeable) r0
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x002f:
            return
        L_0x0030:
            r4 = move-exception
            if (r0 == 0) goto L_0x0038
            java.io.Closeable r0 = (java.io.Closeable) r0
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x0038:
            throw r4
        L_0x0039:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealWebSocket.kt */
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i, ByteString byteString) {
            Intrinsics.checkParameterIsNotNull(byteString, "data");
            this.formatOpcode = i;
            this.data = byteString;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealWebSocket.kt */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealWebSocket.kt */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Intrinsics.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics.checkParameterIsNotNull(bufferedSink, "sink");
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealWebSocket.kt */
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, (DefaultConstructorMarker) null);
        }

        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, (Response) null);
                return -1;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealWebSocket.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0, 2, (Object) null);
                return;
            }
            return;
        }
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
