package io.reactivex;

public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
