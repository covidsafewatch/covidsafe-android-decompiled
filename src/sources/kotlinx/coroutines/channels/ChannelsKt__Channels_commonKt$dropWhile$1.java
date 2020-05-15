package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$dropWhile$1", f = "Channels.common.kt", i = {0, 1, 1, 2, 2, 3, 4, 4}, l = {725, 726, 727, 731, 732}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "e", "$this$produce", "$this$produce", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$dropWhile$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_dropWhile;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$dropWhile$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$dropWhile$1 channelsKt__Channels_commonKt$dropWhile$1 = new ChannelsKt__Channels_commonKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__Channels_commonKt$dropWhile$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$dropWhile$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$dropWhile$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x006f
            if (r1 == r6) goto L_0x005f
            if (r1 == r5) goto L_0x004d
            if (r1 == r4) goto L_0x0041
            if (r1 == r3) goto L_0x0030
            if (r1 != r2) goto L_0x0028
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r1
            r8 = r4
            r1 = r0
            r0 = r11
            goto L_0x00cf
        L_0x0028:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0030:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r4
            r4 = r1
            r1 = r0
            r0 = r11
            goto L_0x00df
        L_0x0041:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r1
            r1 = r0
            r0 = r11
            goto L_0x00c9
        L_0x004d:
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r7 = r11.L$1
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r7
            r7 = r1
            r1 = r0
            r0 = r11
            goto L_0x00af
        L_0x005f:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r11
            goto L_0x008f
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.channels.ProducerScope r12 = r11.p$
            kotlinx.coroutines.channels.ReceiveChannel r1 = r11.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r7 = r12
            r12 = r11
        L_0x007c:
            r12.L$0 = r7
            r12.L$1 = r1
            r12.label = r6
            java.lang.Object r8 = r1.hasNext(r12)
            if (r8 != r0) goto L_0x0089
            return r0
        L_0x0089:
            r10 = r0
            r0 = r12
            r12 = r8
            r8 = r7
            r7 = r1
            r1 = r10
        L_0x008f:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00c9
            java.lang.Object r12 = r7.next()
            kotlin.jvm.functions.Function2 r9 = r0.$predicate
            r0.L$0 = r8
            r0.L$1 = r12
            r0.L$2 = r7
            r0.label = r5
            java.lang.Object r9 = r9.invoke(r12, r0)
            if (r9 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r10 = r9
            r9 = r12
            r12 = r10
        L_0x00af:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x00c4
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r12 = r8.send(r9, r0)
            if (r12 != r1) goto L_0x00c9
            return r1
        L_0x00c4:
            r12 = r0
            r0 = r1
            r1 = r7
            r7 = r8
            goto L_0x007c
        L_0x00c9:
            kotlinx.coroutines.channels.ReceiveChannel r12 = r0.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r12 = r12.iterator()
        L_0x00cf:
            r0.L$0 = r8
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r4 = r12.hasNext(r0)
            if (r4 != r1) goto L_0x00dc
            return r1
        L_0x00dc:
            r10 = r4
            r4 = r12
            r12 = r10
        L_0x00df:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00fc
            java.lang.Object r12 = r4.next()
            r0.L$0 = r8
            r0.L$1 = r12
            r0.L$2 = r4
            r0.label = r2
            java.lang.Object r12 = r8.send(r12, r0)
            if (r12 != r1) goto L_0x00fa
            return r1
        L_0x00fa:
            r12 = r4
            goto L_0x00cf
        L_0x00fc:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$dropWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
