package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.TracerApp;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.onboarding.fragment.enterpin.EnterPinFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002J*\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\bJ&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\u001a\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010,\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020\u0018J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0006J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0006XD¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016¨\u00063"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "alertDialog", "Landroid/app/AlertDialog;", "callingCode", "", "countryName", "", "destinationId", "Ljava/lang/Integer;", "enterNumberPresenter", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;", "errorTextColor", "nationalFlagResID", "navigationIcon", "getNavigationIcon", "()Ljava/lang/Integer;", "normalTextColor", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "displaySelectedCountryOrRegion", "", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "hideInvalidPhoneNumberPrompt", "navigateToOTPPage", "session", "challengeName", "phoneNumber", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "showCheckInternetError", "showGenericError", "showInvalidPhoneNumberPrompt", "errorMessageResID", "updateButtonState", "updateSelectedCountry", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterNumberFragment.kt */
public final class EnterNumberFragment extends PagerChildFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ENTER_NUMBER_DESTINATION_ID = "destination_id";
    public static final String ENTER_NUMBER_PROGRESS = "progress";
    private HashMap _$_findViewCache;
    private AlertDialog alertDialog;
    /* access modifiers changed from: private */
    public int callingCode;
    private String countryName;
    private Integer destinationId;
    /* access modifiers changed from: private */
    public final EnterNumberPresenter enterNumberPresenter = new EnterNumberPresenter(this);
    private final int errorTextColor = ContextCompat.getColor(TracerApp.Companion.getAppContext(), R.color.error);
    private int nationalFlagResID;
    private final Integer navigationIcon = Integer.valueOf(R.drawable.ic_up);
    /* access modifiers changed from: private */
    public final int normalTextColor = ContextCompat.getColor(TracerApp.Companion.getAppContext(), R.color.slack_black);
    private Integer stepProgress = 2;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$Companion;", "", "()V", "ENTER_NUMBER_DESTINATION_ID", "", "ENTER_NUMBER_PROGRESS", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterNumberFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Integer getNavigationIcon() {
        return this.navigationIcon;
    }

    public Integer getStepProgress() {
        return this.stepProgress;
    }

    public void setStepProgress(Integer num) {
        this.stepProgress = num;
    }

    private final void updateSelectedCountry() {
        Preference preference = Preference.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext, "this.requireContext()");
        String string = getString(preference.getCountryNameResID(requireContext));
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(Preference.get…D(this.requireContext()))");
        this.countryName = string;
        Preference preference2 = Preference.INSTANCE;
        Context requireContext2 = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext2, "this.requireContext()");
        this.callingCode = preference2.getCallingCode(requireContext2);
        Preference preference3 = Preference.INSTANCE;
        Context requireContext3 = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext3, "this.requireContext()");
        this.nationalFlagResID = preference3.getNationalFlagResID(requireContext3);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_enter_number, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.destinationId = Integer.valueOf(arguments.getInt("destination_id"));
            setStepProgress(arguments.containsKey("progress") ? Integer.valueOf(arguments.getInt("progress")) : null);
        }
    }

    public void onResume() {
        super.onResume();
        updateSelectedCountry();
        EditText editText = (EditText) _$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        editText.addTextChangedListener(new EnterNumberFragment$onResume$$inlined$addTextChangedListener$1(this));
        ((EditText) _$_findCachedViewById(R.id.enter_number_phone_number)).setOnEditorActionListener(new EnterNumberFragment$onResume$2(this));
        updateButtonState();
        displaySelectedCountryOrRegion();
    }

    private final void displaySelectedCountryOrRegion() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.country_name_code);
        Intrinsics.checkExpressionValueIsNotNull(textView, "country_name_code");
        StringBuilder sb = new StringBuilder();
        String str = this.countryName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countryName");
        }
        sb.append(str);
        sb.append("(+");
        sb.append(this.callingCode);
        sb.append(')');
        textView.setText(sb.toString());
        ((ImageView) _$_findCachedViewById(R.id.national_flag)).setImageResource(this.nationalFlagResID);
        ((FrameLayout) _$_findCachedViewById(R.id.country_selection_box)).setOnClickListener(new EnterNumberFragment$displaySelectedCountryOrRegion$1(this));
    }

    private final void hideInvalidPhoneNumberPrompt() {
        ((TextView) _$_findCachedViewById(R.id.enter_number_headline)).setTextColor(this.normalTextColor);
        EditText editText = (EditText) _$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        Context context = getContext();
        editText.setBackground(context != null ? context.getDrawable(R.drawable.edittext_modified_states) : null);
        ((EditText) _$_findCachedViewById(R.id.enter_number_phone_number)).setTextColor(this.normalTextColor);
        TextView textView = (TextView) _$_findCachedViewById(R.id.invalid_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(textView, "invalid_phone_number");
        textView.setVisibility(8);
    }

    public final void showInvalidPhoneNumberPrompt(int i) {
        ((TextView) _$_findCachedViewById(R.id.enter_number_headline)).setTextColor(this.errorTextColor);
        EditText editText = (EditText) _$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        Context context = getContext();
        editText.setBackground(context != null ? context.getDrawable(R.drawable.phone_number_invalid_background) : null);
        ((EditText) _$_findCachedViewById(R.id.enter_number_phone_number)).setTextColor(this.errorTextColor);
        TextView textView = (TextView) _$_findCachedViewById(R.id.invalid_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(textView, "invalid_phone_number");
        textView.setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.invalid_phone_number)).setText(i);
    }

    public void updateButtonState() {
        EnterNumberPresenter enterNumberPresenter2 = this.enterNumberPresenter;
        int i = this.callingCode;
        EditText editText = (EditText) _$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        String obj = editText.getText().toString();
        if (obj != null) {
            Pair<Boolean, Integer> validatePhoneNumber = enterNumberPresenter2.validatePhoneNumber(i, StringsKt.trim((CharSequence) obj).toString());
            if (validatePhoneNumber.getFirst().booleanValue()) {
                enableContinueButton();
                hideInvalidPhoneNumberPrompt();
                return;
            }
            disableContinueButton();
            EditText editText2 = (EditText) _$_findCachedViewById(R.id.enter_number_phone_number);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "enter_number_phone_number");
            if (editText2.getText().toString().length() > 0) {
                showInvalidPhoneNumberPrompt(validatePhoneNumber.getSecond().intValue());
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final void showGenericError() {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.alertDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }

    public final void navigateToOTPPage(String str, String str2, int i, String str3) {
        Intrinsics.checkParameterIsNotNull(str3, "phoneNumber");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(EnterPinFragment.ENTER_PIN_SESSION, str), TuplesKt.to(EnterPinFragment.ENTER_PIN_CHALLENGE_NAME, str2), TuplesKt.to(EnterPinFragment.ENTER_PIN_CALLING_CODE, Integer.valueOf(i)), TuplesKt.to(EnterPinFragment.ENTER_PIN_PHONE_NUMBER, str3), TuplesKt.to("destination_id", this.destinationId));
        Integer stepProgress2 = getStepProgress();
        if (stepProgress2 != null) {
            bundleOf.putInt("progress", stepProgress2.intValue() + 1);
        }
        BaseFragment.navigateTo$default(this, R.id.action_enterNumberFragment_to_otpFragment, bundleOf, (Navigator.Extras) null, 4, (Object) null);
    }

    public void onDestroyView() {
        super.onDestroyView();
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        ((ScrollView) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }

    public UploadButtonLayout.ContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.enter_number_button, new EnterNumberFragment$getUploadButtonLayout$1(this));
    }

    public final void showCheckInternetError() {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.alertDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_internet_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }
}
