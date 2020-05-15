package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(Disposable disposable) {
        lazySet(disposable);
    }

    public boolean update(Disposable disposable) {
        return DisposableHelper.set(this, disposable);
    }

    public boolean replace(Disposable disposable) {
        return DisposableHelper.replace(this, disposable);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }
}
