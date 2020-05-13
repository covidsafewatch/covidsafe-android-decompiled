package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.extensions.ViewExtensionsKt;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.view.PinInputView;
import com.atlassian.mobilekit.module.core.utils.SystemUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0018J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020\u0018J\u0006\u0010.\u001a\u00020\u0018J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "COUNTDOWN_DURATION", "", "alertDialog", "Landroid/app/AlertDialog;", "destinationId", "", "Ljava/lang/Integer;", "navigationIcon", "getNavigationIcon", "()Ljava/lang/Integer;", "presenter", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "stopWatch", "Landroid/os/CountDownTimer;", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "hideInvalidOtp", "", "hideKeyboard", "isIncorrectPinFormat", "", "navigateToNextPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "resetTimer", "showCheckInternetError", "showErrorOtpMustBeSixDigits", "showGenericError", "showInvalidOtp", "startTimer", "updateButtonState", "validateOtp", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterPinFragment.kt */
public final class EnterPinFragment extends PagerChildFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ENTER_PIN_CHALLENGE_NAME = "challenge_name";
    public static final String ENTER_PIN_DESTINATION_ID = "destination_id";
    public static final String ENTER_PIN_PHONE_NUMBER = "phone_number";
    public static final String ENTER_PIN_PROGRESS = "progress";
    public static final String ENTER_PIN_SESSION = "session";
    private final long COUNTDOWN_DURATION = 300;
    private HashMap _$_findViewCache;
    private AlertDialog alertDialog;
    private Integer destinationId;
    private final int navigationIcon = R.drawable.ic_up;
    /* access modifiers changed from: private */
    public EnterPinPresenter presenter;
    private Integer stepProgress = 3;
    private CountDownTimer stopWatch;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void showErrorOtpMustBeSixDigits() {
    }

    public static final /* synthetic */ EnterPinPresenter access$getPresenter$p(EnterPinFragment enterPinFragment) {
        EnterPinPresenter enterPinPresenter = enterPinFragment.presenter;
        if (enterPinPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return enterPinPresenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$Companion;", "", "()V", "ENTER_PIN_CHALLENGE_NAME", "", "ENTER_PIN_DESTINATION_ID", "ENTER_PIN_PHONE_NUMBER", "ENTER_PIN_PROGRESS", "ENTER_PIN_SESSION", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterPinFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Integer getNavigationIcon() {
        return Integer.valueOf(this.navigationIcon);
    }

    public Integer getStepProgress() {
        return this.stepProgress;
    }

    public void setStepProgress(Integer num) {
        this.stepProgress = num;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_enter_pin, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ENTER_PIN_SESSION);
            String string2 = arguments.getString(ENTER_PIN_CHALLENGE_NAME);
            String string3 = arguments.getString(ENTER_PIN_PHONE_NUMBER);
            this.destinationId = Integer.valueOf(arguments.getInt("destination_id"));
            setStepProgress(arguments.containsKey("progress") ? Integer.valueOf(arguments.getInt("progress")) : null);
            TextView textView = (TextView) _$_findCachedViewById(R.id.enter_pin_headline);
            Intrinsics.checkExpressionValueIsNotNull(textView, "enter_pin_headline");
            textView.setText(getResources().getString(R.string.enter_pin_headline, new Object[]{getResources().getString(R.string.enter_number_prefix), string3}));
            this.presenter = new EnterPinPresenter(this, string, string2, string3);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.enter_pin_wrong_number);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "enter_pin_wrong_number");
        ViewExtensionsKt.toHyperlink$default(textView2, (String) null, new EnterPinFragment$onViewCreated$2(this), 1, (Object) null);
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.enter_pin_resend_pin);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "enter_pin_resend_pin");
        ViewExtensionsKt.toHyperlink$default(textView3, (String) null, new EnterPinFragment$onViewCreated$3(this), 1, (Object) null);
        TextView textView4 = (TextView) view.findViewById(R.id.pin_issue);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "view.pin_issue");
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        startTimer();
    }

    public void onResume() {
        super.onResume();
        updateButtonState();
        ((PinInputView) _$_findCachedViewById(R.id.pin)).setOnPinChanged(new EnterPinFragment$onResume$1(this));
    }

    public void onPause() {
        super.onPause();
        ((PinInputView) _$_findCachedViewById(R.id.pin)).setOnPinChanged((Function0<Unit>) null);
    }

    private final void startTimer() {
        CountDownTimer enterPinFragment$startTimer$1 = new EnterPinFragment$startTimer$1(this, ((long) 1000) * this.COUNTDOWN_DURATION, 1000);
        this.stopWatch = enterPinFragment$startTimer$1;
        if (enterPinFragment$startTimer$1 != null) {
            enterPinFragment$startTimer$1.start();
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.enter_pin_resend_pin);
        Intrinsics.checkExpressionValueIsNotNull(textView, "enter_pin_resend_pin");
        textView.setEnabled(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((TextView) _$_findCachedViewById(R.id.enter_pin_resend_pin)).setLinkTextColor(ContextCompat.getColor(activity, R.color.hyperlink_disabled));
        }
    }

    public final void resetTimer() {
        CountDownTimer countDownTimer = this.stopWatch;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        startTimer();
    }

    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.stopWatch;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        ((TextView) _$_findCachedViewById(R.id.enter_pin_resend_pin)).setOnClickListener((View.OnClickListener) null);
        ((TextView) _$_findCachedViewById(R.id.enter_pin_wrong_number)).setOnClickListener((View.OnClickListener) null);
        ((ScrollView) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }

    public final void hideKeyboard() {
        View currentFocus;
        FragmentActivity activity = getActivity();
        if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            SystemUtils.hideSoftKeyboard(currentFocus);
        }
    }

    public final void showInvalidOtp() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.enter_pin_error_label);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "enter_pin_error_label");
        appCompatTextView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void hideInvalidOtp() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.enter_pin_error_label);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "enter_pin_error_label");
        appCompatTextView.setVisibility(8);
    }

    public final void showGenericError() {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.alertDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }

    private final boolean isIncorrectPinFormat() {
        View requireView = requireView();
        Intrinsics.checkExpressionValueIsNotNull(requireView, "requireView()");
        return ((PinInputView) requireView.findViewById(R.id.pin)).isIncomplete();
    }

    public void updateButtonState() {
        if (isIncorrectPinFormat()) {
            disableContinueButton();
        } else {
            enableContinueButton();
        }
    }

    /* access modifiers changed from: private */
    public final void validateOtp() {
        EnterPinPresenter enterPinPresenter = this.presenter;
        if (enterPinPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View requireView = requireView();
        Intrinsics.checkExpressionValueIsNotNull(requireView, "requireView()");
        enterPinPresenter.validateOTP$app_release(((PinInputView) requireView.findViewById(R.id.pin)).getValue());
    }

    public final void navigateToNextPage() {
        Integer num = this.destinationId;
        BaseFragment.navigateTo$default(this, num != null ? num.intValue() : R.id.action_otpFragment_to_permissionFragment, (Bundle) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public UploadButtonLayout.ContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.enter_pin_button, new EnterPinFragment$getUploadButtonLayout$1(this));
    }

    public final void showCheckInternetError() {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.alertDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_internet_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }
}
