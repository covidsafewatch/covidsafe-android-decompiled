package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge$collectTo$2$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Merge.kt */
final class ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendingCollector $collector$inlined;
    final /* synthetic */ Flow $flow;
    final /* synthetic */ ProducerScope $scope$inlined;
    Object L$0;
    int label;
    private CoroutineScope p$;

    ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1(Flow flow, Continuation continuation, ProducerScope producerScope, SendingCollector sendingCollector) {
        this.$flow = flow;
        this.$scope$inlined = producerScope;
        this.$collector$inlined = sendingCollector;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1 channelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1 = new ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1(this.$flow, continuation, this.$scope$inlined, this.$collector$inlined);
        channelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1.p$ = (CoroutineScope) obj;
        return channelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Flow flow = this.$flow;
            FlowCollector flowCollector = this.$collector$inlined;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (flow.collect(flowCollector, this) == coroutine_suspended) {
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
