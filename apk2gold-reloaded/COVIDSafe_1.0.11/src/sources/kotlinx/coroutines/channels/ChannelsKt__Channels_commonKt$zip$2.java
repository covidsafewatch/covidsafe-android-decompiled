package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2201, 2191, 2193}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "element2"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $other;
    final /* synthetic */ ReceiveChannel $this_zip;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private ProducerScope p$;

    ChannelsKt__Channels_commonKt$zip$2(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, Continuation continuation) {
        this.$this_zip = receiveChannel;
        this.$other = receiveChannel2;
        this.$transform = function2;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2 = new ChannelsKt__Channels_commonKt$zip$2(this.$this_zip, this.$other, this.$transform, continuation);
        channelsKt__Channels_commonKt$zip$2.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$zip$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$zip$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00df A[Catch:{ all -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013c A[Catch:{ all -> 0x014c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x00a3
            if (r2 == r5) goto L_0x007c
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r2 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r9 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r9
            java.lang.Object r10 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x014c }
            r13 = r1
            goto L_0x0140
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            java.lang.Object r2 = r1.L$9
            java.lang.Object r6 = r1.L$8
            java.lang.Object r7 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$5
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r10 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r11 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r11
            java.lang.Object r12 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r13 = (kotlinx.coroutines.channels.ChannelIterator) r13
            java.lang.Object r14 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r14 = (kotlinx.coroutines.channels.ProducerScope) r14
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0077 }
            r15 = r18
            r4 = r1
            r16 = r14
            r14 = r2
            r2 = r7
            r7 = r6
            r6 = r8
            r8 = r10
            r10 = r12
            r12 = r16
            goto L_0x0105
        L_0x0077:
            r0 = move-exception
            r2 = r0
            r8 = r10
            goto L_0x014e
        L_0x007c:
            java.lang.Object r2 = r1.L$7
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$5
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$3
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2 r9 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2) r9
            java.lang.Object r10 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x014c }
            r14 = r18
            r13 = r1
            goto L_0x00d7
        L_0x00a3:
            kotlin.ResultKt.throwOnFailure(r18)
            kotlinx.coroutines.channels.ProducerScope r2 = r1.p$
            kotlinx.coroutines.channels.ReceiveChannel r6 = r1.$other
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            kotlinx.coroutines.channels.ReceiveChannel r8 = r1.$this_zip
            r7 = 0
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            kotlinx.coroutines.channels.ChannelIterator r9 = r8.iterator()     // Catch:{ all -> 0x014c }
            r13 = r1
            r12 = r2
            r11 = r6
            r6 = r8
            r10 = r6
            r2 = r9
            r9 = r13
        L_0x00be:
            r13.L$0 = r12     // Catch:{ all -> 0x014c }
            r13.L$1 = r11     // Catch:{ all -> 0x014c }
            r13.L$2 = r10     // Catch:{ all -> 0x014c }
            r13.L$3 = r9     // Catch:{ all -> 0x014c }
            r13.L$4 = r8     // Catch:{ all -> 0x014c }
            r13.L$5 = r7     // Catch:{ all -> 0x014c }
            r13.L$6 = r6     // Catch:{ all -> 0x014c }
            r13.L$7 = r2     // Catch:{ all -> 0x014c }
            r13.label = r5     // Catch:{ all -> 0x014c }
            java.lang.Object r14 = r2.hasNext(r9)     // Catch:{ all -> 0x014c }
            if (r14 != r0) goto L_0x00d7
            return r0
        L_0x00d7:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x014c }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x014c }
            if (r14 == 0) goto L_0x0144
            java.lang.Object r14 = r2.next()     // Catch:{ all -> 0x014c }
            r13.L$0 = r12     // Catch:{ all -> 0x014c }
            r13.L$1 = r11     // Catch:{ all -> 0x014c }
            r13.L$2 = r10     // Catch:{ all -> 0x014c }
            r13.L$3 = r9     // Catch:{ all -> 0x014c }
            r13.L$4 = r8     // Catch:{ all -> 0x014c }
            r13.L$5 = r7     // Catch:{ all -> 0x014c }
            r13.L$6 = r6     // Catch:{ all -> 0x014c }
            r13.L$7 = r2     // Catch:{ all -> 0x014c }
            r13.L$8 = r14     // Catch:{ all -> 0x014c }
            r13.L$9 = r14     // Catch:{ all -> 0x014c }
            r13.label = r4     // Catch:{ all -> 0x014c }
            java.lang.Object r15 = r11.hasNext(r13)     // Catch:{ all -> 0x014c }
            if (r15 != r0) goto L_0x0100
            return r0
        L_0x0100:
            r4 = r13
            r13 = r11
            r11 = r9
            r9 = r7
            r7 = r14
        L_0x0105:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x014c }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x014c }
            if (r15 != 0) goto L_0x0113
            r7 = r9
            r9 = r11
            r11 = r13
            r13 = r4
            r4 = 2
            goto L_0x00be
        L_0x0113:
            java.lang.Object r15 = r13.next()     // Catch:{ all -> 0x014c }
            kotlin.jvm.functions.Function2 r5 = r4.$transform     // Catch:{ all -> 0x014c }
            java.lang.Object r5 = r5.invoke(r14, r15)     // Catch:{ all -> 0x014c }
            r4.L$0 = r12     // Catch:{ all -> 0x014c }
            r4.L$1 = r13     // Catch:{ all -> 0x014c }
            r4.L$2 = r10     // Catch:{ all -> 0x014c }
            r4.L$3 = r11     // Catch:{ all -> 0x014c }
            r4.L$4 = r8     // Catch:{ all -> 0x014c }
            r4.L$5 = r9     // Catch:{ all -> 0x014c }
            r4.L$6 = r6     // Catch:{ all -> 0x014c }
            r4.L$7 = r2     // Catch:{ all -> 0x014c }
            r4.L$8 = r7     // Catch:{ all -> 0x014c }
            r4.L$9 = r14     // Catch:{ all -> 0x014c }
            r4.L$10 = r15     // Catch:{ all -> 0x014c }
            r4.label = r3     // Catch:{ all -> 0x014c }
            java.lang.Object r5 = r12.send(r5, r4)     // Catch:{ all -> 0x014c }
            if (r5 != r0) goto L_0x013c
            return r0
        L_0x013c:
            r7 = r9
            r9 = r11
            r11 = r13
            r13 = r4
        L_0x0140:
            r4 = 2
            r5 = 1
            goto L_0x00be
        L_0x0144:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014c }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014c:
            r0 = move-exception
            r2 = r0
        L_0x014e:
            throw r2     // Catch:{ all -> 0x014f }
        L_0x014f:
            r0 = move-exception
            r3 = r0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
