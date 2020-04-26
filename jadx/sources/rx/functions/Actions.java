package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;

public final class Actions {
    private static final EmptyAction EMPTY_ACTION = new EmptyAction();

    private Actions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> empty() {
        return EMPTY_ACTION;
    }

    static final class EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements Action0, Action1<T0>, Action2<T0, T1>, Action3<T0, T1, T2>, Action4<T0, T1, T2, T3>, Action5<T0, T1, T2, T3, T4>, Action6<T0, T1, T2, T3, T4, T5>, Action7<T0, T1, T2, T3, T4, T5, T6>, Action8<T0, T1, T2, T3, T4, T5, T6, T7>, Action9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, ActionN {
        public void call() {
        }

        public void call(T0 t0) {
        }

        public void call(T0 t0, T1 t1) {
        }

        public void call(T0 t0, T1 t1, T2 t2) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        public void call(Object... objArr) {
        }

        EmptyAction() {
        }
    }

    public static Func0<Void> toFunc(Action0 action0) {
        return toFunc(action0, (Void) null);
    }

    public static <T1> Func1<T1, Void> toFunc(Action1<T1> action1) {
        return toFunc(action1, (Void) null);
    }

    public static <T1, T2> Func2<T1, T2, Void> toFunc(Action2<T1, T2> action2) {
        return toFunc(action2, (Void) null);
    }

    public static <T1, T2, T3> Func3<T1, T2, T3, Void> toFunc(Action3<T1, T2, T3> action3) {
        return toFunc(action3, (Void) null);
    }

    public static <T1, T2, T3, T4> Func4<T1, T2, T3, T4, Void> toFunc(Action4<T1, T2, T3, T4> action4) {
        return toFunc(action4, (Void) null);
    }

    public static <T1, T2, T3, T4, T5> Func5<T1, T2, T3, T4, T5, Void> toFunc(Action5<T1, T2, T3, T4, T5> action5) {
        return toFunc(action5, (Void) null);
    }

    public static <T1, T2, T3, T4, T5, T6> Func6<T1, T2, T3, T4, T5, T6, Void> toFunc(Action6<T1, T2, T3, T4, T5, T6> action6) {
        return toFunc(action6, (Void) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Func7<T1, T2, T3, T4, T5, T6, T7, Void> toFunc(Action7<T1, T2, T3, T4, T5, T6, T7> action7) {
        return toFunc(action7, (Void) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Func8<T1, T2, T3, T4, T5, T6, T7, T8, Void> toFunc(Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8) {
        return toFunc(action8, (Void) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> toFunc(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9) {
        return toFunc(action9, (Void) null);
    }

    public static FuncN<Void> toFunc(ActionN actionN) {
        return toFunc(actionN, (Void) null);
    }

    public static <R> Func0<R> toFunc(final Action0 action0, final R r) {
        return new Func0<R>() {
            public R call() {
                action0.call();
                return r;
            }
        };
    }

    public static <T1, R> Func1<T1, R> toFunc(final Action1<T1> action1, final R r) {
        return new Func1<T1, R>() {
            public R call(T1 t1) {
                action1.call(t1);
                return r;
            }
        };
    }

    public static <T1, T2, R> Func2<T1, T2, R> toFunc(final Action2<T1, T2> action2, final R r) {
        return new Func2<T1, T2, R>() {
            public R call(T1 t1, T2 t2) {
                action2.call(t1, t2);
                return r;
            }
        };
    }

    public static <T1, T2, T3, R> Func3<T1, T2, T3, R> toFunc(final Action3<T1, T2, T3> action3, final R r) {
        return new Func3<T1, T2, T3, R>() {
            public R call(T1 t1, T2 t2, T3 t3) {
                action3.call(t1, t2, t3);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, R> Func4<T1, T2, T3, T4, R> toFunc(final Action4<T1, T2, T3, T4> action4, final R r) {
        return new Func4<T1, T2, T3, T4, R>() {
            public R call(T1 t1, T2 t2, T3 t3, T4 t4) {
                action4.call(t1, t2, t3, t4);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, R> Func5<T1, T2, T3, T4, T5, R> toFunc(final Action5<T1, T2, T3, T4, T5> action5, final R r) {
        return new Func5<T1, T2, T3, T4, T5, R>() {
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                action5.call(t1, t2, t3, t4, t5);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, R> Func6<T1, T2, T3, T4, T5, T6, R> toFunc(final Action6<T1, T2, T3, T4, T5, T6> action6, final R r) {
        return new Func6<T1, T2, T3, T4, T5, T6, R>() {
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
                action6.call(t1, t2, t3, t4, t5, t6);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Func7<T1, T2, T3, T4, T5, T6, T7, R> toFunc(final Action7<T1, T2, T3, T4, T5, T6, T7> action7, final R r) {
        return new Func7<T1, T2, T3, T4, T5, T6, T7, R>() {
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
                action7.call(t1, t2, t3, t4, t5, t6, t7);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> toFunc(final Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8, final R r) {
        return new Func8<T1, T2, T3, T4, T5, T6, T7, T8, R>() {
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
                action8.call(t1, t2, t3, t4, t5, t6, t7, t8);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> toFunc(final Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9, final R r) {
        return new Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() {
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
                action9.call(t1, t2, t3, t4, t5, t6, t7, t8, t9);
                return r;
            }
        };
    }

    public static <R> FuncN<R> toFunc(final ActionN actionN, final R r) {
        return new FuncN<R>() {
            public R call(Object... objArr) {
                actionN.call(objArr);
                return r;
            }
        };
    }

    public static <T> Action1<T> toAction1(Action0 action0) {
        return new Action1CallsAction0(action0);
    }

    static final class Action1CallsAction0<T> implements Action1<T> {
        final Action0 action;

        public Action1CallsAction0(Action0 action0) {
            this.action = action0;
        }

        public void call(T t) {
            this.action.call();
        }
    }

    enum NotImplemented implements Action1<Throwable> {
        INSTANCE;

        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    public static Action1<Throwable> errorNotImplemented() {
        return NotImplemented.INSTANCE;
    }
}
