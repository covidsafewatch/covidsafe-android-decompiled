package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012-\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R:\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;I)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Builders.kt */
final class CallbackFlowBuilder<T> extends ChannelFlowBuilder<T> {
    private final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> block;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallbackFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i);
    }

    public CallbackFlowBuilder(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i) {
        super(function2, coroutineContext, i);
        this.block = function2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collectTo(kotlinx.coroutines.channels.ProducerScope<? super T> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.CallbackFlowBuilder r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = super.collectTo(r5, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            boolean r5 = r5.isClosedForSend()
            if (r5 == 0) goto L_0x0053
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0053:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo(kotlinx.coroutines.channels.ProducerScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public ChannelFlow<T> create(CoroutineContext coroutineContext, int i) {
        return new CallbackFlowBuilder<>(this.block, coroutineContext, i);
    }
}
