package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache.Editor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/io/IOException;", "invoke", "okhttp3/internal/cache/DiskLruCache$Editor$newSink$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: DiskLruCache.kt */
final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends Lambda implements Function1<IOException, Unit> {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ Editor this$0;

    DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(Editor editor, int i) {
        this.this$0 = editor;
        this.$index$inlined = i;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$okhttp();
            Unit unit = Unit.INSTANCE;
        }
    }
}
