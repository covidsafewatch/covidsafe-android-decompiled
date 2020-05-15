package io.reactivex.internal.fuseable;

import io.reactivex.disposables.Disposable;

public interface QueueDisposable<T> extends QueueFuseable<T>, Disposable {
}
