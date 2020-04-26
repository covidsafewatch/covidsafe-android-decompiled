package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ThreadContext.kt */
final class ThreadContextKt$countAll$1 extends Lambda implements Function2<Object, Element, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    ThreadContextKt$countAll$1() {
        super(2);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.coroutines.CoroutineContext$Element, code=java.lang.Object, for r3v0, types: [kotlin.coroutines.CoroutineContext$Element, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
        /*
            r1 = this;
            boolean r0 = r3 instanceof kotlinx.coroutines.ThreadContextElement
            if (r0 == 0) goto L_0x001d
            boolean r0 = r2 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0009
            r2 = 0
        L_0x0009:
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0 = 1
            if (r2 == 0) goto L_0x0013
            int r2 = r2.intValue()
            goto L_0x0014
        L_0x0013:
            r2 = r0
        L_0x0014:
            if (r2 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            int r2 = r2 + r0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
        L_0x001c:
            return r3
        L_0x001d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadContextKt$countAll$1.invoke(java.lang.Object, kotlin.coroutines.CoroutineContext$Element):java.lang.Object");
    }
}
