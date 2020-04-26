package au.gov.health.covidsafe.ui.upload.presentation;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import au.gov.health.covidsafe.factory.NetworkFactory;
import au.gov.health.covidsafe.interactor.usecase.GetUploadOtp;
import au.gov.health.covidsafe.interactor.usecase.UploadData;
import au.gov.health.covidsafe.networking.service.AwsClient;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\u0015\u0010\r\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "fragment", "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;", "(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V", "TAG", "", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "getUploadOtp", "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;", "recordStorage", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;", "uploadData", "Lau/gov/health/covidsafe/interactor/usecase/UploadData;", "onCreate", "", "otp", "uploadData$app_release", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinPresenter.kt */
public final class VerifyUploadPinPresenter implements LifecycleObserver {
    private final String TAG;
    private AwsClient awsClient = NetworkFactory.Companion.getAwsClient();
    /* access modifiers changed from: private */
    public final VerifyUploadPinFragment fragment;
    private GetUploadOtp getUploadOtp;
    /* access modifiers changed from: private */
    public StreetPassRecordStorage recordStorage;
    private UploadData uploadData;

    public VerifyUploadPinPresenter(VerifyUploadPinFragment verifyUploadPinFragment) {
        Intrinsics.checkParameterIsNotNull(verifyUploadPinFragment, "fragment");
        this.fragment = verifyUploadPinFragment;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
        this.fragment.getLifecycle().addObserver(this);
        Context context = this.fragment.getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            this.recordStorage = new StreetPassRecordStorage(context);
        }
    }

    public static final /* synthetic */ StreetPassRecordStorage access$getRecordStorage$p(VerifyUploadPinPresenter verifyUploadPinPresenter) {
        StreetPassRecordStorage streetPassRecordStorage = verifyUploadPinPresenter.recordStorage;
        if (streetPassRecordStorage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordStorage");
        }
        return streetPassRecordStorage;
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    private final void onCreate() {
        AwsClient awsClient2 = this.awsClient;
        OkHttpClient okHttpClient = NetworkFactory.Companion.getOkHttpClient();
        Context context = this.fragment.getContext();
        Lifecycle lifecycle = this.fragment.getLifecycle();
        String str = "fragment.lifecycle";
        Intrinsics.checkExpressionValueIsNotNull(lifecycle, str);
        this.uploadData = new UploadData(awsClient2, okHttpClient, context, lifecycle);
        AwsClient awsClient3 = this.awsClient;
        Lifecycle lifecycle2 = this.fragment.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle2, str);
        this.getUploadOtp = new GetUploadOtp(awsClient3, lifecycle2);
    }

    public final void uploadData$app_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "otp");
        this.fragment.disableContinueButton();
        this.fragment.showDialogLoading();
        UploadData uploadData2 = this.uploadData;
        if (uploadData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadData");
        }
        uploadData2.invoke(str, new VerifyUploadPinPresenter$uploadData$1(this), new VerifyUploadPinPresenter$uploadData$2(this));
    }
}
