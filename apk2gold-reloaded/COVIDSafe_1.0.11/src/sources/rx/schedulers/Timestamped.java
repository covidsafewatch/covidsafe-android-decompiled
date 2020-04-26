package rx.schedulers;

public final class Timestamped<T> {
    private final long timestampMillis;
    private final T value;

    public Timestamped(long j, T t) {
        this.value = t;
        this.timestampMillis = j;
    }

    public long getTimestampMillis() {
        return this.timestampMillis;
    }

    public T getValue() {
        return this.value;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r2.equals(r7) == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r7 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r2 = r7 instanceof rx.schedulers.Timestamped
            if (r2 != 0) goto L_0x000d
            return r1
        L_0x000d:
            rx.schedulers.Timestamped r7 = (rx.schedulers.Timestamped) r7
            long r2 = r6.timestampMillis
            long r4 = r7.timestampMillis
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0026
            T r2 = r6.value
            T r7 = r7.value
            if (r2 == r7) goto L_0x0027
            if (r2 == 0) goto L_0x0026
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.schedulers.Timestamped.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long j = this.timestampMillis;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.value;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[]{Long.valueOf(this.timestampMillis), this.value.toString()});
    }
}
