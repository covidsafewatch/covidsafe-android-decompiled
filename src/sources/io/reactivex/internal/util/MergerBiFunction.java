package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> comparator2) {
        this.comparator = comparator2;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061 A[ADDED_TO_REGION, EDGE_INSN: B:34:0x0061->B:23:0x0061 ?: BREAK  , SYNTHETIC] */
    public java.util.List<T> apply(java.util.List<T> r6, java.util.List<T> r7) throws java.lang.Exception {
        /*
            r5 = this;
            int r0 = r6.size()
            int r1 = r7.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L_0x0011
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L_0x0011:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r6.hasNext()
            r2 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r6.next()
            goto L_0x002b
        L_0x002a:
            r0 = r2
        L_0x002b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r7.next()
            goto L_0x0037
        L_0x0036:
            r3 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x0061
            if (r3 == 0) goto L_0x0061
            java.util.Comparator<? super T> r4 = r5.comparator
            int r4 = r4.compare(r0, r3)
            if (r4 >= 0) goto L_0x0053
            r1.add(r0)
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r6.next()
            goto L_0x0037
        L_0x0051:
            r0 = r2
            goto L_0x0037
        L_0x0053:
            r1.add(r3)
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r7.next()
            goto L_0x0037
        L_0x0061:
            if (r0 == 0) goto L_0x0074
            r1.add(r0)
        L_0x0066:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0085
            java.lang.Object r7 = r6.next()
            r1.add(r7)
            goto L_0x0066
        L_0x0074:
            r1.add(r3)
        L_0x0077:
            boolean r6 = r7.hasNext()
            if (r6 == 0) goto L_0x0085
            java.lang.Object r6 = r7.next()
            r1.add(r6)
            goto L_0x0077
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.MergerBiFunction.apply(java.util.List, java.util.List):java.util.List");
    }
}
