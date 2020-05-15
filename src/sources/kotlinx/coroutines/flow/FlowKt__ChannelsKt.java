package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007\u001a/\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a&\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 16}, xs = "kotlinx/coroutines/flow/FlowKt")
/* compiled from: Channels.kt */
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[SYNTHETIC, Splitter:B:35:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ <T> java.lang.Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector<? super T> r8, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0062
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r8 = r0.L$3
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0060 }
        L_0x003c:
            r11 = r8
            r8 = r2
            r6 = r10
            r10 = r9
            r9 = r6
            goto L_0x0068
        L_0x0042:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004a:
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0060 }
            goto L_0x0082
        L_0x0060:
            r8 = move-exception
            goto L_0x00b8
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            java.lang.Throwable r11 = (java.lang.Throwable) r11
        L_0x0068:
            r0.L$0 = r8     // Catch:{ all -> 0x00b4 }
            r0.L$1 = r9     // Catch:{ all -> 0x00b4 }
            r0.Z$0 = r10     // Catch:{ all -> 0x00b4 }
            r0.L$2 = r11     // Catch:{ all -> 0x00b4 }
            r0.L$3 = r8     // Catch:{ all -> 0x00b4 }
            r0.label = r4     // Catch:{ all -> 0x00b4 }
            java.lang.Object r2 = r9.receiveOrClosed(r0)     // Catch:{ all -> 0x00b4 }
            if (r2 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r6 = r2
            r2 = r8
            r8 = r11
            r11 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0082:
            kotlinx.coroutines.channels.ValueOrClosed r11 = (kotlinx.coroutines.channels.ValueOrClosed) r11     // Catch:{ all -> 0x0060 }
            java.lang.Object r11 = r11.m1026unboximpl()     // Catch:{ all -> 0x0060 }
            boolean r5 = kotlinx.coroutines.channels.ValueOrClosed.m1024isClosedimpl(r11)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x009d
            java.lang.Throwable r11 = kotlinx.coroutines.channels.ValueOrClosed.m1020getCloseCauseimpl(r11)     // Catch:{ all -> 0x0060 }
            if (r11 != 0) goto L_0x009c
            if (r9 == 0) goto L_0x0099
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r8)
        L_0x0099:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x009c:
            throw r11     // Catch:{ all -> 0x0060 }
        L_0x009d:
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m1021getValueimpl(r11)     // Catch:{ all -> 0x0060 }
            r0.L$0 = r2     // Catch:{ all -> 0x0060 }
            r0.L$1 = r10     // Catch:{ all -> 0x0060 }
            r0.Z$0 = r9     // Catch:{ all -> 0x0060 }
            r0.L$2 = r8     // Catch:{ all -> 0x0060 }
            r0.L$3 = r11     // Catch:{ all -> 0x0060 }
            r0.label = r3     // Catch:{ all -> 0x0060 }
            java.lang.Object r11 = r2.emit(r5, r0)     // Catch:{ all -> 0x0060 }
            if (r11 != r1) goto L_0x003c
            return r1
        L_0x00b4:
            r8 = move-exception
            r6 = r10
            r10 = r9
            r9 = r6
        L_0x00b8:
            throw r8     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r11 = move-exception
            if (r9 == 0) goto L_0x00bf
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r8)
        L_0x00bf:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow<>(receiveChannel, false, (CoroutineContext) null, 0, 12, (DefaultConstructorMarker) null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow<>(receiveChannel, true, (CoroutineContext) null, 0, 12, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BroadcastChannel broadcastIn$default(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    public static final <T> BroadcastChannel<T> broadcastIn(Flow<? extends T> flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart) {
        return ChannelFlowKt.asChannelFlow(flow).broadcastImpl(coroutineScope, coroutineStart);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    public static final <T> Flow<T> asFlow(BroadcastChannel<T> broadcastChannel) {
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(broadcastChannel);
    }
}
