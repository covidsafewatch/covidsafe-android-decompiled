package com.atlassian.mobilekit.module.core;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class JobQueue {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public final void enqueue(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public Executor getExecutor() {
        return this.executor;
    }
}
