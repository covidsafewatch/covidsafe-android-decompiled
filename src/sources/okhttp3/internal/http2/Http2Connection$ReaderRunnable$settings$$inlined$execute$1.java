package okhttp3.internal.http2;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$ReaderRunnable$settings$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $clearPrevious$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ Settings $settings$inlined;
    final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$settings$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection.ReaderRunnable readerRunnable, boolean z3, Settings settings) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = readerRunnable;
        this.$clearPrevious$inlined = z3;
        this.$settings$inlined = settings;
    }

    public long runOnce() {
        this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
        return -1;
    }
}
