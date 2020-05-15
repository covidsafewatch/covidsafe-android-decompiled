package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: Collect.kt */
final class FlowKt__CollectKt$launchIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_launchIn;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__CollectKt$launchIn$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_launchIn = flow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__CollectKt$launchIn$1 flowKt__CollectKt$launchIn$1 = new FlowKt__CollectKt$launchIn$1(this.$this_launchIn, continuation);
        flowKt__CollectKt$launchIn$1.p$ = (CoroutineScope) obj;
        return flowKt__CollectKt$launchIn$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__CollectKt$launchIn$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Flow flow = this.$this_launchIn;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (FlowKt.collect(flow, this) == coroutine_suspended) {
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
