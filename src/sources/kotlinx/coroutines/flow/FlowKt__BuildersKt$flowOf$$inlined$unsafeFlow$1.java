package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Object[] $elements$inlined;

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.$elements$inlined = objArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 != r3) goto L_0x004a
            java.lang.Object r10 = r0.L$5
            int r10 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$4
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r5 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r8 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1) r8
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r5
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            r0 = r7
            goto L_0x0081
        L_0x004a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            java.lang.Object[] r2 = r9.$elements$inlined
            int r4 = r2.length
            r5 = 0
            r8 = r9
            r6 = r11
            r11 = r10
            r10 = r5
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r11
        L_0x0064:
            if (r10 >= r4) goto L_0x0083
            r7 = r5[r10]
            r1.L$0 = r8
            r1.L$1 = r0
            r1.L$2 = r6
            r1.L$3 = r11
            r1.L$4 = r5
            r1.I$0 = r4
            r1.I$1 = r10
            r1.L$5 = r7
            r1.label = r3
            java.lang.Object r7 = r11.emit(r7, r1)
            if (r7 != r2) goto L_0x0081
            return r2
        L_0x0081:
            int r10 = r10 + r3
            goto L_0x0064
        L_0x0083:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
