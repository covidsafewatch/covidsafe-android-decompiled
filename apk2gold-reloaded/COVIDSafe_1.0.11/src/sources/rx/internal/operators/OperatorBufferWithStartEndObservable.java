package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class OperatorBufferWithStartEndObservable<T, TOpening, TClosing> implements Operator<List<T>, T> {
    final Func1<? super TOpening, ? extends Observable<? extends TClosing>> bufferClosing;
    final Observable<? extends TOpening> bufferOpening;

    final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        final CompositeSubscription closingSubscriptions;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.closingSubscriptions = compositeSubscription;
            add(compositeSubscription);
        }

        public void onNext(T t) {
            synchronized (this) {
                for (List add : this.chunks) {
                    add.add(t);
                }
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunks.clear();
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r0 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            if (r0.hasNext() == false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            r3.child.onNext((java.util.List) r0.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            r3.child.onCompleted();
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r3 = this;
                monitor-enter(r3)     // Catch:{ all -> 0x0039 }
                boolean r0 = r3.done     // Catch:{ all -> 0x0036 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0036 }
                return
            L_0x0007:
                r0 = 1
                r3.done = r0     // Catch:{ all -> 0x0036 }
                java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0036 }
                java.util.List<java.util.List<T>> r1 = r3.chunks     // Catch:{ all -> 0x0036 }
                r0.<init>(r1)     // Catch:{ all -> 0x0036 }
                java.util.List<java.util.List<T>> r1 = r3.chunks     // Catch:{ all -> 0x0036 }
                r1.clear()     // Catch:{ all -> 0x0036 }
                monitor-exit(r3)     // Catch:{ all -> 0x0036 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0039 }
            L_0x001b:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x002d
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0039 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0039 }
                rx.Subscriber<? super java.util.List<T>> r2 = r3.child     // Catch:{ all -> 0x0039 }
                r2.onNext(r1)     // Catch:{ all -> 0x0039 }
                goto L_0x001b
            L_0x002d:
                rx.Subscriber<? super java.util.List<T>> r0 = r3.child
                r0.onCompleted()
                r3.unsubscribe()
                return
            L_0x0036:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0036 }
                throw r0     // Catch:{ all -> 0x0039 }
            L_0x0039:
                r0 = move-exception
                rx.Subscriber<? super java.util.List<T>> r1 = r3.child
                rx.exceptions.Exceptions.throwOrReport(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.onCompleted():void");
        }

        /* access modifiers changed from: 0000 */
        public void startBuffer(TOpening topening) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.chunks.add(arrayList);
                    try {
                        Observable observable = (Observable) OperatorBufferWithStartEndObservable.this.bufferClosing.call(topening);
                        AnonymousClass1 r1 = new Subscriber<TClosing>() {
                            public void onNext(TClosing tclosing) {
                                BufferingSubscriber.this.closingSubscriptions.remove(this);
                                BufferingSubscriber.this.endBuffer(arrayList);
                            }

                            public void onError(Throwable th) {
                                BufferingSubscriber.this.onError(th);
                            }

                            public void onCompleted() {
                                BufferingSubscriber.this.closingSubscriptions.remove(this);
                                BufferingSubscriber.this.endBuffer(arrayList);
                            }
                        };
                        this.closingSubscriptions.add(r1);
                        observable.unsafeSubscribe(r1);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, (Observer<?>) this);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r1 == false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            r2.child.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void endBuffer(java.util.List<T> r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.done     // Catch:{ all -> 0x002a }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                return
            L_0x0007:
                java.util.List<java.util.List<T>> r0 = r2.chunks     // Catch:{ all -> 0x002a }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002a }
            L_0x000d:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002a }
                if (r1 == 0) goto L_0x0020
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002a }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x002a }
                if (r1 != r3) goto L_0x000d
                r1 = 1
                r0.remove()     // Catch:{ all -> 0x002a }
                goto L_0x0021
            L_0x0020:
                r1 = 0
            L_0x0021:
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                if (r1 == 0) goto L_0x0029
                rx.Subscriber<? super java.util.List<T>> r0 = r2.child
                r0.onNext(r3)
            L_0x0029:
                return
            L_0x002a:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.endBuffer(java.util.List):void");
        }
    }

    public OperatorBufferWithStartEndObservable(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        this.bufferOpening = observable;
        this.bufferClosing = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
        AnonymousClass1 r1 = new Subscriber<TOpening>() {
            public void onNext(TOpening topening) {
                bufferingSubscriber.startBuffer(topening);
            }

            public void onError(Throwable th) {
                bufferingSubscriber.onError(th);
            }

            public void onCompleted() {
                bufferingSubscriber.onCompleted();
            }
        };
        subscriber.add(r1);
        subscriber.add(bufferingSubscriber);
        this.bufferOpening.unsafeSubscribe(r1);
        return bufferingSubscriber;
    }
}
