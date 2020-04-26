package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "index", "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Collect.kt */
public final class FlowKt__CollectKt$collectIndexed$2 implements FlowCollector<T> {
    final /* synthetic */ Function3 $action;
    private int index;

    public FlowKt__CollectKt$collectIndexed$2(Function3 function3) {
        this.$action = function3;
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        Function3 function3 = this.$action;
        int i = this.index;
        this.index = i + 1;
        if (i >= 0) {
            return function3.invoke(Boxing.boxInt(i), t, continuation);
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public Object emit$$forInline(Object obj, Continuation continuation) {
        InlineMarker.mark(4);
        new FlowKt__CollectKt$collectIndexed$2$emit$1(this, continuation);
        InlineMarker.mark(5);
        Function3 function3 = this.$action;
        int i = this.index;
        this.index = i + 1;
        if (i >= 0) {
            return function3.invoke(Integer.valueOf(i), obj, continuation);
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
