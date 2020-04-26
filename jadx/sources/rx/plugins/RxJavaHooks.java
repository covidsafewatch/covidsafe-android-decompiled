package rx.plugins;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import rx.Completable;
import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.OnSubscribeOnAssembly;
import rx.internal.operators.OnSubscribeOnAssemblyCompletable;
import rx.internal.operators.OnSubscribeOnAssemblySingle;
import rx.internal.operators.SingleFromObservable;
import rx.internal.operators.SingleToObservable;

public final class RxJavaHooks {
    static volatile boolean lockdown;
    static volatile Func1<Completable.OnSubscribe, Completable.OnSubscribe> onCompletableCreate;
    static volatile Func1<Completable.Operator, Completable.Operator> onCompletableLift;
    static volatile Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> onCompletableStart;
    static volatile Func1<Throwable, Throwable> onCompletableSubscribeError;
    static volatile Func1<Scheduler, Scheduler> onComputationScheduler;
    static volatile Action1<Throwable> onError;
    static volatile Func0<? extends ScheduledExecutorService> onGenericScheduledExecutorService;
    static volatile Func1<Scheduler, Scheduler> onIOScheduler;
    static volatile Func1<Scheduler, Scheduler> onNewThreadScheduler;
    static volatile Func1<Observable.OnSubscribe, Observable.OnSubscribe> onObservableCreate;
    static volatile Func1<Observable.Operator, Observable.Operator> onObservableLift;
    static volatile Func1<Subscription, Subscription> onObservableReturn;
    static volatile Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> onObservableStart;
    static volatile Func1<Throwable, Throwable> onObservableSubscribeError;
    static volatile Func1<Action0, Action0> onScheduleAction;
    static volatile Func1<Single.OnSubscribe, Single.OnSubscribe> onSingleCreate;
    static volatile Func1<Observable.Operator, Observable.Operator> onSingleLift;
    static volatile Func1<Subscription, Subscription> onSingleReturn;
    static volatile Func2<Single, Single.OnSubscribe, Single.OnSubscribe> onSingleStart;
    static volatile Func1<Throwable, Throwable> onSingleSubscribeError;

    static {
        init();
    }

    private RxJavaHooks() {
        throw new IllegalStateException("No instances!");
    }

