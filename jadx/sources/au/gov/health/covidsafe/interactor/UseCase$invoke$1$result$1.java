package au.gov.health.covidsafe.interactor;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0006\b\u0000\u0010\u0004 \u0001\"\u0006\b\u0001\u0010\u0005 \u0000*\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lau/gov/health/covidsafe/interactor/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.interactor.UseCase$invoke$1$result$1", f = "UseCase.kt", i = {0}, l = {26}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
/* compiled from: UseCase.kt */
final class UseCase$invoke$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Exception, ? extends Type>>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ UseCase$invoke$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UseCase$invoke$1$result$1(UseCase$invoke$1 useCase$invoke$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = useCase$invoke$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        UseCase$invoke$1$result$1 useCase$invoke$1$result$1 = new UseCase$invoke$1$result$1(this.this$0, continuation);
        useCase$invoke$1$result$1.p$ = (CoroutineScope) obj;
        return useCase$invoke$1$result$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UseCase$invoke$1$result$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            UseCase useCase = this.this$0.this$0;
            Object obj2 = this.this$0.$params;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = useCase.run(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
