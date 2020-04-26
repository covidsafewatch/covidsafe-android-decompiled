package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.channels.ValueOrClosed.Closed;
import kotlinx.coroutines.channels.ValueOrClosed.Companion;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\u001a#\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u0012*\u0004\u0018\u00010\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a%\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u0012*\u0006\u0012\u0002\b\u00030\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000*(\b\u0000\u0010\u0016\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"ENQUEUE_FAILED", "", "ENQUEUE_FAILED$annotations", "()V", "HANDLER_INVOKED", "HANDLER_INVOKED$annotations", "OFFER_FAILED", "OFFER_FAILED$annotations", "OFFER_SUCCESS", "OFFER_SUCCESS$annotations", "POLL_FAILED", "POLL_FAILED$annotations", "RECEIVE_NULL_ON_CLOSE", "", "RECEIVE_RESULT", "RECEIVE_THROWS_ON_CLOSE", "toResult", "Lkotlinx/coroutines/channels/ValueOrClosed;", "E", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Object;", "Handler", "Lkotlin/Function1;", "", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: AbstractChannel.kt */
public final class AbstractChannelKt {
    public static final Object ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
    public static final Object HANDLER_INVOKED = new Symbol("ON_CLOSE_HANDLER_INVOKED");
    public static final Object OFFER_FAILED = new Symbol("OFFER_FAILED");
    public static final Object OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
    public static final Object POLL_FAILED = new Symbol("POLL_FAILED");
    public static final int RECEIVE_NULL_ON_CLOSE = 1;
    public static final int RECEIVE_RESULT = 2;
    public static final int RECEIVE_THROWS_ON_CLOSE = 0;

    public static /* synthetic */ void ENQUEUE_FAILED$annotations() {
    }

    public static /* synthetic */ void HANDLER_INVOKED$annotations() {
    }

    public static /* synthetic */ void OFFER_FAILED$annotations() {
    }

    public static /* synthetic */ void OFFER_SUCCESS$annotations() {
    }

    public static /* synthetic */ void POLL_FAILED$annotations() {
    }

    /* access modifiers changed from: private */
    public static final <E> Object toResult(Object obj) {
        if (obj instanceof Closed) {
            Companion companion = ValueOrClosed.Companion;
            return ValueOrClosed.m1017constructorimpl(new Closed(((Closed) obj).closeCause));
        }
        Companion companion2 = ValueOrClosed.Companion;
        return ValueOrClosed.m1017constructorimpl(obj);
    }

    /* access modifiers changed from: private */
    public static final <E> Object toResult(Closed<?> closed) {
        Companion companion = ValueOrClosed.Companion;
        return ValueOrClosed.m1017constructorimpl(new Closed(closed.closeCause));
    }
}
