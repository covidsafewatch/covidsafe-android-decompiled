package okhttp3.internal.http2;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okio.Buffer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$pushDataLater$$inlined$execute$1 extends Task {
    final /* synthetic */ Buffer $buffer$inlined;
    final /* synthetic */ int $byteCount$inlined;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $inFinished$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushDataLater$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z3) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$buffer$inlined = buffer;
        this.$byteCount$inlined = i2;
        this.$inFinished$inlined = z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long runOnce() {
        /*
            r5 = this;
            okhttp3.internal.http2.Http2Connection r0 = r5.this$0     // Catch:{ IOException -> 0x0040 }
            okhttp3.internal.http2.PushObserver r0 = r0.pushObserver     // Catch:{ IOException -> 0x0040 }
            int r1 = r5.$streamId$inlined     // Catch:{ IOException -> 0x0040 }
            okio.Buffer r2 = r5.$buffer$inlined     // Catch:{ IOException -> 0x0040 }
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ IOException -> 0x0040 }
            int r3 = r5.$byteCount$inlined     // Catch:{ IOException -> 0x0040 }
            boolean r4 = r5.$inFinished$inlined     // Catch:{ IOException -> 0x0040 }
            boolean r0 = r0.onData(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0040 }
            if (r0 == 0) goto L_0x0023
            okhttp3.internal.http2.Http2Connection r1 = r5.this$0     // Catch:{ IOException -> 0x0040 }
            okhttp3.internal.http2.Http2Writer r1 = r1.getWriter()     // Catch:{ IOException -> 0x0040 }
            int r2 = r5.$streamId$inlined     // Catch:{ IOException -> 0x0040 }
            okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0040 }
            r1.rstStream(r2, r3)     // Catch:{ IOException -> 0x0040 }
        L_0x0023:
            if (r0 != 0) goto L_0x0029
            boolean r0 = r5.$inFinished$inlined     // Catch:{ IOException -> 0x0040 }
            if (r0 == 0) goto L_0x0040
        L_0x0029:
            okhttp3.internal.http2.Http2Connection r0 = r5.this$0     // Catch:{ IOException -> 0x0040 }
            monitor-enter(r0)     // Catch:{ IOException -> 0x0040 }
            okhttp3.internal.http2.Http2Connection r1 = r5.this$0     // Catch:{ all -> 0x003d }
            java.util.Set r1 = r1.currentPushRequests     // Catch:{ all -> 0x003d }
            int r2 = r5.$streamId$inlined     // Catch:{ all -> 0x003d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x003d }
            r1.remove(r2)     // Catch:{ all -> 0x003d }
            monitor-exit(r0)     // Catch:{ IOException -> 0x0040 }
            goto L_0x0040
        L_0x003d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ IOException -> 0x0040 }
            throw r1     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1.runOnce():long");
    }
}
