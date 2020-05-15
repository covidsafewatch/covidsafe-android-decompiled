package rx.internal.operators;

import rx.functions.Func1;

public class SingleOperatorCast<T, R> implements Func1<T, R> {
    final Class<R> castClass;

    public SingleOperatorCast(Class<R> cls) {
        this.castClass = cls;
    }

    public R call(T t) {
        return this.castClass.cast(t);
    }
}
