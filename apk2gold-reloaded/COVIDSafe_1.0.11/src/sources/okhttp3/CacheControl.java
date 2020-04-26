package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: CacheControl.kt */
public final class CacheControl {
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CacheControl.kt */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j) {
            if (j > ((long) Integer.MAX_VALUE)) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final Builder noCache() {
            Builder builder = this;
            builder.noCache = true;
            return builder;
        }

        public final Builder noStore() {
            Builder builder = this;
            builder.noStore = true;
            return builder;
        }

        public final Builder maxAge(int i, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Builder builder = this;
            if (i >= 0) {
                builder.maxAgeSeconds = builder.clampToInt(timeUnit.toSeconds((long) i));
                return builder;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxAge < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public final Builder maxStale(int i, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Builder builder = this;
            if (i >= 0) {
                builder.maxStaleSeconds = builder.clampToInt(timeUnit.toSeconds((long) i));
                return builder;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxStale < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public final Builder minFresh(int i, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Builder builder = this;
            if (i >= 0) {
                builder.minFreshSeconds = builder.clampToInt(timeUnit.toSeconds((long) i));
                return builder;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("minFresh < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public final Builder onlyIfCached() {
            Builder builder = this;
            builder.onlyIfCached = true;
            return builder;
        }

        public final Builder noTransform() {
            Builder builder = this;
            builder.noTransform = true;
            return builder;
        }

        public final Builder immutable() {
            Builder builder = this;
            builder.immutable = true;
            return builder;
        }

        public final CacheControl build() {
            CacheControl cacheControl = new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
            return cacheControl;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CacheControl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0106  */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.CacheControl parse(okhttp3.Headers r35) {
            /*
                r34 = this;
                r0 = r35
                java.lang.String r1 = "headers"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
                r1 = 0
                java.lang.String r1 = (java.lang.String) r1
                int r2 = r35.size()
                r5 = 1
                r8 = r1
                r7 = r5
                r6 = 0
                r9 = 0
                r10 = 0
                r11 = -1
                r12 = -1
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = -1
                r17 = -1
                r18 = 0
                r19 = 0
                r20 = 0
            L_0x0023:
                if (r6 >= r2) goto L_0x01c0
                java.lang.String r4 = r0.name(r6)
                java.lang.String r3 = r0.value(r6)
                java.lang.String r0 = "Cache-Control"
                boolean r0 = kotlin.text.StringsKt.equals(r4, r0, r5)
                if (r0 == 0) goto L_0x003a
                if (r8 == 0) goto L_0x0038
                goto L_0x0042
            L_0x0038:
                r8 = r3
                goto L_0x0043
            L_0x003a:
                java.lang.String r0 = "Pragma"
                boolean r0 = kotlin.text.StringsKt.equals(r4, r0, r5)
                if (r0 == 0) goto L_0x01b1
            L_0x0042:
                r7 = 0
            L_0x0043:
                r0 = 0
            L_0x0044:
                int r4 = r3.length()
                if (r0 >= r4) goto L_0x01a6
                r4 = r34
                okhttp3.CacheControl$Companion r4 = (okhttp3.CacheControl.Companion) r4
                java.lang.String r5 = "=,;"
                int r5 = r4.indexOfElement(r3, r5, r0)
                r23 = r1
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                if (r3 == 0) goto L_0x01a0
                java.lang.String r0 = r3.substring(r0, r5)
                r24 = r2
                java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r25 = r7
                java.lang.String r7 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r0 == 0) goto L_0x019a
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
                java.lang.String r0 = r0.toString()
                r26 = r8
                int r8 = r3.length()
                if (r5 == r8) goto L_0x00f2
                char r8 = r3.charAt(r5)
                r27 = r9
                r9 = 44
                if (r8 == r9) goto L_0x00f4
                char r8 = r3.charAt(r5)
                r9 = 59
                if (r8 != r9) goto L_0x0090
                goto L_0x00f4
            L_0x0090:
                int r5 = r5 + 1
                int r5 = okhttp3.internal.Util.indexOfNonWhitespace(r3, r5)
                int r8 = r3.length()
                if (r5 >= r8) goto L_0x00ca
                char r8 = r3.charAt(r5)
                r9 = 34
                if (r8 != r9) goto L_0x00ca
                int r5 = r5 + 1
                r28 = r3
                java.lang.CharSequence r28 = (java.lang.CharSequence) r28
                r29 = 34
                r31 = 0
                r32 = 4
                r33 = 0
                r30 = r5
                int r4 = kotlin.text.StringsKt.indexOf$default(r28, r29, r30, r31, r32, r33)
                if (r3 == 0) goto L_0x00c4
                java.lang.String r1 = r3.substring(r5, r4)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 1
                int r4 = r4 + r2
                goto L_0x00f9
            L_0x00c4:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r1)
                throw r0
            L_0x00ca:
                java.lang.String r8 = ",;"
                int r4 = r4.indexOfElement(r3, r8, r5)
                if (r3 == 0) goto L_0x00ec
                java.lang.String r1 = r3.substring(r5, r4)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                if (r1 == 0) goto L_0x00e6
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
                java.lang.String r1 = r1.toString()
                goto L_0x00f9
            L_0x00e6:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r7)
                throw r0
            L_0x00ec:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r1)
                throw r0
            L_0x00f2:
                r27 = r9
            L_0x00f4:
                int r5 = r5 + 1
                r4 = r5
                r1 = r23
            L_0x00f9:
                java.lang.String r2 = "no-cache"
                r5 = 1
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x0106
                r9 = r5
            L_0x0103:
                r2 = -1
                goto L_0x018f
            L_0x0106:
                java.lang.String r2 = "no-store"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x0112
                r10 = r5
            L_0x010f:
                r9 = r27
                goto L_0x0103
            L_0x0112:
                java.lang.String r2 = "max-age"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x0123
                r2 = -1
                int r11 = okhttp3.internal.Util.toNonNegativeInt(r1, r2)
            L_0x011f:
                r9 = r27
                goto L_0x018f
            L_0x0123:
                r2 = -1
                java.lang.String r7 = "s-maxage"
                boolean r7 = kotlin.text.StringsKt.equals(r7, r0, r5)
                if (r7 == 0) goto L_0x0131
                int r12 = okhttp3.internal.Util.toNonNegativeInt(r1, r2)
                goto L_0x011f
            L_0x0131:
                java.lang.String r2 = "private"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x013b
                r13 = r5
                goto L_0x010f
            L_0x013b:
                java.lang.String r2 = "public"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x0145
                r14 = r5
                goto L_0x010f
            L_0x0145:
                java.lang.String r2 = "must-revalidate"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x014f
                r15 = r5
                goto L_0x010f
            L_0x014f:
                java.lang.String r2 = "max-stale"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x015f
                r0 = 2147483647(0x7fffffff, float:NaN)
                int r16 = okhttp3.internal.Util.toNonNegativeInt(r1, r0)
                goto L_0x010f
            L_0x015f:
                java.lang.String r2 = "min-fresh"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r0, r5)
                if (r2 == 0) goto L_0x016d
                r2 = -1
                int r17 = okhttp3.internal.Util.toNonNegativeInt(r1, r2)
                goto L_0x011f
            L_0x016d:
                r2 = -1
                java.lang.String r1 = "only-if-cached"
                boolean r1 = kotlin.text.StringsKt.equals(r1, r0, r5)
                if (r1 == 0) goto L_0x0179
                r18 = r5
                goto L_0x011f
            L_0x0179:
                java.lang.String r1 = "no-transform"
                boolean r1 = kotlin.text.StringsKt.equals(r1, r0, r5)
                if (r1 == 0) goto L_0x0184
                r19 = r5
                goto L_0x011f
            L_0x0184:
                java.lang.String r1 = "immutable"
                boolean r0 = kotlin.text.StringsKt.equals(r1, r0, r5)
                if (r0 == 0) goto L_0x011f
                r20 = r5
                goto L_0x011f
            L_0x018f:
                r0 = r4
                r1 = r23
                r2 = r24
                r7 = r25
                r8 = r26
                goto L_0x0044
            L_0x019a:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r7)
                throw r0
            L_0x01a0:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r1)
                throw r0
            L_0x01a6:
                r23 = r1
                r24 = r2
                r25 = r7
                r26 = r8
                r27 = r9
                goto L_0x01b5
            L_0x01b1:
                r23 = r1
                r24 = r2
            L_0x01b5:
                r2 = -1
                int r6 = r6 + 1
                r0 = r35
                r1 = r23
                r2 = r24
                goto L_0x0023
            L_0x01c0:
                r23 = r1
                if (r7 != 0) goto L_0x01c7
                r21 = r23
                goto L_0x01c9
            L_0x01c7:
                r21 = r8
            L_0x01c9:
                okhttp3.CacheControl r0 = new okhttp3.CacheControl
                r22 = 0
                r8 = r0
                r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        private final int indexOfElement(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }
    }

    @JvmStatic
    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    /* renamed from: -deprecated_noCache reason: not valid java name */
    public final boolean m1062deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    /* renamed from: -deprecated_noStore reason: not valid java name */
    public final boolean m1063deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    /* renamed from: -deprecated_maxAgeSeconds reason: not valid java name */
    public final int m1058deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    /* renamed from: -deprecated_sMaxAgeSeconds reason: not valid java name */
    public final int m1066deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    /* renamed from: -deprecated_mustRevalidate reason: not valid java name */
    public final boolean m1061deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    /* renamed from: -deprecated_maxStaleSeconds reason: not valid java name */
    public final int m1059deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    /* renamed from: -deprecated_minFreshSeconds reason: not valid java name */
    public final int m1060deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    /* renamed from: -deprecated_onlyIfCached reason: not valid java name */
    public final boolean m1065deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    /* renamed from: -deprecated_noTransform reason: not valid java name */
    public final boolean m1064deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    /* renamed from: -deprecated_immutable reason: not valid java name */
    public final boolean m1057deprecated_immutable() {
        return this.immutable;
    }

    public String toString() {
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            String str2 = ", ";
            if (this.maxAgeSeconds != -1) {
                sb.append("max-age=");
                sb.append(this.maxAgeSeconds);
                sb.append(str2);
            }
            if (this.sMaxAgeSeconds != -1) {
                sb.append("s-maxage=");
                sb.append(this.sMaxAgeSeconds);
                sb.append(str2);
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb.append("max-stale=");
                sb.append(this.maxStaleSeconds);
                sb.append(str2);
            }
            if (this.minFreshSeconds != -1) {
                sb.append("min-fresh=");
                sb.append(this.minFreshSeconds);
                sb.append(str2);
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            str = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(str, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = str;
        }
        return str;
    }
}
