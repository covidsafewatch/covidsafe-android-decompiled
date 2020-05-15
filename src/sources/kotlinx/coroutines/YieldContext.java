package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/YieldContext;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "()V", "dispatcherWasUnconfined", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Unconfined.kt */
public final class YieldContext extends AbstractCoroutineContextElement {
    public static final Key Key = new Key((DefaultConstructorMarker) null);
    public boolean dispatcherWasUnconfined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/YieldContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/YieldContext;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Unconfined.kt */
    public static final class Key implements CoroutineContext.Key<YieldContext> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public YieldContext() {
        super(Key);
    }
}
