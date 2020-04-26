package okhttp3.internal.platform.android;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"MAX_LOG_LENGTH", "", "androidLog", "", "level", "message", "", "t", "", "okhttp"}, k = 2, mv = {1, 1, 16})
/* compiled from: util.kt */
public final class UtilKt {
    private static final int MAX_LOG_LENGTH = 4000;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
        r7 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void androidLog(int r7, java.lang.String r8, java.lang.Throwable r9) {
        /*
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            r0 = 5
            if (r7 == r0) goto L_0x0009
            r0 = 3
        L_0x0009:
            if (r9 == 0) goto L_0x0023
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            java.lang.String r8 = "\n"
            r7.append(r8)
            java.lang.String r8 = android.util.Log.getStackTraceString(r9)
            r7.append(r8)
            java.lang.String r8 = r7.toString()
        L_0x0023:
            r7 = 0
            int r9 = r8.length()
        L_0x0028:
            if (r7 >= r9) goto L_0x0061
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 10
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r7
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r1, (char) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            r2 = -1
            if (r1 == r2) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = r9
        L_0x003c:
            int r2 = r7 + 4000
            int r2 = java.lang.Math.min(r1, r2)
            if (r8 == 0) goto L_0x0059
            java.lang.String r7 = r8.substring(r7, r2)
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r3)
            java.lang.String r3 = "OkHttp"
            android.util.Log.println(r0, r3, r7)
            if (r2 < r1) goto L_0x0057
            int r7 = r2 + 1
            goto L_0x0028
        L_0x0057:
            r7 = r2
            goto L_0x003c
        L_0x0059:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r8)
            throw r7
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.android.UtilKt.androidLog(int, java.lang.String, java.lang.Throwable):void");
    }
}
