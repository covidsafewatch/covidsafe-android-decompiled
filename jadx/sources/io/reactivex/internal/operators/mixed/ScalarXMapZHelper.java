package io.reactivex.internal.operators.mixed;

final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: io.reactivex.CompletableSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> boolean tryAsCompletable(java.lang.Object r2, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> r3, io.reactivex.CompletableObserver r4) {
        /*
            boolean r0 = r2 instanceof java.util.concurrent.Callable
            if (r0 == 0) goto L_0x002d
            java.util.concurrent.Callable r2 = (java.util.concurrent.Callable) r2
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r2.call()     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x001b
            java.lang.Object r2 = r3.apply(r2)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "The mapper returned a null CompletableSource"
            java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, (java.lang.String) r3)     // Catch:{ all -> 0x0025 }
            r0 = r2
            io.reactivex.CompletableSource r0 = (io.reactivex.CompletableSource) r0     // Catch:{ all -> 0x0025 }
        L_0x001b:
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.disposables.EmptyDisposable.complete((io.reactivex.CompletableObserver) r4)
            goto L_0x0024
        L_0x0021:
            r0.subscribe(r4)
        L_0x0024:
            return r1
        L_0x0025:
            r2 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r2)
            io.reactivex.internal.disposables.EmptyDisposable.error((java.lang.Throwable) r2, (io.reactivex.CompletableObserver) r4)
            return r1
        L_0x002d:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ScalarXMapZHelper.tryAsCompletable(java.lang.Object, io.reactivex.functions.Function, io.reactivex.CompletableObserver):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: io.reactivex.MaybeSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T, R> boolean tryAsMaybe(java.lang.Object r2, io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> r3, io.reactivex.Observer<? super R> r4) {
        /*
            boolean r0 = r2 instanceof java.util.concurrent.Callable
            if (r0 == 0) goto L_0x0031
            java.util.concurrent.Callable r2 = (java.util.concurrent.Callable) r2
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r2.call()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x001b
            java.lang.Object r2 = r3.apply(r2)     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = "The mapper returned a null MaybeSource"
            java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, (java.lang.String) r3)     // Catch:{ all -> 0x0029 }
            r0 = r2
            io.reactivex.MaybeSource r0 = (io.reactivex.MaybeSource) r0     // Catch:{ all -> 0x0029 }
        L_0x001b:
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.disposables.EmptyDisposable.complete((io.reactivex.Observer<?>) r4)
            goto L_0x0028
        L_0x0021:
            io.reactivex.MaybeObserver r2 = io.reactivex.internal.operators.maybe.MaybeToObservable.create(r4)
            r0.subscribe(r2)
        L_0x0028:
            return r1
        L_0x0029:
            r2 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r2)
            io.reactivex.internal.disposables.EmptyDisposable.error((java.lang.Throwable) r2, (io.reactivex.Observer<?>) r4)
            return r1
        L_0x0031:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ScalarXMapZHelper.tryAsMaybe(java.lang.Object, io.reactivex.functions.Function, io.reactivex.Observer):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: io.reactivex.SingleSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T, R> boolean tryAsSingle(java.lang.Object r2, io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> r3, io.reactivex.Observer<? super R> r4) {
        /*
            boolean r0 = r2 instanceof java.util.concurrent.Callable
            if (r0 == 0) goto L_0x0031
            java.util.concurrent.Callable r2 = (java.util.concurrent.Callable) r2
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r2.call()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x001b
            java.lang.Object r2 = r3.apply(r2)     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = "The mapper returned a null SingleSource"
            java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, (java.lang.String) r3)     // Catch:{ all -> 0x0029 }
            r0 = r2
            io.reactivex.SingleSource r0 = (io.reactivex.SingleSource) r0     // Catch:{ all -> 0x0029 }
        L_0x001b:
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.disposables.EmptyDisposable.complete((io.reactivex.Observer<?>) r4)
            goto L_0x0028
        L_0x0021:
            io.reactivex.SingleObserver r2 = io.reactivex.internal.operators.single.SingleToObservable.create(r4)
            r0.subscribe(r2)
        L_0x0028:
            return r1
        L_0x0029:
            r2 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r2)
            io.reactivex.internal.disposables.EmptyDisposable.error((java.lang.Throwable) r2, (io.reactivex.Observer<?>) r4)
            return r1
        L_0x0031:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ScalarXMapZHelper.tryAsSingle(java.lang.Object, io.reactivex.functions.Function, io.reactivex.Observer):boolean");
    }
}
