package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Combine.kt */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02a8, code lost:
        r0 = new kotlinx.coroutines.flow.internal.AbortFlowException(r12.$this_unsafeFlow);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x028e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x028f, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0293, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0294, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:77:0x026b, B:88:0x028d] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0195 A[Catch:{ all -> 0x0281 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e1 A[Catch:{ all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e4 A[Catch:{ all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01f0 A[Catch:{ all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0274  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x012c
            if (r2 == r6) goto L_0x00e6
            if (r2 == r5) goto L_0x00a2
            if (r2 == r4) goto L_0x0056
            if (r2 != r3) goto L_0x004e
            java.lang.Object r2 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r8 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$7
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r10 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r11 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r11
            java.lang.Object r12 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r13 = (kotlinx.coroutines.channels.ChannelIterator) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r15 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r15 = (kotlinx.coroutines.channels.ReceiveChannel) r15
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0127 }
            r5 = r2
            r2 = r3
            r4 = r9
            r6 = r12
            r3 = r13
            r9 = 4
            r12 = r1
            r1 = r8
            r8 = r10
            r10 = r15
            goto L_0x0259
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0056:
            java.lang.Object r2 = r1.L$12
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r3 = r1.L$11
            java.lang.Object r8 = r1.L$10
            java.lang.Object r9 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$7
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object r12 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r13 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r13
            java.lang.Object r14 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r15 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r15 = (kotlinx.coroutines.channels.ChannelIterator) r15
            java.lang.Object r4 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x009d }
            r7 = r5
            r5 = r9
            r9 = r8
            r8 = r10
            r10 = r12
            r12 = r1
            r1 = r0
            r0 = r22
            r19 = r15
            r15 = r3
            r3 = r6
            r6 = r4
            r4 = r11
            r11 = r13
            r13 = r19
            goto L_0x022c
        L_0x009d:
            r0 = move-exception
            r14 = r4
            r10 = r12
            goto L_0x0128
        L_0x00a2:
            java.lang.Object r2 = r1.L$11
            java.lang.Object r3 = r1.L$10
            java.lang.Object r4 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$7
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r8 = r1.L$6
            r10 = r8
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r8 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r8 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r8
            java.lang.Object r9 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r11 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r12 = r1.L$2
            r14 = r12
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r12 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0127 }
            r7 = r22
            r15 = r2
            r2 = r13
            r13 = r14
            r14 = r1
            r19 = r9
            r9 = r3
            r3 = r11
            r11 = r8
            r8 = r10
            r10 = r5
            r5 = r4
            r4 = r6
            r6 = r19
            goto L_0x01c7
        L_0x00e6:
            java.lang.Object r2 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r3 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r4 = r1.L$7
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r5 = r1.L$6
            r10 = r5
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r5 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r5 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r5
            java.lang.Object r6 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r8 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r1.L$2
            r14 = r9
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r9 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0127 }
            r15 = r22
            r12 = r1
            r13 = 1
            r19 = r4
            r4 = r2
            r2 = r9
            r9 = r6
            r6 = r19
            r20 = r5
            r5 = r3
            r3 = r11
            r11 = r8
            r8 = r20
            goto L_0x018d
        L_0x0127:
            r0 = move-exception
        L_0x0128:
            r12 = r1
        L_0x0129:
            r1 = r0
            goto L_0x028d
        L_0x012c:
            kotlin.ResultKt.throwOnFailure(r22)
            kotlinx.coroutines.CoroutineScope r2 = r1.p$
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r3 = r1.this$0
            kotlinx.coroutines.flow.Flow r3 = r3.$flow$inlined
            kotlinx.coroutines.channels.ReceiveChannel r10 = kotlinx.coroutines.flow.internal.CombineKt.asChannel(r2, r3)
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r3 = r1.this$0
            kotlinx.coroutines.flow.Flow r3 = r3.$flow2$inlined
            kotlinx.coroutines.channels.ReceiveChannel r14 = kotlinx.coroutines.flow.internal.CombineKt.asChannel(r2, r3)
            if (r14 == 0) goto L_0x02c7
            r3 = r14
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r4.<init>(r1, r10)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r3.invokeOnClose(r4)
            kotlinx.coroutines.channels.ChannelIterator r3 = r14.iterator()
            r4 = r7
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ AbortFlowException -> 0x029a, all -> 0x0296 }
            kotlinx.coroutines.channels.ChannelIterator r5 = r10.iterator()     // Catch:{ all -> 0x0288 }
            r11 = r1
            r12 = r11
            r6 = r10
            r8 = r6
            r9 = r8
        L_0x0160:
            r12.L$0 = r2     // Catch:{ all -> 0x0284 }
            r12.L$1 = r10     // Catch:{ all -> 0x0284 }
            r12.L$2 = r14     // Catch:{ all -> 0x0284 }
            r12.L$3 = r3     // Catch:{ all -> 0x0284 }
            r12.L$4 = r6     // Catch:{ all -> 0x0284 }
            r12.L$5 = r11     // Catch:{ all -> 0x0284 }
            r12.L$6 = r8     // Catch:{ all -> 0x0284 }
            r12.L$7 = r4     // Catch:{ all -> 0x0284 }
            r12.L$8 = r9     // Catch:{ all -> 0x0284 }
            r12.L$9 = r5     // Catch:{ all -> 0x0284 }
            r13 = 1
            r12.label = r13     // Catch:{ all -> 0x0284 }
            java.lang.Object r15 = r5.hasNext(r11)     // Catch:{ all -> 0x0284 }
            if (r15 != r0) goto L_0x017e
            return r0
        L_0x017e:
            r19 = r3
            r3 = r2
            r2 = r10
            r10 = r8
            r8 = r11
            r11 = r19
            r20 = r6
            r6 = r4
            r4 = r5
            r5 = r9
            r9 = r20
        L_0x018d:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x0281 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x0281 }
            if (r15 == 0) goto L_0x0269
            java.lang.Object r15 = r4.next()     // Catch:{ all -> 0x0281 }
            r12.L$0 = r3     // Catch:{ all -> 0x0281 }
            r12.L$1 = r2     // Catch:{ all -> 0x0281 }
            r12.L$2 = r14     // Catch:{ all -> 0x0281 }
            r12.L$3 = r11     // Catch:{ all -> 0x0281 }
            r12.L$4 = r9     // Catch:{ all -> 0x0281 }
            r12.L$5 = r8     // Catch:{ all -> 0x0281 }
            r12.L$6 = r10     // Catch:{ all -> 0x0281 }
            r12.L$7 = r6     // Catch:{ all -> 0x0281 }
            r12.L$8 = r5     // Catch:{ all -> 0x0281 }
            r12.L$9 = r4     // Catch:{ all -> 0x0281 }
            r12.L$10 = r15     // Catch:{ all -> 0x0281 }
            r12.L$11 = r15     // Catch:{ all -> 0x0281 }
            r7 = 2
            r12.label = r7     // Catch:{ all -> 0x0281 }
            java.lang.Object r7 = r11.hasNext(r12)     // Catch:{ all -> 0x0281 }
            if (r7 != r0) goto L_0x01bb
            return r0
        L_0x01bb:
            r13 = r14
            r14 = r12
            r12 = r2
            r2 = r3
            r3 = r11
            r11 = r8
            r8 = r10
            r10 = r5
            r5 = r4
            r4 = r6
            r6 = r9
            r9 = r15
        L_0x01c7:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0263 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x01d5
            r9 = r10
            r10 = r12
            r12 = r14
            r7 = 0
            r14 = r13
            goto L_0x0160
        L_0x01d5:
            kotlinx.coroutines.flow.FlowCollector r7 = r14.$this_unsafeFlow     // Catch:{ all -> 0x0263 }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r1 = r14.this$0     // Catch:{ all -> 0x0263 }
            kotlin.jvm.functions.Function3 r1 = r1.$transform$inlined     // Catch:{ all -> 0x0263 }
            r16 = r0
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0263 }
            if (r15 != r0) goto L_0x01e4
            r17 = 0
            goto L_0x01e6
        L_0x01e4:
            r17 = r15
        L_0x01e6:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0263 }
            r18 = r1
            java.lang.Object r1 = r3.next()     // Catch:{ all -> 0x0263 }
            if (r1 != r0) goto L_0x01f1
            r1 = 0
        L_0x01f1:
            r14.L$0 = r2     // Catch:{ all -> 0x0263 }
            r14.L$1 = r12     // Catch:{ all -> 0x0263 }
            r14.L$2 = r13     // Catch:{ all -> 0x0263 }
            r14.L$3 = r3     // Catch:{ all -> 0x0263 }
            r14.L$4 = r6     // Catch:{ all -> 0x0263 }
            r14.L$5 = r11     // Catch:{ all -> 0x0263 }
            r14.L$6 = r8     // Catch:{ all -> 0x0263 }
            r14.L$7 = r4     // Catch:{ all -> 0x0263 }
            r14.L$8 = r10     // Catch:{ all -> 0x0263 }
            r14.L$9 = r5     // Catch:{ all -> 0x0263 }
            r14.L$10 = r9     // Catch:{ all -> 0x0263 }
            r14.L$11 = r15     // Catch:{ all -> 0x0263 }
            r14.L$12 = r7     // Catch:{ all -> 0x0263 }
            r0 = 3
            r14.label = r0     // Catch:{ all -> 0x0263 }
            r0 = r18
            r19 = r17
            r17 = r2
            r2 = r19
            java.lang.Object r0 = r0.invoke(r2, r1, r14)     // Catch:{ all -> 0x0263 }
            r1 = r16
            if (r0 != r1) goto L_0x021f
            return r1
        L_0x021f:
            r2 = r7
            r7 = r12
            r12 = r14
            r14 = r6
            r6 = r13
            r13 = r3
            r3 = r17
            r19 = r10
            r10 = r8
            r8 = r19
        L_0x022c:
            r12.L$0 = r3     // Catch:{ all -> 0x025f }
            r12.L$1 = r7     // Catch:{ all -> 0x025f }
            r12.L$2 = r6     // Catch:{ all -> 0x025f }
            r12.L$3 = r13     // Catch:{ all -> 0x025f }
            r12.L$4 = r14     // Catch:{ all -> 0x025f }
            r12.L$5 = r11     // Catch:{ all -> 0x025f }
            r12.L$6 = r10     // Catch:{ all -> 0x025f }
            r12.L$7 = r4     // Catch:{ all -> 0x025f }
            r12.L$8 = r8     // Catch:{ all -> 0x025f }
            r12.L$9 = r5     // Catch:{ all -> 0x025f }
            r12.L$10 = r9     // Catch:{ all -> 0x025f }
            r12.L$11 = r15     // Catch:{ all -> 0x025f }
            r9 = 4
            r12.label = r9     // Catch:{ all -> 0x025f }
            java.lang.Object r0 = r2.emit(r0, r12)     // Catch:{ all -> 0x025f }
            if (r0 != r1) goto L_0x024e
            return r1
        L_0x024e:
            r0 = r1
            r2 = r3
            r1 = r8
            r8 = r10
            r3 = r13
            r10 = r7
            r19 = r14
            r14 = r6
            r6 = r19
        L_0x0259:
            r7 = 0
            r9 = r1
            r1 = r21
            goto L_0x0160
        L_0x025f:
            r0 = move-exception
            r1 = r0
            r14 = r6
            goto L_0x028d
        L_0x0263:
            r0 = move-exception
            r1 = r0
            r10 = r8
            r12 = r14
            r14 = r13
            goto L_0x028d
        L_0x0269:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0281 }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r6)     // Catch:{ AbortFlowException -> 0x0294 }
            boolean r0 = r14.isClosedForReceive()
            if (r0 != 0) goto L_0x02b0
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            kotlinx.coroutines.flow.FlowCollector r1 = r12.$this_unsafeFlow
            r0.<init>(r1)
        L_0x027b:
            java.util.concurrent.CancellationException r0 = (java.util.concurrent.CancellationException) r0
            r14.cancel(r0)
            goto L_0x02b0
        L_0x0281:
            r0 = move-exception
            goto L_0x0129
        L_0x0284:
            r0 = move-exception
            r1 = r0
            r10 = r8
            goto L_0x028d
        L_0x0288:
            r0 = move-exception
            r12 = r21
            goto L_0x0129
        L_0x028d:
            throw r1     // Catch:{ all -> 0x028e }
        L_0x028e:
            r0 = move-exception
            r2 = r0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r1)     // Catch:{ AbortFlowException -> 0x0294 }
            throw r2     // Catch:{ AbortFlowException -> 0x0294 }
        L_0x0294:
            r0 = move-exception
            goto L_0x029d
        L_0x0296:
            r0 = move-exception
            r12 = r21
            goto L_0x02b4
        L_0x029a:
            r0 = move-exception
            r12 = r21
        L_0x029d:
            kotlinx.coroutines.flow.FlowCollector r1 = r12.$this_unsafeFlow     // Catch:{ all -> 0x02b3 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r0, r1)     // Catch:{ all -> 0x02b3 }
            boolean r0 = r14.isClosedForReceive()
            if (r0 != 0) goto L_0x02b0
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            kotlinx.coroutines.flow.FlowCollector r1 = r12.$this_unsafeFlow
            r0.<init>(r1)
            goto L_0x027b
        L_0x02b0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02b3:
            r0 = move-exception
        L_0x02b4:
            boolean r1 = r14.isClosedForReceive()
            if (r1 != 0) goto L_0x02c6
            kotlinx.coroutines.flow.internal.AbortFlowException r1 = new kotlinx.coroutines.flow.internal.AbortFlowException
            kotlinx.coroutines.flow.FlowCollector r2 = r12.$this_unsafeFlow
            r1.<init>(r2)
            java.util.concurrent.CancellationException r1 = (java.util.concurrent.CancellationException) r1
            r14.cancel(r1)
        L_0x02c6:
            throw r0
        L_0x02c7:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
