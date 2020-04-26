package io.reactivex.schedulers;

public interface SchedulerRunnableIntrospection {
    Runnable getWrappedRunnable();
}
