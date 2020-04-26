package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing> implements Operator<List<T>, T> {
    final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    final int initialCapacity;

    final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        public void onNext(T t) {
            synchronized (this) {
                if (!this.done) {
                    this.chunk.add(t);
                }
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunk = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        public void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.chunk;
                        this.chunk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, (Observer<?>) this.child);
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
            if (r3.done != false) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
            r3.done = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
            rx.exceptions.Exceptions.throwOrReport(r0, (rx.Observer<?>) r3.child);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r3.child.onNext(r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit() {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.done     // Catch:{ all -> 0x0033 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x0007:
                java.util.List<T> r0 = r3.chunk     // Catch:{ all -> 0x0033 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0033 }
                rx.internal.operators.OperatorBufferWithSingleObservable r2 = rx.internal.operators.OperatorBufferWithSingleObservable.this     // Catch:{ all -> 0x0033 }
                int r2 = r2.initialCapacity     // Catch:{ all -> 0x0033 }
                r1.<init>(r2)     // Catch:{ all -> 0x0033 }
                r3.chunk = r1     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                rx.Subscriber<? super java.util.List<T>> r1 = r3.child     // Catch:{ all -> 0x001b }
                r1.onNext(r0)     // Catch:{ all -> 0x001b }
                goto L_0x002f
            L_0x001b:
                r0 = move-exception
                r3.unsubscribe()
                monitor-enter(r3)
                boolean r1 = r3.done     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x0026
                monitor-exit(r3)     // Catch:{ all -> 0x0030 }
                return
            L_0x0026:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x0030 }
                monitor-exit(r3)     // Catch:{ all -> 0x0030 }
                rx.Subscriber<? super java.util.List<T>> r1 = r3.child
                rx.exceptions.Exceptions.throwOrReport(r0, r1)
            L_0x002f:
                return
            L_0x0030:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0030 }
                throw r0
            L_0x0033:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithSingleObservable.BufferingSubscriber.emit():void");
        }
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> func0, int i) {
        this.bufferClosingSelector = func0;
        this.initialCapacity = i;
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> observable, int i) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() {
            public Observable<? extends TClosing> call() {
                return observable;
            }
        };
        this.initialCapacity = i;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        try {
            Observable observable = (Observable) this.bufferClosingSelector.call();
            final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
            AnonymousClass2 r2 = new Subscriber<TClosing>() {
                public void onNext(TClosing tclosing) {
                    bufferingSubscriber.emit();
                }

                public void onError(Throwable th) {
                    bufferingSubscriber.onError(th);
                }

                public void onCompleted() {
                    bufferingSubscriber.onCompleted();
                }
            };
            subscriber.add(r2);
            subscriber.add(bufferingSubscriber);
            observable.unsafeSubscribe(r2);
            return bufferingSubscriber;
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
            return Subscribers.empty();
        }
    }
}
