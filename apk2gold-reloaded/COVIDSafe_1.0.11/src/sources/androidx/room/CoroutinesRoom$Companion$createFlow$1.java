package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u0001H\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {0, 0, 0, 0, 0}, l = {75}, m = "invokeSuspend", n = {"$this$flow", "observerChannel", "observer", "flowContext", "queryContext"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: CoroutinesRoom.kt */
final class CoroutinesRoom$Companion$createFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private FlowCollector p$;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {0, 1, 1, 1}, l = {80, 82}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "signal", "result"}, s = {"L$0", "L$0", "L$1", "L$3"})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1 reason: invalid class name */
    /* compiled from: CoroutinesRoom.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CoroutinesRoom$Companion$createFlow$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r1 = new AnonymousClass1(this.this$0, flowCollector2, coroutinesRoom$Companion$createFlow$1$observer$12, channel, coroutineContext2, continuation);
            r1.p$ = (CoroutineScope) obj;
            return r1;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x005d A[Catch:{ all -> 0x00a5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0068 A[Catch:{ all -> 0x00a5 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0035
                if (r1 == r3) goto L_0x0027
                if (r1 != r2) goto L_0x001f
                java.lang.Object r1 = r11.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r11.L$1
                kotlin.Unit r4 = (kotlin.Unit) r4
                java.lang.Object r4 = r11.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00a7 }
                r12 = r4
                goto L_0x004f
            L_0x001f:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0027:
                java.lang.Object r1 = r11.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r11.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00a7 }
                r5 = r4
                r4 = r11
                goto L_0x0060
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.CoroutineScope r12 = r11.p$
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r1 = r11.this$0
                androidx.room.RoomDatabase r1 = r1.$db
                androidx.room.InvalidationTracker r1 = r1.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r4 = r3
                androidx.room.InvalidationTracker$Observer r4 = (androidx.room.InvalidationTracker.Observer) r4
                r1.addObserver(r4)
                kotlinx.coroutines.channels.Channel r1 = r4     // Catch:{ all -> 0x00a7 }
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch:{ all -> 0x00a7 }
            L_0x004f:
                r4 = r11
            L_0x0050:
                r4.L$0 = r12     // Catch:{ all -> 0x00a5 }
                r4.L$1 = r1     // Catch:{ all -> 0x00a5 }
                r4.label = r3     // Catch:{ all -> 0x00a5 }
                java.lang.Object r5 = r1.hasNext(r4)     // Catch:{ all -> 0x00a5 }
                if (r5 != r0) goto L_0x005d
                return r0
            L_0x005d:
                r10 = r5
                r5 = r12
                r12 = r10
            L_0x0060:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x00a5 }
                boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x00a5 }
                if (r12 == 0) goto L_0x0093
                java.lang.Object r12 = r1.next()     // Catch:{ all -> 0x00a5 }
                kotlin.Unit r12 = (kotlin.Unit) r12     // Catch:{ all -> 0x00a5 }
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r6 = r4.this$0     // Catch:{ all -> 0x00a5 }
                java.util.concurrent.Callable r6 = r6.$callable     // Catch:{ all -> 0x00a5 }
                java.lang.Object r6 = r6.call()     // Catch:{ all -> 0x00a5 }
                kotlin.coroutines.CoroutineContext r7 = r5     // Catch:{ all -> 0x00a5 }
                androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 r8 = new androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1     // Catch:{ all -> 0x00a5 }
                r9 = 0
                r8.<init>(r4, r6, r9)     // Catch:{ all -> 0x00a5 }
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch:{ all -> 0x00a5 }
                r4.L$0 = r5     // Catch:{ all -> 0x00a5 }
                r4.L$1 = r12     // Catch:{ all -> 0x00a5 }
                r4.L$2 = r1     // Catch:{ all -> 0x00a5 }
                r4.L$3 = r6     // Catch:{ all -> 0x00a5 }
                r4.label = r2     // Catch:{ all -> 0x00a5 }
                java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r4)     // Catch:{ all -> 0x00a5 }
                if (r12 != r0) goto L_0x0091
                return r0
            L_0x0091:
                r12 = r5
                goto L_0x0050
            L_0x0093:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r12 = r4.this$0
                androidx.room.RoomDatabase r12 = r12.$db
                androidx.room.InvalidationTracker r12 = r12.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r0 = r3
                androidx.room.InvalidationTracker$Observer r0 = (androidx.room.InvalidationTracker.Observer) r0
                r12.removeObserver(r0)
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L_0x00a5:
                r12 = move-exception
                goto L_0x00a9
            L_0x00a7:
                r12 = move-exception
                r4 = r11
            L_0x00a9:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r0 = r4.this$0
                androidx.room.RoomDatabase r0 = r0.$db
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = r3
                androidx.room.InvalidationTracker$Observer r1 = (androidx.room.InvalidationTracker.Observer) r1
                r0.removeObserver(r1)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z, RoomDatabase roomDatabase, Callable callable, Continuation continuation) {
        this.$tableNames = strArr;
        this.$inTransaction = z;
        this.$db = roomDatabase;
        this.$callable = callable;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, continuation);
        coroutinesRoom$Companion$createFlow$1.p$ = (FlowCollector) obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Channel Channel = ChannelKt.Channel(-1);
            CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$1 = new CoroutinesRoom$Companion$createFlow$1$observer$1(this, Channel, this.$tableNames);
            Channel.offer(Unit.INSTANCE);
            CoroutineContext context = getContext();
            Object transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            CoroutineContext coroutineContext = (CoroutineContext) transactionDispatcher;
            final FlowCollector flowCollector2 = flowCollector;
            final CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$12 = coroutinesRoom$Companion$createFlow$1$observer$1;
            final Channel channel = Channel;
            final CoroutineContext coroutineContext2 = context;
            AnonymousClass1 r0 = new AnonymousClass1(this, null);
            Function2 function2 = r0;
            this.L$0 = flowCollector;
            this.L$1 = Channel;
            this.L$2 = coroutinesRoom$Companion$createFlow$1$observer$1;
            this.L$3 = context;
            this.L$4 = transactionDispatcher;
            this.label = 1;
            if (BuildersKt.withContext(coroutineContext, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) this.L$4;
            CoroutineContext coroutineContext3 = (CoroutineContext) this.L$3;
            CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$13 = (CoroutinesRoom$Companion$createFlow$1$observer$1) this.L$2;
            Channel channel2 = (Channel) this.L$1;
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
