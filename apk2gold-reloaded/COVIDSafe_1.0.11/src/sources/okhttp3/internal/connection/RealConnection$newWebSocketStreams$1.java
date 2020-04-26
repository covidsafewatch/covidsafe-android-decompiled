package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/RealConnection$newWebSocketStreams$1", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "close", "", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealConnection.kt */
public final class RealConnection$newWebSocketStreams$1 extends Streams {
    final /* synthetic */ Exchange $exchange;
    final /* synthetic */ BufferedSink $sink;
    final /* synthetic */ BufferedSource $source;

    RealConnection$newWebSocketStreams$1(Exchange exchange, BufferedSource bufferedSource, BufferedSink bufferedSink, boolean z, BufferedSource bufferedSource2, BufferedSink bufferedSink2) {
        this.$exchange = exchange;
        this.$source = bufferedSource;
        this.$sink = bufferedSink;
        super(z, bufferedSource2, bufferedSink2);
    }

    public void close() {
        this.$exchange.bodyComplete(-1, true, true, null);
    }
}
