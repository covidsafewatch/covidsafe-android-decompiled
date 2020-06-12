package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;

public final class OperatorWindowWithObservable<T, U> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Observable<U> other;

    public OperatorWindowWithObservable(Observable<U> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber);
        BoundarySubscriber boundarySubscriber = new BoundarySubscriber(sourceSubscriber);
        subscriber.add(sourceSubscriber);
        subscriber.add(boundarySubscriber);
        sourceSubscriber.replaceWindow();
        this.other.unsafeSubscribe(boundarySubscriber);
        return sourceSubscriber;
    }

    static final class SourceSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        Observer<T> consumer;
        boolean emitting;
        final Object guard = new Object();
        Observable<T> producer;
        List<Object> queue;

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber) {
            this.child = new SerializedSubscriber(subscriber);
        }

        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            drain(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (r0 == false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            emitValue(r7);
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r5 = r6.queue;
            r6.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
            if (r5 != null) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0041, code lost:
            if (r6.child.isUnsubscribed() == false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0043, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0045, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0048, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0049, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x004d, code lost:
            r1 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x004f, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0050, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            throw r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0053, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0055, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0057, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0058, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0059, code lost:
            if (r3 == false) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x005d, code lost:
            monitor-enter(r6.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0065, code lost:
            throw r7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                boolean r1 = r6.emitting     // Catch:{ all -> 0x0066 }
                if (r1 == 0) goto L_0x0019
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0066 }
                if (r1 != 0) goto L_0x0012
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0066 }
                r1.<init>()     // Catch:{ all -> 0x0066 }
                r6.queue = r1     // Catch:{ all -> 0x0066 }
            L_0x0012:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0066 }
                r1.add(r7)     // Catch:{ all -> 0x0066 }
                monitor-exit(r0)     // Catch:{ all -> 0x0066 }
                return
            L_0x0019:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0066 }
                r2 = 0
                r6.queue = r2     // Catch:{ all -> 0x0066 }
                r3 = 1
                r6.emitting = r3     // Catch:{ all -> 0x0066 }
                monitor-exit(r0)     // Catch:{ all -> 0x0066 }
                r0 = 1
            L_0x0023:
                r4 = 0
                r6.drain(r1)     // Catch:{ all -> 0x0057 }
                if (r0 == 0) goto L_0x002d
                r6.emitValue(r7)     // Catch:{ all -> 0x0057 }
                r0 = 0
            L_0x002d:
                java.lang.Object r1 = r6.guard     // Catch:{ all -> 0x0057 }
                monitor-enter(r1)     // Catch:{ all -> 0x0057 }
                java.util.List<java.lang.Object> r5 = r6.queue     // Catch:{ all -> 0x004f }
                r6.queue = r2     // Catch:{ all -> 0x004f }
                if (r5 != 0) goto L_0x003a
                r6.emitting = r4     // Catch:{ all -> 0x004f }
                monitor-exit(r1)     // Catch:{ all -> 0x0055 }
                return
            L_0x003a:
                monitor-exit(r1)     // Catch:{ all -> 0x004f }
                rx.Subscriber<? super rx.Observable<T>> r1 = r6.child     // Catch:{ all -> 0x0057 }
                boolean r1 = r1.isUnsubscribed()     // Catch:{ all -> 0x0057 }
                if (r1 == 0) goto L_0x004d
                java.lang.Object r1 = r6.guard
                monitor-enter(r1)
                r6.emitting = r4     // Catch:{ all -> 0x004a }
                monitor-exit(r1)     // Catch:{ all -> 0x004a }
                return
            L_0x004a:
                r7 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x004a }
                throw r7
            L_0x004d:
                r1 = r5
                goto L_0x0023
            L_0x004f:
                r7 = move-exception
                r3 = 0
            L_0x0051:
                monitor-exit(r1)     // Catch:{ all -> 0x0055 }
                throw r7     // Catch:{ all -> 0x0053 }
            L_0x0053:
                r7 = move-exception
                goto L_0x0059
            L_0x0055:
                r7 = move-exception
                goto L_0x0051
            L_0x0057:
                r7 = move-exception
                r3 = 0
            L_0x0059:
                if (r3 != 0) goto L_0x0065
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                r6.emitting = r4     // Catch:{ all -> 0x0062 }
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                goto L_0x0065
            L_0x0062:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                throw r7
            L_0x0065:
                throw r7
            L_0x0066:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0066 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithObservable.SourceSubscriber.onNext(java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        public void drain(List<Object> list) {
            if (list != null) {
                for (Object next : list) {
                    if (next == OperatorWindowWithObservable.NEXT_SUBJECT) {
                        replaceSubject();
                    } else if (NotificationLite.isError(next)) {
                        error(NotificationLite.getError(next));
                        return;
                    } else if (NotificationLite.isCompleted(next)) {
                        complete();
                        return;
                    } else {
                        emitValue(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void replaceSubject() {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        /* access modifiers changed from: package-private */
        public void createNewWindow() {
            UnicastSubject create = UnicastSubject.create();
            this.consumer = create;
            this.producer = create;
        }

        /* access modifiers changed from: package-private */
        public void emitValue(T t) {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onNext(t);
            }
        }

        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(NotificationLite.error(th));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(th);
            }
        }

        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(NotificationLite.completed());
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                this.emitting = true;
                try {
                    drain(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            drain(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
            if (r0 == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            replaceSubject();
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r5 = r6.queue;
            r6.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            if (r5 != null) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0043, code lost:
            if (r6.child.isUnsubscribed() == false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0045, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0047, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x004a, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x004b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x004f, code lost:
            r1 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0051, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0052, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0055, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0057, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0059, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x005a, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x005b, code lost:
            if (r3 == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x005f, code lost:
            monitor-enter(r6.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0067, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replaceWindow() {
            /*
                r6 = this;
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                boolean r1 = r6.emitting     // Catch:{ all -> 0x0068 }
                if (r1 == 0) goto L_0x001b
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0068 }
                if (r1 != 0) goto L_0x0012
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0068 }
                r1.<init>()     // Catch:{ all -> 0x0068 }
                r6.queue = r1     // Catch:{ all -> 0x0068 }
            L_0x0012:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0068 }
                java.lang.Object r2 = rx.internal.operators.OperatorWindowWithObservable.NEXT_SUBJECT     // Catch:{ all -> 0x0068 }
                r1.add(r2)     // Catch:{ all -> 0x0068 }
                monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                return
            L_0x001b:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0068 }
                r2 = 0
                r6.queue = r2     // Catch:{ all -> 0x0068 }
                r3 = 1
                r6.emitting = r3     // Catch:{ all -> 0x0068 }
                monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                r0 = 1
            L_0x0025:
                r4 = 0
                r6.drain(r1)     // Catch:{ all -> 0x0059 }
                if (r0 == 0) goto L_0x002f
                r6.replaceSubject()     // Catch:{ all -> 0x0059 }
                r0 = 0
            L_0x002f:
                java.lang.Object r1 = r6.guard     // Catch:{ all -> 0x0059 }
                monitor-enter(r1)     // Catch:{ all -> 0x0059 }
                java.util.List<java.lang.Object> r5 = r6.queue     // Catch:{ all -> 0x0051 }
                r6.queue = r2     // Catch:{ all -> 0x0051 }
                if (r5 != 0) goto L_0x003c
                r6.emitting = r4     // Catch:{ all -> 0x0051 }
                monitor-exit(r1)     // Catch:{ all -> 0x0057 }
                return
            L_0x003c:
                monitor-exit(r1)     // Catch:{ all -> 0x0051 }
                rx.Subscriber<? super rx.Observable<T>> r1 = r6.child     // Catch:{ all -> 0x0059 }
                boolean r1 = r1.isUnsubscribed()     // Catch:{ all -> 0x0059 }
                if (r1 == 0) goto L_0x004f
                java.lang.Object r1 = r6.guard
                monitor-enter(r1)
                r6.emitting = r4     // Catch:{ all -> 0x004c }
                monitor-exit(r1)     // Catch:{ all -> 0x004c }
                return
            L_0x004c:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x004c }
                throw r0
            L_0x004f:
                r1 = r5
                goto L_0x0025
            L_0x0051:
                r0 = move-exception
                r3 = 0
            L_0x0053:
                monitor-exit(r1)     // Catch:{ all -> 0x0057 }
                throw r0     // Catch:{ all -> 0x0055 }
            L_0x0055:
                r0 = move-exception
                goto L_0x005b
            L_0x0057:
                r0 = move-exception
                goto L_0x0053
            L_0x0059:
                r0 = move-exception
                r3 = 0
            L_0x005b:
                if (r3 != 0) goto L_0x0067
                java.lang.Object r1 = r6.guard
                monitor-enter(r1)
                r6.emitting = r4     // Catch:{ all -> 0x0064 }
                monitor-exit(r1)     // Catch:{ all -> 0x0064 }
                goto L_0x0067
            L_0x0064:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0064 }
                throw r0
            L_0x0067:
                throw r0
            L_0x0068:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithObservable.SourceSubscriber.replaceWindow():void");
        }

        /* access modifiers changed from: package-private */
        public void complete() {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        /* access modifiers changed from: package-private */
        public void error(Throwable th) {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }
    }

    static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        final SourceSubscriber<T> sub;

        public BoundarySubscriber(SourceSubscriber<T> sourceSubscriber) {
            this.sub = sourceSubscriber;
        }

        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        public void onNext(U u) {
            this.sub.replaceWindow();
        }

        public void onError(Throwable th) {
            this.sub.onError(th);
        }

        public void onCompleted() {
            this.sub.onCompleted();
        }
    }
}
