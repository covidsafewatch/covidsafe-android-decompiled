package rx.internal.schedulers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.util.PlatformDependent;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public class NewThreadWorker extends Scheduler.Worker implements Subscription {
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> EXECUTORS = new ConcurrentHashMap<>();
    private static final String FREQUENCY_KEY = "rx.scheduler.jdk6.purge-frequency-millis";
    private static final AtomicReference<ScheduledExecutorService> PURGE = new AtomicReference<>();
    private static final String PURGE_FORCE_KEY = "rx.scheduler.jdk6.purge-force";
    public static final int PURGE_FREQUENCY = Integer.getInteger(FREQUENCY_KEY, 1000).intValue();
    private static final String PURGE_THREAD_PREFIX = "RxSchedulerPurge-";
    private static final Object SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED = new Object();
    private static final boolean SHOULD_TRY_ENABLE_CANCEL_POLICY;
    private static volatile Object cachedSetRemoveOnCancelPolicyMethod;
    private final ScheduledExecutorService executor;
    volatile boolean isUnsubscribed;

    static {
        boolean z = Boolean.getBoolean(PURGE_FORCE_KEY);
        int androidApiVersion = PlatformDependent.getAndroidApiVersion();
        SHOULD_TRY_ENABLE_CANCEL_POLICY = !z && (androidApiVersion == 0 || androidApiVersion >= 21);
    }

    public static void registerExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (PURGE.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory(PURGE_THREAD_PREFIX));
            if (PURGE.compareAndSet((Object) null, newScheduledThreadPool)) {
                AnonymousClass1 r4 = new Runnable() {
                    public void run() {
                        NewThreadWorker.purgeExecutors();
                    }
                };
                int i = PURGE_FREQUENCY;
                newScheduledThreadPool.scheduleAtFixedRate(r4, (long) i, (long) i, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        EXECUTORS.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void deregisterExecutor(ScheduledExecutorService scheduledExecutorService) {
        EXECUTORS.remove(scheduledExecutorService);
    }

    static void purgeExecutors() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = EXECUTORS.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaHooks.onError(th);
        }
    }

    public static boolean tryEnableCancelPolicy(ScheduledExecutorService scheduledExecutorService) {
        Method method;
        Object obj;
        if (SHOULD_TRY_ENABLE_CANCEL_POLICY) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj2 = cachedSetRemoveOnCancelPolicyMethod;
                if (obj2 == SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED) {
                    return false;
                }
                if (obj2 == null) {
                    method = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
                    if (method != null) {
                        obj = method;
                    } else {
                        obj = SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED;
                    }
                    cachedSetRemoveOnCancelPolicyMethod = obj;
                } else {
                    method = (Method) obj2;
                }
            } else {
                method = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    method.invoke(scheduledExecutorService, new Object[]{true});
                    return true;
                } catch (InvocationTargetException e) {
                    RxJavaHooks.onError(e);
                } catch (IllegalAccessException e2) {
                    RxJavaHooks.onError(e2);
                } catch (IllegalArgumentException e3) {
                    RxJavaHooks.onError(e3);
                }
            }
        }
        return false;
    }

    static Method findSetRemoveOnCancelPolicyMethod(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!tryEnableCancelPolicy(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            registerExecutor((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.executor = newScheduledThreadPool;
    }

    public Subscription schedule(Action0 action0) {
        return schedule(action0, 0, (TimeUnit) null);
    }

    public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.isUnsubscribed) {
            return Subscriptions.unsubscribed();
        }
        return scheduleActual(action0, j, timeUnit);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0));
        if (j <= 0) {
            future = this.executor.submit(scheduledAction);
        } else {
            future = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public ScheduledAction scheduleActual(Action0 action0, long j, TimeUnit timeUnit, CompositeSubscription compositeSubscription) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), compositeSubscription);
        compositeSubscription.add(scheduledAction);
        if (j <= 0) {
            future = this.executor.submit(scheduledAction);
        } else {
            future = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public ScheduledAction scheduleActual(Action0 action0, long j, TimeUnit timeUnit, SubscriptionList subscriptionList) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), subscriptionList);
        subscriptionList.add(scheduledAction);
        if (j <= 0) {
            future = this.executor.submit(scheduledAction);
        } else {
            future = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public void unsubscribe() {
        this.isUnsubscribed = true;
        this.executor.shutdownNow();
        deregisterExecutor(this.executor);
    }

    public boolean isUnsubscribed() {
        return this.isUnsubscribed;
    }
}
