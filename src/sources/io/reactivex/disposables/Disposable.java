package io.reactivex.disposables;

public interface Disposable {
    void dispose();

    boolean isDisposed();
}
