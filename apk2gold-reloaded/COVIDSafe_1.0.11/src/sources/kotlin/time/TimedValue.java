package kotlin.time;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration", "()D", "D", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: measureTime.kt */
public final class TimedValue<T> {
    private final double duration;
    private final T value;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=T, for r1v0, types: [java.lang.Object] */
    /* renamed from: copy-RFiDyg4$default reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kotlin.time.TimedValue m1009copyRFiDyg4$default(kotlin.time.TimedValue r0, T r1, double r2, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            T r1 = r0.value
        L_0x0006:
            r4 = r4 & 2
            if (r4 == 0) goto L_0x000c
            double r2 = r0.duration
        L_0x000c:
            kotlin.time.TimedValue r0 = r0.m1010copyRFiDyg4(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.TimedValue.m1009copyRFiDyg4$default(kotlin.time.TimedValue, java.lang.Object, double, int, java.lang.Object):kotlin.time.TimedValue");
    }

    public final T component1() {
        return this.value;
    }

    public final double component2() {
        return this.duration;
    }

    /* renamed from: copy-RFiDyg4 reason: not valid java name */
    public final TimedValue<T> m1010copyRFiDyg4(T t, double d) {
        return new TimedValue<>(t, d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (java.lang.Double.compare(r4.duration, r5.duration) == 0) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            if (r4 == r5) goto L_0x001f
            boolean r0 = r5 instanceof kotlin.time.TimedValue
            if (r0 == 0) goto L_0x001d
            kotlin.time.TimedValue r5 = (kotlin.time.TimedValue) r5
            T r0 = r4.value
            T r1 = r5.value
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            double r0 = r4.duration
            double r2 = r5.duration
            int r5 = java.lang.Double.compare(r0, r2)
            if (r5 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            return r5
        L_0x001f:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.TimedValue.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        T t = this.value;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.duration);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TimedValue(value=");
        sb.append(this.value);
        sb.append(", duration=");
        sb.append(Duration.m997toStringimpl(this.duration));
        sb.append(")");
        return sb.toString();
    }

    private TimedValue(T t, double d) {
        this.value = t;
        this.duration = d;
    }

    public /* synthetic */ TimedValue(Object obj, double d, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, d);
    }

    public final double getDuration() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }
}
