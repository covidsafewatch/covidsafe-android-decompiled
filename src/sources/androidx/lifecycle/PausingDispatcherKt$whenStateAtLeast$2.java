package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0, 0, 0, 0}, l = {163}, m = "invokeSuspend", n = {"$this$withContext", "job", "dispatcher", "controller"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: PausingDispatcher.kt */
final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, continuation);
        pausingDispatcherKt$whenStateAtLeast$2.p$ = (CoroutineScope) obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LifecycleController lifecycleController;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
            if (job != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, job);
                try {
                    Function2 function2 = this.$block;
                    this.L$0 = coroutineScope;
                    this.L$1 = job;
                    this.L$2 = pausingDispatcher;
                    this.L$3 = lifecycleController2;
                    this.label = 1;
                    obj = BuildersKt.withContext(pausingDispatcher, function2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i == 1) {
            lifecycleController = (LifecycleController) this.L$3;
            PausingDispatcher pausingDispatcher2 = (PausingDispatcher) this.L$2;
            Job job2 = (Job) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.finish();
        return obj;
    }
}
