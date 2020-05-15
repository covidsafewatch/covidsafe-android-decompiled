package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private SequenceScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.p$ = (SequenceScope) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d4 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x006e
            if (r1 == r6) goto L_0x0059
            if (r1 == r5) goto L_0x004c
            if (r1 == r4) goto L_0x0036
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            java.lang.Object r0 = r14.L$1
            kotlin.collections.RingBuffer r0 = (kotlin.collections.RingBuffer) r0
            goto L_0x0050
        L_0x001c:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0024:
            java.lang.Object r1 = r14.L$1
            kotlin.collections.RingBuffer r1 = (kotlin.collections.RingBuffer) r1
            int r4 = r14.I$1
            int r5 = r14.I$0
            java.lang.Object r7 = r14.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            goto L_0x0189
        L_0x0036:
            java.lang.Object r1 = r14.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r14.L$1
            kotlin.collections.RingBuffer r5 = (kotlin.collections.RingBuffer) r5
            int r7 = r14.I$1
            int r8 = r14.I$0
            java.lang.Object r9 = r14.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            goto L_0x0150
        L_0x004c:
            java.lang.Object r0 = r14.L$1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L_0x0050:
            java.lang.Object r0 = r14.L$0
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x01aa
        L_0x0059:
            java.lang.Object r1 = r14.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r14.L$1
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r3 = r14.I$1
            int r4 = r14.I$0
            java.lang.Object r7 = r14.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r15)
            r8 = r14
            goto L_0x00c1
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.sequences.SequenceScope r15 = r14.p$
            int r1 = r14.$size
            r7 = 1024(0x400, float:1.435E-42)
            int r1 = kotlin.ranges.RangesKt.coerceAtMost((int) r1, (int) r7)
            int r7 = r14.$step
            int r8 = r14.$size
            int r7 = r7 - r8
            if (r7 < 0) goto L_0x00fd
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            r3 = 0
            java.util.Iterator r4 = r14.$iterator
            r8 = r14
            r13 = r4
            r4 = r1
            r1 = r13
        L_0x008e:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x00d4
            java.lang.Object r9 = r1.next()
            if (r3 <= 0) goto L_0x009d
            int r3 = r3 + -1
            goto L_0x008e
        L_0x009d:
            r2.add(r9)
            int r10 = r2.size()
            int r11 = r8.$size
            if (r10 != r11) goto L_0x008e
            r8.L$0 = r15
            r8.I$0 = r4
            r8.I$1 = r7
            r8.L$1 = r2
            r8.I$2 = r3
            r8.L$2 = r9
            r8.L$3 = r1
            r8.label = r6
            java.lang.Object r3 = r15.yield(r2, r8)
            if (r3 != r0) goto L_0x00bf
            return r0
        L_0x00bf:
            r3 = r7
            r7 = r15
        L_0x00c1:
            boolean r15 = r8.$reuseBuffer
            if (r15 == 0) goto L_0x00c9
            r2.clear()
            goto L_0x00d1
        L_0x00c9:
            java.util.ArrayList r15 = new java.util.ArrayList
            int r2 = r8.$size
            r15.<init>(r2)
            r2 = r15
        L_0x00d1:
            r15 = r7
            r7 = r3
            goto L_0x008e
        L_0x00d4:
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x01aa
            boolean r1 = r8.$partialWindows
            if (r1 != 0) goto L_0x00ea
            int r1 = r2.size()
            int r6 = r8.$size
            if (r1 != r6) goto L_0x01aa
        L_0x00ea:
            r8.L$0 = r15
            r8.I$0 = r4
            r8.I$1 = r7
            r8.L$1 = r2
            r8.I$2 = r3
            r8.label = r5
            java.lang.Object r15 = r15.yield(r2, r8)
            if (r15 != r0) goto L_0x01aa
            return r0
        L_0x00fd:
            kotlin.collections.RingBuffer r5 = new kotlin.collections.RingBuffer
            r5.<init>(r1)
            java.util.Iterator r8 = r14.$iterator
            r9 = r15
            r15 = r14
            r13 = r8
            r8 = r1
            r1 = r13
        L_0x0109:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto L_0x0156
            java.lang.Object r10 = r1.next()
            r5.add(r10)
            boolean r11 = r5.isFull()
            if (r11 == 0) goto L_0x0109
            int r11 = r5.size()
            int r12 = r15.$size
            if (r11 >= r12) goto L_0x0129
            kotlin.collections.RingBuffer r5 = r5.expanded(r12)
            goto L_0x0109
        L_0x0129:
            boolean r11 = r15.$reuseBuffer
            if (r11 == 0) goto L_0x0131
            r11 = r5
            java.util.List r11 = (java.util.List) r11
            goto L_0x013b
        L_0x0131:
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = r5
            java.util.Collection r12 = (java.util.Collection) r12
            r11.<init>(r12)
            java.util.List r11 = (java.util.List) r11
        L_0x013b:
            r15.L$0 = r9
            r15.I$0 = r8
            r15.I$1 = r7
            r15.L$1 = r5
            r15.L$2 = r10
            r15.L$3 = r1
            r15.label = r4
            java.lang.Object r10 = r9.yield(r11, r15)
            if (r10 != r0) goto L_0x0150
            return r0
        L_0x0150:
            int r10 = r15.$step
            r5.removeFirst(r10)
            goto L_0x0109
        L_0x0156:
            boolean r1 = r15.$partialWindows
            if (r1 == 0) goto L_0x01aa
            r1 = r5
            r4 = r7
            r5 = r8
            r7 = r9
        L_0x015e:
            int r8 = r1.size()
            int r9 = r15.$step
            if (r8 <= r9) goto L_0x018f
            boolean r8 = r15.$reuseBuffer
            if (r8 == 0) goto L_0x016e
            r8 = r1
            java.util.List r8 = (java.util.List) r8
            goto L_0x0178
        L_0x016e:
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = r1
            java.util.Collection r9 = (java.util.Collection) r9
            r8.<init>(r9)
            java.util.List r8 = (java.util.List) r8
        L_0x0178:
            r15.L$0 = r7
            r15.I$0 = r5
            r15.I$1 = r4
            r15.L$1 = r1
            r15.label = r3
            java.lang.Object r8 = r7.yield(r8, r15)
            if (r8 != r0) goto L_0x0189
            return r0
        L_0x0189:
            int r8 = r15.$step
            r1.removeFirst(r8)
            goto L_0x015e
        L_0x018f:
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x01aa
            r15.L$0 = r7
            r15.I$0 = r5
            r15.I$1 = r4
            r15.L$1 = r1
            r15.label = r2
            java.lang.Object r15 = r7.yield(r1, r15)
            if (r15 != r0) goto L_0x01aa
            return r0
        L_0x01aa:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
