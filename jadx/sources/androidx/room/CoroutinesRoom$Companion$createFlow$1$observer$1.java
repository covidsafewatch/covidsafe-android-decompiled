package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/room/CoroutinesRoom$Companion$createFlow$1$observer$1", "Landroidx/room/InvalidationTracker$Observer;", "onInvalidated", "", "tables", "", "", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: CoroutinesRoom.kt */
public final class CoroutinesRoom$Companion$createFlow$1$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ Channel $observerChannel;
    final /* synthetic */ CoroutinesRoom$Companion$createFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$createFlow$1$observer$1(CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1, Channel channel, String[] strArr) {
        super(strArr);
        this.this$0 = coroutinesRoom$Companion$createFlow$1;
        this.$observerChannel = channel;
    }

    public void onInvalidated(Set<String> set) {
        Intrinsics.checkParameterIsNotNull(set, "tables");
        this.$observerChannel.offer(Unit.INSTANCE);
    }
}
