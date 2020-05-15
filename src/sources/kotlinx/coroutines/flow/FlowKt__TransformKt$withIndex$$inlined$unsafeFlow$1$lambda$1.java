package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$7"}, k = 1, mv = {1, 1, 16})
/* compiled from: Collect.kt */
public final class FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1$lambda$1 implements FlowCollector<T> {
    final /* synthetic */ Ref.IntRef $index$inlined;
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

    public FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Ref.IntRef intRef) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.$index$inlined = intRef;
    }

    public Object emit(Object obj, Continuation continuation) {
        FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
        Ref.IntRef intRef = this.$index$inlined;
        int i = intRef.element;
        intRef.element = i + 1;
        if (i >= 0) {
            Object emit = flowCollector.emit(new IndexedValue(i, obj), continuation);
            if (emit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return emit;
            }
            return Unit.INSTANCE;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
