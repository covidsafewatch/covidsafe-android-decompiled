package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Notification;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class OperatorMaterialize<T> implements Operator<Notification<T>, T> {

    static final class Holder {
        static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();

        Holder() {
        }
    }

    static class ParentSubscriber<T> extends Subscriber<T> {
        private boolean busy;
        private final Subscriber<? super Notification<T>> child;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();
        private volatile Notification<T> terminalNotification;

        ParentSubscriber(Subscriber<? super Notification<T>> subscriber) {
            this.child = subscriber;
        }

        public void onStart() {
            request(0);
        }

        /* access modifiers changed from: 0000 */
        public void requestMore(long j) {
            BackpressureUtils.getAndAddRequest(this.requested, j);
            request(j);
            drain();
        }

        public void onCompleted() {
            this.terminalNotification = Notification.createOnCompleted();
            drain();
        }

        public void onError(Throwable th) {
            this.terminalNotification = Notification.createOnError(th);
            RxJavaHooks.onError(th);
            drain();
        }

        public void onNext(T t) {
            this.child.onNext(Notification.createOnNext(t));
            decrementRequested();
        }

        private void decrementRequested() {
            long j;
            AtomicLong atomicLong = this.requested;
            do {
                j = atomicLong.get();
                if (j == LongCompanionObject.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j - 1));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            if (r6.child.isUnsubscribed() != false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            r1 = r6.terminalNotification;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
            if (r1 == null) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r0.get() <= 0) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r6.terminalNotification = null;
            r6.child.onNext(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
            if (r6.child.isUnsubscribed() != false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
            r6.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
            if (r6.missed != false) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
            r6.busy = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r6.requested;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void drain() {
            /*
                r6 = this;
                monitor-enter(r6)
                boolean r0 = r6.busy     // Catch:{ all -> 0x004b }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r6.missed = r1     // Catch:{ all -> 0x004b }
                monitor-exit(r6)     // Catch:{ all -> 0x004b }
                return
            L_0x000a:
                r6.busy = r1     // Catch:{ all -> 0x004b }
                monitor-exit(r6)     // Catch:{ all -> 0x004b }
                java.util.concurrent.atomic.AtomicLong r0 = r6.requested
            L_0x000f:
                rx.Subscriber<? super rx.Notification<T>> r1 = r6.child
                boolean r1 = r1.isUnsubscribed()
                if (r1 != 0) goto L_0x004a
                rx.Notification<T> r1 = r6.terminalNotification
                if (r1 == 0) goto L_0x003b
                long r2 = r0.get()
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x003b
                r0 = 0
                r6.terminalNotification = r0
                rx.Subscriber<? super rx.Notification<T>> r0 = r6.child
                r0.onNext(r1)
                rx.Subscriber<? super rx.Notification<T>> r0 = r6.child
                boolean r0 = r0.isUnsubscribed()
                if (r0 != 0) goto L_0x003a
                rx.Subscriber<? super rx.Notification<T>> r0 = r6.child
                r0.onCompleted()
            L_0x003a:
                return
            L_0x003b:
                monitor-enter(r6)
                boolean r1 = r6.missed     // Catch:{ all -> 0x0047 }
                if (r1 != 0) goto L_0x0045
                r0 = 0
                r6.busy = r0     // Catch:{ all -> 0x0047 }
                monitor-exit(r6)     // Catch:{ all -> 0x0047 }
                return
            L_0x0045:
                monitor-exit(r6)     // Catch:{ all -> 0x0047 }
                goto L_0x000f
            L_0x0047:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0047 }
                throw r0
            L_0x004a:
                return
            L_0x004b:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x004b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMaterialize.ParentSubscriber.drain():void");
        }
    }

    public static <T> OperatorMaterialize<T> instance() {
        return Holder.INSTANCE;
    }

    OperatorMaterialize() {
    }

    public Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j) {
                if (j > 0) {
                    parentSubscriber.requestMore(j);
                }
            }
        });
        return parentSubscriber;
    }
}
