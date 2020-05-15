package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.subscriptions.SequentialSubscription;

public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(Scheduler.Worker worker, Action0 action0, long j, long j2, TimeUnit timeUnit, NowNanoSupplier nowNanoSupplier) {
        long j3 = j;
        TimeUnit timeUnit2 = timeUnit;
        final long nanos = timeUnit2.toNanos(j2);
        final long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
        final long nanos2 = timeUnit2.toNanos(j3) + nowNanos;
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        final Action0 action02 = action0;
        final SequentialSubscription sequentialSubscription3 = sequentialSubscription2;
        final NowNanoSupplier nowNanoSupplier2 = nowNanoSupplier;
        SequentialSubscription sequentialSubscription4 = sequentialSubscription2;
        AnonymousClass1 r15 = r3;
        final Scheduler.Worker worker2 = worker;
        AnonymousClass1 r3 = new Action0() {
            long count;
            long lastNowNanos = nowNanos;
            long startInNanos = nanos2;

            public void call() {
                long j;
                action02.call();
                if (!sequentialSubscription3.isUnsubscribed()) {
                    NowNanoSupplier nowNanoSupplier = nowNanoSupplier2;
                    long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker2.now());
                    long j2 = this.lastNowNanos;
                    if (SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS + nowNanos < j2 || nowNanos >= j2 + nanos + SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS) {
                        long j3 = nanos;
                        long j4 = nowNanos + j3;
                        long j5 = this.count + 1;
                        this.count = j5;
                        this.startInNanos = j4 - (j3 * j5);
                        j = j4;
                    } else {
                        long j6 = this.startInNanos;
                        long j7 = this.count + 1;
                        this.count = j7;
                        j = j6 + (j7 * nanos);
                    }
                    this.lastNowNanos = nowNanos;
                    sequentialSubscription3.replace(worker2.schedule(this, j - nowNanos, TimeUnit.NANOSECONDS));
                }
            }
        };
        sequentialSubscription.replace(worker.schedule(r15, j3, timeUnit2));
        return sequentialSubscription4;
    }
}
