package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {143}, m = "invokeSuspend", n = {"$this$coroutineScope", "size", "channels", "latestValues", "isClosed", "nonClosed", "remainingNulls"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, continuation);
        combineKt$combineInternal$2.p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            r29 = this;
            r1 = r29
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            java.lang.Object r2 = r1.L$6
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2 r2 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2) r2
            java.lang.Object r2 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r5 = r1.L$4
            kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
            java.lang.Object r6 = r1.L$3
            java.lang.Boolean[] r6 = (java.lang.Boolean[]) r6
            java.lang.Object r7 = r1.L$2
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            java.lang.Object r8 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel[] r8 = (kotlinx.coroutines.channels.ReceiveChannel[]) r8
            int r9 = r1.I$0
            java.lang.Object r10 = r1.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlin.ResultKt.throwOnFailure(r30)
            r15 = r2
            r14 = r5
            r13 = r6
            r12 = r7
            r11 = r8
            r2 = r0
            r8 = r1
            r28 = r10
            r10 = r9
            r9 = r28
            goto L_0x017d
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r30)
            kotlinx.coroutines.CoroutineScope r2 = r1.p$
            kotlinx.coroutines.flow.Flow[] r5 = r1.$flows
            int r5 = r5.length
            kotlinx.coroutines.channels.ReceiveChannel[] r6 = new kotlinx.coroutines.channels.ReceiveChannel[r5]
            r7 = r3
        L_0x0050:
            if (r7 >= r5) goto L_0x0069
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            kotlinx.coroutines.flow.Flow[] r9 = r1.$flows
            r8 = r9[r8]
            kotlinx.coroutines.channels.ReceiveChannel r8 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r8)
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0050
        L_0x0069:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Boolean[] r8 = new java.lang.Boolean[r5]
            r9 = r3
        L_0x006e:
            if (r9 >= r5) goto L_0x0082
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.Number r10 = (java.lang.Number) r10
            r10.intValue()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x006e
        L_0x0082:
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            r9.element = r5
            kotlin.jvm.internal.Ref$IntRef r10 = new kotlin.jvm.internal.Ref$IntRef
            r10.<init>()
            r10.element = r5
            r11 = r6
            r12 = r7
            r13 = r8
            r14 = r9
            r15 = r10
            r8 = r1
            r9 = r2
            r10 = r5
            r2 = r0
        L_0x0099:
            int r0 = r14.element
            if (r0 == 0) goto L_0x0181
            r8.L$0 = r9
            r8.I$0 = r10
            r8.L$1 = r11
            r8.L$2 = r12
            r8.L$3 = r13
            r8.L$4 = r14
            r8.L$5 = r15
            r8.L$6 = r8
            r8.label = r4
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            kotlinx.coroutines.selects.SelectBuilderImpl r6 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r6.<init>(r7)
            r0 = r6
            kotlinx.coroutines.selects.SelectBuilder r0 = (kotlinx.coroutines.selects.SelectBuilder) r0     // Catch:{ all -> 0x0146 }
            r5 = r3
        L_0x00bb:
            if (r5 >= r10) goto L_0x0132
            r16 = r13[r5]     // Catch:{ all -> 0x0146 }
            boolean r16 = r16.booleanValue()     // Catch:{ all -> 0x0146 }
            r17 = r11[r5]     // Catch:{ all -> 0x0146 }
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 r18 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1     // Catch:{ all -> 0x0146 }
            r19 = 0
            r20 = r5
            r5 = r18
            r3 = r6
            r6 = r20
            r21 = r7
            r7 = r19
            r19 = r8
            r22 = r9
            r9 = r10
            r23 = r10
            r10 = r13
            r24 = r11
            r25 = r12
            r26 = r13
            r13 = r15
            r27 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0130 }
            r6 = r18
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x0130 }
            if (r16 == 0) goto L_0x00f1
            r18 = r15
            goto L_0x0116
        L_0x00f1:
            kotlinx.coroutines.selects.SelectClause1 r14 = r17.getOnReceiveOrNull()     // Catch:{ all -> 0x0130 }
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 r16 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2     // Catch:{ all -> 0x0130 }
            r7 = 0
            r5 = r16
            r8 = r20
            r9 = r19
            r10 = r23
            r11 = r26
            r12 = r24
            r13 = r25
            r4 = r14
            r14 = r15
            r18 = r15
            r15 = r27
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x012e }
            r5 = r16
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x012e }
            r0.invoke(r4, r5)     // Catch:{ all -> 0x012e }
        L_0x0116:
            int r5 = r20 + 1
            r6 = r3
            r15 = r18
            r8 = r19
            r7 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r3 = 0
            r4 = 1
            goto L_0x00bb
        L_0x012e:
            r0 = move-exception
            goto L_0x015a
        L_0x0130:
            r0 = move-exception
            goto L_0x0158
        L_0x0132:
            r3 = r6
            r21 = r7
            r19 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r13
            r27 = r14
            r18 = r15
            goto L_0x015d
        L_0x0146:
            r0 = move-exception
            r3 = r6
            r21 = r7
            r19 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r13
            r27 = r14
        L_0x0158:
            r18 = r15
        L_0x015a:
            r3.handleBuilderException(r0)
        L_0x015d:
            java.lang.Object r0 = r3.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x016a
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r21)
        L_0x016a:
            if (r0 != r2) goto L_0x016d
            return r2
        L_0x016d:
            r15 = r18
            r8 = r19
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
        L_0x017d:
            r3 = 0
            r4 = 1
            goto L_0x0099
        L_0x0181:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
