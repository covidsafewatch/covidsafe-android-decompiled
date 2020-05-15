package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onStart$inlined;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0063
            if (r2 == r4) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.L$2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r8 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a4
        L_0x0041:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0049:
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.L$2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0061 }
            goto L_0x008c
        L_0x0061:
            r9 = move-exception
            goto L_0x00a9
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r5 = new kotlinx.coroutines.flow.internal.SafeCollector
            r5.<init>(r8, r2)
            kotlin.jvm.functions.Function2 r2 = r7.$action$inlined     // Catch:{ all -> 0x00a7 }
            r0.L$0 = r7     // Catch:{ all -> 0x00a7 }
            r0.L$1 = r8     // Catch:{ all -> 0x00a7 }
            r0.L$2 = r9     // Catch:{ all -> 0x00a7 }
            r0.L$3 = r8     // Catch:{ all -> 0x00a7 }
            r0.L$4 = r5     // Catch:{ all -> 0x00a7 }
            r0.label = r4     // Catch:{ all -> 0x00a7 }
            java.lang.Object r2 = r2.invoke(r5, r0)     // Catch:{ all -> 0x00a7 }
            if (r2 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r6 = r7
            r2 = r8
            r4 = r9
            r8 = r5
            r5 = r2
        L_0x008c:
            r8.releaseIntercepted()
            kotlinx.coroutines.flow.Flow r9 = r6.$this_onStart$inlined
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r8 = r9.collect(r2, r0)
            if (r8 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a7:
            r9 = move-exception
            r8 = r5
        L_0x00a9:
            r8.releaseIntercepted()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_onStart$inlined = flow;
        this.$action$inlined = function2;
    }
}
