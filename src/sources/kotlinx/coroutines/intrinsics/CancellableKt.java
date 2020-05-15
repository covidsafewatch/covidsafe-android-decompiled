package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DispatchedContinuationKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aR\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u000e\u001a\u0002H\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: Cancellable.kt */
public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        try {
            Continuation<Unit> intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation));
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m4constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m4constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        try {
            Continuation<Unit> intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation));
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m4constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m4constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation<? super Unit> intercepted = IntrinsicsKt.intercepted(continuation);
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m4constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m4constructorimpl(ResultKt.createFailure(th)));
        }
    }

    private static final void runSafely(Continuation<?> continuation, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m4constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
