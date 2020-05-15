package okhttp3.internal.connection;

import kotlin.Metadata;
import okio.AsyncTimeout;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/RealCall$timeout$1", "Lokio/AsyncTimeout;", "timedOut", "", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealCall.kt */
public final class RealCall$timeout$1 extends AsyncTimeout {
    final /* synthetic */ RealCall this$0;

    RealCall$timeout$1(RealCall realCall) {
        this.this$0 = realCall;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        this.this$0.cancel();
    }
}
