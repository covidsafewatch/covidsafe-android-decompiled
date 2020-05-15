package au.gov.health.covidsafe.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0003 \u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bH@"}, d2 = {"retryOkhttpCall", "", "Type", "Params", "call", "Lkotlin/Function0;", "Lokhttp3/Response;", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.interactor.UseCase", f = "UseCase.kt", i = {0, 0, 0, 0, 0}, l = {62}, m = "retryOkhttpCall", n = {"this", "call", "response", "retryCount", "interval"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0"})
/* compiled from: UseCase.kt */
final class UseCase$retryOkhttpCall$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UseCase$retryOkhttpCall$1(UseCase useCase, Continuation continuation) {
        super(continuation);
        this.this$0 = useCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retryOkhttpCall((Function0<Response>) null, this);
    }
}
