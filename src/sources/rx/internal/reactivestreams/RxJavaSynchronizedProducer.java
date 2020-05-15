package rx.internal.reactivestreams;

import java.util.ArrayList;
import java.util.List;
import rx.Producer;
import rx.Subscription;

public final class RxJavaSynchronizedProducer implements Producer, Subscription {
    private boolean emitting;
    private List<Long> requests;
    private final org.reactivestreams.Subscription subscription;
    private volatile boolean unsubscribed;

    public RxJavaSynchronizedProducer(org.reactivestreams.Subscription subscription2) {
        if (subscription2 != null) {
            this.subscription = subscription2;
            return;
        }
        throw new NullPointerException("subscription");
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r7.subscription.request(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r8 = r7.requests;
        r7.requests = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        if (r8 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        r7.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r8 = r8.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004b, code lost:
        if (r8.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x004d, code lost:
        r9 = r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0059, code lost:
        if (r9.longValue() != 0) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        r7.unsubscribed = true;
        r7.subscription.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
        r7.subscription.request(r9.longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006d, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0073, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0075, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0077, code lost:
        if (r2 == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0079, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r7.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0081, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r8) {
        /*
            r7 = this;
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0085
            boolean r2 = r7.unsubscribed
            if (r2 != 0) goto L_0x0085
            monitor-enter(r7)
            boolean r2 = r7.unsubscribed     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r7)     // Catch:{ all -> 0x0082 }
            return
        L_0x0011:
            boolean r2 = r7.emitting     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x002c
            java.util.List<java.lang.Long> r0 = r7.requests     // Catch:{ all -> 0x0082 }
            if (r0 != 0) goto L_0x0021
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0082 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0082 }
            r7.requests = r0     // Catch:{ all -> 0x0082 }
        L_0x0021:
            java.util.List<java.lang.Long> r0 = r7.requests     // Catch:{ all -> 0x0082 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0082 }
            r0.add(r8)     // Catch:{ all -> 0x0082 }
            monitor-exit(r7)     // Catch:{ all -> 0x0082 }
            return
        L_0x002c:
            r2 = 1
            r7.emitting = r2     // Catch:{ all -> 0x0082 }
            monitor-exit(r7)     // Catch:{ all -> 0x0082 }
            r3 = 0
            org.reactivestreams.Subscription r4 = r7.subscription     // Catch:{ all -> 0x0075 }
            r4.request(r8)     // Catch:{ all -> 0x0075 }
        L_0x0036:
            monitor-enter(r7)     // Catch:{ all -> 0x0075 }
            java.util.List<java.lang.Long> r8 = r7.requests     // Catch:{ all -> 0x006d }
            r9 = 0
            r7.requests = r9     // Catch:{ all -> 0x006d }
            if (r8 != 0) goto L_0x0042
            r7.emitting = r3     // Catch:{ all -> 0x006d }
            monitor-exit(r7)     // Catch:{ all -> 0x0073 }
            return
        L_0x0042:
            monitor-exit(r7)     // Catch:{ all -> 0x006d }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0075 }
        L_0x0047:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0075 }
            if (r9 == 0) goto L_0x0036
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0075 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x0075 }
            long r4 = r9.longValue()     // Catch:{ all -> 0x0075 }
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x0063
            r7.unsubscribed = r2     // Catch:{ all -> 0x0075 }
            org.reactivestreams.Subscription r8 = r7.subscription     // Catch:{ all -> 0x0075 }
            r8.cancel()     // Catch:{ all -> 0x0075 }
            return
        L_0x0063:
            org.reactivestreams.Subscription r4 = r7.subscription     // Catch:{ all -> 0x0075 }
            long r5 = r9.longValue()     // Catch:{ all -> 0x0075 }
            r4.request(r5)     // Catch:{ all -> 0x0075 }
            goto L_0x0047
        L_0x006d:
            r8 = move-exception
            r2 = r3
        L_0x006f:
            monitor-exit(r7)     // Catch:{ all -> 0x0073 }
            throw r8     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r8 = move-exception
            goto L_0x0077
        L_0x0073:
            r8 = move-exception
            goto L_0x006f
        L_0x0075:
            r8 = move-exception
            r2 = r3
        L_0x0077:
            if (r2 != 0) goto L_0x0081
            monitor-enter(r7)
            r7.emitting = r3     // Catch:{ all -> 0x007e }
            monitor-exit(r7)     // Catch:{ all -> 0x007e }
            goto L_0x0081
        L_0x007e:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x007e }
            throw r8
        L_0x0081:
            throw r8
        L_0x0082:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0082 }
            throw r8
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.reactivestreams.RxJavaSynchronizedProducer.request(long):void");
    }

    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.emitting) {
                        ArrayList arrayList = new ArrayList(4);
                        this.requests = arrayList;
                        arrayList.add(0L);
                        return;
                    }
                    this.emitting = true;
                    this.unsubscribed = true;
                    this.subscription.cancel();
                }
            }
        }
    }
}
