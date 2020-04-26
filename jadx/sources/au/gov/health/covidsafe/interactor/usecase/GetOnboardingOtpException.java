package au.gov.health.covidsafe.interactor.usecase;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "GetOtpInvalidNumberException", "GetOtpServiceException", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpServiceException;", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GetOnboardingOtp.kt */
public abstract class GetOnboardingOtpException extends Exception {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpServiceException;", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;", "code", "", "(Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GetOnboardingOtp.kt */
    public static final class GetOtpServiceException extends GetOnboardingOtpException {
        private final Integer code;

        public GetOtpServiceException(Integer num) {
            super((DefaultConstructorMarker) null);
            this.code = num;
        }

        public final Integer getCode() {
            return this.code;
        }
    }

    private GetOnboardingOtpException() {
    }

    public /* synthetic */ GetOnboardingOtpException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GetOnboardingOtp.kt */
    public static final class GetOtpInvalidNumberException extends GetOnboardingOtpException {
        public static final GetOtpInvalidNumberException INSTANCE = new GetOtpInvalidNumberException();

        private GetOtpInvalidNumberException() {
            super((DefaultConstructorMarker) null);
        }
    }
}
