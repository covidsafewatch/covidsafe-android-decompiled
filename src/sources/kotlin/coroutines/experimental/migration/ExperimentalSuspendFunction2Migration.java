package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\"\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004B-\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\tJ.\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0010R1\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction2Migration;", "T1", "T2", "R", "Lkotlin/Function3;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function3;)V", "getFunction", "()Lkotlin/jvm/functions/Function3;", "invoke", "t1", "t2", "continuation", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
/* compiled from: CoroutinesMigration.kt */
final class ExperimentalSuspendFunction2Migration<T1, T2, R> implements Function3<T1, T2, Continuation<? super R>, Object> {
    private final Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, Object> function;

    public ExperimentalSuspendFunction2Migration(Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "function");
        this.function = function3;
    }

    public final Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, Object> getFunction() {
        return this.function;
    }

    public Object invoke(T1 t1, T2 t2, Continuation<? super R> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return this.function.invoke(t1, t2, CoroutinesMigrationKt.toContinuation(continuation));
    }
}
