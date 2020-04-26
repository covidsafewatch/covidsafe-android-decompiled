package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: CoroutinesRoom.kt */
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: CoroutinesRoom.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r0 != null) goto L_0x0036;
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r3, boolean r4, java.util.concurrent.Callable<R> r5, kotlin.coroutines.Continuation<? super R> r6) {
            /*
                r2 = this;
                boolean r0 = r3.isOpen()
                if (r0 == 0) goto L_0x0011
                boolean r0 = r3.inTransaction()
                if (r0 == 0) goto L_0x0011
                java.lang.Object r3 = r5.call()
                return r3
            L_0x0011:
                kotlin.coroutines.CoroutineContext r0 = r6.getContext()
                androidx.room.TransactionElement$Key r1 = androidx.room.TransactionElement.Key
                kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                androidx.room.TransactionElement r0 = (androidx.room.TransactionElement) r0
                if (r0 == 0) goto L_0x0028
                kotlin.coroutines.ContinuationInterceptor r0 = r0.getTransactionDispatcher$room_ktx_release()
                if (r0 == 0) goto L_0x0028
                goto L_0x0036
            L_0x0028:
                if (r4 == 0) goto L_0x002f
                kotlinx.coroutines.CoroutineDispatcher r3 = androidx.room.CoroutinesRoomKt.getTransactionDispatcher(r3)
                goto L_0x0033
            L_0x002f:
                kotlinx.coroutines.CoroutineDispatcher r3 = androidx.room.CoroutinesRoomKt.getQueryDispatcher(r3)
            L_0x0033:
                r0 = r3
                kotlin.coroutines.ContinuationInterceptor r0 = (kotlin.coroutines.ContinuationInterceptor) r0
            L_0x0036:
                kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
                androidx.room.CoroutinesRoom$Companion$execute$2 r3 = new androidx.room.CoroutinesRoom$Companion$execute$2
                r4 = 0
                r3.<init>(r5, r4)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                java.lang.Object r3 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r6)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, java.util.concurrent.Callable, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @JvmStatic
        public final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
            Intrinsics.checkParameterIsNotNull(roomDatabase, "db");
            Intrinsics.checkParameterIsNotNull(strArr, "tableNames");
            Intrinsics.checkParameterIsNotNull(callable, "callable");
            CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(strArr, z, roomDatabase, callable, null);
            return FlowKt.flow(coroutinesRoom$Companion$createFlow$1);
        }
    }

    @JvmStatic
    public static final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, z, callable, continuation);
    }

    private CoroutinesRoom() {
    }
}
