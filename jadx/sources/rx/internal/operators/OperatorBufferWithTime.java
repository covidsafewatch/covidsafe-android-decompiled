package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithTime<T> implements Observable.Operator<List<T>, T> {
    final int count;
    final Scheduler scheduler;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    public OperatorBufferWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler2) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.count = i;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(serializedSubscriber, createWorker);
            exactSubscriber.add(createWorker);
            subscriber.add(exactSubscriber);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(serializedSubscriber, createWorker);
        inexactSubscriber.add(createWorker);
        subscriber.add(inexactSubscriber);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }

    final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        boolean done;
        final Scheduler.Worker inner;

        public InexactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            r6 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
            if (r6.hasNext() == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
            r5.child.onNext((java.util.List) r6.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                boolean r0 = r5.done     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r5)     // Catch:{ all -> 0x004f }
                return
            L_0x0007:
                java.util.List<java.util.List<T>> r0 = r5.chunks     // Catch:{ all -> 0x004f }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x004f }
                r1 = 0
            L_0x000e:
                boolean r2 = r0.hasNext()     // Catch:{ all -> 0x004f }
                if (r2 == 0) goto L_0x0035
                java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x004f }
                java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x004f }
                r2.add(r6)     // Catch:{ all -> 0x004f }
                int r3 = r2.size()     // Catch:{ all -> 0x004f }
                rx.internal.operators.OperatorBufferWithTime r4 = rx.internal.operators.OperatorBufferWithTime.this     // Catch:{ all -> 0x004f }
                int r4 = r4.count     // Catch:{ all -> 0x004f }
                if (r3 != r4) goto L_0x000e
                r0.remove()     // Catch:{ all -> 0x004f }
                if (r1 != 0) goto L_0x0031
                java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x004f }
                r1.<init>()     // Catch:{ all -> 0x004f }
            L_0x0031:
                r1.add(r2)     // Catch:{ all -> 0x004f }
                goto L_0x000e
            L_0x0035:
                monitor-exit(r5)     // Catch:{ all -> 0x004f }
                if (r1 == 0) goto L_0x004e
                java.util.Iterator r6 = r1.iterator()
            L_0x003c:
                boolean r0 = r6.hasNext()
                if (r0 == 0) goto L_0x004e
                java.lang.Object r0 = r6.next()
                java.util.List r0 = (java.util.List) r0
                rx.Subscriber<? super java.util.List<T>> r1 = r5.child
                r1.onNext(r0)
                goto L_0x003c
            L_0x004e:
                return
            L_0x004f:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x004f }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.onNext(java.lang.Object):void");
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
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r0, (rx.Observer<?>) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.onCompleted():void");
        }

        /* access modifiers changed from: package-private */
        public void scheduleChunk() {
            this.inner.schedulePeriodically(new Action0() {
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        public void startNewChunk() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.chunks.add(arrayList);
                    this.inner.schedule(new Action0() {
                        public void call() {
                            InexactSubscriber.this.emitChunk(arrayList);
                        }
                    }, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r2.child.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            rx.exceptions.Exceptions.throwOrReport(r3, (rx.Observer<?>) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitChunk(java.util.List<T> r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.done     // Catch:{ all -> 0x002f }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                return
            L_0x0007:
                java.util.List<java.util.List<T>> r0 = r2.chunks     // Catch:{ all -> 0x002f }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002f }
            L_0x000d:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002f }
                if (r1 == 0) goto L_0x0020
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002f }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x002f }
                if (r1 != r3) goto L_0x000d
                r0.remove()     // Catch:{ all -> 0x002f }
                r0 = 1
                goto L_0x0021
            L_0x0020:
                r0 = 0
            L_0x0021:
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                if (r0 == 0) goto L_0x002e
                rx.Subscriber<? super java.util.List<T>> r0 = r2.child     // Catch:{ all -> 0x002a }
                r0.onNext(r3)     // Catch:{ all -> 0x002a }
                goto L_0x002e
            L_0x002a:
                r3 = move-exception
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r3, (rx.Observer<?>) r2)
            L_0x002e:
                return
            L_0x002f:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.emitChunk(java.util.List):void");
        }
    }

    final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk = new ArrayList();
        boolean done;
        final Scheduler.Worker inner;

        public ExactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
            r1.child.onNext(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.done     // Catch:{ all -> 0x002c }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x0007:
                java.util.List<T> r0 = r1.chunk     // Catch:{ all -> 0x002c }
                r0.add(r2)     // Catch:{ all -> 0x002c }
                java.util.List<T> r2 = r1.chunk     // Catch:{ all -> 0x002c }
                int r2 = r2.size()     // Catch:{ all -> 0x002c }
                rx.internal.operators.OperatorBufferWithTime r0 = rx.internal.operators.OperatorBufferWithTime.this     // Catch:{ all -> 0x002c }
                int r0 = r0.count     // Catch:{ all -> 0x002c }
                if (r2 != r0) goto L_0x0022
                java.util.List<T> r2 = r1.chunk     // Catch:{ all -> 0x002c }
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x002c }
                r0.<init>()     // Catch:{ all -> 0x002c }
                r1.chunk = r0     // Catch:{ all -> 0x002c }
                goto L_0x0023
            L_0x0022:
                r2 = 0
            L_0x0023:
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                if (r2 == 0) goto L_0x002b
                rx.Subscriber<? super java.util.List<T>> r0 = r1.child
                r0.onNext(r2)
            L_0x002b:
                return
            L_0x002c:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithTime.ExactSubscriber.onNext(java.lang.Object):void");
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
                this.inner.unsubscribe();
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

        /* access modifiers changed from: package-private */
        public void scheduleExact() {
            this.inner.schedulePeriodically(new Action0() {
                public void call() {
                    ExactSubscriber.this.emit();
                }
            }, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.chunk;
                    this.chunk = new ArrayList();
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, (Observer<?>) this);
                    }
                }
            }
        }
    }
}
