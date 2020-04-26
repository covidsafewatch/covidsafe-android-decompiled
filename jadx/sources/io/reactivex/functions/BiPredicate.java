package io.reactivex.functions;

public interface BiPredicate<T1, T2> {
    boolean test(T1 t1, T2 t2) throws Exception;
}
