package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {143}, m = "invokeSuspend", n = {"$this$coroutineScope", "firstChannel", "secondChannel", "firstValue", "secondValue", "firstIsClosed", "secondIsClosed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* compiled from: Combine.kt */
final class CombineKt$combineTransformInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $first;
    final /* synthetic */ Flow $second;
    final /* synthetic */ FlowCollector $this_combineTransformInternal;
    final /* synthetic */ Function4 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineTransformInternal$2(FlowCollector flowCollector, Flow flow, Flow flow2, Function4 function4, Continuation continuation) {
        super(2, continuation);
        this.$this_combineTransformInternal = flowCollector;
        this.$first = flow;
        this.$second = flow2;
        this.$transform = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$2 = new CombineKt$combineTransformInternal$2(this.$this_combineTransformInternal, this.$first, this.$second, this.$transform, continuation);
        combineKt$combineTransformInternal$2.p$ = (CoroutineScope) obj;
        return combineKt$combineTransformInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineTransformInternal$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(1:(2:3|41)(2:4|5))(1:6)|7|(13:13|14|15|16|17|18|(1:20)(4:21|22|23|24)|25|(1:27)(1:28)|35|(1:37)|(1:39)(4:40|41|7|(0)(2:11|12))|39)(0)|9|13|14|15|16|17|18|(0)(0)|25|(0)(0)|35|(0)|(0)|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0132, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0134, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0136, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0137, code lost:
        r3 = r6;
        r19 = r7;
        r20 = r8;
        r21 = r9;
        r22 = r10;
        r23 = r11;
        r24 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0144, code lost:
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0146, code lost:
        r3.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cd A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d0 A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0110 A[Catch:{ all -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0111 A[Catch:{ all -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0158 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            r26 = this;
            r1 = r26
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r2 = r1.L$7
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2 r2 = (kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2) r2
            java.lang.Object r2 = r1.L$6
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r4 = r1.L$5
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r5 = r1.L$4
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r27)
            r14 = r2
            r15 = r4
            r13 = r5
            r12 = r6
            r11 = r7
            r10 = r8
            r2 = r0
            r8 = r1
            goto L_0x0165
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r27)
            kotlinx.coroutines.CoroutineScope r2 = r1.p$
            kotlinx.coroutines.flow.Flow r4 = r1.$first
            kotlinx.coroutines.channels.ReceiveChannel r4 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r4)
            kotlinx.coroutines.flow.Flow r5 = r1.$second
            kotlinx.coroutines.channels.ReceiveChannel r5 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r5)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r7 = 0
            r6.element = r7
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r8.element = r7
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r9 = 0
            r7.element = r9
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef
            r10.<init>()
            r10.element = r9
            r9 = r2
            r11 = r5
            r12 = r6
            r15 = r7
            r13 = r8
            r14 = r10
            r2 = r0
            r8 = r1
            r10 = r4
        L_0x007a:
            boolean r0 = r15.element
            if (r0 == 0) goto L_0x0086
            boolean r0 = r14.element
            if (r0 != 0) goto L_0x0083
            goto L_0x0086
        L_0x0083:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0086:
            r8.L$0 = r9
            r8.L$1 = r10
            r8.L$2 = r11
            r8.L$3 = r12
            r8.L$4 = r13
            r8.L$5 = r15
            r8.L$6 = r14
            r8.L$7 = r8
            r8.label = r3
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            kotlinx.coroutines.selects.SelectBuilderImpl r6 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r6.<init>(r7)
            r0 = r6
            kotlinx.coroutines.selects.SelectBuilder r0 = (kotlinx.coroutines.selects.SelectBuilder) r0     // Catch:{ all -> 0x0136 }
            boolean r5 = r15.element     // Catch:{ all -> 0x0136 }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 r16 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1     // Catch:{ all -> 0x0136 }
            r17 = 0
            r4 = r16
            r18 = r5
            r5 = r17
            r3 = r6
            r6 = r8
            r19 = r7
            r7 = r15
            r20 = r8
            r8 = r10
            r21 = r9
            r9 = r12
            r22 = r10
            r10 = r13
            r23 = r11
            r11 = r14
            r24 = r12
            r12 = r23
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0134 }
            r5 = r16
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x0134 }
            if (r18 == 0) goto L_0x00d0
            r18 = r13
            goto L_0x00f4
        L_0x00d0:
            kotlinx.coroutines.selects.SelectClause1 r12 = r22.getOnReceiveOrNull()     // Catch:{ all -> 0x0134 }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$2 r16 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$2     // Catch:{ all -> 0x0134 }
            r6 = 0
            r4 = r16
            r7 = r20
            r8 = r15
            r9 = r22
            r10 = r24
            r11 = r13
            r25 = r12
            r12 = r14
            r18 = r13
            r13 = r23
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0132 }
            r4 = r16
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ all -> 0x0132 }
            r5 = r25
            r0.invoke(r5, r4)     // Catch:{ all -> 0x0132 }
        L_0x00f4:
            boolean r13 = r14.element     // Catch:{ all -> 0x0132 }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 r16 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3     // Catch:{ all -> 0x0132 }
            r5 = 0
            r4 = r16
            r6 = r20
            r7 = r15
            r8 = r22
            r9 = r24
            r10 = r18
            r11 = r14
            r12 = r23
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0132 }
            r5 = r16
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x0132 }
            if (r13 == 0) goto L_0x0111
            goto L_0x0149
        L_0x0111:
            kotlinx.coroutines.selects.SelectClause1 r13 = r23.getOnReceiveOrNull()     // Catch:{ all -> 0x0132 }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4 r16 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4     // Catch:{ all -> 0x0132 }
            r6 = 0
            r4 = r16
            r7 = r20
            r8 = r15
            r9 = r22
            r10 = r24
            r11 = r18
            r12 = r14
            r1 = r13
            r13 = r23
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0132 }
            r4 = r16
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ all -> 0x0132 }
            r0.invoke(r1, r4)     // Catch:{ all -> 0x0132 }
            goto L_0x0149
        L_0x0132:
            r0 = move-exception
            goto L_0x0146
        L_0x0134:
            r0 = move-exception
            goto L_0x0144
        L_0x0136:
            r0 = move-exception
            r3 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r12
        L_0x0144:
            r18 = r13
        L_0x0146:
            r3.handleBuilderException(r0)
        L_0x0149:
            java.lang.Object r0 = r3.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x0156
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r19)
        L_0x0156:
            if (r0 != r2) goto L_0x0159
            return r2
        L_0x0159:
            r13 = r18
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
        L_0x0165:
            r3 = 1
            r1 = r26
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
