package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0086
            if (r2 == r5) goto L_0x006d
            if (r2 == r4) goto L_0x0054
            if (r2 != r3) goto L_0x004c
            java.lang.Object r11 = r0.L$5
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object r1 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r1 = (kotlinx.coroutines.flow.internal.SafeCollector) r1
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r2 = r0.L$2
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0049 }
            goto L_0x00c8
        L_0x0049:
            r11 = move-exception
            goto L_0x00d3
        L_0x004c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0054:
            java.lang.Object r11 = r0.L$4
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object r1 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r1 = r0.L$2
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00f9
        L_0x006d:
            java.lang.Object r11 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r2 = r0.L$2
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r6
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00dc
        L_0x0086:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            kotlinx.coroutines.flow.Flow r12 = r10.$this_onCompletion$inlined     // Catch:{ all -> 0x00d7 }
            r0.L$0 = r10     // Catch:{ all -> 0x00d7 }
            r0.L$1 = r11     // Catch:{ all -> 0x00d7 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d7 }
            r0.L$3 = r11     // Catch:{ all -> 0x00d7 }
            r0.label = r5     // Catch:{ all -> 0x00d7 }
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.catchImpl(r12, r11, r0)     // Catch:{ all -> 0x00d7 }
            if (r12 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r6 = r10
            r5 = r11
        L_0x00a1:
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x0081 }
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r7 = new kotlinx.coroutines.flow.internal.SafeCollector
            r7.<init>(r11, r4)
            r4 = r7
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4     // Catch:{ all -> 0x00d1 }
            kotlin.jvm.functions.Function3 r8 = r6.$action$inlined     // Catch:{ all -> 0x00d1 }
            r0.L$0 = r6     // Catch:{ all -> 0x00d1 }
            r0.L$1 = r5     // Catch:{ all -> 0x00d1 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d1 }
            r0.L$3 = r11     // Catch:{ all -> 0x00d1 }
            r0.L$4 = r7     // Catch:{ all -> 0x00d1 }
            r0.L$5 = r12     // Catch:{ all -> 0x00d1 }
            r0.label = r3     // Catch:{ all -> 0x00d1 }
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(r4, r8, r12, r0)     // Catch:{ all -> 0x00d1 }
            if (r11 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            r11 = r12
            r1 = r7
        L_0x00c8:
            r1.releaseIntercepted()
            if (r11 != 0) goto L_0x00d0
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00d0:
            throw r11
        L_0x00d1:
            r11 = move-exception
            r1 = r7
        L_0x00d3:
            r1.releaseIntercepted()
            throw r11
        L_0x00d7:
            r12 = move-exception
            r6 = r10
            r5 = r11
            r11 = r12
            r12 = r5
        L_0x00dc:
            kotlinx.coroutines.flow.ThrowingCollector r3 = new kotlinx.coroutines.flow.ThrowingCollector
            r3.<init>(r11)
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.jvm.functions.Function3 r7 = r6.$action$inlined
            r8 = 0
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r12
            r0.L$4 = r11
            r0.label = r4
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(r3, r7, r8, r0)
            if (r12 != r1) goto L_0x00f9
            return r1
        L_0x00f9:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
