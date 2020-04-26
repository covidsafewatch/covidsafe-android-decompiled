package au.gov.health.covidsafe.interactor.usecase;

import androidx.lifecycle.Lifecycle;
import au.gov.health.covidsafe.interactor.Either;
import au.gov.health.covidsafe.interactor.Failure;
import au.gov.health.covidsafe.interactor.Success;
import au.gov.health.covidsafe.interactor.UseCase;
import au.gov.health.covidsafe.interactor.usecase.GetUploadOtpException;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.networking.response.UploadOTPResponse;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\n\u001a\u0014\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;", "Lau/gov/health/covidsafe/interactor/UseCase;", "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;", "", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V", "TAG", "run", "Lau/gov/health/covidsafe/interactor/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "params", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GetUploadOtp.kt */
public final class GetUploadOtp extends UseCase<UploadOTPResponse, String> {
    private final String TAG;
    private final AwsClient awsClient;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetUploadOtp(AwsClient awsClient2, Lifecycle lifecycle) {
        super(lifecycle);
        Intrinsics.checkParameterIsNotNull(awsClient2, "awsClient");
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        this.awsClient = awsClient2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
    }

    public Object run(String str, Continuation<? super Either<? extends Exception, UploadOTPResponse>> continuation) {
        try {
            AwsClient awsClient2 = this.awsClient;
            Response<UploadOTPResponse> execute = awsClient2.requestUploadOtp("Bearer " + str).execute();
            if (execute.code() != 200) {
                return new Failure(new GetUploadOtpException.GetUploadOtpServiceException(Boxing.boxInt(execute.code())));
            }
            CentralLog.Companion.d(this.TAG, "onCodeUpload");
            return new Success(execute.body());
        } catch (Exception e) {
            return new Failure(e);
        }
    }
}
