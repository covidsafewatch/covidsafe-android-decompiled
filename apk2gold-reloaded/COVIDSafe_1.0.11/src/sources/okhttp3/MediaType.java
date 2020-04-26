package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\u0014"}, d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "charset", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: MediaType.kt */
public final class MediaType {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    /* access modifiers changed from: private */
    public static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MediaType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MediaType get(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toMediaType");
            CharSequence charSequence = str;
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(charSequence);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                String str2 = "Locale.US";
                Intrinsics.checkExpressionValueIsNotNull(locale, str2);
                String str3 = "null cannot be cast to non-null type java.lang.String";
                if (group != null) {
                    String lowerCase = group.toLowerCase(locale);
                    String str4 = "(this as java.lang.String).toLowerCase(locale)";
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, str4);
                    String group2 = matcher.group(2);
                    Intrinsics.checkExpressionValueIsNotNull(group2, "typeSubtype.group(2)");
                    Locale locale2 = Locale.US;
                    Intrinsics.checkExpressionValueIsNotNull(locale2, str2);
                    if (group2 != null) {
                        String lowerCase2 = group2.toLowerCase(locale2);
                        Intrinsics.checkExpressionValueIsNotNull(lowerCase2, str4);
                        String str5 = null;
                        Matcher matcher2 = MediaType.PARAMETER.matcher(charSequence);
                        int end = matcher.end();
                        String str6 = str5;
                        while (end < str.length()) {
                            matcher2.region(end, str.length());
                            String str7 = "\" for: \"";
                            if (matcher2.lookingAt()) {
                                String group3 = matcher2.group(1);
                                if (group3 == null || !StringsKt.equals(group3, "charset", true)) {
                                    end = matcher2.end();
                                } else {
                                    String group4 = matcher2.group(2);
                                    boolean z = false;
                                    if (group4 == null) {
                                        group4 = matcher2.group(3);
                                        Intrinsics.checkExpressionValueIsNotNull(group4, "parameter.group(3)");
                                    } else {
                                        String str8 = "'";
                                        if (StringsKt.startsWith$default(group4, str8, false, 2, null) && StringsKt.endsWith$default(group4, str8, false, 2, null) && group4.length() > 2) {
                                            group4 = group4.substring(1, group4.length() - 1);
                                            Intrinsics.checkExpressionValueIsNotNull(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        }
                                    }
                                    if (str6 == null || StringsKt.equals(group4, str6, true)) {
                                        z = true;
                                    }
                                    if (z) {
                                        str6 = group4;
                                        end = matcher2.end();
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Multiple charsets defined: \"");
                                        sb.append(str6);
                                        sb.append("\" and: \"");
                                        sb.append(group4);
                                        sb.append(str7);
                                        sb.append(str);
                                        sb.append(Typography.quote);
                                        throw new IllegalArgumentException(sb.toString().toString());
                                    }
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Parameter is not formatted correctly: \"");
                                String substring = str.substring(end);
                                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                                sb2.append(substring);
                                sb2.append(str7);
                                sb2.append(str);
                                sb2.append(Typography.quote);
                                throw new IllegalArgumentException(sb2.toString().toString());
                            }
                        }
                        MediaType mediaType = new MediaType(str, lowerCase, lowerCase2, str6, null);
                        return mediaType;
                    }
                    throw new TypeCastException(str3);
                }
                throw new TypeCastException(str3);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("No subtype found for: \"");
            sb3.append(str);
            sb3.append(Typography.quote);
            throw new IllegalArgumentException(sb3.toString().toString());
        }

        @JvmStatic
        public final MediaType parse(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        /* renamed from: -deprecated_get reason: not valid java name */
        public final MediaType m1121deprecated_get(String str) {
            Intrinsics.checkParameterIsNotNull(str, "mediaType");
            return get(str);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        /* renamed from: -deprecated_parse reason: not valid java name */
        public final MediaType m1122deprecated_parse(String str) {
            Intrinsics.checkParameterIsNotNull(str, "mediaType");
            return parse(str);
        }
    }

    @JvmStatic
    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    private MediaType(String str, String str2, String str3, String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4);
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType2, Charset charset2, int i, Object obj) {
        if ((i & 1) != 0) {
            charset2 = null;
        }
        return mediaType2.charset(charset2);
    }

    public final Charset charset(Charset charset2) {
        try {
            return this.charset != null ? Charset.forName(this.charset) : charset2;
        } catch (IllegalArgumentException unused) {
            return charset2;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* renamed from: -deprecated_type reason: not valid java name */
    public final String m1120deprecated_type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))
    /* renamed from: -deprecated_subtype reason: not valid java name */
    public final String m1119deprecated_subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual((Object) ((MediaType) obj).mediaType, (Object) this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }
}
