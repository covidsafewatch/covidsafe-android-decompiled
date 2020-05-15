package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            lazySet(FINISHED);
            RxJavaPlugins.onError(th);
        }
    }
}
