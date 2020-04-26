package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler.Worker;

public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int i, Worker worker);
    }

    void createWorkers(int i, WorkerCallback workerCallback);
}
