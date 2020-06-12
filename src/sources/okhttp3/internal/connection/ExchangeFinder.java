package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ0\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0002J8\u0010&\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002J\u0006\u0010(\u001a\u00020%J\b\u0010)\u001a\u00020%H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectingConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryCurrentRoute", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExchangeFinder.kt */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address2, RealCall realCall, EventListener eventListener2) {
        Intrinsics.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics.checkParameterIsNotNull(address2, "address");
        Intrinsics.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(eventListener2, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall;
        this.eventListener = eventListener2;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics.checkParameterIsNotNull(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !Intrinsics.areEqual((Object) realInterceptorChain.getRequest$okhttp().method(), (Object) "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (RouteException e) {
            trackFailure(e.getLastConnectException());
            throw e;
        } catch (IOException e2) {
            trackFailure(e2);
            throw new RouteException(e2);
        }
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            if (findConnection.isHealthy(z2)) {
                return findConnection;
            }
            findConnection.noNewExchanges();
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    private final okhttp3.internal.connection.RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r0 = 0
            r2 = r0
            okhttp3.internal.connection.RealConnection r2 = (okhttp3.internal.connection.RealConnection) r2
            r3 = r0
            okhttp3.Route r3 = (okhttp3.Route) r3
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            okhttp3.internal.connection.RealConnectionPool r5 = r1.connectionPool
            monitor-enter(r5)
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0221 }
            boolean r6 = r6.isCanceled()     // Catch:{ all -> 0x0221 }
            if (r6 != 0) goto L_0x0217
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection()     // Catch:{ all -> 0x0221 }
            r4.element = r6     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection()     // Catch:{ all -> 0x0221 }
            if (r6 == 0) goto L_0x0058
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection()     // Catch:{ all -> 0x0221 }
            if (r6 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0221 }
        L_0x0034:
            boolean r6 = r6.getNoNewExchanges()     // Catch:{ all -> 0x0221 }
            if (r6 != 0) goto L_0x0051
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection()     // Catch:{ all -> 0x0221 }
            if (r6 != 0) goto L_0x0045
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0221 }
        L_0x0045:
            okhttp3.Address r7 = r1.address     // Catch:{ all -> 0x0221 }
            okhttp3.HttpUrl r7 = r7.url()     // Catch:{ all -> 0x0221 }
            boolean r6 = r6.supportsUrl(r7)     // Catch:{ all -> 0x0221 }
            if (r6 != 0) goto L_0x0058
        L_0x0051:
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0221 }
            java.net.Socket r6 = r6.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x0221 }
            goto L_0x0059
        L_0x0058:
            r6 = r0
        L_0x0059:
            okhttp3.internal.connection.RealCall r7 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r7 = r7.getConnection()     // Catch:{ all -> 0x0221 }
            if (r7 == 0) goto L_0x006c
            okhttp3.internal.connection.RealCall r2 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r2 = r2.getConnection()     // Catch:{ all -> 0x0221 }
            r7 = r0
            okhttp3.internal.connection.RealConnection r7 = (okhttp3.internal.connection.RealConnection) r7     // Catch:{ all -> 0x0221 }
            r4.element = r7     // Catch:{ all -> 0x0221 }
        L_0x006c:
            r7 = 1
            r8 = 0
            if (r2 != 0) goto L_0x0095
            r1.refusedStreamCount = r8     // Catch:{ all -> 0x0221 }
            r1.connectionShutdownCount = r8     // Catch:{ all -> 0x0221 }
            r1.otherFailureCount = r8     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnectionPool r9 = r1.connectionPool     // Catch:{ all -> 0x0221 }
            okhttp3.Address r10 = r1.address     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealCall r11 = r1.call     // Catch:{ all -> 0x0221 }
            boolean r9 = r9.callAcquirePooledConnection(r10, r11, r0, r8)     // Catch:{ all -> 0x0221 }
            if (r9 == 0) goto L_0x008a
            okhttp3.internal.connection.RealCall r2 = r1.call     // Catch:{ all -> 0x0221 }
            okhttp3.internal.connection.RealConnection r2 = r2.getConnection()     // Catch:{ all -> 0x0221 }
            r9 = 1
            goto L_0x0096
        L_0x008a:
            okhttp3.Route r9 = r1.nextRouteToTry     // Catch:{ all -> 0x0221 }
            if (r9 == 0) goto L_0x0095
            okhttp3.Route r3 = r1.nextRouteToTry     // Catch:{ all -> 0x0221 }
            r9 = r0
            okhttp3.Route r9 = (okhttp3.Route) r9     // Catch:{ all -> 0x0221 }
            r1.nextRouteToTry = r9     // Catch:{ all -> 0x0221 }
        L_0x0095:
            r9 = 0
        L_0x0096:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0221 }
            monitor-exit(r5)
            if (r6 == 0) goto L_0x009e
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r6)
        L_0x009e:
            T r5 = r4.element
            okhttp3.internal.connection.RealConnection r5 = (okhttp3.internal.connection.RealConnection) r5
            if (r5 == 0) goto L_0x00b8
            okhttp3.EventListener r5 = r1.eventListener
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.Call r6 = (okhttp3.Call) r6
            T r4 = r4.element
            okhttp3.internal.connection.RealConnection r4 = (okhttp3.internal.connection.RealConnection) r4
            if (r4 != 0) goto L_0x00b3
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b3:
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r5.connectionReleased(r6, r4)
        L_0x00b8:
            if (r9 == 0) goto L_0x00cb
            okhttp3.EventListener r4 = r1.eventListener
            okhttp3.internal.connection.RealCall r5 = r1.call
            okhttp3.Call r5 = (okhttp3.Call) r5
            if (r2 != 0) goto L_0x00c5
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00c5:
            r6 = r2
            okhttp3.Connection r6 = (okhttp3.Connection) r6
            r4.connectionAcquired(r5, r6)
        L_0x00cb:
            if (r2 == 0) goto L_0x00d3
            if (r2 != 0) goto L_0x00d2
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00d2:
            return r2
        L_0x00d3:
            if (r3 != 0) goto L_0x0109
            okhttp3.internal.connection.RouteSelector$Selection r4 = r1.routeSelection
            if (r4 == 0) goto L_0x00e4
            if (r4 != 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00de:
            boolean r4 = r4.hasNext()
            if (r4 != 0) goto L_0x0109
        L_0x00e4:
            okhttp3.internal.connection.RouteSelector r4 = r1.routeSelector
            if (r4 != 0) goto L_0x0101
            okhttp3.internal.connection.RouteSelector r4 = new okhttp3.internal.connection.RouteSelector
            okhttp3.Address r5 = r1.address
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.OkHttpClient r6 = r6.getClient()
            okhttp3.internal.connection.RouteDatabase r6 = r6.getRouteDatabase()
            okhttp3.internal.connection.RealCall r10 = r1.call
            okhttp3.Call r10 = (okhttp3.Call) r10
            okhttp3.EventListener r11 = r1.eventListener
            r4.<init>(r5, r6, r10, r11)
            r1.routeSelector = r4
        L_0x0101:
            okhttp3.internal.connection.RouteSelector$Selection r4 = r4.next()
            r1.routeSelection = r4
            r4 = 1
            goto L_0x010a
        L_0x0109:
            r4 = 0
        L_0x010a:
            r5 = r0
            java.util.List r5 = (java.util.List) r5
            okhttp3.internal.connection.RealConnectionPool r6 = r1.connectionPool
            monitor-enter(r6)
            okhttp3.internal.connection.RealCall r10 = r1.call     // Catch:{ all -> 0x0214 }
            boolean r10 = r10.isCanceled()     // Catch:{ all -> 0x0214 }
            if (r10 != 0) goto L_0x020a
            if (r4 == 0) goto L_0x0138
            okhttp3.internal.connection.RouteSelector$Selection r4 = r1.routeSelection     // Catch:{ all -> 0x0214 }
            if (r4 != 0) goto L_0x0121
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0214 }
        L_0x0121:
            java.util.List r5 = r4.getRoutes()     // Catch:{ all -> 0x0214 }
            okhttp3.internal.connection.RealConnectionPool r4 = r1.connectionPool     // Catch:{ all -> 0x0214 }
            okhttp3.Address r10 = r1.address     // Catch:{ all -> 0x0214 }
            okhttp3.internal.connection.RealCall r11 = r1.call     // Catch:{ all -> 0x0214 }
            boolean r4 = r4.callAcquirePooledConnection(r10, r11, r5, r8)     // Catch:{ all -> 0x0214 }
            if (r4 == 0) goto L_0x0138
            okhttp3.internal.connection.RealCall r2 = r1.call     // Catch:{ all -> 0x0214 }
            okhttp3.internal.connection.RealConnection r2 = r2.getConnection()     // Catch:{ all -> 0x0214 }
            r9 = 1
        L_0x0138:
            if (r9 != 0) goto L_0x0155
            if (r3 != 0) goto L_0x0147
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection     // Catch:{ all -> 0x0214 }
            if (r2 != 0) goto L_0x0143
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0214 }
        L_0x0143:
            okhttp3.Route r3 = r2.next()     // Catch:{ all -> 0x0214 }
        L_0x0147:
            okhttp3.internal.connection.RealConnection r2 = new okhttp3.internal.connection.RealConnection     // Catch:{ all -> 0x0214 }
            okhttp3.internal.connection.RealConnectionPool r4 = r1.connectionPool     // Catch:{ all -> 0x0214 }
            if (r3 != 0) goto L_0x0150
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0214 }
        L_0x0150:
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0214 }
            r1.connectingConnection = r2     // Catch:{ all -> 0x0214 }
        L_0x0155:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0214 }
            monitor-exit(r6)
            if (r9 == 0) goto L_0x0171
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            okhttp3.Call r3 = (okhttp3.Call) r3
            if (r2 != 0) goto L_0x0165
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0165:
            r4 = r2
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r0.connectionAcquired(r3, r4)
            if (r2 != 0) goto L_0x0170
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0170:
            return r2
        L_0x0171:
            if (r2 != 0) goto L_0x0176
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0176:
            okhttp3.internal.connection.RealCall r4 = r1.call
            r16 = r4
            okhttp3.Call r16 = (okhttp3.Call) r16
            okhttp3.EventListener r4 = r1.eventListener
            r10 = r2
            r11 = r19
            r12 = r20
            r13 = r21
            r14 = r22
            r15 = r23
            r17 = r4
            r10.connect(r11, r12, r13, r14, r15, r16, r17)
            okhttp3.internal.connection.RealCall r4 = r1.call
            okhttp3.OkHttpClient r4 = r4.getClient()
            okhttp3.internal.connection.RouteDatabase r4 = r4.getRouteDatabase()
            if (r2 != 0) goto L_0x019d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x019d:
            okhttp3.Route r6 = r2.route()
            r4.connected(r6)
            r4 = r0
            java.net.Socket r4 = (java.net.Socket) r4
            okhttp3.internal.connection.RealConnectionPool r6 = r1.connectionPool
            monitor-enter(r6)
            okhttp3.internal.connection.RealConnection r0 = (okhttp3.internal.connection.RealConnection) r0     // Catch:{ all -> 0x0207 }
            r1.connectingConnection = r0     // Catch:{ all -> 0x0207 }
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0207 }
            okhttp3.Address r8 = r1.address     // Catch:{ all -> 0x0207 }
            okhttp3.internal.connection.RealCall r9 = r1.call     // Catch:{ all -> 0x0207 }
            boolean r0 = r0.callAcquirePooledConnection(r8, r9, r5, r7)     // Catch:{ all -> 0x0207 }
            if (r0 == 0) goto L_0x01d4
            if (r2 != 0) goto L_0x01bf
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0207 }
        L_0x01bf:
            r2.setNoNewExchanges(r7)     // Catch:{ all -> 0x0207 }
            if (r2 != 0) goto L_0x01c7
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0207 }
        L_0x01c7:
            java.net.Socket r4 = r2.socket()     // Catch:{ all -> 0x0207 }
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0207 }
            okhttp3.internal.connection.RealConnection r2 = r0.getConnection()     // Catch:{ all -> 0x0207 }
            r1.nextRouteToTry = r3     // Catch:{ all -> 0x0207 }
            goto L_0x01e8
        L_0x01d4:
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0207 }
            if (r2 != 0) goto L_0x01db
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0207 }
        L_0x01db:
            r0.put(r2)     // Catch:{ all -> 0x0207 }
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0207 }
            if (r2 != 0) goto L_0x01e5
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0207 }
        L_0x01e5:
            r0.acquireConnectionNoEvents(r2)     // Catch:{ all -> 0x0207 }
        L_0x01e8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0207 }
            monitor-exit(r6)
            if (r4 == 0) goto L_0x01f0
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r4)
        L_0x01f0:
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            okhttp3.Call r3 = (okhttp3.Call) r3
            if (r2 != 0) goto L_0x01fb
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x01fb:
            r4 = r2
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r0.connectionAcquired(r3, r4)
            if (r2 != 0) goto L_0x0206
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0206:
            return r2
        L_0x0207:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x020a:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0214 }
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)     // Catch:{ all -> 0x0214 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0214 }
            throw r0     // Catch:{ all -> 0x0214 }
        L_0x0214:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0217:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0221 }
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)     // Catch:{ all -> 0x0221 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0221 }
            throw r0     // Catch:{ all -> 0x0221 }
        L_0x0221:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final RealConnection connectingConnection() {
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnectionPool)) {
            return this.connectingConnection;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    public final void trackFailure(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || !Thread.holdsLock(realConnectionPool)) {
            synchronized (this.connectionPool) {
                this.nextRouteToTry = null;
                if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                } else if (iOException instanceof ConnectionShutdownException) {
                    this.connectionShutdownCount++;
                } else {
                    this.otherFailureCount++;
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    public final boolean retryAfterFailure() {
        synchronized (this.connectionPool) {
            if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
                return false;
            }
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                RealConnection connection = this.call.getConnection();
                if (connection == null) {
                    Intrinsics.throwNpe();
                }
                this.nextRouteToTry = connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null && selection.hasNext()) {
                return true;
            }
            RouteSelector routeSelector2 = this.routeSelector;
            if (routeSelector2 == null) {
                return true;
            }
            boolean hasNext = routeSelector2.hasNext();
            return hasNext;
        }
    }

    private final boolean retryCurrentRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null || connection.getRouteFailureCount$okhttp() != 0 || !Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
            return false;
        }
        return true;
    }
}
