package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final Callable<R> seedSupplier;
    final ObservableSource<T> source;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = observableSource;
        this.seedSupplier = callable;
        this.reducer = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.reducer, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
