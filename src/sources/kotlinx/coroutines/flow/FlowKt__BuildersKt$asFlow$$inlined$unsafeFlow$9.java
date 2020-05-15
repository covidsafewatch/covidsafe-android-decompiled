package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 implements Flow<Integer> {
    final /* synthetic */ IntRange $this_asFlow$inlined;

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(IntRange intRange) {
        this.$this_asFlow$inlined = intRange;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 != r3) goto L_0x004b
            int r11 = r0.I$0
            java.lang.Object r11 = r0.L$6
            java.lang.Object r11 = r0.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$4
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            java.lang.Object r5 = r0.L$2
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 r7 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9) r7
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            r0 = r6
            goto L_0x0069
        L_0x004b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r0
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            kotlin.ranges.IntRange r2 = r10.$this_asFlow$inlined
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r4 = r2.iterator()
            r7 = r10
            r5 = r12
            r12 = r11
            r11 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            r0 = r12
        L_0x0069:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L_0x0097
            java.lang.Object r6 = r11.next()
            r8 = r6
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r1.L$0 = r7
            r1.L$1 = r0
            r1.L$2 = r5
            r1.L$3 = r12
            r1.L$4 = r4
            r1.L$5 = r11
            r1.L$6 = r6
            r1.I$0 = r8
            r1.label = r3
            java.lang.Object r6 = r12.emit(r9, r1)
            if (r6 != r2) goto L_0x0069
            return r2
        L_0x0097:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
