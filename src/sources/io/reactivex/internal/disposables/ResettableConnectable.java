package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
