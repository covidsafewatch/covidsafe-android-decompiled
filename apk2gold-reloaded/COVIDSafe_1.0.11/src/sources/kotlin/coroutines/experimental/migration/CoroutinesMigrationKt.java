package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0005H\u0007\u001a\f\u0010\f\u001a\u00020\t*\u00020\bH\u0007\u001a^\u0010\r\u001a\"\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011*\"\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eH\u0000\u001aL\u0010\r\u001a\u001c\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0011*\u001c\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0013H\u0000\u001a:\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014\"\u0004\b\u0000\u0010\u0011*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014H\u0000¨\u0006\u0015"}, d2 = {"toContinuation", "Lkotlin/coroutines/Continuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "toContinuationInterceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "toExperimentalContinuation", "toExperimentalContinuationInterceptor", "toExperimentalCoroutineContext", "toExperimentalSuspendFunction", "Lkotlin/Function3;", "T1", "T2", "R", "", "Lkotlin/Function2;", "Lkotlin/Function1;", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 1, 16})
/* compiled from: CoroutinesMigration.kt */
public final class CoroutinesMigrationKt {
    public static final <T> Continuation<T> toExperimentalContinuation(kotlin.coroutines.Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$this$toExperimentalContinuation");
        ContinuationMigration continuationMigration = (ContinuationMigration) (!(continuation instanceof ContinuationMigration) ? null : continuation);
        if (continuationMigration != null) {
            Continuation<T> continuation2 = continuationMigration.getContinuation();
            if (continuation2 != null) {
                return continuation2;
            }
        }
        return new ExperimentalContinuationMigration<>(continuation);
    }

