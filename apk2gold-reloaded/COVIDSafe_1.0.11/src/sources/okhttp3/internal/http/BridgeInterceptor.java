package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: BridgeInterceptor.kt */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        Intrinsics.checkParameterIsNotNull(cookieJar2, "cookieJar");
        this.cookieJar = cookieJar2;
    }

    public Response intercept(Chain chain) throws IOException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request request = chain.request();
        Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        String str = HttpHeaders.CONTENT_TYPE;
        String str2 = HttpHeaders.CONTENT_LENGTH;
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header(str, contentType.toString());
            }
            long contentLength = body.contentLength();
            int i = (contentLength > -1 ? 1 : (contentLength == -1 ? 0 : -1));
            String str3 = HttpHeaders.TRANSFER_ENCODING;
            if (i != 0) {
                newBuilder.header(str2, String.valueOf(contentLength));
                newBuilder.removeHeader(str3);
            } else {
                newBuilder.header(str3, "chunked");
                newBuilder.removeHeader(str2);
            }
        }
        String str4 = HttpHeaders.HOST;
        boolean z = false;
        if (request.header(str4) == null) {
            newBuilder.header(str4, Util.toHostHeader$default(request.url(), false, 1, null));
        }
        String str5 = HttpHeaders.CONNECTION;
        if (request.header(str5) == null) {
            newBuilder.header(str5, "Keep-Alive");
        }
        String str6 = HttpHeaders.ACCEPT_ENCODING;
        String str7 = "gzip";
        if (request.header(str6) == null && request.header(HttpHeaders.RANGE) == null) {
            newBuilder.header(str6, str7);
            z = true;
        }
        List loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(HttpHeaders.COOKIE, cookieHeader(loadForRequest));
        }
        String str8 = HttpHeaders.USER_AGENT;
        if (request.header(str8) == null) {
            newBuilder.header(str8, Version.userAgent);
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z) {
            String str9 = HttpHeaders.CONTENT_ENCODING;
            if (StringsKt.equals(str7, Response.header$default(proceed, str9, null, 2, null), true) && HttpHeaders.promisesBody(proceed)) {
                ResponseBody body2 = proceed.body();
                if (body2 != null) {
                    GzipSource gzipSource = new GzipSource(body2.source());
                    request2.headers(proceed.headers().newBuilder().removeAll(str9).removeAll(str2).build());
                    request2.body(new RealResponseBody(Response.header$default(proceed, str, null, 2, null), -1, Okio.buffer((Source) gzipSource)));
                }
            }
        }
        return request2.build();
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Cookie cookie = (Cookie) next;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
