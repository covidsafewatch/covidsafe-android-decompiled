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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowTransformLatest$flowCollect$3$1$2"}, k = 3, mv = {1, 1, 16})
/* compiled from: Merge.kt */
final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $value;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1(Object obj, Continuation continuation, ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1) {
        super(2, continuation);
        this.$value = obj;
        this.this$0 = channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 = new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1(this.$value, continuation, this.this$0);
        channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1.p$ = (CoroutineScope) obj;
        return channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Function3 access$getTransform$p = this.this$0.this$0.this$0.transform;
            FlowCollector flowCollector = this.this$0.this$0.$collector;
            Object obj2 = this.$value;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (access$getTransform$p.invoke(flowCollector, obj2, this) == coroutine_suspended) {
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
