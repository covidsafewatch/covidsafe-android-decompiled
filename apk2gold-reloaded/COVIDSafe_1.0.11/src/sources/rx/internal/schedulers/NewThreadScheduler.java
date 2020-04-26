package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;
import rx.Scheduler.Worker;

public final class NewThreadScheduler extends Scheduler {
    private final ThreadFactory threadFactory;

    public NewThreadScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
