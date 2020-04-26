package okhttp3.logging;

import com.google.common.net.HttpHeaders;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\bF0\u0001¨\u0006 "}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
    /* compiled from: HttpLoggingInterceptor.kt */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
    /* compiled from: HttpLoggingInterceptor.kt */
    public interface Logger {
        public static final Companion Companion = new Companion(null);
        public static final Logger DEFAULT = new HttpLoggingInterceptor$Logger$Companion$DEFAULT$1();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0005"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
        /* compiled from: HttpLoggingInterceptor.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.logger = logger2;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            logger2 = Logger.DEFAULT;
        }
        this(logger2);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level2) {
        Intrinsics.checkParameterIsNotNull(level2, "<set-?>");
        this.level = level2;
    }

    public final void redactHeader(String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        Collection collection = treeSet;
        CollectionsKt.addAll(collection, (Iterable<? extends T>) this.headersToRedact);
        collection.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        Intrinsics.checkParameterIsNotNull(level2, "level");
        HttpLoggingInterceptor httpLoggingInterceptor = this;
        httpLoggingInterceptor.level = level2;
        return httpLoggingInterceptor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    /* renamed from: -deprecated_level reason: not valid java name */
    public final Level m1179deprecated_level() {
        return this.level;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x036e, code lost:
        if (r2 != null) goto L_0x0376;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0191, code lost:
        if (r10 != null) goto L_0x0199;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r2)
            okhttp3.logging.HttpLoggingInterceptor$Level r2 = r1.level
            okhttp3.Request r3 = r21.request()
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.NONE
            if (r2 != r4) goto L_0x0018
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x0018:
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
            if (r2 != r4) goto L_0x001e
            r4 = 1
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0028
            okhttp3.logging.HttpLoggingInterceptor$Level r7 = okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
            if (r2 != r7) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r2 = 0
            goto L_0x0029
        L_0x0028:
            r2 = 1
        L_0x0029:
            okhttp3.RequestBody r7 = r3.body()
            okhttp3.Connection r8 = r21.connection()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "--> "
            r9.append(r10)
            java.lang.String r10 = r3.method()
            r9.append(r10)
            r10 = 32
            r9.append(r10)
            okhttp3.HttpUrl r11 = r3.url()
            r9.append(r11)
            java.lang.String r11 = ""
            if (r8 == 0) goto L_0x0068
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = " "
            r12.append(r13)
            okhttp3.Protocol r8 = r8.protocol()
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            goto L_0x0069
        L_0x0068:
            r8 = r11
        L_0x0069:
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "-byte body)"
            java.lang.String r12 = " ("
            if (r2 != 0) goto L_0x0091
            if (r7 == 0) goto L_0x0091
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r8)
            r13.append(r12)
            long r14 = r7.contentLength()
            r13.append(r14)
            r13.append(r9)
            java.lang.String r8 = r13.toString()
        L_0x0091:
            okhttp3.logging.HttpLoggingInterceptor$Logger r13 = r1.logger
            r13.log(r8)
            java.lang.String r8 = "-byte body omitted)"
            java.lang.String r13 = "UTF_8"
            if (r2 == 0) goto L_0x0213
            okhttp3.Headers r5 = r3.headers()
            if (r7 == 0) goto L_0x00f2
            okhttp3.MediaType r6 = r7.contentType()
            if (r6 == 0) goto L_0x00c6
            java.lang.String r10 = "Content-Type"
            java.lang.String r10 = r5.get(r10)
            if (r10 != 0) goto L_0x00c6
            okhttp3.logging.HttpLoggingInterceptor$Logger r10 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Content-Type: "
            r14.append(r15)
            r14.append(r6)
            java.lang.String r6 = r14.toString()
            r10.log(r6)
        L_0x00c6:
            long r14 = r7.contentLength()
            r17 = -1
            int r6 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r6 == 0) goto L_0x00f2
            java.lang.String r6 = "Content-Length"
            java.lang.String r6 = r5.get(r6)
            if (r6 != 0) goto L_0x00f2
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r14 = "Content-Length: "
            r10.append(r14)
            long r14 = r7.contentLength()
            r10.append(r14)
            java.lang.String r10 = r10.toString()
            r6.log(r10)
        L_0x00f2:
            int r6 = r5.size()
            r10 = 0
        L_0x00f7:
            if (r10 >= r6) goto L_0x00ff
            r1.logHeader(r5, r10)
            int r10 = r10 + 1
            goto L_0x00f7
        L_0x00ff:
            java.lang.String r5 = "--> END "
            if (r4 == 0) goto L_0x01fb
            if (r7 != 0) goto L_0x0107
            goto L_0x01fb
        L_0x0107:
            okhttp3.Headers r6 = r3.headers()
            boolean r6 = r1.bodyHasUnknownEncoding(r6)
            if (r6 == 0) goto L_0x0130
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = r3.method()
            r7.append(r5)
            java.lang.String r5 = " (encoded body omitted)"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.log(r5)
            goto L_0x0213
        L_0x0130:
            boolean r6 = r7.isDuplex()
            if (r6 == 0) goto L_0x0155
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = r3.method()
            r7.append(r5)
            java.lang.String r5 = " (duplex request body omitted)"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.log(r5)
            goto L_0x0213
        L_0x0155:
            boolean r6 = r7.isOneShot()
            if (r6 == 0) goto L_0x017a
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = r3.method()
            r7.append(r5)
            java.lang.String r5 = " (one-shot body omitted)"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.log(r5)
            goto L_0x0213
        L_0x017a:
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r10 = r6
            okio.BufferedSink r10 = (okio.BufferedSink) r10
            r7.writeTo(r10)
            okhttp3.MediaType r10 = r7.contentType()
            if (r10 == 0) goto L_0x0194
            java.nio.charset.Charset r14 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.charset.Charset r10 = r10.charset(r14)
            if (r10 == 0) goto L_0x0194
            goto L_0x0199
        L_0x0194:
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r13)
        L_0x0199:
            okhttp3.logging.HttpLoggingInterceptor$Logger r14 = r1.logger
            r14.log(r11)
            boolean r14 = okhttp3.logging.Utf8Kt.isProbablyUtf8(r6)
            if (r14 == 0) goto L_0x01d3
            okhttp3.logging.HttpLoggingInterceptor$Logger r14 = r1.logger
            java.lang.String r6 = r6.readString(r10)
            r14.log(r6)
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            java.lang.String r5 = r3.method()
            r10.append(r5)
            r10.append(r12)
            long r14 = r7.contentLength()
            r10.append(r14)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r6.log(r5)
            goto L_0x0213
        L_0x01d3:
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r5)
            java.lang.String r5 = r3.method()
            r10.append(r5)
            java.lang.String r5 = " (binary "
            r10.append(r5)
            long r14 = r7.contentLength()
            r10.append(r14)
            r10.append(r8)
            java.lang.String r5 = r10.toString()
            r6.log(r5)
            goto L_0x0213
        L_0x01fb:
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = r3.method()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.log(r5)
        L_0x0213:
            long r5 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x0409 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r14 = java.lang.System.nanoTime()
            long r14 = r14 - r5
            long r5 = r3.toMillis(r14)
            okhttp3.ResponseBody r3 = r0.body()
            if (r3 != 0) goto L_0x022f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x022f:
            long r14 = r3.contentLength()
            r17 = -1
            int r7 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r7 == 0) goto L_0x024b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r14)
            java.lang.String r10 = "-byte"
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            goto L_0x024d
        L_0x024b:
            java.lang.String r7 = "unknown-length"
        L_0x024d:
            okhttp3.logging.HttpLoggingInterceptor$Logger r10 = r1.logger
            r17 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r18 = r14
            java.lang.String r14 = "<-- "
            r9.append(r14)
            int r14 = r0.code()
            r9.append(r14)
            java.lang.String r14 = r0.message()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r14 = r14.length()
            if (r14 != 0) goto L_0x0272
            r14 = 1
            goto L_0x0273
        L_0x0272:
            r14 = 0
        L_0x0273:
            if (r14 == 0) goto L_0x027b
            r16 = r8
            r8 = r11
            r21 = 32
            goto L_0x0296
        L_0x027b:
            java.lang.String r14 = r0.message()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r16 = r8
            r21 = 32
            java.lang.String r8 = java.lang.String.valueOf(r21)
            r15.append(r8)
            r15.append(r14)
            java.lang.String r8 = r15.toString()
        L_0x0296:
            r9.append(r8)
            r8 = r21
            r9.append(r8)
            okhttp3.Request r8 = r0.request()
            okhttp3.HttpUrl r8 = r8.url()
            r9.append(r8)
            r9.append(r12)
            r9.append(r5)
            java.lang.String r5 = "ms"
            r9.append(r5)
            if (r2 != 0) goto L_0x02cd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ", "
            r5.append(r6)
            r5.append(r7)
            java.lang.String r6 = " body"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            goto L_0x02ce
        L_0x02cd:
            r5 = r11
        L_0x02ce:
            r9.append(r5)
            r5 = 41
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            r10.log(r5)
            if (r2 == 0) goto L_0x0408
            okhttp3.Headers r2 = r0.headers()
            int r5 = r2.size()
            r6 = 0
        L_0x02e8:
            if (r6 >= r5) goto L_0x02f0
            r1.logHeader(r2, r6)
            int r6 = r6 + 1
            goto L_0x02e8
        L_0x02f0:
            if (r4 == 0) goto L_0x0401
            boolean r4 = okhttp3.internal.http.HttpHeaders.promisesBody(r0)
            if (r4 != 0) goto L_0x02fa
            goto L_0x0401
        L_0x02fa:
            okhttp3.Headers r4 = r0.headers()
            boolean r4 = r1.bodyHasUnknownEncoding(r4)
            if (r4 == 0) goto L_0x030d
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r2.log(r3)
            goto L_0x0408
        L_0x030d:
            okio.BufferedSource r4 = r3.source()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.request(r5)
            okio.Buffer r4 = r4.getBuffer()
            r5 = 0
            r6 = r5
            java.lang.Long r6 = (java.lang.Long) r6
            java.lang.String r7 = "Content-Encoding"
            java.lang.String r2 = r2.get(r7)
            java.lang.String r7 = "gzip"
            r8 = 1
            boolean r2 = kotlin.text.StringsKt.equals(r7, r2, r8)
            if (r2 == 0) goto L_0x0362
            long r6 = r4.size()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            okio.GzipSource r2 = new okio.GzipSource
            okio.Buffer r4 = r4.clone()
            okio.Source r4 = (okio.Source) r4
            r2.<init>(r4)
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r4 = r2
            okio.GzipSource r4 = (okio.GzipSource) r4     // Catch:{ all -> 0x0359 }
            okio.Buffer r7 = new okio.Buffer     // Catch:{ all -> 0x0359 }
            r7.<init>()     // Catch:{ all -> 0x0359 }
            okio.Source r4 = (okio.Source) r4     // Catch:{ all -> 0x0359 }
            r7.writeAll(r4)     // Catch:{ all -> 0x0359 }
            kotlin.io.CloseableKt.closeFinally(r2, r5)
            r4 = r7
            goto L_0x0362
        L_0x0359:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x035c }
        L_0x035c:
            r0 = move-exception
            r4 = r0
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        L_0x0362:
            okhttp3.MediaType r2 = r3.contentType()
            if (r2 == 0) goto L_0x0371
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.charset.Charset r2 = r2.charset(r3)
            if (r2 == 0) goto L_0x0371
            goto L_0x0376
        L_0x0371:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r13)
        L_0x0376:
            boolean r3 = okhttp3.logging.Utf8Kt.isProbablyUtf8(r4)
            if (r3 != 0) goto L_0x03a1
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            r2.log(r11)
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "<-- END HTTP (binary "
            r3.append(r5)
            long r4 = r4.size()
            r3.append(r4)
            r4 = r16
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            return r0
        L_0x03a1:
            r7 = 0
            int r3 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x03b9
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            r3.log(r11)
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            okio.Buffer r5 = r4.clone()
            java.lang.String r2 = r5.readString(r2)
            r3.log(r2)
        L_0x03b9:
            java.lang.String r2 = "<-- END HTTP ("
            if (r6 == 0) goto L_0x03e3
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            long r7 = r4.size()
            r5.append(r7)
            java.lang.String r2 = "-byte, "
            r5.append(r2)
            r5.append(r6)
            java.lang.String r2 = "-gzipped-byte body)"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3.log(r2)
            goto L_0x0408
        L_0x03e3:
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            long r6 = r4.size()
            r5.append(r6)
            r2 = r17
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3.log(r2)
            goto L_0x0408
        L_0x0401:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP"
            r2.log(r3)
        L_0x0408:
            return r0
        L_0x0409:
            r0 = move-exception
            r2 = r0
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            r0 = r2
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private final void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append(headers.name(i));
        sb.append(": ");
        sb.append(value);
        logger2.log(sb.toString());
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (str == null || StringsKt.equals(str, "identity", true) || StringsKt.equals(str, "gzip", true)) {
            return false;
        }
        return true;
    }
}
