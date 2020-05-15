package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: -Utf8.kt */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
        if (((r0[r5] & 192) == 128) == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x010f, code lost:
        if (((r0[r5] & 192) == 128) == false) goto L_0x0115;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "$this$commonToUtf8String"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            if (r1 < 0) goto L_0x01aa
            int r3 = r0.length
            if (r2 > r3) goto L_0x01aa
            if (r1 > r2) goto L_0x01aa
            int r3 = r2 - r1
            char[] r3 = new char[r3]
            r4 = 0
            r5 = r4
        L_0x0018:
            if (r1 >= r2) goto L_0x01a4
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0039
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            int r1 = r1 + 1
        L_0x0025:
            if (r1 >= r2) goto L_0x0037
            byte r5 = r0[r1]
            if (r5 < 0) goto L_0x0037
            int r5 = r1 + 1
            byte r1 = r0[r1]
            char r1 = (char) r1
            int r6 = r7 + 1
            r3[r7] = r1
            r1 = r5
            r7 = r6
            goto L_0x0025
        L_0x0037:
            r5 = r7
            goto L_0x0018
        L_0x0039:
            int r7 = r6 >> 5
            r8 = -2
            r10 = 128(0x80, float:1.794E-43)
            r11 = 65533(0xfffd, float:9.1831E-41)
            if (r7 != r8) goto L_0x0076
            int r6 = r1 + 1
            if (r2 > r6) goto L_0x004e
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x004c:
            r9 = 1
            goto L_0x0074
        L_0x004e:
            byte r7 = r0[r1]
            byte r6 = r0[r6]
            r8 = r6 & 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x0058
            r8 = 1
            goto L_0x0059
        L_0x0058:
            r8 = r4
        L_0x0059:
            if (r8 != 0) goto L_0x0061
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x004c
        L_0x0061:
            r6 = r6 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r6 = r6 ^ r7
            if (r6 >= r10) goto L_0x006e
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0073
        L_0x006e:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x0073:
            r9 = 2
        L_0x0074:
            int r1 = r1 + r9
            goto L_0x0037
        L_0x0076:
            int r7 = r6 >> 4
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 57343(0xdfff, float:8.0355E-41)
            r15 = 3
            if (r7 != r8) goto L_0x00e6
            int r6 = r1 + 2
            if (r2 > r6) goto L_0x009a
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x004c
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x0096
            r5 = 1
            goto L_0x0097
        L_0x0096:
            r5 = r4
        L_0x0097:
            if (r5 != 0) goto L_0x0073
            goto L_0x004c
        L_0x009a:
            byte r7 = r0[r1]
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00a6
            r9 = 1
            goto L_0x00a7
        L_0x00a6:
            r9 = r4
        L_0x00a7:
            if (r9 != 0) goto L_0x00af
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x004c
        L_0x00af:
            byte r6 = r0[r6]
            r9 = r6 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00b7
            r12 = 1
            goto L_0x00b8
        L_0x00b7:
            r12 = r4
        L_0x00b8:
            if (r12 != 0) goto L_0x00c0
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0073
        L_0x00c0:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r6 = r6 ^ r9
            int r8 = r8 << 6
            r6 = r6 ^ r8
            int r7 = r7 << 12
            r6 = r6 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 >= r7) goto L_0x00d4
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00e4
        L_0x00d4:
            if (r13 <= r6) goto L_0x00d7
            goto L_0x00df
        L_0x00d7:
            if (r14 < r6) goto L_0x00df
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00e4
        L_0x00df:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x00e4:
            r9 = r15
            goto L_0x0074
        L_0x00e6:
            int r6 = r6 >> 3
            if (r6 != r8) goto L_0x019b
            int r6 = r1 + 3
            if (r2 > r6) goto L_0x011b
            int r6 = r5 + 1
            r3[r5] = r11
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0118
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x00fe
            r5 = 1
            goto L_0x00ff
        L_0x00fe:
            r5 = r4
        L_0x00ff:
            if (r5 != 0) goto L_0x0102
            goto L_0x0118
        L_0x0102:
            int r5 = r1 + 2
            if (r2 <= r5) goto L_0x0115
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x010e
            r12 = 1
            goto L_0x010f
        L_0x010e:
            r12 = r4
        L_0x010f:
            if (r12 != 0) goto L_0x0112
            goto L_0x0115
        L_0x0112:
            r9 = r15
            goto L_0x0199
        L_0x0115:
            r9 = 2
            goto L_0x0199
        L_0x0118:
            r9 = 1
            goto L_0x0199
        L_0x011b:
            byte r7 = r0[r1]
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x0127
            r9 = 1
            goto L_0x0128
        L_0x0127:
            r9 = r4
        L_0x0128:
            if (r9 != 0) goto L_0x012f
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0118
        L_0x012f:
            int r9 = r1 + 2
            byte r9 = r0[r9]
            r12 = r9 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0139
            r12 = 1
            goto L_0x013a
        L_0x0139:
            r12 = r4
        L_0x013a:
            if (r12 != 0) goto L_0x0141
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0115
        L_0x0141:
            byte r6 = r0[r6]
            r12 = r6 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0149
            r12 = 1
            goto L_0x014a
        L_0x0149:
            r12 = r4
        L_0x014a:
            if (r12 != 0) goto L_0x0151
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0112
        L_0x0151:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r6 = r6 ^ r10
            int r9 = r9 << 6
            r6 = r6 ^ r9
            int r8 = r8 << 12
            r6 = r6 ^ r8
            int r7 = r7 << 18
            r6 = r6 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r7) goto L_0x0168
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0198
        L_0x0168:
            if (r13 <= r6) goto L_0x016b
            goto L_0x0172
        L_0x016b:
            if (r14 < r6) goto L_0x0172
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0198
        L_0x0172:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x017b
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0198
        L_0x017b:
            if (r6 == r11) goto L_0x0194
            int r7 = r6 >>> 10
            r8 = 55232(0xd7c0, float:7.7397E-41)
            int r7 = r7 + r8
            char r7 = (char) r7
            int r8 = r5 + 1
            r3[r5] = r7
            r5 = r6 & 1023(0x3ff, float:1.434E-42)
            r6 = 56320(0xdc00, float:7.8921E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            int r6 = r8 + 1
            r3[r8] = r5
            goto L_0x0198
        L_0x0194:
            int r6 = r5 + 1
            r3[r5] = r11
        L_0x0198:
            r9 = 4
        L_0x0199:
            int r1 = r1 + r9
            goto L_0x01a1
        L_0x019b:
            int r6 = r5 + 1
            r3[r5] = r11
            int r1 = r1 + 1
        L_0x01a1:
            r5 = r6
            goto L_0x0018
        L_0x01a4:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3, r4, r5)
            return r0
        L_0x01aa:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "size="
            r4.append(r5)
            int r0 = r0.length
            r4.append(r0)
            java.lang.String r0 = " beginIndex="
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " endIndex="
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        int i3;
        char charAt;
        int i4;
        Intrinsics.checkParameterIsNotNull(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i5 = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 >= 128) {
                int length2 = str.length();
                int i6 = i;
                while (i < length2) {
                    char charAt3 = str.charAt(i);
                    if (charAt3 < 128) {
                        int i7 = i6 + 1;
                        bArr[i6] = (byte) charAt3;
                        i++;
                        while (i < length2 && str.charAt(i) < 128) {
                            bArr[i7] = (byte) str.charAt(i);
                            i++;
                            i7++;
                        }
                        i6 = i7;
                    } else {
                        if (charAt3 < 2048) {
                            int i8 = i6 + 1;
                            bArr[i6] = (byte) ((charAt3 >> 6) | 192);
                            i2 = i8 + 1;
                            bArr[i8] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            int i9 = i6 + 1;
                            bArr[i6] = (byte) ((charAt3 >> 12) | 224);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i2 = i10 + 1;
                            bArr[i10] = (byte) ((charAt3 & '?') | 128);
                        } else if (charAt3 > 56319 || length2 <= (i3 = i + 1) || 56320 > (charAt = str.charAt(i3)) || 57343 < charAt) {
                            i2 = i6 + 1;
                            bArr[i6] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int charAt4 = ((charAt3 << 10) + str.charAt(i3)) - 56613888;
                            int i11 = i6 + 1;
                            bArr[i6] = (byte) ((charAt4 >> 18) | 240);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i2 = i13 + 1;
                            bArr[i13] = (byte) ((charAt4 & 63) | 128);
                            i4 = i + 2;
                            i6 = i2;
                        }
                        i4 = i + 1;
                        i6 = i2;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i6);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i] = (byte) charAt2;
            i5 = i + 1;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkExpressionValueIsNotNull(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }
}
