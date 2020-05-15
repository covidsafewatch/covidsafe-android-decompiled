package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0016\u0010\r\u001a\u00020\u0007*\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-p9JZ4hM", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDelayMillis", "toDelayMillis-LRDsOJo", "(D)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: Delay.kt */
public final class DelayKt {
    public static final Object delay(long j, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        getDelay(cancellableContinuation.getContext()).scheduleResumeAfterDelay(j, cancellableContinuation);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* renamed from: delay-p9JZ4hM  reason: not valid java name */
    public static final Object m1012delayp9JZ4hM(double d, Continuation<? super Unit> continuation) {
        Object delay = delay(m1013toDelayMillisLRDsOJo(d), continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    public static final Delay getDelay(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        if (!(element instanceof Delay)) {
            element = null;
        }
        Delay delay = (Delay) element;
        return delay != null ? delay : DefaultExecutorKt.getDefaultDelay();
    }

    /* renamed from: toDelayMillis-LRDsOJo  reason: not valid java name */
    public static final long m1013toDelayMillisLRDsOJo(double d) {
        if (Duration.m958compareToLRDsOJo(d, Duration.Companion.getZERO()) > 0) {
            return RangesKt.coerceAtLeast(Duration.m995toLongMillisecondsimpl(d), 1);
        }
        return 0;
    }
}
