package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/CoroutinesInternalError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Exceptions.common.kt */
public final class CoroutinesInternalError extends Error {
    public CoroutinesInternalError(String str, Throwable th) {
        super(str, th);
    }
}
