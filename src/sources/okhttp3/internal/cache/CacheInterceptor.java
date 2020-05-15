package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: CacheInterceptor.kt */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Cache cache;

    public CacheInterceptor(Cache cache2) {
        this.cache = cache2;
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        ResponseBody body2;
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Cache cache2 = this.cache;
        Response response = cache2 != null ? cache2.get$okhttp(chain.request()) : null;
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache3 = this.cache;
        if (cache3 != null) {
            cache3.trackResponse$okhttp(compute);
        }
        if (!(response == null || cacheResponse != null || (body2 = response.body()) == null)) {
            Util.closeQuietly((Closeable) body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (networkRequest == null) {
            if (cacheResponse == null) {
                Intrinsics.throwNpe();
            }
            return cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
        }
        Response response2 = null;
        try {
            Response proceed = chain.proceed(networkRequest);
            if (!(proceed != null || response == null || body == null)) {
            }
            if (cacheResponse != null) {
                if (proceed == null || proceed.code() != 304) {
                    ResponseBody body3 = cacheResponse.body();
                    if (body3 != null) {
                        Util.closeQuietly((Closeable) body3);
                    }
                } else {
                    Response build = cacheResponse.newBuilder().headers(Companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(Companion.stripBody(cacheResponse)).networkResponse(Companion.stripBody(proceed)).build();
                    ResponseBody body4 = proceed.body();
                    if (body4 == null) {
                        Intrinsics.throwNpe();
                    }
                    body4.close();
                    Cache cache4 = this.cache;
                    if (cache4 == null) {
                        Intrinsics.throwNpe();
                    }
                    cache4.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, build);
                    return build;
                }
            }
            if (proceed == null) {
                Intrinsics.throwNpe();
            }
            Response build2 = proceed.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).networkResponse(Companion.stripBody(proceed)).build();
            if (this.cache != null) {
                if (HttpHeaders.promisesBody(build2) && CacheStrategy.Companion.isCacheable(build2, networkRequest)) {
                    return cacheWritingResponse(this.cache.put$okhttp(build2), build2);
                }
                if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (!(response == null || (body = response.body()) == null)) {
                Util.closeQuietly((Closeable) body);
            }
        }
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        if (body2 == null) {
            Intrinsics.throwNpe();
        }
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$1 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(body2.source(), cacheRequest, Okio.buffer(body));
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, com.google.common.net.HttpHeaders.CONTENT_TYPE, (String) null, 2, (Object) null), response.body().contentLength(), Okio.buffer((Source) cacheInterceptor$cacheWritingResponse$cacheWritingSource$1))).build();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CacheInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body((ResponseBody) null).build() : response;
        }

        /* access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if (!StringsKt.equals(com.google.common.net.HttpHeaders.WARNING, name, true) || !StringsKt.startsWith$default(value, DiskLruCache.VERSION_1, false, 2, (Object) null)) {
                    Companion companion = this;
                    if (companion.isContentSpecificHeader(name) || !companion.isEndToEnd(name) || headers2.get(name) == null) {
                        builder.addLenient$okhttp(name, value);
                    }
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                Companion companion2 = this;
                if (!companion2.isContentSpecificHeader(name2) && companion2.isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isEndToEnd(String str) {
            if (StringsKt.equals(com.google.common.net.HttpHeaders.CONNECTION, str, true) || StringsKt.equals("Keep-Alive", str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE, str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.PROXY_AUTHORIZATION, str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.TE, str, true) || StringsKt.equals("Trailers", str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.TRANSFER_ENCODING, str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.UPGRADE, str, true)) {
                return false;
            }
            return true;
        }

        private final boolean isContentSpecificHeader(String str) {
            if (StringsKt.equals(com.google.common.net.HttpHeaders.CONTENT_LENGTH, str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.CONTENT_ENCODING, str, true) || StringsKt.equals(com.google.common.net.HttpHeaders.CONTENT_TYPE, str, true)) {
                return true;
            }
            return false;
        }
    }
}
