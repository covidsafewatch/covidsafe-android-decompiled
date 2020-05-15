package io.reactivex;

public interface CompletableOperator {
    CompletableObserver apply(CompletableObserver completableObserver) throws Exception;
}
