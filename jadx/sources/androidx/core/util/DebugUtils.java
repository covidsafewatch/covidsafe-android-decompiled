package androidx.core.util;

public class DebugUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = r2.getClass().getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void buildShortClassTag(java.lang.Object r2, java.lang.StringBuilder r3) {
        /*
            if (r2 != 0) goto L_0x0008
            java.lang.String r2 = "null"
            r3.append(r2)
            goto L_0x0041
        L_0x0008:
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getSimpleName()
            if (r0 == 0) goto L_0x0018
            int r1 = r0.length()
            if (r1 > 0) goto L_0x002e
        L_0x0018:
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getName()
            r1 = 46
            int r1 = r0.lastIndexOf(r1)
            if (r1 <= 0) goto L_0x002e
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
        L_0x002e:
            r3.append(r0)
            r0 = 123(0x7b, float:1.72E-43)
            r3.append(r0)
            int r2 = java.lang.System.identityHashCode(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r3.append(r2)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.util.DebugUtils.buildShortClassTag(java.lang.Object, java.lang.StringBuilder):void");
    }

    private DebugUtils() {
    }
}
