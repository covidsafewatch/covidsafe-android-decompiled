package okhttp3.internal.http2;

import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$pushHeadersLater$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $inFinished$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ List $requestHeaders$inlined;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushHeadersLater$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection http2Connection, int i, List list, boolean z3) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$requestHeaders$inlined = list;
        this.$inFinished$inlined = z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long runOnce() {
        /*
            r4 = this;
            okhttp3.internal.http2.Http2Connection r0 = r4.this$0
            okhttp3.internal.http2.PushObserver r0 = r0.pushObserver
            int r1 = r4.$streamId$inlined
            java.util.List r2 = r4.$requestHeaders$inlined
            boolean r3 = r4.$inFinished$inlined
            boolean r0 = r0.onHeaders(r1, r2, r3)
            if (r0 == 0) goto L_0x001f
            okhttp3.internal.http2.Http2Connection r1 = r4.this$0     // Catch:{ IOException -> 0x003c }
            okhttp3.internal.http2.Http2Writer r1 = r1.getWriter()     // Catch:{ IOException -> 0x003c }
            int r2 = r4.$streamId$inlined     // Catch:{ IOException -> 0x003c }
            okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x003c }
            r1.rstStream(r2, r3)     // Catch:{ IOException -> 0x003c }
        L_0x001f:
            if (r0 != 0) goto L_0x0025
            boolean r0 = r4.$inFinished$inlined     // Catch:{ IOException -> 0x003c }
            if (r0 == 0) goto L_0x003c
        L_0x0025:
            okhttp3.internal.http2.Http2Connection r0 = r4.this$0     // Catch:{ IOException -> 0x003c }
            monitor-enter(r0)     // Catch:{ IOException -> 0x003c }
            okhttp3.internal.http2.Http2Connection r1 = r4.this$0     // Catch:{ all -> 0x0039 }
            java.util.Set r1 = r1.currentPushRequests     // Catch:{ all -> 0x0039 }
            int r2 = r4.$streamId$inlined     // Catch:{ all -> 0x0039 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0039 }
            r1.remove(r2)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ IOException -> 0x003c }
            goto L_0x003c
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ IOException -> 0x003c }
            throw r1     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$1.runOnce():long");
    }
}
