package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0017\u0010\u0005\u001a\u0013\u0018\u00010\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bH@¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "p1", "Lkotlinx/coroutines/flow/FlowCollector;", "", "p2", "Lkotlin/ParameterName;", "name", "value", "invoke", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
/* compiled from: SafeCollector.kt */
final /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReference implements Function3<FlowCollector<? super Object>, Object, Continuation<? super Unit>, Object>, SuspendFunction {
    SafeCollectorKt$emitFun$1() {
        super(3);
    }

    public final String getName() {
        return "emit";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FlowCollector.class);
    }

    public final String getSignature() {
        return "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;";
    }

    public final Object invoke(FlowCollector<Object> flowCollector, Object obj, Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        Object emit = flowCollector.emit(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return emit;
    }
}
