package au.gov.health.covidsafe.interactor.usecase;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "GetUploadOtpServiceException", "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GetUploadOtp.kt */
public abstract class GetUploadOtpException extends Exception {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;", "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException;", "code", "", "(Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GetUploadOtp.kt */
    public static final class GetUploadOtpServiceException extends GetUploadOtpException {
        private final Integer code;

        public GetUploadOtpServiceException(Integer num) {
            super(null);
            this.code = num;
        }

        public final Integer getCode() {
            return this.code;
        }
    }

    private GetUploadOtpException() {
    }

    public /* synthetic */ GetUploadOtpException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
