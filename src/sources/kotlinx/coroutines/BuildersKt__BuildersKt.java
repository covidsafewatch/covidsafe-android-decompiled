package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 16}, xs = "kotlinx/coroutines/BuildersKt")
/* compiled from: Builders.kt */
final /* synthetic */ class BuildersKt__BuildersKt {
    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }

    public static final <T> T runBlocking(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        CoroutineContext coroutineContext2;
        EventLoop eventLoop;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            coroutineContext2 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, coroutineContext.plus(eventLoop));
        } else {
            EventLoop eventLoop2 = null;
            if (!(continuationInterceptor instanceof EventLoop)) {
                continuationInterceptor = null;
            }
            EventLoop eventLoop3 = (EventLoop) continuationInterceptor;
            if (eventLoop3 != null) {
                if (eventLoop3.shouldBeProcessedFromContext()) {
                    eventLoop2 = eventLoop3;
                }
                if (eventLoop2 != null) {
                    eventLoop = eventLoop2;
                    coroutineContext2 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, coroutineContext);
                }
            }
            eventLoop = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            coroutineContext2 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, coroutineContext);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContext2, currentThread, eventLoop);
        blockingCoroutine.start(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return blockingCoroutine.joinBlocking();
    }
}
