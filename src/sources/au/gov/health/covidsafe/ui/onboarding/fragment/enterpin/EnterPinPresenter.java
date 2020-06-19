package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.extensions.NetworkExtensionsKt;
import au.gov.health.covidsafe.factory.NetworkFactory;
import au.gov.health.covidsafe.interactor.usecase.GetOnboardingOtp;
import au.gov.health.covidsafe.interactor.usecase.GetOtpParams;
import au.gov.health.covidsafe.networking.request.AuthChallengeRequest;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0003J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\r\u0010\u0013\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "enterPinFragment", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;", "session", "", "challengeName", "callingCode", "", "phoneNumber", "(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "TAG", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "getOtp", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;", "onCreate", "", "onError", "resendCode", "resendCode$app_release", "validateOTP", "otp", "validateOTP$app_release", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterPinPresenter.kt */
public final class EnterPinPresenter implements LifecycleObserver {
    /* access modifiers changed from: private */
    public final String TAG;
    private AwsClient awsClient = NetworkFactory.Companion.getAwsClient();
    private final int callingCode;
    /* access modifiers changed from: private */
    public String challengeName;
    /* access modifiers changed from: private */
    public final EnterPinFragment enterPinFragment;
    private GetOnboardingOtp getOtp;
    private final String phoneNumber;
    /* access modifiers changed from: private */
    public String session;

    public EnterPinPresenter(EnterPinFragment enterPinFragment2, String str, String str2, int i, String str3) {
        Intrinsics.checkParameterIsNotNull(enterPinFragment2, "enterPinFragment");
        this.enterPinFragment = enterPinFragment2;
        this.session = str;
        this.challengeName = str2;
        this.callingCode = i;
        this.phoneNumber = str3;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
        this.enterPinFragment.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void onCreate() {
        AwsClient awsClient2 = this.awsClient;
        Lifecycle lifecycle = this.enterPinFragment.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle, "enterPinFragment.lifecycle");
        this.getOtp = new GetOnboardingOtp(awsClient2, lifecycle);
    }

    public final void resendCode$app_release() {
        FragmentActivity activity = this.enterPinFragment.getActivity();
        if (activity != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            if (!NetworkExtensionsKt.isInternetAvailable(activity)) {
                this.enterPinFragment.showCheckInternetError();
            } else if (this.phoneNumber == null) {
                this.enterPinFragment.showGenericError();
            } else {
                Context requireContext = this.enterPinFragment.requireContext();
                Intrinsics.checkExpressionValueIsNotNull(requireContext, "enterPinFragment.requireContext()");
                GetOnboardingOtp getOnboardingOtp = this.getOtp;
                if (getOnboardingOtp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("getOtp");
                }
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(this.callingCode);
                getOnboardingOtp.invoke(new GetOtpParams(sb.toString(), this.phoneNumber, Preference.INSTANCE.getDeviceID(requireContext), Preference.INSTANCE.getPostCode(requireContext), Preference.INSTANCE.getAge(requireContext), Preference.INSTANCE.getName(requireContext)), new EnterPinPresenter$resendCode$$inlined$let$lambda$1(this), new EnterPinPresenter$resendCode$$inlined$let$lambda$2(this));
            }
        }
    }

    public final void validateOTP$app_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "otp");
        if (TextUtils.isEmpty(str) || str.length() != 6) {
            this.enterPinFragment.showErrorOtpMustBeSixDigits();
            return;
        }
        FragmentActivity activity = this.enterPinFragment.getActivity();
        if (activity == null || NetworkExtensionsKt.isInternetAvailable(activity)) {
            this.enterPinFragment.disableContinueButton();
            this.enterPinFragment.showLoading();
            this.awsClient.respondToAuthChallenge(new AuthChallengeRequest(this.session, str)).enqueue(new EnterPinPresenter$validateOTP$1(this));
            return;
        }
        this.enterPinFragment.showCheckInternetError();
    }

    /* access modifiers changed from: private */
    public final void onError() {
        this.enterPinFragment.enableContinueButton();
        this.enterPinFragment.hideLoading();
        this.enterPinFragment.hideKeyboard();
        this.enterPinFragment.showInvalidOtp();
    }
}
