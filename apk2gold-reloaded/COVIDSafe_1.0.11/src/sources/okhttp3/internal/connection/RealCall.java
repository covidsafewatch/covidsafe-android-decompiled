package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001)\u0018\u00002\u00020\u0001:\u0002`aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010,\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0000H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0016J\u0016\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0007J\b\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u0007H\u0000¢\u0006\u0002\b?J\r\u0010@\u001a\u00020<H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020DH\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u00020\u0007H\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J)\u0010H\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010K\u001a\u0002HI2\u0006\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010MJ;\u0010N\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010K\u001a\u0002HIH\u0000¢\u0006\u0004\bQ\u0010RJ\u0019\u0010%\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020UH\u0000¢\u0006\u0002\bVJ\u000f\u0010W\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0002\bYJ\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010Z\u001a\u00020\u0007J\b\u0010(\u001a\u00020[H\u0016J\u0006\u0010+\u001a\u00020-J!\u0010\\\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010]\u001a\u0002HIH\u0002¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020UH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "setConnection", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeRequestDone", "exchangeResponseDone", "executed", "getForWebSocket", "()Z", "<set-?>", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "noMoreExchanges", "getOriginalRequest", "()Lokhttp3/Request;", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "maybeReleaseConnection", "E", "Ljava/io/IOException;", "e", "force", "(Ljava/io/IOException;Z)Ljava/io/IOException;", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "(Ljava/io/IOException;)Ljava/io/IOException;", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealCall.kt */
public final class RealCall implements Call {
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener = this.client.eventListenerFactory().create(this);
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean executed;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private boolean noMoreExchanges;
    private final Request originalRequest;
    /* access modifiers changed from: private */
    public final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", "run", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealCall.kt */
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            Intrinsics.checkParameterIsNotNull(callback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            Intrinsics.checkParameterIsNotNull(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final void executeOn(ExecutorService executorService) {
            Intrinsics.checkParameterIsNotNull(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (!Util.assertionsEnabled || !Thread.holdsLock(dispatcher)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                } catch (Throwable th) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(dispatcher);
                throw new AssertionError(sb.toString());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A[Catch:{ all -> 0x0082, all -> 0x00d4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ all -> 0x0082, all -> 0x00d4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae A[Catch:{ all -> 0x0082, all -> 0x00d4 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "OkHttp "
                r0.append(r1)
                okhttp3.internal.connection.RealCall r1 = r7.this$0
                java.lang.String r1 = r1.redactedUrl$okhttp()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r2 = "currentThread"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                java.lang.String r2 = r1.getName()
                r1.setName(r0)
                r0 = 0
                okhttp3.internal.connection.RealCall r3 = r7.this$0     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.connection.RealCall$timeout$1 r3 = r3.timeout     // Catch:{ all -> 0x00d4 }
                r3.enter()     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.connection.RealCall r3 = r7.this$0     // Catch:{ IOException -> 0x0084, all -> 0x0054 }
                okhttp3.Response r0 = r3.getResponseWithInterceptorChain$okhttp()     // Catch:{ IOException -> 0x0084, all -> 0x0054 }
                r3 = 1
                okhttp3.Callback r4 = r7.responseCallback     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
                okhttp3.internal.connection.RealCall r5 = r7.this$0     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
                okhttp3.Call r5 = (okhttp3.Call) r5     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
                r4.onResponse(r5, r0)     // Catch:{ IOException -> 0x0052, all -> 0x0050 }
                okhttp3.internal.connection.RealCall r0 = r7.this$0     // Catch:{ all -> 0x00d4 }
                okhttp3.OkHttpClient r0 = r0.getClient()     // Catch:{ all -> 0x00d4 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00d4 }
            L_0x004b:
                r0.finished$okhttp(r7)     // Catch:{ all -> 0x00d4 }
                goto L_0x00c2
            L_0x0050:
                r0 = move-exception
                goto L_0x0058
            L_0x0052:
                r0 = move-exception
                goto L_0x0088
            L_0x0054:
                r3 = move-exception
                r6 = r3
                r3 = r0
                r0 = r6
            L_0x0058:
                okhttp3.internal.connection.RealCall r4 = r7.this$0     // Catch:{ all -> 0x0082 }
                r4.cancel()     // Catch:{ all -> 0x0082 }
                if (r3 != 0) goto L_0x0081
                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0082 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
                r4.<init>()     // Catch:{ all -> 0x0082 }
                java.lang.String r5 = "canceled due to "
                r4.append(r5)     // Catch:{ all -> 0x0082 }
                r4.append(r0)     // Catch:{ all -> 0x0082 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0082 }
                r3.<init>(r4)     // Catch:{ all -> 0x0082 }
                r3.addSuppressed(r0)     // Catch:{ all -> 0x0082 }
                okhttp3.Callback r4 = r7.responseCallback     // Catch:{ all -> 0x0082 }
                okhttp3.internal.connection.RealCall r5 = r7.this$0     // Catch:{ all -> 0x0082 }
                okhttp3.Call r5 = (okhttp3.Call) r5     // Catch:{ all -> 0x0082 }
                r4.onFailure(r5, r3)     // Catch:{ all -> 0x0082 }
            L_0x0081:
                throw r0     // Catch:{ all -> 0x0082 }
            L_0x0082:
                r0 = move-exception
                goto L_0x00c6
            L_0x0084:
                r3 = move-exception
                r6 = r3
                r3 = r0
                r0 = r6
            L_0x0088:
                if (r3 == 0) goto L_0x00ae
                okhttp3.internal.platform.Platform$Companion r3 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0082 }
                okhttp3.internal.platform.Platform r3 = r3.get()     // Catch:{ all -> 0x0082 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
                r4.<init>()     // Catch:{ all -> 0x0082 }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x0082 }
                okhttp3.internal.connection.RealCall r5 = r7.this$0     // Catch:{ all -> 0x0082 }
                java.lang.String r5 = r5.toLoggableString()     // Catch:{ all -> 0x0082 }
                r4.append(r5)     // Catch:{ all -> 0x0082 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0082 }
                r5 = 4
                java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0082 }
                r3.log(r4, r5, r0)     // Catch:{ all -> 0x0082 }
                goto L_0x00b7
            L_0x00ae:
                okhttp3.Callback r3 = r7.responseCallback     // Catch:{ all -> 0x0082 }
                okhttp3.internal.connection.RealCall r4 = r7.this$0     // Catch:{ all -> 0x0082 }
                okhttp3.Call r4 = (okhttp3.Call) r4     // Catch:{ all -> 0x0082 }
                r3.onFailure(r4, r0)     // Catch:{ all -> 0x0082 }
            L_0x00b7:
                okhttp3.internal.connection.RealCall r0 = r7.this$0     // Catch:{ all -> 0x00d4 }
                okhttp3.OkHttpClient r0 = r0.getClient()     // Catch:{ all -> 0x00d4 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00d4 }
                goto L_0x004b
            L_0x00c2:
                r1.setName(r2)
                return
            L_0x00c6:
                okhttp3.internal.connection.RealCall r3 = r7.this$0     // Catch:{ all -> 0x00d4 }
                okhttp3.OkHttpClient r3 = r3.getClient()     // Catch:{ all -> 0x00d4 }
                okhttp3.Dispatcher r3 = r3.dispatcher()     // Catch:{ all -> 0x00d4 }
                r3.finished$okhttp(r7)     // Catch:{ all -> 0x00d4 }
                throw r0     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r0 = move-exception
                r1.setName(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.AsyncCall.run():void");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealCall.kt */
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }

        public CallReference(RealCall realCall, Object obj) {
            Intrinsics.checkParameterIsNotNull(realCall, "referent");
            super(realCall);
            this.callStackTrace = obj;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics.checkParameterIsNotNull(request, "originalRequest");
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        RealCall$timeout$1 realCall$timeout$1 = new RealCall$timeout$1(this);
        realCall$timeout$1.timeout((long) this.client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = realCall$timeout$1;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(RealConnection realConnection) {
        this.connection = realConnection;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public Request request() {
        return this.originalRequest;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        if (r1 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        r1.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        if (r2 == null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        r2.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        r4.eventListener.canceled(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r4 = this;
            okhttp3.internal.connection.RealConnectionPool r0 = r4.connectionPool
            monitor-enter(r0)
            boolean r1 = r4.canceled     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            r4.canceled = r1     // Catch:{ all -> 0x0032 }
            okhttp3.internal.connection.Exchange r1 = r4.exchange     // Catch:{ all -> 0x0032 }
            okhttp3.internal.connection.ExchangeFinder r2 = r4.exchangeFinder     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0019
            okhttp3.internal.connection.RealConnection r2 = r2.connectingConnection()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            okhttp3.internal.connection.RealConnection r2 = r4.connection     // Catch:{ all -> 0x0032 }
        L_0x001b:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)
            if (r1 == 0) goto L_0x0024
            r1.cancel()
            goto L_0x0029
        L_0x0024:
            if (r2 == 0) goto L_0x0029
            r2.cancel()
        L_0x0029:
            okhttp3.EventListener r0 = r4.eventListener
            r1 = r4
            okhttp3.Call r1 = (okhttp3.Call) r1
            r0.canceled(r1)
            return
        L_0x0032:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public Response execute() {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        this.timeout.enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public void enqueue(Callback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "responseCallback");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        List arrayList = new ArrayList();
        Collection collection = arrayList;
        CollectionsKt.addAll(collection, (Iterable<? extends T>) this.client.interceptors());
        collection.add(new RetryAndFollowUpInterceptor(this.client));
        collection.add(new BridgeInterceptor(this.client.cookieJar()));
        collection.add(new CacheInterceptor(this.client.cache()));
        collection.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt.addAll(collection, (Iterable<? extends T>) this.client.networkInterceptors());
        }
        collection.add(new CallServerInterceptor(this.forWebSocket));
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this, arrayList, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        try {
            Response proceed = realInterceptorChain.proceed(this.originalRequest);
            if (!isCanceled()) {
                noMoreExchanges$okhttp(null);
                return proceed;
            }
            Util.closeQuietly((Closeable) proceed);
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
            if (noMoreExchanges$okhttp == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            }
            throw noMoreExchanges$okhttp;
        } catch (Throwable th) {
            if (1 == 0) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        boolean z2 = true;
        if (this.interceptorScopedExchange == null) {
            if (this.exchange != null) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            } else if (z) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkParameterIsNotNull(realInterceptorChain, "chain");
        synchronized (this.connectionPool) {
            boolean z = true;
            if (!this.noMoreExchanges) {
                if (this.exchange != null) {
                    z = false;
                }
                if (z) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        if (exchangeFinder2 == null) {
            Intrinsics.throwNpe();
        }
        ExchangeCodec find = exchangeFinder2.find(this.client, realInterceptorChain);
        EventListener eventListener2 = this.eventListener;
        ExchangeFinder exchangeFinder3 = this.exchangeFinder;
        if (exchangeFinder3 == null) {
            Intrinsics.throwNpe();
        }
        Exchange exchange2 = new Exchange(this, eventListener2, exchangeFinder3, find);
        this.interceptorScopedExchange = exchange2;
        synchronized (this.connectionPool) {
            this.exchange = exchange2;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange2;
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        Intrinsics.checkParameterIsNotNull(realConnection, "connection");
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnectionPool)) {
            if (this.connection == null) {
                this.connection = realConnection;
                realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        if (r1 == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        r6 = maybeReleaseConnection(r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0054, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            okhttp3.internal.connection.RealConnectionPool r0 = r2.connectionPool
            monitor-enter(r0)
            okhttp3.internal.connection.Exchange r1 = r2.exchange     // Catch:{ all -> 0x0055 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)     // Catch:{ all -> 0x0055 }
            r1 = 1
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x0014
            monitor-exit(r0)
            return r6
        L_0x0014:
            r3 = 0
            if (r4 == 0) goto L_0x001d
            boolean r4 = r2.exchangeRequestDone     // Catch:{ all -> 0x0055 }
            r4 = r4 ^ r1
            r2.exchangeRequestDone = r1     // Catch:{ all -> 0x0055 }
            goto L_0x001e
        L_0x001d:
            r4 = r3
        L_0x001e:
            if (r5 == 0) goto L_0x0027
            boolean r5 = r2.exchangeResponseDone     // Catch:{ all -> 0x0055 }
            if (r5 != 0) goto L_0x0025
            r4 = r1
        L_0x0025:
            r2.exchangeResponseDone = r1     // Catch:{ all -> 0x0055 }
        L_0x0027:
            boolean r5 = r2.exchangeRequestDone     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x004a
            boolean r5 = r2.exchangeResponseDone     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x004a
            if (r4 == 0) goto L_0x004a
            okhttp3.internal.connection.Exchange r4 = r2.exchange     // Catch:{ all -> 0x0055 }
            if (r4 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0055 }
        L_0x0038:
            okhttp3.internal.connection.RealConnection r4 = r4.getConnection$okhttp()     // Catch:{ all -> 0x0055 }
            int r5 = r4.getSuccessCount$okhttp()     // Catch:{ all -> 0x0055 }
            int r5 = r5 + r1
            r4.setSuccessCount$okhttp(r5)     // Catch:{ all -> 0x0055 }
            r4 = 0
            okhttp3.internal.connection.Exchange r4 = (okhttp3.internal.connection.Exchange) r4     // Catch:{ all -> 0x0055 }
            r2.exchange = r4     // Catch:{ all -> 0x0055 }
            goto L_0x004b
        L_0x004a:
            r1 = r3
        L_0x004b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)
            if (r1 == 0) goto L_0x0054
            java.io.IOException r6 = r2.maybeReleaseConnection(r6, r3)
        L_0x0054:
            return r6
        L_0x0055:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
            Unit unit = Unit.INSTANCE;
        }
        return maybeReleaseConnection(iOException, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019 A[Catch:{ all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <E extends java.io.IOException> E maybeReleaseConnection(E r7, boolean r8) {
        /*
            r6 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            okhttp3.internal.connection.RealConnectionPool r1 = r6.connectionPool
            monitor-enter(r1)
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L_0x0016
            okhttp3.internal.connection.Exchange r4 = r6.exchange     // Catch:{ all -> 0x0013 }
            if (r4 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r4 = r2
            goto L_0x0017
        L_0x0013:
            r7 = move-exception
            goto L_0x0096
        L_0x0016:
            r4 = r3
        L_0x0017:
            if (r4 == 0) goto L_0x0088
            okhttp3.internal.connection.RealConnection r4 = r6.connection     // Catch:{ all -> 0x0013 }
            okhttp3.Connection r4 = (okhttp3.Connection) r4     // Catch:{ all -> 0x0013 }
            r0.element = r4     // Catch:{ all -> 0x0013 }
            okhttp3.internal.connection.RealConnection r4 = r6.connection     // Catch:{ all -> 0x0013 }
            r5 = 0
            if (r4 == 0) goto L_0x0033
            okhttp3.internal.connection.Exchange r4 = r6.exchange     // Catch:{ all -> 0x0013 }
            if (r4 != 0) goto L_0x0033
            if (r8 != 0) goto L_0x002e
            boolean r8 = r6.noMoreExchanges     // Catch:{ all -> 0x0013 }
            if (r8 == 0) goto L_0x0033
        L_0x002e:
            java.net.Socket r8 = r6.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x0013 }
            goto L_0x0034
        L_0x0033:
            r8 = r5
        L_0x0034:
            okhttp3.internal.connection.RealConnection r4 = r6.connection     // Catch:{ all -> 0x0013 }
            if (r4 == 0) goto L_0x003c
            okhttp3.Connection r5 = (okhttp3.Connection) r5     // Catch:{ all -> 0x0013 }
            r0.element = r5     // Catch:{ all -> 0x0013 }
        L_0x003c:
            boolean r4 = r6.noMoreExchanges     // Catch:{ all -> 0x0013 }
            if (r4 == 0) goto L_0x0046
            okhttp3.internal.connection.Exchange r4 = r6.exchange     // Catch:{ all -> 0x0013 }
            if (r4 != 0) goto L_0x0046
            r4 = r3
            goto L_0x0047
        L_0x0046:
            r4 = r2
        L_0x0047:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            if (r8 == 0) goto L_0x004f
            okhttp3.internal.Util.closeQuietly(r8)
        L_0x004f:
            T r8 = r0.element
            okhttp3.Connection r8 = (okhttp3.Connection) r8
            if (r8 == 0) goto L_0x0066
            okhttp3.EventListener r8 = r6.eventListener
            r1 = r6
            okhttp3.Call r1 = (okhttp3.Call) r1
            T r0 = r0.element
            okhttp3.Connection r0 = (okhttp3.Connection) r0
            if (r0 != 0) goto L_0x0063
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0063:
            r8.connectionReleased(r1, r0)
        L_0x0066:
            if (r4 == 0) goto L_0x0087
            if (r7 == 0) goto L_0x006b
            r2 = r3
        L_0x006b:
            java.io.IOException r7 = r6.timeoutExit(r7)
            if (r2 == 0) goto L_0x007f
            okhttp3.EventListener r8 = r6.eventListener
            r0 = r6
            okhttp3.Call r0 = (okhttp3.Call) r0
            if (r7 != 0) goto L_0x007b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x007b:
            r8.callFailed(r0, r7)
            goto L_0x0087
        L_0x007f:
            okhttp3.EventListener r8 = r6.eventListener
            r0 = r6
            okhttp3.Call r0 = (okhttp3.Call) r0
            r8.callEnd(r0)
        L_0x0087:
            return r7
        L_0x0088:
            java.lang.String r7 = "cannot release connection while it is in use"
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0013 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0013 }
            r8.<init>(r7)     // Catch:{ all -> 0x0013 }
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x0013 }
            throw r8     // Catch:{ all -> 0x0013 }
        L_0x0096:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.maybeReleaseConnection(java.io.IOException, boolean):java.io.IOException");
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnectionPool)) {
            RealConnection realConnection = this.connection;
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            Iterator it = realConnection.getCalls().iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) (RealCall) ((Reference) it.next()).get(), (Object) this)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                z = true;
            }
            if (z) {
                RealConnection realConnection2 = this.connection;
                if (realConnection2 == null) {
                    Intrinsics.throwNpe();
                }
                realConnection2.getCalls().remove(i);
                this.connection = null;
                if (realConnection2.getCalls().isEmpty()) {
                    realConnection2.setIdleAtNs$okhttp(System.nanoTime());
                    if (this.connectionPool.connectionBecameIdle(realConnection2)) {
                        return realConnection2.socket();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    private final <E extends IOException> E timeoutExit(E e) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return e;
        }
        E interruptedIOException = new InterruptedIOException("timeout");
        if (e != null) {
            interruptedIOException.initCause((Throwable) e);
        }
        return (IOException) interruptedIOException;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        boolean z2 = true;
        if (!this.noMoreExchanges) {
            if (z) {
                Exchange exchange2 = this.exchange;
                if (exchange2 != null) {
                    exchange2.detachWithViolence();
                }
                if (this.exchange != null) {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            this.interceptorScopedExchange = null;
            return;
        }
        throw new IllegalStateException("released".toString());
    }

    private final Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        }
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        HostnameVerifier hostnameVerifier2 = hostnameVerifier;
        Address address = new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory2, hostnameVerifier2, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
        return address;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        if (exchangeFinder2 == null) {
            Intrinsics.throwNpe();
        }
        return exchangeFinder2.retryAfterFailure();
    }

    /* access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }
}
