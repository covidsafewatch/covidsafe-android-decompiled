package au.gov.health.covidsafe.interactor.usecase;

import androidx.lifecycle.Lifecycle;
import au.gov.health.covidsafe.interactor.Either;
import au.gov.health.covidsafe.interactor.Failure;
import au.gov.health.covidsafe.interactor.Success;
import au.gov.health.covidsafe.interactor.UseCase;
import au.gov.health.covidsafe.interactor.usecase.GetOnboardingOtpException;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.networking.request.OTPChallengeRequest;
import au.gov.health.covidsafe.networking.response.OTPChallengeResponse;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;", "Lau/gov/health/covidsafe/interactor/UseCase;", "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;", "Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V", "TAG", "", "run", "Lau/gov/health/covidsafe/interactor/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "params", "(Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GetOnboardingOtp.kt */
public final class GetOnboardingOtp extends UseCase<OTPChallengeResponse, GetOtpParams> {
    private final String TAG;
    private final AwsClient awsClient;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetOnboardingOtp(AwsClient awsClient2, Lifecycle lifecycle) {
        super(lifecycle);
        Intrinsics.checkParameterIsNotNull(awsClient2, "awsClient");
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        this.awsClient = awsClient2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
    }

    public Object run(GetOtpParams getOtpParams, Continuation<? super Either<? extends Exception, OTPChallengeResponse>> continuation) {
        try {
            Response<OTPChallengeResponse> execute = this.awsClient.initiateAuth(new OTPChallengeRequest(getOtpParams.getCountryCode$app_release(), getOtpParams.getPhoneNumber$app_release(), getOtpParams.getDeviceId$app_release(), getOtpParams.getPostCode$app_release(), getOtpParams.getAge$app_release(), getOtpParams.getName$app_release())).execute();
            if (execute.code() == 200) {
                OTPChallengeResponse body = execute.body();
                if (body != null) {
                    CentralLog.Companion companion = CentralLog.Companion;
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onCodeSent: ");
                    OTPChallengeResponse body2 = execute.body();
                    sb.append(body2 != null ? body2.getChallengeName() : null);
                    companion.d(str, sb.toString());
                    return new Success(body);
                }
                CentralLog.Companion.d(this.TAG, "AWSAuthInvalidBody");
                return new Failure(new GetOnboardingOtpException.GetOtpServiceException(Boxing.boxInt(execute.code())));
            } else if (execute.code() == 400) {
                CentralLog.Companion.d(this.TAG, "AWSAuthInvalidNumber");
                return new Failure(GetOnboardingOtpException.GetOtpInvalidNumberException.INSTANCE);
            } else {
                CentralLog.Companion.d(this.TAG, "AWSAuthServiceError");
                return new Failure(new GetOnboardingOtpException.GetOtpServiceException(Boxing.boxInt(execute.code())));
            }
        } catch (Exception e) {
            CentralLog.Companion.d(this.TAG, "AWSAuthInvalidChallengeRequest", e);
            return new Failure(new GetOnboardingOtpException.GetOtpServiceException((Integer) null, 1, (DefaultConstructorMarker) null));
        }
    }
}
