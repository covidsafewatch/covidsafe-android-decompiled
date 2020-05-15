package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bB\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H¦\u0002¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "()V", "invoke", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: CompletionHandler.kt */
public abstract class CompletionHandlerBase extends LockFreeLinkedListNode implements Function1<Throwable, Unit> {
    public abstract void invoke(Throwable th);
}
