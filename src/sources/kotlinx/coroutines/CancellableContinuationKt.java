package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a3\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a=\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HHø\u0001\u0000¢\u0006\u0002\u0010\r\u001a3\u0010\u000e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u0010\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0018\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendAtomicCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "holdCancellability", "", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendAtomicCancellableCoroutineReusable", "suspendCancellableCoroutine", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "removeOnCancellation", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: CancellableContinuation.kt */
public final class CancellableContinuationKt {
    private static final Object suspendCancellableCoroutine$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final <T> Object suspendCancellableCoroutine(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final Object suspendAtomicCancellableCoroutine$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final <T> Object suspendAtomicCancellableCoroutine(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final Object suspendAtomicCancellableCoroutineReusable$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl orCreateCancellableContinuation = getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        function1.invoke(orCreateCancellableContinuation);
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final <T> Object suspendAtomicCancellableCoroutineReusable(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl<? super T> orCreateCancellableContinuation = getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        function1.invoke(orCreateCancellableContinuation);
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 0);
        }
        CancellableContinuationImpl<T> claimReusableCancellableContinuation = ((DispatchedContinuation) continuation).claimReusableCancellableContinuation();
        if (claimReusableCancellableContinuation != null) {
            if (!claimReusableCancellableContinuation.resetState()) {
                claimReusableCancellableContinuation = null;
            }
            if (claimReusableCancellableContinuation != null) {
                return claimReusableCancellableContinuation;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 0);
    }

    public static final void removeOnCancellation(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.invokeOnCancellation(new RemoveOnCancel(lockFreeLinkedListNode));
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }

    @Deprecated(message = "holdCancellability parameter is deprecated and is no longer used", replaceWith = @ReplaceWith(expression = "suspendAtomicCancellableCoroutine(block)", imports = {}))
    private static final Object suspendAtomicCancellableCoroutine$$forInline(boolean z, Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    @Deprecated(message = "holdCancellability parameter is deprecated and is no longer used", replaceWith = @ReplaceWith(expression = "suspendAtomicCancellableCoroutine(block)", imports = {}))
    public static final <T> Object suspendAtomicCancellableCoroutine(boolean z, Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object suspendAtomicCancellableCoroutine$default(boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        int i2 = i & 1;
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        function1.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }
}
