package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

enum DirectExecutor implements Executor {
    INSTANCE;

    public String toString() {
        return "MoreExecutors.directExecutor()";
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
