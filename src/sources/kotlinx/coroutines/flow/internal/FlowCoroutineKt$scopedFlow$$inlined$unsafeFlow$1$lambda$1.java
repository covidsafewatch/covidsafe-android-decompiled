package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/FlowCoroutineKt$scopedFlow$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FlowCoroutine.kt */
final class FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1 flowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = flowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1 flowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1 = new FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        flowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return flowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Function3 function3 = this.this$0.$block$inlined;
            FlowCollector flowCollector = this.$this_unsafeFlow;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (function3.invoke(coroutineScope, flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