    public static final <T> kotlin.coroutines.Continuation<T> toContinuation(Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$this$toContinuation");
        ExperimentalContinuationMigration experimentalContinuationMigration = (ExperimentalContinuationMigration) (!(continuation instanceof ExperimentalContinuationMigration) ? null : continuation);
        if (experimentalContinuationMigration != null) {
            kotlin.coroutines.Continuation<T> continuation2 = experimentalContinuationMigration.getContinuation();
            if (continuation2 != null) {
                return continuation2;
            }
        }
        return new ContinuationMigration<>(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002f, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.coroutines.experimental.CoroutineContext toExperimentalCoroutineContext(kotlin.coroutines.CoroutineContext r3) {
        /*
            java.lang.String r0 = "$this$toExperimentalCoroutineContext"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Key r0 = (kotlin.coroutines.CoroutineContext.Key) r0
            kotlin.coroutines.CoroutineContext$Element r0 = r3.get(r0)
            kotlin.coroutines.ContinuationInterceptor r0 = (kotlin.coroutines.ContinuationInterceptor) r0
            kotlin.coroutines.experimental.migration.ContextMigration$Key r1 = kotlin.coroutines.experimental.migration.ContextMigration.Key
            kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r1)
            kotlin.coroutines.experimental.migration.ContextMigration r1 = (kotlin.coroutines.experimental.migration.ContextMigration) r1
            kotlin.coroutines.ContinuationInterceptor$Key r2 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext r3 = r3.minusKey(r2)
            kotlin.coroutines.experimental.migration.ContextMigration$Key r2 = kotlin.coroutines.experimental.migration.ContextMigration.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext r3 = r3.minusKey(r2)
            if (r1 == 0) goto L_0x0032
            kotlin.coroutines.experimental.CoroutineContext r1 = r1.getContext()
            if (r1 == 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            kotlin.coroutines.experimental.EmptyCoroutineContext r1 = kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.experimental.CoroutineContext r1 = (kotlin.coroutines.experimental.CoroutineContext) r1
        L_0x0036:
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            if (r3 != r2) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            kotlin.coroutines.experimental.migration.ExperimentalContextMigration r2 = new kotlin.coroutines.experimental.migration.ExperimentalContextMigration
            r2.<init>(r3)
            kotlin.coroutines.experimental.CoroutineContext r2 = (kotlin.coroutines.experimental.CoroutineContext) r2
            kotlin.coroutines.experimental.CoroutineContext r1 = r1.plus(r2)
        L_0x0046:
            if (r0 != 0) goto L_0x0049
            goto L_0x0053
        L_0x0049:
            kotlin.coroutines.experimental.ContinuationInterceptor r3 = toExperimentalContinuationInterceptor(r0)
            kotlin.coroutines.experimental.CoroutineContext r3 = (kotlin.coroutines.experimental.CoroutineContext) r3
            kotlin.coroutines.experimental.CoroutineContext r1 = r1.plus(r3)
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.experimental.migration.CoroutinesMigrationKt.toExperimentalCoroutineContext(kotlin.coroutines.CoroutineContext):kotlin.coroutines.experimental.CoroutineContext");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002f, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.coroutines.CoroutineContext toCoroutineContext(kotlin.coroutines.experimental.CoroutineContext r3) {
        /*
            java.lang.String r0 = "$this$toCoroutineContext"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            kotlin.coroutines.experimental.ContinuationInterceptor$Key r0 = kotlin.coroutines.experimental.ContinuationInterceptor.Key
            kotlin.coroutines.experimental.CoroutineContext$Key r0 = (kotlin.coroutines.experimental.CoroutineContext.Key) r0
            kotlin.coroutines.experimental.CoroutineContext$Element r0 = r3.get(r0)
            kotlin.coroutines.experimental.ContinuationInterceptor r0 = (kotlin.coroutines.experimental.ContinuationInterceptor) r0
            kotlin.coroutines.experimental.migration.ExperimentalContextMigration$Key r1 = kotlin.coroutines.experimental.migration.ExperimentalContextMigration.Key
            kotlin.coroutines.experimental.CoroutineContext$Key r1 = (kotlin.coroutines.experimental.CoroutineContext.Key) r1
            kotlin.coroutines.experimental.CoroutineContext$Element r1 = r3.get(r1)
            kotlin.coroutines.experimental.migration.ExperimentalContextMigration r1 = (kotlin.coroutines.experimental.migration.ExperimentalContextMigration) r1
            kotlin.coroutines.experimental.ContinuationInterceptor$Key r2 = kotlin.coroutines.experimental.ContinuationInterceptor.Key
            kotlin.coroutines.experimental.CoroutineContext$Key r2 = (kotlin.coroutines.experimental.CoroutineContext.Key) r2
            kotlin.coroutines.experimental.CoroutineContext r3 = r3.minusKey(r2)
            kotlin.coroutines.experimental.migration.ExperimentalContextMigration$Key r2 = kotlin.coroutines.experimental.migration.ExperimentalContextMigration.Key
            kotlin.coroutines.experimental.CoroutineContext$Key r2 = (kotlin.coroutines.experimental.CoroutineContext.Key) r2
            kotlin.coroutines.experimental.CoroutineContext r3 = r3.minusKey(r2)
            if (r1 == 0) goto L_0x0032
            kotlin.coroutines.CoroutineContext r1 = r1.getContext()
            if (r1 == 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
        L_0x0036:
            kotlin.coroutines.experimental.EmptyCoroutineContext r2 = kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE
            if (r3 != r2) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            kotlin.coroutines.experimental.migration.ContextMigration r2 = new kotlin.coroutines.experimental.migration.ContextMigration
            r2.<init>(r3)
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r2)
        L_0x0046:
            if (r0 != 0) goto L_0x0049
            goto L_0x0053
        L_0x0049:
            kotlin.coroutines.ContinuationInterceptor r3 = toContinuationInterceptor(r0)
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r3)
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.experimental.migration.CoroutinesMigrationKt.toCoroutineContext(kotlin.coroutines.experimental.CoroutineContext):kotlin.coroutines.CoroutineContext");
    }

    public static final ContinuationInterceptor toExperimentalContinuationInterceptor(kotlin.coroutines.ContinuationInterceptor continuationInterceptor) {
        Intrinsics.checkParameterIsNotNull(continuationInterceptor, "$this$toExperimentalContinuationInterceptor");
        ContinuationInterceptorMigration continuationInterceptorMigration = (ContinuationInterceptorMigration) (!(continuationInterceptor instanceof ContinuationInterceptorMigration) ? null : continuationInterceptor);
        if (continuationInterceptorMigration != null) {
            ContinuationInterceptor interceptor = continuationInterceptorMigration.getInterceptor();
            if (interceptor != null) {
                return interceptor;
            }
        }
        return new ExperimentalContinuationInterceptorMigration(continuationInterceptor);
    }

    public static final kotlin.coroutines.ContinuationInterceptor toContinuationInterceptor(ContinuationInterceptor continuationInterceptor) {
        Intrinsics.checkParameterIsNotNull(continuationInterceptor, "$this$toContinuationInterceptor");
        ExperimentalContinuationInterceptorMigration experimentalContinuationInterceptorMigration = (ExperimentalContinuationInterceptorMigration) (!(continuationInterceptor instanceof ExperimentalContinuationInterceptorMigration) ? null : continuationInterceptor);
        if (experimentalContinuationInterceptorMigration != null) {
            kotlin.coroutines.ContinuationInterceptor interceptor = experimentalContinuationInterceptorMigration.getInterceptor();
            if (interceptor != null) {
                return interceptor;
            }
        }
        return new ContinuationInterceptorMigration(continuationInterceptor);
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
