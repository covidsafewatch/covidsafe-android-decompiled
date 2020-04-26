package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0005H\u0007\u001a\f\u0010\f\u001a\u00020\t*\u00020\bH\u0007\u001a^\u0010\r\u001a\"\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011*\"\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eH\u0000\u001aL\u0010\r\u001a\u001c\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0011*\u001c\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0013H\u0000\u001a:\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014\"\u0004\b\u0000\u0010\u0011*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014H\u0000¨\u0006\u0015"}, d2 = {"toContinuation", "Lkotlin/coroutines/Continuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "toContinuationInterceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "toExperimentalContinuation", "toExperimentalContinuationInterceptor", "toExperimentalCoroutineContext", "toExperimentalSuspendFunction", "Lkotlin/Function3;", "T1", "T2", "R", "", "Lkotlin/Function2;", "Lkotlin/Function1;", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 1, 16})
/* compiled from: CoroutinesMigration.kt */
public final class CoroutinesMigrationKt {
    public static final <T> Continuation<T> toExperimentalContinuation(kotlin.coroutines.Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics.checkParameterIsNotNull(continuation, "$this$toExperimentalContinuation");
        ContinuationMigration continuationMigration = (ContinuationMigration) (!(continuation instanceof ContinuationMigration) ? null : continuation);
        return (continuationMigration == null || (continuation2 = continuationMigration.getContinuation()) == null) ? new ExperimentalContinuationMigration<>(continuation) : continuation2;
    }

    public static final <T> kotlin.coroutines.Continuation<T> toContinuation(Continuation<? super T> continuation) {
        kotlin.coroutines.Continuation<T> continuation2;
        Intrinsics.checkParameterIsNotNull(continuation, "$this$toContinuation");
        ExperimentalContinuationMigration experimentalContinuationMigration = (ExperimentalContinuationMigration) (!(continuation instanceof ExperimentalContinuationMigration) ? null : continuation);
        return (experimentalContinuationMigration == null || (continuation2 = experimentalContinuationMigration.getContinuation()) == null) ? new ContinuationMigration<>(continuation) : continuation2;
    }

    public static final CoroutineContext toExperimentalCoroutineContext(kotlin.coroutines.CoroutineContext coroutineContext) {
        CoroutineContext coroutineContext2;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$this$toExperimentalCoroutineContext");
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        ContextMigration contextMigration = (ContextMigration) coroutineContext.get(ContextMigration.Key);
        kotlin.coroutines.CoroutineContext minusKey = coroutineContext.minusKey(ContinuationInterceptor.Key).minusKey(ContextMigration.Key);
        if (contextMigration == null || (coroutineContext2 = contextMigration.getContext()) == null) {
            coroutineContext2 = EmptyCoroutineContext.INSTANCE;
        }
        if (minusKey != kotlin.coroutines.EmptyCoroutineContext.INSTANCE) {
            coroutineContext2 = coroutineContext2.plus(new ExperimentalContextMigration(minusKey));
        }
        return continuationInterceptor == null ? coroutineContext2 : coroutineContext2.plus(toExperimentalContinuationInterceptor(continuationInterceptor));
    }

    public static final kotlin.coroutines.CoroutineContext toCoroutineContext(CoroutineContext coroutineContext) {
        kotlin.coroutines.CoroutineContext coroutineContext2;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$this$toCoroutineContext");
        kotlin.coroutines.experimental.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.experimental.ContinuationInterceptor) coroutineContext.get(kotlin.coroutines.experimental.ContinuationInterceptor.Key);
        ExperimentalContextMigration experimentalContextMigration = (ExperimentalContextMigration) coroutineContext.get(ExperimentalContextMigration.Key);
        CoroutineContext minusKey = coroutineContext.minusKey(kotlin.coroutines.experimental.ContinuationInterceptor.Key).minusKey(ExperimentalContextMigration.Key);
        if (experimentalContextMigration == null || (coroutineContext2 = experimentalContextMigration.getContext()) == null) {
            coroutineContext2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        if (minusKey != EmptyCoroutineContext.INSTANCE) {
            coroutineContext2 = coroutineContext2.plus(new ContextMigration(minusKey));
        }
        return continuationInterceptor == null ? coroutineContext2 : coroutineContext2.plus(toContinuationInterceptor(continuationInterceptor));
    }

    public static final kotlin.coroutines.experimental.ContinuationInterceptor toExperimentalContinuationInterceptor(ContinuationInterceptor continuationInterceptor) {
        kotlin.coroutines.experimental.ContinuationInterceptor interceptor;
        Intrinsics.checkParameterIsNotNull(continuationInterceptor, "$this$toExperimentalContinuationInterceptor");
        ContinuationInterceptorMigration continuationInterceptorMigration = (ContinuationInterceptorMigration) (!(continuationInterceptor instanceof ContinuationInterceptorMigration) ? null : continuationInterceptor);
        return (continuationInterceptorMigration == null || (interceptor = continuationInterceptorMigration.getInterceptor()) == null) ? new ExperimentalContinuationInterceptorMigration(continuationInterceptor) : interceptor;
    }

    public static final ContinuationInterceptor toContinuationInterceptor(kotlin.coroutines.experimental.ContinuationInterceptor continuationInterceptor) {
        ContinuationInterceptor interceptor;
        Intrinsics.checkParameterIsNotNull(continuationInterceptor, "$this$toContinuationInterceptor");
        ExperimentalContinuationInterceptorMigration experimentalContinuationInterceptorMigration = (ExperimentalContinuationInterceptorMigration) (!(continuationInterceptor instanceof ExperimentalContinuationInterceptorMigration) ? null : continuationInterceptor);
        return (experimentalContinuationInterceptorMigration == null || (interceptor = experimentalContinuationInterceptorMigration.getInterceptor()) == null) ? new ContinuationInterceptorMigration(continuationInterceptor) : interceptor;
    }

    public static final <R> Function1<Continuation<? super R>, Object> toExperimentalSuspendFunction(Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$this$toExperimentalSuspendFunction");
        return new ExperimentalSuspendFunction0Migration<>(function1);
    }

    public static final <T1, R> Function2<T1, Continuation<? super R>, Object> toExperimentalSuspendFunction(Function2<? super T1, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "$this$toExperimentalSuspendFunction");
        return new ExperimentalSuspendFunction1Migration<>(function2);
    }

    public static final <T1, T2, R> Function3<T1, T2, Continuation<? super R>, Object> toExperimentalSuspendFunction(Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "$this$toExperimentalSuspendFunction");
        return new ExperimentalSuspendFunction2Migration<>(function3);
    }
}
