package androidx.lifecycle;

import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "close", "", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ViewModel.kt */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(CoroutineContext coroutineContext2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext2, "context");
        this.coroutineContext = coroutineContext2;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public void close() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
