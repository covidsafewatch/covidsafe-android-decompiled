package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

public class SchedulerWhen extends Scheduler implements Subscription {
    static final Subscription SUBSCRIBED = new Subscription() {
        public boolean isUnsubscribed() {
            return false;
        }

        public void unsubscribe() {
        }
    };
    static final Subscription UNSUBSCRIBED = Subscriptions.unsubscribed();
    private final Scheduler actualScheduler;
    private final Subscription subscription;
    private final Observer<Observable<Completable>> workerObserver;

    public SchedulerWhen(Func1<Observable<Observable<Completable>>, Completable> func1, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        PublishSubject create = PublishSubject.create();
        this.workerObserver = new SerializedObserver(create);
        this.subscription = func1.call(create.onBackpressureBuffer()).subscribe();
    }

    public void unsubscribe() {
        this.subscription.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.subscription.isUnsubscribed();
    }

    public Scheduler.Worker createWorker() {
        final Scheduler.Worker createWorker = this.actualScheduler.createWorker();
        BufferUntilSubscriber create = BufferUntilSubscriber.create();
        final SerializedObserver serializedObserver = new SerializedObserver(create);
        Observable map = create.map(new Func1<ScheduledAction, Completable>() {
            public Completable call(final ScheduledAction scheduledAction) {
                return Completable.create(new Completable.OnSubscribe() {
                    public void call(CompletableSubscriber completableSubscriber) {
                        completableSubscriber.onSubscribe(scheduledAction);
                        scheduledAction.call(createWorker, completableSubscriber);
                    }
                });
            }
        });
        AnonymousClass2 r3 = new Scheduler.Worker() {
            private final AtomicBoolean unsubscribed = new AtomicBoolean();

            public void unsubscribe() {
                if (this.unsubscribed.compareAndSet(false, true)) {
                    createWorker.unsubscribe();
                    serializedObserver.onCompleted();
                }
            }

            public boolean isUnsubscribed() {
                return this.unsubscribed.get();
            }

            public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
                DelayedAction delayedAction = new DelayedAction(action0, j, timeUnit);
                serializedObserver.onNext(delayedAction);
                return delayedAction;
            }

            public Subscription schedule(Action0 action0) {
                ImmediateAction immediateAction = new ImmediateAction(action0);
                serializedObserver.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.workerObserver.onNext(map);
        return r3;
    }

    static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        /* access modifiers changed from: protected */
        public abstract Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber);

        public ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* access modifiers changed from: private */
        public void call(Scheduler.Worker worker, CompletableSubscriber completableSubscriber) {
            Subscription subscription = (Subscription) get();
            if (subscription != SchedulerWhen.UNSUBSCRIBED && subscription == SchedulerWhen.SUBSCRIBED) {
                Subscription callActual = callActual(worker, completableSubscriber);
                if (!compareAndSet(SchedulerWhen.SUBSCRIBED, callActual)) {
                    callActual.unsubscribe();
                }
            }
        }

        public boolean isUnsubscribed() {
            return ((Subscription) get()).isUnsubscribed();
        }

        public void unsubscribe() {
            Subscription subscription;
            Subscription subscription2 = SchedulerWhen.UNSUBSCRIBED;
            do {
                subscription = (Subscription) get();
                if (subscription == SchedulerWhen.UNSUBSCRIBED) {
                    return;
                }
            } while (!compareAndSet(subscription, subscription2));
            if (subscription != SchedulerWhen.SUBSCRIBED) {
                subscription.unsubscribe();
            }
        }
    }

    static class ImmediateAction extends ScheduledAction {
        private final Action0 action;

        public ImmediateAction(Action0 action0) {
            this.action = action0;
        }

        /* access modifiers changed from: protected */
        public Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber) {
            return worker.schedule(new OnCompletedAction(this.action, completableSubscriber));
        }
    }

    static class DelayedAction extends ScheduledAction {
        private final Action0 action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Action0 action0, long j, TimeUnit timeUnit) {
            this.action = action0;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        /* access modifiers changed from: protected */
        public Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber) {
            return worker.schedule(new OnCompletedAction(this.action, completableSubscriber), this.delayTime, this.unit);
        }
    }

    static class OnCompletedAction implements Action0 {
        private Action0 action;
        private CompletableSubscriber actionCompletable;

        public OnCompletedAction(Action0 action0, CompletableSubscriber completableSubscriber) {
            this.action = action0;
            this.actionCompletable = completableSubscriber;
        }

        public void call() {
            try {
                this.action.call();
            } finally {
                this.actionCompletable.onCompleted();
            }
        }
    }
}
