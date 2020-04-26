package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;

public final class NewThreadScheduler extends Scheduler {
    private final ThreadFactory threadFactory;

    public NewThreadScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
