package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.TracerApp;
import au.gov.health.covidsafe.factory.NetworkFactory;
import au.gov.health.covidsafe.interactor.usecase.GetOnboardingOtp;
import au.gov.health.covidsafe.interactor.usecase.GetOtpParams;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0003J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "enterNumberFragment", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;", "(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)V", "TAG", "", "getOnboardingOtp", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;", "phoneNumber", "makeOTPCall", "", "onCreate", "requestOTP", "requestOTP$app_release", "validateAuNumber", "", "validateAuNumber$app_release", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterNumberPresenter.kt */
public final class EnterNumberPresenter implements LifecycleObserver {
    private final String TAG;
    /* access modifiers changed from: private */
    public final EnterNumberFragment enterNumberFragment;
    private GetOnboardingOtp getOnboardingOtp;
    private String phoneNumber;

    public EnterNumberPresenter(EnterNumberFragment enterNumberFragment2) {
        Intrinsics.checkParameterIsNotNull(enterNumberFragment2, "enterNumberFragment");
        this.enterNumberFragment = enterNumberFragment2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
        this.enterNumberFragment.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void onCreate() {
        AwsClient awsClient = NetworkFactory.Companion.getAwsClient();
        Lifecycle lifecycle = this.enterNumberFragment.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle, "enterNumberFragment.lifecycle");
        this.getOnboardingOtp = new GetOnboardingOtp(awsClient, lifecycle);
    }

    public final void requestOTP$app_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "phoneNumber");
        if (validateAuNumber$app_release(str)) {
            if (StringsKt.startsWith$default(str, "0", false, 2, (Object) null)) {
                str = StringsKt.takeLast(str, TracerApp.Companion.getAppContext().getResources().getInteger(R.integer.australian_phone_number_length));
            }
            Preference.INSTANCE.putPhoneNumber(TracerApp.Companion.getAppContext(), this.enterNumberFragment.getResources().getString(R.string.enter_number_prefix) + str);
            this.phoneNumber = str;
            makeOTPCall(str);
            return;
        }
        this.enterNumberFragment.showInvalidPhoneNumber();
    }

    private final void makeOTPCall(String str) {
        if (this.enterNumberFragment.getActivity() != null) {
            this.enterNumberFragment.disableContinueButton();
            this.enterNumberFragment.showLoading();
            GetOnboardingOtp getOnboardingOtp2 = this.getOnboardingOtp;
            if (getOnboardingOtp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("getOnboardingOtp");
            }
            String deviceID = Preference.INSTANCE.getDeviceID(this.enterNumberFragment.requireContext());
            Preference preference = Preference.INSTANCE;
            Context requireContext = this.enterNumberFragment.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext, "enterNumberFragment.requireContext()");
            String postCode = preference.getPostCode(requireContext);
            Preference preference2 = Preference.INSTANCE;
            Context requireContext2 = this.enterNumberFragment.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext2, "enterNumberFragment.requireContext()");
            String age = preference2.getAge(requireContext2);
            Preference preference3 = Preference.INSTANCE;
            Context requireContext3 = this.enterNumberFragment.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext3, "enterNumberFragment.requireContext()");
            getOnboardingOtp2.invoke(new GetOtpParams(str, deviceID, postCode, age, preference3.getName(requireContext3)), new EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1(this, str), new EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$2(this, str));
        }
    }

    public final boolean validateAuNumber$app_release(String str) {
        int integer = this.enterNumberFragment.getResources().getInteger(R.integer.australian_phone_number_length);
        if (str != null && StringsKt.startsWith$default(str, "0", false, 2, (Object) null)) {
            integer++;
        }
        if ((str != null ? str.length() : 0) == integer) {
            return true;
        }
        return false;
    }
}