    static void init() {
        onError = new Action1<Throwable>() {
            public void call(Throwable th) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(th);
            }
        };
        onObservableStart = new Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe>() {
            public Observable.OnSubscribe call(Observable observable, Observable.OnSubscribe onSubscribe) {
                return RxJavaPlugins.getInstance().getObservableExecutionHook().onSubscribeStart(observable, onSubscribe);
            }
        };
        onObservableReturn = new Func1<Subscription, Subscription>() {
            public Subscription call(Subscription subscription) {
                return RxJavaPlugins.getInstance().getObservableExecutionHook().onSubscribeReturn(subscription);
            }
        };
        onSingleStart = new Func2<Single, Single.OnSubscribe, Single.OnSubscribe>() {
            public Single.OnSubscribe call(Single single, Single.OnSubscribe onSubscribe) {
                RxJavaSingleExecutionHook singleExecutionHook = RxJavaPlugins.getInstance().getSingleExecutionHook();
                if (singleExecutionHook == RxJavaSingleExecutionHookDefault.getInstance()) {
                    return onSubscribe;
                }
                return new SingleFromObservable(singleExecutionHook.onSubscribeStart(single, new SingleToObservable(onSubscribe)));
            }
        };
        onSingleReturn = new Func1<Subscription, Subscription>() {
            public Subscription call(Subscription subscription) {
                return RxJavaPlugins.getInstance().getSingleExecutionHook().onSubscribeReturn(subscription);
            }
        };
        onCompletableStart = new Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe>() {
            public Completable.OnSubscribe call(Completable completable, Completable.OnSubscribe onSubscribe) {
                return RxJavaPlugins.getInstance().getCompletableExecutionHook().onSubscribeStart(completable, onSubscribe);
            }
        };
        onScheduleAction = new Func1<Action0, Action0>() {
            public Action0 call(Action0 action0) {
                return RxJavaPlugins.getInstance().getSchedulersHook().onSchedule(action0);
            }
        };
        onObservableSubscribeError = new Func1<Throwable, Throwable>() {
            public Throwable call(Throwable th) {
                return RxJavaPlugins.getInstance().getObservableExecutionHook().onSubscribeError(th);
            }
        };
        onObservableLift = new Func1<Observable.Operator, Observable.Operator>() {
            public Observable.Operator call(Observable.Operator operator) {
                return RxJavaPlugins.getInstance().getObservableExecutionHook().onLift(operator);
            }
        };
        onSingleSubscribeError = new Func1<Throwable, Throwable>() {
            public Throwable call(Throwable th) {
                return RxJavaPlugins.getInstance().getSingleExecutionHook().onSubscribeError(th);
            }
        };
        onSingleLift = new Func1<Observable.Operator, Observable.Operator>() {
            public Observable.Operator call(Observable.Operator operator) {
                return RxJavaPlugins.getInstance().getSingleExecutionHook().onLift(operator);
            }
        };
        onCompletableSubscribeError = new Func1<Throwable, Throwable>() {
            public Throwable call(Throwable th) {
                return RxJavaPlugins.getInstance().getCompletableExecutionHook().onSubscribeError(th);
            }
        };
        onCompletableLift = new Func1<Completable.Operator, Completable.Operator>() {
            public Completable.Operator call(Completable.Operator operator) {
                return RxJavaPlugins.getInstance().getCompletableExecutionHook().onLift(operator);
            }
        };
        initCreate();
    }

    static void initCreate() {
        onObservableCreate = new Func1<Observable.OnSubscribe, Observable.OnSubscribe>() {
            public Observable.OnSubscribe call(Observable.OnSubscribe onSubscribe) {
                return RxJavaPlugins.getInstance().getObservableExecutionHook().onCreate(onSubscribe);
            }
        };
        onSingleCreate = new Func1<Single.OnSubscribe, Single.OnSubscribe>() {
            public Single.OnSubscribe call(Single.OnSubscribe onSubscribe) {
                return RxJavaPlugins.getInstance().getSingleExecutionHook().onCreate(onSubscribe);
            }
        };
        onCompletableCreate = new Func1<Completable.OnSubscribe, Completable.OnSubscribe>() {
            public Completable.OnSubscribe call(Completable.OnSubscribe onSubscribe) {
                return RxJavaPlugins.getInstance().getCompletableExecutionHook().onCreate(onSubscribe);
            }
        };
    }

    public static void reset() {
        if (!lockdown) {
            init();
            onComputationScheduler = null;
            onIOScheduler = null;
            onNewThreadScheduler = null;
            onGenericScheduledExecutorService = null;
        }
    }

    public static void clear() {
        if (!lockdown) {
            onError = null;
            onObservableCreate = null;
            onObservableStart = null;
            onObservableReturn = null;
            onObservableSubscribeError = null;
            onObservableLift = null;
            onSingleCreate = null;
            onSingleStart = null;
            onSingleReturn = null;
            onSingleSubscribeError = null;
            onSingleLift = null;
            onCompletableCreate = null;
            onCompletableStart = null;
            onCompletableSubscribeError = null;
            onCompletableLift = null;
            onComputationScheduler = null;
            onIOScheduler = null;
            onNewThreadScheduler = null;
            onScheduleAction = null;
            onGenericScheduledExecutorService = null;
        }
    }

    public static void lockdown() {
        lockdown = true;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void onError(Throwable th) {
        Action1<Throwable> action1 = onError;
        if (action1 != null) {
            try {
                action1.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                signalUncaught(th2);
            }
        }
        signalUncaught(th);
    }

    static void signalUncaught(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> Observable.OnSubscribe<T> onCreate(Observable.OnSubscribe<T> onSubscribe) {
        Func1<Observable.OnSubscribe, Observable.OnSubscribe> func1 = onObservableCreate;
        return func1 != null ? func1.call(onSubscribe) : onSubscribe;
    }

    public static <T> Single.OnSubscribe<T> onCreate(Single.OnSubscribe<T> onSubscribe) {
        Func1<Single.OnSubscribe, Single.OnSubscribe> func1 = onSingleCreate;
        return func1 != null ? func1.call(onSubscribe) : onSubscribe;
    }

    public static Completable.OnSubscribe onCreate(Completable.OnSubscribe onSubscribe) {
        Func1<Completable.OnSubscribe, Completable.OnSubscribe> func1 = onCompletableCreate;
        return func1 != null ? func1.call(onSubscribe) : onSubscribe;
    }

    public static Scheduler onComputationScheduler(Scheduler scheduler) {
        Func1<Scheduler, Scheduler> func1 = onComputationScheduler;
        return func1 != null ? func1.call(scheduler) : scheduler;
    }

    public static Scheduler onIOScheduler(Scheduler scheduler) {
        Func1<Scheduler, Scheduler> func1 = onIOScheduler;
        return func1 != null ? func1.call(scheduler) : scheduler;
    }

    public static Scheduler onNewThreadScheduler(Scheduler scheduler) {
        Func1<Scheduler, Scheduler> func1 = onNewThreadScheduler;
        return func1 != null ? func1.call(scheduler) : scheduler;
    }

    public static Action0 onScheduledAction(Action0 action0) {
        Func1<Action0, Action0> func1 = onScheduleAction;
        return func1 != null ? func1.call(action0) : action0;
    }

    public static <T> Observable.OnSubscribe<T> onObservableStart(Observable<T> observable, Observable.OnSubscribe<T> onSubscribe) {
        Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> func2 = onObservableStart;
        return func2 != null ? func2.call(observable, onSubscribe) : onSubscribe;
    }

    public static Subscription onObservableReturn(Subscription subscription) {
        Func1<Subscription, Subscription> func1 = onObservableReturn;
        return func1 != null ? func1.call(subscription) : subscription;
    }

    public static Throwable onObservableError(Throwable th) {
        Func1<Throwable, Throwable> func1 = onObservableSubscribeError;
        return func1 != null ? func1.call(th) : th;
    }

    public static <T, R> Observable.Operator<R, T> onObservableLift(Observable.Operator<R, T> operator) {
        Func1 func1 = onObservableLift;
        return func1 != null ? (Observable.Operator) func1.call(operator) : operator;
    }

    public static <T> Single.OnSubscribe<T> onSingleStart(Single<T> single, Single.OnSubscribe<T> onSubscribe) {
        Func2<Single, Single.OnSubscribe, Single.OnSubscribe> func2 = onSingleStart;
        return func2 != null ? func2.call(single, onSubscribe) : onSubscribe;
    }

    public static Subscription onSingleReturn(Subscription subscription) {
        Func1<Subscription, Subscription> func1 = onSingleReturn;
        return func1 != null ? func1.call(subscription) : subscription;
    }

    public static Throwable onSingleError(Throwable th) {
        Func1<Throwable, Throwable> func1 = onSingleSubscribeError;
        return func1 != null ? func1.call(th) : th;
    }

    public static <T, R> Observable.Operator<R, T> onSingleLift(Observable.Operator<R, T> operator) {
        Func1 func1 = onSingleLift;
        return func1 != null ? (Observable.Operator) func1.call(operator) : operator;
    }

    public static <T> Completable.OnSubscribe onCompletableStart(Completable completable, Completable.OnSubscribe onSubscribe) {
        Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> func2 = onCompletableStart;
        return func2 != null ? func2.call(completable, onSubscribe) : onSubscribe;
    }

    public static Throwable onCompletableError(Throwable th) {
        Func1<Throwable, Throwable> func1 = onCompletableSubscribeError;
        return func1 != null ? func1.call(th) : th;
    }

    public static <T, R> Completable.Operator onCompletableLift(Completable.Operator operator) {
        Func1<Completable.Operator, Completable.Operator> func1 = onCompletableLift;
        return func1 != null ? func1.call(operator) : operator;
    }

    public static void setOnError(Action1<Throwable> action1) {
        if (!lockdown) {
            onError = action1;
        }
    }

    public static void setOnCompletableCreate(Func1<Completable.OnSubscribe, Completable.OnSubscribe> func1) {
        if (!lockdown) {
            onCompletableCreate = func1;
        }
    }

    public static void setOnObservableCreate(Func1<Observable.OnSubscribe, Observable.OnSubscribe> func1) {
        if (!lockdown) {
            onObservableCreate = func1;
        }
    }

    public static void setOnSingleCreate(Func1<Single.OnSubscribe, Single.OnSubscribe> func1) {
        if (!lockdown) {
            onSingleCreate = func1;
        }
    }

    public static void setOnComputationScheduler(Func1<Scheduler, Scheduler> func1) {
        if (!lockdown) {
            onComputationScheduler = func1;
        }
    }

    public static void setOnIOScheduler(Func1<Scheduler, Scheduler> func1) {
        if (!lockdown) {
            onIOScheduler = func1;
        }
    }

    public static void setOnNewThreadScheduler(Func1<Scheduler, Scheduler> func1) {
        if (!lockdown) {
            onNewThreadScheduler = func1;
        }
    }

    public static void setOnScheduleAction(Func1<Action0, Action0> func1) {
        if (!lockdown) {
            onScheduleAction = func1;
        }
    }

    public static void setOnCompletableStart(Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> func2) {
        if (!lockdown) {
            onCompletableStart = func2;
        }
    }

    public static void setOnObservableStart(Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> func2) {
        if (!lockdown) {
            onObservableStart = func2;
        }
    }

    public static void setOnSingleStart(Func2<Single, Single.OnSubscribe, Single.OnSubscribe> func2) {
        if (!lockdown) {
            onSingleStart = func2;
        }
    }

    public static void setOnObservableReturn(Func1<Subscription, Subscription> func1) {
        if (!lockdown) {
            onObservableReturn = func1;
        }
    }

    public static void setOnSingleReturn(Func1<Subscription, Subscription> func1) {
        if (!lockdown) {
            onSingleReturn = func1;
        }
    }

    public static void setOnSingleSubscribeError(Func1<Throwable, Throwable> func1) {
        if (!lockdown) {
            onSingleSubscribeError = func1;
        }
    }

    public static Func1<Throwable, Throwable> getOnSingleSubscribeError() {
        return onSingleSubscribeError;
    }

    public static void setOnCompletableSubscribeError(Func1<Throwable, Throwable> func1) {
        if (!lockdown) {
            onCompletableSubscribeError = func1;
        }
    }

    public static Func1<Throwable, Throwable> getOnCompletableSubscribeError() {
        return onCompletableSubscribeError;
    }

    public static void setOnObservableSubscribeError(Func1<Throwable, Throwable> func1) {
        if (!lockdown) {
            onObservableSubscribeError = func1;
        }
    }

    public static Func1<Throwable, Throwable> getOnObservableSubscribeError() {
        return onObservableSubscribeError;
    }

    public static void setOnObservableLift(Func1<Observable.Operator, Observable.Operator> func1) {
        if (!lockdown) {
            onObservableLift = func1;
        }
    }

    public static Func1<Observable.Operator, Observable.Operator> getOnObservableLift() {
        return onObservableLift;
    }

    public static void setOnSingleLift(Func1<Observable.Operator, Observable.Operator> func1) {
        if (!lockdown) {
            onSingleLift = func1;
        }
    }

    public static Func1<Observable.Operator, Observable.Operator> getOnSingleLift() {
        return onSingleLift;
    }

    public static void setOnCompletableLift(Func1<Completable.Operator, Completable.Operator> func1) {
        if (!lockdown) {
            onCompletableLift = func1;
        }
    }

    public static Func1<Completable.Operator, Completable.Operator> getOnCompletableLift() {
        return onCompletableLift;
    }

    public static Func1<Scheduler, Scheduler> getOnComputationScheduler() {
        return onComputationScheduler;
    }

    public static Action1<Throwable> getOnError() {
        return onError;
    }

    public static Func1<Scheduler, Scheduler> getOnIOScheduler() {
        return onIOScheduler;
    }

    public static Func1<Scheduler, Scheduler> getOnNewThreadScheduler() {
        return onNewThreadScheduler;
    }

    public static Func1<Observable.OnSubscribe, Observable.OnSubscribe> getOnObservableCreate() {
        return onObservableCreate;
    }

    public static Func1<Action0, Action0> getOnScheduleAction() {
        return onScheduleAction;
    }

    public static Func1<Single.OnSubscribe, Single.OnSubscribe> getOnSingleCreate() {
        return onSingleCreate;
    }

    public static Func1<Completable.OnSubscribe, Completable.OnSubscribe> getOnCompletableCreate() {
        return onCompletableCreate;
    }

    public static Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> getOnCompletableStart() {
        return onCompletableStart;
    }

    public static Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> getOnObservableStart() {
        return onObservableStart;
    }

    public static Func2<Single, Single.OnSubscribe, Single.OnSubscribe> getOnSingleStart() {
        return onSingleStart;
    }

    public static Func1<Subscription, Subscription> getOnObservableReturn() {
        return onObservableReturn;
    }

    public static Func1<Subscription, Subscription> getOnSingleReturn() {
        return onSingleReturn;
    }

    public static void resetAssemblyTracking() {
        if (!lockdown) {
            initCreate();
        }
    }

    public static void clearAssemblyTracking() {
        if (!lockdown) {
            onObservableCreate = null;
            onSingleCreate = null;
            onCompletableCreate = null;
        }
    }

    public static void enableAssemblyTracking() {
        if (!lockdown) {
            onObservableCreate = new Func1<Observable.OnSubscribe, Observable.OnSubscribe>() {
                public Observable.OnSubscribe call(Observable.OnSubscribe onSubscribe) {
                    return new OnSubscribeOnAssembly(onSubscribe);
                }
            };
            onSingleCreate = new Func1<Single.OnSubscribe, Single.OnSubscribe>() {
                public Single.OnSubscribe call(Single.OnSubscribe onSubscribe) {
                    return new OnSubscribeOnAssemblySingle(onSubscribe);
                }
            };
            onCompletableCreate = new Func1<Completable.OnSubscribe, Completable.OnSubscribe>() {
                public Completable.OnSubscribe call(Completable.OnSubscribe onSubscribe) {
                    return new OnSubscribeOnAssemblyCompletable(onSubscribe);
                }
            };
        }
    }

    public static void setOnGenericScheduledExecutorService(Func0<? extends ScheduledExecutorService> func0) {
        if (!lockdown) {
            onGenericScheduledExecutorService = func0;
        }
    }

    public static Func0<? extends ScheduledExecutorService> getOnGenericScheduledExecutorService() {
        return onGenericScheduledExecutorService;
    }
}
