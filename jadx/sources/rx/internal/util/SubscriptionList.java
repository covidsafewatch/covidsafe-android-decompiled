package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class SubscriptionList implements Subscription {
    private List<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public SubscriptionList() {
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.subscriptions = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.subscriptions = linkedList;
        linkedList.add(subscription);
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void add(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    if (!this.unsubscribed) {
                        List list = this.subscriptions;
                        if (list == null) {
                            list = new LinkedList();
                            this.subscriptions = list;
                        }
                        list.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r3.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.Subscription r3) {
        /*
            r2 = this;
            boolean r0 = r2.unsubscribed
            if (r0 != 0) goto L_0x001e
            monitor-enter(r2)
            java.util.List<rx.Subscription> r0 = r2.subscriptions     // Catch:{ all -> 0x001b }
            boolean r1 = r2.unsubscribed     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0019
            if (r0 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r0 = r0.remove(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            r3.unsubscribe()
            goto L_0x001e
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r3
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.SubscriptionList.remove(rx.Subscription):void");
    }

    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    this.unsubscribed = true;
                    List<Subscription> list = this.subscriptions;
                    this.subscriptions = null;
                    unsubscribeFromAll(list);
                }
            }
        }
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

    public void clear() {
        List<Subscription> list;
        if (!this.unsubscribed) {
            synchronized (this) {
                list = this.subscriptions;
                this.subscriptions = null;
            }
            unsubscribeFromAll(list);
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
