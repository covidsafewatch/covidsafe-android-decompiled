package io.reactivex;

public interface CompletableOnSubscribe {
    void subscribe(CompletableEmitter completableEmitter) throws Exception;
}
