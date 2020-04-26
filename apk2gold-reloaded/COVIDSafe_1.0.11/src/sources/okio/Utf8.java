package okio;

import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a1\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: Utf8.kt */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        char c;
        Intrinsics.checkParameterIsNotNull(str, "$this$utf8Size");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (z) {
                    long j = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j++;
                        } else {
                            if (charAt < 2048) {
                                i3 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i3 = 3;
                            } else {
                                int i4 = i + 1;
                                if (i4 < i2) {
                                    c = str.charAt(i4);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || c < 56320 || c > 57343) {
                                    j++;
                                    i = i4;
                                } else {
                                    j += (long) 4;
                                    i += 2;
                                }
                            }
                            j += (long) i3;
                        }
                        i++;
                    }
                    return j;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("endIndex > string.length: ");
                sb.append(i2);
                sb.append(" > ");
                sb.append(str.length());
                throw new IllegalArgumentException(sb.toString().toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i2);
            sb2.append(" < ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("beginIndex < 0: ");
        sb3.append(i);
        throw new IllegalArgumentException(sb3.toString().toString());
    }

    public static final void processUtf8Bytes(String str, int i, int i2, Function1<? super Byte, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$this$processUtf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                function1.invoke(Byte.valueOf((byte) charAt));
                i++;
                while (i < i2 && str.charAt(i) < 128) {
                    int i3 = i + 1;
                    function1.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i = i3;
                }
            } else {
                if (charAt < 2048) {
                    function1.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else if (55296 > charAt || 57343 < charAt) {
                    function1.invoke(Byte.valueOf((byte) ((charAt >> 12) | 224)));
                    function1.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    if (charAt <= 56319) {
                        int i4 = i + 1;
                        if (i2 > i4) {
                            char charAt2 = str.charAt(i4);
                            if (56320 <= charAt2 && 57343 >= charAt2) {
                                int charAt3 = ((charAt << 10) + str.charAt(i4)) - 56613888;
                                function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i += 2;
                            }
                        }
                    }
                    function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r8 == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0109, code lost:
        if (r8 == false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "$this$processUtf8CodePoints"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r3)
            r3 = r17
        L_0x0012:
            if (r3 >= r1) goto L_0x0184
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0034
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0021:
            if (r3 >= r1) goto L_0x0012
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0012
            int r4 = r3 + 1
            byte r3 = r0[r3]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.invoke(r3)
            r3 = r4
            goto L_0x0021
        L_0x0034:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 0
            r9 = 128(0x80, float:1.794E-43)
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x006f
            int r4 = r3 + 1
            if (r1 > r4) goto L_0x004d
        L_0x0044:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
        L_0x004b:
            r7 = r11
            goto L_0x006d
        L_0x004d:
            byte r5 = r0[r3]
            byte r4 = r0[r4]
            r6 = r4 & 192(0xc0, float:2.69E-43)
            if (r6 != r9) goto L_0x0056
            r8 = r11
        L_0x0056:
            if (r8 != 0) goto L_0x0059
            goto L_0x0044
        L_0x0059:
            r4 = r4 ^ 3968(0xf80, float:5.56E-42)
            int r5 = r5 << 6
            r4 = r4 ^ r5
            if (r4 >= r9) goto L_0x0065
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            goto L_0x0069
        L_0x0065:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0069:
            r2.invoke(r4)
        L_0x006c:
            r7 = 2
        L_0x006d:
            int r3 = r3 + r7
            goto L_0x0012
        L_0x006f:
            int r5 = r4 >> 4
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 57343(0xdfff, float:8.0355E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00de
            int r4 = r3 + 2
            if (r1 > r4) goto L_0x0093
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004b
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x0090
            r8 = r11
        L_0x0090:
            if (r8 != 0) goto L_0x006c
            goto L_0x004b
        L_0x0093:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x009f
            r15 = r11
            goto L_0x00a0
        L_0x009f:
            r15 = r8
        L_0x00a0:
            if (r15 != 0) goto L_0x00aa
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004b
        L_0x00aa:
            byte r4 = r0[r4]
            r15 = r4 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00b1
            r8 = r11
        L_0x00b1:
            if (r8 != 0) goto L_0x00bb
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x006c
        L_0x00bb:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r7
            int r6 = r6 << 6
            r4 = r4 ^ r6
            int r5 = r5 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00d1
        L_0x00c9:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x00cd:
            r2.invoke(r4)
            goto L_0x00dc
        L_0x00d1:
            if (r12 <= r4) goto L_0x00d4
            goto L_0x00d7
        L_0x00d4:
            if (r13 < r4) goto L_0x00d7
            goto L_0x00c9
        L_0x00d7:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00cd
        L_0x00dc:
            r7 = r14
            goto L_0x006d
        L_0x00de:
            int r4 = r4 >> 3
            if (r4 != r6) goto L_0x0179
            int r4 = r3 + 3
            if (r1 > r4) goto L_0x010d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004b
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x00f9
            r4 = r11
            goto L_0x00fa
        L_0x00f9:
            r4 = r8
        L_0x00fa:
            if (r4 != 0) goto L_0x00fe
            goto L_0x004b
        L_0x00fe:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x006c
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x0109
            r8 = r11
        L_0x0109:
            if (r8 != 0) goto L_0x00dc
            goto L_0x006c
        L_0x010d:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x0119
            r15 = r11
            goto L_0x011a
        L_0x0119:
            r15 = r8
        L_0x011a:
            if (r15 != 0) goto L_0x0125
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004b
        L_0x0125:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x012f
            r7 = r11
            goto L_0x0130
        L_0x012f:
            r7 = r8
        L_0x0130:
            if (r7 != 0) goto L_0x013b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x006c
        L_0x013b:
            byte r4 = r0[r4]
            r7 = r4 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0142
            r8 = r11
        L_0x0142:
            if (r8 != 0) goto L_0x014c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x00dc
        L_0x014c:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r4 = r4 ^ r7
            int r7 = r15 << 6
            r4 = r4 ^ r7
            int r6 = r6 << 12
            r4 = r4 ^ r6
            int r5 = r5 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0166
        L_0x015e:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x0162:
            r2.invoke(r4)
            goto L_0x0176
        L_0x0166:
            if (r12 <= r4) goto L_0x0169
            goto L_0x016c
        L_0x0169:
            if (r13 < r4) goto L_0x016c
            goto L_0x015e
        L_0x016c:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r5) goto L_0x0171
            goto L_0x015e
        L_0x0171:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0162
        L_0x0176:
            r7 = 4
            goto L_0x006d
        L_0x0179:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0012
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (r8 == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010b, code lost:
        if (r8 == false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "$this$processUtf16Chars"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r3)
            r3 = r17
        L_0x0012:
            if (r3 >= r1) goto L_0x019f
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0036
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0022:
            if (r3 >= r1) goto L_0x0012
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0012
            int r4 = r3 + 1
            byte r3 = r0[r3]
            char r3 = (char) r3
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r2.invoke(r3)
            r3 = r4
            goto L_0x0022
        L_0x0036:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 0
            r9 = 128(0x80, float:1.794E-43)
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x0070
            int r4 = r3 + 1
            if (r1 > r4) goto L_0x0050
        L_0x0046:
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x004e:
            r7 = r11
            goto L_0x006e
        L_0x0050:
            byte r5 = r0[r3]
            byte r4 = r0[r4]
            r6 = r4 & 192(0xc0, float:2.69E-43)
            if (r6 != r9) goto L_0x0059
            r8 = r11
        L_0x0059:
            if (r8 != 0) goto L_0x005c
            goto L_0x0046
        L_0x005c:
            r4 = r4 ^ 3968(0xf80, float:5.56E-42)
            int r5 = r5 << 6
            r4 = r4 ^ r5
            if (r4 >= r9) goto L_0x0065
            char r4 = (char) r10
            goto L_0x0066
        L_0x0065:
            char r4 = (char) r4
        L_0x0066:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x006d:
            r7 = 2
        L_0x006e:
            int r3 = r3 + r7
            goto L_0x0012
        L_0x0070:
            int r5 = r4 >> 4
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 57343(0xdfff, float:8.0355E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00e0
            int r4 = r3 + 2
            if (r1 > r4) goto L_0x0095
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004e
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x0092
            r8 = r11
        L_0x0092:
            if (r8 != 0) goto L_0x006d
            goto L_0x004e
        L_0x0095:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00a1
            r15 = r11
            goto L_0x00a2
        L_0x00a1:
            r15 = r8
        L_0x00a2:
            if (r15 != 0) goto L_0x00ad
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x004e
        L_0x00ad:
            byte r4 = r0[r4]
            r15 = r4 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00b4
            r8 = r11
        L_0x00b4:
            if (r8 != 0) goto L_0x00bf
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x006d
        L_0x00bf:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r7
            int r6 = r6 << 6
            r4 = r4 ^ r6
            int r5 = r5 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00d6
        L_0x00cd:
            char r4 = (char) r10
        L_0x00ce:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x00de
        L_0x00d6:
            if (r12 <= r4) goto L_0x00d9
            goto L_0x00dc
        L_0x00d9:
            if (r13 < r4) goto L_0x00dc
            goto L_0x00cd
        L_0x00dc:
            char r4 = (char) r4
            goto L_0x00ce
        L_0x00de:
            r7 = r14
            goto L_0x006e
        L_0x00e0:
            int r4 = r4 >> 3
            if (r4 != r6) goto L_0x0194
            int r4 = r3 + 3
            if (r1 > r4) goto L_0x010f
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004e
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x00fb
            r4 = r11
            goto L_0x00fc
        L_0x00fb:
            r4 = r8
        L_0x00fc:
            if (r4 != 0) goto L_0x0100
            goto L_0x004e
        L_0x0100:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x006d
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x010b
            r8 = r11
        L_0x010b:
            if (r8 != 0) goto L_0x00de
            goto L_0x006d
        L_0x010f:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x011b
            r15 = r11
            goto L_0x011c
        L_0x011b:
            r15 = r8
        L_0x011c:
            if (r15 != 0) goto L_0x0127
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004e
        L_0x0127:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0131
            r7 = r11
            goto L_0x0132
        L_0x0131:
            r7 = r8
        L_0x0132:
            if (r7 != 0) goto L_0x013d
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x006d
        L_0x013d:
            byte r4 = r0[r4]
            r7 = r4 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0144
            r8 = r11
        L_0x0144:
            if (r8 != 0) goto L_0x014e
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x00de
        L_0x014e:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r4 = r4 ^ r7
            int r7 = r15 << 6
            r4 = r4 ^ r7
            int r6 = r6 << 12
            r4 = r4 ^ r6
            int r5 = r5 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0168
        L_0x0160:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0191
        L_0x0168:
            if (r12 <= r4) goto L_0x016b
            goto L_0x016e
        L_0x016b:
            if (r13 < r4) goto L_0x016e
            goto L_0x0160
        L_0x016e:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r5) goto L_0x0173
            goto L_0x0160
        L_0x0173:
            if (r4 == r10) goto L_0x0160
            int r5 = r4 >>> 10
            r6 = 55232(0xd7c0, float:7.7397E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r2.invoke(r5)
            r4 = r4 & 1023(0x3ff, float:1.434E-42)
            r5 = 56320(0xdc00, float:7.8921E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x0191:
            r7 = 4
            goto L_0x006e
        L_0x0194:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0012
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process2Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i3 = i + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = (b2 ^ 3968) ^ (b << 6);
        if (b3 < 128) {
            function1.invoke(valueOf);
        } else {
            function1.invoke(Integer.valueOf(b3));
        }
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process3Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i3 = i + 2;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    z = true;
                }
                return !z ? 1 : 2;
            }
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = bArr[i3];
        if ((b3 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b4 = ((b3 ^ -123008) ^ (b2 << 6)) ^ (b << Ascii.FF);
        if (b4 < 2048) {
            function1.invoke(valueOf);
        } else if (55296 <= b4 && 57343 >= b4) {
            function1.invoke(valueOf);
        } else {
            function1.invoke(Integer.valueOf(b4));
        }
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process4Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i3 = i + 3;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            z = true;
                        }
                        return !z ? 2 : 3;
                    }
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = bArr[i + 2];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b4 = bArr[i3];
        if ((b4 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 3;
        }
        byte b5 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << Ascii.FF)) ^ (b << Ascii.DC2);
        if (b5 > 1114111) {
            function1.invoke(valueOf);
        } else if (55296 <= b5 && 57343 >= b5) {
            function1.invoke(valueOf);
        } else if (b5 < 65536) {
            function1.invoke(valueOf);
        } else {
            function1.invoke(Integer.valueOf(b5));
        }
        return 4;
    }
}
