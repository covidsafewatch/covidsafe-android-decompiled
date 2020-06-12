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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u00002\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u0004\u0018\u00010\r2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0014¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010(R\u0016\u0010,\u001a\u00020\b8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\b8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\b8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0016\u00100\u001a\u00020\b8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b0\u0010-R\u0016\u00101\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b1\u0010-R\u0016\u00102\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010-R\u0016\u00103\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b3\u0010-R\u001a\u00106\u001a\u000604j\u0002`58\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "<init>", "(I)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "currentSize", "", "ensureCapacity", "element", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "isFull", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 1, 16})
/* compiled from: ArrayChannel.kt */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private volatile int size;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayChannel(int i) {
        this.capacity = i;
        if (i < 1 ? false : true) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[Math.min(this.capacity, 8)];
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return this.size == this.capacity;
    }

    public boolean isFull() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return isFullImpl();
        } finally {
            lock2.unlock();
        }
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

    public boolean isClosedForReceive() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            lock2.unlock();
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
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    do {
                        takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != null) {
                            if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                this.size = i;
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
                    this.size = i;
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
                ensureCapacity(i);
                this.buffer[(this.head + i) % this.buffer.length] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
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
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    while (true) {
                        AbstractSendChannel.TryOfferDesc describeTryOffer = describeTryOffer(e);
                        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                        if (performAtomicTrySelect == null) {
                            this.size = i;
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
                            this.size = i;
                            lock2.unlock();
                            return performAtomicTrySelect;
                        }
                    }
                }
                if (!selectInstance.trySelect()) {
                    this.size = i;
                    Object already_selected = SelectKt.getALREADY_SELECTED();
                    lock2.unlock();
                    return already_selected;
                }
                ensureCapacity(i);
                this.buffer[(this.head + i) % this.buffer.length] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object enqueueSend(Send send) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            lock2.unlock();
        }
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.buffer;
        if (i >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.capacity)];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Send send = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.buffer[this.head];
            this.buffer[this.head] = null;
            this.size = i - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if (i == this.capacity) {
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        break;
                    }
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend((LockFreeLinkedListNode.PrepareOp) null);
                    if (tryResumeSend != null) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
                                z = true;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        obj2 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                        z = true;
                    } else {
                        send = takeFirstSendOrPeekClosed;
                    }
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i;
                this.buffer[(this.head + i) % this.buffer.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            if (z) {
                if (send == null) {
                    Intrinsics.throwNpe();
                }
                send.completeResumeSend();
            }
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.channels.Send} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlinx.coroutines.channels.Send} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        if (r7 != kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        r8.size = r3;
        r8.buffer[r8.head] = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        r2.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        if ((r7 instanceof kotlinx.coroutines.channels.Closed) == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        r1 = (kotlinx.coroutines.channels.Send) r7;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        throw new java.lang.IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ab A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object pollSelectInternal(kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1
            java.util.concurrent.locks.ReentrantLock r2 = r8.lock
            java.util.concurrent.locks.Lock r2 = (java.util.concurrent.locks.Lock) r2
            r2.lock()
            int r3 = r8.size     // Catch:{ all -> 0x00da }
            if (r3 != 0) goto L_0x001c
            kotlinx.coroutines.channels.Closed r9 = r8.getClosedForSend()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            java.lang.Object r9 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00da }
        L_0x0018:
            r2.unlock()
            return r9
        L_0x001c:
            java.lang.Object[] r4 = r8.buffer     // Catch:{ all -> 0x00da }
            int r5 = r8.head     // Catch:{ all -> 0x00da }
            r4 = r4[r5]     // Catch:{ all -> 0x00da }
            java.lang.Object[] r5 = r8.buffer     // Catch:{ all -> 0x00da }
            int r6 = r8.head     // Catch:{ all -> 0x00da }
            r5[r6] = r0     // Catch:{ all -> 0x00da }
            int r0 = r3 + -1
            r8.size = r0     // Catch:{ all -> 0x00da }
            java.lang.Object r0 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00da }
            int r5 = r8.capacity     // Catch:{ all -> 0x00da }
            r6 = 1
            if (r3 != r5) goto L_0x0094
        L_0x0033:
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r5 = r8.describeTryPoll()     // Catch:{ all -> 0x00da }
            r7 = r5
            kotlinx.coroutines.internal.AtomicDesc r7 = (kotlinx.coroutines.internal.AtomicDesc) r7     // Catch:{ all -> 0x00da }
            java.lang.Object r7 = r9.performAtomicTrySelect(r7)     // Catch:{ all -> 0x00da }
            if (r7 != 0) goto L_0x0052
            java.lang.Object r0 = r5.getResult()     // Catch:{ all -> 0x00da }
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1     // Catch:{ all -> 0x00da }
            if (r1 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x00da }
        L_0x004c:
            java.lang.Object r0 = r1.getPollResult()     // Catch:{ all -> 0x00da }
        L_0x0050:
            r5 = 1
            goto L_0x0095
        L_0x0052:
            java.lang.Object r5 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00da }
            if (r7 != r5) goto L_0x0057
            goto L_0x0094
        L_0x0057:
            java.lang.Object r5 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC     // Catch:{ all -> 0x00da }
            if (r7 != r5) goto L_0x005c
            goto L_0x0033
        L_0x005c:
            java.lang.Object r0 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00da }
            if (r7 != r0) goto L_0x006e
            r8.size = r3     // Catch:{ all -> 0x00da }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00da }
            int r0 = r8.head     // Catch:{ all -> 0x00da }
            r9[r0] = r4     // Catch:{ all -> 0x00da }
            r2.unlock()
            return r7
        L_0x006e:
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x0077
            r1 = r7
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1     // Catch:{ all -> 0x00da }
            r0 = r7
            goto L_0x0050
        L_0x0077:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r9.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r0)     // Catch:{ all -> 0x00da }
            r9.append(r7)     // Catch:{ all -> 0x00da }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00da }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00da }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00da }
            r0.<init>(r9)     // Catch:{ all -> 0x00da }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00da }
            throw r0     // Catch:{ all -> 0x00da }
        L_0x0094:
            r5 = 0
        L_0x0095:
            java.lang.Object r7 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00da }
            if (r0 == r7) goto L_0x00ab
            boolean r7 = r0 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00da }
            if (r7 != 0) goto L_0x00ab
            r8.size = r3     // Catch:{ all -> 0x00da }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00da }
            int r7 = r8.head     // Catch:{ all -> 0x00da }
            int r7 = r7 + r3
            java.lang.Object[] r3 = r8.buffer     // Catch:{ all -> 0x00da }
            int r3 = r3.length     // Catch:{ all -> 0x00da }
            int r7 = r7 % r3
            r9[r7] = r0     // Catch:{ all -> 0x00da }
            goto L_0x00c1
        L_0x00ab:
            boolean r9 = r9.trySelect()     // Catch:{ all -> 0x00da }
            if (r9 != 0) goto L_0x00c1
            r8.size = r3     // Catch:{ all -> 0x00da }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00da }
            int r0 = r8.head     // Catch:{ all -> 0x00da }
            r9[r0] = r4     // Catch:{ all -> 0x00da }
            java.lang.Object r9 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00da }
            r2.unlock()
            return r9
        L_0x00c1:
            int r9 = r8.head     // Catch:{ all -> 0x00da }
            int r9 = r9 + r6
            java.lang.Object[] r0 = r8.buffer     // Catch:{ all -> 0x00da }
            int r0 = r0.length     // Catch:{ all -> 0x00da }
            int r9 = r9 % r0
            r8.head = r9     // Catch:{ all -> 0x00da }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00da }
            r2.unlock()
            if (r5 == 0) goto L_0x00d9
            if (r1 != 0) goto L_0x00d6
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00d6:
            r1.completeResumeSend()
        L_0x00d9:
            return r4
        L_0x00da:
            r9 = move-exception
            r2.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.pollSelectInternal(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
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
    public void onCancelIdempotent(boolean z) {
        if (z) {
            Lock lock2 = this.lock;
            lock2.lock();
            try {
                int i = this.size;
                for (int i2 = 0; i2 < i; i2++) {
                    this.buffer[this.head] = 0;
                    this.head = (this.head + 1) % this.buffer.length;
                }
                this.size = 0;
                Unit unit = Unit.INSTANCE;
            } finally {
                lock2.unlock();
            }
        }
        super.onCancelIdempotent(z);
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}
