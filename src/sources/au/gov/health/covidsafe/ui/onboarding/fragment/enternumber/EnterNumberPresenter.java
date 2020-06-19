package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.extensions.NetworkExtensionsKt;
import au.gov.health.covidsafe.factory.NetworkFactory;
import au.gov.health.covidsafe.interactor.usecase.GetOnboardingOtp;
import au.gov.health.covidsafe.interactor.usecase.GetOtpParams;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0003J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "enterNumberFragment", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;", "(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)V", "getOnboardingOtp", "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;", "adjustPrefixForAustralianAndNorfolkPhoneNumber", "", "callingCode", "", "phoneNumber", "makeOTPCall", "", "onCreate", "requestOTP", "validatePhoneNumber", "Lkotlin/Pair;", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterNumberPresenter.kt */
public final class EnterNumberPresenter implements LifecycleObserver {
    /* access modifiers changed from: private */
    public final EnterNumberFragment enterNumberFragment;
    private GetOnboardingOtp getOnboardingOtp;

    public EnterNumberPresenter(EnterNumberFragment enterNumberFragment2) {
        Intrinsics.checkParameterIsNotNull(enterNumberFragment2, "enterNumberFragment");
        this.enterNumberFragment = enterNumberFragment2;
        enterNumberFragment2.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void onCreate() {
        AwsClient awsClient = NetworkFactory.Companion.getAwsClient();
        Lifecycle lifecycle = this.enterNumberFragment.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle, "enterNumberFragment.lifecycle");
        this.getOnboardingOtp = new GetOnboardingOtp(awsClient, lifecycle);
    }

    public final void requestOTP(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "phoneNumber");
        String adjustPrefixForAustralianAndNorfolkPhoneNumber = adjustPrefixForAustralianAndNorfolkPhoneNumber(i, str);
        FragmentActivity activity = this.enterNumberFragment.getActivity();
        if (activity == null || NetworkExtensionsKt.isInternetAvailable(activity)) {
            makeOTPCall(i, adjustPrefixForAustralianAndNorfolkPhoneNumber);
        } else {
            this.enterNumberFragment.showCheckInternetError();
        }
    }

    private final void makeOTPCall(int i, String str) {
        if (this.enterNumberFragment.getActivity() != null) {
            this.enterNumberFragment.disableContinueButton();
            this.enterNumberFragment.showLoading();
            Context requireContext = this.enterNumberFragment.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext, "enterNumberFragment.requireContext()");
            GetOnboardingOtp getOnboardingOtp2 = this.getOnboardingOtp;
            if (getOnboardingOtp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("getOnboardingOtp");
            }
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(i);
            getOnboardingOtp2.invoke(new GetOtpParams(sb.toString(), str, Preference.INSTANCE.getDeviceID(requireContext), Preference.INSTANCE.getPostCode(requireContext), Preference.INSTANCE.getAge(requireContext), Preference.INSTANCE.getName(requireContext)), new EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1(this, i, str), new EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$2(this, i, str));
        }
    }

    public final Pair<Boolean, Integer> validatePhoneNumber(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "phoneNumber");
        boolean z = true;
        int i2 = 0;
        if (i == 61 ? !StringsKt.startsWith$default(str, EnterNumberPresenterKt.AUSTRALIA_MOBILE_NUMBER_PREFIX_DIGIT, false, 2, (Object) null) ? str.length() != 9 : str.length() != 10 : i == 672 && (!StringsKt.startsWith$default(str, EnterNumberPresenterKt.NORFOLK_ISLAND_MOBILE_PREFIX_DIGIT, false, 2, (Object) null) ? str.length() != 5 : str.length() != 6)) {
            z = false;
        }
        if (i == 61) {
            i2 = R.string.invalid_australian_phone_number_error_prompt;
        } else if (i == 672) {
            i2 = R.string.invalid_norfolk_island_phone_number_error_prompt;
        }
        return new Pair<>(Boolean.valueOf(z), Integer.valueOf(i2));
    }

    private final String adjustPrefixForAustralianAndNorfolkPhoneNumber(int i, String str) {
        if (i == 61) {
            return StringsKt.removePrefix(str, (CharSequence) EnterNumberPresenterKt.AUSTRALIA_MOBILE_NUMBER_PREFIX_DIGIT);
        }
        if (i != 672 || str.length() != 5) {
            return str;
        }
        return '3' + str;
    }
}
