package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$1$2$1", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ ObjectRef $lastValue$inlined;
    final /* synthetic */ SelectBuilder $this_select$inlined;
    final /* synthetic */ Object $value;
    final /* synthetic */ ReceiveChannel $values$inlined;
    int label;
    final /* synthetic */ FlowKt__DelayKt$debounce$2 this$0;

    FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(Object obj, Continuation continuation, SelectBuilder selectBuilder, FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2, ReceiveChannel receiveChannel, ObjectRef objectRef, FlowCollector flowCollector) {
        this.$value = obj;
        this.$this_select$inlined = selectBuilder;
        this.this$0 = flowKt__DelayKt$debounce$2;
        this.$values$inlined = receiveChannel;
        this.$lastValue$inlined = objectRef;
        this.$downstream$inlined = flowCollector;
        super(1, continuation);
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2 flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2 = new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(this.$value, continuation, this.$this_select$inlined, this.this$0, this.$values$inlined, this.$lastValue$inlined, this.$downstream$inlined);
        return flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2;
    }

    public final Object invoke(Object obj) {
        return ((FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = null;
            this.$lastValue$inlined.element = null;
            FlowCollector flowCollector = this.$downstream$inlined;
            Symbol symbol = NullSurrogateKt.NULL;
            Object obj3 = this.$value;
            if (obj3 != symbol) {
                obj2 = obj3;
            }
            this.label = 1;
            if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
