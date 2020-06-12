package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class OperatorMaterialize<T> implements Observable.Operator<Notification<T>, T> {

    static final class Holder {
        static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();

        Holder() {
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

        /* access modifiers changed from: package-private */
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
                if (j == LongCompanionObject.MAX_VALUE || atomicLong.compareAndSet(j, j - 1)) {
                }
                j = atomicLong.get();
                return;
            } while (atomicLong.compareAndSet(j, j - 1));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            if (r7.child.isUnsubscribed() != false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            r1 = r7.terminalNotification;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
            if (r1 == null) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r0.get() <= 0) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r7.terminalNotification = null;
            r7.child.onNext(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
            if (r7.child.isUnsubscribed() != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
            r7.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
            if (r7.missed != false) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
            r7.busy = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r7.requested;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void drain() {
            /*
                r7 = this;
                monitor-enter(r7)
                boolean r0 = r7.busy     // Catch:{ all -> 0x004b }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r7.missed = r1     // Catch:{ all -> 0x004b }
                monitor-exit(r7)     // Catch:{ all -> 0x004b }
                return
            L_0x000a:
                r7.busy = r1     // Catch:{ all -> 0x004b }
                monitor-exit(r7)     // Catch:{ all -> 0x004b }
                java.util.concurrent.atomic.AtomicLong r0 = r7.requested
            L_0x000f:
                rx.Subscriber<? super rx.Notification<T>> r1 = r7.child
                boolean r1 = r1.isUnsubscribed()
                if (r1 != 0) goto L_0x004a
                rx.Notification<T> r1 = r7.terminalNotification
                if (r1 == 0) goto L_0x003b
                long r2 = r0.get()
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x003b
                r0 = 0
                r7.terminalNotification = r0
                rx.Subscriber<? super rx.Notification<T>> r0 = r7.child
                r0.onNext(r1)
                rx.Subscriber<? super rx.Notification<T>> r0 = r7.child
                boolean r0 = r0.isUnsubscribed()
                if (r0 != 0) goto L_0x003a
                rx.Subscriber<? super rx.Notification<T>> r0 = r7.child
                r0.onCompleted()
            L_0x003a:
                return
            L_0x003b:
                monitor-enter(r7)
                boolean r1 = r7.missed     // Catch:{ all -> 0x0047 }
                if (r1 != 0) goto L_0x0045
                r0 = 0
                r7.busy = r0     // Catch:{ all -> 0x0047 }
                monitor-exit(r7)     // Catch:{ all -> 0x0047 }
                return
            L_0x0045:
                monitor-exit(r7)     // Catch:{ all -> 0x0047 }
                goto L_0x000f
            L_0x0047:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0047 }
                throw r0
            L_0x004a:
                return
            L_0x004b:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x004b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMaterialize.ParentSubscriber.drain():void");
        }
    }
}
