package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements Function2<Integer, Element, Integer> {
    final /* synthetic */ SafeCollector $this_checkContext;

    SafeCollector_commonKt$checkContext$result$1(SafeCollector safeCollector) {
        this.$this_checkContext = safeCollector;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Number) obj).intValue(), (Element) obj2));
    }

    public final int invoke(int i, Element element) {
        Key key = element.getKey();
        Element element2 = this.$this_checkContext.collectContext.get(key);
        if (key != Job.Key) {
            return element != element2 ? Integer.MIN_VALUE : i + 1;
        }
        Job job = (Job) element2;
        if (element != null) {
            Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) element, job);
            if (transitiveCoroutineParent == job) {
                if (job != null) {
                    i++;
                }
                return i;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n");
            sb.append("\t\tChild of ");
            sb.append(transitiveCoroutineParent);
            sb.append(", expected child of ");
            sb.append(job);
            sb.append(".\n");
            sb.append("\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n");
            sb.append("\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'");
            throw new IllegalStateException(sb.toString().toString());
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Job");
    }
}
