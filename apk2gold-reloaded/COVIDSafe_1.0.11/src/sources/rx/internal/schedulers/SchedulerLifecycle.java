package rx.internal.schedulers;

public interface SchedulerLifecycle {
    void shutdown();

    void start();
}
