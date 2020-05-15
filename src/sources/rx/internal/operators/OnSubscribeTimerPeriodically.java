package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

public final class OnSubscribeTimerPeriodically implements Observable.OnSubscribe<Long> {
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public OnSubscribeTimerPeriodically(long j, long j2, TimeUnit timeUnit, Scheduler scheduler2) {
        this.initialDelay = j;
        this.period = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void call(final Subscriber<? super Long> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        createWorker.schedulePeriodically(new Action0() {
            long counter;

            public void call() {
                try {
                    Subscriber subscriber = subscriber;
                    long j = this.counter;
                    this.counter = 1 + j;
                    subscriber.onNext(Long.valueOf(j));
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                    throw th;
                }
            }
        }, this.initialDelay, this.period, this.unit);
    }
}
