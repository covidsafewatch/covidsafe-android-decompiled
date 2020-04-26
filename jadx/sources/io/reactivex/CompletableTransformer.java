package io.reactivex;

public interface CompletableTransformer {
    CompletableSource apply(Completable completable);
}
