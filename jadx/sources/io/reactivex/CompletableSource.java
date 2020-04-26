package io.reactivex;

public interface CompletableSource {
    void subscribe(CompletableObserver completableObserver);
}
