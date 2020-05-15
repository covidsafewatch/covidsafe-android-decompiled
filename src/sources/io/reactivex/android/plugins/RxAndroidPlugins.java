package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        onInitMainThreadHandler = function;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = onInitMainThreadHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        onMainThreadHandler = function;
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = onMainThreadHandler;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) apply(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return onInitMainThreadHandler;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return onMainThreadHandler;
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler((Function<Callable<Scheduler>, Scheduler>) null);
        setMainThreadSchedulerHandler((Function<Scheduler, Scheduler>) null);
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.reactivex.Scheduler applyRequireNonNull(io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> r0, java.util.concurrent.Callable<io.reactivex.Scheduler> r1) {
        /*
            java.lang.Object r0 = apply(r0, r1)
            io.reactivex.Scheduler r0 = (io.reactivex.Scheduler) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.android.plugins.RxAndroidPlugins.applyRequireNonNull(io.reactivex.functions.Function, java.util.concurrent.Callable):io.reactivex.Scheduler");
    }

    static <T, R> R apply(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }
}
