package okio.internal;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\b\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\nH\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\nH\b\u001a\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\b\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n*\u00020\u0010H\b\u001a\r\u0010\u0015\u001a\u00020\n*\u00020\u0010H\b\u001a\r\u0010\u0016\u001a\u00020\n*\u00020\u0010H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\b\u001a\u0017\u0010\u001a\u001a\u00020\u0018*\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\b\u001a\r\u0010\u001f\u001a\u00020\u0005*\u00020\nH\b\u001a\r\u0010 \u001a\u00020\u0005*\u00020\nH\b\u001a\r\u0010!\u001a\u00020\u0010*\u00020\nH\b\u001a\u001d\u0010\"\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\nH\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005H\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\nH\b\u001a\u001d\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\b\u001a\r\u0010/\u001a\u00020\n*\u00020\nH\b\u001a\r\u00100\u001a\u00020\n*\u00020\nH\b\u001a\r\u00101\u001a\u00020\u0007*\u00020\nH\b\u001a\u001d\u00102\u001a\u00020\n*\u00020\u00072\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a\r\u00103\u001a\u00020\u0010*\u00020\nH\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\nH\b\u001a$\u00105\u001a\u000206*\u00020\n2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u00069"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: ByteString.kt */
public final class ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String commonUtf8(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final String commonBase64(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(ByteString byteString) {
        byte[] data$okio;
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonHex");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        int i = 0;
        for (byte b : byteString.getData$okio()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static final ByteString commonToAsciiLowercase(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonToAsciiLowercase");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b = byteString.getData$okio()[i];
            byte b2 = (byte) 65;
            if (b >= b2) {
                byte b3 = (byte) 90;
                if (b <= b3) {
                    byte[] data$okio = byteString.getData$okio();
                    byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                    Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                    copyOf[i] = (byte) (b + 32);
                    for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                        byte b4 = copyOf[i2];
                        if (b4 >= b2 && b4 <= b3) {
                            copyOf[i2] = (byte) (b4 + 32);
                        }
                    }
                    return new ByteString(copyOf);
                }
            }
        }
        return byteString;
    }

    public static final ByteString commonToAsciiUppercase(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonToAsciiUppercase");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b = byteString.getData$okio()[i];
            byte b2 = (byte) 97;
            if (b >= b2) {
                byte b3 = (byte) 122;
                if (b <= b3) {
                    byte[] data$okio = byteString.getData$okio();
                    byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                    Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                    copyOf[i] = (byte) (b - 32);
                    for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                        byte b4 = copyOf[i2];
                        if (b4 >= b2 && b4 <= b3) {
                            copyOf[i2] = (byte) (b4 - 32);
                        }
                    }
                    return new ByteString(copyOf);
                }
            }
        }
        return byteString;
    }

    public static final ByteString commonSubstring(ByteString byteString, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonSubstring");
        boolean z = true;
        if (i >= 0) {
            if (i2 <= byteString.getData$okio().length) {
                if (i2 - i < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i == 0 && i2 == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), i, i2));
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("endIndex > length(");
                sb.append(byteString.getData$okio().length);
                sb.append(')');
                throw new IllegalArgumentException(sb.toString().toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final byte commonGetByte(ByteString byteString, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final byte[] commonToByteArray(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, ByteString byteString2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(bArr, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(byteString.getData$okio(), i, bArr, i2, i3);
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonIndexOf(ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString byteString2, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(bArr, "other");
        for (int min = Math.min(i, byteString.getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(ByteString byteString, Object obj) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final int commonHashCode(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final int commonCompareTo(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonCompareTo");
        Intrinsics.checkParameterIsNotNull(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (true) {
            int i2 = -1;
            if (i < min) {
                byte b = byteString.getByte(i) & 255;
                byte b2 = byteString2.getByte(i) & 255;
                if (b == b2) {
                    i++;
                } else {
                    if (b >= b2) {
                        i2 = 1;
                    }
                    return i2;
                }
            } else if (size == size2) {
                return 0;
            } else {
                if (size >= size2) {
                    i2 = 1;
                }
                return i2;
            }
        }
    }

    public static final ByteString commonOf(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final ByteString commonToByteString(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new ByteString(ArraysKt.copyOfRange(bArr, i, i2 + i));
    }

    public static final ByteString commonEncodeUtf8(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final ByteString commonDecodeBase64(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$commonDecodeHex");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new ByteString(bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected hex string: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(byteString, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected hex digit: ");
                sb.append(c);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (c - c2) + 10;
    }

    public static final String commonToString(ByteString byteString) {
        String str;
        String str2;
        ByteString byteString2 = byteString;
        Intrinsics.checkParameterIsNotNull(byteString2, "$this$commonToString");
        boolean z = true;
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        String str3 = "…]";
        String str4 = "[size=";
        if (access$codePointIndexToCharIndex == -1) {
            if (byteString.getData$okio().length <= 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[hex=");
                sb.append(byteString.hex());
                sb.append(']');
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(byteString.getData$okio().length);
                sb2.append(" hex=");
                if (64 > byteString.getData$okio().length) {
                    z = false;
                }
                if (z) {
                    if (64 != byteString.getData$okio().length) {
                        byteString2 = new ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), 0, 64));
                    }
                    sb2.append(byteString2.hex());
                    sb2.append(str3);
                    str2 = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("endIndex > length(");
                    sb3.append(byteString.getData$okio().length);
                    sb3.append(')');
                    throw new IllegalArgumentException(sb3.toString().toString());
                }
            }
            return str2;
        }
        String utf8 = byteString.utf8();
        if (utf8 != null) {
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), StringUtils.EOL, "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str4);
                sb4.append(byteString.getData$okio().length);
                sb4.append(" text=");
                sb4.append(replace$default);
                sb4.append(str3);
                str = sb4.toString();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[text=");
                sb5.append(replace$default);
                sb5.append(']');
                str = sb5.toString();
            }
            return str;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006b, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x01e8
            byte r7 = r0[r4]
            r8 = 127(0x7f, float:1.78E-43)
            r9 = 159(0x9f, float:2.23E-43)
            r10 = 31
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x0075
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0039
            if (r7 == r11) goto L_0x0039
            if (r7 < 0) goto L_0x002e
            if (r10 >= r7) goto L_0x0033
        L_0x002e:
            if (r8 <= r7) goto L_0x0031
            goto L_0x0036
        L_0x0031:
            if (r9 < r7) goto L_0x0036
        L_0x0033:
            r6 = r17
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            if (r6 != 0) goto L_0x003b
        L_0x0039:
            if (r7 != r12) goto L_0x003c
        L_0x003b:
            return r16
        L_0x003c:
            if (r7 >= r14) goto L_0x0041
            r6 = r17
            goto L_0x0042
        L_0x0041:
            r6 = 2
        L_0x0042:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x0045:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r7 = r4 + 1
            byte r4 = r0[r4]
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0056
            return r5
        L_0x0056:
            if (r4 == r13) goto L_0x0069
            if (r4 == r11) goto L_0x0069
            if (r4 < 0) goto L_0x005e
            if (r10 >= r4) goto L_0x0063
        L_0x005e:
            if (r8 <= r4) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            if (r9 < r4) goto L_0x0066
        L_0x0063:
            r6 = r17
            goto L_0x0067
        L_0x0066:
            r6 = 0
        L_0x0067:
            if (r6 != 0) goto L_0x006b
        L_0x0069:
            if (r4 != r12) goto L_0x006c
        L_0x006b:
            return r16
        L_0x006c:
            if (r4 >= r14) goto L_0x0071
            r4 = r17
            goto L_0x0072
        L_0x0071:
            r4 = 2
        L_0x0072:
            int r5 = r5 + r4
            r4 = r7
            goto L_0x0045
        L_0x0075:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00ca
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x0084
            if (r6 != r1) goto L_0x0083
            return r5
        L_0x0083:
            return r16
        L_0x0084:
            byte r7 = r0[r4]
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x008f
            r15 = r17
            goto L_0x0090
        L_0x008f:
            r15 = 0
        L_0x0090:
            if (r15 != 0) goto L_0x0096
            if (r6 != r1) goto L_0x0095
            return r5
        L_0x0095:
            return r16
        L_0x0096:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x00a1
            if (r6 != r1) goto L_0x00a0
            return r5
        L_0x00a0:
            return r16
        L_0x00a1:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00a6
            return r5
        L_0x00a6:
            if (r3 == r13) goto L_0x00b9
            if (r3 == r11) goto L_0x00b9
            if (r3 < 0) goto L_0x00ae
            if (r10 >= r3) goto L_0x00b3
        L_0x00ae:
            if (r8 <= r3) goto L_0x00b1
            goto L_0x00b6
        L_0x00b1:
            if (r9 < r3) goto L_0x00b6
        L_0x00b3:
            r6 = r17
            goto L_0x00b7
        L_0x00b6:
            r6 = 0
        L_0x00b7:
            if (r6 != 0) goto L_0x00bb
        L_0x00b9:
            if (r3 != r12) goto L_0x00bc
        L_0x00bb:
            return r16
        L_0x00bc:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00c3
            r15 = r17
            goto L_0x00c4
        L_0x00c3:
            r15 = 2
        L_0x00c4:
            int r5 = r5 + r15
            int r4 = r4 + 2
        L_0x00c7:
            r6 = r7
            goto L_0x0008
        L_0x00ca:
            int r3 = r7 >> 4
            r12 = 55296(0xd800, float:7.7486E-41)
            r9 = 57343(0xdfff, float:8.0355E-41)
            if (r3 != r15) goto L_0x014a
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x00dc
            if (r6 != r1) goto L_0x00db
            return r5
        L_0x00db:
            return r16
        L_0x00dc:
            byte r7 = r0[r4]
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r8 = r15 & 192(0xc0, float:2.69E-43)
            if (r8 != r14) goto L_0x00e9
            r8 = r17
            goto L_0x00ea
        L_0x00e9:
            r8 = 0
        L_0x00ea:
            if (r8 != 0) goto L_0x00f0
            if (r6 != r1) goto L_0x00ef
            return r5
        L_0x00ef:
            return r16
        L_0x00f0:
            byte r3 = r0[r3]
            r8 = r3 & 192(0xc0, float:2.69E-43)
            if (r8 != r14) goto L_0x00f9
            r8 = r17
            goto L_0x00fa
        L_0x00f9:
            r8 = 0
        L_0x00fa:
            if (r8 != 0) goto L_0x0100
            if (r6 != r1) goto L_0x00ff
            return r5
        L_0x00ff:
            return r16
        L_0x0100:
            r8 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r8
            int r8 = r15 << 6
            r3 = r3 ^ r8
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x0112
            if (r6 != r1) goto L_0x0111
            return r5
        L_0x0111:
            return r16
        L_0x0112:
            if (r12 <= r3) goto L_0x0115
            goto L_0x011b
        L_0x0115:
            if (r9 < r3) goto L_0x011b
            if (r6 != r1) goto L_0x011a
            return r5
        L_0x011a:
            return r16
        L_0x011b:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x0120
            return r5
        L_0x0120:
            if (r3 == r13) goto L_0x0137
            if (r3 == r11) goto L_0x0137
            if (r3 < 0) goto L_0x0128
            if (r10 >= r3) goto L_0x0131
        L_0x0128:
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 <= r3) goto L_0x012d
            goto L_0x0134
        L_0x012d:
            r6 = 159(0x9f, float:2.23E-43)
            if (r6 < r3) goto L_0x0134
        L_0x0131:
            r6 = r17
            goto L_0x0135
        L_0x0134:
            r6 = 0
        L_0x0135:
            if (r6 != 0) goto L_0x013c
        L_0x0137:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x013d
        L_0x013c:
            return r16
        L_0x013d:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0144
            r15 = r17
            goto L_0x0145
        L_0x0144:
            r15 = 2
        L_0x0145:
            int r5 = r5 + r15
            int r4 = r4 + 3
            goto L_0x00c7
        L_0x014a:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x01e4
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x0156
            if (r6 != r1) goto L_0x0155
            return r5
        L_0x0155:
            return r16
        L_0x0156:
            byte r7 = r0[r4]
            int r8 = r4 + 1
            byte r8 = r0[r8]
            r15 = r8 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x0163
            r15 = r17
            goto L_0x0164
        L_0x0163:
            r15 = 0
        L_0x0164:
            if (r15 != 0) goto L_0x016a
            if (r6 != r1) goto L_0x0169
            return r5
        L_0x0169:
            return r16
        L_0x016a:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x0175
            r10 = r17
            goto L_0x0176
        L_0x0175:
            r10 = 0
        L_0x0176:
            if (r10 != 0) goto L_0x017c
            if (r6 != r1) goto L_0x017b
            return r5
        L_0x017b:
            return r16
        L_0x017c:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x0185
            r10 = r17
            goto L_0x0186
        L_0x0185:
            r10 = 0
        L_0x0186:
            if (r10 != 0) goto L_0x018c
            if (r6 != r1) goto L_0x018b
            return r5
        L_0x018b:
            return r16
        L_0x018c:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r8 = r8 << 12
            r3 = r3 ^ r8
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x01a2
            if (r6 != r1) goto L_0x01a1
            return r5
        L_0x01a1:
            return r16
        L_0x01a2:
            if (r12 <= r3) goto L_0x01a5
            goto L_0x01ab
        L_0x01a5:
            if (r9 < r3) goto L_0x01ab
            if (r6 != r1) goto L_0x01aa
            return r5
        L_0x01aa:
            return r16
        L_0x01ab:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01b3
            if (r6 != r1) goto L_0x01b2
            return r5
        L_0x01b2:
            return r16
        L_0x01b3:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01b8
            return r5
        L_0x01b8:
            if (r3 == r13) goto L_0x01d1
            if (r3 == r11) goto L_0x01d1
            if (r3 < 0) goto L_0x01c2
            r6 = 31
            if (r6 >= r3) goto L_0x01cb
        L_0x01c2:
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 <= r3) goto L_0x01c7
            goto L_0x01ce
        L_0x01c7:
            r6 = 159(0x9f, float:2.23E-43)
            if (r6 < r3) goto L_0x01ce
        L_0x01cb:
            r6 = r17
            goto L_0x01cf
        L_0x01ce:
            r6 = 0
        L_0x01cf:
            if (r6 != 0) goto L_0x01d6
        L_0x01d1:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x01d7
        L_0x01d6:
            return r16
        L_0x01d7:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x01de
            r15 = r17
            goto L_0x01df
        L_0x01de:
            r15 = 2
        L_0x01df:
            int r5 = r5 + r15
            int r4 = r4 + 4
            goto L_0x00c7
        L_0x01e4:
            if (r6 != r1) goto L_0x01e7
            return r5
        L_0x01e7:
            return r16
        L_0x01e8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }
}
