package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\nHÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/http2/Header;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokio/ByteString;", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "hpackSize", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Header.kt */
public final class Header {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ByteString PSEUDO_PREFIX = ByteString.Companion.encodeUtf8(":");
    public static final ByteString RESPONSE_STATUS = ByteString.Companion.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY = ByteString.Companion.encodeUtf8(TARGET_AUTHORITY_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD = ByteString.Companion.encodeUtf8(TARGET_METHOD_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH = ByteString.Companion.encodeUtf8(TARGET_PATH_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME = ByteString.Companion.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i, Object obj) {
        if ((i & 1) != 0) {
            byteString = header.name;
        }
        if ((i & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "name");
        Intrinsics.checkParameterIsNotNull(byteString2, "value");
        return new Header(byteString, byteString2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) header.name) && Intrinsics.areEqual((Object) this.value, (Object) header.value);
    }

    public int hashCode() {
        ByteString byteString = this.name;
        int i = 0;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        if (byteString2 != null) {
            i = byteString2.hashCode();
        }
        return hashCode + i;
    }

    public Header(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "name");
        Intrinsics.checkParameterIsNotNull(byteString2, "value");
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + this.value.size();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Header(String str, String str2) {
        this(ByteString.Companion.encodeUtf8(str), ByteString.Companion.encodeUtf8(str2));
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.Companion.encodeUtf8(str));
        Intrinsics.checkParameterIsNotNull(byteString, "name");
        Intrinsics.checkParameterIsNotNull(str, "value");
    }

    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Header$Companion;", "", "()V", "PSEUDO_PREFIX", "Lokio/ByteString;", "RESPONSE_STATUS", "RESPONSE_STATUS_UTF8", "", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Header.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
