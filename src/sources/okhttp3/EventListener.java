package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J+\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u001c\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b\u001f0\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J+\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0011\u0010$\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u001f0\u001dH\u0016J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u00102\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u00106\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006<"}, d2 = {"Lokhttp3/EventListener;", "", "()V", "callEnd", "", "call", "Lokhttp3/Call;", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "Lkotlin/jvm/JvmSuppressWildcards;", "dnsStart", "proxySelectEnd", "url", "Lokhttp3/HttpUrl;", "proxies", "proxySelectStart", "requestBodyEnd", "byteCount", "", "requestBodyStart", "requestFailed", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseFailed", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseHeadersStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: EventListener.kt */
public abstract class EventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lokhttp3/EventListener$Factory;", "", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EventListener.kt */
    public interface Factory {
        EventListener create(Call call);
    }

    public void callEnd(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
    }

    public void callStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void canceled(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(str, "domainName");
        Intrinsics.checkParameterIsNotNull(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics.checkParameterIsNotNull(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
    }

    public void requestBodyEnd(Call call, long j) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void requestBodyStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void requestFailed(Call call, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(request, "request");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyEnd(Call call, long j) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseFailed(Call call, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectStart(Call call) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/EventListener$Companion;", "", "()V", "NONE", "Lokhttp3/EventListener;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EventListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
