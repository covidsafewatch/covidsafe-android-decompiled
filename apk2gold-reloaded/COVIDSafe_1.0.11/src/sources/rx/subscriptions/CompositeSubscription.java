package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
    }

    public CompositeSubscription(Subscription... subscriptionArr) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptionArr));
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void add(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    if (!this.unsubscribed) {
                        if (this.subscriptions == null) {
                            this.subscriptions = new HashSet(4);
                        }
                        this.subscriptions.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public void addAll(Subscription... subscriptionArr) {
        int i = 0;
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(subscriptionArr.length);
                    }
                    int length = subscriptionArr.length;
                    while (i < length) {
                        Subscription subscription = subscriptionArr[i];
                        if (!subscription.isUnsubscribed()) {
                            this.subscriptions.add(subscription);
                        }
                        i++;
                    }
                    return;
                }
            }
        }
        int length2 = subscriptionArr.length;
        while (i < length2) {
            subscriptionArr[i].unsubscribe();
            i++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r0 == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r2.unsubscribe();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.Subscription r2) {
        /*
            r1 = this;
            boolean r0 = r1.unsubscribed
            if (r0 != 0) goto L_0x0020
            monitor-enter(r1)
            boolean r0 = r1.unsubscribed     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x001b
            java.util.Set<rx.Subscription> r0 = r1.subscriptions     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x000e
            goto L_0x001b
        L_0x000e:
            java.util.Set<rx.Subscription> r0 = r1.subscriptions     // Catch:{ all -> 0x001d }
            boolean r0 = r0.remove(r2)     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0020
            r2.unsubscribe()
            goto L_0x0020
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            return
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r2
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.remove(rx.Subscription):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        unsubscribeFromAll(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r2 = this;
            boolean r0 = r2.unsubscribed
            if (r0 != 0) goto L_0x001d
            monitor-enter(r2)
            boolean r0 = r2.unsubscribed     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0018
            java.util.Set<rx.Subscription> r0 = r2.subscriptions     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            java.util.Set<rx.Subscription> r0 = r2.subscriptions     // Catch:{ all -> 0x001a }
            r1 = 0
            r2.subscriptions = r1     // Catch:{ all -> 0x001a }
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            unsubscribeFromAll(r0)
            goto L_0x001d
        L_0x0018:
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            return
        L_0x001a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            throw r0
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.clear():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        unsubscribeFromAll(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unsubscribe() {
        /*
            r2 = this;
            boolean r0 = r2.unsubscribed
            if (r0 != 0) goto L_0x001b
            monitor-enter(r2)
            boolean r0 = r2.unsubscribed     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            return
        L_0x000b:
            r0 = 1
            r2.unsubscribed = r0     // Catch:{ all -> 0x0018 }
            java.util.Set<rx.Subscription> r0 = r2.subscriptions     // Catch:{ all -> 0x0018 }
            r1 = 0
            r2.subscriptions = r1     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            unsubscribeFromAll(r0)
            goto L_0x001b
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r0
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.unsubscribe():void");
    }

    private static void unsubscribeFromAll(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    public boolean hasSubscriptions() {
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && this.subscriptions != null && !this.subscriptions.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}
