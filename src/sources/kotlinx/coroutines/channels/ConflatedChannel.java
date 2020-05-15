package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000 #*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0014J\u0015\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00028\u00002\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0014¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\tH\u0014J\n\u0010!\u001a\u0004\u0018\u00010\u0013H\u0014J\u0016\u0010\"\u001a\u0004\u0018\u00010\u00132\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "pollInternal", "pollSelectInternal", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: ConflatedChannel.kt */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Symbol EMPTY = new Symbol("EMPTY");
    private final ReentrantLock lock = new ReentrantLock();
    private Object value = EMPTY;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return this.value == EMPTY;
    }

    public boolean isEmpty() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return isEmptyImpl();
        } finally {
            lock2.unlock();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel$Companion;", "", "()V", "EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "EMPTY$annotations", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ConflatedChannel.kt */
    private static final class Companion {
        private static /* synthetic */ void EMPTY$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        ReceiveOrClosed receiveOrClosed = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.value == EMPTY) {
                do {
                    takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (takeFirstReceiveOrPeekClosed != null) {
                        if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                            if (takeFirstReceiveOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            lock2.unlock();
                            return takeFirstReceiveOrPeekClosed;
                        }
                        if (takeFirstReceiveOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, (LockFreeLinkedListNode.PrepareOp) null);
                    }
                } while (tryResumeReceive == null);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                Unit unit = Unit.INSTANCE;
                lock2.unlock();
                if (takeFirstReceiveOrPeekClosed == null) {
                    Intrinsics.throwNpe();
                }
                takeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                if (takeFirstReceiveOrPeekClosed == null) {
                    Intrinsics.throwNpe();
                }
                return takeFirstReceiveOrPeekClosed.getOfferResult();
            }
            this.value = e;
            Object obj = AbstractChannelKt.OFFER_SUCCESS;
            lock2.unlock();
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        ReceiveOrClosed receiveOrClosed = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.value == EMPTY) {
                while (true) {
                    AbstractSendChannel.TryOfferDesc describeTryOffer = describeTryOffer(e);
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        ReceiveOrClosed receiveOrClosed2 = (ReceiveOrClosed) describeTryOffer.getResult();
                        Unit unit = Unit.INSTANCE;
                        lock2.unlock();
                        if (receiveOrClosed2 == null) {
                            Intrinsics.throwNpe();
                        }
                        receiveOrClosed2.completeResumeReceive(e);
                        if (receiveOrClosed2 == null) {
                            Intrinsics.throwNpe();
                        }
                        return receiveOrClosed2.getOfferResult();
                    } else if (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED) {
                        break;
                    } else if (performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                        if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                            if (!(performAtomicTrySelect instanceof Closed)) {
                                throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                            }
                        }
                        lock2.unlock();
                        return performAtomicTrySelect;
                    }
                }
            }
            if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                lock2.unlock();
                return already_selected;
            }
            this.value = e;
            Object obj = AbstractChannelKt.OFFER_SUCCESS;
            lock2.unlock();
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.value == EMPTY) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.value;
            this.value = EMPTY;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object pollSelectInternal(SelectInstance<?> selectInstance) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.value == EMPTY) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            } else if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                lock2.unlock();
                return already_selected;
            } else {
                Object obj = this.value;
                this.value = EMPTY;
                Unit unit = Unit.INSTANCE;
                lock2.unlock();
                return obj;
            }
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelIdempotent(boolean z) {
        if (z) {
            Lock lock2 = this.lock;
            lock2.lock();
            try {
                this.value = EMPTY;
                Unit unit = Unit.INSTANCE;
            } finally {
                lock2.unlock();
            }
        }
        super.onCancelIdempotent(z);
    }

    /* access modifiers changed from: protected */
    public boolean enqueueReceiveInternal(Receive<? super E> receive) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(value=" + this.value + ')';
    }
}
