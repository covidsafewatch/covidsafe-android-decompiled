package au.gov.health.covidsafe.ui.splash;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.ui.splash.SplashViewModel$setupUI$1", f = "SplashViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {66, 67}, m = "invokeSuspend", n = {"$this$launch", "splashScreenCoroutine", "migratingCoroutine", "$this$launch", "splashScreenCoroutine", "migratingCoroutine"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: SplashViewModel.kt */
final class SplashViewModel$setupUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SplashViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplashViewModel$setupUI$1(SplashViewModel splashViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = splashViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SplashViewModel$setupUI$1 splashViewModel$setupUI$1 = new SplashViewModel$setupUI$1(this.this$0, continuation);
        splashViewModel$setupUI$1.p$ = (CoroutineScope) obj;
        return splashViewModel$setupUI$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SplashViewModel$setupUI$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Deferred deferred;
        Deferred deferred2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new SplashViewModel$setupUI$1$splashScreenCoroutine$1(this, (Continuation) null), 2, (Object) null);
            deferred2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new SplashViewModel$setupUI$1$migratingCoroutine$1(this, (Continuation) null), 2, (Object) null);
            this.L$0 = coroutineScope;
            this.L$1 = async$default;
            this.L$2 = deferred2;
            this.label = 1;
            if (async$default.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default;
        } else if (i == 1) {
            deferred2 = (Deferred) this.L$2;
            deferred = (Deferred) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Deferred deferred3 = (Deferred) this.L$2;
            Deferred deferred4 = (Deferred) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = coroutineScope;
        this.L$1 = deferred;
        this.L$2 = deferred2;
        this.label = 2;
        if (deferred2.join(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
