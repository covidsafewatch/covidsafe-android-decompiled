package rx.internal.util;

import rx.functions.Func1;

public final class UtilityFunctions {

    enum Identity implements Func1<Object, Object> {
        INSTANCE;

        public Object call(Object obj) {
            return obj;
        }
    }

    private UtilityFunctions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Func1<? super T, Boolean> alwaysTrue() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> Func1<? super T, Boolean> alwaysFalse() {
        return AlwaysFalse.INSTANCE;
    }

    public static <T> Func1<T, T> identity() {
        return Identity.INSTANCE;
    }

    enum AlwaysTrue implements Func1<Object, Boolean> {
        INSTANCE;

        public Boolean call(Object obj) {
            return true;
        }
    }

    enum AlwaysFalse implements Func1<Object, Boolean> {
        INSTANCE;

        public Boolean call(Object obj) {
            return false;
        }
    }
}
