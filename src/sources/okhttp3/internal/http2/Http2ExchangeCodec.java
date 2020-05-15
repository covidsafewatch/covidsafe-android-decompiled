package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "canceled", "", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "protocol", "Lokhttp3/Protocol;", "stream", "Lokhttp3/internal/http2/Http2Stream;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Http2ExchangeCodec.kt */
public final class Http2ExchangeCodec implements ExchangeCodec {
    private static final String CONNECTION = "connection";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    /* access modifiers changed from: private */
    public static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    /* access modifiers changed from: private */
    public static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection2) {
        Protocol protocol2;
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics.checkParameterIsNotNull(realConnection, CONNECTION);
        Intrinsics.checkParameterIsNotNull(realInterceptorChain, "chain");
        Intrinsics.checkParameterIsNotNull(http2Connection2, "http2Connection");
        this.connection = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection2;
        if (okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol2 = Protocol.HTTP_2;
        }
        this.protocol = protocol2;
    }

    public RealConnection getConnection() {
        return this.connection;
    }

    public Sink createRequestBody(Request request, long j) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            Intrinsics.throwNpe();
        }
        return http2Stream.getSink();
    }

    public void writeRequestHeaders(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        if (this.stream == null) {
            this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), request.body() != null);
            if (this.canceled) {
                Http2Stream http2Stream = this.stream;
                if (http2Stream == null) {
                    Intrinsics.throwNpe();
                }
                http2Stream.closeLater(ErrorCode.CANCEL);
                throw new IOException("Canceled");
            }
            Http2Stream http2Stream2 = this.stream;
            if (http2Stream2 == null) {
                Intrinsics.throwNpe();
            }
            http2Stream2.readTimeout().timeout((long) this.chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            Http2Stream http2Stream3 = this.stream;
            if (http2Stream3 == null) {
                Intrinsics.throwNpe();
            }
            http2Stream3.writeTimeout().timeout((long) this.chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        }
    }

    public void flushRequest() {
        this.http2Connection.flush();
    }

    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            Intrinsics.throwNpe();
        }
        http2Stream.getSink().close();
    }

    public Response.Builder readResponseHeaders(boolean z) {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            Intrinsics.throwNpe();
        }
        Response.Builder readHttp2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
        if (!z || readHttp2HeadersList.getCode$okhttp() != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public long reportedContentLength(Response response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0;
        }
        return Util.headersContentLength(response);
    }

    public Source openResponseBodySource(Response response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            Intrinsics.throwNpe();
        }
        return http2Stream.getSource$okhttp();
    }

    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            Intrinsics.throwNpe();
        }
        return http2Stream.trailers();
    }

    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "()V", "CONNECTION", "", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "http2HeadersList", "Lokhttp3/internal/http2/Header;", "request", "Lokhttp3/Request;", "readHttp2HeadersList", "Lokhttp3/Response$Builder;", "headerBlock", "Lokhttp3/Headers;", "protocol", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Http2ExchangeCodec.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Header> http2HeadersList(Request request) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String header = request.header(com.google.common.net.HttpHeaders.HOST);
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int i = 0;
            int size = headers.size();
            while (i < size) {
                String name = headers.name(i);
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (name != null) {
                    String lowerCase = name.toLowerCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (Intrinsics.areEqual((Object) lowerCase, (Object) Http2ExchangeCodec.TE) && Intrinsics.areEqual((Object) headers.value(i), (Object) "trailers"))) {
                        arrayList.add(new Header(lowerCase, headers.value(i)));
                    }
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return arrayList;
        }

        public final Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) {
            Intrinsics.checkParameterIsNotNull(headers, "headerBlock");
            Intrinsics.checkParameterIsNotNull(protocol, "protocol");
            StatusLine statusLine = null;
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if (Intrinsics.areEqual((Object) name, (Object) Header.RESPONSE_STATUS_UTF8)) {
                    statusLine = StatusLine.Companion.parse("HTTP/1.1 " + value);
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }
}
