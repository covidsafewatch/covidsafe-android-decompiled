package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\b\u0007\u0018\u0000 A*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000F:\u0004BACDB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004B\u0007¢\u0006\u0004\b\u0003\u0010\u0005J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0016¢\u0006\u0004\b\u000f\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00132\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001b\u001a\u00020\u00132\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016¢\u0006\u0004\b&\u0010'JX\u00100\u001a\u00020\u0013\"\u0004\b\u0001\u0010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)2\u0006\u0010\u001f\u001a\u00028\u00002(\u0010/\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010-\u0012\u0006\u0012\u0004\u0018\u00010.0+H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J?\u00102\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b2\u0010\u000bJ\u001b\u00103\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b7\u00106R(\u0010;\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,088V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0019\u0010\u0002\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b>\u0010\u0005\u001a\u0004\b<\u0010=R\u0015\u0010@\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010=\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isClosedForSend", "()Z", "isFull", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "value$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k = 1, mv = {1, 1, 16})
/* compiled from: ConflatedBroadcastChannel.kt */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    private static final Closed CLOSED = new Closed((Throwable) null);
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final State<Object> INITIAL_STATE;
    private static final Symbol UNDEFINED;
    private static final AtomicReferenceFieldUpdater _state$FU;
    private static final AtomicIntegerFieldUpdater _updating$FU;
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU;
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;

    public static /* synthetic */ void value$annotations() {
    }

    public boolean isFull() {
        return false;
    }

    public ConflatedBroadcastChannel() {
        this._state = INITIAL_STATE;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        _state$FU.lazySet(this, new State(e, (Subscriber<E>[]) null));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "CLOSED$annotations", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Companion {
        private static /* synthetic */ void CLOSED$annotations() {
        }

        private static /* synthetic */ void UNDEFINED$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Class<ConflatedBroadcastChannel> cls = ConflatedBroadcastChannel.class;
        Symbol symbol = new Symbol("UNDEFINED");
        UNDEFINED = symbol;
        INITIAL_STATE = new State<>(symbol, (Subscriber<E>[]) null);
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
        _updating$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_updating");
        onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "onCloseHandler");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class State<E> {
        public final Subscriber<E>[] subscribers;
        public final Object value;

        public State(Object obj, Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable th) {
            this.closeCause = th;
        }

        public final Throwable getSendException() {
            Throwable th = this.closeCause;
            return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }

        public final Throwable getValueException() {
            Throwable th = this.closeCause;
            return th != null ? th : new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    public final E getValueOrNull() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            return null;
        }
        if (obj instanceof State) {
            E e = UNDEFINED;
            E e2 = ((State) obj).value;
            if (e2 == e) {
                return null;
            }
            return e2;
        }
        throw new IllegalStateException(("Invalid state " + obj).toString());
    }

    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    public ReceiveChannel<E> openSubscription() {
        Object obj;
        State state;
        Object obj2;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                if (state.value != UNDEFINED) {
                    subscriber.offerInternal(state.value);
                }
                obj2 = state.value;
                if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr != null) {
            return (Subscriber[]) ArraysKt.plus((T[]) subscriberArr, subscriber);
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[1];
        for (int i = 0; i < 1; i++) {
            subscriberArr2[i] = subscriber;
        }
        return subscriberArr2;
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        int length = subscriberArr.length;
        int indexOf = ArraysKt.indexOf((T[]) subscriberArr, subscriber);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(indexOf >= 0)) {
                throw new AssertionError();
            }
        }
        if (length == 1) {
            return null;
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[(length - 1)];
        Subscriber<E>[] subscriberArr3 = subscriberArr;
        Subscriber<E>[] subscriberArr4 = subscriberArr2;
        ArraysKt.copyInto$default((Object[]) subscriberArr3, (Object[]) subscriberArr4, 0, 0, indexOf, 6, (Object) null);
        ArraysKt.copyInto$default((Object[]) subscriberArr3, (Object[]) subscriberArr4, indexOf, indexOf + 1, 0, 8, (Object) null);
        return subscriberArr2;
    }

    private final void invokeOnCloseHandler(Throwable th) {
        Object obj = this.onCloseHandler;
        if (obj != null && obj != AbstractChannelKt.HANDLER_INVOKED && onCloseHandler$FU.compareAndSet(this, obj, AbstractChannelKt.HANDLER_INVOKED)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
        }
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        if (!onCloseHandler$FU.compareAndSet(this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && onCloseHandler$FU.compareAndSet(this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            function1.invoke(((Closed) obj2).closeCause);
        }
    }

    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    public Object send(E e, Continuation<? super Unit> continuation) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal != null) {
            throw offerInternal.getSendException();
        } else if (offerInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return offerInternal;
        } else {
            return Unit.INSTANCE;
        }
    }

    public boolean offer(E e) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal == null) {
            return true;
        }
        throw offerInternal.getSendException();
    }

    private final Closed offerInternal(E e) {
        Object obj;
        if (!_updating$FU.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof Closed) {
                    Closed closed = (Closed) obj;
                    this._updating = 0;
                    return closed;
                } else if (!(obj instanceof State)) {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                } else if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } finally {
                this._updating = 0;
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(e, ((State) obj).subscribers)));
        Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            for (Subscriber<E> offerInternal : subscriberArr) {
                offerInternal.offerInternal(e);
            }
        }
        return null;
    }

    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return new ConflatedBroadcastChannel$onSend$1(this);
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        if (selectInstance.trySelect()) {
            Closed offerInternal = offerInternal(e);
            if (offerInternal != null) {
                selectInstance.resumeSelectWithException(offerInternal.getSendException());
            } else {
                UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        /* access modifiers changed from: protected */
        public void onCancelIdempotent(boolean z) {
            if (z) {
                this.broadcastChannel.closeSubscriber(this);
            }
        }

        public Object offerInternal(E e) {
            return super.offerInternal(e);
        }
    }

    public final E getValue() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            throw ((Closed) obj).getValueException();
        } else if (obj instanceof State) {
            State state = (State) obj;
            if (state.value != UNDEFINED) {
                return state.value;
            }
            throw new IllegalStateException("No value");
        } else {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
    }

    /* access modifiers changed from: private */
    public final void closeSubscriber(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (!(obj instanceof Closed)) {
                if (obj instanceof State) {
                    State state = (State) obj;
                    obj2 = state.value;
                    if (obj != null) {
                        subscriberArr = state.subscribers;
                        if (subscriberArr == null) {
                            Intrinsics.throwNpe();
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } else {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                }
            } else {
                return;
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    /* renamed from: close */
    public boolean cancel(Throwable th) {
        Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, th == null ? CLOSED : new Closed(th)));
        if (obj != null) {
            Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
            if (subscriberArr != null) {
                for (Subscriber<E> close : subscriberArr) {
                    close.close(th);
                }
            }
            invokeOnCloseHandler(th);
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    }
}
