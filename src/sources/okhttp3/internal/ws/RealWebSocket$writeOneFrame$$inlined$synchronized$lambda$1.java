package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.concurrent.Task;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp", "okhttp3/internal/ws/RealWebSocket$$special$$inlined$execute$1"}, k = 1, mv = {1, 1, 16})
/* compiled from: TaskQueue.kt */
public final class RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ Ref.ObjectRef $messageOrClose$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ ByteString $pong$inlined;
    final /* synthetic */ Ref.IntRef $receivedCloseCode$inlined;
    final /* synthetic */ Ref.ObjectRef $receivedCloseReason$inlined;
    final /* synthetic */ Ref.ObjectRef $streamsToClose$inlined;
    final /* synthetic */ WebSocketWriter $writer$inlined;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(String str, boolean z, String str2, boolean z2, RealWebSocket realWebSocket, WebSocketWriter webSocketWriter, ByteString byteString, Ref.ObjectRef objectRef, Ref.IntRef intRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = realWebSocket;
        this.$writer$inlined = webSocketWriter;
        this.$pong$inlined = byteString;
        this.$messageOrClose$inlined = objectRef;
        this.$receivedCloseCode$inlined = intRef;
        this.$receivedCloseReason$inlined = objectRef2;
        this.$streamsToClose$inlined = objectRef3;
    }

    public long runOnce() {
        this.this$0.cancel();
        return -1;
    }
}
