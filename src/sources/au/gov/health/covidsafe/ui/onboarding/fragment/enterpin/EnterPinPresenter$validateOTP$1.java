package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import androidx.core.app.NotificationCompat;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.networking.response.AuthChallengeResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"au/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1", "Lretrofit2/Callback;", "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterPinPresenter.kt */
public final class EnterPinPresenter$validateOTP$1 implements Callback<AuthChallengeResponse> {
    final /* synthetic */ EnterPinPresenter this$0;

    EnterPinPresenter$validateOTP$1(EnterPinPresenter enterPinPresenter) {
        this.this$0 = enterPinPresenter;
    }

    public void onResponse(Call<AuthChallengeResponse> call, Response<AuthChallengeResponse> response) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.code() == 200) {
            CentralLog.Companion.d(this.this$0.TAG, "code received");
            AuthChallengeResponse body = response.body();
            String str = null;
            String pin = body != null ? body.getPin() : null;
            if (pin != null) {
                Preference.INSTANCE.putHandShakePin(this.this$0.enterPinFragment.getContext(), pin);
            }
            if (body != null) {
                str = body.getToken();
            }
            Preference.INSTANCE.putEncrypterJWTToken(this.this$0.enterPinFragment.requireContext(), str);
            this.this$0.enterPinFragment.hideKeyboard();
            this.this$0.enterPinFragment.navigateToNextPage();
            return;
        }
        this.this$0.onError();
    }

    public void onFailure(Call<AuthChallengeResponse> call, Throwable th) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(th, "t");
        this.this$0.onError();
    }
}
