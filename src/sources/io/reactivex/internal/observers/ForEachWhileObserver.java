package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Predicate<? super T> onNext;

    public ForEachWhileObserver(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.onNext = predicate;
        this.onError = consumer;
        this.onComplete = action;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                if (!this.onNext.test(t)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                onError(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }
}
