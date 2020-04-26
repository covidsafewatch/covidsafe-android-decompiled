package au.gov.health.covidsafe.interactor.usecase;

import au.gov.health.covidsafe.interactor.Either;
import au.gov.health.covidsafe.networking.response.BroadcastMessageResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00060\u0005H@"}, d2 = {"run", "", "params", "Ljava/lang/Void;", "continuation", "Lkotlin/coroutines/Continuation;", "Lau/gov/health/covidsafe/interactor/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff", f = "UpdateBroadcastMessageAndPerformScanWithExponentialBackOff.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {31}, m = "run", n = {"this", "params", "jwtToken", "jwtToken", "response", "retryCount", "interval"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0"})
/* compiled from: UpdateBroadcastMessageAndPerformScanWithExponentialBackOff.kt */
final class UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateBroadcastMessageAndPerformScanWithExponentialBackOff this$0;

    UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1(UpdateBroadcastMessageAndPerformScanWithExponentialBackOff updateBroadcastMessageAndPerformScanWithExponentialBackOff, Continuation continuation) {
        this.this$0 = updateBroadcastMessageAndPerformScanWithExponentialBackOff;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((Void) null, (Continuation<? super Either<? extends Exception, BroadcastMessageResponse>>) this);
    }
}
