package au.gov.health.covidsafe.interactor.usecase;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/UploadDataException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "UploadDataIncorrectPinException", "UploadDataJwtExpiredException", "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;", "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataJwtExpiredException;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: UploadData.kt */
public abstract class UploadDataException extends Exception {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;", "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException;", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: UploadData.kt */
    public static final class UploadDataIncorrectPinException extends UploadDataException {
        public static final UploadDataIncorrectPinException INSTANCE = new UploadDataIncorrectPinException();

        private UploadDataIncorrectPinException() {
            super((DefaultConstructorMarker) null);
        }
    }

    private UploadDataException() {
    }

    public /* synthetic */ UploadDataException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataJwtExpiredException;", "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException;", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: UploadData.kt */
    public static final class UploadDataJwtExpiredException extends UploadDataException {
        public static final UploadDataJwtExpiredException INSTANCE = new UploadDataJwtExpiredException();

        private UploadDataJwtExpiredException() {
            super((DefaultConstructorMarker) null);
        }
    }
}
