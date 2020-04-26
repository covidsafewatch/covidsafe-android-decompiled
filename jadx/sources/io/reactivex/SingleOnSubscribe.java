package io.reactivex;

public interface SingleOnSubscribe<T> {
    void subscribe(SingleEmitter<T> singleEmitter) throws Exception;
}
