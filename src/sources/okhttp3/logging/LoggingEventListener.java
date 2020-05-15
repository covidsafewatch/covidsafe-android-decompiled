package okhttp3.logging;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001>B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J2\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001fH\u0002J&\u0010&\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140!H\u0016J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u00105\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u00106\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lokhttp3/logging/LoggingEventListener;", "Lokhttp3/EventListener;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "startNs", "", "callEnd", "", "call", "Lokhttp3/Call;", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "dnsStart", "logWithTime", "message", "proxySelectEnd", "url", "Lokhttp3/HttpUrl;", "proxies", "proxySelectStart", "requestBodyEnd", "byteCount", "requestBodyStart", "requestFailed", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseFailed", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseHeadersStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Factory", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
/* compiled from: LoggingEventListener.kt */
public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger2, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger2);
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger2) {
        this.logger = logger2;
    }

    public void callStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
        logWithTime("proxySelectStart: " + httpUrl);
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics.checkParameterIsNotNull(list, "proxies");
        logWithTime("proxySelectEnd: " + list);
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(str, "domainName");
        logWithTime("dnsStart: " + str);
    }

    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(str, "domainName");
        Intrinsics.checkParameterIsNotNull(list, "inetAddressList");
        logWithTime("dnsEnd: " + list);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    public void secureConnectStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("secureConnectStart");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("secureConnectEnd: " + handshake);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        logWithTime("connectEnd: " + protocol);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
        logWithTime("connectFailed: " + protocol + ' ' + iOException);
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        logWithTime("connectionAcquired: " + connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        logWithTime("connectionReleased");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("requestHeadersStart");
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(request, "request");
        logWithTime("requestHeadersEnd");
    }

    public void requestBodyStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("requestBodyStart");
    }

    public void requestBodyEnd(Call call, long j) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("requestBodyEnd: byteCount=" + j);
    }

    public void requestFailed(Call call, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
        logWithTime("requestFailed: " + iOException);
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("responseHeadersStart");
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
        logWithTime("responseHeadersEnd: " + response);
    }

    public void responseBodyStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("responseBodyStart");
    }

    public void responseBodyEnd(Call call, long j) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("responseBodyEnd: byteCount=" + j);
    }

    public void responseFailed(Call call, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
        logWithTime("responseFailed: " + iOException);
    }

    public void callEnd(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("callEnd");
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
        logWithTime("callFailed: " + iOException);
    }

    public void canceled(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        logWithTime("canceled");
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger2 = this.logger;
        logger2.log('[' + millis + " ms] " + str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/logging/LoggingEventListener$Factory;", "Lokhttp3/EventListener$Factory;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LoggingEventListener.kt */
    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger2) {
            Intrinsics.checkParameterIsNotNull(logger2, "logger");
            this.logger = logger2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger2);
        }

        public EventListener create(Call call) {
            Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
            return new LoggingEventListener(this.logger, (DefaultConstructorMarker) null);
        }
    }
}
