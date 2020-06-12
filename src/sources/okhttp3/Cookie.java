package okhttp3;

import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Cookie.kt */
public final class Cookie {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    @JvmStatic
    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
        if (this.hostOnly) {
            z = Intrinsics.areEqual((Object) httpUrl.host(), (Object) this.domain);
        } else {
            z = Companion.domainMatch(httpUrl.host(), this.domain);
        }
        if (!z || !Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return Intrinsics.areEqual((Object) cookie.name, (Object) this.name) && Intrinsics.areEqual((Object) cookie.value, (Object) this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual((Object) cookie.domain, (Object) this.domain) && Intrinsics.areEqual((Object) cookie.path, (Object) this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
        }
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.secure)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.httpOnly)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.persistent)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.hostOnly);
    }

    public String toString() {
        return toString$okhttp(false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m1079deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m1083deprecated_value() {
        return this.value;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m1081deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m1076deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m1077deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m1075deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m1080deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m1078deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m1082deprecated_secure() {
        return this.secure;
    }

    public final String toString$okhttp(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "toString()");
        return sb2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Cookie.kt */
    public static final class Builder {
        private String domain;
        private long expiresAt = DatesKt.MAX_DATE;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path = "/";
        private boolean persistent;
        private boolean secure;
        private String value;

        public final Builder name(String str) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Builder builder = this;
            if (Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) str).toString(), (Object) str)) {
                builder.name = str;
                return builder;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder value(String str) {
            Intrinsics.checkParameterIsNotNull(str, "value");
            Builder builder = this;
            if (Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) str).toString(), (Object) str)) {
                builder.value = str;
                return builder;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        public final Builder expiresAt(long j) {
            Builder builder = this;
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DatesKt.MAX_DATE) {
                j = 253402300799999L;
            }
            builder.expiresAt = j;
            builder.persistent = true;
            return builder;
        }

        public final Builder domain(String str) {
            Intrinsics.checkParameterIsNotNull(str, "domain");
            return domain(str, false);
        }

        public final Builder hostOnlyDomain(String str) {
            Intrinsics.checkParameterIsNotNull(str, "domain");
            return domain(str, true);
        }

        private final Builder domain(String str, boolean z) {
            Builder builder = this;
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                builder.domain = canonicalHost;
                builder.hostOnly = z;
                return builder;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        public final Builder path(String str) {
            Intrinsics.checkParameterIsNotNull(str, "path");
            Builder builder = this;
            if (StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
                builder.path = str;
                return builder;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            Builder builder = this;
            builder.secure = true;
            return builder;
        }

        public final Builder httpOnly() {
            Builder builder = this;
            builder.httpOnly = true;
            return builder;
        }

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, (DefaultConstructorMarker) null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Cookie.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                return true;
            }
            if (!StringsKt.endsWith$default(str, str2, false, 2, (Object) null) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.canParseAsIpAddress(str)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.areEqual((Object) encodedPath, (Object) str)) {
                return true;
            }
            return StringsKt.startsWith$default(encodedPath, str, false, 2, (Object) null) && (StringsKt.endsWith$default(str, "/", false, 2, (Object) null) || encodedPath.charAt(str.length()) == '/');
        }

        @JvmStatic
        public final Cookie parse(HttpUrl httpUrl, String str) {
            Intrinsics.checkParameterIsNotNull(httpUrl, "url");
            Intrinsics.checkParameterIsNotNull(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x011d  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0144 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0145  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.Cookie parse$okhttp(long r25, okhttp3.HttpUrl r27, java.lang.String r28) {
            /*
                r24 = this;
                r6 = r28
                java.lang.String r0 = "url"
                r7 = r27
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
                java.lang.String r0 = "setCookie"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
                r1 = 59
                r2 = 0
                r3 = 0
                r4 = 6
                r5 = 0
                r0 = r28
                int r8 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r0, (char) r1, (int) r2, (int) r3, (int) r4, (java.lang.Object) r5)
                r1 = 61
                r4 = 2
                r3 = r8
                int r0 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r0, (char) r1, (int) r2, (int) r3, (int) r4, (java.lang.Object) r5)
                r1 = 0
                if (r0 != r8) goto L_0x0026
                return r1
            L_0x0026:
                r2 = 0
                r3 = 1
                java.lang.String r10 = okhttp3.internal.Util.trimSubstring$default(r6, r2, r0, r3, r1)
                r4 = r10
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r4 = r4.length()
                if (r4 != 0) goto L_0x0037
                r4 = 1
                goto L_0x0038
            L_0x0037:
                r4 = 0
            L_0x0038:
                if (r4 != 0) goto L_0x0184
                int r4 = okhttp3.internal.Util.indexOfControlOrNonAscii(r10)
                r5 = -1
                if (r4 == r5) goto L_0x0043
                goto L_0x0184
            L_0x0043:
                int r0 = r0 + r3
                java.lang.String r11 = okhttp3.internal.Util.trimSubstring(r6, r0, r8)
                int r0 = okhttp3.internal.Util.indexOfControlOrNonAscii(r11)
                if (r0 == r5) goto L_0x004f
                return r1
            L_0x004f:
                r0 = r1
                java.lang.String r0 = (java.lang.String) r0
                int r8 = r8 + r3
                int r4 = r28.length()
                r12 = -1
                r5 = r0
                r20 = r12
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 1
                r22 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0069:
                if (r8 >= r4) goto L_0x00e4
                r9 = 59
                int r9 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r6, (char) r9, (int) r8, (int) r4)
                r1 = 61
                int r1 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r6, (char) r1, (int) r8, (int) r9)
                java.lang.String r8 = okhttp3.internal.Util.trimSubstring(r6, r8, r1)
                if (r1 >= r9) goto L_0x0084
                int r1 = r1 + 1
                java.lang.String r1 = okhttp3.internal.Util.trimSubstring(r6, r1, r9)
                goto L_0x0086
            L_0x0084:
                java.lang.String r1 = ""
            L_0x0086:
                java.lang.String r14 = "expires"
                boolean r14 = kotlin.text.StringsKt.equals(r8, r14, r3)
                if (r14 == 0) goto L_0x009b
                r8 = r24
                okhttp3.Cookie$Companion r8 = (okhttp3.Cookie.Companion) r8     // Catch:{ IllegalArgumentException -> 0x00e0 }
                int r14 = r1.length()     // Catch:{ IllegalArgumentException -> 0x00e0 }
                long r22 = r8.parseExpires(r1, r2, r14)     // Catch:{ IllegalArgumentException -> 0x00e0 }
                goto L_0x00ab
            L_0x009b:
                java.lang.String r14 = "max-age"
                boolean r14 = kotlin.text.StringsKt.equals(r8, r14, r3)
                if (r14 == 0) goto L_0x00ae
                r8 = r24
                okhttp3.Cookie$Companion r8 = (okhttp3.Cookie.Companion) r8     // Catch:{  }
                long r20 = r8.parseMaxAge(r1)     // Catch:{  }
            L_0x00ab:
                r18 = 1
                goto L_0x00e0
            L_0x00ae:
                java.lang.String r14 = "domain"
                boolean r14 = kotlin.text.StringsKt.equals(r8, r14, r3)
                if (r14 == 0) goto L_0x00c1
                r8 = r24
                okhttp3.Cookie$Companion r8 = (okhttp3.Cookie.Companion) r8     // Catch:{ IllegalArgumentException -> 0x00e0 }
                java.lang.String r0 = r8.parseDomain(r1)     // Catch:{ IllegalArgumentException -> 0x00e0 }
                r19 = 0
                goto L_0x00e0
            L_0x00c1:
                java.lang.String r14 = "path"
                boolean r14 = kotlin.text.StringsKt.equals(r8, r14, r3)
                if (r14 == 0) goto L_0x00cb
                r5 = r1
                goto L_0x00e0
            L_0x00cb:
                java.lang.String r1 = "secure"
                boolean r1 = kotlin.text.StringsKt.equals(r8, r1, r3)
                if (r1 == 0) goto L_0x00d6
                r16 = 1
                goto L_0x00e0
            L_0x00d6:
                java.lang.String r1 = "httponly"
                boolean r1 = kotlin.text.StringsKt.equals(r8, r1, r3)
                if (r1 == 0) goto L_0x00e0
                r17 = 1
            L_0x00e0:
                int r8 = r9 + 1
                r1 = 0
                goto L_0x0069
            L_0x00e4:
                r3 = -9223372036854775808
                int r1 = (r20 > r3 ? 1 : (r20 == r3 ? 0 : -1))
                if (r1 != 0) goto L_0x00ec
            L_0x00ea:
                r12 = r3
                goto L_0x0117
            L_0x00ec:
                int r1 = (r20 > r12 ? 1 : (r20 == r12 ? 0 : -1))
                if (r1 == 0) goto L_0x0115
                r3 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r1 = (r20 > r3 ? 1 : (r20 == r3 ? 0 : -1))
                if (r1 > 0) goto L_0x00ff
                r1 = 1000(0x3e8, float:1.401E-42)
                long r3 = (long) r1
                long r20 = r20 * r3
                goto L_0x0104
            L_0x00ff:
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x0104:
                long r3 = r25 + r20
                int r1 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
                r8 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                if (r1 < 0) goto L_0x0113
                int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
                if (r1 <= 0) goto L_0x00ea
            L_0x0113:
                r12 = r8
                goto L_0x0117
            L_0x0115:
                r12 = r22
            L_0x0117:
                java.lang.String r1 = r27.host()
                if (r0 != 0) goto L_0x0120
                r14 = r1
                r3 = 0
                goto L_0x012e
            L_0x0120:
                r3 = r24
                okhttp3.Cookie$Companion r3 = (okhttp3.Cookie.Companion) r3
                boolean r3 = r3.domainMatch(r1, r0)
                if (r3 != 0) goto L_0x012c
                r3 = 0
                return r3
            L_0x012c:
                r3 = 0
                r14 = r0
            L_0x012e:
                int r0 = r1.length()
                int r1 = r14.length()
                if (r0 == r1) goto L_0x0145
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = r0.get()
                java.lang.String r0 = r0.getEffectiveTldPlusOne(r14)
                if (r0 != 0) goto L_0x0145
                return r3
            L_0x0145:
                java.lang.String r0 = "/"
                if (r5 == 0) goto L_0x0153
                r1 = 2
                boolean r1 = kotlin.text.StringsKt.startsWith$default(r5, r0, r2, r1, r3)
                if (r1 != 0) goto L_0x0151
                goto L_0x0153
            L_0x0151:
                r15 = r5
                goto L_0x017b
            L_0x0153:
                java.lang.String r1 = r27.encodedPath()
                r3 = r1
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r4 = 47
                r5 = 0
                r6 = 0
                r7 = 6
                r8 = 0
                int r3 = kotlin.text.StringsKt.lastIndexOf$default((java.lang.CharSequence) r3, (char) r4, (int) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
                if (r3 == 0) goto L_0x017a
                if (r1 == 0) goto L_0x0172
                java.lang.String r0 = r1.substring(r2, r3)
                java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                goto L_0x017a
            L_0x0172:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)
                throw r0
            L_0x017a:
                r15 = r0
            L_0x017b:
                okhttp3.Cookie r0 = new okhttp3.Cookie
                r20 = 0
                r9 = r0
                r9.<init>(r10, r11, r12, r14, r15, r16, r17, r18, r19, r20)
                return r0
            L_0x0184:
                r0 = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        private final long parseExpires(String str, int i, int i2) {
            String str2 = str;
            int i3 = i2;
            Companion companion = this;
            int dateCharacterOffset = companion.dateCharacterOffset(str2, i, i3, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str2);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            while (dateCharacterOffset < i3) {
                int dateCharacterOffset2 = companion.dateCharacterOffset(str2, dateCharacterOffset + 1, i3, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i5 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkExpressionValueIsNotNull(group, "matcher.group(1)");
                    i5 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkExpressionValueIsNotNull(group2, "matcher.group(2)");
                    i8 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkExpressionValueIsNotNull(group3, "matcher.group(3)");
                    i9 = Integer.parseInt(group3);
                } else if (i6 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkExpressionValueIsNotNull(group4, "matcher.group(1)");
                    i6 = Integer.parseInt(group4);
                } else if (i7 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkExpressionValueIsNotNull(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                    if (group5 != null) {
                        String lowerCase = group5.toLowerCase(locale);
                        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String pattern = Cookie.MONTH_PATTERN.pattern();
                        Intrinsics.checkExpressionValueIsNotNull(pattern, "MONTH_PATTERN.pattern()");
                        i7 = StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (i4 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkExpressionValueIsNotNull(group6, "matcher.group(1)");
                    i4 = Integer.parseInt(group6);
                }
                dateCharacterOffset = companion.dateCharacterOffset(str2, dateCharacterOffset2 + 1, i3, false);
            }
            if (70 <= i4 && 99 >= i4) {
                i4 += 1900;
            }
            if (i4 >= 0 && 69 >= i4) {
                i4 += 2000;
            }
            if (i4 >= 1601) {
                if (i7 != -1) {
                    if (1 <= i6 && 31 >= i6) {
                        if (i5 >= 0 && 23 >= i5) {
                            if (i8 >= 0 && 59 >= i8) {
                                if (i9 >= 0 && 59 >= i9) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i4);
                                    gregorianCalendar.set(2, i7 - 1);
                                    gregorianCalendar.set(5, i6);
                                    gregorianCalendar.set(11, i5);
                                    gregorianCalendar.set(12, i8);
                                    gregorianCalendar.set(13, i9);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final int dateCharacterOffset(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (((charAt < ' ' && charAt != 9) || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e) {
                if (!new Regex("-?\\d+").matches(str)) {
                    throw e;
                } else if (StringsKt.startsWith$default(str, "-", false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return LongCompanionObject.MAX_VALUE;
                }
            }
        }

        private final String parseDomain(String str) {
            if (!StringsKt.endsWith$default(str, ".", false, 2, (Object) null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(str, (CharSequence) "."));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            Intrinsics.checkParameterIsNotNull(httpUrl, "url");
            Intrinsics.checkParameterIsNotNull(headers, "headers");
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            List list = null;
            int size = values.size();
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(httpUrl, values.get(i));
                if (parse != null) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(parse);
                }
            }
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(list);
            Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        }
    }
}
