package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$combineTransformInternal$2$1$4"}, k = 3, mv = {1, 1, 16})
/* compiled from: Combine.kt */
final class CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $firstChannel$inlined;
    final /* synthetic */ BooleanRef $firstIsClosed$inlined;
    final /* synthetic */ ObjectRef $firstValue$inlined;
    final /* synthetic */ ReceiveChannel $secondChannel$inlined;
    final /* synthetic */ BooleanRef $secondIsClosed$inlined;
    final /* synthetic */ ObjectRef $secondValue$inlined;
    Object L$0;
    int label;
    private Object p$0;
    final /* synthetic */ CombineKt$combineTransformInternal$2 this$0;

    CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3(Continuation continuation, CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$2, BooleanRef booleanRef, ReceiveChannel receiveChannel, ObjectRef objectRef, ObjectRef objectRef2, BooleanRef booleanRef2, ReceiveChannel receiveChannel2) {
        this.this$0 = combineKt$combineTransformInternal$2;
        this.$firstIsClosed$inlined = booleanRef;
        this.$firstChannel$inlined = receiveChannel;
        this.$firstValue$inlined = objectRef;
        this.$secondValue$inlined = objectRef2;
        this.$secondIsClosed$inlined = booleanRef2;
        this.$secondChannel$inlined = receiveChannel2;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3(continuation, this.this$0, this.$firstIsClosed$inlined, this.$firstChannel$inlined, this.$firstValue$inlined, this.$secondValue$inlined, this.$secondIsClosed$inlined, this.$secondChannel$inlined);
        combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3.p$0 = obj;
        return combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            T t = this.p$0;
            this.$secondValue$inlined.element = t;
            if (this.$firstValue$inlined.element != null) {
                Function4 function4 = this.this$0.$transform;
                FlowCollector flowCollector = this.this$0.$this_combineTransformInternal;
                Symbol symbol = CombineKt.getNull();
                Symbol symbol2 = this.$firstValue$inlined.element;
                Object obj2 = null;
                if (symbol2 == symbol) {
                    symbol2 = null;
                }
                T t2 = CombineKt.getNull();
                T t3 = this.$secondValue$inlined.element;
                if (t3 != t2) {
                    obj2 = t3;
                }
                this.L$0 = t;
                this.label = 1;
                if (function4.invoke(flowCollector, symbol2, obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
