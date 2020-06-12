package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {700, 705, 706}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, continuation);
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0053
            if (r1 == r4) goto L_0x0040
            if (r1 == r3) goto L_0x002d
            if (r1 != r2) goto L_0x0025
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r4
            r10 = r5
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x00a9
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002d:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x00bb
        L_0x0040:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r5 = r9.I$0
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0086
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.channels.ProducerScope r10 = r9.p$
            int r1 = r9.$n
            if (r1 < 0) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x00dd
            int r1 = r9.$n
            if (r1 <= 0) goto L_0x00a0
            kotlinx.coroutines.channels.ReceiveChannel r5 = r9.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r10
            r10 = r9
            r8 = r5
            r5 = r1
            goto L_0x009c
        L_0x0070:
            r10.L$0 = r6
            r10.I$0 = r5
            r10.L$1 = r1
            r10.label = r4
            java.lang.Object r7 = r1.hasNext(r10)
            if (r7 != r0) goto L_0x007f
            return r0
        L_0x007f:
            r8 = r0
            r0 = r10
            r10 = r7
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x0086:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x009e
            r5.next()
            int r10 = r6 + -1
            if (r10 != 0) goto L_0x0097
            r6 = r10
            goto L_0x009e
        L_0x0097:
            r6 = r7
            r8 = r5
            r5 = r10
            r10 = r0
            r0 = r1
        L_0x009c:
            r1 = r8
            goto L_0x0070
        L_0x009e:
            r10 = r7
            goto L_0x00a3
        L_0x00a0:
            r6 = r1
            r1 = r0
            r0 = r9
        L_0x00a3:
            kotlinx.coroutines.channels.ReceiveChannel r4 = r0.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L_0x00a9:
            r0.L$0 = r10
            r0.I$0 = r6
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r5 = r4.hasNext(r0)
            if (r5 != r1) goto L_0x00b8
            return r1
        L_0x00b8:
            r8 = r5
            r5 = r10
            r10 = r8
        L_0x00bb:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00da
            java.lang.Object r10 = r4.next()
            r0.L$0 = r5
            r0.I$0 = r6
            r0.L$1 = r10
            r0.L$2 = r4
            r0.label = r2
            java.lang.Object r10 = r5.send(r10, r0)
            if (r10 != r1) goto L_0x00d8
            return r1
        L_0x00d8:
            r10 = r5
            goto L_0x00a9
        L_0x00da:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00dd:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Requested element count "
            r10.append(r0)
            int r0 = r9.$n
            r10.append(r0)
            java.lang.String r0 = " is less than zero."
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
