package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\u0007"}, d2 = {"interceptContinuationIfNeeded", "Lkotlin/coroutines/experimental/Continuation;", "T", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "continuation", "normalizeContinuation", "kotlin-stdlib-coroutines"}, k = 2, mv = {1, 1, 16})
/* compiled from: CoroutineIntrinsics.kt */
public final class CoroutineIntrinsics {
    public static final <T> Continuation<T> normalizeContinuation(Continuation<? super T> continuation) {
        Continuation<Object> facade;
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        CoroutineImpl coroutineImpl = (CoroutineImpl) (!(continuation instanceof CoroutineImpl) ? null : continuation);
        return (coroutineImpl == null || (facade = coroutineImpl.getFacade()) == null) ? continuation : facade;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r1 = r1.interceptContinuation(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlin.coroutines.experimental.Continuation<T> interceptContinuationIfNeeded(kotlin.coroutines.experimental.CoroutineContext r1, kotlin.coroutines.experimental.Continuation<? super T> r2) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "continuation"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            kotlin.coroutines.experimental.ContinuationInterceptor$Key r0 = kotlin.coroutines.experimental.ContinuationInterceptor.Key
            kotlin.coroutines.experimental.CoroutineContext$Key r0 = (kotlin.coroutines.experimental.CoroutineContext.Key) r0
            kotlin.coroutines.experimental.CoroutineContext$Element r1 = r1.get(r0)
            kotlin.coroutines.experimental.ContinuationInterceptor r1 = (kotlin.coroutines.experimental.ContinuationInterceptor) r1
            if (r1 == 0) goto L_0x001d
            kotlin.coroutines.experimental.Continuation r1 = r1.interceptContinuation(r2)
            if (r1 == 0) goto L_0x001d
            r2 = r1
        L_0x001d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics.interceptContinuationIfNeeded(kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.experimental.Continuation):kotlin.coroutines.experimental.Continuation");
    }
}
