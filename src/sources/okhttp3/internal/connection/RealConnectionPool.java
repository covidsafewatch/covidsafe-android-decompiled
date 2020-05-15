package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "callAcquirePooledConnection", "", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "routes", "", "Lokhttp3/Route;", "requireMultiplexed", "cleanup", "now", "connectionBecameIdle", "connection", "connectionCount", "evictAll", "", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealConnectionPool.kt */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask = new RealConnectionPool$cleanupTask$1(this, Util.okHttpName + " ConnectionPool");
    private final ArrayDeque<RealConnection> connections = new ArrayDeque<>();
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public RealConnectionPool(TaskRunner taskRunner, int i, long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.newQueue();
        if (!(j > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
        }
    }

    public final synchronized int idleConnectionCount() {
        int i;
        Iterable<RealConnection> iterable = this.connections;
        i = 0;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (RealConnection calls : iterable) {
                if (calls.getCalls().isEmpty() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final synchronized int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        List<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<RealConnection> it = this.connections.iterator();
            Intrinsics.checkExpressionValueIsNotNull(it, "connections.iterator()");
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.getCalls().isEmpty()) {
                    next.setNoNewExchanges(true);
                    Intrinsics.checkExpressionValueIsNotNull(next, "connection");
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            Unit unit = Unit.INSTANCE;
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0069, code lost:
        if (r0 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006b, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006e, code lost:
        okhttp3.internal.Util.closeQuietly(r0.socket());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0077, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long cleanup(long r11) {
        /*
            r10 = this;
            r0 = 0
            okhttp3.internal.connection.RealConnection r0 = (okhttp3.internal.connection.RealConnection) r0
            monitor-enter(r10)
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r1 = r10.connections     // Catch:{ all -> 0x0078 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0078 }
            r2 = 0
            r3 = -9223372036854775808
            r4 = r3
            r3 = r2
        L_0x000f:
            boolean r6 = r1.hasNext()     // Catch:{ all -> 0x0078 }
            if (r6 == 0) goto L_0x0038
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x0078 }
            okhttp3.internal.connection.RealConnection r6 = (okhttp3.internal.connection.RealConnection) r6     // Catch:{ all -> 0x0078 }
            java.lang.String r7 = "connection"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)     // Catch:{ all -> 0x0078 }
            int r7 = r10.pruneAndGetAllocationCount(r6, r11)     // Catch:{ all -> 0x0078 }
            if (r7 <= 0) goto L_0x0029
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0029:
            int r2 = r2 + 1
            long r7 = r6.getIdleAtNs$okhttp()     // Catch:{ all -> 0x0078 }
            long r7 = r11 - r7
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x000f
            r0 = r6
            r4 = r7
            goto L_0x000f
        L_0x0038:
            long r11 = r10.keepAliveDurationNs     // Catch:{ all -> 0x0078 }
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0054
            int r11 = r10.maxIdleConnections     // Catch:{ all -> 0x0078 }
            if (r2 <= r11) goto L_0x0043
            goto L_0x0054
        L_0x0043:
            if (r2 <= 0) goto L_0x004a
            long r11 = r10.keepAliveDurationNs     // Catch:{ all -> 0x0078 }
            long r11 = r11 - r4
            monitor-exit(r10)
            return r11
        L_0x004a:
            if (r3 <= 0) goto L_0x0050
            long r11 = r10.keepAliveDurationNs     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)
            return r11
        L_0x0050:
            r11 = -1
            monitor-exit(r10)
            return r11
        L_0x0054:
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r11 = r10.connections     // Catch:{ all -> 0x0078 }
            r11.remove(r0)     // Catch:{ all -> 0x0078 }
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r11 = r10.connections     // Catch:{ all -> 0x0078 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x0078 }
            if (r11 == 0) goto L_0x0066
            okhttp3.internal.concurrent.TaskQueue r11 = r10.cleanupQueue     // Catch:{ all -> 0x0078 }
            r11.cancelAll()     // Catch:{ all -> 0x0078 }
        L_0x0066:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)
            if (r0 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x006e:
            java.net.Socket r11 = r0.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r11)
            r11 = 0
            return r11
        L_0x0078:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.cleanup(long):long");
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i = 0;
        while (i < calls.size()) {
            Reference reference = calls.get(i);
            if (reference.get() != null) {
                i++;
            } else if (reference != null) {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. " + "Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j - this.keepAliveDurationNs);
                    return 0;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
            }
        }
        return calls.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealConnectionPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            Intrinsics.checkParameterIsNotNull(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List<Route> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(address, "address");
        Intrinsics.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Iterator<RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if ((!z || next.isMultiplexed()) && next.isEligible$okhttp(address, list)) {
                    Intrinsics.checkExpressionValueIsNotNull(next, "connection");
                    realCall.acquireConnectionNoEvents(next);
                    return true;
                }
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final void put(RealConnection realConnection) {
        Intrinsics.checkParameterIsNotNull(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            this.connections.add(realConnection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        Intrinsics.checkParameterIsNotNull(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        } else if (realConnection.getNoNewExchanges() || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return true;
        } else {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return false;
        }
    }
}
