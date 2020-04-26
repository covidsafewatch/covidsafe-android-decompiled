package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.subjects.Subject;

public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {
    final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
    final Object guard;
    Subscription guardedSubscription;
    final Observable<? extends T> source;
    final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
    Subscriber<T> subscription;
    final List<Subscriber<? super R>> waitingForConnect;

    public OperatorMulticast(Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        this(new Object(), new AtomicReference(), new ArrayList(), observable, func0);
    }

    private OperatorMulticast(final Object obj, final AtomicReference<Subject<? super T, ? extends R>> atomicReference, final List<Subscriber<? super R>> list, Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        super(new OnSubscribe<R>() {
            public void call(Subscriber<? super R> subscriber) {
                synchronized (obj) {
                    if (atomicReference.get() == null) {
                        list.add(subscriber);
                    } else {
                        ((Subject) atomicReference.get()).unsafeSubscribe(subscriber);
                    }
                }
            }
        });
        this.guard = obj;
        this.connectedSubject = atomicReference;
        this.waitingForConnect = list;
        this.source = observable;
        this.subjectFactory = func0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        r6.call(r5.guardedSubscription);
        r6 = r5.guard;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = r5.subscription;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (r0 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        r5.source.subscribe(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(rx.functions.Action1<? super rx.Subscription> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.guard
            monitor-enter(r0)
            rx.Subscriber<T> r1 = r5.subscription     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x000e
            rx.Subscription r1 = r5.guardedSubscription     // Catch:{ all -> 0x0071 }
            r6.call(r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x000e:
            rx.functions.Func0<? extends rx.subjects.Subject<? super T, ? extends R>> r1 = r5.subjectFactory     // Catch:{ all -> 0x0071 }
            java.lang.Object r1 = r1.call()     // Catch:{ all -> 0x0071 }
            rx.subjects.Subject r1 = (rx.subjects.Subject) r1     // Catch:{ all -> 0x0071 }
            rx.Subscriber r2 = rx.observers.Subscribers.from(r1)     // Catch:{ all -> 0x0071 }
            r5.subscription = r2     // Catch:{ all -> 0x0071 }
            java.util.concurrent.atomic.AtomicReference r2 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x0071 }
            r2.<init>()     // Catch:{ all -> 0x0071 }
            rx.internal.operators.OperatorMulticast$2 r3 = new rx.internal.operators.OperatorMulticast$2     // Catch:{ all -> 0x0071 }
            r3.<init>(r2)     // Catch:{ all -> 0x0071 }
            rx.Subscription r3 = rx.subscriptions.Subscriptions.create(r3)     // Catch:{ all -> 0x0071 }
            r2.set(r3)     // Catch:{ all -> 0x0071 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0071 }
            rx.Subscription r2 = (rx.Subscription) r2     // Catch:{ all -> 0x0071 }
            r5.guardedSubscription = r2     // Catch:{ all -> 0x0071 }
            java.util.List<rx.Subscriber<? super R>> r2 = r5.waitingForConnect     // Catch:{ all -> 0x0071 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0071 }
        L_0x003b:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0071 }
            rx.Subscriber r3 = (rx.Subscriber) r3     // Catch:{ all -> 0x0071 }
            rx.internal.operators.OperatorMulticast$3 r4 = new rx.internal.operators.OperatorMulticast$3     // Catch:{ all -> 0x0071 }
            r4.<init>(r3, r3)     // Catch:{ all -> 0x0071 }
            r1.unsafeSubscribe(r4)     // Catch:{ all -> 0x0071 }
            goto L_0x003b
        L_0x0050:
            java.util.List<rx.Subscriber<? super R>> r2 = r5.waitingForConnect     // Catch:{ all -> 0x0071 }
            r2.clear()     // Catch:{ all -> 0x0071 }
            java.util.concurrent.atomic.AtomicReference<rx.subjects.Subject<? super T, ? extends R>> r2 = r5.connectedSubject     // Catch:{ all -> 0x0071 }
            r2.set(r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            rx.Subscription r0 = r5.guardedSubscription
            r6.call(r0)
            java.lang.Object r6 = r5.guard
            monitor-enter(r6)
            rx.Subscriber<T> r0 = r5.subscription     // Catch:{ all -> 0x006e }
            monitor-exit(r6)     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x006d
            rx.Observable<? extends T> r6 = r5.source
            r6.subscribe(r0)
        L_0x006d:
            return
        L_0x006e:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006e }
            throw r0
        L_0x0071:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMulticast.connect(rx.functions.Action1):void");
    }
}
