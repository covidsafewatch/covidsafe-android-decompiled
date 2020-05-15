package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001an\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00032(\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f*\u00020\u00102\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f*\u00020\u00102\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u0001\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00040\u00152\u0014\u0010\u0016\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00030\u00172\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00140\u00170\u001929\u0010\t\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a¢\u0001\u0010\u001c\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00032W\u0010\t\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0015\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001f¢\u0006\u0002\b\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010$\u001av\u0010%\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00130&2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u001923\b\b\u0010%\u001a-\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0+H\bø\u0001\u0000¢\u0006\u0002\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"getNull", "Lkotlinx/coroutines/internal/Symbol;", "zipImpl", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "flow", "flow2", "transform", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "asChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "asFairChannel", "combineInternal", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "flows", "", "arrayFactory", "Lkotlin/Function0;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "combineTransformInternal", "first", "second", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceive", "Lkotlinx/coroutines/selects/SelectBuilder;", "isClosed", "", "channel", "onClosed", "Lkotlin/Function2;", "value", "(Lkotlinx/coroutines/selects/SelectBuilder;ZLkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: Combine.kt */
public final class CombineKt {
    public static final Symbol getNull() {
        return NullSurrogateKt.NULL;
    }

    public static final <T1, T2, R> Object combineTransformInternal(FlowCollector<? super R> flowCollector, Flow<? extends T1> flow, Flow<? extends T2> flow2, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$combineTransformInternal$2(flowCollector, flow, flow2, function4, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static final <R, T> Object combineInternal(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$combineInternal$2(flowCollector, flowArr, function0, function3, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onReceive(SelectBuilder<? super Unit> selectBuilder, boolean z, ReceiveChannel<? extends Object> receiveChannel, Function0<Unit> function0, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (!z) {
            selectBuilder.invoke((SelectClause1<? extends Q>) receiveChannel.getOnReceiveOrNull(), (Function2<? super Q, ? super Continuation<? super Object>, ? extends Object>) new CombineKt$onReceive$1(function0, function2, (Continuation) null));
        }
    }

    /* access modifiers changed from: private */
    public static final ReceiveChannel<Object> asFairChannel(CoroutineScope coroutineScope, Flow<?> flow) {
        return ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, 0, new CombineKt$asFairChannel$1(flow, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final ReceiveChannel<Object> asChannel(CoroutineScope coroutineScope, Flow<?> flow) {
        return ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, 0, new CombineKt$asChannel$1(flow, (Continuation) null), 3, (Object) null);
    }

    public static final <T1, T2, R> Flow<R> zipImpl(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new CombineKt$zipImpl$$inlined$unsafeFlow$1(flow, flow2, function3);
    }
}
