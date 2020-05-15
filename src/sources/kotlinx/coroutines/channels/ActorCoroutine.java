package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "handleJobException", "exception", "", "onCancelling", "", "cause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Actor.kt */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    public ActorCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z) {
        super(coroutineContext, channel, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.concurrent.CancellationException} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCancelling(java.lang.Throwable r4) {
        /*
            r3 = this;
            kotlinx.coroutines.channels.Channel r0 = r3.get_channel()
            r1 = 0
            if (r4 == 0) goto L_0x002c
            boolean r2 = r4 instanceof java.util.concurrent.CancellationException
            if (r2 != 0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r1 = r4
        L_0x000d:
            java.util.concurrent.CancellationException r1 = (java.util.concurrent.CancellationException) r1
            if (r1 == 0) goto L_0x0012
            goto L_0x002c
        L_0x0012:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = kotlinx.coroutines.DebugStringsKt.getClassSimpleName(r3)
            r1.append(r2)
            java.lang.String r2 = " was cancelled"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.util.concurrent.CancellationException r4 = kotlinx.coroutines.ExceptionsKt.CancellationException(r1, r4)
            r1 = r4
        L_0x002c:
            r0.cancel((java.util.concurrent.CancellationException) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ActorCoroutine.onCancelling(java.lang.Throwable):void");
    }

    /* access modifiers changed from: protected */
    public boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }
}
